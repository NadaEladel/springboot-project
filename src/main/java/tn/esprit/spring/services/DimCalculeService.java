package tn.esprit.spring.services;

import tn.esprit.spring.entities.DimCalcule;
import tn.esprit.spring.entities.Dimensionnement;
import tn.esprit.spring.entities.Plan;

import java.util.List;
import java.util.Optional;

public interface DimCalculeService {

    public DimCalcule save (DimCalcule dimCalcule);

    List<DimCalcule> getAllDimCalcule();
    List<DimCalcule> getAllByPlan(Plan idPlan);
    
    
    DimCalcule debit(Long id);
     DimCalcule afficherDimensionnement(Long id);
    DimCalcule hauteur(Long id);

    DimCalcule Smouille(Long id);

    DimCalcule vitesse(Long id);
    
    Optional<DimCalcule>  findById(Long id);
}
