package DAO;
import entity.Dentist;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DentistDAOH2 implements DAO<Dentist>{


    //Properties to create connection to DBH2
    private static final String DB_JDBC_Driver = "org.h2.Driver";
    private static final String DB_URL = "jdbc:h2:~/dentalCareCenter;INIT=RUNSCRIPT FROM 'create.sql'";
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

            connection.setAutoCommit(false);
            preparedStatement.executeUpdate();
            LOGGER.info("El odontologo ha sido creado.");
            preparedStatement.close();
            connection.commit();
            connection.setAutoCommit(true);

        } catch (ClassNotFoundException e) {
            LOGGER.error("Error al agregar Odontologo a la base de datos.");
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            connection.close();
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
            preparedStatement = connection.prepareStatement("SELECT * FROM dentists where id=?");
            preparedStatement.setInt(1, id);
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

        } catch (ClassNotFoundException e) {
            LOGGER.error("Error, Odontologo no fue encontrado en la base de datos");
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            connection.close();
        }
        return dentist;
    }

    @Override
    public boolean update(Dentist dentist) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            Class.forName(DB_JDBC_Driver);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            preparedStatement = connection.prepareStatement("UPDATE dentists SET dentalLicense=?, lastName = ?, name =? WHERE id = ?");
            preparedStatement.setInt(1, dentist.getDentalLicense());
            preparedStatement.setString(2, dentist.getLastName());
            preparedStatement.setString(3, dentist.getName());
            preparedStatement.setInt(4, dentist.getId());

            connection.setAutoCommit(false);
            int response = preparedStatement.executeUpdate();
            if(response==1){
                LOGGER.info("El Odontologo fue encontrado en la base de datos y esta actualizado.");
                connection.commit();
                connection.setAutoCommit(true);
                return true;
            }else if (response>1) {
                LOGGER.info("Cuidado, hay mas de un odontologo con el mismo Id.");
                connection.commit();
                connection.setAutoCommit(true);
                return false;
            }else if (response==0){
                LOGGER.info("El Odontologo fue encontrado en la base de datos y esta actualizado.");
                connection.commit();
                connection.setAutoCommit(true);
                return false;
            }

        } catch (ClassNotFoundException e) {
            LOGGER.error("Error");
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            preparedStatement.close();
            connection.close();
        }
        return false;
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

            connection.setAutoCommit(false);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.setAutoCommit(true);

            LOGGER.info("El odontologo fue eliminado de la base de datos.");

        } catch (ClassNotFoundException e) {
            LOGGER.error("Error, el odontologo no fue encontrado en la base de datos.");
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            connection.close();
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
            preparedStatement = connection.prepareStatement("SELECT * FROM dentists");

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

            preparedStatement.close();

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            connection.close();

        }
        return dentists;
    }
}