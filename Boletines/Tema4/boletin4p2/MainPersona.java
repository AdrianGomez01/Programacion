package Tema4.boletin4p2;

import java.time.LocalDate;

public class MainPersona {

	public static void main(String[] args) {
		
		Persona persona1 = new Persona("Adrian", LocalDate.of(1996,1,26), 29620180, 'M', 1.68f, 60.00f );
		System.out.println(persona1);
		System.out.printf("Tu IMC es de %f \n" , persona1.getImc());

	}

}
