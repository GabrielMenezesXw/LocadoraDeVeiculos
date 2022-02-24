package br.com.fundatec.locadoraveiculo.bancodedados;

import br.com.fundatec.locadoraveiculo.model.Locacao;
import java.util.LinkedList;
import java.util.List;

public class ListaLocacoes {

    private static ListaLocacoes instancia;
    private List<Locacao> locacoes;

    private ListaLocacoes() {
        this.locacoes = new LinkedList<>();
    }

    public static ListaLocacoes criar() {
        if (instancia == null) {
            instancia = new ListaLocacoes();
        }
        return instancia;
    }

    public void adicionar(Locacao locacao) {
        this.locacoes.add(locacao);
    }

    public List<Locacao> getLocacoes() {
        return locacoes;
    }

    public Locacao getLocacaoId(int i) {
        return locacoes.get(i);
    }
}
