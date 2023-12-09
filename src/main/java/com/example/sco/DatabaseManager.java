package com.example.sco;

import java.sql.*;

public class DatabaseManager {
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
    private static final String USERNAME = "om";
    private static final String PASSWORD = "om";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    public static void closeConnection(Connection connection) throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }

    public static void insertUserData(String firstName, String lastName, String phoneNumber, String email, String address, String postalCode)
            throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = getConnection();
            String sql = "INSERT INTO custom (first_name, last_name, phone_number, email, address, postal_code) VALUES (?, ?, ?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, phoneNumber);
            preparedStatement.setString(4, email);
            preparedStatement.setString(5, address);
            preparedStatement.setString(6, postalCode);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Signup successful!");
            } else {
                System.out.println("Signup failed. Please try again.");
            }
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            closeConnection(connection);
        }
    }
    public static boolean isPhoneNumberRegistered(String phoneNumber) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = getConnection();
            String sql = "SELECT COUNT(*) FROM custom WHERE phone_number = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, phoneNumber);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                return count > 0;
            }
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            closeConnection(connection);
        }

        return false;
    }

    public static String getUsername(String userIdentifier) throws SQLException {
        String first_name = null;
        String query = "SELECT first_name FROM custom WHERE email = ? OR phone_number = ?";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, userIdentifier);
            preparedStatement.setString(2, userIdentifier);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    first_name = resultSet.getString("first_name");
                }
            }
        }

        return first_name;
    }
    //did have enough time to work in this but it is not effecting my code in any way
    public static String getPoints(String userIdentifier) throws SQLException {
        String points = null;
        String query = "SELECT points FROM custom WHERE email = ? OR phone_number = ?";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, userIdentifier);
            preparedStatement.setString(2, userIdentifier);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    points = resultSet.getString("points");
                }
            }
        }

        return points;
    }
//did have enough time to work in this but it is not effecting my code in any way
    public static void updatePoints(String userIdentifier, String newPoints) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = getConnection();
            String sql = "UPDATE custom SET points = ? WHERE email = ? OR phone_number = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, newPoints);
            preparedStatement.setString(2, userIdentifier);
            preparedStatement.setString(3, userIdentifier);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Points updated successfully!");
            } else {
                System.out.println("Failed to update points. Please try again.");
            }
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }



    public static class Product {
        private String productName;
        private double productPrice;

        public Product(String productName, double productPrice) {
            this.productName = productName;
            this.productPrice = productPrice;
        }

        public String getProductName() {
            return productName;
        }

        public double getProductPrice() {
            return productPrice;
        }
    }


         Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

    public Product getProductByCode(String itemCode) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = getConnection();
            String sql = "SELECT product_name, product_price FROM products WHERE item_code = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, itemCode);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String productName = resultSet.getString("product_name");
                double productPrice = resultSet.getDouble("product_price");
                return new Product(productName, productPrice);
            } else {
                System.out.println("Product not found for item code: " + itemCode);
                return null; // Product not found
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Log the exception for debugging
            throw e; // Re-throw the exception to indicate failure
        } finally {
            closeConnection(connection, preparedStatement, resultSet);
        }
    }



    // Add this method to your DatabaseManager class for closing resources
    public static void closeConnection(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Log the exception for debugging
        }
    }

}
