package excepciones;
/**
 * *  Captura los mensajes de error YA DEPURADOS que se han producido
 *  en la base de datos
 * @author angel
 *  
 */
public class MiException extends Exception {
	/**
	 * 
	 * @param s  mensaje del error que vamos a reenviar al programa principal
	 * 
	 */
 public MiException( String s ) {    // constructor
        super( s );
        }
		  
}