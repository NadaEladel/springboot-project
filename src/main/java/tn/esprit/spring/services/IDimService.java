package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Dimensionnement;


public interface IDimService {
	public void ajoutDimensionnement (Dimensionnement dimensionnement) ;
	List<Dimensionnement> ListerDimensionnement();
	public Dimensionnement afficherDimensionnement(Long idDim) ;
	public void Update(Long id, Dimensionnement dimensionnement);
	public void delete(Long id);

}
