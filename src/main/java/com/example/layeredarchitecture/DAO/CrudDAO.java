package com.example.layeredarchitecture.DAO;

import com.example.layeredarchitecture.DAO.custom.QueryDAO;
import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author Praboda Thathsarani
 * @Project layered-architecture
 * @Date 18/12/2023
 */
public interface CrudDAO<T> {
    public ArrayList<T> getAll() throws SQLException, ClassNotFoundException ;

    public boolean save(T dto) throws SQLException, ClassNotFoundException ;

    public Boolean update(T dto) throws SQLException, ClassNotFoundException;


    public boolean exsist(String id) throws SQLException, ClassNotFoundException;

    public boolean delete(String id) throws SQLException, ClassNotFoundException;

    public String generateId() throws SQLException, ClassNotFoundException;

    public T search(String id) throws SQLException, ClassNotFoundException;

    /**
     * @author Praboda Thathsarani
     * @Project layered-architecture
     * @Date 18/12/2023
     */
    class QueryDAOImpl implements QueryDAO {

        @Override
        public void customerOrderDetails(CustomerDTO customerDTO) {
            //join queries
        }
    }
}
