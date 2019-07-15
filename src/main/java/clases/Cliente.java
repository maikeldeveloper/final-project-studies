package clases;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import beans.ClienteBean;
import conexionBBDD.ConexionMySql;
import excepciones.MiException;

public class Cliente {
	

	
	private   String cadenaVacia (String cadena){
		if (cadena.compareTo("")==0)
		  return null;
		else
		  return cadena;
	} 
	
	public static ClienteBean autentificarCliente(String nom_user, String pass){

		ClienteBean clienteAutentificado = null;
		Connection conexion = ConexionMySql.getConexionMySql();
		Statement orden = null;
		ResultSet resultado = null;
		String query = "SELECT NOM_USER, PASS, NOMBRE, APELLIDOS,COD_POSTAL,LETRA,NUMERO, ESCALERA, TELEFONO, DIRECCION, PISO, COD_POSTAL FROM clientes WHERE NOM_USER='"+ nom_user +"' AND PASS='"+pass+"'";
		boolean encontrado;
		try {
			orden = conexion.createStatement();
			resultado = orden.executeQuery(query);
			encontrado = resultado.next();
			if (encontrado && resultado.getString("PASS").equals(pass) && resultado.getString("NOM_USER").equals(nom_user)) {
				clienteAutentificado = new ClienteBean();
				clienteAutentificado.setNom_user(resultado.getString("NOM_USER"));
				clienteAutentificado.setNombre(resultado.getString("NOMBRE"));
				clienteAutentificado.setApellidos(resultado.getString("APELLIDOS"));
				clienteAutentificado.setDireccion(resultado.getString("DIRECCION"));
				clienteAutentificado.setPiso(resultado.getString("PISO"));
				clienteAutentificado.setNumero(resultado.getString("NUMERO"));
				clienteAutentificado.setCod_postal(resultado.getString("COD_POSTAL"));
				clienteAutentificado.setTelefono(resultado.getString("TELEFONO"));
				clienteAutentificado.setEscalera(resultado.getString("ESCALERA"));
				clienteAutentificado.setLetra(resultado.getString("LETRA"));
			} 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				if (conexion != null && !conexion.isClosed())
					conexion.close();
				if (orden != null && !orden.isClosed())
					orden.close();
				if (resultado != null && !resultado.isClosed())
					resultado.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return clienteAutentificado;	
	}
	
	
	/**
	 * inserta un cliente en la base de datos
	 * @param nom_user nombre del usuario PK
	 * @param pass contrasena
	 * @param pass_r contrasena repetida
	 * @param nombre, nombre real del cliente
	 * @param apellidos
	 * @param direccion
	 * @param numero
	 * @param piso, puede ser null
	 * @param letra, puede ser null
	 * @param escalera, puede ser null
	 * @param cod_postal, codigo postal
	 * @param telefono
	 * @return ClienteBean
	 * @throws MiException permite capturar el error depurado que se ha producido en la base de datos 
	 * con el metodo toString() heredado de la clase Exception.
	 */
	public ClienteBean insertarClientes( String nom_user,
						            String pass,
						            String pass_r,
						            String nombre,
						            String apellidos,
						            String direccion,
						            String numero,
						            String piso,
						            String letra,
						            String escalera,
						            String cod_postal,
						            String telefono ) throws MiException{
		
		if((nom_user == null)    ||   (cadenaVacia(nom_user) == null))throw  new MiException("Tiene que introducir su nombre de usuario");
		if((pass == null)        ||       (cadenaVacia(pass) == null))throw  new MiException("Tiene que introducir la contrasena");
		if((pass_r == null)      ||     (cadenaVacia(pass_r) == null))throw  new MiException("Tiene que repetir la contrasena");
		if((nombre == null)      ||     (cadenaVacia(nombre) == null))throw  new MiException("Tiene que introducir su nombre");
		if((apellidos == null)   ||  (cadenaVacia(apellidos) == null))throw  new MiException("Tiene que introducir sus apellidos");
		if((numero == null)      ||     (cadenaVacia(numero) == null))throw  new MiException("Tiene que introducir el numero del portal");
		if((direccion == null)   ||  (cadenaVacia(direccion) == null))throw  new MiException("Tiene que introducir la direccion de su calle");
		if((cod_postal == null)  || (cadenaVacia(cod_postal) == null))throw  new MiException("Tiene que introducir su codigo postal");
		if((telefono == null)    ||   (cadenaVacia(telefono) == null))throw  new MiException("Tiene que introducir su telefono");
		if(!pass.equals(pass_r))throw  new MiException("Las contrase�as introducidas no coinciden");
		/*LONGITUD DE CAMPOS*/
		if(nom_user.length()>20)	throw  new MiException("El nombre del usuario no puede tener mas de 20 letras");
		if(pass.length()>20)    	throw  new MiException("El nombre del usuario no puede tener mas de 20 letras");
		if(nombre.length()>20)		throw  new MiException("El nombre del usuario no puede tener mas de 20 letras");
		if(apellidos.length()>45)	throw  new MiException("Los apellidos no puede tener mas de 45 letras");
		if(direccion.length()>145)	throw  new MiException("La direcci�n no puede tener mas de 145 letras");
		if(numero.length()>3)		throw  new MiException("El numero no puede tener mas de 2 digitos");
		if(piso.length()>2)			throw  new MiException("El piso no puede tener mas de 2 digitos");
		if(letra.length()>2)		throw  new MiException("La letra no puede tener mas de 2 digitos");
		if(escalera.length()>9)		throw  new MiException("La escalera no puede tener mas de 9 letras");
		if(cod_postal.length()>5)	throw  new MiException("El codigo postal no puede tener mas de 5 digitos");
		if(telefono.length()>9)		throw  new MiException("El telefono no puede tener mas de 9 digitos");

		
		String queryInsert = "INSERT INTO `clientes` (`NOM_USER`, " +
													"`PASS`, " +
													"`NOMBRE`, " +
													"`APELLIDOS`, " +
													"`DIRECCION`, " +
													"`NUMERO`, " +
													"`PISO`, " +
													"`LETRA`, " +
													"`ESCALERA`, " +
													"`COD_POSTAL`, " +
													"`TELEFONO`) " +
											"VALUES ('"+nom_user+"', " +
													"'"+pass+"', " +
													"'"+nombre+"', " +
													"'"+apellidos+"', " +
													"'"+direccion+"', " +
													"'"+numero+"', " +
													"'"+piso+"', " +
													"'"+letra+"', " +
													"'"+escalera+"', " +
													"'"+cod_postal+"', " +
													"'"+telefono+"')";
		Statement orden;
		ClienteBean clienteInsertado =null;
		System.out.println('1');
		Connection conexion = ConexionMySql.getConexionMySql();
		System.out.println('2');
		try {
			System.out.println('3');
			orden = conexion.createStatement();
			System.out.println('4');
			int j= orden.executeUpdate(queryInsert);
			System.out.println('5');
			clienteInsertado = new ClienteBean();
			System.out.println('6');
			clienteInsertado.setNom_user(nom_user);
			clienteInsertado.setNombre(nombre);
			clienteInsertado.setApellidos(apellidos);
			clienteInsertado.setDireccion(direccion);
			clienteInsertado.setNumero(numero);
			clienteInsertado.setPiso(piso);
			clienteInsertado.setCod_postal(cod_postal);
			clienteInsertado.setTelefono(telefono);
			clienteInsertado.setEscalera(escalera);
			clienteInsertado.setLetra(letra);
			orden.close();
		} catch (SQLException e) {
			System.out.println(e.getErrorCode());
			if (e.getErrorCode()==1062)  
				throw new MiException("Nombre de usuario utilizado");
			else 	if (e.getErrorCode()==2291)
				throw new MiException("Operacion no posible en estos momentos, repita el proceso");
			else 
				e.printStackTrace();	
		}finally{
			try {
				conexion.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return clienteInsertado;
	}
	
	/**
	 * inserta un cliente en la base de datos
	 * @param nom_user nombre del usuario PK
	 * @param pass contrase�a
	 * @param pass_r contrase�a repetida
	 * @param nombre, nombre real del cliente
	 * @param apellidos
	 * @param direccion
	 * @param numero
	 * @param piso, puede ser null
	 * @param letra, puede ser null
	 * @param escalera, puede ser null
	 * @param cod_postal, codigo postal
	 * @param telefono
	  * @throws MiException permite capturar el error depurado que se ha producido en la base de datos 
	  * con el metodo toString() heredado de la clase Exception.
	 */
	public void insertarCliente( String nom_user,
						            String pass,
						            String pass_r,
						            String nombre,
						            String apellidos,
						            String direccion,
						            String numero,
						            String piso,
						            String letra,
						            String escalera,
						            String cod_postal,
						            String telefono ) throws MiException{
		
		if((nom_user == null)    ||   (cadenaVacia(nom_user) == null))throw  new MiException("Tiene que introducir su nombre de usuario");
		if((pass == null)        ||       (cadenaVacia(pass) == null))throw  new MiException("Tiene que introducir la contrase�a");
		if((pass_r == null)      ||     (cadenaVacia(pass_r) == null))throw  new MiException("Tiene que repetir la contrase�a");
		if((nombre == null)      ||     (cadenaVacia(nombre) == null))throw  new MiException("Tiene que introducir su nombre");
		if((apellidos == null)   ||  (cadenaVacia(apellidos) == null))throw  new MiException("Tiene que introducir sus apellidos");
		if((numero == null)      ||     (cadenaVacia(numero) == null))throw  new MiException("Tiene que introducir el numero del portal");
		if((direccion == null)   ||  (cadenaVacia(direccion) == null))throw  new MiException("Tiene que introducir la direccion de su calle");
		if((cod_postal == null)  || (cadenaVacia(cod_postal) == null))throw  new MiException("Tiene que introducir su codigo postal");
		if((telefono == null)    ||   (cadenaVacia(telefono) == null))throw  new MiException("Tiene que introducir su telefono");
		if(!pass.equals(pass_r))throw  new MiException("Las contrase�as introducidas no coinciden");
		/*LONGITUD DE CAMPOS*/
		if(nom_user.length()>20)	throw  new MiException("El nombre del usuario no puede tener mas de 20 letras");
		if(pass.length()>20)    	throw  new MiException("El nombre del usuario no puede tener mas de 20 letras");
		if(nombre.length()>20)		throw  new MiException("El nombre del usuario no puede tener mas de 20 letras");
		if(apellidos.length()>20)	throw  new MiException("Los apellidos no puede tener mas de 45 letras");
		if(direccion.length()>20)	throw  new MiException("La direcci�n no puede tener mas de 145 letras");
		if(numero.length()>20)		throw  new MiException("El numero no puede tener mas de 2 digitos");
		if(piso.length()>20)		throw  new MiException("El piso no puede tener mas de 2 digitos");
		if(letra.length()>20)		throw  new MiException("La letra no puede tener mas de 2 digitos");
		if(escalera.length()>20)	throw  new MiException("La escalera no puede tener mas de 9 letras");
		if(cod_postal.length()>20)	throw  new MiException("El codigo postal no puede tener mas de 5 digitos");
		if(telefono.length()>20)	throw  new MiException("El telefono no puede tener mas de 9 digitos");

		
		String queryInsert = "INSERT INTO `clientes` (`NOM_USER`, " +
													"`PASS`, " +
													"`NOMBRE`, " +
													"`APELLIDOS`, " +
													"`DIRECCION`, " +
													"`NUMERO`, " +
													"`PISO`, " +
													"`LETRA`, " +
													"`ESCALERA`, " +
													"`COD_POSTAL`, " +
													"`TELEFONO`) " +
											"VALUES ('"+nom_user+"', " +
													"'"+pass+"', " +
													"'"+nombre+"', " +
													"'"+apellidos+"', " +
													"'"+direccion+"', " +
													"'"+numero+"', " +
													"'"+piso+"', " +
													"'"+letra+"', " +
													"'"+escalera+"', " +
													"'"+cod_postal+"', " +
													"'"+telefono+"')";
		Statement orden = null;
		Connection conexion = ConexionMySql.getConexionMySql();
		try {
			orden = conexion.createStatement();
			int j= orden.executeUpdate(queryInsert);
			orden.close();
		} catch (SQLException e) {
			if (e.getErrorCode()==1)  
				throw new MiException("Nombre de usuario utilizado");
			else 	if (e.getErrorCode()==2291)
				throw new MiException("Operacion no posible en estos momentos, repita el proceso");
			else 
				throw new MiException(e.toString());	
		}finally{
			try {
				orden.close();
				conexion.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
}

