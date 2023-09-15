package repository;
import connectionDB.ConnectionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SalesRepository {
    private Connection conn = ConnectionDB.connect();
    private PreparedStatement pstm;

    public boolean getTotalValuesGreaterThan10(){
        try {
            String SQL = "SELECT product.name, sales.total_value " +
                    "FROM product,sales " +
                    "WHERE product.id = sales.id_product " +
                    "AND sales.total_value>10.00 ";

            pstm = conn.prepareStatement(SQL);
            ResultSet resultSet = pstm.executeQuery();
            System.out.println("Vendas cujo valor total são maiores que R$ 10.00");
            while (resultSet.next()){
                System.out.println("\t|Produto:   " + resultSet.getString("name") + "|");
                System.out.println("\t|Total:       " + resultSet.getDouble("total_value") + "|");
            }
            return true;

        }catch (SQLException error){
            error.printStackTrace();
        }
        return false;
    }
    public boolean changeTheTotalValueSalesThatAreNull(){
        try {
            String SQL = "UPDATE sales " +
                    "SET total_value = 0 " +
                    "WHERE total_value IS NULL ";
            pstm = conn.prepareStatement(SQL);
            pstm.executeUpdate();
            return true;
        }catch (SQLException error){
            error.printStackTrace();
        }
        return false;
    }
    public boolean registerNewSale(int id_Seller,int id_Customer,int id_Product,int amount, Double total){
        try{
            String SQL = "INSERT INTO sales (id_seller,id_customer,id_product,amount_product,total_value) " +
                    "VALUES (?,?,?,?,?) ";
            pstm = conn.prepareStatement(SQL);
            pstm.setInt(1, id_Seller);
            pstm.setInt(2, id_Customer);
            pstm.setInt(3, id_Product);
            pstm.setInt(4, amount);
            pstm.setDouble(5, total);
            pstm.executeUpdate();
            return true;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
    public boolean deleteSale(int idSale){
        try {
            String SQL = "DELETE FROM sales WHERE id = ?";
            pstm = conn.prepareStatement(SQL);
            pstm.setInt(1,idSale);
            pstm.executeUpdate();
            return true;
        }catch (SQLException error){
            error.printStackTrace();
        }
        return false;
    }
    public ResultSet showAllSales(){
        try {
            String sql = "SELECT * FROM sales ";
            pstm = conn.prepareStatement(sql);
            ResultSet resultSet = pstm.executeQuery();
            return resultSet;
        }catch (SQLException error){
            error.printStackTrace();
        }
        return null;
    }
    public ResultSet showAllSaleById(int idSale){
        try {
            String sql = "SELECT * FROM sales WHERE id = ? ";
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1,idSale);
            ResultSet resultSet = pstm.executeQuery();
            return resultSet;
        }catch (SQLException error){
            error.printStackTrace();
        }
        return null;
    }

}
