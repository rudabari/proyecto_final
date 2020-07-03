package co.com.bancolombia.entities;

public class Persona {

	private String nombre;
	private int edad;
	private int identificacion;

	public Persona() {

	}

	public Persona(String nombre, int edad, int identificacion) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.identificacion = identificacion;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return this.nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public int getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(int identificacion) {
		this.identificacion = identificacion;
	}

	@Override
	public String toString() {
		return "Identificacion = " +  identificacion + "\nNombre = "  + nombre + "\nEdad =" + edad + " años";
	}

	public String toString2() {
		return "Identificacion = " +  identificacion + "\nNombre = "  + nombre;
	}
	
}
