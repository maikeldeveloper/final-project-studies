package beans;

import java.io.Serializable;

public class ProductoBean implements Serializable {
	private String cod_pro;
	private String cod_sub;
	private String nombre;
	private float precio;
	private String descripcion;
	private String url_foto;
	
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public String getUrl_foto() {
		return url_foto;
	}
	public void setUrl_foto(String url_foto) {
		this.url_foto = url_foto;
	}
	public String getCod_pro() {
		return cod_pro;
	}
	public void setCod_pro(String cod_pro) {
		this.cod_pro = cod_pro;
	}
	public String getCod_sub() {
		return cod_sub;
	}
	public void setCod_sub(String cod_sub) {
		this.cod_sub = cod_sub;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
