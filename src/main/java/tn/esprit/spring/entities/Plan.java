package tn.esprit.spring.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
public class Plan  implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idPlan;
    private String adresse;
    private String reseaux;
    private  String proprietaire;

    private  String planscanner ;


    //private  String imagePlan;


    @OnDelete(action = OnDeleteAction.CASCADE)
    @ManyToOne
    
    @JoinColumn(name ="User_id")
    private User user;
    private String type;
    private LocalDate date;

   /* private String file;
    private String fileName;
    private String fileType;*/
/*
    @OneToMany
    private List<DimCalcule> calcules = new ArrayList<>();*/



    @JsonIgnore
    @JsonBackReference
    @OneToMany(mappedBy = "plan")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<DimCalcule> calcule;





    private String nom;

    public Plan(String adresse, String reseaux, String proprietaire, String nom, String planscanner, User user, String type,
                LocalDate date) {
        super();
        this.adresse = adresse;
        this.reseaux = reseaux;
        this.proprietaire = proprietaire;
        this.nom=nom;
        this.planscanner = planscanner;
        this.user = user;
        this.type = type;
        this.date = date;
    }


    public Plan() {

    }


    public Long getIdPlan() {
        return idPlan;
    }

    public void setIdPlan(Long idPlan) {
        this.idPlan = idPlan;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getReseaux() {
        return reseaux;
    }

    public void setReseaux(String reseaux) {
        this.reseaux = reseaux;
    }



    public String getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(String proprietaire) {
        this.proprietaire = proprietaire;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<DimCalcule> getCalcule() {
        return calcule;
    }

    public void setCalcule(List<DimCalcule> calcule) {
        this.calcule = calcule;
    }

    /*public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }
*/


    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getPlanscanner() {
        return planscanner;
    }

    public void setPlanscanner(String planscanner) {
        this.planscanner = planscanner;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    @Override
    public String toString() {
        return "Plan [idPlan=" + idPlan + ", adresse=" + adresse + ", reseaux=" + reseaux + ", proprietaire="
                + proprietaire + ", planscanner=" + planscanner + ", user=" + user + ", type=" + type + ", date=" + date
                + ", calcule=" + calcule + "]";
    }


}