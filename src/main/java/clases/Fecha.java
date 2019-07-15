package clases;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
public class Fecha {
	
	/**
	 * 
	 * @param fecha String con formato de la mascara
	 * @param mascara String constante 
	 *                    "yyyy/MM/dd" 
	 *                    "dd/MM/yyyy"
	 *                    "yyyy-MM-dd" .... ect. Ó con tiempos
	 *                    "dd/MM/yyyy/hh/mm/ss" ... ect
	 * @return si la fecha es correcta o incorrecta
	 */
	public static boolean validarFecha(String fecha,String mascara){
		SimpleDateFormat formato = new SimpleDateFormat(mascara);
		formato.setLenient(false);
		try {
			 new Date(formato.parse(fecha).getTime());
		} catch (ParseException e) {
			return false;
		}
		return true;
		
	}
	/**
	 * convierte un String de una fecha a un date java.sql.date
	 * 
	 * @param fecha  String con formato de la mascara
	 * @param mascara String constante separadores validos (solo / ó solo -)
	 *                    "yyyy/MM/dd"
	 *                    "dd/MM/yyyy"  
	 *                    "dd/MM/yyyy"
	 *                    "yyyy-MM-dd" .... ect. Ó con tiempos
	 *                    "dd/MM/yyyy/hh/mm/ss" ... ect
	 * @return   java.sql.Date.
	 * @throws ParseException
	 */
	public static java.sql.Date convertirADate(String fecha,String mascara) throws ParseException{
		if (fecha.compareTo("")==0 ||fecha ==null)
			return null;
		else{
		SimpleDateFormat formato = new SimpleDateFormat(mascara);
		formato.setLenient(false);
		return new Date(formato.parse(fecha).getTime());
		}	
			
	}
	/**
	 * convierte un  java.sql.date a un String con una mascara
	 * @param fecha  java.sql.Date
	 * @param mascara String constante separadores validos 
	 *               cualquier combinacion de  /,-,: blancos 
	 * @return 
	 */
	
	public static String convertirAString(java.sql.Date fecha,String mascara) {
		SimpleDateFormat formato = new SimpleDateFormat(mascara);
		formato.setLenient(false);
		return formato.format(fecha);
			
			
	}
	/**
	 *  devuelve la fecha actual ,se puede incluir en la mascara la hora...
	 * @param mascara String constante constante 
	 *                  separadores validos (solo / ó solo -)
	 *                  dd/MM/yyyy Ó yyyy-MM-dd
	 *                  dd/MM/yyyy/hh/mm/ss
	 * @return
	 * @throws ParseException
	 */
	public static java.sql.Date hoy(String mascara) throws ParseException {
		SimpleDateFormat formato = new SimpleDateFormat(mascara);
		formato.setLenient(false);
		String fechahoy= formato.format(new java.util.Date());
		return convertirADate(fechahoy,mascara);
			
	}
	
	
	/**
	 * 
	 * @return  object java.sql.Date de la fecha actual
	 * no funciona; no pueden hacer los cast de java.sql.util a java.sql.date.
	 */
	public static  java.sql.Date fechaActualDate(){
	
		//  no pueden hacer los cast de java.sql.util a java.sql.date.		
		Calendar cal = new GregorianCalendar();
		return  (java.sql.Date) cal.getTime();
		
	}
	
	/**
	 * 
	 * @return  object java.sql.Date de la fecha actual
	 * no funciona; no pueden hacer los cast de java.sql.util a java.sql.date.
	 */
	public static  java.sql.Date fechaActual(){
		
		//  no pueden hacer los cast de java.sql.util a java.sql.date.	
		return  (java.sql.Date)new java.util.Date() ;
		
	}
	
	/**************************  TIMESTAMP   *********************************/
	public static String hoy_HHMMSS(){
		java.util.Date dt = new java.util.Date();
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String currentTime = sdf.format(dt);
		return currentTime;
	}


}
