package uppa.m1bigdata.devweb.pojo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the d�s database table.
 * 
 */
@Entity
@Table(name="des")
@NamedQuery(name="De.findAll", query="SELECT d FROM De d")
public class De implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idDes;

	private String nomDes;

	private int valeurFace;

	//bi-directional many-to-one association to Combinaison
	@OneToMany(mappedBy="de1")
	private List<Combinaison> combinaisons1;

	//bi-directional many-to-one association to Combinaison
	@OneToMany(mappedBy="de2")
	private List<Combinaison> combinaisons2;

	//bi-directional many-to-one association to Combinaison
	@OneToMany(mappedBy="de3")
	private List<Combinaison> combinaisons3;

	public De() {
	}

	public int getIdDes() {
		return this.idDes;
	}

	public void setIdDes(int idDes) {
		this.idDes = idDes;
	}

	public String getNomDes() {
		return this.nomDes;
	}

	public void setNomDes(String nomDes) {
		this.nomDes = nomDes;
	}

	public int getValeurFace() {
		return this.valeurFace;
	}

	public void setValeurFace(int valeurFace) {
		this.valeurFace = valeurFace;
	}

	public List<Combinaison> getCombinaisons1() {
		return this.combinaisons1;
	}

	public void setCombinaisons1(List<Combinaison> combinaisons1) {
		this.combinaisons1 = combinaisons1;
	}

	public Combinaison addCombinaisons1(Combinaison combinaisons1) {
		getCombinaisons1().add(combinaisons1);
		combinaisons1.setDe1(this);

		return combinaisons1;
	}

	public Combinaison removeCombinaisons1(Combinaison combinaisons1) {
		getCombinaisons1().remove(combinaisons1);
		combinaisons1.setDe1(null);

		return combinaisons1;
	}

	public List<Combinaison> getCombinaisons2() {
		return this.combinaisons2;
	}

	public void setCombinaisons2(List<Combinaison> combinaisons2) {
		this.combinaisons2 = combinaisons2;
	}

	public Combinaison addCombinaisons2(Combinaison combinaisons2) {
		getCombinaisons2().add(combinaisons2);
		combinaisons2.setDe2(this);

		return combinaisons2;
	}

	public Combinaison removeCombinaisons2(Combinaison combinaisons2) {
		getCombinaisons2().remove(combinaisons2);
		combinaisons2.setDe2(null);

		return combinaisons2;
	}

	public List<Combinaison> getCombinaisons3() {
		return this.combinaisons3;
	}

	public void setCombinaisons3(List<Combinaison> combinaisons3) {
		this.combinaisons3 = combinaisons3;
	}

	public Combinaison addCombinaisons3(Combinaison combinaisons3) {
		getCombinaisons3().add(combinaisons3);
		combinaisons3.setDe3(this);

		return combinaisons3;
	}

	public Combinaison removeCombinaisons3(Combinaison combinaisons3) {
		getCombinaisons3().remove(combinaisons3);
		combinaisons3.setDe3(null);
		return combinaisons3;
	}

}