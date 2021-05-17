package uppa.m1bigdata.devweb.pojo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;
import java.util.Random;


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

	public De() {
	}

	public De(String nomDes) {
		this.nomDes = nomDes;
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

	public int roll(int borneInf, int borneSup){
		Random random = new Random();
		return borneInf+random.nextInt(borneSup-borneInf);
	}

}