package MockTests;

import controller.SellerController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import repository.SellerRepository;


import java.sql.ResultSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SellerControllerTest {
    private SellerRepository sellerRepository;
    private SellerController sellerController;
    @BeforeEach
    public void setUp() {
        sellerRepository = mock(SellerRepository.class);
        sellerController = new SellerController(sellerRepository);
    }
    @Test
    @DisplayName("Deve retonar  verdadeiro ao tentar cadastrar um vendedor - mock")
    public void testRegisterSeller(){
        when(sellerRepository.registerNewSeller("John Doe", "john@example.com", "password"
                ,"12345678",1200.00)).thenReturn(true);
        boolean result = sellerController.registerNewSeller("John Doe", "john@example.com", "password"
                ,"12345678",1200.00);
        assertTrue(result);
    }
    @Test
    @DisplayName("Deve retornar verdadeiro ao tentar realizar o login do vendedor")
    public void testValidateLoginSeller(){
        when(sellerRepository.validateLoginSeller("emilio@example.com","12345678")).thenReturn(true);
        boolean result =  sellerController.validateLoginSeller("emilio@example.com","12345678");
        assertTrue(result);
    }
    @Test
    @DisplayName("Deve retornar verdadeiro ao tentar deletar um vendedor")
    public void testDeleteSeller(){
        when(sellerRepository.deleteSeller(1)).thenReturn(true);
        boolean result = sellerController.deleteSeller(1);
        assertTrue(result);
    }
    @Test
    @DisplayName("Deve retonar verdadeiro ao tentar atualizar o email do vendedor")
    public void testUpadateSellerEmail(){
        when(sellerRepository.updateSellerEmail(1,"emilio@example.com")).thenReturn(true);
        boolean result = sellerController.updateSellerEmail(1,"emilio@example.com");
        assertTrue(result);
    }
    @Test
    @DisplayName("Deve retonar verdadeiro ao tentar atualizar a senha do vendedor")
    public void testUpdatePasswordSeller(){
        when(sellerRepository.updateSellerPassword(1,"12345678")).thenReturn(true);
        boolean result = sellerController.updateSellerPassword(1,"12345678");
        assertTrue(result);
    }
    @Test
    @DisplayName("Verifica se o método esta retornando um objeto resultset e não nulo")
    public void testShowAllSeller(){
        ResultSet resultSet1 = mock(ResultSet.class);
        when(sellerRepository.showAllSellers()).thenReturn(resultSet1);
        ResultSet resultSet = sellerController.showAllSellers();
        assertEquals(resultSet1,resultSet);
    }
    @Test
    @DisplayName("Verifica se o método esta retornando um objeto resultset e não nulo")
    public void testShowSellerById(){
        ResultSet resultSet1 = mock(ResultSet.class);
        when(sellerRepository.showSellerById(1)).thenReturn(resultSet1);
        ResultSet resultSet = sellerController.showSellerById(1);
        assertEquals(resultSet1,resultSet);
    }


}
