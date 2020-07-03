package co.com.bancolombia.entities;

public class Factura {
	private int numeroFactura;
	private int identificacionCliente;
	private int codigoProducto;
	private int precioUnitario;
	private int cantidadComprada;
	
	public Factura() {
		super();
	}

	public Factura(int numeroFactura, int identificacionCliente, int codigoProducto, int precioUnitario,
			int cantidadComprada) {
		super();
		this.numeroFactura = numeroFactura;
		this.identificacionCliente = identificacionCliente;
		this.codigoProducto = codigoProducto;
		this.precioUnitario = precioUnitario;
		this.cantidadComprada = cantidadComprada;
	}

	public int getNumeroFactura() {
		return numeroFactura;
	}

	public void setNumeroFactura(int numeroFactura) {
		this.numeroFactura = numeroFactura;
	}

	public int getIdentificacionCliente() {
		return identificacionCliente;
	}

	public void setIdentificacionCliente(int identificacionCliente) {
		this.identificacionCliente = identificacionCliente;
	}

	public int getCodigoProducto() {
		return codigoProducto;
	}

	public void setCodigoProducto(int codigoProducto) {
		this.codigoProducto = codigoProducto;
	}

	public int getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(int precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public int getCantidadComprada() {
		return cantidadComprada;
	}

	public void setCantidadComprada(int cantidadComprada) {
		this.cantidadComprada = cantidadComprada;
	}

	@Override
	public String toString() {
		return "Factura [numeroFactura=" + numeroFactura + ", identificacionCliente=" + identificacionCliente
				+ ", codigoProducto=" + codigoProducto + ", precioUnitario=" + precioUnitario + ", cantidadComprada="
				+ cantidadComprada + "]";
	}
	
	
	
}
