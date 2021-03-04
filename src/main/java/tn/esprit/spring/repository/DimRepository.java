package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Dimensionnement;

@Repository
public interface DimRepository extends CrudRepository <Dimensionnement,Long>{

}
