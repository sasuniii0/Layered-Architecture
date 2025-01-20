package com.example.layeredarchitecture.bo.custom;

import com.example.layeredarchitecture.model.CustomerDTO;
import com.example.layeredarchitecture.model.ItemDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface PlaceOrderBO {
    public CustomerDTO searchCustomer(String id) throws SQLException, ClassNotFoundException;
    public boolean existItem(String code) throws SQLException, ClassNotFoundException ;
    public boolean existCustomer(String id) throws SQLException, ClassNotFoundException;
    public String generateNewOrderId() throws SQLException, ClassNotFoundException;
    public ArrayList<CustomerDTO> getAllCustomerIds() throws SQLException, ClassNotFoundException;
    public ArrayList<ItemDTO> getAllItemIds() throws SQLException, ClassNotFoundException;
}
