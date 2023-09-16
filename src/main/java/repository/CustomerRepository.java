package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static connectionDB.ConnectionDB.connect;
public class CustomerRepository {
    private Connection conn = connect();
    private PreparedStatement pstm;

    public boolean registerNewCustomer(String name, String email, String cpf, String address) {
        try {
            String SQL = "INSERT INTO customer (name,email,cpf,address) VALUES (?,?,?,?) ";
            pstm = conn.prepareStatement(SQL);
            pstm.setString(1, name);
            pstm.setString(2, email);
            pstm.setString(3, cpf);
            pstm.setString(4, address);
            pstm.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean deleteCustomer(int idCustomer){
        try {
            String SQL = "DELETE FROM customer WHERE id = ?";
            pstm = conn.prepareStatement(SQL);
            pstm.setInt(1,idCustomer);
            pstm.executeUpdate();
            return true;
        }catch (SQLException error){
            error.printStackTrace();
        }
        return false;
    }
    public boolean updateEmailCustomer(int idCustomer, String email){
        try {
            String sql = "UPDATE customer SET email = ? WHERE id = ?";
            pstm = conn.prepareStatement(sql);
            pstm.setString(1,email);
            pstm.setInt(2,idCustomer);
            pstm.executeUpdate();
            return true;
        }catch (SQLException error){
            error.printStackTrace();
        }
        return false;
    }
    public boolean updateAddressCustomer(int idCustomer, String address){
        try {
            String sql = "UPDATE customer SET address = ? WHERE id = ?";
            pstm = conn.prepareStatement(sql);
            pstm.setString(1,address);
            pstm.setInt(2,idCustomer);
            pstm.executeUpdate();
            return true;
        }catch (SQLException error){
            error.printStackTrace();
        }
        return false;
    }
    public ResultSet showAllCustomers(){
        try {
            String sql = "SELECT * FROM customer ";
            pstm = conn.prepareStatement(sql);
            ResultSet resultSet = pstm.executeQuery();
            return resultSet;
        }catch (SQLException error){
            error.printStackTrace();
        }
        return null;
    }
    public ResultSet showCustomerById(int idCustomer){
        try {
            String sql = "SELECT * FROM customer WHERE id = ? ";
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1,idCustomer);
            ResultSet resultSet = pstm.executeQuery();
            return resultSet;
        }catch (SQLException error){
            error.printStackTrace();
        }
        return null;
    }
}
