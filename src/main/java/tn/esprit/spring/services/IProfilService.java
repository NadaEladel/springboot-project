package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Profilenlong;

public interface IProfilService {
	public void ajoutProfil (Profilenlong profilenlong,Long idDim) ;
	List<Profilenlong> ListerProfil();
	public Profilenlong afficherProfil(Long idProfil) ;
	public void Update(Long id, Profilenlong profilenlong);
	public void delete(Long id);
	float CPamount(float CPaval, float h);
	float CPaval(float CPamont, float L, float i);
	float Pr(float CTNamont, float CPamont);
	float J(float L, float i);
	double DeltaH(float ξ, float V, float G);
	float hauteurchtot(float CP1, float CP2);


}
