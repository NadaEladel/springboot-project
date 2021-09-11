package tn.esprit.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entities.DimCalcule;
import tn.esprit.spring.entities.Plan;
import tn.esprit.spring.repository.DimcalculeRepository;
import tn.esprit.spring.repository.PlanRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DimCalculeServiceImpl implements DimCalculeService {
    @Autowired
   DimcalculeRepository dimCalculeRepo;


    @Autowired
    DimCalculeService  dimCalculeService;

    @Override
    public DimCalcule save(DimCalcule dimCalcule) {
        return dimCalculeRepo.save(dimCalcule);
    }

    @Override
    public List<DimCalcule> getAllDimCalcule() {
        List<DimCalcule> plans = new ArrayList<DimCalcule>();
        dimCalculeRepo.findAll().forEach(plans1 -> plans.add(plans1));
        return plans;
    }

    @Override
    public DimCalcule debit(Long id) {
        DimCalcule dim = dimCalculeRepo.findById(id).get();
        float q= dimCalculeRepo.findById(id).get().getSurface() * dimCalculeRepo.findById(id).get().getDebitunitaire();

        dim.setQ(q);
       return dimCalculeRepo.save(dim);
    }

    @Override
    public DimCalcule afficherDimensionnement(Long id) {
        return dimCalculeService.afficherDimensionnement(id);
    }

    @Override
    public DimCalcule hauteur(Long id) {
        DimCalcule dim = dimCalculeRepo.findById(id).get();
        float yn = (float) ((0.001 * dimCalculeRepo.findById(id).get().getQ()/ dimCalculeRepo.findById(id).get().getCoefmanning() * Math.pow(dimCalculeRepo.findById(id).get().getPente(), 0.5))* ( Math.pow((dimCalculeRepo.findById(id).get().getB()+2*dimCalculeRepo.findById(id).get().getY0()*(Math.pow((1+Math.pow(dimCalculeRepo.findById(id).get().getTalus(), 2)), 0.5))), 0.4) / (dimCalculeRepo.findById(id).get().getB()+dimCalculeRepo.findById(id).get().getTalus()*dimCalculeRepo.findById(id).get().getY0()) ));
        dim.setYn(yn);
        //return ((0.001 * Q / K * Math.pow(i, 0.5))* ( Math.pow((b+2*y0*(Math.pow((1+Math.pow(m, 2)), 0.5))), 0.4) / (b+m*y0) ) )  ;
        return dimCalculeRepo.save(dim);
    }

    @Override
    public DimCalcule Smouille(Long id) {
        //return yn*(b+m+yn)
        DimCalcule dim = dimCalculeRepo.findById(id).get();

        float S =dimCalculeRepo.findById(id).get().getYn()*(dimCalculeRepo.findById(id).get().getB()+dimCalculeRepo.findById(id).get().getTalus()+dimCalculeRepo.findById(id).get().getYn());
       dim.setSection(S);
        return dimCalculeRepo.save(dim);
    }

    @Override
    public DimCalcule vitesse(Long id) {
        DimCalcule dim = dimCalculeRepo.findById(id).get();
        //return (0.001*Q/Smouille)
        float v = (float) (0.001*dimCalculeRepo.findById(id).get().getQ()/dimCalculeRepo.findById(id).get().getSection());
        dim.setVitesse(v);
        return dimCalculeRepo.save(dim);
    }

	@Override
	public List<DimCalcule> getAllByPlan(Plan idPlan) {
		
		
		// TODO Auto-generated method stub
		return dimCalculeRepo.findByPlan(idPlan);
	}
	
	

	public void delete(Long id)
    {
		dimCalculeRepo.deleteById(id);
    }

	@Override
	public Optional<DimCalcule> findById(Long id) {
		// TODO Auto-generated method stub
		return dimCalculeRepo.findById(id);
	}
	
	
	 public DimCalcule update(DimCalcule dim, Long id)
	    {
	        DimCalcule dimId = dimCalculeRepo.findById(id).get();
	        dimId.setCanals(dim.getCanals());
	        dimId.setNamont(dim.getNamont());
	        dimId.setNaval(dim.getNaval());
	        dimId.setDebitunitaire(dim.getDebitunitaire());
	        dimId.setLargeurdecanal(dim.getLargeurdecanal());
	        dimId.setCoefmanning(dim.getCoefmanning());
	        dimId.setPente(dim.getPente());
	        dimId.setTalus(dim.getTalus());
	        dimId.setY0(dim.getY0());
	        dimId.setRevanche(dim.getRevanche());
	        dimId.setSurface(dim.getB());
	        




	        return dimCalculeRepo.save(dimId);
	    }

}
