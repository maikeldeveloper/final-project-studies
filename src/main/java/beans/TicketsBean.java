package beans;

import java.util.Vector;

public class TicketsBean {
	private String cod_enc;
	private String cod_rep;
	private String hora_salida;
	private String hora_llegada;
	private String hora_pedido;
	private String tiempo_en_salir;
	private int cod_tic;
	private float importe_ticket;
	private float importe_perdido;
	
	public float getImporte_perdido() {
		return importe_perdido;
	}
	public void setImporte_perdido(float importe_perdido) {
		this.importe_perdido = importe_perdido;
	}
	private RepartidorBeans repartidor;
	private IncidenciaBean incidencia;
	
	public IncidenciaBean getIncidencia() {
		return incidencia;
	}
	public void setIncidencia(IncidenciaBean incidencia) {
		this.incidencia = incidencia;
	}
	public RepartidorBeans getRepartidor() {
		return repartidor;
	}
	public void setRepartidor(RepartidorBeans repartidor) {
		this.repartidor = repartidor;
	}
	public EncargadoBean getEncargado() {
		return encargado;
	}
	public void setEncargado(EncargadoBean encargado) {
		this.encargado = encargado;
	}
	private EncargadoBean encargado;
	
	public float getImporte_ticket() {
		return importe_ticket;
	}
	public void setImporte_ticket(float importe_ticket) {
		this.importe_ticket = importe_ticket;
	}
	private ClienteBean cliente;
	private Vector<Lin_PedBean> lineasPedido;
	
	public Vector<Lin_PedBean> getLineasPedido() {
		return lineasPedido;
	}
	public void setLineasPedido(Vector<Lin_PedBean> lineasPedido) {
		this.lineasPedido = lineasPedido;
	}
	public ClienteBean getCliente() {
		return cliente;
	}
	public void setCliente(ClienteBean cliente) {
		this.cliente = cliente;
	}
	public int getCod_tic() {
		return cod_tic;
	}
	public void setCod_tic(int i) {
		this.cod_tic = i;
	}
	public String getCod_enc() {
		return cod_enc;
	}
	public void setCod_enc(String cod_enc) {
		this.cod_enc = cod_enc;
	}
	public String getCod_rep() {
		return cod_rep;
	}
	public void setCod_rep(String cod_rep) {
		this.cod_rep = cod_rep;
	}
	public String getHora_salida() {
		return hora_salida;
	}
	public void setHora_salida(String hora_salida) {
		this.hora_salida = hora_salida;
	}
	public String getHora_llegada() {
		return hora_llegada;
	}
	public void setHora_llegada(String hora_llegada) {
		this.hora_llegada = hora_llegada;
	}
	public String getHora_pedido() {
		return hora_pedido;
	}
	public void setHora_pedido(String hora_pedido) {
		this.hora_pedido = hora_pedido;
	}
	public String getTiempo_en_salir() {
		return tiempo_en_salir;
	}
	public void setTiempo_en_salir(String tiempo_en_salir) {
		this.tiempo_en_salir = tiempo_en_salir;
	}

}
