package es.iespuerto.ets;

import java.io.*;

/**
 * Clase Fecha capaz de verificar de que la fecha introducida es la correcta o
 * no dependiendo del mes que se le introduzca o del anyo si es bisiesto o no.
 * 
 * @author GuillermoSH
 */
public class Fecha {
    private int dia;
    private int mesNumerico;
    private int anio;
    private final String[] meses = { "enero", "febrero", "marzo", "abril", "mayo", "junio", "julio", "agosto",
            "septiembre", "octubre", "noviembre", "diciembre" };
    private final int[] dias = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

    /**
     * Constructor parametrizado de la clase Fecha
     * 
     * @param fecha a evaluar
     * @throws IOException si alguno de los parametros de la fecha es incorrecto
     */
    public Fecha(String fecha) throws IOException {
        String[] fechaSeparada = new String[3];

        for (int i = 0; i < fechaSeparada.length; i++) {
            fechaSeparada = fecha.split("[/-]");
        }

        this.anio = obtenerAnio(fechaSeparada[2]);
        this.mesNumerico = obtenerMes(fechaSeparada[1]);
        this.dia = obtenerDia(fechaSeparada[0]);
    }

    /**
     * Getter del parametro mesNombre
     * 
     * @return mes, pero su nombre
     */
    public String obtenerNombreMes() {
        return meses[this.mesNumerico - 1];
    }

    /**
     * Metodo para la obtencion del parametro anio con su previa validacion a partir
     * del String de fecha
     * 
     * @param strAnio la parte del String fecha despues de hacer el split
     * @return anio como int
     * @throws IOException si el anio es incorrecto
     */
    private int obtenerAnio(String strAnio) throws IOException {
        int numAnio = Integer.parseInt(strAnio);

        if (numAnio < 1999 || numAnio > 9999) {
            throw new IOException("Error Fecha.obtenerAnio(): el anio es incorrecto.");
        }

        return numAnio;
    }

    /**
     * Metodo para la obtencion del parametro mes con su previa validacion a partir
     * del String de fecha
     * 
     * @param strMes la parte del String fecha despues de hacer el split
     * @return mes como int
     * @throws IOException si el mes es incorrecto
     */
    private int obtenerMes(String strMes) throws IOException {
        int numMes = Integer.parseInt(strMes);

        if (numMes > 12 || numMes < 1) {
            throw new IOException("Error Fecha.obtenerMes(): el mes es incorrecto.");
        }
        return numMes;
    }

    /**
     * Metodo para la obtencion del parametro dia con su previa validacion a partir
     * del String de fecha
     * 
     * @param strDia la parte del String fecha despues de hacer el split
     * @return dia como int
     * @throws IOException si el dia es incorrecto
     */
    private int obtenerDia(String strDia) throws IOException {
        int numDia = Integer.parseInt(strDia);

        if (esBisiesto(this.anio)) {
            dias[1] = 29;
        }

        if (numDia < 1 || numDia > dias[this.mesNumerico - 1]) {
            throw new IOException("Error Fecha.obtenerDia(): el dia es incorrecto.");
        }
        return numDia;
    }

    /**
     * Metodo para la verificacion de que el anyo es bisiesto
     * 
     * @param anio a verificar si es bisiesto o no
     * @return true o false dependiendo de si es bisiesto
     */
    private boolean esBisiesto(int anio) {
        return (anio % 4 == 0 && anio % 100 != 0 || anio % 400 == 0);
    }

    /**
     * Metodo que devuelve como String la fecha con el mes en formato numerico o
     * como nombre dependiendo de la entrada que de el usuario en el constructor de
     * la clase
     * 
     * @param numerico si se quiere la fecha con mes numerico o no
     * @return como String la fecha con el mes en formato numerico o como nombre
     */
    public String toString(boolean numerico) {
        if (!numerico) {
            return String.format("%d de %s de %d", this.dia, obtenerNombreMes(), this.anio);
        }
        return String.format("%02d/%02d/%d", this.dia, this.mesNumerico, this.anio);
    }
}
