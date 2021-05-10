package uppa.m1bigdata.devweb.pojo;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the jouer database table.
 * 
 */
@Embeddable
public class JouerPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column
	private int idJoueur;

	@Column
	private int idPartie;

	@Column
	private int idCombinaison;

	public JouerPK() {
	}
	public int getIdJoueur() {
		return this.idJoueur;
	}
	public void setIdJoueur(int idJoueur) {
		this.idJoueur = idJoueur;
	}
	public int getIdPartie() {
		return this.idPartie;
	}
	public void setIdPartie(int idPartie) {
		this.idPartie = idPartie;
	}
	public int getIdCombinaison() {
		return this.idCombinaison;
	}
	public void setIdCombinaison(int idCombinaison) {
		this.idCombinaison = idCombinaison;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof JouerPK)) {
			return false;
		}
		JouerPK castOther = (JouerPK)other;
		return 
			(this.idJoueur == castOther.idJoueur)
			&& (this.idPartie == castOther.idPartie)
			&& (this.idCombinaison == castOther.idCombinaison);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idJoueur;
		hash = hash * prime + this.idPartie;
		hash = hash * prime + this.idCombinaison;
		
		return hash;
	}
}