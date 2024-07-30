package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AvionPrivadoTest {

    @Test
    void volarRetornaCombustibleNecesarioCorrecto() {
        AvionPrivado avion = new AvionPrivado(1000, 5);
        int resultado = avion.volar(100);
        assertEquals(1000, resultado);
    }

    @Test
    void volarRetornaConsumoSinDistancia() {
        AvionPrivado avion = new AvionPrivado(1000, 5);
        int resultado = avion.volar(0);
        assertEquals(500, resultado);
    }

    @Test
    void getCapacidadCombustibleRetornaValorCorrecto() {
        AvionPrivado avion = new AvionPrivado(1000, 5);
        assertEquals(1000, avion.getCapacidadCombustible());
    }

    @Test
    void getConsumoCombustibleRetornaValorCorrecto() {
        AvionPrivado avion = new AvionPrivado(1000, 5);
        assertEquals(5, avion.getConsumoCombustible());
    }
}