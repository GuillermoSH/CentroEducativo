package es.iespuerto.ets;

import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import org.junit.jupiter.api.*;

public class AlumnoTest {
    Temario temario = null;
    ArrayList<Tema> temas = null;
    Tema tema1 = null;
    Tema tema2 = null;
    Tema tema3 = null;
    Asignatura asignatura1 = null;
    Asignatura asignatura2 = null;
    Asignatura asignatura3 = null;
    ArrayList<Asignatura> asignaturas = null;
    Map<Asignatura, Double> notas = new HashMap<>();
    Matricula matricula2021 = null;
    Matricula matricula2022 = null;
    ArrayList<Matricula> matriculas = new ArrayList<>();
    Alumno alumno1 = null;
    Alumno alumno2 = null;

    @BeforeEach
    public void beforeEach() throws IOException {
        // Creacion de temas
        tema1 = new Tema("Tema1", 120);
        tema2 = new Tema("Tema2", 40);
        tema3 = new Tema("Tema3", 80);
        // Creacion de temario y de la lista de temas
        temas = new ArrayList<>();
        temas.add(tema1);
        temas.add(tema2);
        temario = new Temario("Temario Introduccion", temas);
        // Creacion de las asignaturas y la lista de asignaturas
        asignatura1 = new Asignatura("Programacion", temario);
        asignatura2 = new Asignatura("Entornos", temario);
        asignatura3 = new Asignatura("BB.DD.", temario);
        asignaturas = new ArrayList<>();
        asignaturas.add(asignatura1);
        // Creacion de las notas del alumno
        notas.put(asignatura1, 5.0);
        notas.put(asignatura2, 6.1);
        notas.put(asignatura3, 8.5);
        // Creacion de la matricula del alumno1
        matricula2021 = new Matricula(43383780, "IES PUERTO", asignaturas, notas, "29-08-2021");
        matricula2022 = new Matricula(43383780, "IES PUERTO", asignaturas, notas, "27-08-2022");
        matriculas.add(matricula2021);
        // Creacion del alumno
        alumno1 = new Alumno("JuaN anToNIO", "HerNANDEz PeREZ", 43383780, matriculas, "24-04-2004");
        alumno2 = new Alumno("MaRIA", "GarCIA ROdriGuEZ", 43651235, matriculas, "04-12-2000");
    }

    @Test
    public void getNombreTest() {
        assertEquals("Juan Antonio", alumno1.getNombre());
        assertEquals("Maria", alumno2.getNombre());
    }

    @Test
    public void getApellidosTest() throws IOException {
        assertEquals("Hernandez Perez", alumno1.getApellidos(),
                "Capitaliza solo la primera letra de cada uno de los apellidos que se hayan introducido.");

        alumno2 = new Alumno("MaRIA", "GarCIA", 43651235, matriculas, "04-12-2000");
        assertEquals("Garcia", alumno2.getApellidos(), "Capitaliza solo la primera letra del apellido.");
    }

    @Test
    public void getDniTest() {
        assertEquals("43383780F", alumno1.getDni(), "43383780 % 23 = 8 que seria igual a la letra F");
        assertEquals("43651235H", alumno2.getDni(), "43651235 % 23 = 19 que seria igual a la letra H");
    }

    @Test
    public void getFechaNacimientoTest() throws Exception {
        assertEquals("24 de abril de 2004", alumno1.getFechaNacimiento(false),
                "Al poner numerico a false la fecha se imprimira con el mes en formato String");
        assertEquals("04/12/2000", alumno2.getFechaNacimiento(true),
                "Al poner numerico a true la fecha se imprimira con el mes en formato numerico");
    }

    @Test
    public void exceptionGetFechaNacimientoTest() throws IOException {
        Exception thrown1 = assertThrows(Exception.class,
                () -> alumno1 = new Alumno("JuaN anToNIO", "HerNANDEz PeREZ", 43383780, matriculas, "31-04-2004"));

        assertTrue(
                thrown1.getMessage().contains("Error Fecha.obtenerDia(): el dia es incorrecto."));

        Exception thrown2 = assertThrows(Exception.class,
                () -> alumno2 = new Alumno("MaRIA", "GarCIA ROdriGuEZ", 43651235, matriculas, "30-12-10000"));

        assertTrue(
                thrown2.getMessage().contains("Error Fecha.obtenerAnio(): el anio es incorrecto."));
    }

    @Test
    public void getMatriculasTest() {
        assertEquals(matriculas, alumno1.getMatriculas(),
                "La lista de objetos matricula debe ser la misma que la creada en los test");
    }

    @Test
    public void agregarMatriculaTest() throws Exception {
        assertTrue(alumno2.agregarMatricula(matricula2022),
                "Devuelve true si la matricula se ha podido insertar en la lista sin problemas");
    }

    @Test
    public void exceptionAgregarMatriculaTest() {
        Exception thrown = assertThrows(Exception.class, () -> alumno1.agregarMatricula(matricula2021));

        assertTrue(thrown.getMessage().contains("Error Alumno.agregarMatricula(): esa matricula ya existe."));
    }

    @Test
    public void eliminarMatriculaTest() throws Exception {
        assertTrue(alumno1.eliminarMatricula(matricula2021),
                "Devuelve true si la matricula se ha podido borrar en la lista sin problemas");
    }

    @Test
    public void exceptionEliminarMatriculaTest() {
        Exception thrown = assertThrows(Exception.class, () -> alumno1.eliminarMatricula(matricula2022));

        assertTrue(thrown.getMessage().contains("Error Alumno.eliminarMatricula(): esa matricula no existe."));
    }

    @Test
    public void editarMatriculaTest() throws Exception {
        assertTrue(alumno2.editarMatricula(matricula2021, matricula2022),
                "Devuelve true si la matricula anterior se ha podido cambiar por la nueva sin problemas");
    }

    @Test
    public void exceptionEditarMatriculaTest() {
        Exception thrown = assertThrows(Exception.class,
                () -> alumno1.editarMatricula(matricula2022, matricula2021));

        assertTrue(thrown.getMessage().contains("Error Alumno.editarMatricula(): esa matricula no existe."));
    }

    @Test
    public void toStringTest() throws IOException {
        alumno1 = new Alumno("JuAn", "PeREZ", 43383780, matriculas, "22/02/2022");

        assertTrue(alumno1.toString().contains(
                "Alumno Juan Perez con DNI 43383780F y fecha de nacimiento 22/02/2022, esta matriculado en:"));
    }
}
