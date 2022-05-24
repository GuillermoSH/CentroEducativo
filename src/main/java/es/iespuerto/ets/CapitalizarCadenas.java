package es.iespuerto.ets;

/**
 * Clase para capitalizar cadenas compuestas y simples, es decir, capitaliza la
 * primera letra de cada palabra
 * 
 * @param cadenaCapitalizada cadena ya capitalizada
 * 
 * @author GuillermoSH
 */
public class CapitalizarCadenas {
    private String cadenaCapitalizada;

    /**
     * Contructor de la clase que llama a los metodos
     * {@link #capitalizarCadenaCompuesta(String)} y
     * {@link #capitalizarCadenaSimple(String)} dependiendo si detecta que tiene mas
     * de una palabra o no la cadena
     * 
     * @param cadena cadena a capitalizar
     */
    public CapitalizarCadenas(String cadena) {
        if (cadena.contains(" ")) {
            this.cadenaCapitalizada = capitalizarCadenaCompuesta(cadena);
        } else {
            this.cadenaCapitalizada = capitalizarCadenaSimple(cadena);
        }
    }

    /**
     * Getter de la cadena que se ha insertado en el constructor con su primera
     * letra de cada palabra ya capitalizada
     * 
     * @return la cadena capitalizada
     */
    public String getCadenaCapitalizada() {
        return this.cadenaCapitalizada;
    }

    /**
     * Metodo para capitalizar una cadena compuesta de caracteres. Ej: "juan
     * antonio" -> "Juan Antonio"
     * 
     * @param cadena de caracteres compuesta a capitalizar
     * @return cadena de caracteres capitalizando el primer caracter
     */
    public String capitalizarCadenaCompuesta(String cadena) {
        String[] cadenas = cadena.split(" ");
        String resultado = "";

        for (int i = 0; i < cadenas.length; i++) {
            cadenas[i] = cadenas[i].substring(0, 1).toUpperCase() + cadenas[i].substring(1).toLowerCase();
            resultado += " " + cadenas[i];
        }
        return resultado.substring(1);
    }

    /**
     * Metodo para capitalizar una cadena simple de caracteres. Ej: "guillermo" ->
     * "Guillermo"
     * 
     * @param cadena de caracteres simple a capitalizar
     * @return cadena de caracteres capitalizando el primer caracter
     */
    public String capitalizarCadenaSimple(String cadena) {
        return cadena.substring(0, 1).toUpperCase() + cadena.substring(1).toLowerCase();
    }
}
