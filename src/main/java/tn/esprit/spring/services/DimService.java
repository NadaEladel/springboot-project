package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entities.Dimensionnement;
import tn.esprit.spring.repository.DimRepository;

@Service
public class DimService implements IDimService {
	@Autowired
	DimRepository dr;
	@Autowired
	DimService ds;

	@Override
	public void ajoutDimensionnement(Dimensionnement dimensionnement) {
		// TODO Auto-generated method stub
		dr.save(dimensionnement);
		
	}

	@Override
	public List<Dimensionnement> ListerDimensionnement() {
		// TODO Auto-generated method stub
		return (List<Dimensionnement>)dr.findAll();
	}

	@Override
	public Dimensionnement afficherDimensionnement(Long idDim) {
		// TODO Auto-generated method stub
		return dr.findById(idDim).orElse(null) ;
	}

	
	@Override
	public void Update(Long id, Dimensionnement dimensionnement) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		dr.deleteById(id);
		
	}

}
