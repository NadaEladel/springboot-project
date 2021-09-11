package tn.esprit.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entities.DimCalcule;
import tn.esprit.spring.entities.Plan;
import tn.esprit.spring.entities.ProfilCalcule;

import tn.esprit.spring.entities.Profilenlong;
import tn.esprit.spring.repository.DimcalculeRepository;
import tn.esprit.spring.repository.ProfilCalculeRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class ProfileCalculServiceImpl implements ProfileCalculService{


    @Autowired
    ProfilCalculeRepository pr;
    @Autowired
    ProfileCalculService ps;
    @Autowired
    DimcalculeRepository dimCalculeRepo;

   /* public void ajoutProfil(Profilenlong profilenlong,Long idDim) {
        // TODO Auto-generated method stub
        DimCalcule dim = dimCalculeRepo.findById(idDim).get();

        profilenlong.setCanals(dim.getCanals());
        profilenlong.setNamont(dim.getNamont());
        profilenlong.setNaval(dim.getNaval());
        //profilenlong.setDim(dim);
        pr.save(profilenlong);
    }*/
    @Override
    public ProfilCalcule ajoutProfil(ProfilCalcule profilenlong, Long idDim) {
        DimCalcule dim = dimCalculeRepo.findById(idDim).get();
        if (dim != null) {
            profilenlong.setCanals(dim.getCanals());
            profilenlong.setNamont(dim.getNamont());
            profilenlong.setNaval(dim.getNaval());
            profilenlong.setDim(dim);
            return pr.save(profilenlong);
        }else {
            return null;
        }
    }

    //update ne9sa
    @Override
    public ProfilCalcule update(ProfilCalcule dim, Long id)
    {
    	ProfilCalcule planId = pr.findById(id).get();
        planId.setHauteurchute(dim.getHauteurchute());
        planId.setNombredechute(dim.getNombredechute());
        planId.setChute(dim.getChute());
        planId.setLongueur(dim.getLongueur());
        planId.setCotetnamont(dim.getCotetnamont());
        planId.setCotetnaval(dim.getCotetnaval());
        
        planId.setCoeficient(dim.getCoeficient());
        
        planId.setAcceleration(dim.getAcceleration());
        //resultat
        
        planId.setHauteurdechutetotal(0);
        
        planId.setCoteprojetamont(0);

        planId.setCoteprojetaval(0);
        
        planId.setProfondeur(0);
        
        planId.setPertedechargelineaire(0);
        planId.setPertedechargesinguliaire(0);
        
        planId.setCoteplushauteeauamont(0);
        planId.setCoteplushauteeauaval(0);
        
       
       
        
       // planId.setReseaux(plan.getReseaux());
        return pr.save(planId);
    }
    
    @Override
    public ProfilCalcule CPamount(Long id) {

 /// get all profiles
        List<ProfilCalcule> profiles = new ArrayList<ProfilCalcule>();
        pr.findAll().forEach(p1 -> profiles.add(p1));

        ProfilCalcule profile= pr.findById(id ).get();


        ProfilCalcule x = profiles.get(0);
        if (x == profile) {
            float c = ( profile.getCotetnamont() - profile.getHauteurchute());
            profile.setCoteprojetamont(c);
        return pr.save(profile);
       // if(profile.getCoteprojetaval() == 0.0){
         //   float c = profile.getCotetnamont() -profile.getHauteurchute();
          //  profile.setCoteprojetamont(c);
           // return pr.save(profile);
        }else {

            int y = profiles.indexOf(profile);

            float c = profiles.get(y-1).getCoteprojetaval() - profiles.get(y).getHauteurchute();
            profile.setCoteprojetamont(c);
            return pr.save(profile);
        }
   
    }

    @Override
    public ProfilCalcule CPaval(Long id) {

        ProfilCalcule profile= pr.findById(id).get();
        float aval= (float) (profile.getCoteprojetamont()-(profile.getLongueur()*0.005));
        profile.setCoteprojetaval(aval);
        return pr.save(profile);
    }

    @Override
    public ProfilCalcule Profondeur(Long id) {
        ProfilCalcule profile=pr.findById(id).get();
        float pro = profile.getCotetnamont()-profile.getCoteprojetamont();
   profile.setProfondeur(pro);
        return pr.save(profile);
    }

    @Override
    public List<ProfilCalcule> getAllProfilCalcule() {


        return  (List<ProfilCalcule>)pr.findAll();
    }

    @Override
    public ProfilCalcule CalculeJ(Long id) {

        ProfilCalcule profile=pr.findById(id).get();

        float j = (float) (profile.getLongueur()*0.005);
        profile.setPertedechargelineaire(j);

        return pr.save(profile);
    }

    @Override
    public ProfilCalcule DeltaH(Long id ) {
        ProfilCalcule p= pr.findById(id).get();
       Long idDim = p.getDim().getId();
        System.out.println(p);

        //System.out.println(idDim);
        DimCalcule dim = dimCalculeRepo.findById(idDim).get();
        float dh = (p.getCoeficient()* dim.getVitesse() * dim.getVitesse())/(2* p.getAcceleration());
       // float dh = p.getCoeficient()/(2* p.getAcceleration());
        p.setPertedechargesinguliaire(dh);
        return pr.save(p);
    }
    
    /// à modifier 

    @Override
    public ProfilCalcule hauteurchtot(Long id) {
        /// get all profiles
        List<ProfilCalcule> profiles =(List<ProfilCalcule>) pr.findAll();
        		//new ArrayList<ProfilCalcule>();
        
        
     //   pr.findAll().forEach(p1 -> profiles.add(p1));
        System.out.println("profiles");
        System.out.println(profiles);
        
        ProfilCalcule profile= pr.findById(id).get();
        System.out.println("profile");
        System.out.println(profile);
        int y = profiles.indexOf(profile);
        System.out.println("SIZE");
        System.out.println(profiles.size());
        
        if (profiles.size()>y+1) {
        ProfilCalcule profile1 = profiles.get(y+1);
        System.out.println("profile1");
        System.out.println(profile1);
         float hc= profile.getCoteprojetamont()- profile1.getCoteprojetamont();
         profile.setHauteurdechutetotal(hc);
         
         //else  KEN KIF YEBDOU LES DEUX MAWJOUDIN 
        // TE5EDH 0

        return pr.save(profile);
    }else {
    	profile.setHauteurdechutetotal(0);
    	return pr.save(profile);
    }
    }
    //correction methode hauteurChtot
    
    

    @Override
    public ProfilCalcule coteeauamont(Long id) {

        ProfilCalcule profile= pr.findById(id).get();
        Long idDim = profile.getDim().getId();
        DimCalcule dim = dimCalculeRepo.findById(idDim).get();

        float x = profile.getCoteprojetamont()+dim.getYn();

        profile.setCoteplushauteeauamont(x);
        return pr.save(profile);
    }

    @Override
    public ProfilCalcule coteeauaval(Long id) {

        ProfilCalcule t= pr.findById(id).get();
        Long idDim = t.getDim().getId();
        DimCalcule dim = dimCalculeRepo.findById(idDim).get();

        float x = t.getCoteprojetaval()+dim.getYn();

        t.setCoteplushauteeauaval(x);
        return pr.save(t);
    }

	@Override
	public List<ProfilCalcule> getAllByPlan(DimCalcule idProfile) {
		// TODO Auto-generated method stub
		return pr.findByDim(idProfile);
	}

	//getbyid
	public ProfilCalcule getProfileById(Long id)
    {
        return pr.findById(id).get();
    }

	@Override
	public List<ProfilCalcule> getAll() {
		// TODO Auto-generated method stub
		return (List<ProfilCalcule>) pr.findAll();
	}

}
