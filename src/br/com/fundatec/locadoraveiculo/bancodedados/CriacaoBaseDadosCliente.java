package br.com.fundatec.locadoraveiculo.bancodedados;

import br.com.fundatec.locadoraveiculo.enums.TipoDocumento;
import br.com.fundatec.locadoraveiculo.enums.TipoVeiculo;
import br.com.fundatec.locadoraveiculo.model.Cliente;

public class CriacaoBaseDadosCliente {

	public static void inicializarBase() {
		cadastrarClientes();
	}

	private static void cadastrarClientes() {
		ListaClientes cadastro = ListaClientes.criar();
		
		cadastro.adicionar(new Cliente("Gabriel", "016.649.852-24", TipoDocumento.CNH, 0f, 5.0, 50.0));
		cadastro.adicionar(new Cliente("Luiz", "043.675.123-52", TipoDocumento.CPF, 0f, 5.0, 50.0));
		cadastro.adicionar(new Cliente("Daniel", "021.526.748-12", TipoDocumento.RG, 0f, 5.0, 50.0));
		cadastro.adicionar(new Cliente("Google", "123.212.252/11", 0f, 5.0, 50.0));
		cadastro.adicionar(new Cliente("Fundatec", "429.520.939/10", 0f, 5.0, 50.0));
		
	}
}


