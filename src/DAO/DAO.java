package DAO;

import java.sql.SQLException;
import java.util.List;

public interface DAO<T> {


    //Methods
    public T add(T type) throws SQLException; // Create an object, so it adds a row in table
    public T search(int id) throws SQLException; //Find element in table, so it returns the row found
    public T update(T type); //Update an existing object, so it updated a row
    public void delete(int id) throws SQLException; //Delete row in table, so it deletes the object
    public List<T> listAllElements() throws SQLException; //Return the complete table

}
