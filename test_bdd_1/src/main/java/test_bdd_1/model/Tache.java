package test_bdd_1.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tache {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private String id;

	private Date dateDeb;

	private Date echeance;

	public Date getDateDeb() {
		return dateDeb;
	}

	public void setDateDeb(Date dateDeb) {
		this.dateDeb = dateDeb;
	}

	public Date getEcheance() {
		return echeance;
	}

	public void setEcheance(Date echeance) {
		this.echeance = echeance;
	}

	public String getId() {
		return id;
	}

	public Tache() {
	}

}
