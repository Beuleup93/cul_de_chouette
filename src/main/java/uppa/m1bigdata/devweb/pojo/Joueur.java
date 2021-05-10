package uppa.m1bigdata.devweb.pojo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the joueur database table.
 * 
 */
@Entity
@NamedQuery(name="Joueur.findAll", query="SELECT j FROM Joueur j")
public class Joueur implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idJoueur;

	private int age;

	private String nomJoueur;

	private String pseudo;

	private String pwd;

	private String sexe;

	private String ville;

	//bi-directional many-to-one association to Jouer
	@OneToMany(mappedBy="joueur")
	private List<Jouer> jouers;

	public Joueur() {
	}

	
	
	public Joueur(String nomJoueur, String pseudo, String pwd,int age, String sexe, String ville) {
		this.nomJoueur = nomJoueur;
		this.pseudo = pseudo;
		this.pwd = pwd;
		this.age = age;
		this.sexe = sexe;
		this.ville = ville;
	}



	public int getIdJoueur() {
		return this.idJoueur;
	}

	public void setIdJoueur(int idJoueur) {
		this.idJoueur = idJoueur;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getNomJoueur() {
		return this.nomJoueur;
	}

	public void setNomJoueur(String nomJoueur) {
		this.nomJoueur = nomJoueur;
	}

	public String getPseudo() {
		return this.pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getSexe() {
		return this.sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public String getVille() {
		return this.ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public List<Jouer> getJouers() {
		return this.jouers;
	}

	public void setJouers(List<Jouer> jouers) {
		this.jouers = jouers;
	}

	public Jouer addJouer(Jouer jouer) {
		getJouers().add(jouer);
		jouer.setJoueur(this);

		return jouer;
	}

	public Jouer removeJouer(Jouer jouer) {
		getJouers().remove(jouer);
		jouer.setJoueur(null);

		return jouer;
	}

}