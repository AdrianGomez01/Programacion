package Tema4.boletin4p1;

public class PrincipalMaquinaCafe {

	public static void main(String[] args) {
		MaquinaCafe maquina1 = new MaquinaCafe();
		boolean apagarMaquina= false;
		int opcion;
		do {
			System.out.println(maquina1.crearMenu());
			opcion= MiEntradaSalida.leerEnteroEnRango("Introduzca una opción", 1, 5);
			
			switch (opcion) {
				case MaquinaCafe.OPC_KF_SOLO:
				case MaquinaCafe.OPC_LECHE:
				case MaquinaCafe.OPC_KF_LECHE:
					procesaPedido(maquina1, opcion);
					
					break;
					
				case MaquinaCafe.OPC_ESTADO_MAQUINA:
					System.out.println(maquina1);
					break;
					
				case MaquinaCafe.OPC_APAGAR:
					apagarMaquina=true;
					break;
			}
			
		} while (!apagarMaquina);
	}

	public static double pedirDinero(int opcion) {
		
		double dineroInsertado= MiEntradaSalida.leerDouble("Introduzca el dinero:");
		while (dineroInsertado < MaquinaCafe.getPrecioOpcion(opcion)) {
			System.out.println("El dinero que ha introducido es insuficiente.Faltan " + (MaquinaCafe.getPrecioOpcion(opcion)- dineroInsertado) + " e.");
			dineroInsertado = dineroInsertado + MiEntradaSalida.leerDouble("Introduzca el dinero restante:");
		}
		
		return dineroInsertado;
	}
	
	public static void procesaPedido(MaquinaCafe maquina1, int opcion) {
		if (maquina1.comprobarExistencias(opcion)) {
			double dineroIntroducido = pedirDinero(opcion);
			if (maquina1.comprobarCambio(dineroIntroducido, opcion)) {
				maquina1.servirProducto(opcion);
				System.out.println("Producto servido");
				System.out.println("Recoja su cambio: " + (dineroIntroducido - MaquinaCafe.getPrecioOpcion(opcion)) + " e.");
			}
		}
	}
	
}
