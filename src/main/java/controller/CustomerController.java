package controller;

import model.CustomerModel;
import repository.CustomerRepository;
import repository.ManagerRepository;

import java.sql.ResultSet;

public class CustomerController {
    CustomerRepository customerRepository ;
    CustomerModel customerModel = new CustomerModel();
    public CustomerController() {
    }
    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public boolean registerNewCustomer(String name, String email, String cpf, String address){
        customerModel.setCustomerName(name);
        customerModel.setEmail(email);
        customerModel.setCpf(cpf);
        customerModel.setAddress(address);
        return customerRepository.registerNewCustomer(customerModel.getCustomerName(), customerModel.getEmail(),customerModel.getCpf(),customerModel.getAddress());
    }
    public boolean deleteCustomer(int idCustomer){
        customerModel.setIdCustomer(idCustomer);
        return customerRepository.deleteCustomer(customerModel.getIdCustomer());
    }
    public boolean updateEmailCustomer(int idCustomer, String email){
        customerModel.setIdCustomer(idCustomer);
        customerModel.setEmail(email);
        return customerRepository.updateEmailCustomer(customerModel.getIdCustomer(), customerModel.getEmail());
    }
    public boolean updateAddressCustomer(int idCustomer, String address){
        customerModel.setIdCustomer(idCustomer);
        customerModel.setAddress(address);
        return customerRepository.updateAddressCustomer(customerModel.getIdCustomer(), customerModel.getAddress());
    }
    public ResultSet showAllCustomers(){
        return customerRepository.showAllCustomers();
    }
    public ResultSet showCustomerById(int idCustomer){
        customerModel.setIdCustomer(idCustomer);
        return customerRepository.showCustomerById(customerModel.getIdCustomer());
    }
}
