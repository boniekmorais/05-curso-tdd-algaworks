package com.algaworks.pedidovendas.main.desconto;

public class PrimeiraFaixa extends FaixaDesconto {

    public PrimeiraFaixa(FaixaDesconto proximo) {
        super(proximo);
    }

    @Override
    public double calcular(double valorTotal) {

        if (valorTotal > 300.0 && valorTotal <= 800.0) {
            return valorTotal * 0.04;
        }

        return -1;
    }
}
