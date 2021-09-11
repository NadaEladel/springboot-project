package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.spring.entities.DimCalcule;
import tn.esprit.spring.entities.Plan;
import org.springframework.data.jpa.repository.Query;

public interface DimcalculeRepository extends CrudRepository<DimCalcule,Long> {

	List<DimCalcule> findByPlan(Plan plan);
	
	@Query("SELECT u.yn FROM DimCalcule u WHERE u.canals = 'Tertiaire'")
	
    public List<Float> afficheyn();
	
	
@Query("SELECT u.yn FROM DimCalcule u WHERE u.canals = 'Secondaire'")
	
    public List<Float> afficheynSecdaire();



@Query("SELECT u.yn FROM DimCalcule u WHERE u.canals = 'Primaire'")

public List<Float> afficheynPrimaire();


//primaire


@Query("SELECT u.namont FROM DimCalcule u WHERE u.canals = 'Primaire' ")

public List<String> namontPrimaire();
//secondaire


@Query("SELECT u.namont FROM DimCalcule u WHERE u.canals = 'Secondaire' ")

public List<String> namontSeconadire();

//tertiare

@Query("SELECT u.namont FROM DimCalcule u WHERE u.canals = 'Secondaire' ")

public List<String> namontTertiaire();
	
}
