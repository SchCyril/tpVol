package tpvol;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
//		Date date1 = new Date(119, 00, 11);
//		Date date2 = new Date(119, 00, 10);
//		Date date3 = new Date(119,00,9);
//		Date date4 = new Date(119,00,8);
//
//		Vol vol1 = new Vol("0001", "A330", 300, "Montpellier", "Paris", date1);
//		

//		Reservation resa1 = new Reservation("", "Schneidenbach", "Cyril", 25, vol1);
//		Reservation resa2 = new Reservation("", "Mattera", "Lorick", 29, vol1);
//		Reservation resa3 = new Reservation("", "Carreaux", "Baptiste", 23, vol1);
//		Reservation resa4 = new Reservation("", "Montet", "Benjamin", 26, vol1);
//		Reservation resa5 = new Reservation("", "Payan", "Benjamin", 23, vol1);

//	VolDAO daov = new VolDAO();
////		daov.create(vol1);
////		
//	ReservationDAO daor = new ReservationDAO();
//		daor.create(resa1);
//		daor.create(resa2);
//		daor.create(resa3);
//		daor.create(resa4);
//		daor.create(resa5);
		
		System.out.println("Menu principal");
		
		

		Scanner scan = new Scanner(System.in);

		System.out.println("1) Gestion des vols");
		System.out.println("2) Gestion des réservations");
		System.out.println("3) Quitter");
		Integer str = scan.nextInt();

		switch (str) {
		case 1:
			Vol.gestionVol();
			break;
		case 2:
			System.out.println("vous avez choisi la gestion des resa");

			break;
		case 3:
			System.exit(str);
			break;
		default:
			System.exit(str);
		}

	}

}
