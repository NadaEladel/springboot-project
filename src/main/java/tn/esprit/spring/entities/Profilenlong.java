package tn.esprit.spring.entities;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.NaturalId;
@Entity
public  class Profilenlong implements Serializable {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY) 
private long id; 
//@NaturalId(mutable=true)
//@Column(name = "canals", unique=true)

private  String canals ;
private String namont ;	
private String naval ;
private int hauteurchute;
private int nombredechute ;
private int chute ;
private int longueur;
private float cotetnamont ;
private float cotetnaval;



//private float ξ;
//private float G;
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getCanals() {
	return canals;
}
public void setCanals(String canals) {
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



	/*public float getξ() {
        return ξ;
    }
    public void setξ(float ξ) {
        this.ξ = ξ;
    }
    public float getG() {
        return G;
    }
    public void setG(float g) {
        G = g;
    }*/
@Override
public String toString() {
	return "Profilenlong [id=" + id + ", canals=" + canals + ", namont=" + namont + ", naval=" + naval
			+ ", hauteurchute=" + hauteurchute + ", nombredechute=" + nombredechute + ", chute=" + chute + ", longueur="
			+ longueur + ", cotetnamont=" + cotetnamont + ", cotetnaval=" + cotetnaval + "]";
}

	public Profilenlong() {
	}

	public Profilenlong(long id, String canals, String namont, String naval, int hauteurchute, int nombredechute, int chute, int longueur, float cotetnamont, float cotetnaval) {
		this.id = id;
		this.canals = canals;
		this.namont = namont;
		this.naval = naval;
		this.hauteurchute = hauteurchute;
		this.nombredechute = nombredechute;
		this.chute = chute;
		this.longueur = longueur;
		this.cotetnamont = cotetnamont;
		this.cotetnaval = cotetnaval;

	}
}
