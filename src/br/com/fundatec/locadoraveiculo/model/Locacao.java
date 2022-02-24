package br.com.fundatec.locadoraveiculo.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

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

    public BigDecimal getValor() {
        return valor;
    }

    public void encerrar(Float kmAtual, LocalDate dataEntrega) {
        // Trocar situação para encerrada
        this.situacao = SituacaoLocacao.ENCERRADA;
        // Calcular valor da locação - Retorna calculo dos dias
        Long numeroDiarias = ChronoUnit.DAYS.between(dataLocacao, dataEntrega);
        numeroDiarias = numeroDiarias + 1;
        this.dataEntrega = dataEntrega;
        Float diferencaKm = kmAtual.floatValue() - veiculo.getKilometragem().floatValue();

        BigDecimal diarias = new BigDecimal(numeroDiarias);
        System.out.println("diarias........: " + diarias);
        BigDecimal valorDiaria = new BigDecimal(veiculo.getValorDiaria().toString());
        System.out.println("valor diaria...: " + valorDiaria);
        BigDecimal km = new BigDecimal(diferencaKm.toString());
        System.out.println("KM.............: " + km);
        BigDecimal valorKm = new BigDecimal(veiculo.getValorKmRodado());
        System.out.println("Valor KM.......: " + valorKm);
        BigDecimal part1 = diarias.multiply(valorDiaria);
        System.out.println("mult1..........: " + part1);
        BigDecimal part2 = km.multiply(valorKm);
        System.out.println("mult2..........: " + part2);
        BigDecimal result = part1.add(part2);
        System.out.println("result..........: " + result);

        this.valor = result;
        // Atualizar a kilometragem do veículo.
        veiculo.alterarKilometragem(kmAtual);
    }

    @Override
    public String toString() {
        return "Locacao [cliente=" + cliente + ", dataEntrega=" + dataEntrega + ", dataLocacao=" + dataLocacao
                + ", situacao=" + situacao + ", valor=" + valor + ", veiculo=" + veiculo + "]";
    }
}
