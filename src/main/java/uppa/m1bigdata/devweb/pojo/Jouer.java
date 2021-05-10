package uppa.m1bigdata.devweb.pojo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the jouer database table.
 * 
 */
@Entity
@NamedQuery(name="Jouer.findAll", query="SELECT j FROM Jouer j")
public class Jouer implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private JouerPK id;

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

	public JouerPK getId() {
		return this.id;
	}

	public void setId(JouerPK id) {
		this.id = id;
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