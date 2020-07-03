package co.com.bancolombia;

import javax.swing.JOptionPane;

import co.com.bancolombia.services.FacturaServices;
import co.com.bancolombia.services.PersonaServices;
import co.com.bancolombia.services.ProductoServices;
import co.com.bancolombia.servicesImpl.PersonaServicesImpl;
import co.com.bancolombia.servicesImpl.ProductoServicesImpl;
import co.com.bancolombia.servicesImpl.FacturaServicesImpl;

public class ProyectoFinal {

	public static void main(String[] args) {

		PersonaServices personaServices = new PersonaServicesImpl();
		ProductoServices productoServices = new ProductoServicesImpl();
		FacturaServices facturaServices = new FacturaServicesImpl();

		int opcion = 0;
		int opcionSubmenu1 = 0;
		int opcionSubmenu1_5 = 0;
		int opcionSubmenu2 = 0;
		int opcionSubmenu2_5 = 0;
		int opcionSubmenu3 = 0;

		do {

			String numOpcion = JOptionPane.showInputDialog(
					"1. Archivo personas\n" + "2. Inventario productos\n" + "3. Facturacion\n\n" + "9. Salir\n\n");

			opcion = Integer.parseInt(numOpcion);

			// Evaluar opción ingresada
			switch (opcion) {
			case 1: // submenu personas
				do {
					String numOpcionSubmenu1 = JOptionPane.showInputDialog("1. Crear persona\n" + "2. Listar personas\n"
							+ "3. Consultar persona\n" + "4. Eliminar persona\n" + "5. Modificar persona\n\n"
							+ "9. Volver al menu principal\n\n");
					opcionSubmenu1 = Integer.parseInt(numOpcionSubmenu1);
					switch (opcionSubmenu1) {
					case 1: // crear persona
						personaServices.crearPersona();
						break;
					case 2: // listar persona
						personaServices.listarPersonas();
						break;
					case 3: // consultar persona por identific
						personaServices.consultarPersona();
						break;
					case 4: // eliminar persona por identific
						personaServices.eliminarPersona();
						break;
					case 5: // submenu de modificar personas
						do {
							String numOpcionSubmenu1_5 = JOptionPane.showInputDialog("1. Modificar Nombre\n"
									+ "2. Modificar edad\n\n" + "9. Volver al menu amterior\n\n");
							opcionSubmenu1_5 = Integer.parseInt(numOpcionSubmenu1_5);
							switch (opcionSubmenu1_5) {
							case 1: // crear nombre
								personaServices.modificarPersonaNombre();
								break;
							case 2: // listar edad
								personaServices.modificarPersonaEdad();
								break;
							default:
								break;
							}
						} while (opcionSubmenu1_5 != 9);
						break;

					default:
						break;
					}
				} while (opcionSubmenu1 != 9);
				break;

			case 2: // submenu productos
				do {

					String numOpcionSubmenu2 = JOptionPane.showInputDialog("1. Crear producto\n"
							+ "2. Listar productos\n" + "3. Consultar producto\n" + "4. Eliminar producto\n"
							+ "5. Modificar producto\n\n" + "9. Volver al menu principal\n\n");
					opcionSubmenu2 = Integer.parseInt(numOpcionSubmenu2);
					switch (opcionSubmenu2) {
					case 1: // crear producto
						productoServices.crearProducto();
						break;
					case 2: // listar productos
						productoServices.listarProductos();
						break;
					case 3: // consultar producto por codigo
						productoServices.consultarProducto();
						break;
					case 4: // eliminar producto por codigo
						productoServices.eliminarProducto();
						break;
					case 5: // submenu de modificar producto
						do {
							String numOpcionSubmenu2_5 = JOptionPane.showInputDialog("1. Modificar descripcion\n"
									+ "2. Modificar precio unitario\n" + "3. Modificar cantidad en inventario\n\n"
									+ "9. Volver al menu amterior\n\n");
							opcionSubmenu2_5 = Integer.parseInt(numOpcionSubmenu2_5);
							switch (opcionSubmenu2_5) {
							case 1: // modifica descripcion del producto
								productoServices.modificaProductoDescripcion();
								break;
							case 2: // modifica precio unitario
								productoServices.modificaProductoPrecio();
								break;
							case 3: // modifica cantidad en inventario
								productoServices.modificaProductoCantidad();
								break;
							default:
								break;
							}
						} while (opcionSubmenu2_5 != 9);
						break;
					default:
						break;
					}
				} while (opcionSubmenu2 != 9);
				break;

			case 3: // facturacion
				do {

					String numOpcionSubmenu3 = JOptionPane.showInputDialog("1. Nueva venta\n"
							+ "2. Listar ventas\n3. Consultar factura\n\n" + "9. Volver al menu principal\n\n");
					opcionSubmenu3 = Integer.parseInt(numOpcionSubmenu3);
					switch (opcionSubmenu3) {
					case 1: // nueva venta
						facturaServices.nuevaVenta();
						break;
					case 2: // listar ventas
						facturaServices.listarVentas();
						break;
					case 3:
						facturaServices.consultarFactura();
						break;
					default:
						break;
					}
				} while (opcionSubmenu3 != 9);
				break;

			default:
				break;
			}
		} while (opcion != 9);

	}

}
