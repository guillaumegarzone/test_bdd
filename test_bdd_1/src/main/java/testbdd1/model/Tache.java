package testbdd1.model;

import java.util.Date;

public class Tache {

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

	@Override
	public String toString() {
		return "Tache [id=" + id + ", dateDeb=" + dateDeb + ", echeance="
				+ echeance + "]";
	}

}
