package com.example.layeredarchitecture.dao.custom.impl;

import com.example.layeredarchitecture.dao.custom.ItemDAO;
import com.example.layeredarchitecture.dao.SQLUtil;
import com.example.layeredarchitecture.model.ItemDTO;

import java.sql.*;
import java.util.ArrayList;

public class ItemDAOImpl implements ItemDAO {
    @Override
    public ArrayList<ItemDTO> getAll() throws SQLException, ClassNotFoundException {
            ResultSet rst = SQLUtil.execute("SELECT * FROM Item");
            ArrayList<ItemDTO> items = new ArrayList<>();

            while(rst.next()){
                ItemDTO itemDTO = new ItemDTO();
                itemDTO.getCode();
                itemDTO.getDescription();
                itemDTO.getUnitPrice();
                itemDTO.getQtyOnHand();

                items.add(itemDTO);
            }
            return items;
    }

    @Override
    public void delete(String id) throws SQLException, ClassNotFoundException {
            SQLUtil.execute("DELETE FROM Item WHERE code=?", id);
    }

    @Override
    public void save(ItemDTO itemDTO) throws SQLException, ClassNotFoundException {
            SQLUtil.execute("INSERT INTO Item (code, description, unitPrice, qtyOnHand) VALUES (?,?,?,?)", itemDTO.getCode(), itemDTO.getDescription(), itemDTO.getUnitPrice(), itemDTO.getQtyOnHand());
    }

    @Override
    public void update(ItemDTO itemDTO) throws SQLException, ClassNotFoundException {
           SQLUtil.execute("UPDATE Item SET description=?, unitPrice=?, qtyOnHand=? WHERE code=?", itemDTO.getDescription(), itemDTO.getUnitPrice(), itemDTO.getQtyOnHand(), itemDTO.getCode());
    }

    @Override
    public boolean exist(String id) throws SQLException, ClassNotFoundException {
            ResultSet rst = SQLUtil.execute("SELECT code FROM Item WHERE code=?", id);
            return rst.next();
    }

    @Override
    public String generateNewId() throws SQLException, ClassNotFoundException {
            ResultSet rst = SQLUtil.execute("SELECT code FROM Item ORDER BY code DESC LIMIT 1");
            if (rst.next()) {
                String id = rst.getString("code");
                int newItemId = Integer.parseInt(id.replace("I00-", "")) + 1;
                return String.format("I00-%03d", newItemId);
            } else {
                return "I00-001";
        }
    }

    @Override
    public ItemDTO search(String id) throws SQLException, ClassNotFoundException {
            ResultSet rst = SQLUtil.execute("SELECT * FROM Item WHERE code=?", id);
            rst.next();
            return new ItemDTO(id, rst.getString("description"), rst.getBigDecimal("unitPrice"), rst.getInt("qtyOnHand"));
    }
}
