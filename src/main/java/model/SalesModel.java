package model;

public class SalesModel {
    private int id,fk_Idseller,fk_IdCustomer,fk_IdProduct, amoutProduct;
    private Double totalValue;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFk_Idseller() {
        return fk_Idseller;
    }

    public void setFk_Idseller(int fk_Idseller) {
        this.fk_Idseller = fk_Idseller;
    }

    public int getFk_IdCustomer() {
        return fk_IdCustomer;
    }

    public void setFk_IdCustomer(int fk_IdCustomer) {
        this.fk_IdCustomer = fk_IdCustomer;
    }

    public int getFk_IdProduct() {
        return fk_IdProduct;
    }

    public void setFk_IdProduct(int fk_IdProduct) {
        this.fk_IdProduct = fk_IdProduct;
    }

    public int getAmoutProduct() {
        return amoutProduct;
    }

    public void setAmoutProduct(int amoutProduct) {
        this.amoutProduct = amoutProduct;
    }

    public Double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
    }
}
