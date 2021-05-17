package uppa.m1bigdata.devweb.pojo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.ArrayList;
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

	private int valDes1, valDes2, valDes3;

	//bi-directional many-to-one association to Jouer
	@OneToMany(mappedBy="combinaison")
	private List<Jouer> jouers = new ArrayList<>();

	public Combinaison() {
	}

	public Combinaison(String nomCombinaison, String typeCombinaison, int valDes1, int valDes2, int valDes3) {
		this.nomCombinaison = nomCombinaison;
		this.typeCombinaison = typeCombinaison;
		this.valDes1 = valDes1;
		this.valDes2 = valDes2;
		this.valDes3 = valDes3;
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

	public List<Jouer> getJouers() {
		return this.jouers;
	}

	public void setJouers(List<Jouer> jouers) {
		this.jouers = jouers;
	}

	public int getValDes1() {
		return valDes1;
	}

	public void setValDes1(int valDes1) {
		this.valDes1 = valDes1;
	}

	public int getValDes2() {
		return valDes2;
	}

	public void setValDes2(int valDes2) {
		this.valDes2 = valDes2;
	}

	public int getValDes3() {
		return valDes3;
	}

	public void setValDes3(int valDes3) {
		this.valDes3 = valDes3;
	}

	public void addJouer(Jouer jouer) {
		jouers.add(jouer);
		jouer.setCombinaison(this);
	}

	public Jouer removeJouer(Jouer jouer) {
		getJouers().remove(jouer);
		jouer.setCombinaison(null);
		return jouer;
	}

}