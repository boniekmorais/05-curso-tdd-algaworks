package com.algaworks.pedidovendas.main.desconto;

public abstract class FaixaDesconto {

    private FaixaDesconto proximo;

    public FaixaDesconto(FaixaDesconto proximo) {
        this.proximo = proximo;
    }

    public double desconto(double valorTotal) {
        double desconto = calcular(valorTotal);

        if (desconto == -1) {
            return proximo.desconto(valorTotal);
        }

        return desconto;
    }

    public abstract double calcular(double valorTotal);

}
