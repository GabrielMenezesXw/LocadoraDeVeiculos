package br.com.fundatec.locadoraveiculo.model;

public class Endereco {
    String logradouro;
    int numero;
    String complemento;
    String bairro;
    String cidade;
    String uf;
    long cep;
    public Endereco(String logradouro, int numero, String complemento, String bairro, String cidade, String uf, long cep) {
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
    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }
    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public String getComplemento() {
        return complemento;
    }
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    public String getBairro() {
        return bairro;
    }
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
    public String getUf() {
        return uf;
    }
    public void setUf(String uf) {
        this.uf = uf;
    }
    public long getCep() {
        return cep;
    }
    public void setCep(long cep) {
        this.cep = cep;
    }

    @Override
    public String toString() {
        return "Endereco [ cidade= " + cidade + "bairro= " + bairro + ", cep= " + cep + ", complemento= " + complemento + ", logradouro= "
                + logradouro + ", numero= " + numero + ", uf= " + uf + "]";
    }
    
}
