package tn.esprit.spring.controllers;

import java.util.List;
import java.util.Optional;
import java.util.Properties;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.security.access.prepost.PreAuthorize;
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
import tn.esprit.spring.entities.ResultatDim;
import tn.esprit.spring.repository.DimRepository;
import tn.esprit.spring.repository.ResultatdimRepository;
import tn.esprit.spring.services.Formules;
import tn.esprit.spring.services.IDimService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class DimController {
	@Autowired
	IDimService ds;
	@Autowired
	DimRepository dr;
	@Autowired
	ResultatdimRepository rr;
	
	@PostMapping("/addDim")

	public void AjouterDimensionnement(@RequestBody Dimensionnement dimensionnement) {
		ds.ajoutDimensionnement(dimensionnement);
	}
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	@GetMapping("/getAll")
	public List<Dimensionnement>  listerDimensionnement() {
		List<Dimensionnement> list= ds.ListerDimensionnement();
				return list;
	}
	
	@GetMapping("/getOneDim/{id}")
	public Dimensionnement afficherDimensionnement(@PathVariable Long id, Dimensionnement dim) {
		return ds.afficherDimensionnement(id);
		
		
	}

	
@GetMapping("/getresultatdim/{id}")
public float afficherresulatDim(@PathVariable Long id,@RequestBody ResultatDim res) {
Dimensionnement dim=dr.findById(id).get();

float q=res.getQ();
  return q=ds.debit(dim.getSurface(), dim.getDebitunitaire());
 
 //float yn=res.getYn();
    //yn=(float) ds.hauteur(q, dim.getCoefmanning(), dim.getPente(), dim.getB(), dim.getY0(), dim.getTalus()); 
		
 //float section=res.getSection();
   // section=(float) ds.Smouille(yn, dim.getB(), dim.getTalus());

  //float vitesse= res.getVitesse();
  // vitesse= (float) ds.V(section, q);

   //return res;
   

}

	
	

	
	
	
	
	
	
	
	
	
	
	
	
	@PutMapping("/dimensionnement/{id}")
	public ResponseEntity<Object> updateDimensionnement(@PathVariable long id, @RequestBody Dimensionnement dimensionnement) {

		Optional<Dimensionnement> DimOptional = dr.findById(id);

		if (!DimOptional.isPresent())
			return ResponseEntity.notFound().build();

		dimensionnement.setId(id);
		
		dr.save(dimensionnement);
		
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/supp/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
	    if (!dr.findById(id).isPresent()) {
	        ResponseEntity.badRequest().build();
	    }

	    dr.deleteById(id);

	    return ResponseEntity.ok().build();
	}
	
	


}
