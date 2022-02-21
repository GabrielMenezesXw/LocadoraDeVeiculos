package br.com.fundatec.locadoraveiculo.tela;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuPrincipal {
    public void ImprimirMenu() {
        Scanner in = new Scanner(System.in);
        while (true) {
            int opcao = 0;
            System.out.println("|-------------Qual tela gostaria de ir-------------|");
            System.out.println("|-------Opção 1: Apresentar tela de veículos-------|");
            System.out.println("|--------Opção 2: Apresentar Tela Clientes.--------|");
            System.out.println("|------Opção 3: Apresentar Tela de locações.-------|");
            System.out.println("|-----------Opção 0: Encerrar Programa.------------|");

            try {
                opcao = in.nextInt();
            } catch (InputMismatchException excecao) {
                in.nextLine();
                opcao = 4;
            }

            switch (opcao) {
                case 1:
                    System.out.println("Navegar para tela de veículos");
                    TelaVeiculos telaVeiculo = new TelaVeiculos();
                    telaVeiculo.ImprimirTelaVeiculos();
                    break;
                case 2:
                    System.out.println("Navegar para tela de clientes");
                    TelaClientes telaCliente = new TelaClientes();
                    telaCliente.ImprimirTelaClientes();
                    break;
                case 3:
                    System.out.println("Navegar para a tela de locações");
                    TelaLocacoes telaLocacao = new TelaLocacoes();
                    telaLocacao.ImprimirTelaLocacoes();
                    break;
                case 0:
                    System.out.println("Encerrando programa");
                    in.close();
                    return;
                default:
                    System.out.println("Opcão inválida, tente novamente.");
            }            
        }        
    }
}
