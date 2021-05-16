package uppa.m1bigdata.devweb.pojo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the combinaison database table.
 * 
 */
@Entity
@NamedQuery(name="Combinaison.findAll", query="SELECT c FROM Combinaison c")
public class Combinaison implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idCombinaison;

	private String nomCombinaison;

	private String typeCombinaison;

	//bi-directional many-to-one association to D?
	@ManyToOne
	@JoinColumn(name="de1")
	private De de1;

	//bi-directional many-to-one association to D?
	@ManyToOne
	@JoinColumn(name="de2")
	private De de2;

	//bi-directional many-to-one association to D?
	@ManyToOne
	@JoinColumn(name="de3")
	private De de3;

	//bi-directional many-to-one association to Jouer
	@OneToMany(mappedBy="combinaison", cascade = CascadeType.ALL)
	private List<Jouer> jouers;

	public Combinaison() {
	}

	public Combinaison(String nomCombinaison, String typeCombinaison, De de1, De de2, De de3) {
		this.nomCombinaison = nomCombinaison;
		this.typeCombinaison = typeCombinaison;
		this.de1 = de1;
		this.de2 = de2;
		this.de3 = de3;
	}

	public int getIdCombinaison() {
		return this.idCombinaison;
	}

	public void setIdCombinaison(int idCombinaison) {
		this.idCombinaison = idCombinaison;
	}

	public String getNomCombinaison() {
		return this.nomCombinaison;
	}

	public void setNomCombinaison(String nomCombinaison) {
		this.nomCombinaison = nomCombinaison;
	}

	public String getTypeCombinaison() {
		return this.typeCombinaison;
	}

	public void setTypeCombinaison(String typeCombinaison) {
		this.typeCombinaison = typeCombinaison;
	}

	public De getDe1() {
		return this.de1;
	}

	public void setDe1(De de1) {
		this.de1 = de1;
	}

	public De getDe2() {
		return this.de2;
	}

	public void setDe2(De de2) {
		this.de2 = de2;
	}

	public De getDe3() {
		return this.de3;
	}

	public void setDe3(De de3) {
		this.de3 = de3;
	}

	public List<Jouer> getJouers() {
		return this.jouers;
	}

	public void setJouers(List<Jouer> jouers) {
		this.jouers = jouers;
	}

	public Jouer addJouer(Jouer jouer) {
		getJouers().add(jouer);
		jouer.setCombinaison(this);

		return jouer;
	}

	public Jouer removeJouer(Jouer jouer) {
		getJouers().remove(jouer);
		jouer.setCombinaison(null);

		return jouer;
	}

}