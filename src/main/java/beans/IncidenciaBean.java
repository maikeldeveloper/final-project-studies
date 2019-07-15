package beans;

public class IncidenciaBean {
	private int cod_inc;
	private int cod_ped;
	private String descripcion;
	private TicketsBean ticketIncindecia;
	
	public TicketsBean getTicketIncindecia() {
		return ticketIncindecia;
	}
	public void setTicketIncindecia(TicketsBean ticketIncindecia) {
		this.ticketIncindecia = ticketIncindecia;
	}
	public int getCod_inc() {
		return cod_inc;
	}
	public void setCod_inc(int cod_inc) {
		this.cod_inc = cod_inc;
	}
	public int getCod_ped() {
		return cod_ped;
	}
	public void setCod_ped(int cod_ped) {
		this.cod_ped = cod_ped;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
