package view;

import service.ManagerUseCase;
import service.SellerUseCase;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class SellerView {
    SellerUseCase sellerUseCase = new SellerUseCase();
    Scanner scanner = new Scanner(System.in);
      public boolean loginSeller() {
          System.out.println("Por favor informe seus dados de login: ");
          System.out.print("Email: ");
          String loginEmail = scanner.next();
          System.out.print("Senha: ");
          String loginPassword = scanner.next();
          boolean login = sellerUseCase.validateLoginSeller(loginEmail, loginPassword);
          while (login == false) {
              System.out.println("Dados inválidos, tente novamente");
              loginSeller();
          }
          return true;
      }

    public void accessMenu(){
        System.out.println("Informe qual área do sistema deseja acessar: ");
        System.out.println("\n\t1- Acesso aos Vendedores\n\t2- Acesso aos Clientes\n\t3- Acesso as Vendas\n\t4- Acesso aos Produtos" +
                "\n\t0- Sair");
        int choiceAccces = scanner.nextInt();
        switch (choiceAccces){
            case 1:
                accessSallerMenu();
                break;
            case 2:
                 accessCustomerMenu();
                break;
            case 3:
                accessSalesMenu();
                break;
            case 4:
                accessProductMenu();
                break;
            case 0:
                System.out.println("Encerrando");
                System.exit(0);
                break;
            default:
                System.out.println("Por favor digite um opção válida");
                accessMenu();
        }
      }
      public void accessSalesMenu(){
          System.out.println("Informe uma das opções: ");
          System.out.println("\n\t1- Cadastrar uma nova Venda\n\t2- Ver todas as vendas\n\t3- Pesquisar uma venda" +
                  "\n\t4- Ver vendas registradas acima de R$10,00\n\t5- Atualizar os valores das vendas vazias\n\t0- Voltar");
          int choice = scanner.nextInt();
          switch (choice){
              case 1:
                  if (addNewSale()){
                      System.out.println("Venda cadastrada com sucesso! ");
                      accessSalesMenu();
                  }else {
                      System.out.println("Não foi possível cadastrar a venda.");
                      accessSalesMenu();
                  }
                  break;
              case 2:
                  viewAllSales();
                  accessSalesMenu();
                  break;
              case 3:
                  searchASaleById();
                  accessSalesMenu();
                  break;
              case 4:
                   seeSalesGreateThanThen();
                   accessSalesMenu();
                  break;
              case 5:
                   if (updateZeroSalesValues()){
                       System.out.println("Valores foram atualizados com sucesso!");
                       accessSalesMenu();
                   }else {
                       System.out.println("Não foi possível atualizar os valores.");
                       accessSalesMenu();
                   }
                  break;
              case 0:
                  accessMenu();
                  break;
              default:
                  System.out.println("Por favor, escolha uma das opções válidas");
                  accessSalesMenu();
          }
      }
    public boolean addNewSale() {
        System.out.print("Por favor identifique seu id para cadastro da venda:  ");
        int idSeller = scanner.nextInt();
        System.out.print("Por favor identifique o id do cliente para cadastro da venda:  ");
        int idCustomer = scanner.nextInt();
        System.out.print("Por favor identifique o id do produto para cadastro da venda:  ");
        int idProduct = scanner.nextInt();
        System.out.print("Informe a quantidade do produto vendida: ");
        int amount = scanner.nextInt();
        System.out.print("Informe o valor total da venda: ");
        Double totalValue = scanner.nextDouble();
        return sellerUseCase.registerNewSale(idSeller, idCustomer, idProduct, amount, totalValue);
    }
    public void viewAllSales(){
        try {
            ResultSet resultSet = sellerUseCase.showAllSales();
            System.out.println("Visualize as vendas cadastradas: ");
            while (resultSet.next()){
                System.out.println("|ID: "+resultSet.getString("id"));
                System.out.println("|Valor Total: "+resultSet.getString("total_value"));
            }
        }catch (SQLException err){
            err.printStackTrace();
    }
      }
    public boolean searchASaleById(){
          try {
              System.out.println("Informe o id de identificação da venda que deseja localizar: ");
              int id = scanner.nextInt();
              ResultSet resultSet =   sellerUseCase.showAllSaleById(id);
              System.out.println("Dados encontrados: ");
              while (resultSet.next()){
                  System.out.println("|ID: "+resultSet.getString("id"));
                  System.out.println("|Valor Total: "+resultSet.getString("total_value"));
              }
              return true;
          }catch (SQLException err){
              err.printStackTrace();
          }
       return false;
    }
    public void seeSalesGreateThanThen() {
        sellerUseCase.getTotalValuesGreaterThan10();
    }
    public boolean updateZeroSalesValues() {
        return sellerUseCase.changeTheTotalValueSalesThatAreNull();
    }
    public void accessSallerMenu(){
        System.out.println("Informe uma das opções: ");
        System.out.println("\n\t1- Atualizar seu email\n\t2- Atualizar sua senha\n\t3- Ver vendedores" +
                "\n\t4- Pesquisar um vendedor\n\t0- Voltar");
        int choice = scanner.nextInt();
        switch (choice){
            case 1:
                if (updateEmailSeller()){
                    System.out.println("E-mail atualizado com sucesso! ");
                    accessSallerMenu();
                }else {
                    System.out.println("Não foi possível atualizar o e-mail.");
                    accessSallerMenu();
                }
                accessSallerMenu();
                break;
            case 2:
                if (updatePasswordSeller()){
                    System.out.println("Senha atualizada com sucesso! ");
                    accessSallerMenu();
                }else {
                    System.out.println("Não foi possível atualizar a senha.");
                    accessSallerMenu();
                }
                accessSallerMenu();
                break;
            case 3:
                viewAllSelers();
                accessSallerMenu();
                break;
            case 4:
               searchASellerById();
                accessSallerMenu();
                break;

            case 0:
                accessMenu();
                break;
            default:
                System.out.println("Por favor, escolha uma das opções válidas");
                accessSallerMenu();
        }
    }
   public boolean updateEmailSeller(){
       System.out.print("Informe seu id de identificação: ");
       int id = scanner.nextInt();
       scanner.nextLine();
       System.out.print("Informe seu novo e-mail: ");
       String newEmail = scanner.next();
       return sellerUseCase.updateSellerEmail(id,newEmail);
   }
   public boolean updatePasswordSeller(){
       System.out.print("Informe seu id de identificação: ");
       int id = scanner.nextInt();
       scanner.nextLine();
       System.out.print("Informe sua nova senha:  ");
       String newPassword = scanner.next();
       return sellerUseCase.updateSellerPassword(id,newPassword);
   }
   public void viewAllSelers() {
       try {
           ResultSet resultSet = sellerUseCase.showAllSellers();
           System.out.println("Visualize os vendedores cadastradas: ");
           while (resultSet.next()){
               System.out.println("|Nome: "+resultSet.getString("name"));
               System.out.println("|E-mail: "+resultSet.getString("email"));
           }
       }catch (SQLException err){
           err.printStackTrace();
   }
}
    public boolean searchASellerById() {
        try {
            System.out.println("Informe o id de identificação do vendedor que deseja localizar: ");
            int id = scanner.nextInt();
            ResultSet resultSet =   sellerUseCase.showSellerById(id);
            System.out.println("Dados encontrados: ");
            while (resultSet.next()){
                System.out.println("|Nome: "+resultSet.getString("name"));
                System.out.println("|E-mail: "+resultSet.getString("email"));
            }
            return true;
        }catch (SQLException err){
            err.printStackTrace();
        }
        return false;
    }
    public void accessCustomerMenu(){
        System.out.println("Informe uma das opções: ");
        System.out.println("\n\t1- Cadastrar um novo Cliente\n\t2- Atualizar endereço\n\t3- Atualizar e-mail" +
                "\n\t4- Ver todos os clientes\n\t5- Pesquisat um cliente\n\t0- Voltar");
        int choice = scanner.nextInt();
        switch (choice){

            case 1:
                if (addNewCustomer()){
                    System.out.println("Cliente cadastrado com sucesso!");
                    accessCustomerMenu();
                }else {
                    System.out.println("Não foi possível realizar o cadastro do cliente.");
                    accessCustomerMenu();
                }
            break;
            case 2:
                if (updateAddressCusotmer()){
                    System.out.println("Endereço atualizado com sucesso! ");
                    accessCustomerMenu();
                }else {
                    System.out.println("Não foi possível atualizar o endereço.");
                    accessCustomerMenu();
                }
                break;
            case 3:
                if (updateEmailCustomer()){
                    System.out.println("E-mail atualizado com sucesso! ");
                    accessCustomerMenu();
                }else {
                    System.out.println("Não foi possível atualizar o e-mail.");
                    accessCustomerMenu();
                }
                break;
            case 4:
                viewAllCustomers();
                accessCustomerMenu();
                break;
            case 5:
                searchACustomerById();
                accessCustomerMenu();
                break;
            case 0:
                accessMenu();
                break;
            default:
                System.out.println("Por favor, escolha uma das opções válidas");
                accessSallerMenu();
        }
    }
    public boolean addNewCustomer(){
        scanner.nextLine();
        System.out.print("Informe o primeiro nome: ");
        String name = scanner.next();
        System.out.print("Informe o email: ");
        String email = scanner.next();
        System.out.print("Informe seu CPF: ");
        String cpf = scanner.next();
        System.out.print("Informe o endereço: ");
        String address = scanner.next();

        return sellerUseCase.registerNewCustomer(name,email,cpf,address);
    }
    public boolean updateAddressCusotmer(){
        System.out.print("Informe o id do cliente de identificação: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Informe o novo endereço: ");
        String newAddress = scanner.next();
        return sellerUseCase.updateAddressCustomer(id,newAddress);
    }
    public boolean updateEmailCustomer(){
        System.out.print("Informe o id do cliente de identificação: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Informe o novo e-mail: ");
        String newEmail = scanner.next();
        return sellerUseCase.updateEmailCustomer(id,newEmail);
    }
    public boolean viewAllCustomers(){
        try {
            ResultSet resultSet = sellerUseCase.showAllCustomers();
            System.out.println("Visualize os clientes cadastradas: ");
            while (resultSet.next()){
                System.out.println("|Nome: "+resultSet.getString("name"));
                System.out.println("|E-mail: "+resultSet.getString("email"));
                System.out.println("|Endereço: "+resultSet.getString("address"));
            }
            return true;
        }catch (SQLException err){
            err.printStackTrace();
    }
        return false;
      }
    public boolean searchACustomerById() {
        try {
            System.out.println("Informe o id de identificação do cliente que deseja localizar: ");
            int id = scanner.nextInt();
            ResultSet resultSet =   sellerUseCase.showCustomerById(id);
            System.out.println("Dados encontrados: ");
            while (resultSet.next()){
                System.out.println("|Nome: "+resultSet.getString("name"));
                System.out.println("|E-mail: "+resultSet.getString("email"));
            }
            return true;
        }catch (SQLException err){
            err.printStackTrace();
        }
        return false;
    }
    public void accessProductMenu(){
        System.out.println("Informe uma das opções: ");
        System.out.println("\n\t1- Cadastrar um novo produto\n\t2- Atualizar preço\n\t3- Ver produtos" +
                "\n\t4- Pesquisar um produto\n\t0- Voltar");
        int choice = scanner.nextInt();
        switch (choice){
            case 1:
                if (addNewProduct()){
                    System.out.println("Produto cadatrado com sucesso!");
                    accessProductMenu();
                }else {
                    System.out.println("Não foi possível cadastrar o produto.");
                    accessProductMenu();
                }
              break;
            case 2:
                if (updatePriceProduct()){
                    System.out.println("Preço atualizado com sucesso! ");
                    accessProductMenu();
                }else {
                    System.out.println("Não foi possível atualizar o preço.");
                    accessProductMenu();
                }
                break;
            case 3:
                viewAllProduct();
                accessProductMenu();
                break;
            case 4:
                searchAProductById();
                accessProductMenu();
                break;
            case 0:
                accessMenu();
                break;
            default:
                System.out.println("Por favor, escolha uma das opções válidas");
                accessSallerMenu();
        }
    }
    public boolean addNewProduct(){
          scanner.nextLine();
        System.out.print("Informe o nome do produto: ");
        String nameProduct = scanner.next();
        System.out.print("Informe o preço do produto: ");
        Double price = scanner.nextDouble();
        return sellerUseCase.registerNewProduct(nameProduct,price);
    }
    public boolean updatePriceProduct(){
        System.out.print("Informe o id de identificação do produto: ");
        int idProduct = scanner.nextInt();
        System.out.print("Informe o novo preço do produto: ");
        Double newPrice = scanner.nextDouble();
        return sellerUseCase.updateProductPrice(idProduct,newPrice);
    }
    public boolean viewAllProduct(){
        try {
            ResultSet resultSet = sellerUseCase.showAllProducts();
            System.out.println("Visualize os produtos cadastradas: ");
            while (resultSet.next()){
                System.out.println("|Nome: "+resultSet.getString("name"));
                System.out.println("|Preço: "+resultSet.getString("price"));
                System.out.println();
            }
            return true;
        }catch (SQLException err){
            err.printStackTrace();
        }
        return false;
    }
    public boolean searchAProductById(){
        try {
            System.out.println("Informe o id de identificação do produto que deseja localizar: ");
            int id = scanner.nextInt();
            ResultSet resultSet =   sellerUseCase.showProductById(id);
            System.out.println("Dados encontrados: ");
            while (resultSet.next()){
                System.out.println("|Nome: "+resultSet.getString("name"));
                System.out.println("|Preço: "+resultSet.getString("price"));
                System.out.println();
            }
            return true;
        }catch (SQLException err){
            err.printStackTrace();
        }
        return false;
    }
}


