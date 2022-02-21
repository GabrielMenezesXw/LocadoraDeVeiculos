package br.com.fundatec.locadoraveiculo.model;

import br.com.fundatec.locadoraveiculo.enums.TipoVeiculo;

public class Veiculo {
    String placa;
    String marca;
    String modelo;
    TipoVeiculo tipoVeiculo;
    float kilometragem;
    double valorKmRodado;
    double valorDiaria;

    public Veiculo(String placa, String marca, String modelo, TipoVeiculo tipoVeiculo, float kilometragem,
            double valorKmRodado, double valorDiaria) {
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

    public float getKilometragem() {
        return kilometragem;
    }

    public double getValorKmRodade() {
        return valorKmRodado;
    }

    public double getValorDiaria() {
        return valorDiaria;
    }

    public void atualizarQuilometragem(Float kmAtualVeiculo) {
        this.kilometragem = kmAtualVeiculo;
    }

    public float getQuilometragem() {
        return kilometragem;
    }

    public Double getValorKmRodado() {
        return valorDiaria * kilometragem;
    }

    @Override
    public String toString() {
        return "Veiculo [kilometragem=" + kilometragem + ", marca=" + marca + ", modelo=" + modelo + ", placa=" + placa
                + ", tipoVeiculo=" + tipoVeiculo + ", valorDiaria=" + valorDiaria + ", valorKmRodado=" + valorKmRodado
                + "]";
    }
}
