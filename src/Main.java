import DAO.DentistDAOH2;
import entity.Dentist;
import entity.Patient;
import org.apache.log4j.Logger;
import service.DentistService;

import java.sql.SQLException;

public class Main {

    private static final Logger LOGGER = Logger.getLogger(Main.class);

    public static void main(String[] args) throws SQLException {

        //Caso odontologo
        Dentist dentist =  new Dentist(186, 9874, "Jaramillo", "Ana");
        Dentist dentist2 =  new Dentist(186, 9875, "Jaramillo", "Ana Maria");
        Dentist dentist3 = new Dentist(55689, 962, "Guzman", "Daniela");
        Dentist dentist4 = new Dentist(963985, 8532, "Betancur", "Claudia");
        Dentist dentist5 = new Dentist(965856, 8532, "Franco", "Victoria");

        DentistService dentistService =  new DentistService();
        dentistService.setDentistDAO(new DentistDAOH2());

        dentistService.addDentist(dentist);
        dentistService.addDentist(dentist3);
        dentistService.addDentist(dentist4);
        dentistService.addDentist(dentist5);

        System.out.println(dentistService.listDentists());

        dentistService.updateDentist(dentist3);
        dentistService.deleteDentist(dentist2);
        System.out.println(dentistService.listDentists());


        //Caso paciente


    }
}