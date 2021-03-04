package tn.esprit.spring.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class ResultatDim implements Serializable {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY) 
private float yn;
private float hretunue;
private float q;
private float section;
private float vitesse;
public float getYn() {
	return yn;
}
public void setYn(float yn) {
	this.yn = yn;
}
public float getHretunue() {
	return hretunue;
}
public void setHretunue(float hretunue) {
	this.hretunue = hretunue;
}
public float getQ() {
	return q;
}
public void setQ(float q) {
	this.q = q;
}
public float getSection() {
	return section;
}
public void setSection(float section) {
	this.section = section;
}
public float getVitesse() {
	return vitesse;
}
public void setVitesse(float vitesse) {
	this.vitesse = vitesse;
}
@Override
public String toString() {
	return "ResultatProfil [yn=" + yn + ", hretunue=" + hretunue + ", q=" + q + ", section=" + section + ", vitesse="
			+ vitesse + "]";
}

}
