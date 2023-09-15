package repository;

import connectionDB.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductRepository {
    private Connection conn = ConnectionDB.connect();
    private PreparedStatement pstm;
    public boolean registerNewProduct(String name, Double price){
        try{
            String SQL = "INSERT INTO product (name,price) " +
                    "VALUES (?,?) ";
            pstm = conn.prepareStatement(SQL);
            pstm.setString(1, name);
            pstm.setDouble(2, price);
            pstm.executeUpdate();
            return true;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
    public boolean deleteProduct(int idProduct){
        try{
            String SQL = "DELETE FROM product WHERE id= ? ";
            pstm = conn.prepareStatement(SQL);
            pstm.setInt(1, idProduct);
            pstm.executeUpdate();
            return true;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateProductPrice(int idProduct,Double price){
        try {
            String sql = "UPDATE product SET price = ? WHERE id = ?";
            pstm = conn.prepareStatement(sql);
            pstm.setDouble(1,price);
            pstm.setInt(2,idProduct);
            pstm.executeUpdate();
            return true;
        }catch (SQLException error){
            error.printStackTrace();
        }
        return false;
    }
    public ResultSet showAllProducts(){
        try {
            String sql = "SELECT * FROM product ";
            pstm = conn.prepareStatement(sql);
            ResultSet resultSet = pstm.executeQuery();
            return resultSet;
        }catch (SQLException error){
            error.printStackTrace();
        }
        return null;
    }
    public ResultSet showProductById(int idProduct){
        try {
            String sql = "SELECT * FROM product WHERE id = ? ";
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1,idProduct);
            ResultSet resultSet = pstm.executeQuery();
            return resultSet;
        }catch (SQLException error){
            error.printStackTrace();
        }
        return null;
    }
    }


