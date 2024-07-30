package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class CalculadorCombustibleTest {

    @Test
    void calcularCombustibleReturnaValorCorrectoAvionComercial() {
        Avion comercial = mock(Avion.class);
        when(comercial.volar(200)).thenReturn(1000);
        CalculadorCombustible calculador = CalculadorCombustible.getInstance();
        int resultado = calculador.calcularCombustible(comercial, 200);
        assertEquals(1000, resultado);
    }

    @Test
    void calcularCombustibleReturnaValorCorrectoAvionPrivado() {
        Avion privado = mock(Avion.class);
        when(privado.volar(50)).thenReturn(250);
        CalculadorCombustible calculador = CalculadorCombustible.getInstance();
        int resultado = calculador.calcularCombustible(privado, 50);
        assertEquals(250, resultado);
    }

    @Test
    public void getInstanceRetornaMismaInstancia() {
        CalculadorCombustible calculadorCombustible = CalculadorCombustible.getInstance();
        CalculadorCombustible calculadorCombustible2 = CalculadorCombustible.getInstance();
        assertEquals(calculadorCombustible, calculadorCombustible2);
    }
}