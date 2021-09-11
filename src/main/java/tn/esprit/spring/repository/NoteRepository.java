package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Note;

@Repository
public interface NoteRepository extends CrudRepository <Note,Long> {

}
