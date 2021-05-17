package uppa.m1bigdata.devweb.pojo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the jouer database table.
 * 
 */
@Entity
@Table(name="Jouer")
@NamedQuery(name="Jouer.findAll", query="SELECT j FROM Jouer j")
public class Jouer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idJouer;

	private int point;

	//bi-directional many-to-one association to Combinaison
	@ManyToOne
	@JoinColumn(name="idCombinaison",insertable=false, updatable=false)
	private Combinaison combinaison;

	//bi-directional many-to-one association to Joueur
	@ManyToOne
	@JoinColumn(name="idJoueur",insertable=false, updatable=false)
	private Joueur joueur;

	//bi-directional many-to-one association to Partie
	@ManyToOne
	@JoinColumn(name="idPartie",insertable=false, updatable=false)
	private Partie partie;

	public Jouer() {
	}

	public Jouer(int point) {
		this.point = point;
	}

	public Jouer(int idJouer, int point, Combinaison combinaison, Joueur joueur, Partie partie) {
		this.idJouer = idJouer;
		this.point = point;
		this.combinaison = combinaison;
		this.joueur = joueur;
		this.partie = partie;
	}

	public int getIdJouer() {
		return idJouer;
	}

	public void setIdJouer(int idJouer) {
		this.idJouer = idJouer;
	}

	public int getPoint() {
		return this.point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public Combinaison getCombinaison() {
		return this.combinaison;
	}

	public void setCombinaison(Combinaison combinaison) {
		this.combinaison = combinaison;
	}

	public Joueur getJoueur() {
		return this.joueur;
	}

	public void setJoueur(Joueur joueur) {
		this.joueur = joueur;
	}

	public Partie getPartie() {
		return this.partie;
	}

	public void setPartie(Partie partie) {
		this.partie = partie;
	}

}