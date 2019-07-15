package beans;

public class PedidoBean {
	private String cod_ped;
	private String nom_user;
	private String dia_hora;
	private ClienteBean cliente;
	
	public ClienteBean getCliente() {
		return cliente;
	}
	public void setCliente(ClienteBean cliente) {
		this.cliente = cliente;
	}
	public String getCod_ped() {
		return cod_ped;
	}
	public void setCod_ped(String cod_ped) {
		this.cod_ped = cod_ped;
	}
	public String getNom_user() {
		return nom_user;
	}
	public void setNom_user(String nom_user) {
		this.nom_user = nom_user;
	}
	public String getDia_hora() {
		return dia_hora;
	}
	public void setDia_hora(String dia_hora) {
		this.dia_hora = dia_hora;
	}

}
