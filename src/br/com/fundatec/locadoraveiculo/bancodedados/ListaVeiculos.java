package br.com.fundatec.locadoraveiculo.bancodedados;

import br.com.fundatec.locadoraveiculo.model.Veiculo;

import java.util.LinkedList;
import java.util.List;

public class ListaVeiculos {

    private static ListaVeiculos instancia;
    private List<Veiculo> veiculos;

    private ListaVeiculos() {
        this.veiculos = new LinkedList<>();
    }

    public static ListaVeiculos criar() {
        if (instancia == null) {
            instancia = new ListaVeiculos();
        }
        return instancia;
    }

    public void adicionar(Veiculo veiculo) {
        this.veiculos.add(veiculo);
    }

    public List<Veiculo> getVeiculos() {
        return veiculos;
    }

    public Veiculo getVeiculoId(int i) {
        return veiculos.get(i);
    }
}