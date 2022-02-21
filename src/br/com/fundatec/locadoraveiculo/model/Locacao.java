package br.com.fundatec.locadoraveiculo.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.fundatec.locadoraveiculo.enums.SituacaoLocacao;

public class Locacao {
    private Cliente cliente;
    private Veiculo veiculo;
    private LocalDate dataLocacao;
    private LocalDate dataEntrega;
    private BigDecimal valor;
    private SituacaoLocacao situacao;

    public Locacao(Cliente cliente, Veiculo veiculo, LocalDate dataLocacao) {
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.dataLocacao = dataLocacao;
        this.situacao = SituacaoLocacao.ATIVA;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public LocalDate getDataLocacao() {
        return dataLocacao;
    }

    public SituacaoLocacao getSituacao() {
        return situacao;
    }

    @Override
    public String toString() {
        return "Locacao [cliente=" + cliente + ", dataEntrega=" + dataEntrega + ", dataLocacao=" + dataLocacao
                + ", situacao=" + situacao + ", valor=" + valor + ", veiculo=" + veiculo + "]";
    }
}
