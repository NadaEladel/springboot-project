package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Dimensionnement;
import tn.esprit.spring.entities.Profilenlong;
import tn.esprit.spring.repository.DimRepository;
import tn.esprit.spring.repository.ProfilRepository;

@Service
public class ProfilService implements IProfilService{
	
	@Autowired
	ProfilRepository pr;
	@Autowired
	ProfilService ps;
	@Override
	public void ajoutProfil(Profilenlong profilenlong) {
		// TODO Auto-generated method stub
	pr.save(profilenlong);	
	}

	@Override
	public List<Profilenlong> ListerProfil() {
		// TODO Auto-generated method stub
		return  (List<Profilenlong>)pr.findAll();
	}

	@Override
	public Profilenlong afficherProfil(Long idProfil) {
		// TODO Auto-generated method stub
		return pr.findById(idProfil).orElse(null) ;
	}

	@Override
	public void Update(Long id, Profilenlong profilenlong) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		pr.deleteById(id);

	}

}
