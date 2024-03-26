package com.coderhouse.controlador;

import com.coderhouse.entidades.Cliente;
import com.coderhouse.entidades.Producto;

import java.sql.*;

public class JavaDataBaseController {
    private static final String DATA_BASE = "coderhouse";
    private static final String URL = "jdbc:mysql://localhost:3306/" + DATA_BASE;
    private static final String USER = "root";
    private static final String PASSWORD = "2013facu";

    private Connection connection;

    public Connection getConnection() {
        if(connection == null) {
            try {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("Conexion exitosa a la base de datos: " + DATA_BASE);
            } catch (SQLException e) {
                //throw new RuntimeException(e);
                System.err.println("Error al establecer la conexion" + e.getMessage());
            }

        }
        return connection;
    }

    public void closeConnection () {
        if(connection != null){
            try {
                connection.close();
                System.out.println("Se ha cerrado la conexion");
            } catch (SQLException e) {
                //throw new RuntimeException(e);
                System.err.println("Error al cerrar la conexion" + e.getMessage());
            }
        }
    }

    public void mostrarClientes (){
        Statement statement = null;
        ResultSet resultSet = null;
        String query = "SELECT dni, name, surname, clientAddress, clientPhone, clientEmail FROM clients";
        try{
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);

            while (resultSet.next()){
                Integer dni = resultSet.getInt("dni");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String clientAddress = resultSet.getString("clientAddress");
                Integer clientPhone = resultSet.getInt("clientPhone");
                String clientEmail = resultSet.getString("clientEmail");

                System.out.println("Cliente con DNI Nro. " + dni + "es " + name + " " + surname
                        + ", vive en " + clientAddress + ", su telefono es " + clientPhone + " y su email " + clientEmail  );
            }

        } catch (SQLException e) {
            //throw new RuntimeException(e);
            System.err.println(e.getMessage());
        } finally {
            try {
                if(resultSet != null){
                    resultSet.close();
                }
                if(statement != null){
                    statement.close();
                }
            } catch (SQLException e){
                System.err.println("Error al cerrar el statement o resultSet: " + e.getMessage());
            }
        }
    }

    public void mostrarCliente(Integer dni) throws SQLException {
        Statement statement = null;
        ResultSet resultSet = null;
        String query = "SELECT * FROM clients WHERE dni = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, dni);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String clientAddress = resultSet.getString("clientAddress");
                Integer clientPhone = resultSet.getInt("clientPhone");
                String clientEmail = resultSet.getString("clientEmail");

                System.out.println("Cliente con DNI Nro. " + dni + " es " + name + " " + surname
                        + ", vive en " + clientAddress + ", su telefono es " + clientPhone + " y su email " + clientEmail);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                System.err.println("Error al cerrar el statement o resultSet: " + e.getMessage());
            }
        }
    }
    public void insertarCliente (Cliente cliente){
        PreparedStatement statement = null;
        String query = "INSERT INTO clients (dni, name, surname, clientAddress, clientPhone, clientEmail) VALUES (?, ?, ?, ?, ?, ?)";
        try{
            statement = connection.prepareStatement(query);
            statement.setInt(1, cliente.getDni());
            statement.setString(2, cliente.getName());
            statement.setString(3, cliente.getSurname());
            statement.setString(4, cliente.getClientAddress());
            statement.setInt(5, cliente.getClientPhone());
            statement.setString(6, cliente.getClientEmail());

            int rowsAffected = statement.executeUpdate();

            if(rowsAffected == 0){
                throw new SQLException(
                        "No se pudo insertar al cliente: " + cliente.getName() + cliente.getSurname()
                );
            }
            System.out.println("Cliente con DNI Nro. " + cliente.getDni() + " con nombre " + cliente.getName() + " " + cliente.getSurname()
                    + " fue insertado correctamente.");
        } catch (SQLException e) {
            //throw new RuntimeException(e);
            System.err.println(e.getMessage());
        } finally {
            try {
                if(statement != null){
                    statement.close();
                }
            } catch (SQLException e){
                System.err.println("Error al cerrar el statement o resultSet: " + e.getMessage());
            }
        }
    }

    public void modificarCliente (Integer dni, Integer nuevoClientPhone, String nuevoClientAddress, String nuevoClientEmail) {
        PreparedStatement statement = null;
        try {
            String query = "UPDATE clients SET clientPhone = ?, clientAddress = ?, clientEmail = ? WHERE dni = ?";
            statement = connection.prepareStatement(query);

            statement.setInt(1, nuevoClientPhone);
            statement.setString(2, nuevoClientAddress);
            statement.setString(3, nuevoClientEmail);
            statement.setInt(4, dni);

            int rowsAffected = statement.executeUpdate();

            if(rowsAffected == 0){
                throw new SQLException(
                        "No se pudo modificar al cliente con DNI: " + dni
                );
            }
            System.out.println("Cliente con DNI Nro. " + dni + " fue modificado correctamente.");


        } catch (SQLException e) {
            //throw new RuntimeException(e);
            System.err.println(e.getMessage());
        } finally {
            try {
                if(statement != null){
                    statement.close();
                }
            } catch (SQLException e){
                System.err.println("Error al cerrar el statement o resultSet: " + e.getMessage());
            }
        }
    }

    public void eliminarCliente (Integer dni) {
        PreparedStatement statement = null;
        try {
            String query = "DELETE FROM clients WHERE dni = ?";
            statement = connection.prepareStatement(query);

            statement.setInt(1, dni);

            int rowsAffected = statement.executeUpdate();

            if(rowsAffected == 0){
                throw new SQLException(
                        "No se eliminar al cliente con DNI: " + dni
                );
            }
            System.out.println("Cliente con DNI Nro. " + dni
                    + " fue eliminado correctamente.");


        } catch (SQLException e) {
            //throw new RuntimeException(e);
            System.err.println(e.getMessage());
        } finally {
            try {
                if(statement != null){
                    statement.close();
                }
            } catch (SQLException e){
                System.err.println("Error al cerrar el statement o resultSet: " + e.getMessage());
            }
        }
    }

    public void insertarProducto (Producto product){
        PreparedStatement statement = null;
        String query = "INSERT INTO products (title, description, stock, price) VALUES (?, ?, ?, ?, ?)"; //SKU autogenerated
        try{
            statement = connection.prepareStatement(query);
            //statement.setInt(1, product.getSKU());
            statement.setString(1, product.getTitle());
            statement.setString(2, product.getDescription());
            statement.setInt(3, product.getStock());
            statement.setInt(4, product.getPrice());

            int rowsAffected = statement.executeUpdate();

            if(rowsAffected == 0){
                throw new SQLException(
                        "No se pudo insertar al producto: " + product.getSKU() + product.getTitle()
                );
            }
            System.out.println("Producto con SKU Nro. " + product.getSKU() + " con nombre " + product.getTitle()
                    + " fue insertado correctamente.");
        } catch (SQLException e) {
            //throw new RuntimeException(e);
            System.err.println(e.getMessage());
        } finally {
            try {
                if(statement != null){
                    statement.close();
                }
            } catch (SQLException e){
                System.err.println("Error al cerrar el statement o resultSet: " + e.getMessage());
            }
        }
    }

}
