package Tema4.boletin4p1;

public class MaquinaCafe {

	//Constantes
	static final int TAMANHO_DEP_CAFE = 50;
	static final int TAMANHO_DEP_LECHE = 50;
	static final int TAMANHO_DEP_VASOS = 80;
	static final double MONEDERO_INICIAL = 100;
	static final double PREC_KFSOLO = 1;
	static final double PREC_LECHE = 0.8;
	static final double PREC_KFLECHE = 1.5;
	static final int OPC_KF_SOLO = 1;
	static final int OPC_LECHE = 2;
	static final int OPC_KF_LECHE = 3;
	static final int OPC_ESTADO_MAQUINA = 4;
	static final int OPC_APAGAR = 5;
	
	//Atributos
	private int depositoCafe;
	private int depositoLeche;
	private int depositoVasos;
	private double monedero;
	
	//Creamos el constructor
	public MaquinaCafe () {
		this.monedero= MONEDERO_INICIAL;
		this.llenarDepositos();
	}
	
	/**
	 * Método para llenado de depósitos.
	 */
	public void llenarDepositos(){
		this.depositoCafe = TAMANHO_DEP_CAFE;
		this.depositoLeche = TAMANHO_DEP_LECHE;
		this.depositoVasos = TAMANHO_DEP_VASOS;
	}
	
	/**
	 *Metodo para servir los productos
	 * @param opcion
	 */
	public void servirProducto(int opcion) {
		double precioProducto = 0;
		depositoVasos--;
		switch (opcion) {
			case OPC_KF_SOLO:
				depositoCafe--;
				precioProducto= PREC_KFSOLO;
				break;
	
			case OPC_LECHE:
				depositoLeche--;
				precioProducto= PREC_LECHE;
				break;
				
			case OPC_KF_LECHE:
				depositoLeche--;
				depositoCafe--;
				precioProducto= PREC_KFLECHE;
				break;
		}
		monedero = monedero + precioProducto;
	}
	
	/**
	 * Método para crear el menú
	 * @return
	 */
	public String crearMenu() {
		// Salto de Línea con "System.getProperty("line.separator") o con \n + Enter
		return "Opciones: \n"
				+ OPC_KF_SOLO + ". Servir Café solo (" + PREC_KFSOLO + "e)\n"
				+ OPC_LECHE + ". Servir Leche (" + PREC_LECHE + "e)\n"
				+ OPC_KF_LECHE + ". Servir Café con leche (" + PREC_KFLECHE + "e)\n"
				+ OPC_ESTADO_MAQUINA + ". Consultar estado máquina. Aparecen los datos de los depositos y del monedero \n"
				+ OPC_APAGAR + ". Apagar la máquina";
	}
	
	/**
	 * Comprueba las existencias de la maquina
	 * @param opcion
	 * @return
	 */
	public boolean comprobarExistencias(int opcion) {
		boolean existencias =false;
		
		if (this.depositoVasos >0) {
			
			switch (opcion) {
			case OPC_KF_SOLO:
				existencias = this.depositoCafe>0;
				break;
				
			case OPC_LECHE:
				existencias = this.depositoLeche>0;
				break;

			case OPC_KF_LECHE:
				existencias = this.depositoLeche>0 && this.depositoCafe>0;
				break;
			}
		}		
		return existencias;
	}
	
	/**
	 * Comprueba si la máquina tiene dinero para devolver la vuelta
	 * @param dinero
	 * @param opcion
	 * @return
	 */
	public boolean comprobarCambio(double dinero, int opcion) {
		boolean hayDinero = false;
		
		switch (opcion) {
			case OPC_KF_SOLO:
				hayDinero = this.monedero >= dinero - PREC_KFSOLO;
				break;
				
			case OPC_LECHE:
				hayDinero = this.monedero >= dinero - PREC_LECHE;
				break;
				
			case OPC_KF_LECHE:
				hayDinero = this.monedero >= dinero - PREC_KFLECHE;
				break;
		}
		return hayDinero;
	}
	
	/**
	 * Obtiene el precio de las opciones
	 * @param opcion
	 * @return
	 */
	public static double getPrecioOpcion(int opcion) {
		double precioOpcion =0;
		switch (opcion) {
			case OPC_KF_SOLO:
				precioOpcion= PREC_KFSOLO;
				break;
				
			case OPC_LECHE:
				precioOpcion=  PREC_LECHE;
				break;
				
			case OPC_KF_LECHE:
				precioOpcion=  PREC_KFLECHE;
				break;
		}
		return precioOpcion;
	}

	/**
	 * Estado de la máquina. Generado en Source>generate toString
	 */
	public String toString() {
		return "MaquinaCafe [depositoCafe=" + depositoCafe + ", depositoLeche=" + depositoLeche + ", depositoVasos="
				+ depositoVasos + ", monedero=" + monedero + "]";
	}
	
}