package br.com.fundatec.locadoraveiculo.model;

public class Endereco {
    private String logradouro;
    private long numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String uf;
    private long cep;

    public Endereco(String logradouro, long numero, String complemento, String bairro, String cidade, String uf,
            long cep) {
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public long getNumero() {
        return numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public String getUf() {
        return uf;
    }

    public long getCep() {
        return cep;
    }

    @Override
    public String toString() {
        return "Endereco [ cidade= " + cidade + "bairro= " + bairro + ", cep= " + cep + ", complemento= " + complemento
                + ", logradouro= "
                + logradouro + ", numero= " + numero + ", uf= " + uf + "]";
    }

}
