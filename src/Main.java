import DAO.DentistDAOH2;
import entity.Dentist;
import entity.Patient;
import org.apache.log4j.Logger;
import service.DentistService;

import java.sql.SQLException;

public class Main {

    private static final Logger LOGGER = Logger.getLogger(Main.class);

    public static void main(String[] args) throws SQLException {

        Dentist dentist =  new Dentist(123, 9874, "Osorio", "Manuel");
        DentistService dentistService =  new DentistService();
        dentistService.setDentistDAO(new DentistDAOH2());

        Dentist dentist2 =  new Dentist(123, 9874, "Osorio", "Manuel Aberto");
        dentistService.addDentist(dentist);
        dentistService.updateDentist(dentist2);
        System.out.println(dentistService.listDentists());


    }
}