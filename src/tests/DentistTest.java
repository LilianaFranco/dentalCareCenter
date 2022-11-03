package tests;
import DAO.DentistDAOH2;
import entity.Dentist;
import org.junit.jupiter.api.Test;
import service.DentistService;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class DentistTest {

    @Test
    public void setDentalLicense() throws SQLException {
        //Given
        Dentist dentist1 =  new Dentist(985, 9874, "Stark", "Sansa");
        Dentist dentist2 =  new Dentist(985, 9874, "Stark", "Arya");
        DentistService dentistService =  new DentistService();
        dentistService.setDentistDAO(new DentistDAOH2());
        dentistService.addDentist(dentist1);
        dentistService.updateDentist(dentist2);

        //When
        String realName = "Arya";

        //Then
        assertEquals(realName,dentist1.getName());

    }

}


