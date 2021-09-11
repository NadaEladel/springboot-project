package tn.esprit.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entities.Proposition;
import tn.esprit.spring.repository.propositionRepository;
import tn.esprit.spring.services.IPropService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController

public class PropController {
	@Autowired
	IPropService ps;
	@Autowired
	propositionRepository pr;
	
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	@GetMapping("/getAllp")
	public List<Proposition>  listerProposition() {
		return pr.findAll();
	}
	
	@GetMapping("/getOneProp/{id}")
	public Proposition afficherProposition(@PathVariable Long id) {
		return ps.afficherProposition(id);
	}
}
