package com.example.layeredarchitecture.DAO;

import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.ItemDTO;

import java.sql.*;
import java.util.ArrayList;

/**
 * @author Praboda Thathsarani
 * @Project layered-architecture
 * @Date 16/12/2023
 */
public interface ItemDAO {
    public ArrayList<ItemDTO> getAllITem() throws SQLException, ClassNotFoundException ;

    public boolean saveItem(ItemDTO dto) throws SQLException, ClassNotFoundException ;

    public Boolean updateItem(ItemDTO dto) throws SQLException, ClassNotFoundException ;

    public boolean deleteItem(String code) throws SQLException, ClassNotFoundException ;

    public boolean exsistItem(String code) throws SQLException, ClassNotFoundException ;

    public String generateNewId() throws SQLException, ClassNotFoundException ;

    public ItemDTO findItem(String  code) throws SQLException, ClassNotFoundException;


}
