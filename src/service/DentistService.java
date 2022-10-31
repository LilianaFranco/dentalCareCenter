package service;

import DAO.DAO;
import entity.Dentist;

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
    public Dentist addDentist(Dentist dentist){
        return dentistDAO.add(dentist);
    }

    //Delete dentist. If the dentist exists, it is deleted and returns true. If the dentist does not exist, it returns false.
    public boolean deleteDentist(Dentist dentist){
        Long id = dentist.getId();
        boolean answer = false;
        if(dentistDAO.search(id)!=null){
            dentistDAO.delete(id);
            System.out.println("El odontologo fue eliminado.");
            answer = true;
        }else{
            System.out.println("El odontologo no existe.");
        }
        return answer;
    }

    //Update an existing dentist. If he doesn't exist returns null.
    public Dentist updateDentist(Dentist dentist){
        Long id = dentist.getId();
        if(dentistDAO.search(id)!=null){
            System.out.println("El odontologo fue actualizado");
            return dentistDAO.update(dentist);
        }else{
            System.out.println("El odontologo no existe");
            System.out.println();
            return null;
        }
    }

    //List all dentist
    public List<Dentist> listDentists(){
        return dentistDAO.listAllElements();
    }


}
