package com.example.layeredarchitecture.bo;

import com.example.layeredarchitecture.dao.custom.impl.ItemDAOImpl;
import com.example.layeredarchitecture.model.ItemDTO;

import java.sql.SQLException;

public class PlaceOrderBOImpl {
    public ItemDTO search(String code) {
        try {
            /*Connection connection = DBConnection.getDbConnection().getConnection();
            PreparedStatement pstm = connection.prepareStatement("SELECT * FROM Item WHERE code=?");
            pstm.setString(1, code);
            ResultSet rst = pstm.executeQuery();
            rst.next();
            return new ItemDTO(code, rst.getString("description"), rst.getBigDecimal("unitPrice"), rst.getInt("qtyOnHand"));
      */
            ItemDAOImpl itemDAO = new ItemDAOImpl();
            return itemDAO.search(code);
        } catch (SQLException e) {
            throw new RuntimeException("Failed to find the Item " + code, e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
