package com.example.layeredarchitecture.DAO;

import com.example.layeredarchitecture.model.OrderDTO;

import java.sql.SQLException;

/**
 * @author Praboda Thathsarani
 * @Project layered-architecture
 */
public interface OrderDAO {
    public String generateOID() throws SQLException, ClassNotFoundException;
    public boolean existOrder(String orderId) throws SQLException, ClassNotFoundException;
    public boolean saveOrder(OrderDTO dto) throws SQLException, ClassNotFoundException;

}
