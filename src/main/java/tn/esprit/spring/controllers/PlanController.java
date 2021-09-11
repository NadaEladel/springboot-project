package tn.esprit.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tn.esprit.spring.entities.*;
import tn.esprit.spring.repository.PlanRepository;
import tn.esprit.spring.response.ResponseMessage;
import tn.esprit.spring.services.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//@CrossOrigin(origins = "*", maxAge = 3600)
@CrossOrigin(origins = "http://localhost:4200")

@RestController
@RequestMapping("/api/plan")
public class PlanController {

    @Autowired
     PlanServiceImpl planImp;
    @Autowired
     DimCalculeServiceImpl dr;
    @Autowired
     PlanRepository pr;
    @Autowired
     FilesStorageService storageService;
    @Autowired
      UserController userController;
   /* @Autowired
    public PlanController(FilesStorageService storageService,UserController userController,PlanRepository pr,DimCalculeServiceImpl dr, PlanServiceImpl planImp) {
        this.storageService = storageService;
        this.userController =userController;
        this.pr=pr;
        this.dr=dr;
        this.planImp=planImp;
    }*/

    //add file and plan
   @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    @PostMapping("/addPlan/{id}")
    public ResponseEntity<ResponseMessage> uploadFile( String adresse, String reseaux,
                                                       String proprietaire,
                                                      @PathVariable(value = "id") Long id_user,
                                                      @RequestParam("file") MultipartFile file) {
        System.out.println("id"+id_user);

        System.out.println("file"+file);


        String message = "";
        try {

            storageService.store(file);
           // Plan d = new Plan ( adresse,  reseaux,
             //        proprietaire,userController.user(id_user), file.getOriginalFilename(), file.getName(), file.getContentType(),LocalDate.now().plusDays(1));

           /* Plan e = new Plan(adresse,reseaux,proprietaire,file.getOriginalFilename(),
                    file.getName(),
                    userController.user(id_user),
                    file.getContentType(),LocalDate.now().plusDays(1));*/
           /* Note e = new Note(desc,file.getOriginalFilename(),
                    file.getName(),
                    userController.user(id_user),
                    file.getContentType(),LocalDate.now().plusDays(1),obj);*/
            Plan d= new Plan (adresse,reseaux,proprietaire,file.getOriginalFilename(),
                    file.getName(),
                    userController.user(id_user), file.getContentType(),LocalDate.now().plusDays(1));

            List<Plan> x=new ArrayList<>();
            x.add(d);
            pr.save(d);

            message = "Note telechargé avec succées avec la capture: " + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        }
        catch (Exception e) {
            message = "Désolée: " + file.getOriginalFilename() + "!";

            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }





  /*@GetMapping("/plans")
   private List<Plan> getAllPlans()
    {
        return planImp.getAllPlan();
    }

*/
   @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    @GetMapping(value = "/plans")
    public Iterable<Plan> getAllPlans()
    {
        return pr.findAll();
    }



    @GetMapping("/test")
    public Boolean test()
    {
      return  true;
    }
    @DeleteMapping("/delete/{id}")
    public void deleteBook(@PathVariable("id") Long id)
    {
        planImp.delete(id);
    }

    @GetMapping("/planById/{id}")
    public Plan getPlanById(@PathVariable("id") Long id)
    {
        return planImp.getPlanById(id);
    }

    @PutMapping("/update/{id}")
    public Plan update(@RequestBody Plan plan,@PathVariable("id") Long id)
    {
        planImp.update(plan,id);
        return plan;
    }
    @Autowired
   	PlanRepository sr;
    @GetMapping("/getP/{username}")    
    public Object rechercher(@PathVariable(name = "username") String username) {
    return	sr.trouveFicheByPlan(username);
   // return null;
    } 

}
