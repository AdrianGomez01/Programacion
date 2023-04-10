package boletin4p2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Persona {

	//Atributos
	private String nombre;
	private LocalDate fecha;
	private int dni;
	private char sexo;
	private float altura;
	private float peso;

	/**
	 * Constructor
	 * @param nombre
	 * @param fecha
	 * @param dni
	 * @param sexo
	 * @param altura
	 * @param peso
	 */
	public Persona(String nombre, LocalDate fecha, int dni, char sexo, float altura, float peso) {
		super();
		this.nombre = nombre;
		this.fecha = fecha;
		this.dni = dni;
		this.sexo = sexo;
		this.altura = altura;
		this.peso = peso;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public char getSexo() {
		return sexo;
	}
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	public float getAltura() {
		return altura;
	}
	public void setAltura(float altura) {
		this.altura = altura;
	}
	public float getPeso() {
		return peso;
	}
	public void setPeso(float peso) {
		this.peso = peso;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public int getDni() {
		return dni;
	}
	
	public static char calcularLetraDni(int dni) {
		char caracteres[] = {'T','R','W','A','G','M','Y','F','P','D','X','B','N','J','Z','S','Q','V','H','L','C','K','E'};
		return caracteres[dni %23];
	}
	
	public char getLetraDNI() {
		return calcularLetraDni(this.dni);
	}
	
	public static double calcularImc(float peso, float altura) {
		return peso / Math.pow(altura, 2);
	}
	
	public double getImc() {
		return calcularImc(this.peso, this.altura);
	}

	
	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", fecha=" + fecha.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + ", dni=" + dni + getLetraDNI() + ", sexo=" + sexo + ", altura="
				+ altura + ", peso=" + peso + "]";
	}
	
	
}
