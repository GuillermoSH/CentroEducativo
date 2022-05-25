package es.iespuerto.ets;

/**
 * Clase DNI para la validacion y calculo de la letra a partir del numero del
 * DNI introducido
 * 
 * @param dni    con la letra calculada y comprobado que es un numero valido
 * @param letras array con las letras de los DNIs ordenadas para hacer el
 *               calculo de la misma correctamente
 * 
 * @author GuillermoSH
 */
public class DNI {
    private String dni;
    private char[] letras = { 'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V',
            'H', 'L', 'C', 'K', 'E' };

    /**
     * Constructor parametrizado de la clase con el metodo de validacion y calculo
     * de la letra incluidos en la insercion de las variable numeroDNI a la clase
     * 
     * @param numeroDNI que se quiere comprobar y calcular su letra
     * @throws IllegalArgumentException si el DNI no llega a los 8 digitos
     * @see #obtenerDNI(int)
     */
    public DNI(int numeroDNI) throws IllegalArgumentException {
        this.dni = obtenerDNI(numeroDNI);
    }

    /**
     * Getter del dni ya con todas las comprobaciones hechas y calculada la letra
     * del mismo
     * 
     * @return el dni con letra
     */
    public String getDNI() {
        return this.dni;
    }

    /**
     * Metodo que comprueba que la longitud del dni es la necesaria para que el
     * programa se ejecute correctamente
     * 
     * @param numeroDNI que se quiere comprobar y calcular su letra
     * @throws IllegalArgumentException si el DNI no llega a los 8 digitos
     */
    private void dniValido(int numeroDNI) throws IllegalArgumentException {
        String DNI = "" + numeroDNI;
        if (DNI.length() != 8) {
            throw new IllegalArgumentException("Error DNI.dniValido(): el numero debe contener 8 digitos.");
        }
    }

    /**
     * Metodo que calcula la letra del dni habiendose asegurado antes de que el
     * numeroDNI cumple con los requisitos
     * 
     * @param numeroDNI que se quiere comprobar y calcular su letra
     * @return dni con letra
     * @throws IllegalArgumentException si el DNI no llega a los 8 digitos
     */
    private String obtenerDNI(int numeroDNI) throws IllegalArgumentException {
        dniValido(numeroDNI);

        return numeroDNI + "" + letras[numeroDNI % 23];
    }
}
