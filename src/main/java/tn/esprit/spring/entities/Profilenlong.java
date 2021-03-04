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
public class Profilenlong implements Serializable {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY) 
private long id; 
@Enumerated(EnumType.STRING)
@Column(length = 20)
private Categorie canals ;
private String namont ;	
private String naval ;
private int hauteurchute;
private int nombredechute ;
private int chute ;
private int longueur;
private float cotetnamont ;
private float cotetnaval;
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
public int getHauteurchute() {
	return hauteurchute;
}
public void setHauteurchute(int hauteurchute) {
	this.hauteurchute = hauteurchute;
}
public int getNombredechute() {
	return nombredechute;
}
public void setNombredechute(int nombredechute) {
	this.nombredechute = nombredechute;
}
public int getChute() {
	return chute;
}
public void setChute(int chute) {
	this.chute = chute;
}
public int getLongueur() {
	return longueur;
}
public void setLongueur(int longueur) {
	this.longueur = longueur;
}
public float getCotetnamont() {
	return cotetnamont;
}
public void setCotetnamont(float cotetnamont) {
	this.cotetnamont = cotetnamont;
}
public float getCotetnaval() {
	return cotetnaval;
}
public void setCotetnaval(float cotetnaval) {
	this.cotetnaval = cotetnaval;
}
@Override
public String toString() {
	return "Profilenlong [id=" + id + ", canals=" + canals + ", namont=" + namont + ", naval=" + naval
			+ ", hauteurchute=" + hauteurchute + ", nombredechute=" + nombredechute + ", chute=" + chute + ", longueur="
			+ longueur + ", cotetnamont=" + cotetnamont + ", cotetnaval=" + cotetnaval + "]";
}



}
