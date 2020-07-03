package co.com.bancolombia.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import co.com.bancolombia.config.DbConnection;
import co.com.bancolombia.entities.Persona;
import co.com.bancolombia.entities.Producto;

public class AccionesBd {

	DbConnection dbConnection = new DbConnection();

	// inserta registro en tabla personas
	public String crearPersona(Persona persona) {

		String sql = "INSERT INTO PERSONA(IDENTIFICACION, NOMBRE, EDAD) VALUES (?,?,?)";

		Connection con = dbConnection.getConnection();

		try {

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setObject(1, persona.getIdentificacion());
			ps.setObject(2, persona.getNombre());
			ps.setObject(3, persona.getEdad());
			ps.executeUpdate();

			return "Persona registrada satisfactoriamente";

		} catch (SQLException e) {
			return "Error " + e.getMessage();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {

			}
		}

	}

	// selecciona todos los registros de personas
	public String listarPersonas() {
		String sql = "SELECT * FROM PERSONA";

		String respuesta = "";

		Connection con = dbConnection.getConnection();

		try {

			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			boolean flag = false;
			while (rs.next()) {

				flag = true;
				Persona persona = new Persona();
				persona.setIdentificacion(rs.getInt(1));
				persona.setNombre(rs.getString(2));
				persona.setEdad(rs.getInt(3));
				respuesta += persona.toString() + "\n-----------------------\n";
				;

			}

			if (flag == true) {
				return respuesta;
			} else {
				return "No hay personas registradas";
			}

		} catch (SQLException e) {
			return "Error " + e.getMessage();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {

			}
		}
	}

	// selecciona UN solo registro de la tabla personas
	public String ConsultarPersona(int idPersona) {
		String sql = "SELECT * FROM PERSONA WHERE IDENTIFICACION = " + idPersona;

		String respuesta = "";

		Connection con = dbConnection.getConnection();

		try {

			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			boolean flag = false;
			while (rs.next()) {

				flag = true;
				Persona persona = new Persona();
				persona.setIdentificacion(rs.getInt(1));
				persona.setNombre(rs.getString(2));
				persona.setEdad(rs.getInt(3));
				respuesta = persona.toString();
				;

			}

			if (flag == true) {
				return respuesta;
			} else {
				return "No existe la persona buscada";
			}

		} catch (SQLException e) {
			return "Error " + e.getMessage();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {

			}
		}
	}

	// eliminar registro de la tabla personas
	public String EliminarRegistroPersonas(int idPersona) {

		String sql = "DELETE FROM PERSONA WHERE IDENTIFICACION = " + idPersona;

		String respuesta = "";

		Connection con = dbConnection.getConnection();

		try {

			PreparedStatement ps = con.prepareStatement(sql);
			ps.execute();
			respuesta = "Registro eliminado exitosamente";

		} catch (SQLException e) {
			respuesta = "Error " + e.getMessage();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {

			}
		}
		return respuesta;

	}

	// modificar registro de la tabla personas
	public String ModificarRegistroPersonas(int idPersona, String cadena, String campo) {

		String sql = "UPDATE PERSONA SET " + campo + " = '" + cadena + "' WHERE IDENTIFICACION = " + idPersona;

		String respuesta = "";

		Connection con = dbConnection.getConnection();

		try {

			PreparedStatement ps = con.prepareStatement(sql);
			ps.execute();
			respuesta = campo + " actualizado exitosamente";

		} catch (SQLException e) {
			respuesta = "Error " + e.getMessage();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {

			}
		}
		return respuesta;

	}

	// selecciona todos los registros de productos
	public String listarProductos() {
		String sql = "SELECT CODIGO, DESCRIPCION, PRECIO, CANTIDAD FROM PRODUCTO";

		String respuesta = "";

		Connection con = dbConnection.getConnection();

		try {

			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			boolean flag = false;
			while (rs.next()) {

				flag = true;
				Producto articulo = new Producto();
				articulo.setCodigo(rs.getInt(1));
				articulo.setDescripcion(rs.getString(2));
				articulo.setPrecio(rs.getInt(3));
				articulo.setCantidad(rs.getInt(4));
				respuesta += articulo.toString() + "\n-----------------------\n";

			}

			if (flag == true) {
				return respuesta;
			} else {
				return "No hay productos registrados";
			}

		} catch (SQLException e) {
			return "Error " + e.getMessage();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {

			}
		}
	}

	// selecciona UN solo registro de la tabla productos
	public String ConsultarProducto(int codProd) {
		String sql = "SELECT * FROM PRODUCTO WHERE CODIGO = " + codProd;

		String respuesta = "";

		Connection con = dbConnection.getConnection();

		try {

			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			boolean flag = false;
			while (rs.next()) {

				flag = true;
				Producto articulo = new Producto();
				articulo.setCodigo(rs.getInt(1));
				articulo.setDescripcion(rs.getString(2));
				articulo.setPrecio(rs.getInt(3));
				articulo.setCantidad(rs.getInt(4));
				respuesta = articulo.toString();
				;

			}

			if (flag == true) {
				return respuesta;
			} else {
				return "No existe el producto buscado";
			}

		} catch (SQLException e) {
			return "Error " + e.getMessage();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {

			}
		}
	}

