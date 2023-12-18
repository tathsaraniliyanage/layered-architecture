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
public class CustomerDAOImpl implements CustomerDAO {
    @Override
  public ArrayList<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException {
      Connection connection = DBConnection.getDbConnection().getConnection();
      Statement stm = connection.createStatement();
   //   ResultSet rst = stm.executeQuery("SELECT * FROM Customer");
        ResultSet rst = SQLUtil.execute("SELECT * FROM Customer");
      ArrayList<CustomerDTO> allCustomer =new ArrayList<>();

      while(rst.next()){
          CustomerDTO customerDTO=new CustomerDTO(
                  rst.getString("id"),
                  rst.getString("name"),
                  rst.getString("address")
          );
         allCustomer.add(customerDTO);
      }
      return allCustomer;
  }

@Override
  public boolean saveCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException {
    /*  Connection connection = DBConnection.getDbConnection().getConnection();
      PreparedStatement pstm = connection.prepareStatement("INSERT INTO Customer (id,name, address) VALUES (?,?,?)");
      pstm.setString(1, dto.getId());
      pstm.setString(2, dto.getName());
      pstm.setString(3, dto.getAddress());
    return  pstm.executeUpdate()>0;*/
    return  SQLUtil.execute("INSERT INTO Customer (id,name, address) VALUES (?,?,?)",dto.getId(),dto.getName(),dto.getAddress());
  }

  @Override
public Boolean updateCustomer (CustomerDTO dto) throws SQLException, ClassNotFoundException {
   /* Connection connection = DBConnection.getDbConnection().getConnection();
    PreparedStatement pstm = connection.prepareStatement("UPDATE Customer SET name=?, address=? WHERE id=?");
    pstm.setString(1, dto.getId());
    pstm.setString(2, dto.getName());
    pstm.setString(3, dto.getAddress());
    return  pstm.executeUpdate()>0;*/
 return SQLUtil.execute("UPDATE Customer SET name=?, address=? WHERE id=?",dto.getName(),dto.getAddress(),dto.getId());
}

@Override
public Boolean existCustomer(String id) throws SQLException, ClassNotFoundException {
   /* Connection connection = DBConnection.getDbConnection().getConnection();
    PreparedStatement pstm = connection.prepareStatement("SELECT id FROM Customer WHERE id=?");
    pstm.setString(1,id );
    return pstm.executeQuery().next() ;*/
    return SQLUtil.execute("SELECT id FROM Customer WHERE id=?",id);
}

@Override
public boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException {
 /*   Connection connection = DBConnection.getDbConnection().getConnection();
    PreparedStatement pstm = connection.prepareStatement("DELETE FROM Customer WHERE id=?");
    pstm.setString(1, id);
   return  pstm.executeUpdate() >0;*/
    return SQLUtil.execute("DELETE FROM Customer WHERE id=?",id);
}

    @Override
    public String genarateId() throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
     //   ResultSet rst = connection.createStatement().executeQuery("SELECT id FROM Customer ORDER BY id DESC LIMIT 1;");
        ResultSet rst = SQLUtil.execute("SELECT id FROM Customer ORDER BY id DESC LIMIT 1;");
        if (rst.next()) {
            String id = rst.getString("id");
            int newCustomerId = Integer.parseInt(id.replace("C00-", "")) + 1;
            return String.format("C00-%03d", newCustomerId);
        } else {
            return "C00-001";
        }
    }


    @Override
    public CustomerDTO searchCustomer(String id) throws SQLException, ClassNotFoundException {
     /*   Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement("SELECT * FROM Customer WHERE id=?");
        pstm.setString(1, id + "");
        ResultSet rst = pstm.executeQuery();
        rst.next();
        return new CustomerDTO(id + "", rst.getString("name"), rst.getString("address"));*/

        return  SQLUtil.execute("SELECT * FROM Customer WHERE id=?",id);
    }



}

