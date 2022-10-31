package service;

import DAO.DAO;
import entity.Dentist;
import entity.Patient;

import java.util.List;

public class PatientService {
    //Properties
    private DAO<Patient> patientDAO;

    //Getter and Setter
    public DAO<Patient> getPatientDAO() {
        return patientDAO;
    }

    public void setPatientDAO(DAO<Patient> patientDAO) {
        this.patientDAO = patientDAO;
    }

    //Methods

    //Add a new patient
    public Patient addPatient(Patient patient){
        return patientDAO.add(patient);
    }

    //Delete patient. If the patient exists, it is deleted and returns true. If the patient does not exist, it returns false.
    public boolean deletePatient(Patient patient){
        Long id = patient.getId();
        boolean answer = false;
        if(patientDAO.search(id)!=null){
            patientDAO.delete(id);
            System.out.println("El paciente fue eliminado.");
            answer = true;
        }else{
            System.out.println("El paciente no existe.");
        }
        return answer;
    }

    //Update an existing patient. If he doesn't exist returns null.
    public Patient updatePatient(Patient patient){
        Long id = patient.getId();
        if(patientDAO.search(id)!=null){
            System.out.println("El paciente fue actualizado");
            return patientDAO.update(patient);
        }else{
            System.out.println("El paciente no existe");
            System.out.println();
            return null;
        }
    }

    //List all patients
    public List<Patient> listPatients(){
        return patientDAO.listAllElements();
    }

}
