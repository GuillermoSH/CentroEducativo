package es.iespuerto.ets;

import java.io.*;
import org.junit.jupiter.api.*;


public class FechaTest {
    Fecha fecha = null;

    @BeforeEach
    public void Before() throws IOException {
        fecha = new Fecha("29/02/2012");
    }

    @Test
    public void getAnioTest() {
        Assertions.assertEquals(2012, fecha.getAnio());
    }

    @Test
    public void getMesNumericoTest() {
        Assertions.assertEquals(2, fecha.getMesNumerico());
    }

    @Test
    public void getMesNombreTest() throws Exception {
        Assertions.assertEquals("febrero", fecha.getMesNombre());
        // Comprobacion de los demas meses del año
        fecha = new Fecha("30/01/2012");
        Assertions.assertEquals("enero", fecha.getMesNombre());
        fecha = new Fecha("30/03/2012");
        Assertions.assertEquals("marzo", fecha.getMesNombre());
        fecha = new Fecha("30/04/2012");
        Assertions.assertEquals("abril", fecha.getMesNombre());
        fecha = new Fecha("30/05/2012");
        Assertions.assertEquals("mayo", fecha.getMesNombre());
        fecha = new Fecha("30/06/2012");
        Assertions.assertEquals("junio", fecha.getMesNombre());
        fecha = new Fecha("31/07/2012");
        Assertions.assertEquals("julio", fecha.getMesNombre());
        fecha = new Fecha("30/08/2012");
        Assertions.assertEquals("agosto", fecha.getMesNombre());
        fecha = new Fecha("30/09/2012");
        Assertions.assertEquals("septiembre", fecha.getMesNombre());
        fecha = new Fecha("30/10/2012");
        Assertions.assertEquals("octubre", fecha.getMesNombre());
        fecha = new Fecha("30/11/2012");
        Assertions.assertEquals("noviembre", fecha.getMesNombre());
        fecha = new Fecha("31/12/2012");
        Assertions.assertEquals("diciembre", fecha.getMesNombre());
    }

    @Test
    public void getDiaTest() {
        Assertions.assertEquals(29, fecha.getDia());
    }

    @Test
    public void obtenerAnioTest() throws Exception {
        Assertions.assertEquals(fecha.getAnio(),fecha.obtenerAnio("2012"));
    }

    @Test 
    public void obtenerMesTest() throws Exception {
        Assertions.assertEquals(fecha.getMesNumerico(),fecha.obtenerMes("02"));
    }

    @Test
    public void obtenerDiaTest() throws Exception {
        Assertions.assertEquals(fecha.getDia(),fecha.obtenerDia("29"));
    }

    @Test
    public void imprimeFechaTest() throws Exception {
        Assertions.assertEquals("29 de febrero de 2012", fecha.imprimeFecha(false));
        Assertions.assertEquals("29/02/2012", fecha.imprimeFecha(true));
    }

    @Test
    public void exceptionObtenerAnio() {
        // Exception con anio inferior a 1999
        Exception anioIncorrecto1 = Assertions.assertThrows(Exception.class,
                () -> fecha = new Fecha("12/01/1891"));
        Assertions.assertTrue(anioIncorrecto1.getMessage().contains("Error Fecha.obtenerAnio(): el anio es incorrecto."));
        // Exception con anio superior a 9999
        Exception anioIncorrecto2 = Assertions.assertThrows(Exception.class,
                () -> fecha = new Fecha("12/12/20000"));
        Assertions.assertTrue(anioIncorrecto2.getMessage().contains("Error Fecha.obtenerAnio(): el anio es incorrecto."));
    }

    @Test
    public void exceptionObtenerMes() {
        // Exception con mes inferior a 1
        Exception mesIncorrecto1 = Assertions.assertThrows(Exception.class,
                () -> fecha = new Fecha("12/00/2000"));
        Assertions.assertTrue(mesIncorrecto1.getMessage().contains("Error Fecha.obtenerMes(): el mes es incorrecto."));
        // Exception con mes superior a 12
        Exception mesIncorrecto2 = Assertions.assertThrows(Exception.class,
                () -> fecha = new Fecha("12/13/2000"));
        Assertions.assertTrue(mesIncorrecto2.getMessage().contains("Error Fecha.obtenerMes(): el mes es incorrecto."));
    }

    @Test
    public void exceptionObtenerDia() {
        // Exception con mes inferior a 1
        Exception diaIncorrecto1 = Assertions.assertThrows(Exception.class,
                () -> fecha = new Fecha("00/01/2012"));
        Assertions.assertTrue(diaIncorrecto1.getMessage().contains("Error Fecha.obtenerDia(): el dia es incorrecto."));
        // Exception con mes superior a 30
        Exception diaIncorrecto2 = Assertions.assertThrows(Exception.class,
                () -> fecha = new Fecha("31/04/2000"));
        Assertions.assertTrue(diaIncorrecto2.getMessage().contains("Error Fecha.obtenerDia(): el dia es incorrecto."));
        // Exception con mes superior a 31
        Exception diaIncorrecto3 = Assertions.assertThrows(Exception.class,
                () -> fecha = new Fecha("32/01/2000"));
        Assertions.assertTrue(diaIncorrecto3.getMessage().contains("Error Fecha.obtenerDia(): el dia es incorrecto."));
        // Exception con mes superior a 28
        Exception diaIncorrecto4 = Assertions.assertThrows(Exception.class,
                () -> fecha = new Fecha("29/02/2011"));
        Assertions.assertTrue(diaIncorrecto4.getMessage().contains("Error Fecha.obtenerDia(): el dia es incorrecto."));
        // Exception con mes superior a 29
        Exception diaIncorrecto5 = Assertions.assertThrows(Exception.class,
                () -> fecha = new Fecha("30/02/2012"));
        Assertions.assertTrue(diaIncorrecto5.getMessage().contains("Error Fecha.obtenerDia(): el dia es incorrecto."));
    }
}