package beans;

import java.io.Serializable;

public class FamiliaProductoBean implements Serializable {
	private String nombreFamilia;
	private String cod_familia;
	private String ordenMenuFamilias;
	
	public String getNombreFamilia() {
		return nombreFamilia;
	}
	public void setNombreFamilia(String nombreFamilia) {
		this.nombreFamilia = nombreFamilia;
	}
	public String getCod_familia() {
		return cod_familia;
	}
	public void setCod_familia(String cod_familia) {
		this.cod_familia = cod_familia;
	}
	public String getOrdenMenuFamilias() {
		return ordenMenuFamilias;
	}
	public void setOrdenMenuFamilias(String ordenMenuFamilias) {
		this.ordenMenuFamilias = ordenMenuFamilias;
	}
	
}
