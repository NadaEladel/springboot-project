package tn.esprit.spring.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Note implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_note;

    private String description ;
    private  String notescanner ;
private String statut;
    @JsonIgnore
    @JsonBackReference
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
   @JoinColumn(name ="User_id")
    private User usernote ;
    private String type;
    private LocalDate date;
    private String objet;
    
    public Long getId_note() {
        return id_note;
    }

    public void setId_note(Long id_note) {
        this.id_note = id_note;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        description = description;
    }

    public User getUsernote() {
        return usernote;
    }

    public void setUsernote(User usernote) {
        this.usernote = usernote;
    }
    

public String getNotescanner() {
		return notescanner;
	}

	public void setNotescanner(String notescanner) {
		this.notescanner = notescanner;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getObjet() {
		return objet;
	}

	public void setObjet(String objet) {
		this.objet = objet;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	

public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

public Note() {}   
private String nom;
	public  Note(String description,String nom, String notescanner, 
			User usernote, String type, LocalDate date, String objet) {
		
		this.description = description;
		this.nom=nom;
		this.notescanner = notescanner;
		this.usernote = usernote;
		this.type = type;
		this.date = date;
		this.objet = objet;
	}

	public Note(Long id_note, String description, String notescanner, String statut, User usernote, String type,
			LocalDate date, String objet, String nom) {
		super();
		this.id_note = id_note;
		this.description = description;
		this.notescanner = notescanner;
		this.statut = statut;
		this.usernote = usernote;
		this.type = type;
		this.date = date;
		this.objet = objet;
		this.nom = nom;
	}

	@Override
	public String toString() {
		return "Note [id_note=" + id_note + ", description=" + description + ", notescanner=" + notescanner
				+ ", statut=" + statut + ", usernote=" + usernote + ", type=" + type + ", date=" + date + ", objet="
				+ objet + ", nom=" + nom + "]";
	}
	


}