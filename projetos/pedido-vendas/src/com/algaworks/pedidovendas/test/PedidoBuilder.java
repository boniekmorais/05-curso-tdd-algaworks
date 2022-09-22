package com.algaworks.pedidovendas.test;

import com.algaworks.pedidovendas.main.ItemPedido;
import com.algaworks.pedidovendas.main.Pedido;
import com.algaworks.pedidovendas.main.desconto.*;

public class PedidoBuilder {

    private Pedido instancia;

    public PedidoBuilder() {
        FaixaDesconto faixaDesconto = new TerceiraFaixa(new SegundaFaixa(new PrimeiraFaixa(new SemDesconto(null))));
        instancia = new Pedido(faixaDesconto);
    }

    public PedidoBuilder withItem(String descricao, double valor, int quantidade) {
        instancia.adicionarItem(new ItemPedido(descricao, valor, quantidade));
        return this;
    }

    public Pedido build() {
        return instancia;
    }
}
