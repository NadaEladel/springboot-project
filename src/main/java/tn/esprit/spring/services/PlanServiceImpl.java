package tn.esprit.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entities.Plan;
import tn.esprit.spring.repository.PlanRepository;

import java.util.ArrayList;
import java.util.List;
@Service
public class PlanServiceImpl implements PlanService{
    @Autowired
    PlanRepository planRepo;

    @Autowired
   PlanService  planService;

    @Override
    public Plan save(Plan plan) {

        return planRepo.save(plan);
    }

    @Override
    public List<Plan> getAllPlan() {
       // return  planRepo.findAll();
        List<Plan> plans = new ArrayList<Plan>();
        planRepo.findAll().forEach(plans1 -> plans.add(plans1));
        return plans;
    }


    //getting a specific record by using the method findById() of CrudRepository
    public Plan getPlanById(Long id)
    {
        return planRepo.findById(id).get();
    }
    //saving a specific record by using the method save() of CrudRepository
    public void saveOrUpdate(Plan books)
    {
        planRepo.save(books);
    }
    //deleting a specific record by using the method deleteById() of CrudRepository
    public void delete(Long id)
    {
        planRepo.deleteById(id);
    }

    public Plan update(Plan plan, Long id)
    {
        Plan planId = planRepo.findById(id).get();
        planId.setAdresse(plan.getAdresse());
        planId.setProprietaire(plan.getProprietaire());
        planId.setReseaux(plan.getReseaux());
        return planRepo.save(planId);
    }


}
