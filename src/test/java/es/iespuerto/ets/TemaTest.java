package es.iespuerto.ets;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class TemaTest {
    Tema tema = null;

    @BeforeEach
    public void Before() {
        tema = new Tema("Tema1", 120);
    }

    @Test
    public void getNombreCapitalizadoTest() {
        assertEquals("tema1", tema.getNombre(), "Siempre devolvera la cadena en minusculas");
    }

    @Test
    public void getNombreMayusculasTest() {
        tema = new Tema("TEMA1", 120);
        assertEquals("tema1", tema.getNombre(), "Siempre devolvera la cadena en minusculas");
    }

    @Test
    public void getNombreMayusculasSalteadasTest() {
        tema = new Tema("tema1", 120);
        assertEquals("tema1", tema.getNombre(), "Siempre devolvera la cadena en minusculas");
    }

    @Test
    public void getHorasTest() {
        assertEquals(120, tema.getHoras(), "Devuelve correctamente las horas introducidas en el objeto de la clase");
    }

    @Test
    public void imprimeTemaTest() {
        assertEquals("tema1 con 120 horas", tema.toString(),
                "Devuelve un String con el formato: (nombre) con (numeroHoras) horas");
    }
}
