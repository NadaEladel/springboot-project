package tn.esprit.spring.controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import tn.esprit.spring.entities.DimCalcule;
import tn.esprit.spring.entities.Note;

import tn.esprit.spring.entities.Plan;
import tn.esprit.spring.repository.NoteRepository;

import tn.esprit.spring.repository.PlanRepository;
import tn.esprit.spring.response.ResponseMessage;
import tn.esprit.spring.services.FilesStorageService;
import tn.esprit.spring.services.NoteServiceImpl;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class NoteController {

    @Autowired
    private NoteRepository noteRepository ;
    @Autowired
    FilesStorageService storageService;
    
  @Autowired
  UserController userController;
  
  @Autowired
  NoteServiceImpl noteImpl;


  @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    @PostMapping("/note/{id}")
    public ResponseEntity<ResponseMessage> uploadFile(String obj,String desc,
    		@PathVariable(value = "id") Long id_user,
  		  @RequestParam("file") MultipartFile file) {
  	System.out.println("id"+id_user);

  	System.out.println("file"+file);

  	
  	String message = "";
       try {
       
        storageService.store(file);
  
       Note e = new Note(desc,file.getOriginalFilename(),
        		file.getName(),
        		userController.user(id_user),
        	file.getContentType(),LocalDate.now().plusDays(1),obj);
       
       e.setStatut("En attente");
       List<Note> x=new ArrayList<>();
       x.add(e);
  noteRepository.save(e);
       
  	message = "Note telechargé avec succées avec la capture: " + file.getOriginalFilename();
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
     }
  catch (Exception e) {
        message = "Désolée: " + file.getOriginalFilename() + "!";
    
  return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
      }
    }


  

    @GetMapping(value = "/listnote" )
    public Iterable<Note> propoList(){
        return  noteRepository.findAll();

    }

	@DeleteMapping(value = "/deletenote/{id}" )
    public void Delete(@PathVariable(name = "id") Long id ) {
        noteRepository.deleteById(id);

    }
    /* ////////////////////////////find////////////////////// */

    @GetMapping(value = "/getnote/{id}")
    public Note offre(@PathVariable(name = "id") Long id ) {
        return 	noteRepository.findById(id).get();
    }
    //update Note 
    @GetMapping("/updateNote/{id}")
    public Note updateStatut(@PathVariable("id") Long id)
    {
    	return  noteImpl.update(id);
       
    }
}
