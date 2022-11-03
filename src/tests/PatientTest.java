package tests;
import DAO.PatientDAOH2;
import entity.Patient;
import org.junit.jupiter.api.Test;
import service.PatientService;

import java.sql.SQLException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PatientTest {

    @Test
    public void updatePatient() throws SQLException {
        //Given
        Patient patient1 = new Patient(122, 122, "Baratheon", "Joffrey", "Kings Landing", LocalDate.now());
        Patient patient2 = new Patient(122, 122, "Lannister", "Joffrey", "Kings Landing", LocalDate.now());

        PatientService patientService =  new PatientService();
        patientService.setPatientDAO(new PatientDAOH2());

        //When
        patientService.addPatient(patient1);
        Patient updatedPatient = patientService.updatePatient(patient2);
        String realLastName = "Lannister";

        //Then
        assertEquals(realLastName,updatedPatient.getLastname());

    }

}
