package co.com.bancolombia.servicesImpl;

import javax.swing.JOptionPane;

import co.com.bancolombia.entities.Persona;
import co.com.bancolombia.repository.AccionesBd;
import co.com.bancolombia.services.PersonaServices;

public class PersonaServicesImpl implements PersonaServices {

	AccionesBd accionesBd = new AccionesBd();

	@Override
	public void crearPersona() {
		int id = Integer.parseInt(JOptionPane.showInputDialog("Digite identificacion"));
		String datosId = accionesBd.ConsultarPersona(id);
		if (datosId == "No existe la persona buscada") {
			String nombre = JOptionPane.showInputDialog("Digite el nombre");
			int edad = Integer.parseInt(JOptionPane.showInputDialog("Digite la edad"));
			Persona persona = new Persona(nombre, edad, id);

			String respuesta = accionesBd.crearPersona(persona);

			JOptionPane.showMessageDialog(null, respuesta);
		} else {
			JOptionPane.showMessageDialog(null, "La identificacion ya existe. Corresponde a:\n\n" + datosId);
		}

	}

	@Override
	public void consultarPersona() {
		int id = Integer.parseInt(JOptionPane.showInputDialog("Digite identificacion de la persona"));
		JOptionPane.showMessageDialog(null, accionesBd.ConsultarPersona(id));
	}

	@Override
	public void listarPersonas() {
		JOptionPane.showMessageDialog(null, accionesBd.listarPersonas());
	}

	@Override
	public void eliminarPersona() {
		int id = Integer.parseInt(JOptionPane.showInputDialog("Digite identificacion de la persona"));
		String datosPersona = accionesBd.ConsultarPersona(id);
		if (datosPersona == "No existe la persona buscada") {
			JOptionPane.showMessageDialog(null, datosPersona);
		} else {
			String respuestaBorrar = JOptionPane
					.showInputDialog(datosPersona + "\n\nConfirma borrar a la persona? (S/N)\n\n");
			if (respuestaBorrar.contentEquals("s") || respuestaBorrar.contentEquals("S")) {
				JOptionPane.showMessageDialog(null, accionesBd.EliminarRegistroPersonas(id));
			}
		}
	}

	@Override
	public void modificarPersonaNombre() {
		int id = Integer.parseInt(JOptionPane.showInputDialog("Digite identificacion"));
		String datosPersona = accionesBd.ConsultarPersona(id);
		if (datosPersona == "No existe la persona buscada") {
			JOptionPane.showMessageDialog(null, datosPersona);
		} else {
			String nuevoNombre = JOptionPane.showInputDialog(datosPersona + "\n\nDigite el nuevo nombre");
			JOptionPane.showMessageDialog(null, accionesBd.ModificarRegistroPersonas(id, nuevoNombre, "Nombre"));
		}
	}

	@Override
	public void modificarPersonaEdad() {
		int id = Integer.parseInt(JOptionPane.showInputDialog("Digite identificacion"));
		String datosPersona = accionesBd.ConsultarPersona(id);
		if (datosPersona == "No existe la persona buscada") {
			JOptionPane.showMessageDialog(null, datosPersona);
		} else {
			String nuevaEdad = JOptionPane.showInputDialog("Digite la nueva edad");
			JOptionPane.showMessageDialog(null, accionesBd.ModificarRegistroPersonas(id, nuevaEdad, "Edad"));
		}
	}

}
