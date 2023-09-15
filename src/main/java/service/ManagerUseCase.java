package service;

import controller.*;

import java.sql.ResultSet;
public class ManagerUseCase {
    ManagerController managerController = new ManagerController();
    SellerController sellerController = new SellerController();
    SalesController salesController = new SalesController();
    ProductController productController= new ProductController();
    CustomerController customerController = new CustomerController();

    public boolean registerManager(String name, String email, String password){
        return managerController.registerManager(name, email, password);
    }
    public boolean validateLoginManager(String email,String password){
        return managerController.validateLoginManager(email,password);
    }
    public boolean deleteManager(int idManager){
        return managerController.deleteManager(idManager);
    }
    public boolean updateManagerEmail(int idManager,String email){
        return managerController.updateManagerEmail(idManager, email);
    }
    public boolean updatePasswordManager(int idManager,String password){
        return managerController.updatePasswordManager(idManager, password);
    }
    public ResultSet showAllManagers(){
        return managerController.showAllManagers();
    }
    public ResultSet showManagerById(int idManager){
        return managerController.showManagerById(idManager);
    }
    public void showCustomerOrSellersWithBusinessEmail(){
         managerController.showCustomerOrSellersWithBusinessEmail();
    }
    public ResultSet showSalespeopleSalary(){
        return managerController.showSalespeopleSalary();
    }
    public boolean registerNewSeller(String name, String email,String password ,String cpf, Double wage){
        return sellerController.registerNewSeller(name, email, password, cpf, wage);
    }
    public boolean deleteSeller(int idSeller){
        return sellerController.deleteSeller(idSeller);
    }
    public boolean deleteSale(int idSale){
        return salesController.deleteSale(idSale);
    }
    public boolean deleteProduct(int idProduct){
        return productController.deleteProduct(idProduct);
    }
    public boolean deleteCustomer(int idCustomer){
        return customerController.deleteCustomer(idCustomer);
    }
}
