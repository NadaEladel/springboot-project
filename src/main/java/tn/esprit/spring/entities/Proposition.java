package tn.esprit.spring.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.*;

@Entity
@Table(name = "propositions")
public class Proposition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_proposition;
    private  String propositionscanner ;
  //  @JsonIgnore
    @OneToOne
@OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name ="User_id")
   // @JsonBackReference
	//@LazyCollection(LazyCollectionOption.FALSE)

    private  User user ;
    @Column(name = "type")
    private String type;
    private LocalDate date;
    private boolean validation;
public Proposition() {}

public Proposition(String propositionscanner, String name) {
		super();
		this.propositionscanner = propositionscanner;
		this.name = name;
	}


	public LocalDate getDate() {
	return date;
}

public void setDate(LocalDate date) {
	this.date = date;
}

public boolean isValidation() {
	return validation;
}

public void setValidation(boolean validation) {
	this.validation = validation;
}

public Proposition(String propositionscanner, User user, String type,
		String name,boolean val,LocalDate d) {
    this.propositionscanner = propositionscanner;
    this.user = user;
    this.type = type;
    this.name = name;
    this.validation=val;
    this.date=d;
}
public Proposition(String propositionscanner, User user, String type, String name) {
    this.propositionscanner = propositionscanner;
    this.user = user;
    this.type = type;
    this.name = name;
}

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name="name")
    private String name ;
        public Long getId_proposition() {
        return id_proposition;
    }

    public void setId_proposition(Long id_proposition) {
        this.id_proposition = id_proposition;
    }

    public String getPropositionscanner() {
        return propositionscanner;
    }

    public void setPropositionscanner(String propositionscanner) {
        this.propositionscanner = propositionscanner;
    }

 

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}