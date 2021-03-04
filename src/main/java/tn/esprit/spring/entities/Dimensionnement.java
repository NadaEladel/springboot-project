package tn.esprit.spring.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Dimensionnement  implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private long id;  
	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private Categorie canals ;
	private String namont ;	
	private String naval ;
	private float debitunitaire;
	private float surface ;
	private float largeurdecanal;
	private float coefmanning;
	private float pente;
	private float talus;
	private float y0;
	private float revanche;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Categorie getCanals() {
		return canals;
	}
	public void setCanals(Categorie canals) {
		this.canals = canals;
	}
	public String getNamont() {
		return namont;
	}
	public void setNamont(String namont) {
		this.namont = namont;
	}
	public String getNaval() {
		return naval;
	}
	public void setNaval(String naval) {
		this.naval = naval;
	}
	public float getDebitunitaire() {
		return debitunitaire;
	}
	public void setDebitunitaire(float debitunitaire) {
		this.debitunitaire = debitunitaire;
	}
	public float getSurface() {
		return surface;
	}
	public void setSurface(float surface) {
		this.surface = surface;
	}
	public float getLargeurdecanal() {
		return largeurdecanal;
	}
	public void setLargeurdecanal(float largeurdecanal) {
		this.largeurdecanal = largeurdecanal;
	}
	public float getCoefmanning() {
		return coefmanning;
	}
	public void setCoefmanning(float coefmanning) {
		this.coefmanning = coefmanning;
	}
	public float getPente() {
		return pente;
	}
	public void setPente(float pente) {
		this.pente = pente;
	}
	public float getTalus() {
		return talus;
	}
	public void setTalus(float talus) {
		this.talus = talus;
	}
	public float getY0() {
		return y0;
	}
	public void setY0(float y0) {
		this.y0 = y0;
	}
	public float getRevanche() {
		return revanche;
	}
	public void setRevanche(float revanche) {
		this.revanche = revanche;
	}
	
	@Override
	public String toString() {
		return "Dimensionnement [id=" + id + ", canals=" + canals + ", nœudamont=" + namont + ", nœudaval="
				+ naval + ", debitunitaire=" + debitunitaire + ", surface=" + surface + ", largeurdecanal="
				+ largeurdecanal + ", coefmanning=" + coefmanning + ", pente=" + pente + ", talus=" + talus + ", y0="
				+ y0 + ", revanche=" + revanche + "]";
	}
	
	
	
}
