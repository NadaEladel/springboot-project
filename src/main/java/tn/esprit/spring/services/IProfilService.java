package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Profilenlong;

public interface IProfilService {
	public void ajoutProfil (Profilenlong profilenlong) ;
	List<Profilenlong> ListerProfil();
	public Profilenlong afficherProfil(Long idProfil) ;
	public void Update(Long id, Profilenlong profilenlong);
	public void delete(Long id);
}
