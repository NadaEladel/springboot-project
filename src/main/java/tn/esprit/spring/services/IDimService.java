package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Dimensionnement;


public interface IDimService {
	public void ajoutDimensionnement (Dimensionnement dimensionnement) ;
	List<Dimensionnement> ListerDimensionnement();
	public Dimensionnement afficherDimensionnement(Long idDim) ;
	public void Update(Long id, Dimensionnement dimensionnement);
	public void delete(Long id);
	float debit(float s, float q);
	double hauteur(float Q, float K, float i, float b, float y0, float m);
	float Smouille(float yn, float b, float m);
	double V(float Smouille, float Q);

	
	

}
