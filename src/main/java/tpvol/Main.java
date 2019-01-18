package tpvol;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class Main {
	
	private static final String ACTION_1 = "error";
	private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) {
		
		
		LOGGER.trace(ACTION_1);
		
		
		LOGGER.trace("Menu principal");
		
		

		Scanner scan = new Scanner(System.in);

		LOGGER.trace("1) Gestion des vols");
		LOGGER.trace("2) Gestion des réservations");
		LOGGER.trace("3) Quitter");
		Integer str = scan.nextInt();

		switch (str) {
		case 1:
			Vol.gestionVol();
			break;
		case 2:
			LOGGER.trace("vous avez choisi la gestion des resa");

			break;
		case 3:
			System.exit(str);
			break;
		default:
			System.exit(str);
		}

	}

}
