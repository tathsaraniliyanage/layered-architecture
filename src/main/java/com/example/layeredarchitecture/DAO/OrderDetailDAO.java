package com.example.layeredarchitecture.DAO;

import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.SQLException;

/**
 * @author Praboda Thathsarani
 * @Project layered-architecture
 */
public interface OrderDetailDAO {
    public boolean saveOrderDetail(OrderDetailDTO dto) throws SQLException, ClassNotFoundException;

}
