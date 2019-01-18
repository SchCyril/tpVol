package tpvol;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.TypedQuery;
import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

@Entity
@SequenceGenerator(name = "vol_seq")

public class Vol {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vol_seq")
	private Integer id;

	@Column(unique = true)
	@NotBlank
	private String numero;

	private String typeAvion;

	@NotNull
	private Integer nbPlace;

	@NotBlank
	private String villeDepart;

	@NotBlank
	private String villeArrive;

	@NotBlank
	private Date dateDepart;

	@OneToMany(mappedBy = "vol")
	private List<Reservation> reservations;

	public Vol() {

	}

	public Vol(String numero, String typeAvion, Integer nbPlace, String villeDepart, String villeArrive,
			Date dateDepart) {
		super();

		this.numero = numero;
		this.typeAvion = typeAvion;
		this.nbPlace = nbPlace;
		this.villeDepart = villeDepart;
		this.villeArrive = villeArrive;
		this.dateDepart = dateDepart;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Integer getNbPlace() {
		return nbPlace;
	}

	public void setNbPlace(Integer nbPlace) {
		this.nbPlace = nbPlace;
	}

	public String getVilleDepart() {
		return villeDepart;
	}

	public void setVilleDepart(String villeDepart) {
		this.villeDepart = villeDepart;
	}

	public String getVilleArrive() {
		return villeArrive;
	}

	public void setVilleArrive(String villeArrive) {
		this.villeArrive = villeArrive;
	}

	public Date getDateDepart() {
		return dateDepart;
	}

	public void setDateDepart(Date dateDepart) {
		this.dateDepart = dateDepart;
	}

	@Override
	public String toString() {
		return "Vol [id=" + id + ", numero=" + numero + ", nbPlace=" + nbPlace + ", villeDepart=" + villeDepart
				+ ", villeArrive=" + villeArrive + ", dateDepart=" + dateDepart + "]";
	}

	public String getTypeAvion() {
		return typeAvion;
	}

	public void setTypeAvion(String typeAvion) {
		this.typeAvion = typeAvion;
	}

	public static void creationVol() {

		Reservation resa1 = new Reservation();
		Vol vol1 = new Vol();
		Scanner scan = new Scanner(System.in);

		System.out.println("Veuillez renseigner un numéro de vol");
		String str = scan.nextLine();
		resa1.setNumero(str);
		System.out.println("Veuillez renseigner le type de l'avion");
		String str1 = scan.nextLine();
		vol1.setTypeAvion(str1);
		System.out.println("Veuillez renseigner le nombre de places");
		Integer str2 = Integer.valueOf(scan.nextLine());
		vol1.setNbPlace(str2);
		System.out.println("Veuillez renseigner la ville de départ");
		String str3 = scan.nextLine();
		vol1.setVilleDepart(str3);
		System.out.println("Veuillez renseigner la ville d'arrivée");
		String str4 = scan.nextLine();
		vol1.setVilleArrive(str4);
		// System.out.println("Veuillez renseigner le nombre de places");

		System.out.println("Voulez vous enregistrer ?");
		String str5 = scan.nextLine();
		System.out.println("test");
		if (str5.equals("oui")) {
			VolDAO daov = new VolDAO();
			System.out.println("test");
			ReservationDAO daor = new ReservationDAO();
			System.out.println("test");
			daor.create(resa1);
			System.out.println("test");
			daov.create(vol1);
		}

	}

	public static List<Vol> listeVol() {

		EntityManager em = DatabaseHelper.createEntityManager();
		TypedQuery<Vol> query = em.createQuery("from Vol", Vol.class);
		List<Vol> vols = query.getResultList();

		return vols;

	}

	public static void gestionVol() {

		Scanner scan = new Scanner(System.in);

		System.out.println("1) création d'un vols");
		System.out.println("2) Liste des vols");
		System.out.println("3) Quitter");
		Integer str = scan.nextInt();

		switch (str) {
		case 1:
			Vol.creationVol();
			break;
		case 2:
			System.out.println("Voici la liste des vols");
			Vol.listeVol();
			break;
		case 3:
			System.out.println("veuillez saisir un numéro de vol");
			Integer str2 = Integer.valueOf(scan.nextLine());
			VolDAO.planeSearch();
			break;
		case 4:
			System.out.println("recherchez votre avion");			
			System.out.println("Veuillez renseigner la ville de départ");
			String str3 = scan.nextLine();
			System.out.println("Veuillez renseigner la ville d'arrivée");
			String str4 = scan.nextLine();
//			VolDAO.planeByCity();
			
		}
	}

	
}
