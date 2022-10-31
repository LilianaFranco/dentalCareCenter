package DAO;

import java.util.List;

public interface DAO<T> {

    public T add(T type); // Create an object, so it adds a row in table
    public T search(Long id); //Find element in table, so it returns the row found
    public T update(T type); //Update an existing object, so it updated a row
    public void delete(Long id); //Delete row in table, so it deletes the object
    public List<T> listAllElements(); //Return the complete table

}
