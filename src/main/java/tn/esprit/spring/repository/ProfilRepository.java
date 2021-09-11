package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Profilenlong;

@Repository
public interface ProfilRepository extends CrudRepository <Profilenlong,Long> {
	@Query("SELECT count(u) FROM Profilenlong u where u.canals=:ok ")
   	public int findProfileByCategorie(String ok);
	
		
	@Query("SELECT count (u) FROM Profilenlong u ")
	    public int countprofil();
	    
    
}
