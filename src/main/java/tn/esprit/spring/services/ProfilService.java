package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.DimCalcule;
import tn.esprit.spring.entities.Dimensionnement;
import tn.esprit.spring.entities.Profilenlong;
import tn.esprit.spring.repository.DimRepository;
import tn.esprit.spring.repository.DimcalculeRepository;
import tn.esprit.spring.repository.ProfilRepository;

@Service
public class ProfilService implements IProfilService{
	
	@Autowired
	ProfilRepository pr;
	@Autowired
	ProfilService ps;
	@Autowired
	DimcalculeRepository dimCalculeRepo;
	@Override
	public void ajoutProfil(Profilenlong profilenlong,Long idDim) {
		// TODO Auto-generated method stub
		DimCalcule dim = dimCalculeRepo.findById(idDim).get();

	    profilenlong.setCanals(dim.getCanals());
		profilenlong.setNamont(dim.getNamont());
		profilenlong.setNaval(dim.getNaval());
		//profilenlong.setDim(dim);
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
	
	
	//2 CALAGE DU PROFIL
	
		//2.1 Côte projet en amont :
		
		
		//CPaval : côte projet aval (m) ;
		//h : hauteur chute (m) ;
		@Override
		public
		float CPamount (float CPaval , float h ) {return CPaval - h ;}
		
		//2.2 Côte projet en aval 
		
		
		// CPamont : côte projet amont (m) ;
		// L : longueur du tronçon du canal (m) ;
		// i : pente (%) ;
		@Override
		public float CPaval ( float CPamont , float L , float i ){return CPamont - L * i ; }
			
		
		// 2.3 Profondeur du canal
			
		// CTNamont : côte du terrain naturel en amont (m) ;
		// CPamont : côte projet amont (m) ;
		@Override
		public float Pr (float CTNamont , float CPamont) {return  CTNamont -  CPamont ;}
		
		// 2.4 Perte de charge linéaire
		
		// L : longueur du tronçon du canal (m) ;
		// i : pente (%)
		@Override
		public float J (float L , float i ) {return L*i ;}
		
		
		// 2.5 Perte de charge singulière 
		
		// ∆h : pertes de charge dues à la singularité (m) ;
		// ξ : coefficients de pertes de charge (sans dimension) ;
		// G : accélération de la pesenteur (m/s2) ;
		// V : vitesse d’écoulement (m/s) ;
		// Q : débit (m3/s) ;
		
		@Override
		public double DeltaH( float ξ , float V , float G  )
		{
			return ξ*V*V/2*G ;
			
		}

		@Override
		public float hauteurchtot(float CP1, float CP2) {
			// TODO Auto-generated method stub
			return CP1-CP2;
		}

		/*@Override
		public float coteeauamont(float CPAmont, float yn) {
			// TODO Auto-generated method stub
			return CPAmont+yn;
		}

		@Override
		public float coteeauaval(float CPAval, float yn) {
			// TODO Auto-generated method stub
			return CPAval+yn;
		}*/

	
		
//update
		
		
}
