package model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class DNITest {
    DNI dniValido1 = null;
    DNI dniValido2 = null;
    DNI dniInvalido1 = null;
    DNI dniInvalido2 = null;

    @BeforeEach
    public void beforeEach() throws IllegalArgumentException {
        dniValido1 = new DNI(43127521);
        dniValido2 = new DNI(78312423);
    }

    @Test
    public void crearDniInvalido1() {
        Exception dniInvalido = Assertions.assertThrows(Exception.class, () -> dniInvalido1 = new DNI(433837801));

        Assertions.assertTrue(
                dniInvalido.getMessage().contains("Error DNI.dniValido(): el numero debe contener 8 digitos."));
    }

    @Test
    public void crearDniInvalido2() {
        Exception dniInvalido = Assertions.assertThrows(Exception.class, () -> dniInvalido2 = new DNI(43383));

        Assertions.assertTrue(
                dniInvalido.getMessage().contains("Error DNI.dniValido(): el numero debe contener 8 digitos."));
    }

    @Test
    public void getDNI() {
        assertEquals("43127521Z",dniValido1.getDNI(),"la letra devuelta debera ser la Z porque 43127521 % 23 tiene de resto 15");
        assertEquals("78312423E",dniValido2.getDNI(),"la letra devuelta debera ser la E porque 78312423 % 23 tiene de resto 23");
    }
}
