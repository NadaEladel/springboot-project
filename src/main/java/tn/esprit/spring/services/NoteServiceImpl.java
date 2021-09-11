package tn.esprit.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import tn.esprit.spring.entities.Note;
import tn.esprit.spring.repository.NoteRepository;
@Service
public class NoteServiceImpl implements NoteService{
@Autowired
NoteRepository noteRep;
	@Override
	public Note update(Long id) {
		// TODO Auto-generated method stub
		
		Note noteId =noteRep.findById(id).get();
		
		noteId.setStatut("Traitée");
		return noteRep.save(noteId);
	}
	
	

}