	// eliminar registro de la tabla PRODUCTO
	public String EliminarRegistroProductos(int codProd) {

		String sql = "DELETE FROM PRODUCTO WHERE CODIGO = " + codProd;

		String respuesta = "";

		Connection con = dbConnection.getConnection();

		try {

			PreparedStatement ps = con.prepareStatement(sql);
			ps.execute();
			respuesta = "Registro de producto\neliminado exitosamente";

		} catch (SQLException e) {
			respuesta = "Error " + e.getMessage();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {

			}
		}
		return respuesta;

	}

	// inserta registro en tabla producto
	public String crearProducto(Producto articulo) {

		String sql = "INSERT INTO PRODUCTO (CODIGO, DESCRIPCION, PRECIO, CANTIDAD) VALUES (?,?,?,?)";

		Connection con = dbConnection.getConnection();

		try {

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setObject(1, articulo.getCodigo());
			ps.setObject(2, articulo.getDescripcion());
			ps.setObject(3, articulo.getPrecio());
			ps.setObject(4, articulo.getCantidad());
			ps.executeUpdate();

			return "Nuevo Producto registrado exitosamente";

		} catch (SQLException e) {
			return "Error " + e.getMessage();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {

			}
		}

	}

	// modificar registro de la tabla PRODUCTO
	public String ModificaRegistroProducto(int codProd, String cadena, String campo) {

		String sql = "UPDATE PRODUCTO SET " + campo + " = '" + cadena + "' WHERE CODIGO = " + codProd;

		String respuesta = "";

		Connection con = dbConnection.getConnection();

		try {

			PreparedStatement ps = con.prepareStatement(sql);
			ps.execute();
			respuesta = campo + " actualizado exitosamente";

		} catch (SQLException e) {
			respuesta = "Error " + e.getMessage();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {

			}
		}
		return respuesta;

	}

	// retorna cantidad en inventario del producto
	public int ConsultarExistenciasProducto(int codProd) {
		String sql = "SELECT CANTIDAD FROM PRODUCTO WHERE CODIGO = " + codProd;

		int respuesta = 0;

		Connection con = dbConnection.getConnection();

		try {

			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			boolean flag = false;

			while (rs.next()) {
				flag = true;
				respuesta = rs.getInt(1);
			}

			if (flag == true) {
				return respuesta;
			} else {
				return 0;
			}

		} catch (SQLException e) {
			return e.getErrorCode();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {

			}
		}
	}

	// retorna precio unitario en inventario del producto
	public int ConsultarPrecioUnitarioProducto(int codProd) {
		String sql = "SELECT PRECIO FROM PRODUCTO WHERE CODIGO = " + codProd;

		int respuesta = 0;

		Connection con = dbConnection.getConnection();

		try {

			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			boolean flag = false;

			while (rs.next()) {
				flag = true;
				respuesta = rs.getInt(1);
			}

			if (flag == true) {
				return respuesta;
			} else {
				return 0;
			}

		} catch (SQLException e) {
			return e.getErrorCode();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {

			}
		}
	}

	// recupera ultimo consecutivo de factura
	public int ConsultarUltimoConsecutivoFactura() {
		String sql = "SELECT MAX(NUMEROFACTURA) FROM FACTURACION";

		int respuesta = 0;

		Connection con = dbConnection.getConnection();

		try {

			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			boolean flag = false;

			while (rs.next()) {
				flag = true;
				respuesta = rs.getInt(1);
			}

			if (flag == true) {
				return respuesta;
			} else {
				return 0;
			}

		} catch (SQLException e) {
			return e.getErrorCode();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {

			}
		}
	}

	// inserta registro en tabla personas
	public String grabaItemFactura(int consecutivo, int idCliente, int codProducto, int precioUnitario,
			int cantidadComprada) {

		String sql = "INSERT INTO FACTURACION (NUMEROFACTURA, IDENTIFICACIONCLIENTE, CODIGOPRODUCTO, PRECIOUNITARIO, CANTIDADCOMPRADA, FECHAFACTURA) VALUES (?,?,?,?,?,now())";

		Connection con = dbConnection.getConnection();

		try {

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setObject(1, consecutivo);
			ps.setObject(2, idCliente);
			ps.setObject(3, codProducto);
			ps.setObject(4, precioUnitario);
			ps.setObject(5, cantidadComprada);
			ps.executeUpdate();

			return "Item facturado exitosamente";

		} catch (SQLException e) {
			return "Error " + e.getMessage();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {

			}
		}

	}

