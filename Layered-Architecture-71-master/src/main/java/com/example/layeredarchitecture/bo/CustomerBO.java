package com.example.layeredarchitecture.bo;

import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerBO {
    public ArrayList<CustomerDTO> getAll() throws SQLException, ClassNotFoundException;
    public void save(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException ;
    public void update(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException ;
    public boolean exist(String id) throws SQLException, ClassNotFoundException;
    public void delete(String id) throws SQLException, ClassNotFoundException;
    public String generateNewId() throws SQLException, ClassNotFoundException;
    public CustomerDTO search(String newValue) throws SQLException, ClassNotFoundException;
}
