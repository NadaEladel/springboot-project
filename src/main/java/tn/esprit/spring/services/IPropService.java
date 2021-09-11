package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Proposition;


public interface IPropService {
	List<Proposition> ListerProposition();
	public Proposition afficherProposition(Long idProp) ;
	
}
