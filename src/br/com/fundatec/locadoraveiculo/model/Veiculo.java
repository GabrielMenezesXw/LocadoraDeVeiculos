package br.com.fundatec.locadoraveiculo.model;

import br.com.fundatec.locadoraveiculo.enums.TipoVeiculo;

public class Veiculo {
    private String placa;
    private String marca;
    private String modelo;
    private TipoVeiculo tipoVeiculo;
    private Float kilometragem;
    private Double valorKmRodado;
    private Double valorDiaria;

    public Veiculo(String placa, String marca, String modelo, TipoVeiculo tipoVeiculo, Float kilometragem,
            Double valorKmRodado, Double valorDiaria) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.tipoVeiculo = tipoVeiculo;
        this.kilometragem = kilometragem;
        this.valorKmRodado = valorKmRodado;
        this.valorDiaria = valorDiaria;

    }

    public String getPlaca() {
        return placa;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public TipoVeiculo getTipoVeiculo() {
        return tipoVeiculo;
    }

    public Float getKilometragem() {
        return kilometragem;
    }

    public Double getValorKmRodado() {
        return valorKmRodado;
    }

    public Double getValorDiaria() {
        return valorDiaria;
    }

    public void atualizarQuilometragem(Float kmAtualVeiculo) {
        this.kilometragem = kmAtualVeiculo;
    }

    public Float getQuilometragem() {
        return kilometragem;
    }

    public void alterarKilometragem(Float kmAtual) {
        this.kilometragem = kmAtual;
    }

    @Override
    public String toString() {
        return "Veiculo [kilometragem=" + kilometragem + ", marca=" + marca + ", modelo=" + modelo + ", placa=" + placa
                + ", tipoVeiculo=" + tipoVeiculo + ", valorDiaria=" + valorDiaria + ", valorKmRodado=" + valorKmRodado
                + "]";
    }
}
