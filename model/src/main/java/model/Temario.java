package es.iespuerto.ets;

import java.util.*;
import java.io.*;

/**
 * Clase Temario que contiene los datos de cada Tema impartido
 * 
 * @author GuillermoSH
 */
public class Temario {
    private String nombre;
    private List<Tema> temas = new ArrayList<>();

    /**
     * Contructor parametrizado de la clase Temario
     * 
     * @param nombre del temario
     * @param temas  lista de temas incluidos en el temario
     */
    public Temario(String nombre, List<Tema> temas) {
        this.nombre = nombre.toUpperCase();
        this.temas = temas;
    }

    /**
     * Getter del parametro nombre de la clase Temario
     * 
     * @return nombre de la asignatura referida al temario
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Getter de la lista de objetos de Tema, temas de la clase Temario
     * 
     * @return lista de temas de la asignatura
     */
    public List<Tema> getTemas() {
        return this.temas;
    }

    /**
     * Getter del parametro horasTotales de la clase Temario
     * 
     * @return horas totales de cada temario
     */
    public int getHorasTotales() {
        int sumaHorasTotales = 0;

        for (int i = 0; i < this.temas.size(); i++) {
            Tema tema = this.temas.get(i);
            int horas = tema.getHoras();
            sumaHorasTotales += horas;
        }
        return sumaHorasTotales;
    }

    /**
     * Metodo para añadir objetos de la clase Tema a la lista temas
     * 
     * @param newTema nuevo objeto Tema a añadir
     * @return true si se ha añadido correctamente el tema
     * @throws IOException si el tema ya existe en la lista
     */
    public boolean agregarTema(Tema newTema) throws IOException {
        if (temas.contains(newTema)) {
            throw new IOException("Error Temario.agregarTema(): el tema ya existe.");
        }
        temas.add(newTema);
        return true;
    }

    /**
     * Metodo para eliminar un objeto de la clase Tema de la lista temas
     * 
     * @param oldTema objeto existente Tema a eliminar
     * @return true si existia el objeto a eliminar
     * @throws IOException Error Temario.eliminar(): no existe ese tema.
     */
    public boolean eliminarTema(Tema oldTema) throws IOException {
        if (!temas.contains(oldTema)) {
            throw new IOException("Error Temario.eliminarTema(): no existe ese tema.");
        }
        temas.remove(oldTema);
        return true;
    }

    /**
     * Metodo para editar un objeto de la clase Tema de la lista temas
     * 
     * @param oldTema objeto existente Tema a editar
     * @param newTema objeto nuevo Tema a reemplazar por el anterior
     * @return true si existia eñ objeto a editar
     * @throws IOException Error Temario.editar(): no existe ese tema
     */
    public boolean editarTema(Tema oldTema, Tema newTema) throws IOException {
        if (!temas.contains(oldTema)) {
            throw new IOException("Error Temario.editarTema(): no existe ese tema");
        }
        temas.set(temas.indexOf(oldTema), newTema);
        return true;
    }

    /**
     * Metodo para devolver un string con los datos de cada temario con un formato
     * dado
     * 
     * @return los datos de cada temario
     */
    @Override
    public String toString() {
        return String.format("Temario %s con %d horas totales: %s", this.nombre, getHorasTotales(),
                this.temas.toString());

    }
}
