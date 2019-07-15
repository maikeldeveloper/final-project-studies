package beans;

import java.io.Serializable;

@SuppressWarnings("serial")
public class MenuSubFamiliaBean  implements Serializable{
	private String cod_sub;
	private String cod_fam;
	private String nom_sub;
	private String img_sub;
	
	public String getImg_sub() {
		return img_sub;
	}
	public void setImg_sub(String img_sub) {
		this.img_sub = img_sub;
	}
	public String getCod_sub() {
		return cod_sub;
	}
	public void setCod_sub(String cod_sub) {
		this.cod_sub = cod_sub;
	}
	public String getCod_fam() {
		return cod_fam;
	}
	public void setCod_fam(String cod_fam) {
		this.cod_fam = cod_fam;
	}
	public String getNom_sub() {
		return nom_sub;
	}
	public void setNom_sub(String nom_sub) {
		this.nom_sub = nom_sub;
	}
}
