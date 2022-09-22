package com.algaworks.pedidovendas.main;

public class ResumoPedido {

    private double valorTotal;
    private double valorDesconto;

    public ResumoPedido(double valorTotal, double valorDesconto) {
        this.valorTotal = valorTotal;
        this.valorDesconto = valorDesconto;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public double getValorDesconto() {
        return valorDesconto;
    }

    public void setValorDesconto(double valorDesconto) {
        this.valorDesconto = valorDesconto;
    }
}
