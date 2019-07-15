package clases;
import java.util.Iterator;
import java.util.Vector;

import clases.Producto;
import excepciones.MiException;
import beans.ProductoBean;
import java.io.Serializable;

public class Lin_Ped  implements Serializable {
	private ProductoBean producto;
	private int cantidadProducto;
	
	public Lin_Ped(ProductoBean product, int cantidad){
		producto = product;
		cantidadProducto = cantidad;
	}
	
	public static Vector<Lin_Ped> addLin_Ped(Vector<Lin_Ped> carrito, String cod_pro, int cantidad){
		ProductoBean productoNuevo = Producto.getProductoByCodigo(cod_pro);
		Lin_Ped nuevaLineaPedido = new Lin_Ped(productoNuevo,cantidad);
		if (carrito.size()>0) {
			boolean existe = false;
			for(Lin_Ped articulo : carrito){
				if (articulo.getProducto().getCod_pro().equals(cod_pro)) {
					articulo.setCantidadProducto(articulo.getCantidadProducto() + cantidad);
					existe = true;
					break;
				}
			}
			if(!existe){
				carrito.add(nuevaLineaPedido);
			}
		}else{
			carrito.add(nuevaLineaPedido);
		}
		return carrito;
	}
	
	public static Vector<Lin_Ped> eliminarLin_Ped(Vector<Lin_Ped> carrito, String cod_pro) throws MiException{
		boolean eliminado = false;
		
		for(Iterator producto = carrito.iterator(); producto.hasNext();){
			Lin_Ped productoComodin = (Lin_Ped) producto.next();
			if(productoComodin.getProducto().getCod_pro().equals(cod_pro)){
				producto.remove();
				eliminado = true;
			}
		}
		if(!eliminado){
			throw new MiException("Se ha tratado de eliminar un producto que no esta en el carrito");
		}
		return carrito;
	}
	
	
	public ProductoBean getProducto() {
		return producto;
	}

	public void setProducto(ProductoBean producto) {
		this.producto = producto;
	}

	public int getCantidadProducto() {
		return cantidadProducto;
	}

	public void setCantidadProducto(int cantidadProducto) {
		this.cantidadProducto = cantidadProducto;
	}
}
