package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.ResultatDim;

@Repository
public interface ResultatdimRepository  extends CrudRepository <ResultatDim,Long> {

}
