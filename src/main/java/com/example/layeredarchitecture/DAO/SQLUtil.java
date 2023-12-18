package com.example.layeredarchitecture.DAO;

import com.example.layeredarchitecture.db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author Praboda Thathsarani
 * @Project layered-architecture
 * @Date 18/12/2023
 */
public class SQLUtil {
    public static <T> T execute(String sql,Object...args) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);
       /* pstm.setString(1, dto.getId());
        pstm.setString(2, dto.getName());
        pstm.setString(3, dto.getAddress());*/

        for(int i=0; i< args.length  ;i++){
            pstm.setObject((i+1),args[i]);
        }

        if(sql.startsWith("SELECT")){
            // (T) - T ekakata cast kara ganima thmi meken dakwanne
          return (T)  pstm.executeQuery();
        }else {
           return (T) (Boolean) (pstm.executeUpdate()>0);
        }
    }
}