	// selecciona todas las facturas
	public String listarFacturas() {
		String sql = "SELECT * FROM VISTAFACTURAS";

		String respuesta = "";

		Connection con = dbConnection.getConnection();

		try {

			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			int facturaAnterior = 0;
			boolean primeraLinea = true;
			int totalFactura = 0;

			boolean flag = false;
			while (rs.next()) {

				flag = true;
				int numeroFactura = rs.getInt(1);
				String fechaFactura = rs.getString(2);
				int idCliente = rs.getInt(3);
				String nomCliente = rs.getString(4);
				int codProducto = rs.getInt(5);
				String descripProducto = rs.getString(6);
				int cantidadComprada = rs.getInt(7);
				int precioUnitario = rs.getInt(8);
				int subtotal = rs.getInt(9);

				if (facturaAnterior != numeroFactura) {
					facturaAnterior = numeroFactura;
					if (primeraLinea == true) {
						primeraLinea = false;
					} else {
						respuesta += "\nTotal factura: $" + totalFactura;
						respuesta += "\n\n";
					}
					totalFactura = 0;
					respuesta += "Numero factura: " + numeroFactura + "\nFecha factura: " + fechaFactura + "\nCliente: "
							+ idCliente + " - " + nomCliente;
				}

				respuesta += "\nProducto: " + codProducto + " - " + descripProducto + " Cantidad: " + cantidadComprada
						+ " Precio unitario: $" + precioUnitario + " Subtotal: $" + subtotal;
				totalFactura += subtotal;
			}

			if (flag == true) {
				respuesta += "\nTotal factura: $" + totalFactura;
				return respuesta;
			} else {
				return "No hay facturas registradas";
			}

		} catch (SQLException e) {
			return "Error " + e.getMessage();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {

			}
		}
	}

	// selecciona todas las facturas
	public String consultaUnaFactura(int numero) {
		String sql = "SELECT * FROM VISTAFACTURAS WHERE NUMEROFACTURA = " + numero;

		String respuesta = "";

		Connection con = dbConnection.getConnection();

		try {

			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			int facturaAnterior = 0;
			boolean primeraLinea = true;
			int totalFactura = 0;

			boolean flag = false;
			while (rs.next()) {

				flag = true;
				int numeroFactura = rs.getInt(1);
				String fechaFactura = rs.getString(2);
				int idCliente = rs.getInt(3);
				String nomCliente = rs.getString(4);
				int codProducto = rs.getInt(5);
				String descripProducto = rs.getString(6);
				int cantidadComprada = rs.getInt(7);
				int precioUnitario = rs.getInt(8);
				int subtotal = rs.getInt(9);

				if (facturaAnterior != numeroFactura) {
					facturaAnterior = numeroFactura;
					if (primeraLinea == true) {
						primeraLinea = false;
					} else {
						respuesta += "\nTotal factura: $" + totalFactura;
						respuesta += "\n\n";
					}
					totalFactura = 0;
					respuesta += "Numero factura: " + numeroFactura + "\nFecha factura: " + fechaFactura + "\nCliente: "
							+ idCliente + " - " + nomCliente + "\n";
				}

				respuesta += "\nProducto: " + codProducto + " - " + descripProducto + " Cantidad: " + cantidadComprada
						+ " Precio unitario: $" + precioUnitario + " Subtotal: $" + subtotal;
				totalFactura += subtotal;
			}

			if (flag == true) {
				respuesta += "\nTotal factura: $" + totalFactura + "\n\n¡Gracias por su compra!";
				return respuesta;
			} else {
				return "No existe la factura";
			}

		} catch (SQLException e) {
			return "Error " + e.getMessage();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {

			}
		}
	}

	// retorna si un item esta incluido en una factura
	public int consultarExistenciaItemFactura(int numeroFactura, int idCliente, int codProducto) {
		String sql = "SELECT count(*) FROM FACTURACION WHERE NUMEROFACTURA = " + numeroFactura
				+ " AND IDENTIFICACIONCLIENTE = " + idCliente + " AND CODIGOPRODUCTO = " + codProducto;

		int respuesta = 0;

		Connection con = dbConnection.getConnection();

		try {

			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			boolean flag = false;

			while (rs.next()) {
				flag = true;
				respuesta = rs.getInt(1);
			}

			if (flag == true) {
				return respuesta;
			} else {
				return 0;
			}

		} catch (SQLException e) {
			return e.getErrorCode();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {

			}
		}
	}

	// selecciona UN solo registro de la tabla personas (solo id y nombre)
	public String ConsultarPersona2(int idPersona) {
		String sql = "SELECT IDENTIFICACION, NOMBRE FROM PERSONA WHERE IDENTIFICACION = " + idPersona;

		String respuesta = "";

		Connection con = dbConnection.getConnection();

		try {

			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			boolean flag = false;
			while (rs.next()) {

				flag = true;
				Persona persona = new Persona();
				persona.setIdentificacion(rs.getInt(1));
				persona.setNombre(rs.getString(2));
				respuesta = persona.toString2();
				;

			}

			if (flag == true) {
				return respuesta;
			} else {
				return "No existe la persona buscada";
			}

		} catch (SQLException e) {
			return "Error " + e.getMessage();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {

			}
		}
	}

}
