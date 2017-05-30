package it.unibs.ing.fp.simulazionetraffico;


import javax.sound.midi.Soundbank;

import it.unibs.fp.mylib.MyMenu;

import java.util.concurrent.TimeUnit;

public class Simulazione {

//	public static void main(String[] args) {
//		Strada strada = new Strada(20,10); //Lunghezza, altezza
//		
//		final String[] vociMenu = { "Nuova simulazione" , "Avanza simulazione" , "Azzera simulazione" };
//		MyMenu menu = new MyMenu("Clinica Medica", vociMenu);
//		
//		boolean esci = false;
//		
//		while (!esci) {
//			switch (menu.scegli()) {
//				case 1:
//					strada = new Strada(20,10);
//					clearScreen();
//					strada.paintStrada();
//					break;
//				case 2:
//					strada.avanzaSimulazione();
//					strada.paintStrada();
//					break;
//				case 3:
//					clearScreen();
//					strada.clearStrada();
//					strada.paintStrada();
//					break;
//				case 0:
//					clearScreen();
//					strada = null;
//					esci = true;
//					break;
//				default:
//					break;
//			}

	public static void main(String[] args) throws InterruptedException {
		Strada strada = new Strada(50, 10); // Lunghezza, altezza
		int timeSimulation = 400;// Millisecondi

		for (; true;) {
			strada.paintStrada();
			strada.avanzaSimulazione();
			clearScreen();
			TimeUnit.MILLISECONDS.sleep(timeSimulation);
		}
	}


		public static void clearScreen() {
			System.out.print("\n\n\n\n\n\n\n\n");
		}

}
