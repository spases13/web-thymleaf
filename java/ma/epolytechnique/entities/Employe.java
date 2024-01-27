package ma.epolytechnique.entities;

import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;



@Entity
public class Employe implements Serializable{

	@Id
	@GeneratedValue
	private long idemploye;
	private String nomemploye;
	private String genre;
	private double salaire;
	
	public Employe() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employe(String nomemploye, String genre, double salaire) {
		super();
		this.nomemploye = nomemploye;
		this.genre = genre;
		this.salaire = salaire;
	}

	public long getIdemploye() {
		return idemploye;
	}

	public void setIdemploye(long idemploye) {
		this.idemploye = idemploye;
	}

	public String getNomemploye() {
		return nomemploye;
	}

	public void setNomemploye(String nomemploye) {
		this.nomemploye = nomemploye;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public double getSalaire() {
		return salaire;
	}

	public void setSalaire(double salaire) {
		this.salaire = salaire;
	}
	
	
	
	
	
	
}
