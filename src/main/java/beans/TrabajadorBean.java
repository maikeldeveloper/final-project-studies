package beans;

import java.io.Serializable;

public class TrabajadorBean implements Serializable {
	private String cod_tra;
	private String dni;
	private String nombre;
	private String apellidos;
	private String nacionalidad;
	private String telefono;
	
	public String getCod_tra() {
		return cod_tra;
	}
	public void setCod_tra(String cod_tra) {
		this.cod_tra = cod_tra;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getNacionalidad() {
		return nacionalidad;
	}
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

}
