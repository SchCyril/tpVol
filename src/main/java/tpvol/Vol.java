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
import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;





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
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Vol.class);

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

		LOGGER.trace("Veuillez renseigner un numéro de vol");
		String str = scan.nextLine();
		resa1.setNumero(str);
		LOGGER.trace("Veuillez renseigner le type de l'avion");
		String str1 = scan.nextLine();
		vol1.setTypeAvion(str1);
		LOGGER.trace("Veuillez renseigner le nombre de places");
		Integer str2 = Integer.valueOf(scan.nextLine());
		vol1.setNbPlace(str2);
		LOGGER.trace("Veuillez renseigner la ville de départ");
		String str3 = scan.nextLine();
		vol1.setVilleDepart(str3);
		LOGGER.trace("Veuillez renseigner la ville d'arrivée");
		String str4 = scan.nextLine();
		vol1.setVilleArrive(str4);
	

		LOGGER.trace("Voulez vous enregistrer ?");
		String str5 = scan.nextLine();
		LOGGER.trace("test");
		if (str5.equals("oui")) {
			VolDAO daov = new VolDAO();
			LOGGER.trace("test");
			ReservationDAO daor = new ReservationDAO();
			LOGGER.trace("test");
			daor.create(resa1);
			LOGGER.trace("test");
			daov.create(vol1);
		}

	}

	public static List<Vol> listeVol() {

		EntityManager em = DatabaseHelper.createEntityManager();
		TypedQuery<Vol> query = em.createQuery("from Vol", Vol.class);
		

		return query.getResultList();

	}

	public static void gestionVol() {

		Scanner scan = new Scanner(System.in);

		LOGGER.trace("1) création d'un vols");
		LOGGER.trace("2) Liste des vols");
		LOGGER.trace("3) Quitter");
		Integer str = scan.nextInt();

		switch (str) {
		case 1:
			Vol.creationVol();
			break;
		case 2:
			LOGGER.trace("Voici la liste des vols");
			Vol.listeVol();
			break;
		case 3:
			LOGGER.trace("veuillez saisir un numéro de vol");
			scan.nextInt();
			VolDAO.planeSearch();
			break;
		case 4:
			LOGGER.trace("recherchez votre avion");			
			LOGGER.trace("Veuillez renseigner la ville de départ");
			scan.nextLine();
			LOGGER.trace("Veuillez renseigner la ville d'arrivée");
			scan.nextLine();
			
		default:
			System.exit(0);
			break;

			
		}
	}

	
}
