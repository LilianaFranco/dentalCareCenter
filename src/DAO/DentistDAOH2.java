package DAO;

import entity.Dentist;
import entity.Patient;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DentistDAOH2 implements DAO<Dentist>{


    //Properties to create connection to DBH2
    private static final String DB_JDBC_Driver = "org.h2.Driver";
    private static final String DB_URL = "jdbc:h2:~/dentalCareCenter";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    private static final Logger LOGGER = Logger.getLogger(Dentist.class);


    @Override
    public Dentist add(Dentist dentist) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            Class.forName(DB_JDBC_Driver);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            preparedStatement = connection.prepareStatement("INSERT INTO dentists VALUES (?, ?, ?, ?)");
            preparedStatement.setInt(1, dentist.getId());
            preparedStatement.setInt(2, dentist.getDentalLicense());
            preparedStatement.setString(3, dentist.getLastName());
            preparedStatement.setString(4, dentist.getName());

            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (ClassNotFoundException e) {
            LOGGER.error("Error al agregar Odontologo a la base de datos");
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return dentist;
    }

    @Override
    public Dentist search(int id) throws SQLException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Dentist dentist = null;

        try {
            Class.forName(DB_JDBC_Driver);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            preparedStatement = connection.prepareStatement("SELECT * FROM dentist where id=?");
            preparedStatement.setInt(1, dentist.getId());
            ResultSet result = preparedStatement.executeQuery();

            while(result.next()){
                int dentistId = result.getInt("id");
                int dentistLicense = result.getInt("dentalLicense");
                String dentistLastName = result.getString("lastName");
                String dentistName = result.getString("name");
                dentist = new Dentist();
                dentist.setId(dentistId);
                dentist.setDentalLicense(dentistLicense);
                dentist.setLastName(dentistLastName);
                dentist.setName(dentistName);
            }
            preparedStatement.close();
            LOGGER.error("El Odontologo fue encontrado en la base de datos.");

        } catch (ClassNotFoundException e) {
            LOGGER.error("Error, Odontologo no encontrado en la base de datos");
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return dentist;
    }

    @Override
    public Dentist update(Dentist type) {


        return null;
    }

    @Override
    public void delete(int id) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            Class.forName(DB_JDBC_Driver);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            preparedStatement = connection.prepareStatement("DELETE FROM dentists where id=?");
            preparedStatement.setInt(1, id);

            preparedStatement.executeQuery();
            preparedStatement.close();

        } catch (ClassNotFoundException e) {
            LOGGER.error("Error al agregar Odontologo a la base de datos");
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Dentist> listAllElements() throws SQLException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        List<Dentist> dentists = new ArrayList<>();

        try {
            Class.forName(DB_JDBC_Driver);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            preparedStatement = connection.prepareStatement("SELECT * FROM dentist");

            ResultSet result = preparedStatement.executeQuery();

            while(result.next()){
                int dentistId = result.getInt("id");
                int dentistLicense = result.getInt("dentalLicense");
                String dentistLastName = result.getString("lastName");
                String dentistName = result.getString("name");

                Dentist dentist = new Dentist();
                dentist.setId(dentistId);
                dentist.setDentalLicense(dentistLicense);
                dentist.setLastName(dentistLastName);
                dentist.setName(dentistName);

                dentists.add(dentist);
            }

            preparedStatement.executeUpdate();
            LOGGER.error("El Odontologo fue creado en la base de datos.");
            preparedStatement.close();

        } catch (ClassNotFoundException e) {
            LOGGER.error("Error al agregar Odontologo a bbase de datos");
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return dentists;
    }
}
