package service;

import DAO.DAO;
import entity.Dentist;
import entity.Patient;
import org.apache.log4j.Logger;

import java.sql.SQLException;
import java.util.List;

public class PatientService {
    //Properties
    private DAO<Patient> patientDAO;
    private static final Logger LOGGER = Logger.getLogger(PatientService.class);

    //Getter and Setter
    public DAO<Patient> getPatientDAO() {
        return patientDAO;
    }

    public void setPatientDAO(DAO<Patient> patientDAO) {
        this.patientDAO = patientDAO;
    }

    //Methods

    //Add a new patient
    public Patient addPatient(Patient patient) throws SQLException {
        return patientDAO.add(patient);
    }

    //Delete patient. If the patient exists, it is deleted and returns true. If the patient does not exist, it returns false.
    public boolean deletePatient(Patient patient) throws SQLException {
        int id = patient.getId();
        boolean answer = false;
        if(patientDAO.search(id)!=null){
            patientDAO.delete(id);
            System.out.println("El paciente fue eliminado de la base de datos.");
            LOGGER.info("El paciente fue eliminado de la base de datos.");
            answer = true;
        }else{
            System.out.println("El paciente no existe en la base de datos.");
            LOGGER.info("El paciente no existe en la base de datos.");
        }
        return answer;
    }

    //Update an existing patient. If he doesn't exist returns null.
    public Patient updatePatient(Patient patient) throws SQLException {
        int id = patient.getId();
        if(patientDAO.search(id)!=null){
            System.out.println("El paciente fue actualizado en la base de datos.");
            LOGGER.info("El paciente fue actualizado en la base de datos.");
            return patientDAO.update(patient);
        }else{
            System.out.println("El paciente no existe en la base de datos.");
            LOGGER.info("El paciente no existe en la base de datos.");
            return null;
        }
    }

    //List all patients
    public List<Patient> listPatients() throws SQLException {
        return patientDAO.listAllElements();
    }

}
