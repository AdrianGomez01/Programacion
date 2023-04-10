package Tema4.Boletin4p4;

import java.util.Scanner;

public class TryEj7 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca una frase");

		String frase = sc.nextLine().toLowerCase();
		sc.close();
		
		System.out.println(devuelveCadenaCambiada(frase));
		
	}
	
	public static String devuelveCadenaCambiada(String frase){
		StringBuilder consonantes = new StringBuilder();
		StringBuilder vocales = new StringBuilder();
		
		for (int i = 0; i < frase.length(); i++) {
			if (esVocal(frase)) {
				vocales.append(frase.charAt(i));
			}
			else {
				consonantes.append(frase.charAt(i));
			}
		}
		return consonantes.append(vocales.toString()).toString();
		
	}

	public static boolean esVocal(String frase){
	String vocales = "aeiou";
	
	for (int i = 0; i < vocales.length(); i++) {
		if (frase.indexOf(vocales.charAt(i)) != -1) {
			return true;
		}
	}
	return false;
	}
	
}
