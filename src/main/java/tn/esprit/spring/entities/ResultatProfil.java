package tn.esprit.spring.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class ResultatProfil implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
private long id;
private float hauteurdechutetotal;
private float coteprojetamont;
private float coteprojetaval;
private float profondeur;
private float pertedechargelineaire;
private float pertedechargesinguliaire;
private float coteplushauteeauamont;
private float coteplushauteeauaval;
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public float getHauteurdechuttTotal() {
	return hauteurdechutetotal;
}
public void setHauteurdechuttTotal(float hauteurdechutetotal) {
	this.hauteurdechutetotal = hauteurdechutetotal;
}
public float getCoteprojetamont() {
	return coteprojetamont;
}
public void setCoteprojetamont(float coteprojetamont) {
	this.coteprojetamont = coteprojetamont;
}
public float getCoteprojetaval() {
	return coteprojetaval;
}
public void setCoteprojetaval(float coteprojetaval) {
	this.coteprojetaval = coteprojetaval;
}
public float getProfondeur() {
	return profondeur;
}
public void setProfondeur(float profondeur) {
	this.profondeur = profondeur;
}
public float getPertedechargelineaire() {
	return pertedechargelineaire;
}
public void setPertedechargelineaire(float pertedechargelineaire) {
	this.pertedechargelineaire = pertedechargelineaire;
}
public float getPertedechargesinguliaire() {
	return pertedechargesinguliaire;
}
public void setPertedechargesinguliaire(float pertedechargesinguliaire) {
	this.pertedechargesinguliaire = pertedechargesinguliaire;
}
public float getCoteplushauteeauamont() {
	return coteplushauteeauamont;
}
public void setCoteplushauteeauamont(float coteplushauteeauamont) {
	this.coteplushauteeauamont = coteplushauteeauamont;
}
public float getCoteplushauteeauaval() {
	return coteplushauteeauaval;
}
public void setCoteplushauteeauaval(float coteplushauteeauaval) {
	this.coteplushauteeauaval = coteplushauteeauaval;
}
@Override
public String toString() {
	return "ResultatDim [id=" + id + ", hauteurdechuttTotal=" + hauteurdechutetotal + ", coteprojetamont="
			+ coteprojetamont + ", coteprojetaval=" + coteprojetaval + ", profondeur=" + profondeur
			+ ", pertedechargelineaire=" + pertedechargelineaire + ", pertedechargesinguliaire="
			+ pertedechargesinguliaire + ", coteplushauteeauamont=" + coteplushauteeauamont + ", coteplushauteeauaval="
			+ coteplushauteeauaval + "]";
}


}
