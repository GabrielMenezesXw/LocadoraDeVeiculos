package br.com.fundatec.locadoraveiculo.tela;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import br.com.fundatec.locadoraveiculo.bancodedados.*;
import br.com.fundatec.locadoraveiculo.model.Cliente;
import br.com.fundatec.locadoraveiculo.model.Endereco;
import br.com.fundatec.locadoraveiculo.enums.TipoDocumento;
import br.com.fundatec.locadoraveiculo.enums.TipoPessoa;

public class TelaClientes {
    ListaClientes listaClientes = ListaClientes.criar();

    Scanner in = new Scanner(System.in);

    public void ImprimirTelaClientes() {
        while (true) {
            int opcao = 0;
            System.out.println("|------Qual tela gostaria de ir------|");
            System.out.println("|-----Opção 1: Cadastrar Clientes----|");
            System.out.println("|------Opção 2: Listar Clientes------|");
            System.out.println("|Opção 0: Retornar ao Menu Principal.|");

            try {
                opcao = in.nextInt();
            } catch (InputMismatchException excecao) {
                in.nextLine();
                opcao = 4;
            }
            switch (opcao) {
                case 1:
                    System.out.println("Cadastro de Clientes");
                    this.cadastrarCliente();
                    break;
                case 2:
                    System.out.println("Lista de Clientes");
                    this.listaClientes();
                    break;
                case 0:
                    System.out.println("Retornando ao menu");
                    return;
                default:
                    System.err.println("Opção inválida, tente novamente.");
            }

        }
    }

    private void cadastrarCliente() {
        String razaoSocial = "null";
        String nome = "null";
        long documento = 0;
        long cnpj = 0;
        System.out.println("Informe o tipo do cliente. Digite uma das opções: FISICA/JURIDICA");
        TipoPessoa tipoPessoa = this.lerTipoPessoa();
        if (tipoPessoa.equals(TipoPessoa.JURIDICA)) {
            System.out.println("Informe o CNPJ");
            cnpj = this.lerLong();
            in.nextLine();
            System.out.println("Informe a razão Social");
            razaoSocial = this.lerString();
        } else if (tipoPessoa.equals(TipoPessoa.FISICA)) {
            System.out.println("Informe o tipo de documento que deseja informar. Digite uma das opções: CPF/RG/CNH");
            TipoDocumento tipoDocumento = this.lerTipoDocumento();
            if (tipoDocumento.equals(TipoDocumento.CPF)) {
                System.out.println("Informe o CPF");
                documento = this.lerLong();
                in.nextLine();
                System.out.println("Informe o nome");
                nome = this.lerString();
            } else if (tipoDocumento.equals(TipoDocumento.RG)) {
                System.out.println("Informe o RG");
                documento = this.lerLong();
                in.nextLine();
                System.out.println("Informe o nome");
                nome = this.lerString();
            } else if (tipoDocumento.equals(TipoDocumento.CNH)) {
                System.out.println("Informe o CNH");
                documento = this.lerLong();
                in.nextLine();
                System.out.println("Informe o nome");
                nome = this.lerString();
            }
            System.out.println("Informe o Endereço.");
            String logradouro = in.nextLine();
            System.out.println("Informe o numero.");
            int numero = this.lerInt();
            in.nextLine();
            System.out.println("Informe o complemento.");
            String complemento = in.nextLine();
            System.out.println("Informe a cidade.");
            String cidade = in.nextLine();
            System.out.println("Informe o bairro.");
            String bairro = in.nextLine();
            System.out.println("Informe o UF.");
            String uf = in.next().toUpperCase();
            System.out.println("Informe o CEP.");
            long cep = in.nextLong();
            Endereco endereco = new Endereco(logradouro, numero, complemento, cidade, bairro, uf, cep);
            if (tipoPessoa.equals(TipoPessoa.JURIDICA)) {
                Cliente cliente = new Cliente(razaoSocial, cnpj, endereco);
                listaClientes.adicionar(cliente);
                System.out.println("Cliente Cadastrado com Sucesso!");

            } else if (tipoPessoa.equals(TipoPessoa.FISICA)) {
                Cliente cliente = new Cliente(nome, documento, tipoDocumento, endereco);
                listaClientes.adicionar(cliente);
                System.out.println("Cliente Cadastrado com Sucesso!");
            }
        }
    }

    private void listaClientes() {
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
    }

    private TipoPessoa lerTipoPessoa() {
        while (true) {
            try {
                String tipoPessoa = in.next();
                return TipoPessoa.valueOf(tipoPessoa.toUpperCase());
            } catch (IllegalArgumentException excecao) {
                System.err.println(
                        "!!!Tipo de veículo inválido. Digite uma das opções válidas. (FISICA, JURIDICA)!!!");
            }
        }
    }

    private TipoDocumento lerTipoDocumento() {
        while (true) {
            try {
                String tipoDocumento = in.next();
                return TipoDocumento.valueOf(tipoDocumento.toUpperCase());
            } catch (IllegalArgumentException excecao) {
                System.err.println(
                        "!!!Tipo de veículo inválido. Digite uma das opções válidas. (CPF, RG, CNH)!!!");
            }
        }
    }

    private String lerString() {
        while (true) {
            try {
                return in.nextLine();
            } catch (IllegalArgumentException excecao) {
                in.nextLine();
                System.err.println("!!!Digite uma opção válida!!!");
            }
        }
    }

    private Long lerLong() {
        while (true) {
            try {
                return in.nextLong();
            } catch (IllegalArgumentException excecao) {
                in.nextLine();
                System.err.println("!!!Digite uma valor válido!!!");
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
