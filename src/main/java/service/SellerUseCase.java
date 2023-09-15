package service;

import controller.CustomerController;
import controller.ProductController;
import controller.SalesController;
import controller.SellerController;

import java.sql.ResultSet;

public class SellerUseCase {
    SellerController sellerController = new SellerController();
    SalesController salesController = new SalesController();
    ProductController productController = new ProductController();
    CustomerController customerController = new CustomerController();

    // referente ao vendedor
    public boolean validateLoginSeller(String email, String password) {
        return sellerController.validateLoginSeller(email, password);
    }
    public boolean updateSellerEmail(int idSeller, String email) {
        return sellerController.updateSellerEmail(idSeller, email);
    }
    public boolean updateSellerPassword(int idSeller, String password) {
        return sellerController.updateSellerPassword(idSeller, password);
    }
    public ResultSet showSellerById(int idSeller) {
        return sellerController.showSellerById(idSeller);
    }
    public ResultSet showAllSellers() {
        return sellerController.showAllSellers();
    }

    //referente a venda
    public boolean getTotalValuesGreaterThan10() {
        return salesController.getTotalValuesGreaterThan10();
    }
    public boolean changeTheTotalValueSalesThatAreNull() {
        return salesController.changeTotalValueOfSalesThatAreNullToZero();
    }
    public boolean registerNewSale(int id_Seller, int id_Customer, int id_Product, int amount, Double total) {
        return salesController.registerNewSale(id_Seller, id_Customer, id_Product, amount, total);
    }
    public ResultSet showAllSales() {
        return salesController.showAllSales();
    }
    public ResultSet showAllSaleById(int idSale) {
        return salesController.showAllSaleById(idSale);
    }

    // referente ao produto
    public boolean registerNewProduct(String name, Double price) {
        return productController.registerNewProduct(name, price);
    }
    public boolean updateProductPrice(int idProduct,Double price){
        return productController.updateProductPrice(idProduct, price);
    }
    public ResultSet showAllProducts(){
        return productController.showAllProducts();
    }
    public ResultSet showProductById(int idProduct){
        return productController.showProductById(idProduct);
    }

    // referente ao cliente
    public boolean registerNewCustomer(String name, String email, String cpf, String address){
        return customerController.registerNewCustomer(name, email, cpf, address);
    }
    public boolean updateEmailCustomer(int idCustomer, String email){
        return customerController.updateEmailCustomer(idCustomer, email);
    }
    public boolean updateAddressCustomer(int idCustomer, String address){
        return customerController.updateAddressCustomer(idCustomer, address);
    }
    public ResultSet showAllCustomers(){
        return customerController.showAllCustomers();
    }
    public ResultSet showCustomerById(int idCustomer){
        return customerController.showCustomerById(idCustomer);
    }

}