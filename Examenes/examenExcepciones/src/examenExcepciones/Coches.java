package examenExcepciones;

public class Coches {

	private String nombrePropietario, matricula, marca;
	private int numKm, dia, mes, anho;
	static final int MIN_KM = 10;
	static final int MAX_KM = 350000;

	public Coches(String nombrePropietario, String matricula, int numKm, String marca, int dia, int mes, int anho) {
		this.nombrePropietario = nombrePropietario;
		this.matricula = matricula;
		this.numKm = 10;
		this.marca = marca;
		this.dia = dia;
		this.mes = mes;
		this.anho = anho;
	}

	public String getNombrePropietario() {
		return nombrePropietario;
	}

	public String getMatricula() {
		return matricula;
	}

	public int getNumKm() {
		return numKm;
	}

	public String getMarca() {
		return marca;
	}

	public int getDia() {
		return dia;
	}

	public int getMes() {
		return mes;
	}

	public int getAnho() {
		return anho;
	}

	/**
	 * TODO Revisar la cantidad de dias dependiendo del mes
	 * 
	 * @param dia
	 * @return
	 */
	public boolean validarDia(int dia) {
		if (dia > 0 && dia <= 31) {
			return true;
		} else {
			System.out.println("Introduzca un día válido");
			return false;
		}
	}

	public boolean validarMes(int mes) {
		if (mes > 0 && mes <= 12) {
			return true;
		} else {
			System.out.println("Introduzca un mes válido");
			return false;
		}
	}

	public boolean validarAnho(int anho) {
		if (anho >= 2022) {
			return true;
		} else {
			System.out.println("Introduzca un año válido");
			return false;
		}
	}

	public boolean validarKm(int numKm) {
		if (numKm >= MIN_KM && numKm <= MAX_KM) {
			return true;
		} else {
			System.out.println("El kilometraje no es válido");
			return false;
		}
	}

	public boolean validarMarca(String marca) {
		if (marca.length() > 0 && marca.length() < 14) {
			return true;
		} else {
			System.out.println("ta malo");
			return false;
		}
	}

	
	public boolean validarMatricula(String matricula) {
		boolean valido = true;
		String vocales = "aeiou";
		String numeroMatricula = matricula.substring(0, 4);
		String letrasMatricula = matricula.substring(4);

		if (matricula.length() != 7) {
			valido = false;
		}

		for (int i = 0; i < matricula.length() && valido; i++) {
			if (!Character.isDigit(numeroMatricula.charAt(i))) {
				valido = false;
			}
		}
		
		for (int i = 0; i < letrasMatricula.length() && valido; i++) {
			if (!Character.isLetter(letrasMatricula.charAt(i))
					|| vocales.contains(String.valueOf(Character.toLowerCase(letrasMatricula.charAt(i))))) {

				valido = false;
			}
		}
		return valido;

	}

	// TODO Preguntar si esto es correcto, me resulta raro tantas validaciones.
	public boolean validarNombrePropietario(String nombrePropietario) {
		if (nombrePropietario.length() < 0) {
			return false;
		} else {
			return true;
		}
	}

}
