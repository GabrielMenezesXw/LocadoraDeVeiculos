package br.com.fundatec.locadoraveiculo.tela;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDate;
import br.com.fundatec.locadoraveiculo.bancodedados.*;
import br.com.fundatec.locadoraveiculo.model.*;

public class TelaLocacoes {
    private Scanner in = new Scanner(System.in);
    private ListaVeiculos listaVeiculos = ListaVeiculos.criar();
    // private ListaClientes listaClientes = ListaClientes.criar();

    public void ImprimirTelaLocacoes() {
        // ListaLocacoes listaLocacao = ListaLocacoes.criar();
        while (true) {
            int opcao = 0;
            System.out.println("|---------Qual tela gostaria de ir---------|");
            System.out.println("|------Opção 1: Cadastrar Locações---------|");
            System.out.println("|-----Opção 2: Listar Listar Locações------|");
            System.out.println("|---Opção 0: Retornar ao Menu Principal.---|");
            try {
                opcao = in.nextInt();
            } catch (InputMismatchException excecao) {
                in.nextLine();
                opcao = 4;
            }

            switch (opcao) {
                case 1:
                    System.out.println("Cadastro de Locações");
                    cadastrarLocacao();
                    break;
                case 2:
                    System.out.println("Lista de Locações");
                    listarLocacoes();
                    break;
                case 0:
                    System.out.println("Retornando ao menu");
                    return;
                default:
                    System.out.println("Opção inválida, tente novamente.");
            }
        }
    }

    private Locacao cadastrarLocacao() {
        Veiculo veiculos = selecionarVeiculo();
        Cliente clientes = selecionarCliente();
        System.out.println("Informe a data de locação. (YYYY-MM-DD)");
        String dataLocacao = in.nextLine();
        LocalDate locacaoConvertida = LocalDate.parse(dataLocacao);
        Locacao locacao = new Locacao(clientes, veiculos, locacaoConvertida);
        return locacao;
    }

    private Veiculo selecionarVeiculo() {

        List<Veiculo> veiculos = listaVeiculos.getVeiculos();
        if (veiculos.isEmpty()) {
            System.out.println("Ainda não foram cadastrados Veiculos");
        } else {
            String linha = "%-4s %-7s %-10s %-10s %-6s %-8s %-6s %-6s";
            System.out.println(
                    String.format(linha, "Num", "Placa", "Marca", "Modelo", "Tipo", "Km", "Valor Km", "Valor Diária"));
            for (int i = 1; i <= veiculos.size(); i++) {
                Veiculo veiculo = veiculos.get(i - 1);
                System.out.println(String.format(linha,
                        i,
                        veiculo.getPlaca(),
                        veiculo.getMarca(),
                        veiculo.getModelo(),
                        veiculo.getTipoVeiculo(),
                        veiculo.getKilometragem(),
                        veiculo.getValorKmRodado(),
                        veiculo.getValorDiaria()));
            }
        }
        System.out.println("Selecione um veículo.");
        int veiculo = in.nextInt();
        listaVeiculos.getVeiculoId(veiculo);
        return veiculos.get(veiculo);
    }

    private Cliente selecionarCliente() {
        ListaClientes listaClientes = ListaClientes.criar();
        List<Cliente> clientes = listaClientes.getClientes();
        if (clientes.isEmpty()) {
            System.out.println("Ainda não foram cadastrados clientes");
        } else {
            String linha = "%-4s %-7s %-10s %-10s %-6s %-8s %-6s %-6s";
            System.out.println(
                    String.format(linha, "Num", "Nome", "Tipo Documento", "Número documento", "CNPJ", "Razão Social",
                            "Endereço"));
            for (int i = 1; i <= clientes.size(); i++) {
                Cliente cliente = clientes.get(i - 1);
                System.out.println(String.format(linha,
                        i,
                        cliente.getNome(),
                        cliente.getTipoDocumento(),
                        cliente.getDocumento(),
                        cliente.getCnpj(),
                        cliente.getRazaoSocial(),
                        cliente.getEndereco()));
            }
        }
        System.out.println("Indique o cliente que realizará a locação.");
        int cliente = in.nextInt();
        listaClientes.getClienteId(cliente);
        return clientes.get(cliente);
    }

    private void listarLocacoes() {
        ListaLocacoes listaLocacoes = ListaLocacoes.criar();
        List<Locacao> locacoes = listaLocacoes.getLocacoes();
        if (locacoes.isEmpty()) {
            System.out.println("Ainda não foram cadastrados locacoes");
        } else {
            for (int i = 1; i <= locacoes.size(); i++) {
                Locacao locacao = locacoes.get(i - 1);
                System.out.println(String.format("(%s) %s", i, locacao));
            }
        }
    }

}
