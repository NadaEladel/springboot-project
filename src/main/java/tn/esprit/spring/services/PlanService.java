package tn.esprit.spring.services;

import tn.esprit.spring.entities.Plan;
import tn.esprit.spring.entities.User;

import java.util.List;

public interface  PlanService  {
    public Plan save(Plan plan);
    List<Plan> getAllPlan();
}
