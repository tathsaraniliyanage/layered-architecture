package com.example.layeredarchitecture.DAO;

import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.SQLException;

import java.sql.Connection;
import java.sql.PreparedStatement;
/**
 * @author Praboda Thathsarani
 * @Project layered-architecture
 */
public class OrderDetailDAOImpl implements OrderDetailDAO {

    @Override
    public boolean saveOrderDetail(OrderDetailDTO dto) throws SQLException,ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement stm = connection.prepareStatement("INSERT INTO OrderDetails (oid, itemCode, unitPrice, qty) VALUES (?,?,?,?)");
      //  stm.setString(1, dto.getOid());
        stm.setString(2, dto.getItemCode());
        stm.setBigDecimal(3, dto.getUnitPrice());
        stm.setInt(4, dto.getQty());
        return stm.executeUpdate()>0;
    }
}
