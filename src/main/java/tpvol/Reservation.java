package tpvol;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

@Entity
@SequenceGenerator(name = "resa_seq")

public class Reservation {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "resa_seq")
	private Integer id;

	@Column(unique = true)
	@NotBlank
	private String numero;

	@NotBlank
	private String nom;

	@NotBlank
	private String prenom;

	@NotNull
	private Integer age;

	@ManyToOne
	private Vol vol;

	public Reservation() {

	}

	public Reservation(String numero, String nom, String prenom, Integer age, Vol vol) {
		super();

		this.numero = numero;
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.vol = vol;
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

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Reservation [id=" + id + ", numero=" + numero + ", nom=" + nom + ", prenom=" + prenom + ", age=" + age
				+ "]";
	}

	
	
}
