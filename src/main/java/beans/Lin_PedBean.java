package beans;

public class Lin_PedBean {
	private int cod_pro;
	private int cod_ped;
	private int cantidad;
	private float precio_uni;
	private int cantidad_perdida;
	private float precio_uni_perdida;
	private ProductoBean producto;
	public ProductoBean getProducto() {
		return producto;
	}
	public void setProducto(ProductoBean producto) {
		this.producto = producto;
	}
	public int getCod_pro() {
		return cod_pro;
	}
	public void setCod_pro(int i) {
		this.cod_pro = i;
	}
	public int getCod_ped() {
		return cod_ped;
	}
	public void setCod_ped(int cod_ped) {
		this.cod_ped = cod_ped;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public float getPrecio_uni() {
		return precio_uni;
	}
	public void setPrecio_uni(float precio_uni) {
		this.precio_uni = precio_uni;
	}
	public int getCantidad_perdida() {
		return cantidad_perdida;
	}
	public void setCantidad_perdida(int cantidad_perdida) {
		this.cantidad_perdida = cantidad_perdida;
	}
	public float getPrecio_uni_perdida() {
		return precio_uni_perdida;
	}
	public void setPrecio_uni_perdida(float precio_uni_perdida) {
		this.precio_uni_perdida = precio_uni_perdida;
	}
}
