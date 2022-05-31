package es.iespuerto.ets;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class CapitalizarCadenasTest {
    CapitalizarCadenas cadenaSimple = null;
    CapitalizarCadenas cadenaCompuesta2 = null;
    CapitalizarCadenas cadenaCompuesta3 = null;
    CapitalizarCadenas cadenaCompuesta4 = null;
    CapitalizarCadenas cadenaCompuestaExtrema = null;

    @BeforeEach
    public void beforeEach() {
        cadenaSimple = new CapitalizarCadenas("AnToNIO");
        cadenaCompuesta2 = new CapitalizarCadenas("AnToNIO FErnaNDEz");
        cadenaCompuesta3 = new CapitalizarCadenas("AnToNIO FernanDEZ PEreZ");
        cadenaCompuesta4 = new CapitalizarCadenas("JUAn AnToNIO FeRNANdeZ PeREZ");
        cadenaCompuestaExtrema = new CapitalizarCadenas("hey que pasa amigo? yo estoy mas o menos bien y tu que tal?");
    }

    @Test
    public void cadenaSimpleTest() {
        String resultado = "Antonio";

        assertEquals(resultado, cadenaSimple.getCadenaCapitalizada());
    }

    @Test
    public void cadenaCompuesta2Test() {
        String resultado = "Antonio Fernandez";

        assertEquals(resultado, cadenaCompuesta2.getCadenaCapitalizada());
    }

    @Test
    public void cadenaCompuesta3Test() {
        String resultado = "Antonio Fernandez Perez";

        assertEquals(resultado, cadenaCompuesta3.getCadenaCapitalizada());
    }

    @Test
    public void cadenaCompuesta4Test() {
        String resultado = "Juan Antonio Fernandez Perez";
        assertEquals(resultado, cadenaCompuesta4.getCadenaCapitalizada());
    }

    @Test
    public void cadenaCompuestaCasoExtremoTest() {
        String resultado = "Hey Que Pasa Amigo? Yo Estoy Mas O Menos Bien Y Tu Que Tal?";

        assertEquals(resultado,cadenaCompuestaExtrema.getCadenaCapitalizada());
    }
}
