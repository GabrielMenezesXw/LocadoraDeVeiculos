package br.com.fundatec.locadoraveiculo.tela;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import br.com.fundatec.locadoraveiculo.bancodedados.*;
import br.com.fundatec.locadoraveiculo.enums.*;
import br.com.fundatec.locadoraveiculo.model.*;

public class TelaLocacoes {
    private Scanner in = new Scanner(System.in);
    private ListaVeiculos listaVeiculos = ListaVeiculos.criar();
    private ListaClientes listaClientes = ListaClientes.criar();
    ListaLocacoes listaLocacao = ListaLocacoes.criar();

    public void ImprimirTelaLocacoes() {

        while (true) {
            int opcao = 0;
            System.out.println("|---------Qual tela gostaria de ir---------|");
            System.out.println("|-------Opção 1: Cadastrar Locações--------|");
            System.out.println("|-------Opção 2: Encerrar Locações---------|");
            System.out.println("|--------Opção 3: Listar Locações----------|");
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
                    System.out.println("Encerrar de Locações");
                    encerrarLocacao();
                    break;
                case 3:
                    System.out.println("Lista de Locações");
                    listarLocacoes();
                    break;
                case 0:
                    System.out.println("Retornando ao menu");
                    return;
                default:
                    System.err.println("Opção inválida, tente novamente.");
            }
        }
    }

    private void cadastrarLocacao() {
        Veiculo veiculos = selecionarVeiculo();
        Cliente clientes = selecionarCliente();
        System.out.println("Informe a data de locação. (YYYY-MM-DD)");
        LocalDate dataLocacao = this.lerLocalDate();
        Locacao locacao = new Locacao(clientes, veiculos, dataLocacao);
        listaLocacao.adicionar(locacao);

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
        int veiculo = this.lerInt();
        return listaVeiculos.getVeiculoId(veiculo - 1);
    }

    private Cliente selecionarCliente() {
        List<Cliente> clientes = listaClientes.getClientes();
        if (clientes.isEmpty()) {
            System.out.println("Ainda não foram cadastrados clientes");
        } else {
            String linha = "%-4s %-8s %-30s %-4s %-22s %s";
            System.out.println(String.format(linha, "Num", "Tipo", "Nome/Razão Social", "Doc", "Num Doc", "Endereco"));
            for (int i = 1; i <= clientes.size(); i++) {
                Cliente cliente = clientes.get(i - 1);
                System.out.println(String.format(linha,
                        i,
                        cliente.getTipoPessoa(),
                        TipoPessoa.FISICA.equals(cliente.getTipoPessoa()) ? cliente.getNome()
                                : cliente.getRazaoSocial(),
                        TipoPessoa.FISICA.equals(cliente.getTipoPessoa()) ? cliente.getTipoDocumento() : "CNPJ",
                        cliente.getDocumentoFormatado(),
                        cliente.getEndereco()));
            }
        }
        System.out.println("Indique o cliente que realizará a locação.");
        int cliente = this.lerInt();
        System.out.println("Cliente Selecionado com sucesso!!");
        return listaClientes.getClienteId(cliente - 1);
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

    private Locacao selecionarLocacoes() {
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
        System.out.println("Selecione uma Locação.");
        int locacao = in.nextInt();
        return listaLocacoes.getLocacaoId(locacao - 1);
    }

    private void encerrarLocacao() {
        System.out.println("Informe a locação que deseja encerrar.");
        Locacao locacao = this.selecionarLocacoes();
        if(locacao.getSituacao() == SituacaoLocacao.ENCERRADA){
            System.out.println("A locação em questão já foi cancelada");
        }else{
        System.out.println("Informe a data de entrega (AAAA-MM-DD).");
        LocalDate dataEntrega = this.lerLocalDateEntrega();
        System.out.println("Informe a kilometragem atual do veículo.");
        Float kmAtual = in.nextFloat();
        in.nextLine();
        locacao.encerrar(kmAtual, dataEntrega);
        BigDecimal custo = locacao.getValor();
        System.out.println("Valor total da locação = R$ " + custo);
        return;
        }
    }

    private LocalDate lerLocalDateEntrega() {
        while (true) {
            try {
                String dataEntrega = in.next();
                return LocalDate.parse(dataEntrega);
            } catch (DateTimeParseException excecao) {
                in.nextLine();
                System.err.println("!!!Digite uma data válida!!!");

            }
        }
    }

    private LocalDate lerLocalDate() {
        while (true) {
            try {
                String dataLocacao = in.next();
                return LocalDate.parse(dataLocacao);
            } catch (DateTimeParseException excecao) {
                in.nextLine();
                System.err.println("!!!Digite uma data válida!!!");
            }
        }
    }

    private int lerInt() {
        while (true) {
            try {
                return in.nextInt();
            } catch (IllegalArgumentException excecao) {
                in.nextLine();
                System.err.println("!!!Digite uma valor válido!!!");
            }
        }
    }
}
