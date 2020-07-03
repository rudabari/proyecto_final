package co.com.bancolombia.servicesImpl;

import javax.swing.JOptionPane;

import co.com.bancolombia.entities.Producto;
import co.com.bancolombia.repository.AccionesBd;
import co.com.bancolombia.services.ProductoServices;

public class ProductoServicesImpl implements ProductoServices {

	AccionesBd accionesBd = new AccionesBd();

	public void listarProductos() {
		JOptionPane.showMessageDialog(null, accionesBd.listarProductos());
	}

	@Override
	public void consultarProducto() {
		int id = Integer.parseInt(JOptionPane.showInputDialog("Digite codigo del producto"));
		JOptionPane.showMessageDialog(null, accionesBd.ConsultarProducto(id));
	}

	@Override
	public void eliminarProducto() {
		int codProd = Integer.parseInt(JOptionPane.showInputDialog("Digite codigo del producto"));
		String datosProducto = accionesBd.ConsultarProducto(codProd);
		if (datosProducto == "No existe el producto buscado") {
			JOptionPane.showMessageDialog(null, datosProducto);
		} else {
			String respuestaBorrar = JOptionPane
					.showInputDialog(datosProducto + "\n\nConfirma borrar el producto? (S/N)\n\n");
			if (respuestaBorrar.contentEquals("s") || respuestaBorrar.contentEquals("S")) {
				JOptionPane.showMessageDialog(null, accionesBd.EliminarRegistroProductos(codProd));
			}
		}
	}

	@Override
	public void crearProducto() {
		int codProd = Integer.parseInt(JOptionPane.showInputDialog("Digite codigo"));
		String datosProd = accionesBd.ConsultarProducto(codProd);
		if (datosProd == "No existe el producto buscado") {
			String descripcion = JOptionPane.showInputDialog("Digite la descripcion");
			int precio = Integer.parseInt(JOptionPane.showInputDialog("Digite el precio"));
			int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Digite la cantidad en inventario"));
			Producto articulo = new Producto(codProd, descripcion, precio, cantidad);

			String respuesta = accionesBd.crearProducto(articulo);

			JOptionPane.showMessageDialog(null, respuesta);
		} else {
			JOptionPane.showMessageDialog(null, "El producto ya existe. Corresponde a:\n\n" + datosProd);
		}

	}

	@Override
	public void modificaProductoDescripcion() {
		int codProd = Integer.parseInt(JOptionPane.showInputDialog("Digite codigo del producto"));
		String datosProducto = accionesBd.ConsultarProducto(codProd);
		if (datosProducto == "No existe el producto buscado") {
			JOptionPane.showMessageDialog(null, datosProducto);
		} else {
			String nuevaDescripcion = JOptionPane
					.showInputDialog(datosProducto + "\n\nDigite la nueva descripcion para el producto");
			JOptionPane.showMessageDialog(null,
					accionesBd.ModificaRegistroProducto(codProd, nuevaDescripcion, "Descripcion"));
		}
	}

	@Override
	public void modificaProductoPrecio() {
		int codProd = Integer.parseInt(JOptionPane.showInputDialog("Digite codigo del producto"));
		String datosProducto = accionesBd.ConsultarProducto(codProd);
		if (datosProducto == "No existe el producto buscado") {
			JOptionPane.showMessageDialog(null, datosProducto);
		} else {
			String nuevoPrecio = JOptionPane
					.showInputDialog(datosProducto + "\n\nDigite el nuevo precio para el producto");
			JOptionPane.showMessageDialog(null,
					accionesBd.ModificaRegistroProducto(codProd, nuevoPrecio, "Precio"));
		}
	}

	@Override
	public void modificaProductoCantidad() {
		int codProd = Integer.parseInt(JOptionPane.showInputDialog("Digite codigo del producto"));
		String datosProducto = accionesBd.ConsultarProducto(codProd);
		if (datosProducto == "No existe el producto buscado") {
			JOptionPane.showMessageDialog(null, datosProducto);
		} else {
			String nuevaCantidad = JOptionPane
					.showInputDialog(datosProducto + "\n\nDigite la nueva cantidad para el producto");
			JOptionPane.showMessageDialog(null,
					accionesBd.ModificaRegistroProducto(codProd, nuevaCantidad, "CANTIDAD"));
		}
	}
	
}


