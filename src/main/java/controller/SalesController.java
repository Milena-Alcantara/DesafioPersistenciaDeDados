package controller;

import model.SalesModel;
import repository.SalesRepository;

import java.sql.ResultSet;

public class SalesController {
    SalesRepository saleRepository = new SalesRepository();
    SalesModel salesModel = new SalesModel();

    public boolean getTotalValuesGreaterThan10(){
        return saleRepository.getTotalValuesGreaterThan10();
    }

    public boolean changeTotalValueOfSalesThatAreNullToZero(){
        return saleRepository.changeTheTotalValueSalesThatAreNull();
    }
    public boolean registerNewSale(int id_Seller,int id_Customer,int id_Product,int amount, Double total){
        salesModel.setFk_Idseller(id_Seller);
        salesModel.setFk_IdCustomer(id_Customer);
        salesModel.setFk_IdProduct(id_Product);
        salesModel.setAmoutProduct(amount);
        salesModel.setTotalValue(total);
       return saleRepository.registerNewSale(salesModel.getFk_Idseller(), salesModel.getFk_IdCustomer(), salesModel.getFk_IdProduct(),
                salesModel.getAmoutProduct(),salesModel.getTotalValue());
    }
    public boolean deleteSale(int idSale){
        salesModel.setId(idSale);
        return saleRepository.deleteSale(salesModel.getId());
    }
    public ResultSet showAllSales(){
        return saleRepository.showAllSales();
    }
    public ResultSet showAllSaleById(int idSale){
        salesModel.setId(idSale);
        return saleRepository.showAllSaleById(salesModel.getId());
    }
}
