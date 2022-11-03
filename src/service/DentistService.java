package service;
import DAO.DAO;
import entity.Dentist;
import java.sql.SQLException;
import java.util.List;

public class DentistService{

    //Properties
    private DAO<Dentist> dentistDAO;

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
            answer = true;
        }
        return answer;
    }

    //Update an existing dentist. If he doesn't exist returns null.
    public Dentist updateDentist(Dentist dentist) throws SQLException {
        int id = dentist.getId();
        if(dentistDAO.update(dentist)){
            return dentistDAO.search(id);
        }else{
            return null;
        }
    }

    //List all dentist
    public List<Dentist> listDentists() throws SQLException {
        return dentistDAO.listAllElements();
    }


}
