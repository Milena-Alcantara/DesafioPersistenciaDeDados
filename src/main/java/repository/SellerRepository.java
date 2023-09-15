package repository;

import connectionDB.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SellerRepository {
    private Connection conn = ConnectionDB.connect();
    private PreparedStatement pstm;

    public boolean registerNewSeller(String name, String email,String password ,String cpf, Double wage){
        try {
            String SQL = "INSERT INTO seller (name,email,password,cpf,wage) VALUES (?,?,?,?,?) ";
            pstm = conn.prepareStatement(SQL);
            pstm.setString(1, name);
            pstm.setString(2, email);
            pstm.setString(3, password);
            pstm.setString(4, cpf);
            pstm.setDouble(5,wage);
            pstm.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }
    public boolean deleteSeller(int idSeller){
        try {
            String SQL = "DELETE FROM seller WHERE id = ?";
            pstm = conn.prepareStatement(SQL);
            pstm.setInt(1,idSeller);
            pstm.executeUpdate();
            return true;
        }catch (SQLException error){
            error.printStackTrace();
        }
        return false;
    }
    public boolean updateSellerEmail(int idSeller,String email){
        try {
            String sql = "UPDATE seller SET email = ? WHERE id = ?";
            pstm = conn.prepareStatement(sql);
            pstm.setString(1,email);
            pstm.setInt(2,idSeller);
            pstm.executeUpdate();
            return true;
        }catch (SQLException error){
            error.printStackTrace();
        }
        return false;
    }
    public boolean updateSellerPassword(int idSeller,String password){
        try {
            String sql = "UPDATE seller SET password = ? WHERE id = ?";
            pstm = conn.prepareStatement(sql);
            pstm.setString(1,password);
            pstm.setInt(2,idSeller);
            pstm.executeUpdate();
            return true;
        }catch (SQLException error){
            error.printStackTrace();
        }
        return false;
    }
    public ResultSet showAllSellers(){
        try {
            String sql = "SELECT * FROM seller ";
            pstm = conn.prepareStatement(sql);
            ResultSet resultSet = pstm.executeQuery();
            return resultSet;
        }catch (SQLException error){
            error.printStackTrace();
        }
        return null;
    }
    public ResultSet showSellerById(int idSeller){
        try {
            String sql = "SELECT * FROM seller WHERE id = ? ";
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1,idSeller);
            ResultSet resultSet = pstm.executeQuery();
            return resultSet;
        }catch (SQLException error){
            error.printStackTrace();
        }
        return null;
    }
    public boolean validateLoginSeller(String email,String password){
        try {
            String sql = "SELECT COUNT(*) FROM seller WHERE email = ? AND password = ? ";
            pstm = conn.prepareStatement(sql);
            pstm.setString(1,email);
            pstm.setString(2,password);
            ResultSet resultSet = pstm.executeQuery();

            if (resultSet.next()){
                int count = resultSet.getInt(1);
                return count > 0;
            }
        }catch (SQLException error) {
            error.printStackTrace();
        }
        return false;
    }

    }


