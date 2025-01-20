package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.ItemDTO;

import java.sql.*;
import java.util.ArrayList;

public interface ItemDAO {
     public ArrayList<ItemDTO> loadAllItems() throws SQLException, ClassNotFoundException;
     public void deleteItem(String id) throws SQLException, ClassNotFoundException;
     public void saveItem(ItemDTO itemDTO) throws SQLException, ClassNotFoundException;
     public void updateItem(ItemDTO itemDTO) throws SQLException, ClassNotFoundException;
     public boolean existItem(String id) throws SQLException, ClassNotFoundException;
     public String generateNewId() throws SQLException, ClassNotFoundException;
     public ItemDTO findItem(String id) throws SQLException, ClassNotFoundException;
}
