package view;

import service.ManagerUseCase;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ManagerView {
    ManagerUseCase managerUseCase = new ManagerUseCase();
    Scanner scanner = new Scanner(System.in);
    public boolean loginManager(){
        System.out.println("Por favor informe seus dados de login: ");
        System.out.print("Email: ");
        String loginEmail = scanner.next();
        System.out.print("Senha: ");
        String loginPassword = scanner.next();
        boolean login = managerUseCase.validateLoginManager(loginEmail,loginPassword);
        while (login == false){
            System.out.println("Dados inválidos, tente novamente");
            loginManager();
        }
        return true;
    }
    public void accessMenu(){
        System.out.println("Informe qual área do sistema deseja acessar: ");
        System.out.println("\n\t1- Acesso aos Gerentes\n\t2- Acesso aos Vendedores" +
                "\n\t3- Acesso aos Clientes\n\t4- Acesso as Vendas\n\t5- Acesso aos Produtos\n\t0- Sair");
        int choiceAccces = scanner.nextInt();
        switch (choiceAccces){
            case 1:
                accessManagerMenu();
                break;
            case 2:
                acccessSellerMenu();
                break;
            case 3:
                accessCustomerMenu();
                break;
            case 4:
                accessSalesMenu();
                break;
            case 5:
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
    public void accessManagerMenu(){
        System.out.println("Informe uma das opções: ");
        System.out.println("\n\t1- Cadastrar um novo gerente\n\t2- Atualizar sua senha\n\t3- Atualizar seu e-mail" +
                "\n\t4- Excluir um gerente\n\t5- Ver todos os gerentes\n\t6- Pesquisar um gerente" +
                "\n\t7- Visualizar todos os cadastros com e-mail comercial\n\t0- Voltar");
        int choice = scanner.nextInt();
        switch (choice){
            case 1:
                if (registerManagerMenu()) {
                    System.out.println("Novo Gerente cadastrado com sucesso");
                    accessManagerMenu();
                }else {
                    System.out.println("Não foi possível efetuar o cadastro");
                    accessManagerMenu();
                }
                break;
            case 2:
                if (updatePassword()){
                    System.out.println("Senha atualizada com sucesso!");
                    accessManagerMenu();
                }else{
                    System.out.println("Não foi possível atualizar sua senha!");
                    accessManagerMenu();
                }
                break;
            case 3:
                if (updateEmail()){
                    System.out.println("E-mail atualizado com sucesso!");
                    accessManagerMenu();
                }else{
                    System.out.println("Não foi possível atualizar seu e-mail.");
                    accessManagerMenu();
                }
                break;
            case 4:
                if (deleteManager()){
                    System.out.println("Gerente deletado com sucesso!");
                    accessManagerMenu();
                }else {
                    System.out.println("Não foi possível excluir o gerente selecionado.");
                    accessManagerMenu();
                }
                break;
            case 5:
                viewAllManagers();
                accessManagerMenu();
                break;
            case 6:
                searchForAManager();
                accessManagerMenu();
                break;
            case 7:
                viewRegisteredCommercialEmails();
                accessManagerMenu();
                break;
            case 0:
                accessMenu();
                break;
            default:
                System.out.println("Por favor digite um opção válida");
                accessManagerMenu();
        }
        }
    public boolean registerManagerMenu(){
        scanner.nextLine();
        System.out.print("Informe o primeiro nome: ");
        String name = scanner.next();
        System.out.print("Informe o email: ");
        String email = scanner.next();
        System.out.print("Informe o a senha: ");
        String password = scanner.next();
        return managerUseCase.registerManager(name,email,password);
    }
    public boolean updatePassword(){
        System.out.print("Informe seu id de identificação: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Informe sua nova senha: ");
        String newPassword = scanner.next();
        return managerUseCase.updatePasswordManager(id,newPassword);
    }
    public boolean updateEmail(){
        System.out.print("Informe seu id de identificação: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Informe seu novo e-mail: ");
        String newEmail = scanner.next();
        return managerUseCase.updateManagerEmail(id,newEmail);
    }
    public boolean deleteManager(){
        System.out.println("Informe o id de identificação do gerente que deseja exluir: ");
        int id = scanner.nextInt();
        return managerUseCase.deleteManager(id);
    }
    public void viewAllManagers(){
        try {
            ResultSet resultSet = managerUseCase.showAllManagers();
            System.out.println("Visualize os gerentes cadastrados: ");
            while (resultSet.next()){
                System.out.println("|Nome: "+resultSet.getString("name"));
                System.out.println("|Email: "+resultSet.getString("email"));
            }

        }catch (SQLException err){
            err.printStackTrace();
        }
    }
    public void searchForAManager(){
        try {
            System.out.println("Informe o id de identificação do gerente que deseja localizar: ");
            int id = scanner.nextInt();
            ResultSet resultSet =   managerUseCase.showManagerById(id);
            System.out.println("Dados encontrados: ");
            while (resultSet.next()){
                System.out.println("|Nome: "+resultSet.getString("name"));
                System.out.println("|Email: "+resultSet.getString("email"));
            }

        }catch (SQLException err){
            err.printStackTrace();
        }
    }
    public void viewRegisteredCommercialEmails() {
        System.out.println("Dados encontrados:  ");
        managerUseCase.showCustomerOrSellersWithBusinessEmail();
    }
    public void acccessSellerMenu(){
        System.out.println("Informe uma das opções: ");
        System.out.println("\n\t1- Cadastrar um vendedor\n\t2- Deletar um vendedor \n\t3- Ver os salários de todos os funcionários" +
                "\n\t0- Voltar ao Menu anterior");
        int choiceAccessSeller = scanner.nextInt();
        switch (choiceAccessSeller){
            case 1:
                if (addNewSeller()){
                    System.out.println("Vendedor cadastrado com sucesso! ");
                    acccessSellerMenu();
                }else {
                    System.out.println("Não foi possível cadastrar o vendedor.");
                    acccessSellerMenu();
                }
                break;
            case 2:
                if (deleteSeller()){
                    System.out.println("Vendedor Deletado com sucesso! ");
                    acccessSellerMenu();
                }else{
                    System.out.println("Não foi possível deletar o vendedor selecionado.");
                    acccessSellerMenu();
                }
                break;
            case 3:
                viewAllWagesSellers();
                acccessSellerMenu();
                break;
            case 0:
                accessMenu();
                break;
            default:
                System.out.println("Por favor digite um opção válida");
                acccessSellerMenu();
        }
    }
    public boolean addNewSeller(){
        System.out.print("Informe o nome: ");
        String nameSeller = scanner.next();
        System.out.print("Informe o email: ");
        String emailSeller = scanner.next();
        System.out.print("Cadastre uma senha: ");
        String password = scanner.next();
        System.out.print("Informe o CPF: ");
        String cpf = scanner.next();
        scanner.nextLine();
        System.out.print("Informe o Salário: ");
        Double salary = scanner.nextDouble();
        return managerUseCase.registerNewSeller(nameSeller,emailSeller,password,cpf,salary);
    }
    public  boolean deleteSeller(){
        System.out.println("Informe o id de identificação do vendedor: ");
        int idSeller = scanner.nextInt();
        return managerUseCase.deleteSeller(idSeller);
    }
    public void viewAllWagesSellers(){
        try {
            ResultSet resultSet = managerUseCase.showSalespeopleSalary();
            while (resultSet.next()){
                System.out.println("|Nome: "+resultSet.getString("name")+" |");
                System.out.println("|Salário: R$ "+resultSet.getDouble("wage")+" |");
                System.out.println();
            }
        }catch (SQLException err){
            err.printStackTrace();
        }
    }
    public void accessCustomerMenu(){
        System.out.println("Informe uma das opções: ");
        System.out.println("\n\t1- Deletar um cliente\n\t0- Voltar ao Menu anterior");
        int choiceAccessSeller = scanner.nextInt();

        switch (choiceAccessSeller){
            case 1:
                if (deleteACustomer()){
                    System.out.println("Cliente deletado com sucesso! ");
                    accessCustomerMenu();
                }else {
                    System.out.println("Não foi possível deletar o cliente.");
                    accessCustomerMenu();
                }
                break;
            case 2:
                accessMenu();
                break;

            default:
                System.out.println("Por favor digite um opção válida");
                acccessSellerMenu();
        }
    }
    public boolean deleteACustomer(){
        System.out.println("Informe o id de identificação do cliente: ");
        int idCustomer = scanner.nextInt();
        return managerUseCase.deleteCustomer(idCustomer);
    }
    public void accessSalesMenu(){
        System.out.println("Informe uma das opções: ");
        System.out.println("\n\t1- Deletar uma VendA\n\t0- Voltar ao Menu anterior");
        int choiceAccessSeller = scanner.nextInt();

        switch (choiceAccessSeller){
            case 1:
                if (deleteASale()){
                    System.out.println("Venda deletada com sucesso! ");
                    accessCustomerMenu();
                }else {
                    System.out.println("Não foi possível deletar a venda.");
                    accessCustomerMenu();
                }
                break;
            case 2:
                accessMenu();
                break;

            default:
                System.out.println("Por favor digite um opção válida");
                acccessSellerMenu();
        }
    }
    public boolean deleteASale(){
        System.out.println("Informe o id de identificação da venda: ");
        int idSale = scanner.nextInt();
        return managerUseCase.deleteSale(idSale);
    }
    public void accessProductMenu(){
        System.out.println("Informe uma das opções: ");
        System.out.println("\n\t1- Deletar um Produto\n\t0- Voltar ao Menu anterior");
        int choiceAccessSeller = scanner.nextInt();

        switch (choiceAccessSeller){
            case 1:
                if (deleteAProduct()){
                    System.out.println("Produto com sucesso! ");
                    accessCustomerMenu();
                }else {
                    System.out.println("Não foi possível deletar o produto.");
                    accessCustomerMenu();
                }
                break;
            case 2:
                accessMenu();
                break;
            default:
                System.out.println("Por favor digite um opção válida");
                acccessSellerMenu();
        }

    }
    public boolean deleteAProduct(){
        System.out.println("Informe o id de identificação do produto: ");
        int idProduct = scanner.nextInt();
        return managerUseCase.deleteProduct(idProduct);
    }
}