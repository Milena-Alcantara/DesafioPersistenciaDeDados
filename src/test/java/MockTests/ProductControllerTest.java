package MockTests;

import controller.ProductController;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import repository.ProductRepository;


import java.sql.ResultSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ProductControllerTest {
    private ProductRepository productRepository;
    private ProductController productController;
    @BeforeEach
    public void setUp() {
        productRepository = mock(ProductRepository.class);
        productController = new ProductController(productRepository);
    }
    @Test
    @DisplayName("Deve retonar  verdadeiro ao tentar cadastrar um produto - mock")
    public void testRegisterSeller(){
        when(productRepository.registerNewProduct("Pastel", 12.00)).thenReturn(true);
        boolean result = productController.registerNewProduct("Pastel", 12.00);
        assertTrue(result);
    }
    @Test
    @DisplayName("Deve retornar verdadeiro ao tentar deletar um produto")
    public void testDeleteSeller(){
        when(productRepository.deleteProduct(1)).thenReturn(true);
        boolean result = productController.deleteProduct(1);
        assertTrue(result);
    }
    @Test
    @DisplayName("Deve retonar verdadeiro ao tentar atualizar o preço do produto")
    public void testUpadateProductPrice(){
        when(productRepository.updateProductPrice(1,13.00)).thenReturn(true);
        boolean result = productController.updateProductPrice(1,13.00);
        assertTrue(result);
    }
    @Test
    @DisplayName("Verifica se o método esta retornando um objeto resultset e não nulo")
    public void testShowAllProduct(){
        ResultSet resultSet1 = mock(ResultSet.class);
        when(productRepository.showAllProducts()).thenReturn(resultSet1);
        ResultSet resultSet = productController.showAllProducts();
        assertEquals(resultSet1,resultSet);
    }
    @Test
    @DisplayName("Verifica se o método esta retornando um objeto resultset e não nulo")
    public void testShowProductById(){
        ResultSet resultSet1 = mock(ResultSet.class);
        when(productRepository.showProductById(1)).thenReturn(resultSet1);
        ResultSet resultSet = productController.showProductById(1);
        assertEquals(resultSet1,resultSet);
    }
}
