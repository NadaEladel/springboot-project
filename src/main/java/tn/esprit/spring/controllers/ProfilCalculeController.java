package tn.esprit.spring.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import tn.esprit.spring.entities.DimCalcule;
import tn.esprit.spring.entities.Plan;
import tn.esprit.spring.entities.ProfilCalcule;
import tn.esprit.spring.entities.Statistique;
import tn.esprit.spring.repository.DimcalculeRepository;
import tn.esprit.spring.repository.PlanRepository;
import tn.esprit.spring.repository.ProfilCalculeRepository;
import tn.esprit.spring.services.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController

@RequestMapping("/api/profile")
public class ProfilCalculeController {
    @Autowired
    ProfileCalculService ps;
    
    @Autowired
    ProfileCalculServiceImpl dr;
    
    @Autowired
    DimcalculeRepository dimr;
    
    @Autowired
    ProfilCalculeRepository pcr;
    
    //get all profil
    @GetMapping("/all/{idDim}")
    
    public List<ProfilCalcule> getAllProfile( @PathVariable  Long idDim) {
       // return ps.ajoutProfil(idDim);
    	DimCalcule dim = dimr.findById(idDim).get();
    	
    	return ps.getAllByPlan(dim);
    }
    
     @GetMapping("/all")
    
    public List<ProfilCalcule> getAll() {
       // return ps.ajoutProfil(idDim);
    
    	
    	return ps.getAll();
    }
    	
    @GetMapping("/profileById/{id}")
    public ProfilCalcule getPlanById(@PathVariable("id") Long id)
    {
        return dr.getProfileById(id);
    }
    

    @PostMapping("/add/{idDim}")
    public ProfilCalcule AjouterProfile(@RequestBody ProfilCalcule profil, @PathVariable  Long idDim) {
        return ps.ajoutProfil(profil,idDim);
    }

    
    
    @GetMapping("/CPamount/{id}")
    public ProfilCalcule CPamount(@PathVariable  Long id){

        return ps.CPamount(id);
    }


    @GetMapping("/paval/{id}")
    public ProfilCalcule CPaval( @PathVariable Long id){

        return dr.CPaval(id);
    }

    //test
    @GetMapping("/profondeur/{id}")
    public ProfilCalcule Profondeur(  @PathVariable Long id){

        return dr.Profondeur(id) ;
    }

    @GetMapping("/lineaire/{id}")
    public ProfilCalcule CalculeJ(@PathVariable  Long id){
        return  dr.CalculeJ(id);
    }
//
    @GetMapping("/singuliaire/{id}")
    public ProfilCalcule DeltaH( @PathVariable Long id ){

        return  dr.DeltaH(id);
    }

    @GetMapping("/hauteurch/{id}")
    public ProfilCalcule hauteurchtot(@PathVariable Long id ) {

        return  dr.hauteurchtot(id);
    }

    @GetMapping("/eauamont/{id}")
    public ProfilCalcule coteeauamont(@PathVariable Long id){


        return  dr.coteeauamont(id);
    }

    @GetMapping("/eauaval/{id}")
    public ProfilCalcule coteeauaval( @PathVariable Long id){

        return dr.coteeauaval(id);
    }
    
    //delete
    
    @DeleteMapping("/delete/{id}")
    public void deletDimCalcule(@PathVariable("id") Long id)
    {
		pcr.deleteById(id);
    }
    
    //update
    
    
    @PutMapping("/update/{id}")
    public ProfilCalcule update(@RequestBody ProfilCalcule plan,@PathVariable("id") Long id)
    {
    	return   dr.update(plan,id);
        
    }

    
    ////////////statistique//////////////
    
    @RequestMapping(value = "/statis", method = RequestMethod.GET)
    public Statistique stat()
    {
    int n=pcr.countprofil();
    int Primaire=pcr.findProfileByCategorie("Primaire");
    int Secondaire=pcr.findProfileByCategorie("Secondaire");
    int Tertiaire=pcr.findProfileByCategorie("Tertiaire");
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
 
    ///////////////statistique line//////////////
    //Primaire//
    
    @RequestMapping(value = "/statistiquecoteamont", method = RequestMethod.GET)
    public List<Float> statcoteqmont()
    {
    	List<Float> res =  Stream.concat(pcr.affichecoteamont().stream(), pcr.affichecoteaval().stream())
                .collect(Collectors.toList());
    	
	return res;
   
    
    }
    
    
    @RequestMapping(value = "/statistiquecotepamont", method = RequestMethod.GET)
    public List<Float> statcoteprojetamont()
    {
	 
    	
    	List<Float> res =  Stream.concat(pcr.affichecoteprojetamont().stream(), pcr.affichecoteprojetaval().stream())
                .collect(Collectors.toList());
	return res;
   
    
    }
    
    //Secondaire//
    @RequestMapping(value = "/statistiquecoteSecondaire", method = RequestMethod.GET)
    public List<Float> statcoteavalSecondaire()
    {
    	List<Float> res =  Stream.concat(pcr.affichecoteamontSecondaire().stream(), pcr.affichecoteavalSecondaire().stream())
                .collect(Collectors.toList());
    	
	return res;
   
    
    }
    
    @RequestMapping(value = "/statistiquecoteprojetSecondaire", method = RequestMethod.GET)
    public List<Float> statcoteprojetavalSecodaire()
    {
	 
    	List<Float> res =  Stream.concat(pcr.affichecoteprojetamontSecondaire().stream(), pcr.affichecoteprojetavalSecondaire().stream())
                .collect(Collectors.toList());
	return res;
   
   
    
    }
    //Tertiare//
    
    
    @RequestMapping(value = "/statistiquecoteTertiaire", method = RequestMethod.GET)
    public List<Float> statcoteavalTertiare()
    {
	 
    	List<Float> res =  Stream.concat(pcr.affichecoteamontTertiare().stream(), pcr.affichecoteavalTertiare().stream())
                .collect(Collectors.toList());
    	
	return res;
   
    
    }
    
    @RequestMapping(value = "/statistiquecoteprojetTertiare", method = RequestMethod.GET)
    public List<Float> statcoteprojetavalTetiare()
    {
	 
    	List<Float> res =  Stream.concat(pcr.affichecoteprojetamontTertiare().stream(), pcr.affichecoteprojetavalTertiare().stream())
                .collect(Collectors.toList());
	return res;
   
   
	
    
    }

}
