package tn.esprit.spring.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.spring.entities.Dimensionnement;
import tn.esprit.spring.repository.DimRepository;
import tn.esprit.spring.services.IDimService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class DimController {
	@Autowired
	IDimService ds;
	@Autowired
	DimRepository dr;
	
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
	public Dimensionnement afficherDimensionnement(@PathVariable Long id) {
		return ds.afficherDimensionnement(id);
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
