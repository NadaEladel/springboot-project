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
	
	
	
	

	// 1- Dimensionnement des canaux 
	
	
	//1.1- Débit :  Q = s * q 
	// s : surface(ha)
	// q : debit unitaire (l/s)
	@Override
	public float debit(float s , float q ) {return s*q ;}
	
	//1.2- Hauteur d'eau dans le canal 
	
	
	// Q : débit (l/s)
	// K : coefficient de Manning-Strickler pour les canaux bétonné, K =70 ;
	// i : pente (%) ;
	// b : base du canal (m) b=2*10
	// m : pente des talus (m/m)
	@Override
 public double hauteur(float Q , float K , float i , float b , float y0 , float m )
	{
	return ((0.001 * Q / K * Math.pow(i, 0.5))* ( Math.pow((b+2*y0*(Math.pow((1+Math.pow(m, 2)), 0.5))), 0.4) / (b+m*y0) ) )  ; 
	}
	
	

	
	// 1.3-Section mouillée 
	
	
	// yn : hauteur d’eau dans le canal (m) ;
	// b : base du canal (m)
	// m : pente des talus (m/m);
	@Override
	public float Smouille(float yn,float b,float m) {return yn*(b+m+yn);}
	
	
	
	// 1.4-Vitesse d’écoulement 
	// Q : débit (l/s) ;
	// Smouillée : section mouillée (m2)
	//m : pente des talus (m/m);
	@Override
	public double V(float Smouille , float Q) {return (0.001*Q/Smouille);}
	
	
	
	
	
	

}
