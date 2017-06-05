package it.unibs.ing.fp.simulazionetraffico;

import it.unibs.fp.mylib.MyMenu;



public class Simulazione {

	public static void main(String[] args) throws InterruptedException {
		Strada strada = new Strada(10,5); //Lunghezza, altezza
		

		
		final String[] vociMenu = { "Nuova simulazione" , "Avanza simulazione" };
		MyMenu menu = new MyMenu("Simulazione traffico", vociMenu);
		
		boolean esci = false;
		
		while (!esci) {
			switch (menu.scegli()) {
				case 1:
					strada = new Strada(20,10);
					clearScreen();
					strada.paintStrada();
					break;
				case 2:
					strada.avanzaSimulazione();
					strada.paintStrada();
					break;
				case 0:
					clearScreen();
					strada = null;
					esci = true;
					break;
				default:
					break;
			}
		}
	}

//	public static void main(String[] args) throws InterruptedException {
//		Strada strada = new Strada(50, 10); // Lunghezza, altezza
//		int timeSimulation = 400;// Millisecondi
//
//		for (; true;) {
//			strada.paintStrada();
//			strada.avanzaSimulazione();
//			clearScreen();
//			TimeUnit.MILLISECONDS.sleep(timeSimulation);
//		}
//	}
		public static void clearScreen() {
			System.out.print("\n\n\n\n\n\n\n\n");
		}

}
