package br.com.fundatec.locadoraveiculo.tela;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.List;
import br.com.fundatec.locadoraveiculo.model.Veiculo;
import br.com.fundatec.locadoraveiculo.enums.TipoVeiculo;
import br.com.fundatec.locadoraveiculo.bancodedados.*;

public class TelaVeiculos {
    private ListaVeiculos listaVeiculos = ListaVeiculos.criar();

    Scanner in = new Scanner(System.in);

    public void ImprimirTelaVeiculos() {
        while (true) {
            int opcao = 0;
            System.out.println("|---------Qual tela gostaria de ir----------|");
            System.out.println("|--------Opção 1: Cadastrar Veículo---------|");
            System.out.println("|------Opção 2: Listar Listar Veículos------|");
            System.out.println("|----Opção 0: Retornar ao Menu Principal----|");

            try {
                opcao = in.nextInt();
            } catch (InputMismatchException excecao) {
                in.nextLine();
                opcao = 4;
            }
            switch (opcao) {
                case 1:
                    System.out.println("Cadastro de Veículos");
                    this.cadastrarVeiculo();

                    break;
                case 2:
                    System.out.println("Lista de Veículos");
                    this.listaVeiculos();
                    break;
                case 0:
                    System.out.println("Retornando ao menu");
                    MenuPrincipal menu = new MenuPrincipal();
                    menu.ImprimirMenu();
                    return;
                default:
                    System.out.println("Opção inválida, tente novamente.");
            }
        }
    }

    private void cadastrarVeiculo() {
        System.out.println("Digite a placa:");        
        String placa =this.lerString();
        System.out.println("Digite a marca:");
        String marca =this.lerString();
        System.out.println("Digite o modelo:");
        String modelo =this.lerString();
        System.out.println("Informe o Tipo de veículo. Digite uma das opções: HATCH, SEDAN, SUV, PICKUP");
        TipoVeiculo tipoVeiculo = this.lerTipoVeiculo();
        System.out.println("Digite a kilometragem:");
        float kilometragem = this.lerFloat();
        in.nextLine();
        System.out.println("Digite o Valor de Km Rodados:");
        double valorKmRodado = this.lerDouble();
        System.out.println("Digite o valor da diária:");
        double valorDiaria = this.lerDouble();
        Veiculo veiculo = new Veiculo(placa, marca, modelo, tipoVeiculo, kilometragem, valorKmRodado, valorDiaria);
        listaVeiculos.adicionar(veiculo);
    }

    private void listaVeiculos() {
        ListaVeiculos listaVeiculos = ListaVeiculos.criar();
        List<Veiculo> veiculos = listaVeiculos.getVeiculos();
        if (veiculos.isEmpty()) {
            System.out.println("Ainda não foram cadastrados Veiculos");
        } else {
            for (int i = 1; i <= veiculos.size(); i++) {
                Veiculo veiculo = veiculos.get(i - 1);
                System.out.println(String.format("(%s) %s", i, veiculo));
            }
        }
    }
    private TipoVeiculo lerTipoVeiculo() {
        while (true) {
            try {
                 String tipoVeiculo = in.next();
                return TipoVeiculo.valueOf(tipoVeiculo.toUpperCase());
            } catch (IllegalArgumentException excecao) {
                System.out.println(
                        "!!!Tipo de veículo inválido. Digite uma das opções válidas. (HATCH, SEDAN, SUV, PICKUP)!!!");
            }
        }
    }  

    private double lerDouble() {
        while (true) {
            try {
                return in.nextDouble();
            } catch (IllegalArgumentException excecao) {
                in.nextLine();
                System.out.println("!!!Digite um valor válido!!!");
            }
        }
    }

    private String lerString(){
        while (true) {
            try {
                return in.next();
            } catch (IllegalArgumentException excecao) {
                in.nextLine();
                System.out.println("!!!Digite uma opção válida!!!");
            }
        }
    }
    private float lerFloat(){
        while (true) {
            try {
                return in.nextFloat();
            } catch (IllegalArgumentException excecao) {
                in.nextLine();
                System.out.println("!!!Digite uma valor válido!!!");
            }
        }
    }    
 
}

   