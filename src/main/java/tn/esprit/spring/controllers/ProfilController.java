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
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.spring.entities.Profilenlong;
import tn.esprit.spring.repository.ProfilRepository;
import tn.esprit.spring.services.IProfilService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ProfilController {
	@Autowired
	IProfilService ps;
	@Autowired
	ProfilRepository pr;

	@PostMapping("/addProfil")
	public void AjouterDimensionnement(@RequestBody Profilenlong profilenlong) {
		ps.ajoutProfil(profilenlong);
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


}
