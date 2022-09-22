package com.algaworks.pedidovendas.main.desconto;

public class SegundaFaixa extends FaixaDesconto {

    public SegundaFaixa(FaixaDesconto proximo) {
        super(proximo);
    }

    @Override
    public double calcular(double valorTotal) {

        if (valorTotal > 800.0 && valorTotal <= 1000.0) {
            return valorTotal * 0.06;
        }

        return -1;
    }
}
