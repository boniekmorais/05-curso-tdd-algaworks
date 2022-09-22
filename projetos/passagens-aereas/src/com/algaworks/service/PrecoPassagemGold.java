package com.algaworks.service;

import com.algaworks.model.Voo;

public class PrecoPassagemGold implements CalculadoraPrecoPassagem {

    @Override
    public double calcular(Voo voo) {
        double preco = voo.getPreco();
        return preco > 500.0 ?  calcularValorAcimaLimite(preco) : calcularValorAbaixoLimite(preco);
    }

    private double calcularValorAbaixoLimite(double preco) {
        return preco * 0.90;
    }

    private double calcularValorAcimaLimite(double preco) {
        return preco * 0.85;
    }
}
