package es.iespuerto.ets;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class CapitalizarCadenasTest {
    CapitalizarCadenas cadenaSimple = null;
    CapitalizarCadenas cadenaCompuesta2 = null;
    CapitalizarCadenas cadenaCompuesta3 = null;
    CapitalizarCadenas cadenaCompuesta4 = null;

    @BeforeEach
    public void beforeEach() {
        cadenaSimple = new CapitalizarCadenas("AnToNIO");
        cadenaCompuesta2 = new CapitalizarCadenas("AnToNIO FErnaNDEz");
        cadenaCompuesta3 = new CapitalizarCadenas("AnToNIO FernanDEZ PEreZ");
        cadenaCompuesta4 = new CapitalizarCadenas("JUAn AnToNIO FeRNANdeZ PeREZ");
    }

    @Test
    public void cadenaSimpleTest() {
        assertEquals("Antonio", cadenaSimple.getCadenaCapitalizada());
    }

    @Test
    public void cadenaCompuesta2Test() {
        assertEquals("Antonio Fernandez", cadenaCompuesta2.getCadenaCapitalizada());
    }

    @Test
    public void cadenaCompuesta3Test() {
        assertEquals("Antonio Fernandez Perez", cadenaCompuesta3.getCadenaCapitalizada());
    }

    @Test
    public void cadenaCompuesta4Test() {
        assertEquals("Juan Antonio Fernandez Perez", cadenaCompuesta4.getCadenaCapitalizada());
    }
}
