package com.algaworks.pedidovendas.main;

import com.algaworks.pedidovendas.main.desconto.FaixaDesconto;
import com.algaworks.pedidovendas.main.exception.QuantidadeItensInvalidaException;

import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private final List<ItemPedido> itens = new ArrayList<>();
    private final FaixaDesconto faixaDesconto;

    public Pedido(FaixaDesconto faixaDesconto) {
        this.faixaDesconto = faixaDesconto;
    }

    public void adicionarItem(ItemPedido item) {

        if (item.getQuantidade() < 0) {
            throw new QuantidadeItensInvalidaException("Quantidade negativa!");
        }

        itens.add(item);
    }

    public ResumoPedido resumo() {

        double valorTotal = itens.stream().mapToDouble(i -> i.getValor() * i.getQuantidade()).sum();
        double valorDesconto = faixaDesconto.desconto(valorTotal);

        return new ResumoPedido(valorTotal, valorDesconto);
    }

}
