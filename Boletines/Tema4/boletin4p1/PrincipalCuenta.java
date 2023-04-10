package Tema4.boletin4p1;

import java.util.Scanner;

public class PrincipalCuenta {

	
	
	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("<-------Bienvenido-------->");
		System.out.println("<----1.Sacar Dinero------->");
		System.out.println("<----2.Ingresar Dinero---->");
		System.out.println("<----3.Consultar Saldo---->");
		System.out.println("<----4.Salir del Banco---->");
		int opc = Integer.parseInt(teclado.nextLine());
		
		double cantidad = MiEntradaSalida.leerDouble("Introduzca una cantidad");
		
		do {
			
		} while (opc != 4);		
		

	}

	public class Cuenta {
		private int numCuenta;
		private double saldo;
		private int numIngresos;
		private int numReintegros;
		
		//Constructor de los datos
		public Cuenta (double saldo, int numCuenta) {
			this.saldo=saldo;
			this.numCuenta = numCuenta;
			numIngresos = 0;
			numReintegros = 0;
		}
		
		//metodo para obtener el saldo
		public double getSaldo() {
			return saldo;
		}
		
		//metodo para obtener el num de cuenta
		public int getNumCuenta() {
			return numCuenta;
		}
		
		//metodo para ingresar dinero
		public void ingresar(double cantidadIngresar) {
			if(cantidadIngresar > 0) {
				saldo = saldo + cantidadIngresar;
				numIngresos++;
			}
			else {
				System.out.println("Introduzca una cantidad válida");
			}
		}
		
		//metodo para retirar dinero
		public void retirar(double cantidadRetirar) {
			if (saldo <= cantidadRetirar || cantidadRetirar <= 0) {
				System.out.println("No se puede retirar la cantidad indicada");
			}
			saldo = saldo - cantidadRetirar;
			numReintegros++;
		}
		
		public String consulta() {
			return toString();
		}
		
		@Override
		public String toString() {
			
			return "Saldo: " + saldo + ". Ingresos: " + numIngresos + ". Retiradas: " + numReintegros ;
		}

	}
}

