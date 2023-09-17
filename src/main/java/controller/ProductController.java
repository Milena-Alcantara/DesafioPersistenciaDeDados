package controller;

import model.ProductModel;
import repository.ProductRepository;

import java.sql.ResultSet;

public class ProductController {
    ProductRepository productRepository;
    ProductModel productModel = new ProductModel();

    public ProductController() {
    }

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public boolean registerNewProduct(String name, Double price){
        productModel.setName(name);
        productModel.setPrice(price);
        return productRepository.registerNewProduct(productModel.getName(), productModel.getPrice());
    }
    public boolean deleteProduct(int idProduct){
        productModel.setId(idProduct);
        return productRepository.deleteProduct(productModel.getId());
    }
    public boolean updateProductPrice(int idProduct,Double price){
        productModel.setId(idProduct);
        productModel.setPrice(price);
        return productRepository.updateProductPrice(productModel.getId(),productModel.getPrice());
    }
    public ResultSet showAllProducts(){
        return productRepository.showAllProducts();
    }
    public ResultSet showProductById(int idProduct){
        productModel.setId(idProduct);
        return productRepository.showProductById(productModel.getId());
    }
}
