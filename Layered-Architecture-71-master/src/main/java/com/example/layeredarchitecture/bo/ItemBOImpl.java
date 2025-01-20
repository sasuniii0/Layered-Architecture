package com.example.layeredarchitecture.bo;

import com.example.layeredarchitecture.dao.custom.ItemDAO;
import com.example.layeredarchitecture.dao.custom.impl.ItemDAOImpl;
import com.example.layeredarchitecture.model.ItemDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class ItemBOImpl implements ItemBO {
    ItemDAO itemDAO = new ItemDAOImpl();
    public ArrayList<ItemDTO> getAll() throws SQLException, ClassNotFoundException {
        return itemDAO.getAll();
    }
    public void delete(String id) throws SQLException, ClassNotFoundException {
        itemDAO.delete(id);
    }
    public void save(ItemDTO itemDTO) throws SQLException, ClassNotFoundException {
        itemDAO.save(itemDTO);
    }
    public void update(ItemDTO itemDTO) throws SQLException, ClassNotFoundException {
        itemDAO.update(itemDTO);
    }
    public boolean exist(String id) throws SQLException, ClassNotFoundException {
        return itemDAO.exist(id);
    }
    public String generateNewId() throws SQLException, ClassNotFoundException {
        return itemDAO.generateNewId();
    }
    public ItemDTO search(String id) throws SQLException, ClassNotFoundException {
        return itemDAO.search(id);
    }
}
