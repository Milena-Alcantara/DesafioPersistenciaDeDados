package MockTests;

import controller.SalesController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import repository.SalesRepository;

import java.sql.ResultSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SalesControllerTest {
    private SalesRepository salesRepository;
    private SalesController salesController;
    @BeforeEach
    public void setUp() {
        salesRepository = mock(SalesRepository.class);
        salesController = new SalesController(salesRepository);
    }
    @Test
    @DisplayName("Deve retonar verdadeiro ao mostrar os valores maiores que 10.00 em vendas - mock")
    public void testgetTotalValuesGreaterThan10(){
        when(salesRepository.getTotalValuesGreaterThan10()).thenReturn(true);
        boolean result = salesController.getTotalValuesGreaterThan10();
        assertTrue(result);
    }
    @Test
    public void testChangeTotalValueOfSalesThatAreNullToZero(){
        when(salesRepository.changeTheTotalValueSalesThatAreNull()).thenReturn(true);
        boolean result = salesController.changeTotalValueOfSalesThatAreNullToZero();
        assertTrue(result);
    }
    @Test
    public void testRegisterNewSale(){
        when(salesRepository.registerNewSale(1, 1, 1
                ,2,26.00)).thenReturn(true);
        boolean result = salesController.registerNewSale(1, 1, 1
                ,2,26.00);
        assertTrue(result);
    }
    @Test
    public void testDeleteSale(){
        when(salesRepository.deleteSale(1)).thenReturn(true);
        boolean result = salesController.deleteSale(1);
        assertTrue(result);
    }
    @Test
    public void testShowAllSales(){
        ResultSet resultSet1 = mock(ResultSet.class);
        when(salesRepository.showAllSales()).thenReturn(resultSet1);
        ResultSet resultSet = salesController.showAllSales();
        assertEquals(resultSet1,resultSet);
    }
    @Test
    public void testShowAllSaleById(){
        ResultSet resultSet1 = mock(ResultSet.class);
        when(salesRepository.showAllSaleById(1)).thenReturn(resultSet1);
        ResultSet resultSet = salesController.showAllSaleById(1);
        assertEquals(resultSet1,resultSet);
    }
}
