package br.com.fundatec.locadoraveiculo.bancodedados;

import br.com.fundatec.locadoraveiculo.enums.*;
import br.com.fundatec.locadoraveiculo.model.*;

public class CriacaoBaseDados {

	public static void inicializarBase() {
		cadastrarVeiculos();
		cadastrarClientes();
	}

	private static void cadastrarVeiculos() {
		ListaVeiculos cadastro = ListaVeiculos.criar();
		
		cadastro.adicionar(new Veiculo("ABC0001", "VW", "Gol", TipoVeiculo.HATCH, 0f, 5.0, 50.0));
		cadastro.adicionar(new Veiculo("ABC0002", "Fiat", "Palio", TipoVeiculo.HATCH, 0f, 5.0, 50.0));
		cadastro.adicionar(new Veiculo("ABC0003", "Chevrolet", "Onyx", TipoVeiculo.HATCH, 0f, 5.0, 50.0));
		cadastro.adicionar(new Veiculo("ABC0004", "Toyota", "Etios", TipoVeiculo.HATCH, 0f, 5.0, 50.0));
		cadastro.adicionar(new Veiculo("ABC0005", "Renault", "Sandero", TipoVeiculo.HATCH, 0f, 5.0, 50.0));
		cadastro.adicionar(new Veiculo("ABC0005", "Peugeot", "207", TipoVeiculo.HATCH, 0f, 5.0, 50.0));
		cadastro.adicionar(new Veiculo("ABC0006", "VW", "Virtus", TipoVeiculo.SEDAN, 0f, 7.0, 60.0));
		cadastro.adicionar(new Veiculo("ABC0007", "Fiat", "Siena", TipoVeiculo.SEDAN, 0f, 7.0, 60.0));
		cadastro.adicionar(new Veiculo("ABC0008", "Chevrolet", "Cobalt", TipoVeiculo.SEDAN, 0f, 7.0, 60.0));
		cadastro.adicionar(new Veiculo("ABC0009", "Toyota", "Corolla", TipoVeiculo.SEDAN, 0f, 8.0, 65.0));
		cadastro.adicionar(new Veiculo("ABC0010", "Renault", "Logan", TipoVeiculo.SEDAN, 0f, 7.0, 60.0));
		cadastro.adicionar(new Veiculo("ABC0011", "Jeep", "Compass", TipoVeiculo.SUV, 0f, 11.0, 100.0));
		cadastro.adicionar(new Veiculo("ABC0012", "VW", "T-Cross", TipoVeiculo.SUV, 0f, 11.0, 95.0));
		cadastro.adicionar(new Veiculo("ABC0013", "Hyundai", "Creta", TipoVeiculo.SUV, 0f, 11.0, 95.0));
		cadastro.adicionar(new Veiculo("ABC0014", "Honda", "HRV", TipoVeiculo.SUV, 0f, 11.0, 95.0));
		cadastro.adicionar(new Veiculo("ABC0015", "Ford", "Ranger", TipoVeiculo.PICKUP, 0f, 12.5, 110.0));
		cadastro.adicionar(new Veiculo("ABC0016", "VW", "Amarok", TipoVeiculo.PICKUP, 0f, 12.0, 115.0));
	}
	private static void cadastrarClientes() {
		ListaClientes cadastro = ListaClientes.criar();
		
		cadastro.adicionar(new Cliente("Gabriel", Long.valueOf("100568997") , TipoDocumento.CNH, new Endereco("Rua Silva", 139, "Apto 301", "Lindóia", "Porto Alegre", "RS", Long.valueOf("91039404"))));
		cadastro.adicionar(new Cliente("Luiz", Long.valueOf("01259866384"), TipoDocumento.CPF,  new Endereco("Rua Moura", 223, "Apto 301", "Humaitá", "Porto Alegre", "RS", Long.valueOf("91039404"))));
		cadastro.adicionar(new Cliente("Daniel", Long.valueOf("36985742023"), TipoDocumento.RG, new Endereco("Rua Costa", 1890, "Apto 301", "Centro", "Porto Alegre", "RS", Long.valueOf("91039404"))));
		cadastro.adicionar(new Cliente("Google", Long.valueOf("12321225211"),  new Endereco("Avenida Julho", 20, "Apto 122", "Lindóia", "Porto Alegre", "RS", Long.valueOf("91039404"))));
		cadastro.adicionar(new Cliente("Fundatec", Long.valueOf("42952093910"),  new Endereco("Avenida Cristovão", 930, "Apto 402", "Jardim São Pedro", "Porto Alegre", "RS", Long.valueOf("91039404"))));
		
	}
}
