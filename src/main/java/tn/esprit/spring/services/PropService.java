package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Proposition;
import tn.esprit.spring.repository.propositionRepository;


@Service
public class PropService implements IPropService{
@Autowired
propositionRepository pr;

@Override
public List<Proposition> ListerProposition() {
	// TODO Auto-generated method stub
	return (List<Proposition>)pr.findAll();}

@Override
public Proposition afficherProposition(Long idProp) {
	// TODO Auto-generated method stub
	return pr.findById(idProp).orElse(null) ;
}



}
