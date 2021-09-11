package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.entities.Plan;

import java.util.List;

@Repository
public interface PlanRepository extends CrudRepository<Plan,Long> {
	
	// @Query("SELECT s FROM Plan s  where s.user.username LIKE %:username%") 
		  //public Plan  findbyPlanuser(String username);
		
		@Query("SELECT s FROM Plan s  where s.user.username LIKE %:username%") 
		   public List<Plan> trouveFicheByPlan(String username);
}

