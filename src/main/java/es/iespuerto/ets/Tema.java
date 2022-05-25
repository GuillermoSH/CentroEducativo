package es.iespuerto.ets;

/**
 * Clase de almacenamiento de datos relacionados con el tema de cada temario de
 * las asignaturas impartidas
 * 
 * @author GuillermoSH
 */
public class Tema {
    private String nombre;
    private int horas;

    /**
     * Contructor parametrizado de la clase Tema.
     * 
     * @param nombre del tema
     * @param horas  dedicadas en total al tema
     */
    public Tema(String nombre, int horas) {
        this.nombre = nombre.toLowerCase();
        this.horas = horas;
    }

    /**
     * Getter de la variable tema.
     * 
     * @return nombre del tema
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Getter de la variable hora.
     * 
     * @return numero de horas dedicadas al tema
     */
    public int getHoras() {
        return this.horas;
    }

    /**
     * Metodo para devolver un string con los datos de cada tema con el formato dado
     * 
     * @return los datos de cada tema
     */
    public String toString() {
        return String.format("%s con %d horas", this.nombre, this.horas);
    }
}
