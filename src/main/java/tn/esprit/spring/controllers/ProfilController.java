package tn.esprit.spring.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Dimensionnement;
import tn.esprit.spring.entities.Plan;
import tn.esprit.spring.entities.Profilenlong;
import tn.esprit.spring.entities.ResultatDim;
import tn.esprit.spring.entities.ResultatProfil;
import tn.esprit.spring.entities.Statistique;
import tn.esprit.spring.repository.DimRepository;
import tn.esprit.spring.repository.ProfilRepository;
import tn.esprit.spring.services.IDimService;
import tn.esprit.spring.services.IProfilService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ProfilController {
	@Autowired
	IProfilService ps;
	@Autowired
	IDimService ds;
	@Autowired
	ProfilRepository pr;
	@Autowired
	DimRepository dr;
   
	@RequestMapping(value = "/statis", method = RequestMethod.GET)
    public Statistique stat()
    {
    int n=pr.countprofil();
    int Primaire=pr.findProfileByCategorie("Primaire");
    int Secondaire=pr.findProfileByCategorie("Secondaire");
    int Tertiaire=pr.findProfileByCategorie("Tertiaire");
    Primaire=Primaire*100/n;
    Secondaire=Secondaire*100/n;
    Tertiaire=Tertiaire*100/n;
   
    Statistique e=new Statistique();

   e.setLabel1("Primaire");
   e.setNumb1(Primaire);
   e.setLabel2("Secondaire");
   e.setNumb2(Secondaire);
   e.setLabel3("Tertiaire");
   e.setNumb3(Tertiaire);  
   return e;
   
    }
    
    

	@PostMapping("/addProfil/{idDim}")
	public void AjouterProfil(@RequestBody Profilenlong profilenlong, @PathVariable Long idDim) {
		ps.ajoutProfil(profilenlong,idDim);
	}
	
	@GetMapping("/getAllProfil")
	public List<Profilenlong>  listerProfil() {
		List<Profilenlong> list= ps.ListerProfil();
				return list;
	}
	
	@GetMapping("/getOneProfil/{id}")
	public Profilenlong afficherProfil(@PathVariable Long id) {
		return ps.afficherProfil(id);
	}
	
	
	
	@PutMapping("/profilenlong/{id}")
	public ResponseEntity<Object> updateDimensionnement(@PathVariable long id, @RequestBody Profilenlong profilenlong) {

		Optional<Profilenlong> ProfilOptional = pr.findById(id);

		if (!ProfilOptional.isPresent())
			return ResponseEntity.notFound().build();

		profilenlong.setId(id);
		
		pr.save(profilenlong);

		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/supprimer/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
	    if (!pr.findById(id).isPresent()) {
	        ResponseEntity.badRequest().build();
	    }

	    pr.deleteById(id);

	    return ResponseEntity.ok().build();
	}

	@GetMapping("/getresultatprofil/{id}")
	public float afficherresulatProfil(@PathVariable Long id,@RequestBody ResultatProfil res) {

		Profilenlong profil=pr.findById(id).get();
		
		//le premier valeur ya5ou valeur mta3 champ de l'entité profil en long"getCotetnamont"-heuteur) 
//ba3d kif n3wdou l5edma 3la deuxieme noeud ya5ou lcote le7sabneh tw "coteprojetamont"-heuteur(champ d'entree)
		
		float coteprojetamont=res.getCoteprojetamont();
		  coteprojetamont=ps.CPamount(profil.getCotetnamont(), profil.getHauteurchute());
		

		 float coteprojetaval=res.getCoteprojetaval();
		   coteprojetaval=ps.CPaval(coteprojetamont, profil.getLongueur(),(float) 0.005 );
		
		 float profondeur=res.getProfondeur();
		  profondeur=ps.Pr(profil.getCotetnamont(), coteprojetamont);
	
		  float pertedechargelineaire=res.getPertedechargelineaire();
		return  pertedechargelineaire=ps.J(profil.getLongueur(), (float) 0.005);
	
      //  float pertedechargesinguliaire=res.getPertedechargesinguliaire();
		//	 pertedechargesinguliaire=ps.DeltaH(ξ, V, G)
	
	
		//float  hauteurdechutetotal=res.getHauteurdechuttTotal();
		// hauteurdechutetotal=ps.hauteurchtot(profil.getCotetnamont(), CP2)
		
		
		//float coteplushauteeauamont=res.getCoteplushauteeauamont();
		// coteplushauteeauamont=ps.coteeauamont(CPAmont, yn)
		
		
		//float coteplushauteeauaval=ps.coteeauaval(CPAval, yn);
		// coteplushauteeauaval=ps.coteeauaval(CPAval, yn)
	}



}

