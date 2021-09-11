package tn.esprit.spring.controllers;

import java.time.LocalDate;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import tn.esprit.spring.entities.Note;
import tn.esprit.spring.entities.Proposition;
import tn.esprit.spring.repository.NoteRepository;
import tn.esprit.spring.repository.propositionRepository;
import tn.esprit.spring.response.ResponseMessage;
import tn.esprit.spring.services.FilesStorageService;
import tn.esprit.spring.services.FilesStorageServiceImpl;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class FilesController {

  @Autowired
  FilesStorageService storageService;
@Autowired
propositionRepository sr;
@Autowired
UserController userController;

@Bean
public JavaMailSender getJavaMailSender() {
    JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
    mailSender.setHost("smtp.gmail.com");
    mailSender.setPort(587);

    mailSender.setUsername("zizoakhtar@gmail.com");
    mailSender.setPassword("Babylife");

    Properties props = mailSender.getJavaMailProperties();
    props.put("mail.transport.protocol", "smtp");
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.starttls.enable", "true");
    props.put("mail.debug", "true");

    return mailSender;
}
@Autowired
private JavaMailSender javaMailSender;
@Autowired
NoteRepository ar;
 @RequestMapping(value ="/rec/{id_note}/{txt}", method = RequestMethod.PUT)
    public  ResponseEntity<ResponseMessage> traitrecl(@PathVariable(name = "id_note") Long id,@PathVariable(name = "txt") String txt )
    {	String message = "";
     try {
         
    	Note u=ar.findById(id).get();
    	
    	u.setStatut("Traité");

    	
    	
    	SimpleMailMessage msg = new SimpleMailMessage();
msg.setTo(u.getUsernote().getEmail());

msg.setSubject("bonjour votre réclamation est en cours du traitement  ");
msg.setText(txt);

javaMailSender.send(msg);
message = "Réponse envoyé avec succès";
return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
}
catch (Exception e) {
         message = "Veuillez ressayer!";
     
   return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
       }
     }
 
@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
  @PostMapping("/upload/{id}")
  public ResponseEntity<ResponseMessage> uploadFile(@PathVariable(value = "id") Long id_user,
		  @RequestParam("file") MultipartFile file) {
	System.out.println("id"+id_user);

	System.out.println("file"+file);

	
	String message = "";
     try {
     
      storageService.store(file);

      Proposition e = new Proposition(file.getName(),userController.user(id_user),
      	file.getContentType(),file.getOriginalFilename(),true,LocalDate.now());
     userController.user(id_user).setFile(e);
sr.save(e);
     
	message = "Uploaded the file successfully: " + file.getOriginalFilename();
      return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
   }
catch (Exception e) {
      message = "Could not upload the file: " + file.getOriginalFilename() + "!";
    
  	
  	
      SimpleMailMessage msg = new SimpleMailMessage();
   msg.setTo(userController.user(id_user).getEmail());

      msg.setSubject("bonjour votre image est bien telechargé  ");
      msg.setText("bonjour votre image est bien telechargé");

      javaMailSender.send(msg);
        
return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
    }
  }


 
  List<String> files = new ArrayList<String>();
  @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
  @GetMapping("/filesc")

  public List<String> getListFiles( ) {
  List<String> fileNames = files
  .stream().map(fileName -> MvcUriComponentsBuilder
          .fromMethodName(FilesController.class, "getFile", fileName).build().toString())
  .collect(Collectors.toList());
return files;
}
  
  @GetMapping("/files/{filename:.+}")
  public ResponseEntity<Resource> getFile(@PathVariable String filename) {
    Resource file = storageService.load(filename);
    return ResponseEntity.ok()
        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
  }

}
