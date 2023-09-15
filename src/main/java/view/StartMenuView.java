package view;

import java.util.Scanner;

public class StartMenuView {
    Scanner scanner= new Scanner(System.in);
    ManagerView managerView  = new ManagerView();
    SellerView sellerView = new SellerView();
    public void startMenu(){
        System.out.println("Bem vindo(a)! ");
        System.out.println("Informe sua área de atuação: \n\t1- Vendas\t2- Gerência\t0- Sair do sistema");
        int choicePosition = scanner.nextInt();

        switch (choicePosition){
            case 1:
                if (sellerView.loginSeller()){
                    sellerView.accessMenu();
                }else {
                    System.out.println("Não foi possível iniciar o sistema.");
                    startMenu();
                }
                break;
            case 2:
                if (managerView.loginManager()){
                    managerView.accessMenu();
                }else{
                    System.out.println("Não foi possível inciar o sistema");
                    startMenu();
                }
                break;
            case 0:
                System.out.println("Encerrando...");
                System.exit(0);
                break;
            default:
                scanner.nextLine();
                System.out.println("Opção inválida");
                startMenu();
        }
    }
}
