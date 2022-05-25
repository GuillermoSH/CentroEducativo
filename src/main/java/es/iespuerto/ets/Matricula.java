package es.iespuerto.ets;

import java.util.*;
import java.io.*;

/**
 * Clase Matricula para guardar los datos de cada una de las matriculas
 * asociadas a los alumnos que lo soliciten
 * 
 * @author GuillermoSH
 */
public class Matricula {
    private String dni;
    private String nombre;
    private List<Asignatura> asignaturas = new ArrayList<>();
    private Map<Asignatura, Double> notas = new HashMap<>();
    private String fecha;
    private double precio;
    private boolean pagada = false;

    /**
     * Constructor parametrizado de la clase
     * 
     * @param numDni      del matriculado
     * @param nombre      del centro
     * @param asignaturas a estudiar por el alumno
     * @param notas       del alumno
     * @param fecha       de realizacion de la matricula
     * @throws IOException si al fecha es incorrecta o el DNI es incorrecto
     */
    public Matricula(int numDni, String nombre, List<Asignatura> asignaturas, Map<Asignatura, Double> notas,
            String fecha) throws IOException {
        DNI objDNI = new DNI(numDni);
        this.dni = objDNI.getDNI();

        this.nombre = nombre;
        this.asignaturas = asignaturas;
        this.notas = notas;
        this.fecha = obtenerFecha(fecha, true);
        this.precio = obtenerPrecio();
    }

    /**
     * Getter del parametro dni
     * 
     * @return el dni con la letra calculada
     * @see DNI
     */
    public String getDni() {
        return this.dni;
    }

    /**
     * Getter del parametro nombre
     * 
     * @return nombre del centro educativo
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Getter del parametro asignaturas
     * 
     * @return las asignaturas matriculadas por el alumno
     */
    public List<Asignatura> getAsignaturas() {
        return this.asignaturas;
    }

    /**
     * Getter del parametro notas
     * 
     * @return las notas asociadas a cada asignatura
     */
    public Map<Asignatura, Double> getNotas() {
        return this.notas;
    }

    /**
     * Getter del parametro fecha
     * 
     * @param numerico si se desea en formato numerico o no
     * @return fecha validada en el formato deseado
     * @throws IOException si alguna cifra es incorrecta
     */
    public String getFecha(boolean numerico) throws IOException {
        return obtenerFecha(this.fecha, numerico);
    }

    /**
     * Getter del parametro precio
     * 
     * @return el precio total a pagar por la matricula
     */
    public double getPrecio() {
        return this.precio;
    }

    /**
     * Getter del parametro pagada
     * 
     * @return si la matricula ha sido pagada o no
     */
    public boolean isPagada() {
        return this.pagada;
    }

    /**
     * Metodo para la validacion de la variable fecha mediante el uso de la clase
     * {@link Fecha}
     * 
     * @param fecha    a validar
     * @param numerico si se desea en formato numerico o no
     * @return la fecha validada y en el formato deseado
     * @throws IOException si alguna cifra es incorrecta
     */
    public String obtenerFecha(String fecha, boolean numerico) throws IOException {
        Fecha fechaObj = new Fecha(fecha);

        return fechaObj.toString(numerico);
    }

    /**
     * Metodo para la obtencion del total a pagar por la matricula dependiendo de
     * las asignaturas elegidas
     * 
     * @return precio total a pagar
     */
    public double obtenerPrecio() {
        double precioTotal = 0;
        for (Asignatura asignatura : asignaturas) {
            precioTotal += asignatura.getPrecio();
        }
        return precioTotal;
    }

    /**
     * Metodo que permite al usuario pagar dicha matricula introduciendo un importe
     * que si no supera el precio de la matricula sera invalidado
     * 
     * @param importe introducido por el usuario
     */
    public void pagarMatricula(double importe) {
        if (importe >= obtenerPrecio()) {
            this.pagada = true;
        }
    }

    /**
     * Metodo para lanzar las excepciones
     * 
     * @param condicion a evaluar
     * @param cadena    a lanzar si falla
     * @throws NoSuchFieldException si no se cumple la condicion
     */
    public void exception(boolean condicion, String cadena) throws NoSuchFieldException {
        if (condicion) {
            throw new NoSuchFieldException("Error Matricula." + cadena);
        }
    }

    /**
     * Metodo que permite agregar asignaturas a la lista, si la matricula esta
     * pagada se anula la modificacion
     * 
     * @param newAsignatura nueva asignatura a añadir
     * @return true si se ha podido agregar a la lista la nueva asignatura
     * @throws NoSuchFieldException si ya existe la asignatura a añadir
     */
    public boolean agregarAsignatura(Asignatura newAsignatura) throws NoSuchFieldException {
        exception(pagada, "agregarAsignatura(): la matricula ya ha sido pagada.");
        exception(this.asignaturas.contains(newAsignatura), "agregarAsignatura(): la asignatura ya existe.");

        asignaturas.add(newAsignatura);

        return true;
    }

    /**
     * Metodo que permite eliminar asignaturas a no ser que no exista la asignatura,
     * y si la matricula esta pagada se anula la modificacion
     * 
     * @param oldAsignatura asignatura a eliminar
     * @return true si se ha podido eliminar la asignatura de la lista
     * @throws NoSuchFieldException si no existe en la lista la asignatura
     */
    public boolean eliminarAsignatura(Asignatura oldAsignatura) throws NoSuchFieldException {
        exception(pagada, "eliminarAsignatura(): la matricula ya ha sido pagada.");
        exception(!this.asignaturas.contains(oldAsignatura), "eliminarAsignatura(): no existe esa asignatura.");

        this.asignaturas.remove(oldAsignatura);

        return true;
    }

    /**
     * Metodo que permite editar asignaturas si existen dentro de la lista, y si la
     * matricula esta pagada se anula la modificacion
     * 
     * @param oldAsignatura antigua asignatura a modificar
     * @param newAsignatura nueva asignatura a añadir
     * @return true si se ha podido editar la asignatura
     * @throws NoSuchFieldException si no existe en la lista la asignatura
     */
    public boolean editarAsignatura(Asignatura oldAsignatura, Asignatura newAsignatura) throws NoSuchFieldException {
        exception(pagada, "editarAsignatura(): la matricula ya ha sido pagada.");
        exception(!this.asignaturas.contains(oldAsignatura), "editarAsignatura(): no existe esa asignatura.");

        this.asignaturas.set(asignaturas.indexOf(oldAsignatura), newAsignatura);

        return true;
    }

    /**
     * Metodo para devolver un string con el formato deseado de los datos de la
     * matricula
     * 
     * @return los datos de la matricula del alumno
     */
    @Override
    public String toString() {
        return String.format("Matricula para %s en el centro %s a %s, con las asignaturas:\n    %s", this.dni,
                this.nombre, this.fecha, this.asignaturas.toString());
    }
}
