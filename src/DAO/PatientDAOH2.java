package DAO;
import entity.Patient;
import org.apache.log4j.Logger;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PatientDAOH2 implements DAO<Patient> {


    //Properties to create connection to DBH2
    private static final String DB_JDBC_Driver = "org.h2.Driver";
    private static final String DB_URL = "jdbc:h2:~/dentalCareCenter;";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    private static final Logger LOGGER = Logger.getLogger(Patient.class);


    @Override
    public Patient add(Patient patient) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            Class.forName(DB_JDBC_Driver);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            preparedStatement = connection.prepareStatement("INSERT INTO patients VALUES (?, ?, ?, ?, ?, ?)");
            preparedStatement.setInt(1, patient.getId());
            preparedStatement.setInt(2, patient.getIdCard());
            preparedStatement.setString(3, patient.getLastname());
            preparedStatement.setString(4, patient.getName());
            preparedStatement.setString(5, patient.getAddress());
            preparedStatement.setDate(6, Date.valueOf(patient.getRegistrationDate()));

            connection.setAutoCommit(false);
            preparedStatement.executeUpdate();
            LOGGER.info("El paciente fue creado.");
            preparedStatement.close();
            connection.commit();
            connection.setAutoCommit(true);

        } catch (ClassNotFoundException e) {
            LOGGER.error("Error al agregar paciente a la base de datos.");
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            connection.close();
        }

        return patient;
    }

    @Override

    public Patient search(int id) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Patient patient = null;

        try {
            Class.forName(DB_JDBC_Driver);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            preparedStatement = connection.prepareStatement("SELECT * FROM patients where id=?");
            preparedStatement.setInt(1, id);
            ResultSet result = preparedStatement.executeQuery();

            while(result.next()){
                int patientId = result.getInt("id");
                int patientIdCard = result.getInt("idCard");
                String patientLastName = result.getString("lastName");
                String patientName = result.getString("name");
                String patientAddress = result.getString("address");
                String patientRegistrationDate = String.valueOf(result.getDate("registrationDate"));
                patient = new Patient();
                patient.setId(patientId);
                patient.setIdCard(patientIdCard);
                patient.setLastname(patientLastName);
                patient.setName(patientName);
                patient.setAddress(patientAddress);
                patient.setRegistrationDate(LocalDate.parse(patientRegistrationDate));

            }
            preparedStatement.close();

        } catch (ClassNotFoundException e) {
            LOGGER.error("Error, paciente no fue encontrado en la base de datos.");
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            connection.close();
        }
        return patient;
    }

    @Override
    public boolean update(Patient patient) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            Class.forName(DB_JDBC_Driver);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            preparedStatement = connection.prepareStatement("UPDATE patients SET idCard=?, lastName=?, name=?, address=?, registrationDate=?  WHERE id = ?");
            preparedStatement.setInt(1, patient.getIdCard());
            preparedStatement.setString(2, patient.getLastname());
            preparedStatement.setString(3, patient.getName());
            preparedStatement.setString(4, patient.getAddress());
            preparedStatement.setDate(5, Date.valueOf(patient.getRegistrationDate()));
            preparedStatement.setInt(6, patient.getId());

            connection.setAutoCommit(false);
            int response = preparedStatement.executeUpdate();
            if(response==1){
                LOGGER.info("El paciente fue encontrado en la base de datos y esta actualizado.");
                connection.commit();
                connection.setAutoCommit(true);
                return true;
            }else if (response>1) {
                LOGGER.info("Cuidado, hay mas de un paciente con el mismo Id.");
                connection.commit();
                connection.setAutoCommit(true);
                return false;
            }else if (response==0){
                LOGGER.info("El paciente fue encontrado en la base de datos y esta actualizado.");
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
            preparedStatement = connection.prepareStatement("DELETE FROM patients where id=?");
            preparedStatement.setInt(1, id);

            connection.setAutoCommit(false);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            LOGGER.info("El paciente fue eliminado de la base de datos.");
            connection.commit();
            connection.setAutoCommit(true);

        } catch (ClassNotFoundException e) {
            LOGGER.error("Error, el paciente no fue encontrado en la base de datos.");
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            connection.close();
        }
    }

    @Override
    public List<Patient> listAllElements() throws SQLException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        List<Patient> patients = new ArrayList<>();

        try {
            Class.forName(DB_JDBC_Driver);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            preparedStatement = connection.prepareStatement("SELECT * FROM patients");

            ResultSet result = preparedStatement.executeQuery();

            while(result.next()){
                int patientId = result.getInt("id");
                int patientIdCard = result.getInt("idCard");
                String patientLastName = result.getString("lastName");
                String patientName = result.getString("name");
                String patientAddress = result.getString("address");
                String patientRegistrationDate = String.valueOf(result.getDate("registrationDate"));
                Patient patient = new Patient();
                patient.setId(patientId);
                patient.setIdCard(patientIdCard);
                patient.setLastname(patientLastName);
                patient.setName(patientName);
                patient.setAddress(patientAddress);
                patient.setRegistrationDate(LocalDate.parse(patientRegistrationDate));

                patients.add(patient);
            }

            preparedStatement.close();

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            connection.close();

        }
        return patients;
    }
}
