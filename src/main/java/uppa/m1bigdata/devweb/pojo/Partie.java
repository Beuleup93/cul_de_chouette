package uppa.m1bigdata.devweb.pojo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the partie database table.
 * 
 */
@Entity
@NamedQuery(name="Partie.findAll", query="SELECT p FROM Partie p")
public class Partie implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idPartie;

	@Temporal(TemporalType.DATE)
	private Date date;

	private String description;

	//bi-directional many-to-one association to Jouer
	@OneToMany(mappedBy="partie")
	private List<Jouer> jouers;

	public Partie(String description) {
		this.description = description;
	}

	public Partie() {
	}

	public int getIdPartie() {
		return this.idPartie;
	}

	public void setIdPartie(int idPartie) {
		this.idPartie = idPartie;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Jouer> getJouers() {
		return this.jouers;
	}

	public void setJouers(List<Jouer> jouers) {
		this.jouers = jouers;
	}

	public Jouer addJouer(Jouer jouer) {
		getJouers().add(jouer);
		jouer.setPartie(this);

		return jouer;
	}

	public Jouer removeJouer(Jouer jouer) {
		getJouers().remove(jouer);
		jouer.setPartie(null);

		return jouer;
	}

}