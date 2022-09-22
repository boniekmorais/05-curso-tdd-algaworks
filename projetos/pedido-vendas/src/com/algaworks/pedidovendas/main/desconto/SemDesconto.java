package com.algaworks.pedidovendas.main.desconto;

public class SemDesconto extends FaixaDesconto {

    public SemDesconto(FaixaDesconto proximo) {
        super(proximo);
    }

    @Override
    public double calcular(double valorTotal) {
        return 0;
    }
}
