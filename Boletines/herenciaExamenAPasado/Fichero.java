package herenciaExamenAPasado;

import java.time.LocalDate;

import herencia3.PersonajeException;

public abstract class Fichero {


	// Atributos
	public String nombre;
	private long tamanho;
	private LocalDate fechaCreacion; //LocalDate.fromNow(); 
	
	//Constructor
	public Fichero(String nombre, long tamanho,LocalDate fechaCreacion) throws FicheroException {
		this.nombre = nombre;
		this.tamanho = tamanho;
		this.setFechaCreacion(fechaCreacion);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public long getTamanho() {
		return tamanho;
	}

	public void setTamanho(long tamanho) {
		this.tamanho = tamanho;
	}


	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}

	private void setFechaCreacion(LocalDate fecha_creacion) {
		this.fechaCreacion = fecha_creacion;
	}
	
	/**
	 * Método que muestra los datos comunes en todos los ficheros (Nombre, Tamaño y Fecha de creacion)
	 * @throws PersonajeException
	 */
	public final void mostrarDatos() throws PersonajeException {
		System.out.printf("El nombre del archivo es: \n", getNombre());
		System.out.printf("El tamaño del archivo es: \n", getTamanho());
		System.out.printf("La fecha de creación es: \n", getFechaCreacion());
	}
	
}
