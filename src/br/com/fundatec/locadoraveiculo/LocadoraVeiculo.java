package br.com.fundatec.locadoraveiculo;
import br.com.fundatec.locadoraveiculo.bancodedados.CriacaoBaseDados;
import java.util.Scanner;

import br.com.fundatec.locadoraveiculo.tela.MenuPrincipal;

public class LocadoraVeiculo {
    public static void main(String[] args) {
        CriacaoBaseDados.inicializarBase();
        Scanner in = new Scanner(System.in);
        MenuPrincipal menu = new MenuPrincipal();
        menu.ImprimirMenu();
        System.out.println("Encerrando...");
        in.close();
    }
}