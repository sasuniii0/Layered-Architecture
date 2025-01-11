package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.*;
import java.util.ArrayList;

public class CustomerDAOImpl implements CustomerDAO {

    private CustomerDTO customerDTO;
    @Override
    public ArrayList<CustomerDTO> getAllCustomers() throws SQLException, ClassNotFoundException {
            ResultSet rst = SQLUtil.execute("SELECT * FROM Customer");
            ArrayList<CustomerDTO> customers = new ArrayList<>();
            while (rst.next()) {
                CustomerDTO customerDTO = new CustomerDTO();
                customerDTO.setId(rst.getString(1));
                customerDTO.setName(rst.getString(2));
                customerDTO.setAddress(rst.getString(3));
                customers.add(customerDTO);
            }
            return customers;
        }

    @Override
    public void saveCustomer(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException {
            ResultSet rst = SQLUtil.execute("INSERT INTO Customer (id,name, address) VALUES (?,?,?)", customerDTO.getId(),customerDTO.getName(),customerDTO.getAddress());
    }

    @Override
    public void updateCustomer(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException {
            ResultSet rst = SQLUtil.execute("UPDATE Customer SET name=?, address=? WHERE id=?", customerDTO.getName(), customerDTO.getAddress(), customerDTO.getId());
    }

    @Override
    public boolean existCustomer(String id) throws SQLException, ClassNotFoundException {
            ResultSet rst = SQLUtil.execute("SELECT id FROM Customer WHERE id=?", id);
            return rst.next();
    }

    @Override
    public void deleteCustomer(String id) throws SQLException, ClassNotFoundException {
            SQLUtil.execute("DELETE FROM Customer WHERE id=?", id);
    }

    @Override
    public String generateNewId() throws SQLException, ClassNotFoundException {
            ResultSet rst = SQLUtil.execute("SELECT id FROM Customer ORDER BY id DESC LIMIT 1");
            if (rst.next()) {
                String id = rst.getString("id");
                int newCustomerId = Integer.parseInt(id.replace("C00-", "")) + 1;
                return String.format("C00-%03d", newCustomerId);
            } else {
                return "C00-001";
        }
    }

    @Override
    public CustomerDTO searchCustomer(String newValue) throws SQLException, ClassNotFoundException {
            ResultSet rst = SQLUtil.execute("SELECT * FROM Customer WHERE id=?", newValue);
            rst.next();
            return new CustomerDTO(newValue + "", rst.getString("name"), rst.getString("address"));
    }
}
