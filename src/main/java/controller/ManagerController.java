package controller;

import model.CustomerModel;
import model.ManagerModel;
import repository.CustomerRepository;
import repository.ManagerRepository;

import java.sql.ResultSet;

public class ManagerController {
    ManagerRepository managerRepository = new ManagerRepository();
    ManagerModel managerModel = new ManagerModel();

    public boolean registerManager(String name, String email, String password){
        managerModel.setName(name);
        managerModel.setEmail(email);
        managerModel.setPassword(password);
        return managerRepository.registerManager(managerModel.getName(),managerModel.getEmail(),managerModel.getPassword());
    }
    public boolean deleteManager(int idManager){
        managerModel.setId(idManager);
        return managerRepository.deleteManager(managerModel.getId());
    }
    public boolean updateManagerEmail(int idManager,String email){
        managerModel.setId(idManager);
        managerModel.setEmail(email);
        return managerRepository.updateManagerEmail(managerModel.getId(),managerModel.getEmail());
    }
    public boolean updatePasswordManager(int idManager,String password){
        managerModel.setId(idManager);
        managerModel.setPassword(password);
        return managerRepository.updatePasswordManager(managerModel.getId(),managerModel.getPassword());
    }
    public ResultSet showAllManagers(){
        return managerRepository.showAllManagers();
    }
    public ResultSet showManagerById(int idManager){
        managerModel.setId(idManager);
        return managerRepository.showManagerById(managerModel.getId());
    }
    public boolean validateLoginManager(String email,String password){
        managerModel.setEmail(email);
        managerModel.setPassword(password);
        return managerRepository.validateLoginManager(managerModel.getEmail(),managerModel.getPassword());
    }
    public void showCustomerOrSellersWithBusinessEmail(){
        managerRepository.showCustomerOrSellersWithBusinessEmail();
    }
    public ResultSet showSalespeopleSalary(){
        return managerRepository.ShowSalespeopleSalary();
    }
}
