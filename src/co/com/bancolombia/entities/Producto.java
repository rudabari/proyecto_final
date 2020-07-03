package co.com.bancolombia.entities;

public class Producto {

	private int codigo;
	private String descripcion;
	private int precio;
	private int cantidad;

	public Producto() {
		super();
	}

	public Producto(int codigo, String descripcion, int precio, int cantidad) {
		super();
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.precio = precio;
		this.cantidad = cantidad;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return "codigo producto = " + codigo + "\ndescripcion = " + descripcion + "\nprecio = $" + precio
				+ "\ncantidad = " + cantidad;
	}

}
