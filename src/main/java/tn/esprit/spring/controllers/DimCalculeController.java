package tn.esprit.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entities.DimCalcule;
import tn.esprit.spring.entities.Dimensionnement;
import tn.esprit.spring.entities.Plan;
import tn.esprit.spring.entities.ProfilCalcule;
import tn.esprit.spring.repository.DimRepository;
import tn.esprit.spring.repository.DimcalculeRepository;
import tn.esprit.spring.repository.PlanRepository;
import tn.esprit.spring.repository.ProfilCalculeRepository;
import tn.esprit.spring.repository.ResultatdimRepository;
import tn.esprit.spring.services.DimCalculeService;
import tn.esprit.spring.services.DimCalculeServiceImpl;
import tn.esprit.spring.services.IDimService;
import tn.esprit.spring.services.PlanServiceImpl;
import tn.esprit.spring.services.ProfileCalculServiceImpl;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/dimc")
public class DimCalculeController {

	@Autowired
	DimCalculeService ds;
	@Autowired
	DimCalculeServiceImpl dr;
	@Autowired
	PlanRepository pr;
	@Autowired
	PlanServiceImpl ps;
	@Autowired
	DimcalculeRepository dimr;
	
	@Autowired
	ProfileCalculServiceImpl profil;
	
	@Autowired
	ProfilCalculeRepository profilRep;

	

	
	  @PostMapping("/dims/{plantId}") public DimCalcule createComment(@PathVariable
	("plantId")  Long planId,@RequestBody DimCalcule dim) { 
			  
	  /* return pr.findById(planId).map(plan -> { dim.setPlan(plan); return dimr.save(dim);
	  }).orElseThrow(() -> new ResourceNotFoundException("PostId " + planId +
	  " not found"));*/
	  
	  Plan plan = ps.getPlanById(planId); 
	  dim.setPlan(plan);
	  System.out.println(dim); System.out.println("testsss");
	  return
	  dimr.save(dim);
	  
	  }
	 
//get all dim by plan public List<DimCalcule> getAllByPlan(Long idPlan)
	  
	  @GetMapping("/allByPlan/{id}")
		private List<DimCalcule> getAllByPlans(@PathVariable ("id")Long id) {
		  Plan plan = ps.getPlanById(id); 
			return dr.getAllByPlan(plan);
		
		}
//	 @PostMapping("/dims")
//	    public DimCalcule createComment(@RequestBody DimCalcule dim) {
//	       /*return pr.findById(planId).map(plan -> {
//	            dim.setPlan(plan);
//	            return dimr.save(dim);
//	        }).orElseThrow(() -> new ResourceNotFoundException("PostId " + planId + " not found"));*/
//	         Plan plan = ps.getPlanById(1L);
//	         dim.setPlan(plan);
//	         System.out.println(dim);
//	        System.out.println("testsss");
//	         return dimr.save(dim);
//
//	    }
	  
	@PostMapping("/add")
	public DimCalcule AjouterDimensionnement(@RequestBody DimCalcule dimc) {

		return ds.save(dimc);
	}

	@GetMapping("/plans")
	private List<DimCalcule> getAllPlans() {
		return dr.getAllDimCalcule();
	}

	@GetMapping("/debit/{id}")
	public DimCalcule debit(@PathVariable Long id) {
		return dr.debit(id);
	}

	@GetMapping("/hauteur/{id}")
	public DimCalcule hauteur(@PathVariable Long id) {

		return dr.hauteur(id);
	}

	@GetMapping("/smouille/{id}")
	public DimCalcule Smouille(@PathVariable Long id) {

		return dr.Smouille(id);
	}

	@GetMapping("/vitesse/{id}")
	public DimCalcule vitesse(@PathVariable Long id) {
		return dr.vitesse(id);
	}

//to do get all dim by id plan 
	
	
	@DeleteMapping("/delete/{id}")
    public void deletDimCalcule(@PathVariable("id") Long id)
    {
		dr.delete(id);
    }
	
	
	//getdimbyId
	@GetMapping("/getOneDim/{id}")
	public Optional<DimCalcule> afficherDimensionnement(@PathVariable Long id) {
		return dr.findById(id);
				
		
		
	}
	
	 @PutMapping("/updatedim/{id}")
	    public DimCalcule update(@RequestBody DimCalcule m,@PathVariable("id") Long id)
	    {
		 DimCalcule dm = dimr.findById(id).get();
	        //findprofil by id dim
	     ProfilCalcule dim =  profilRep.findByDim(dm).get(0);
	        //update profil
	     
	     
	     profil.update(dim,dim.getId());
	       dr.update(m,id);
	        return m;
	    }
 /////////////////stat///////////
	 
	 //

	 @RequestMapping(value = "/statistiqueyn", method = RequestMethod.GET)
	    public List<Float> statyn()
	    {
		 
		return dimr.afficheyn();
		
		
	    }
	 
	 //Secondary
	 
	 @RequestMapping(value = "/secondaireYn", method = RequestMethod.GET)
	    public List<Float> statynSecondaire()
	    {
		 
		return dimr.afficheynSecdaire();
		
	
	    }
	 
	 
	 @RequestMapping(value = "/primaireYn", method = RequestMethod.GET)
	    public List<Float> statynPrimaire()
	    {
		 
		return dimr.afficheynPrimaire();
		
	
	    }
	 
	 //// namont primaire
	 
	 
	 @RequestMapping(value = "/Primairenammont", method = RequestMethod.GET)
	    public List<String> namontPrimaire()
	    {
		 
		return dimr.namontPrimaire();
		
	
	  }
	 
	 
//// namont Secondaire
	 
	 
	 @RequestMapping(value = "/Secondairenammont", method = RequestMethod.GET)
	    public List<String> namontSecondaire()
	    {
		 
		return dimr.namontSeconadire();
		
	
	  }
	 
	 
//// namont Tertiaire
	 
	 
	 @RequestMapping(value = "/Tertiarenammont", method = RequestMethod.GET)
	    public List<String> namontTertiaire()
	    {
		 
		return dimr.namontTertiaire();
		
	
	  }

}
