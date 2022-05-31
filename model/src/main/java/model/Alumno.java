package es.iespuerto.ets;

import java.io.IOException;
import java.util.*;

/**
 * Clase de almacenamiento de datos relacionados con cada uno de los alumnos
 * 
 * @author GuillermoSH
 */
public class Alumno {
    private String nombre;
    private String apellidos;
    private String dni;
    private String fechaNacimiento;
    private List<Matricula> matriculas = new ArrayList<>();

    /**
     * Constructor parametrizado de la clase Alumno
     * 
     * @param nombre     del alumno
     * @param apellidos  del alumno
     * @param numDni     del alumno (sin letra)
     * @param fecha      del alumno
     * @param matriculas puestas a cursar por el alumno
     * @see CapitalizarCadenas
     * @see DNI
     * @throws IOException si el DNI es incorrecto
     */
    public Alumno(String nombre, String apellidos, int numDni, List<Matricula> matriculas, String fecha)
            throws IOException {
        CapitalizarCadenas cadenaCapitalizada = new CapitalizarCadenas(nombre);
        this.nombre = cadenaCapitalizada.getCadenaCapitalizada();

        cadenaCapitalizada = new CapitalizarCadenas(apellidos);
        this.apellidos = cadenaCapitalizada.getCadenaCapitalizada();

        DNI objDNI = new DNI(numDni);
        this.dni = objDNI.getDNI();

        this.fechaNacimiento = obtenerFecha(fecha, true);
        this.matriculas = matriculas;
    }

    /**
     * Getter del parametro nombre de la clase Alumno
     * 
     * @return el nombre del profesor en cuestion capitalizado
     * @see CapitalizarCadenas
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Getter del parametro apellidos de la clase Alumno
     * 
     * @return apellidos del profesor sea 1 o 2 capitalizados
     * @see CapitalizarCadenas
     */
    public String getApellidos() {
        return this.apellidos;
    }

    /**
     * Getter del parametro dni con la letra del mismo calculada
     * 
     * @return el dni con la letra calculada
     * @see DNI
     */
    public String getDni() {
        return this.dni;
    }

    /**
     * Getter del parametro fecha en el formato que quiera el usuario
     * 
     * @param numerico si se desea la fecha con mes numerico o no
     * @return la fecha comprobada mediante la clase {@link Fecha}
     * @throws IOException si la fecha introducida es incorrecta
     */
    public String getFechaNacimiento(boolean numerico) throws IOException {
        Fecha fechaObj = new Fecha(this.fechaNacimiento);
        this.fechaNacimiento = fechaObj.toString(numerico);

        return this.fechaNacimiento;
    }

    /**
     * Getter del parametro matriculas
     * 
     * @return la lista de matriculas asociadas al alumno
     */
    public List<Matricula> getMatriculas() {
        return this.matriculas;
    }

    /**
     * Metodo para obtener la fecha validada, en caso contrario arrojara una
     * excepcion
     * 
     * @param fecha    a validar
     * @param numerico si se quiere en formato numerico o no
     * 
     * @return fecha validada
     * @throws IOException si la fecha es erronea en alguna de sus cifras
     */
    private String obtenerFecha(String fecha, boolean numerico) throws IOException {
        Fecha fechaObj = new Fecha(fecha);

        return fechaObj.toString(numerico);
    }

    /**
     * Metodo que permite al usuario agregar nuevas matriculas a su lista de
     * matriculas
     * 
     * @param newMatricula nueva matricula a añadir
     * 
     * @return true si se ha añadido correctamente la matricula a la lista
     * @throws IOException si la matricula ya existia en la lista
     */
    public boolean agregarMatricula(Matricula newMatricula) throws IOException {
        if (this.matriculas.contains(newMatricula)) {
            throw new IOException("Error Alumno.agregarMatricula(): esa matricula ya existe.");
        }

        matriculas.add(newMatricula);

        return true;
    }

    /**
     * Metodo que permite al usuario eliminar una matricula ya existente dentro de
     * su lista de matriculas
     * 
     * @param oldMatricula matricula existente dentro de su lista de matriculas
     * @return true si se ha podido eliminar la matricula correctamente
     * @throws IOException si la matricula no existe dentro de la lista
     */
    public boolean eliminarMatricula(Matricula oldMatricula) throws IOException {
        if (!this.matriculas.contains(oldMatricula)) {
            throw new IOException("Error Alumno.eliminarMatricula(): esa matricula no existe.");
        }
        matriculas.remove(oldMatricula);
        return true;
    }

    /**
     * Metodo que permite al usuario editar una matricula ya existente dentro de su
     * lista de matriculas
     * 
     * @param newMatricula nueva matricula a añadir en la lista en sustitucion de la
     *                     antigua
     * @param oldMatricula matricula ya existente en la lista a modificar
     * @return true si se ha podido editar la matricula anterior correctamente
     * @throws IOException si no se ha encontrado la matricula anterior
     */
    public boolean editarMatricula(Matricula oldMatricula, Matricula newMatricula) throws IOException {
        if (!this.matriculas.contains(oldMatricula)) {
            throw new IOException("Error Alumno.editarMatricula(): esa matricula no existe.");
        }
        matriculas.set(matriculas.indexOf(oldMatricula), newMatricula);
        return true;
    }

    /**
     * Metodo sobrecargado del toString() de java para devolver un string en el
     * formato deseado con los datos del alumno
     * 
     * @return los datos de cada alumno con el formato deseado
     */
    @Override
    public String toString() {
        return String.format("Alumno %s %s con DNI %s y fecha de nacimiento %s, esta matriculado en:%n    %s",
                this.nombre, this.apellidos, this.dni, this.fechaNacimiento, this.matriculas);
    }
}
