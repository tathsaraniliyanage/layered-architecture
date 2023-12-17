package com.example.layeredarchitecture.DAO;

import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.*;
import java.util.ArrayList;

/**
 * @author Praboda Thathsarani
 * @Project layered-architecture
 * @Date 16/12/2023
 */
public interface CustomerDAO {
    public ArrayList<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException ;

    public boolean saveCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException ;

    public Boolean updateCustomer (CustomerDTO dto) throws SQLException, ClassNotFoundException;


    public Boolean existCustomer(String id) throws SQLException, ClassNotFoundException;

    public boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException;

    public String genarateId() throws SQLException, ClassNotFoundException;

    public CustomerDTO searchCustomer(String id) throws SQLException, ClassNotFoundException;

}
