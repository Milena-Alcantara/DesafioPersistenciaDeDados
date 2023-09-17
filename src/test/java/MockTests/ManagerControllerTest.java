package MockTests;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import controller.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import repository.ManagerRepository;

import java.sql.ResultSet;

public class ManagerControllerTest {
    private ManagerController managerController;
    private ManagerRepository managerRepository;

    @BeforeEach
    public void setUp() {
        managerRepository = mock(ManagerRepository.class);
        managerController = new ManagerController(managerRepository);


    }
    @Test
    @DisplayName("Deve retornar verdadeiro ao registrar um novo gerente")
    public void testRegisterManager() {
        when(managerRepository.registerManager(anyString(), anyString(), anyString())).thenReturn(true);
        boolean result = managerController.registerManager("John Doe", "john@example.com", "password");
        assertTrue(result);
    }
    @Test
    @DisplayName("Deve retornar verdadeiro ao tentar deletar um gerente")
    public void testDeleteManager(){
        when(managerRepository.deleteManager(1)).thenReturn(true);
        boolean result = managerController.deleteManager(1);
        assertTrue(result);
    }
    @Test
    @DisplayName("Deve retonar verdadeiro ao tentar atualizar o email do gerente")
    public void testUpadateManagerEmail(){
        when(managerRepository.updateManagerEmail(1,"emilio@example.com")).thenReturn(true);
        boolean result = managerController.updateManagerEmail(1,"emilio@example.com");
        assertTrue(result);
    }
    @Test
    @DisplayName("Deve retonar verdadeiro ao tentar atualizar a senha do gerente")
    public void testUpdatePasswordManager(){
        when(managerRepository.updatePasswordManager(1,"12345678")).thenReturn(true);
        boolean result = managerController.updatePasswordManager(1,"12345678");
        assertTrue(result);
    }
    @Test
    @DisplayName("Deve retornar verdadeiro ao tentar realizar o login do gerente")
    public void testValidateLoginManager(){
        when(managerRepository.validateLoginManager("emilio@example.com","12345678")).thenReturn(true);
        boolean result =  managerController.validateLoginManager("emilio@example.com","12345678");
        assertTrue(result);
    }
    @Test
    @DisplayName("Verifica se o método esta retornando um objeto resultset e não nulo")
    public void testShowAllManager(){
        ResultSet resultSet1 = mock(ResultSet.class);
        when(managerRepository.showAllManagers()).thenReturn(resultSet1);
        ResultSet resultSet = managerController.showAllManagers();
        assertEquals(resultSet1,resultSet);
    }
    @Test
    @DisplayName("Verifica se o método esta retornando um objeto resultset e não nulo")
    public void testShowManagerById(){
        ResultSet resultSet1 = mock(ResultSet.class);
        when(managerRepository.showManagerById(1)).thenReturn(resultSet1);
        ResultSet resultSet = managerController.showManagerById(1);
        assertEquals(resultSet1,resultSet);
    }
    @Test
    @DisplayName("Verifica se o método esta retornando um objeto resultset e não nulo")
    public void testShowAllSalesPeopleSalary(){
        ResultSet resultSet1 = mock(ResultSet.class);
        when(managerRepository.ShowSalespeopleSalary()).thenReturn(resultSet1);
        ResultSet resultSet  = managerController.showSalespeopleSalary();
        assertEquals(resultSet1,resultSet);
    }





}
