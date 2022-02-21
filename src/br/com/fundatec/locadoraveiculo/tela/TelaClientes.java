package br.com.fundatec.locadoraveiculo.tela;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import br.com.fundatec.locadoraveiculo.bancodedados.ListaClientes;
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
                    System.out.println("Opção inválida, tente novamente.");
            }

        }
    }

    private void cadastrarCliente() {
        long cnpj = 0;
        String razaoSocial = "NÃO UTILIZADO";
        long documento = 0;
        String nome = "NÃO UTILIZADO";
        TipoDocumento tipoDocumento = TipoDocumento.valueOf("CPF");

        System.out.println("Informe o tipo do cliente. Digite uma das opções: FISICA/JURIDICA");
        TipoPessoa tipoPessoa = TipoPessoa.valueOf(in.next().toUpperCase());
        // try {
        // tipoPessoa = TipoPessoa.valueOf(in.next().toUpperCase());
        // } catch (IllegalArgumentException excecao) {
        // in.nextLine();
        // System.out.println("Opção inválida, tente novamente.");
        // System.out.println("Informe o tipo do cliente. FISICA/JURIDICA");
        // tipoPessoa = TipoPessoa.valueOf(in.next().toUpperCase());
        // } --- NÃO CONSEGUI FAZER FUNCIONAR ESSA EXCEÇÃO
        if (tipoPessoa.equals(TipoPessoa.JURIDICA)) {
            System.out.println("Informe o CNPJ");
            cnpj = in.nextLong();
            in.nextLine();
            System.out.println("Informe a razão Social");
            razaoSocial = in.next();
        } else if (tipoPessoa.equals(TipoPessoa.FISICA)) {
            System.out.println("Informe o tipo de documento que deseja informar. Digite uma das opções: CPF/RG");
            tipoDocumento = TipoDocumento.valueOf(in.next().toUpperCase());
            if (tipoDocumento.equals(TipoDocumento.CPF)) {
                System.out.println("Informe o CPF");
                documento = in.nextLong();
                in.nextLine();
            } else if (tipoDocumento.equals(TipoDocumento.RG)) {
                System.out.println("Informe o RG");
                documento = in.nextLong();
                in.nextLine();
            } else if (tipoDocumento.equals(TipoDocumento.CNH)) {
                System.out.println("Informe o CNH");
                documento = in.nextLong();
                in.nextLine();
                System.out.println("Informe o nome");
                nome = in.nextLine();
            }
            System.out.println("Informe o Endereço.");
            String logradouro = in.nextLine();
            System.out.println("Informe o numero.");
            int numero = in.nextInt();
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
        ListaClientes listaClientes = ListaClientes.criar();
        List<Cliente> clientes = listaClientes.getClientes();
        if (clientes.isEmpty()) {
            System.out.println("Ainda não foram cadastrados clientes");
        } else {
            for (int i = 1; i <= clientes.size(); i++) {
                Cliente cliente = clientes.get(i - 1);
                System.out.println(String.format("(%s) %s", i, cliente));
            }
        }
    }
}
