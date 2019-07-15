package beans;

public class BalanceBean {
	private int num_pedidos;
	private int num_incidencias;
	private float importe_pedidos;
	private float importe_incidencias;
	private float importe_total;
	
	public int getNum_pedidos() {
		return num_pedidos;
	}
	public void setNum_pedidos(int num_pedidos) {
		this.num_pedidos = num_pedidos;
	}
	public int getNum_incidencias() {
		return num_incidencias;
	}
	public void setNum_incidencias(int num_incidencias) {
		this.num_incidencias = num_incidencias;
	}
	public float getImporte_pedidos() {
		return importe_pedidos;
	}
	public void setImporte_pedidos(float importe_pedidos) {
		this.importe_pedidos = importe_pedidos;
	}
	public float getImporte_incidencias() {
		return importe_incidencias;
	}
	public void setImporte_incidencias(float importe_incidencias) {
		this.importe_incidencias = importe_incidencias;
	}
	public float getImporte_total() {
		return importe_total;
	}
	public void setImporte_total(float importe_total) {
		this.importe_total = importe_total;
	}
}
