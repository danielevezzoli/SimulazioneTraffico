package it.unibs.ing.fp.simulazionetraffico;


public class Simulazione {

	public static void main(String[] args) {
		Strada strada = new Strada(20,10); //Lunghezza, altezza

		for(int i=0; i<20; i++) {
			strada.paintStrada();
			strada.avanzaSimulazione();
			clearScreen();
		}

	}
	
	
	public static void clearScreen() {  
	    System.out.print("\n\n\n\n\n\n\n\n");   
	}  

}
