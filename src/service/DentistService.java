package service;

import DAO.DAO;
import entity.Dentist;
import org.apache.log4j.Logger;

import java.sql.SQLException;
import java.util.List;

public class DentistService{

    //Properties
    private DAO<Dentist> dentistDAO;
    private static final Logger LOGGER = Logger.getLogger(DentistService.class);

    //Getter and Setter
    public DAO<Dentist> getDentistDAO() {
        return dentistDAO;
    }

    public void setDentistDAO(DAO<Dentist> dentistDAO) {
        this.dentistDAO = dentistDAO;
    }

    //Methods

    //Add a new dentist
    public Dentist addDentist(Dentist dentist) throws SQLException {

        return dentistDAO.add(dentist);
    }

    //Delete dentist. If the dentist exists, it is deleted and returns true. If the dentist does not exist, it returns false.
    public boolean deleteDentist(Dentist dentist) throws SQLException {
        int id = dentist.getId();
        boolean answer = false;
        if(dentistDAO.search(id)!=null){
            dentistDAO.delete(id);
            System.out.println("El odontologo fue eliminado de la base de datos.");
            LOGGER.info("El odontologo fue eliminado de la base de datos.");
            answer = true;
        }else{
            System.out.println("El odontologo no existe en la base de datos.");
            LOGGER.info("El odontologo no existe en la base de datos.");
        }
        return answer;
    }

    //Update an existing dentist. If he doesn't exist returns null.
    public Dentist updateDentist(Dentist dentist) throws SQLException {
        int id = dentist.getId();
        if(dentistDAO.search(id)!=null){
            System.out.println("El odontologo fue actualizado en la base de datos.");
            LOGGER.info("El odontologo fue actualizado en la base de datos.");
            return dentistDAO.update(dentist);
        }else{
            System.out.println("El odontologo no existe en la base de datos.");
            LOGGER.info("El odontologo no existe en la base de datos.");
            return null;
        }
    }

    //List all dentist
    public List<Dentist> listDentists() throws SQLException {
        return dentistDAO.listAllElements();
    }


}
