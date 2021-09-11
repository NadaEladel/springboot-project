package tn.esprit.spring.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
@Entity
public class DimCalcule   implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    // @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private String canals;
    private String namont;
    private String naval;
    private float debitunitaire;
    private float surface;
    private float largeurdecanal;
    private float coefmanning;
    private float pente;
    private float talus;
    private float y0;
    private float revanche;
    private int b;
    //result calcul
    private float yn;
    private float hretunue;
    private float q;
    private float section;
    private float vitesse;


    @ManyToOne
    @JsonIgnore
   // @JsonBackReference
    @JoinTable(	name = "plan_dim",
            joinColumns = @JoinColumn(name = "dim_id"),
            inverseJoinColumns = @JoinColumn(name = "plan_id"))
    @OnDelete(action = OnDeleteAction.CASCADE)
     
    private Plan plan;

    
	/*
	 * @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
	 * CascadeType.REFRESH,CascadeType.REMOVE}, fetch=FetchType.LAZY,optional=true )
	 * 
	 * private ProfilCalcule profilenlong;
	 */
   // @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL , mappedBy = "dim")
   //private ProfilCalcule profilenlong;
    
    public DimCalcule() {
    }


    public DimCalcule(String canals, String namont, Plan plan) {
        this.canals = canals;
        this.namont = namont;
        this.plan = plan;
    }

    public DimCalcule(long id, String canals, String namont, String naval, float debitunitaire, float surface, float largeurdecanal, float coefmanning, float pente, float talus, float y0, float revanche, int b, float yn, float hretunue, float q, float section, float vitesse, Plan plan) {
        this.id = id;
        this.canals = canals;
        this.namont = namont;
        this.naval = naval;
        this.debitunitaire = debitunitaire;
        this.surface = surface;
        this.largeurdecanal = largeurdecanal;
        this.coefmanning = coefmanning;
        this.pente = pente;
        this.talus = talus;
        this.y0 = y0;
        this.revanche = revanche;
        this.b = b;
        this.yn = yn;
        this.hretunue = hretunue;
        this.q = q;
        this.section = section;
        this.vitesse = vitesse;
        this.plan = plan;
     
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

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

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

    public Plan getPlan() {
        return plan;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }


	
	/*
	 * public ProfilCalcule getProfilenlong() { return profilenlong; }
	 * 
	 * public void setProfilenlong(ProfilCalcule profilenlong) { this.profilenlong =
	 * profilenlong; }
	 */

	public DimCalcule(String canals, String namont, String naval, float debitunitaire, float surface,
			float largeurdecanal, float coefmanning, float pente, float talus, float y0, int b,
			 Plan plan) {
		super();
		this.canals = canals;
		this.namont = namont;
		this.naval = naval;
		this.debitunitaire = debitunitaire;
		this.surface = surface;
		this.largeurdecanal = largeurdecanal;
		this.coefmanning = coefmanning;
		this.pente = pente;
		this.talus = talus;
		this.y0 = y0;
		
		
		this.plan = plan;
		
	}
    
    
    
	/*
	 * canals: "Tertiaire" coefmanning: 22 debitunitaire: 2222 largeurdecanal: 22
	 * namont: "www" naval: "2222" pente: 222 revanche: 22 surface: 222 talus: 222
	 * y0: 222
	 */
}





