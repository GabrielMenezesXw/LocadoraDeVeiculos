package br.com.fundatec.locadoraveiculo.model;

import br.com.fundatec.locadoraveiculo.enums.TipoDocumento;
import br.com.fundatec.locadoraveiculo.enums.TipoPessoa;

public class Cliente {
    private TipoPessoa tipoPessoa;
    private String nome;
    private long documento;
    private TipoDocumento tipoDocumento;
    private String razaoSocial;
    private Long cnpj;
    private Endereco endereco;

    public Cliente(String nome, Long documento, TipoDocumento tipoDocumento, Endereco endereco) {
        this.tipoPessoa = TipoPessoa.FISICA;
        this.nome = nome;
        this.documento = documento;
        this.tipoDocumento = tipoDocumento;
        this.endereco = endereco;
    }

    public Cliente(String razaoSocial, Long cnpj, Endereco endereco) {
        this.tipoPessoa = TipoPessoa.JURIDICA;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public TipoPessoa getTipoPessoa() {
        return tipoPessoa;
    }

    public long getDocumento() {
        return documento;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public long getCnpj() {
        return cnpj;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    @Override
    public String toString() {
        if (tipoPessoa.equals((TipoPessoa.FISICA))) {
            return "Cliente{" + "nome = '" + nome + '\'' + ", tipoDocumento = " + tipoDocumento + ", documento = "
                    + documento + ", endereco = " + endereco.getLogradouro() + ", " + endereco.getNumero() + ", " +
                    endereco.getComplemento() + ", " + endereco.getBairro() + ", " + endereco.getCidade() + ", "
                    + endereco.getUf() + ", " + endereco.getCep() + '}';
        } else if (tipoPessoa.equals(TipoPessoa.JURIDICA)) {
            return "Cliente{" + "razaoSocial = " + razaoSocial + ", cnpj = " + cnpj + ", endereco = "
                    + endereco.getLogradouro() + ", " + endereco.getNumero() + ", " + endereco.getComplemento() + ", "
                    + endereco.getBairro() + ", " + endereco.getCidade() + ", " +
                    endereco.getUf() + ", " + endereco.getCep() + '}';
        }
        return null;
    }

}
