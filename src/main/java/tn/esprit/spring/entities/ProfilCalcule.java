package tn.esprit.spring.entities;

import javax.persistence.*;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

@Entity
public class ProfilCalcule  implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
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

    private float coeficient;
    private float acceleration;


    // resultat

    private float hauteurdechutetotal;
    private float coteprojetamont;
    private float coteprojetaval;
    private float profondeur;
    private float pertedechargelineaire;
    private float pertedechargesinguliaire;
    private float coteplushauteeauamont;
    private float coteplushauteeauaval;
   
   // @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH,CascadeType.REMOVE}, fetch=FetchType.LAZY,optional=true )
  
   // @OneToOne(cascade= {CascadeType.PERSIST, CascadeType.REMOVE}, fetch=FetchType.EAGER)
   // @LazyCollection(LazyCollectionOption.FALSE)
	//@OneToOne(cascade={CascadeType.REMOVE})
  // @JsonBackReference
   
    
    
   //@OneToOne
   //@JsonIgnore
 //  @PrimaryKeyJoinColumn
  // @JoinColumn(name = "dim_id", referencedColumnName = "id")
  // @OnDelete(action = OnDeleteAction.CASCADE)
    //@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    
    @OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "dim_id")
    @JsonIgnore
    private DimCalcule dim;

    public ProfilCalcule() {

    }

    public ProfilCalcule(long id, String canals, String namont, String naval, DimCalcule dim) {
        this.id = id;
        this.canals = canals;
        this.namont = namont;
        this.naval = naval;
        this.dim = dim;
    }

    public ProfilCalcule(long id, String canals, String namont, String naval, int hauteurchute, int nombredechute, int chute, int longueur, float cotetnamont, float cotetnaval, float coeficient, float acceleration, float hauteurdechutetotal, float coteprojetamont, float coteprojetaval, float profondeur, float pertedechargelineaire, float pertedechargesinguliaire, float coteplushauteeauamont, float coteplushauteeauaval, DimCalcule dim) {
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
        this.coeficient = coeficient;
        this.acceleration = acceleration;
        this.hauteurdechutetotal = hauteurdechutetotal;
        this.coteprojetamont = coteprojetamont;
        this.coteprojetaval = coteprojetaval;
        this.profondeur = profondeur;
        this.pertedechargelineaire = pertedechargelineaire;
        this.pertedechargesinguliaire = pertedechargesinguliaire;
        this.coteplushauteeauamont = coteplushauteeauamont;
        this.coteplushauteeauaval = coteplushauteeauaval;
        this.dim = dim;
    }

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

    public float getCoeficient() {
        return coeficient;
    }

    public void setCoeficient(float coeficient) {
        this.coeficient = coeficient;
    }

    public float getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(float acceleration) {
        this.acceleration = acceleration;
    }

    public float getHauteurdechutetotal() {
        return hauteurdechutetotal;
    }

    public void setHauteurdechutetotal(float hauteurdechutetotal) {
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

    public DimCalcule getDim() {
        return dim;
    }

    public void setDim(DimCalcule dim) {
        this.dim = dim;
    }
}
