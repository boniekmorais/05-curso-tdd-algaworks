package com.algaworks.camelcase01.test;

import com.algaworks.camelcase01.main.CamelCaseConverter;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class CamelCaseConverterTest {

    private CamelCaseConverter camelCase;

    @Before
    public void setup() {
        camelCase = new CamelCaseConverter();
    }

    @Test
    public void deveCriarObjetoCamelCaseConverter() throws Exception {
    }

    @Test
    public void aplicarCamelCaseEmNomeUnico() throws Exception {
        assertEquals("Boniek", camelCase.converter("boniek"));
    }

    @Test
    public void deveConverterNomeSimplesMisturadoMaiusculoEMinusculo() throws Exception {
        assertEquals("Boniek", camelCase.converter("bOnIeK"));
    }

}
