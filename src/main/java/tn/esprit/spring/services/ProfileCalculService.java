package tn.esprit.spring.services;

import tn.esprit.spring.entities.DimCalcule;
import tn.esprit.spring.entities.Plan;
import tn.esprit.spring.entities.ProfilCalcule;
import tn.esprit.spring.entities.Profilenlong;

import java.util.List;
import java.util.Optional;

public interface  ProfileCalculService {
    public ProfilCalcule ajoutProfil (ProfilCalcule profilenlong, Long idDim) ;
   // ProfilCalcule debit(Long id);
   ProfilCalcule CPamount(Long id);
    ProfilCalcule CPaval (Long id);
    ProfilCalcule Profondeur (Long id);

    public List<ProfilCalcule> getAllProfilCalcule();
    public List<ProfilCalcule> getAll();

    ProfilCalcule CalculeJ (Long id);

    ProfilCalcule DeltaH ( Long id);

    ProfilCalcule hauteurchtot(Long id);

    ProfilCalcule coteeauamont(Long id);
    ProfilCalcule coteeauaval(Long id);
    
    public List<ProfilCalcule> getAllByPlan(DimCalcule idProfile) ;
    
  
    public ProfilCalcule update(ProfilCalcule dim, Long id);

}
