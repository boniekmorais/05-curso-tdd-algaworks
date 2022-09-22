package com.algaworks.pedidovendas.main.desconto;

public class TerceiraFaixa extends FaixaDesconto {

    public TerceiraFaixa(FaixaDesconto proximo) {
        super(proximo);
    }

    @Override
    public double calcular(double valorTotal) {

        if (valorTotal > 1000.0) {
            return  valorTotal * 0.08;
        }

        return -1;
    }
}
