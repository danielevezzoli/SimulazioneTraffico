package it.unibs.ing.fp.simulazionetraffico;


public class Simulazione {

	public static void main(String[] args) {
		Strada strada = new Strada(70,10);
		
		strada.initStrada();
		strada.paintStrada();
		int x=0;
		
		while(x<2) {
			strada.avanzaSimulazione();
			System.out.println("\n\n");
			strada.paintStrada();
			x++;
		}

	}

}
