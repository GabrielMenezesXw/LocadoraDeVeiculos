package br.com.fundatec.locadoraveiculo.model;

import java.text.ParseException;

import javax.swing.text.MaskFormatter;

import br.com.fundatec.locadoraveiculo.enums.TipoDocumento;
import br.com.fundatec.locadoraveiculo.enums.TipoPessoa;

public class Cliente {
    private TipoPessoa tipoPessoa;
    private String nome;
    private Long documento;
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

    public Long getDocumento() {
        return documento;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public Long getCnpj() {
        return cnpj;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public String getDocumentoFormatado() {
        String retorno = null;
        MaskFormatter mask = null;
        try {
            if (TipoDocumento.CPF.equals(tipoDocumento)) {
                retorno = String.format("%011d", documento);
                mask = new MaskFormatter("###.###.###-##");
            } else if (TipoPessoa.JURIDICA.equals(tipoPessoa)) {
                retorno = String.format("%014d", cnpj);
                mask = new MaskFormatter("##.###.###/####-##");
            }
            if (retorno != null) {
                mask.setValueContainsLiteralCharacters(false);
                return mask.valueToString(retorno);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return documento.toString();
    }

    @Override
    public String toString() {
        if (tipoPessoa.equals((TipoPessoa.FISICA))) {
            return "Cliente{" + "nome = " + nome + ", tipoDocumento = " + tipoDocumento + ", documento = "
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
