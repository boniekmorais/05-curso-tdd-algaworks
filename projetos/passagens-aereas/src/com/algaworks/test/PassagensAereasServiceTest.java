package com.algaworks.test;

import com.algaworks.model.Passageiro;
import com.algaworks.model.TipoPassageiro;
import com.algaworks.model.Voo;
import com.algaworks.service.PrecoPassagemService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PassagensAereasServiceTest {

    private PrecoPassagemService precoPassagemService;

    @Before
    public void setup() {
        precoPassagemService = new PrecoPassagemService();
    }

    @Test
    public void deveCalcularValorPassagemPassageiroGoldValorAbaixoLimite() throws Exception {
        PrecoPassagemService precoPassagemService = new PrecoPassagemService();
        Passageiro passageiro = new Passageiro("John Doe", TipoPassageiro.GOLD);
        Voo voo = new Voo("São Paulo", "Rio de Janeiro", 100.0);
        assertValorPassagem(90.0, passageiro, voo);
    }

    @Test
    public void deveCalcularValorPassagemPassageiroGoldValorAcimaLimite() throws Exception {
        PrecoPassagemService precoPassagemService = new PrecoPassagemService();
        Passageiro passageiro = new Passageiro("John Doe", TipoPassageiro.GOLD);
        Voo voo = new Voo("São Paulo", "Rio de Janeiro", 600.0);
        assertValorPassagem(510.0, passageiro, voo);
    }

    @Test
    public void deveCalcularValorPassagemPassageiroSilverValorAbaixoLimite() throws Exception {
        PrecoPassagemService precoPassagemService = new PrecoPassagemService();
        Passageiro passageiro = new Passageiro("John Doe", TipoPassageiro.SILVER);
        Voo voo = new Voo("São Paulo", "Rio de Janeiro", 100.0);
        assertValorPassagem(94.0, passageiro, voo);
    }

    @Test
    public void deveCalcularValorPassagemPassageiroSilverValorAcimaLimite() throws Exception {
        PrecoPassagemService precoPassagemService = new PrecoPassagemService();
        Passageiro passageiro = new Passageiro("John Doe", TipoPassageiro.SILVER);
        Voo voo = new Voo("São Paulo", "Rio de Janeiro", 800.0);
        assertValorPassagem(720.0, passageiro, voo);
    }

    private void assertValorPassagem(double valorEsperado, Passageiro passageiro, Voo voo) {
        double valorObtido = precoPassagemService.calcular(passageiro, voo);
        Assert.assertEquals(valorEsperado, valorObtido, 0.0001);
    }
}
