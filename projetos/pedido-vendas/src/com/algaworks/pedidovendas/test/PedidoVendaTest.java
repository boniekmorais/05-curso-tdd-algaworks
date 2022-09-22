package com.algaworks.pedidovendas.test;

import com.algaworks.pedidovendas.main.ResumoPedido;

import com.algaworks.pedidovendas.main.exception.QuantidadeItensInvalidaException;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PedidoVendaTest {

    private PedidoBuilder pedido;

    @Before
    public void setup() {
        pedido = new PedidoBuilder();
    }

    @Test
    public void deveCriarUmPedido() throws Exception {
    }

    @Test
    public void devePermitirAdicionarItemNoPedido() throws Exception {
        pedido.withItem("Impressora", 500.0, 3);
    }

    @Test
    public void deveCalcularValorTotalParaPedidoVazio() throws Exception {
        assertEquals(0.0, pedido.build().resumo().getValorTotal(), 0001);
    }

    @Test
    public void deveCalcularValorTotalEDescontoParaPedidoVazio() throws Exception {
        double valorTotal = 0.0;
        double valorDesconto = 0.0;
        assertResumoPedido(valorTotal, valorDesconto);
    }

    @Test
    public void deveCalcularResumoParaUmItemSemDesconto() throws Exception {
        pedido.withItem("Mouse USB", 50.0, 1);
        assertResumoPedido(50.0, 0.0);
    }

    @Test
    public void deveCalcularResumoParaDoisItensSemDesconto() throws Exception {

        pedido.withItem("Pendrive 16GB", 15.0, 2)
                .withItem("Pendrive 8GB", 10.0, 1);

        assertResumoPedido(40.0, 0.0);
    }

    // Acima de 300 reais, 4% de desconto.
    @Test
    public void deveAplicarDescontoPrimeiraFaixa() throws Exception {
        pedido.withItem("Pendrive 32GB", 30.0, 12);
        assertResumoPedido(360.0, 14.4);
    }

    // Acima de 800 reais, 6% de desconto.
    @Test
    public void deveAplicarDescontoSegundaFaixa() throws Exception {
        pedido.withItem("Pendrive 32GB", 30.0, 30);
        assertResumoPedido(900.0, 54.0);
    }

    // Acima de 1000 reais, 8% de desconto.
    @Test
    public void deveAplicarDescontoTerceiraFaixa() throws Exception {
        pedido.withItem("Pendrive 32GB", 30.0, 50);
        assertResumoPedido(1500.0, 120.0);
    }

    @Test(expected = QuantidadeItensInvalidaException.class)
    public void naoAceitarItensComQuantidadeNegativa() {
        pedido.withItem("Produto", 0.0, -10);
    }

    @Test
    public void naoAceitarItensComQuantidadeNegativa2() {

        try {
            pedido.withItem("Produto", 0.0, -10);
            fail("Deveria ter lançado uma exceção.");
        } catch (QuantidadeItensInvalidaException ex) {
            String message = ex.getMessage();
            assertEquals("Quantidade negativa!", message);
        }
    }

    private void assertResumoPedido(double valorTotal, double valorDesconto) {
        ResumoPedido resumoPedido = pedido.build().resumo();
        assertEquals(valorTotal, resumoPedido.getValorTotal(), 0001);
        assertEquals(valorDesconto, resumoPedido.getValorDesconto(), 0001);
    }

}
