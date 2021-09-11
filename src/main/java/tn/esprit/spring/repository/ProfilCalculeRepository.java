package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

import tn.esprit.spring.entities.DimCalcule;
import tn.esprit.spring.entities.Plan;
import tn.esprit.spring.entities.ProfilCalcule;
import org.springframework.data.jpa.repository.Query;

public interface ProfilCalculeRepository extends CrudRepository<ProfilCalcule,Long> {
	
	List<ProfilCalcule> findByDim(DimCalcule plan);
	

	@Query("SELECT count(u) FROM ProfilCalcule u where u.canals=:ok ")
   	public int findProfileByCategorie(String ok);
	  
   
	//////////////////stat :statistique 2 /////////////////////////////
	
	 //cote amont aval 
	//cote projet amont + projetaval
	//yn
	
	@Query("SELECT count (u) FROM ProfilCalcule u ")
	    public int countprofil();
	
	/////// primaire////
	
	@Query("SELECT   u.cotetnamont FROM ProfilCalcule u  WHERE u.canals ='Primaire' ")
    public List<Float> affichecoteamont();
	

	@Query("SELECT  u.cotetnaval  FROM ProfilCalcule u  WHERE u.canals ='Primaire'")
    public List<Float> affichecoteaval();
	
	
	@Query("SELECT  u.coteprojetamont  FROM ProfilCalcule u  WHERE u.canals ='Primaire'")
    public List<Float> affichecoteprojetamont();
	
	@Query("SELECT  u.coteprojetaval  FROM ProfilCalcule u  WHERE u.canals ='Primaire'")
    public List<Float> affichecoteprojetaval();
	
	
/////// Secondaire////
	
	@Query("SELECT   u.cotetnamont FROM ProfilCalcule u  WHERE u.canals ='Secondaire' ")
  public List<Float> affichecoteamontSecondaire();
	

	@Query("SELECT  u.cotetnaval  FROM ProfilCalcule u  WHERE u.canals ='Secondaire'")
  public List<Float> affichecoteavalSecondaire();
	
	
	@Query("SELECT  u.coteprojetamont  FROM ProfilCalcule u  WHERE u.canals ='Secondaire'")
  public List<Float> affichecoteprojetamontSecondaire();
	
	@Query("SELECT  u.coteprojetaval  FROM ProfilCalcule u  WHERE u.canals ='Secondaire'")
  public List<Float> affichecoteprojetavalSecondaire();
	
	//Tertiaire///
	
	@Query("SELECT   u.cotetnamont FROM ProfilCalcule u  WHERE u.canals ='Secondaire' ")
	  public List<Float> affichecoteamontTertiare();
		

		@Query("SELECT  u.cotetnaval  FROM ProfilCalcule u  WHERE u.canals ='Secondaire'")
	  public List<Float> affichecoteavalTertiare();
		
		
		@Query("SELECT  u.coteprojetamont  FROM ProfilCalcule u  WHERE u.canals ='Secondaire'")
	  public List<Float> affichecoteprojetamontTertiare();
		
		@Query("SELECT  u.coteprojetaval  FROM ProfilCalcule u  WHERE u.canals ='Secondaire'")
	  public List<Float> affichecoteprojetavalTertiare();
		
		
		
}

	
	

