package br.com.fundatec.locadoraveiculo.bancodedados;

import br.com.fundatec.locadoraveiculo.model.Cliente;
import java.util.LinkedList;
import java.util.List;

public class ListaClientes {

    private static ListaClientes instancia;
    private List<Cliente> clientes;

    private ListaClientes() {
        this.clientes = new LinkedList<>();
    }

    public static ListaClientes criar() {
        if (instancia == null) {
            instancia = new ListaClientes();
        }
        return instancia;
    }

    public void adicionar(Cliente cliente) {
        this.clientes.add(cliente);
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public Cliente getClienteId(int i) {
        return clientes.get(i);
    }
}
