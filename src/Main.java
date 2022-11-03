import DAO.DentistDAOH2;
import DAO.PatientDAOH2;
import entity.Dentist;
import entity.Patient;
import org.apache.log4j.Logger;
import service.DentistService;
import service.PatientService;

import java.sql.SQLException;
import java.time.LocalDate;

public class Main {

    private static final Logger LOGGER = Logger.getLogger(Main.class);

    public static void main(String[] args) throws SQLException {

        //Caso odontologo
        Dentist dentist1 =  new Dentist(123, 9874, "Stark", "Sansa");
        Dentist dentist2 = new Dentist(55689, 962, "Stark", "Robb");
        Dentist dentist3 =  new Dentist(123, 9874, "Stark", "Arya");
        Dentist dentist4 = new Dentist(963985, 8532, "Stark", "Bran");
        Dentist dentist5 = new Dentist(965856, 8532, "Stark", "Rickon");

        DentistService dentistService =  new DentistService();
        dentistService.setDentistDAO(new DentistDAOH2());

        dentistService.addDentist(dentist1);
        dentistService.addDentist(dentist2);
        dentistService.addDentist(dentist4);
        dentistService.addDentist(dentist5);

        System.out.println(dentistService.listDentists());

        dentistService.updateDentist(dentist3);
        dentistService.deleteDentist(dentist2);
        System.out.println(dentistService.listDentists());


        //Caso paciente

        Patient patient1 = new Patient(123, 456, "Lannister", "Cersei", "Kings Landing", LocalDate.now());
        Patient patient2 = new Patient(678, 987, "Lannister", "Jaime", "Kings Landing", LocalDate.now());
        Patient patient3 = new Patient(654, 321, "Baratheon", "Joffrey", "Kings Landing", LocalDate.now());
        Patient patient4 = new Patient(369, 321, "Lannister", "Tyrion", "Kings Landing", LocalDate.now());
        Patient patient5 = new Patient(654, 987, "Lannister", "Joffrey", "Kings Landing", LocalDate.now());
        Patient patient6 = new Patient(652, 965, "Lannister", "Tywin", "Kings Landing", LocalDate.now());

        PatientService patientService = new PatientService();
        patientService.setPatientDAO(new PatientDAOH2());

        patientService.addPatient(patient1);
        patientService.addPatient(patient2);
        patientService.addPatient(patient3);
        patientService.addPatient(patient4);
        patientService.addPatient(patient6);
        System.out.println(patientService.listPatients());

        patientService.updatePatient(patient5);
        patientService.deletePatient(patient6);
        System.out.println(patientService.listPatients());

    }

}