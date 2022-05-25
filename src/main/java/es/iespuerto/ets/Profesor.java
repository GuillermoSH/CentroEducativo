package es.iespuerto.ets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase Profesor para el almacenaje de asignaturas impartidas por el mismo y
 * comprobacion de que no supera el limite de 3000h de docencia.
 * 
 * @author GuillermoSH
 * @version 0.2
 */
public class Profesor {
    private String nombre;
    private String apellidos;
    private String titulacion;
    private List<Asignatura> asignaturas = new ArrayList<>();

    /**
     * Constructor parametrizado de la clase Profesor
     * 
     * @param nombre      nombre del profesor compuesto o simple
     * @param apellidos   apellidos del profesor
     * @param titulacion  titulacion del profesor
     * @param asignaturas asignaturas impartidas por el profesor
     */
    public Profesor(String nombre, String apellidos, String titulacion, List<Asignatura> asignaturas) {
        CapitalizarCadenas cadenaCapitalizada = new CapitalizarCadenas(nombre);
        this.nombre = cadenaCapitalizada.getCadenaCapitalizada();

        cadenaCapitalizada = new CapitalizarCadenas(apellidos);
        this.apellidos = cadenaCapitalizada.getCadenaCapitalizada();

        this.titulacion = titulacion;
        this.asignaturas = asignaturas;
    }

    /**
     * Getter del parametro nombre de la clase Profesor
     * 
     * @return el nombre del profesor en cuestion capitalizado
     * @see CapitalizarCadenas
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Getter del parametro apellidos
     * 
     * @return apellidos del profesor sea 1 o 2 capitalizados
     * @see CapitalizarCadenas
     */
    public String getApellidos() {
        return this.apellidos;
    }

    /**
     * Getter del parametro titulacion
     * 
     * @return titulacion del profesor
     */
    public String getTitulacion() {
        return this.titulacion;
    }

    /**
     * Getter de la lista de objetos Asignaturas
     * 
     * @return lista de objetos de la clase Asignatura
     */
    public List<Asignatura> getAsignaturas() {
        return this.asignaturas;
    }

    /**
     * Metodo que permite agregar asignaturas a impartir por el profesor siempre y
     * cuando no {@link #superaLimiteHorasTotales()}, ni existe ya dentro de
     * la lista
     * 
     * @param newAsignatura nueva asignatura a añadir
     * @return true si se ha podido agregar a la lista la nueva asignatura
     * @throws Exception si se supera el limite de horas a impartir o si ya existe
     *                   la asignatura a añadir
     */
    public boolean agregarAsignatura(Asignatura newAsignatura) throws IOException {
        superaLimiteHorasTotales();

        if (this.asignaturas.contains(newAsignatura)) {
            throw new IOException("Error Profesor.agregarAsignatura(): la asignatura ya existe.");
        }
        asignaturas.add(newAsignatura);

        return true;
    }

    /**
     * Metodo que permite eliminar asignaturas que imparte por el profesor a no ser
     * que no exista la asignatura
     * 
     * @param oldAsignatura asignatura a eliminar
     * @return true si se ha podido eliminar la asignatura de la lista
     * @throws Exception si no existe la asignatura
     */
    public boolean eliminarAsignatura(Asignatura oldAsignatura) throws IOException {
        if (!this.asignaturas.contains(oldAsignatura)) {
            throw new IOException("Error Profesor.eliminarAsignatura(): no existe esa asignatura.");
        }
        this.asignaturas.remove(oldAsignatura);
        return true;
    }

    /**
     * Metodo que permite editar asignaturas a impartir por el profesor siempre y
     * cuando no {@link #superaLimiteHorasTotales()}, si existe dentro de
     * la lista
     * 
     * @param oldAsignatura antigua asignatura a modificar
     * @param newAsignatura nueva asignatura a añadir
     * @return true si se ha podido agregar a la lista la nueva asignatura
     * @throws Exception si se supera el limite de horas a impartir o si no existe
     *                   en la lista
     */
    public boolean editarAsignatura(Asignatura oldAsignatura, Asignatura newAsignatura) throws IOException {
        superaLimiteHorasTotales();

        if (!this.asignaturas.contains(oldAsignatura)) {
            throw new IOException("Error Profesor.editarAsignatura(): no existe esa asignatura.");
        }
        this.asignaturas.set(this.asignaturas.indexOf(oldAsignatura), newAsignatura);
        return true;
    }

    /**
     * Metodo para comprobar que el limite estipulado de 3000h maximo por profesor
     * de docencia escolar no se supera
     */
    private void superaLimiteHorasTotales() throws IOException {
        int horasTotales = 0;

        for (Asignatura asignatura : asignaturas) {
            Temario temario = asignatura.getTemario();

            horasTotales += temario.getHorasTotales();

            if (horasTotales > 3000) {
                throw new IOException(
                        "Error, el límite de horas totales a impartir se ha superado.");
            }
        }
    }

    /**
     * Metodo para devolver un string con formato dado con los datos de cada
     * profesor
     * 
     * @return los datos de cada profesor
     */
    @Override
    public String toString() {
        return String.format("Profesor: %s %s, con titulación: %s y asignaturas impartidas:  %s", getNombre(),
                getApellidos(), this.titulacion, this.asignaturas);
    }
}
