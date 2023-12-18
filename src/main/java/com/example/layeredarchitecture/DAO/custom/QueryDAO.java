package com.example.layeredarchitecture.DAO.custom;

import com.example.layeredarchitecture.model.CustomerDTO;

/**
 * @author Praboda Thathsarani
 * @Project layered-architecture
 * @Date 18/12/2023
 */
public interface QueryDAO {
  void customerOrderDetails(CustomerDTO customerDTO);
}
