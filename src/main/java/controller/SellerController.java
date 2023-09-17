package controller;

import model.SellerModel;
import repository.SellerRepository;

import java.sql.ResultSet;

public class SellerController {
    SellerRepository sellerRepository;
    SellerModel sellerModel = new SellerModel();

    public SellerController() {
    }

    public SellerController(SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }

    public boolean registerNewSeller(String name, String email, String password , String cpf, Double wage){
        sellerModel.setName(name);
        sellerModel.setEmail(email);
        sellerModel.setPassword(password);
        sellerModel.setCpf(cpf);
        sellerModel.setWage(wage);
        return sellerRepository.registerNewSeller(sellerModel.getName(),sellerModel.getEmail(),sellerModel.getPassword(),
                sellerModel.getCpf(),sellerModel.getWage());
    }
    public boolean deleteSeller(int idSeller){
        sellerModel.setId(idSeller);
        return sellerRepository.deleteSeller(sellerModel.getId());
    }
    public boolean updateSellerEmail(int idSeller,String email){
        sellerModel.setId(idSeller);
        sellerModel.setEmail(email);
        return sellerRepository.updateSellerEmail(sellerModel.getId(),sellerModel.getEmail());
    }
    public boolean updateSellerPassword(int idSeller,String password){
        sellerModel.setId(idSeller);
        sellerModel.setPassword(password);
        return  sellerRepository.updateSellerPassword(sellerModel.getId(), sellerModel.getPassword());
    }
    public ResultSet showAllSellers(){
        return sellerRepository.showAllSellers();
    }
    public ResultSet showSellerById(int idSeller){
        sellerModel.setId(idSeller);
        return sellerRepository.showSellerById(sellerModel.getId());
    }
    public boolean validateLoginSeller(String email,String password){
        sellerModel.setEmail(email);
        sellerModel.setPassword(password);
        return sellerRepository.validateLoginSeller(sellerModel.getEmail(), sellerModel.getPassword());
    }

}
