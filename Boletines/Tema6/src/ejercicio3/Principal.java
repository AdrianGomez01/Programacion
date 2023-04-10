package Tema6.src.ejercicio3;

public class Principal {

	public static void main(String[] args) {

		try {
			Profesor profesor1 = new Profesor("11", "Pepe", 30);
			Profesor profesor2 = new Profesor("12", "Pepa", 32);
			Alumno alumno1 = new Alumno("15","Juan",15,null, 2);
			Alumno alumno2 = new Alumno("10","Maria",19,null, 2);
			Alumno alumno3 = new Alumno("3","Juan",18,null, 1);

			profesor1.enviarCorreo("Hola hola", profesor2);
			profesor1.enviarCorreo("Adios", profesor2);

			System.out.println(profesor1.mostrarMensajesOrdenados());
		} catch (IESException e) {
			System.out.println(e.getMessage());
		}
	}

}
