package repository;

import connectionDB.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class ManagerRepository {
    private Connection conn = ConnectionDB.connect();
    private PreparedStatement pstm;

    public boolean registerManager(String name, String email, String password){
        try {
            String SQL = "INSERT INTO manager (name,email,password) VALUES (?,?,?) ";
            pstm = conn.prepareStatement(SQL);
            pstm.setString(1, name);
            pstm.setString(2, email);
            pstm.setString(3, password);
            pstm.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean deleteManager(int idManager){
        try {
            String SQL = "DELETE FROM manager WHERE id = ?";
            pstm = conn.prepareStatement(SQL);
            pstm.setInt(1,idManager);
            pstm.executeUpdate();
            return true;
        }catch (SQLException error){
            error.printStackTrace();
        }
        return false;
    }
    public boolean updateManagerEmail(int idManager,String email){
        try {
            String sql = "UPDATE manager SET email = ? WHERE id = ?";
            pstm = conn.prepareStatement(sql);
            pstm.setString(1,email);
            pstm.setInt(2,idManager);
            pstm.executeUpdate();
            return true;
        }catch (SQLException error){
            error.printStackTrace();
        }
        return false;
    }
    public boolean updatePasswordManager(int idManager,String password){
        try {
            String sql = "UPDATE manager SET password = ? WHERE id = ?";
            pstm = conn.prepareStatement(sql);
            pstm.setString(1,password);
            pstm.setInt(2,idManager);
            pstm.executeUpdate();
            return true;
        }catch (SQLException error){
            error.printStackTrace();
        }
        return false;
    }
    public ResultSet showAllManagers(){
        try {
            String sql = "SELECT * FROM manager ";
            pstm = conn.prepareStatement(sql);
            ResultSet resultSet = pstm.executeQuery();
            return resultSet;
        }catch (SQLException error){
            error.printStackTrace();
        }
        return null;
    }
    public ResultSet showManagerById(int idManager){
        try {
            String sql = "SELECT * FROM manager WHERE id = ? ";
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1,idManager);
            ResultSet resultSet = pstm.executeQuery();
            return resultSet;
        }catch (SQLException error){
            error.printStackTrace();
        }
        return null;
    }
    public boolean validateLoginManager(String email,String password){
        try {
            String sql = "SELECT COUNT(*) FROM manager WHERE email = ? AND password = ? ";
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
    public void showCustomerOrSellersWithBusinessEmail(){
        try {
            String SQL = "SELECT seller.name, seller.email " +
                    "FROM seller WHERE seller.email LIKE '%zup.com.br' " +
                    "UNION SELECT customer.name, customer.email " +
                    "FROM customer WHERE customer.email LIKE '%zup.com.br'";

            pstm = conn.prepareStatement(SQL);
            ResultSet rset = pstm.executeQuery();
            while (rset.next()) {
                System.out.println("\t|Pessoa:   " + rset.getString("name") + "|");
                System.out.println("\t|Email:   " + rset.getString("email") + "|");
                System.out.println();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public ResultSet  ShowSalespeopleSalary() {
        try {
            String SQL = "SELECT seller.name,seller.wage " +
                    "FROM seller " +
                    "ORDER BY seller.wage DESC ";

            pstm = conn.prepareStatement(SQL);
            ResultSet resultSet = pstm.executeQuery();
            return resultSet;
        } catch (SQLException error) {
            error.printStackTrace();
        }
        return null;
    }

}



