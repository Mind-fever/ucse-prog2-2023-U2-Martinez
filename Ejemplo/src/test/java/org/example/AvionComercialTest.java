package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AvionComercialTest {

    @Test
    void volarRetornaCombustibleNecesarioCorrecto() {
        AvionComercial avion = new AvionComercial(1000, 5);
        int resultado = avion.volar(100);
        assertEquals(500, resultado);
    }

    @Test
    void volarLargaDistancia() {
        AvionComercial avion = new AvionComercial(1000, 5);
        int resultado = avion.volar(100000);
        assertEquals(500000, resultado);
    }

    @Test
    void getCapacidadCombustibleRetornaValorCorrecto() {
        AvionComercial avion = new AvionComercial(1000, 5);
        assertEquals(1000, avion.getCapacidadCombustible());
    }

    @Test
    void getConsumoCombustibleRetornaValorCorrecto() {
        AvionComercial avion = new AvionComercial(1000, 5);
        assertEquals(5, avion.getConsumoCombustible());
    }
}