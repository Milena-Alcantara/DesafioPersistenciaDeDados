package view;

import service.ManagerUseCase;
import service.SellerUseCase;

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
                // acccessSellerMenu();
                break;
            case 2:
                // accessCustomerMenu();
                break;
            case 3:
                accessSalesMenu();
                break;
            case 4:
             //   accessProductMenu();
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
              case 2: break;
              case 3: break;
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
    public void seeSalesGreateThanThen() {
        sellerUseCase.getTotalValuesGreaterThan10();
    }
    public boolean updateZeroSalesValues() {
        return sellerUseCase.changeTheTotalValueSalesThatAreNull();
    }
}


