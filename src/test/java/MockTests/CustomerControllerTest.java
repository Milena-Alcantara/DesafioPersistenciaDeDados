package MockTests;

import controller.CustomerController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import repository.CustomerRepository;

import java.sql.ResultSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CustomerControllerTest {
    private CustomerRepository customerRepository;
    private CustomerController customerController;
    @BeforeEach
    public void setUp() {
        customerRepository = mock(CustomerRepository.class);
        customerController = new CustomerController(customerRepository);
    }
    @Test
    @DisplayName("Deve retonar  verdadeiro ao tentar cadastrar um cliente - mock")
    public void testRegisterCustomer(){
        when(customerRepository.registerNewCustomer("John Doe", "john@example.com", "password"
                ,"Av Rio Branco - n50, São Paulo -SP")).thenReturn(true);
        boolean result = customerController.registerNewCustomer("John Doe", "john@example.com", "password"
                ,"Av Rio Branco - n50, São Paulo -SP");
        assertTrue(result);
    }
    @Test
    @DisplayName("Deve retornar verdadeiro ao tentar deletar um cliente")
    public void testDeleteCustomer(){
        when(customerRepository.deleteCustomer(1)).thenReturn(true);
        boolean result = customerController.deleteCustomer(1);
        assertTrue(result);
    }
    @Test
    @DisplayName("Deve retonar verdadeiro ao tentar atualizar o email do cliente")
    public void testUpadateCustomerEmail(){
        when(customerRepository.updateEmailCustomer(1,"emilio@example.com")).thenReturn(true);
        boolean result = customerController.updateEmailCustomer(1,"emilio@example.com");
        assertTrue(result);
    }
    @Test
    @DisplayName("Deve retonar verdadeiro ao tentar atualizar o endereço do cliente")
    public void testUpdateAddressCustomer(){
        when(customerRepository.updateAddressCustomer(1,"Av Rio Branco - n50, São Paulo -SP")).thenReturn(true);
        boolean result = customerController.updateAddressCustomer(1,"Av Rio Branco - n50, São Paulo -SP");
        assertTrue(result);
    }
    @Test
    @DisplayName("Verifica se o método esta retornando um objeto resultset e não nulo")
    public void testShowAllCustomer(){
        ResultSet resultSet1 = mock(ResultSet.class);
        when(customerRepository.showAllCustomers()).thenReturn(resultSet1);
        ResultSet resultSet = customerController.showAllCustomers();
        assertEquals(resultSet1,resultSet);
    }
    @Test
    @DisplayName("Verifica se o método esta retornando um objeto resultset e não nulo")
    public void testShowSCustomerById(){
        ResultSet resultSet1 = mock(ResultSet.class);
        when(customerRepository.showCustomerById(1)).thenReturn(resultSet1);
        ResultSet resultSet = customerController.showCustomerById(1);
        assertEquals(resultSet1,resultSet);
    }
}
