package co.com.bancolombia.servicesImpl;

import javax.swing.JOptionPane;

import co.com.bancolombia.repository.AccionesBd;
import co.com.bancolombia.services.FacturaServices;

public class FacturaServicesImpl implements FacturaServices {

	AccionesBd accionesBd = new AccionesBd();

	@Override
	public void nuevaVenta() {

		String seguir = "";
		int itemsComprados = 0;

		int idPersona = Integer.parseInt(JOptionPane.showInputDialog("Digite identificacion del cliente"));
		String datosPersona = accionesBd.ConsultarPersona2(idPersona);
		if (datosPersona == "No existe la persona buscada") {
			JOptionPane.showMessageDialog(null, "Cliente no exite");
		} else {

			int ConsecutivoFactura = accionesBd.ConsultarUltimoConsecutivoFactura() + 1;

			do {

				int codProducto = Integer
						.parseInt(JOptionPane.showInputDialog(datosPersona + "\n\nDigite codigo del producto"));
				String datosProducto = accionesBd.ConsultarProducto(codProducto);
				if (datosProducto == "No existe el producto buscado") {
					seguir = JOptionPane.showInputDialog("El producto no exite, desea seguir comprando? (S/N)");
				} else {
					if (accionesBd.consultarExistenciaItemFactura(ConsecutivoFactura, idPersona, codProducto) != 0) {
						seguir = JOptionPane
								.showInputDialog("Ya incluyó ese item en la compra, desea seguir con otro item? (S/N)");
					} else {

						int existencias = accionesBd.ConsultarExistenciasProducto(codProducto);
						if (existencias <= 0) {
							seguir = JOptionPane
									.showInputDialog("No hay existencias del producto, desea seguir comprando? (S/N)");
						} else {
							int precioUnitario = accionesBd.ConsultarPrecioUnitarioProducto(codProducto);
							int cantidadComprar = Integer.parseInt(JOptionPane.showInputDialog(
									datosPersona + "\n\n" + datosProducto + "\n\nDigite la cantidad a comprar"));
							if (cantidadComprar <= 0 || cantidadComprar > existencias) {
								seguir = JOptionPane
										.showInputDialog("Cantidad no válida, desea seguir comprando? (S/N)");

							} else {

								int nuevaCantidadInventario = existencias - cantidadComprar;
								seguir = JOptionPane.showInputDialog("Factura Numero: " + ConsecutivoFactura + "\n"
										+ accionesBd.grabaItemFactura(ConsecutivoFactura, idPersona, codProducto,
												precioUnitario, cantidadComprar)
										+ "\n"
										+ accionesBd.ModificaRegistroProducto(codProducto,
												String.valueOf(nuevaCantidadInventario), "cantidad")
										+ "\nDesea seguir adicionando items a la compra? (S/N)");
								itemsComprados = itemsComprados + 1;

							}
						}
					}
				}

			} while (seguir.equals("S") || seguir.equals("s"));

			if (itemsComprados > 0) {
				JOptionPane.showMessageDialog(null, accionesBd.consultaUnaFactura(ConsecutivoFactura));

			}

		}

	}

	@Override
	public void listarVentas() {
		JOptionPane.showMessageDialog(null, accionesBd.listarFacturas());
	}

	@Override
	public void consultarFactura() {
		int numFac = Integer.parseInt(JOptionPane.showInputDialog("Digite el numero de la factura"));
		JOptionPane.showMessageDialog(null, accionesBd.consultaUnaFactura(numFac));
	}

}
