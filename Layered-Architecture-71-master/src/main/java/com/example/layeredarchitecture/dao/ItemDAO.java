package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.ItemDTO;

import java.sql.*;
import java.util.ArrayList;

public interface ItemDAO {
     ArrayList<ItemDTO> loadAllItems() throws SQLException, ClassNotFoundException;
     void deleteItem(String id) throws SQLException, ClassNotFoundException;
     void saveItem(ItemDTO itemDTO) throws SQLException, ClassNotFoundException;
     void updateItem(ItemDTO itemDTO) throws SQLException, ClassNotFoundException;
     boolean existItem(String id) throws SQLException, ClassNotFoundException;
     String generateNewId() throws SQLException, ClassNotFoundException;
     ItemDTO findItem(String id) throws SQLException, ClassNotFoundException;
}
