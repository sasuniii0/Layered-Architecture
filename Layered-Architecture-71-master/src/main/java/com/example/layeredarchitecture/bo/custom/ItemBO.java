package com.example.layeredarchitecture.bo.custom;

import com.example.layeredarchitecture.model.ItemDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ItemBO {
    public ArrayList<ItemDTO> getAll() throws SQLException, ClassNotFoundException;
    public void delete(String id) throws SQLException, ClassNotFoundException;
    public void save(ItemDTO itemDTO) throws SQLException, ClassNotFoundException;
    public void update(ItemDTO itemDTO) throws SQLException, ClassNotFoundException;
    public boolean exist(String id) throws SQLException, ClassNotFoundException;
    public String generateNewId() throws SQLException, ClassNotFoundException;
    public ItemDTO search(String id) throws SQLException, ClassNotFoundException;
}
