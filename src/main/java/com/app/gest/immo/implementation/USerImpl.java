package com.app.gest.immo.implementation;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ExecutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.app.gest.immo.config.securities.Groupes;
import com.app.gest.immo.config.securities.Roles;
import com.app.gest.immo.config.securities.Status;
import com.app.gest.immo.config.securities.Utilisateur;
import com.app.gest.immo.controller.UserDetailsImpl;
import com.app.gest.immo.entities.ChangePwd;
import com.app.gest.immo.entities.UtilsAPP;
import com.app.gest.immo.enumeration.ESexe;
import com.app.gest.immo.init.RolesName;
import com.app.gest.immo.repository.IUtilisateurRepository;
import com.app.gest.immo.service.IGoupes;
import com.app.gest.immo.service.IUtilisateur;

import jakarta.transaction.Transactional;

@Service
public class USerImpl implements IUtilisateur {

    private final IUtilisateurRepository repository;
    private final IGoupes groupesService;
    private final PasswordEncoder passwordEncoder;
    private final ExecutorService executorService;


    public USerImpl(IUtilisateurRepository repository,IGoupes groupesService, @Qualifier("passwordEncoder") PasswordEncoder passwordEncoder, ExecutorService executorService) {
        this.repository = repository;
        this.groupesService = groupesService;
        this.passwordEncoder = passwordEncoder;
		this.executorService = executorService;
    }

    @Override
    public Utilisateur findById(Long id) throws Exception {
        Utilisateur utilisateur = repository.findById(id).orElse(null);
        if(utilisateur == null)
            throw new Exception("User with id = "+id+" don't exist");
        return (utilisateur);
    }

    @Override
    @Transactional
    public Utilisateur save(Utilisateur utilisateur, Long idGroupe) throws Exception {
        String pwd = null;
        Groupes groupe = groupesService.finById(idGroupe);
        boolean codeIsCreate = false;
        String code = "";
       
        utilisateur.setGroupes(groupe);
        utilisateur.setPassWord(passwordEncoder.encode(pwd));
        utilisateur.setStatus(Status.ACTIF);
        try {
            saveIt(utilisateur);
            executorService.execute(()->{
                String message = "Felicitation pour votre Inscription. Login:";
                message = message+(utilisateur.getEmail()==null ? utilisateur.getLogin() : utilisateur.getEmail());
                message = message+" \n Password:"+pwd;
            });
            return (utilisateur);
        }catch (Exception ex){
            ex.printStackTrace();
            throw ex;
        }
    }

    private Date parseYYYYMMDDDate(String dateString)throws Exception {
        SimpleDateFormat INPUT_FORMAT = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH);
        SimpleDateFormat OUTPUT_FORMAT = new SimpleDateFormat("yyyy/MM/dd");
        SimpleDateFormat OUTPUT_FORMAT1 = new SimpleDateFormat("MM/dd/yyyy");
        try {
            Date date = INPUT_FORMAT.parse(dateString);
            return OUTPUT_FORMAT.parse(OUTPUT_FORMAT.format(date));
        } catch (Exception e) {
            e.printStackTrace();
            return OUTPUT_FORMAT1.parse(OUTPUT_FORMAT1.format(INPUT_FORMAT.parse(dateString)));
        }
    }
  
    @Override
    @Transactional
    public Utilisateur saveAdmin(Utilisateur utilisateur, Long idGroupe) throws Exception {
        String pwd = UtilsAPP. genDefaultCode();
        Groupes groupe = groupesService.finById(idGroupe);
        
        boolean codeIsCreate = false;
        String code = "";
        while(!codeIsCreate){
            code = UtilsAPP.genCode("US",8);
            if(!repository.findByLogin(code).isPresent())
                codeIsCreate = true;
        }
        utilisateur.setId(null);
        utilisateur.setGroupes(groupe);
        utilisateur.setPassWord(passwordEncoder.encode(pwd));
        utilisateur.setStatus(Status.ACTIF);
        utilisateur.setFirstConnexion(true);
        try {
            saveIt(utilisateur);
            return (utilisateur);
        }catch (Exception ex){
            ex.printStackTrace();
            throw ex;
        }
    }

    private Utilisateur saveIt(Utilisateur utilisateur)throws Exception{
        try {
            checkIfUserExist(utilisateur);
            return repository.save(utilisateur);
        }catch (Exception ex){
            throw ex;
        }
    }

    private Utilisateur updateIt(Utilisateur utilisateur)throws Exception{
        try {
            return repository.save(utilisateur);
        }catch (Exception ex){
            throw ex;
        }
    }
    private void checkIfUserExist(Utilisateur utilisateur) throws Exception{
        if(repository.findByEmail(utilisateur.getEmail()).isPresent())
            throw new Exception("Email deja utilise");
        if(repository.findByNumero(utilisateur.getNumero())!=null)
            throw new Exception("Numero de telephone deja utilise");
    }

    @Override
    @Transactional
    public Utilisateur register(Utilisateur utilisateur) throws Exception {
        boolean sendSMS = true;
        Groupes groupe = groupesService.findByNom(RolesName.USER.toString()).get(0);
        boolean codeIsCreate = false;
        String code = "";
        while(!codeIsCreate){
            code =UtilsAPP. genCode("CL",8);
            if(!repository.findByCode(code).isPresent())
                codeIsCreate = true;
        }
        utilisateur.setId(null);
        utilisateur.setLogin(code);
        utilisateur.setGroupes(groupe);//
        utilisateur.setStatus(Status.ACTIF);
        utilisateur.setPassWord(passwordEncoder.encode(utilisateur.getPassWord()));
        utilisateur.setStatus(Status.INNATIF);
        utilisateur.setFirstConnexion(false);
        try {
            utilisateur = saveIt(utilisateur);
            executorService.execute(()->{
                String message = "Felicitation pour votre Inscription. Pour vous connecter, utiliser le login ";
                    message = message+(utilisateur.getEmail()==null ? utilisateur.getLogin() : utilisateur.getEmail().trim());
                    message = message+" via le lien client.youthfp.cm";
                });
                return (utilisateur);
        }catch (Exception ex){
            throw ex;
        }
    }

    @Override
    public Page<Utilisateur> list(int page) throws Exception {
        Page<Utilisateur> utilisateurs = repository.findAll(PageRequest.of(page, 15));
        return  new PageImpl<>(
                utilisateurs.stream().map(this::findWithFile).toList(),
                PageRequest.of(page, 15),
                utilisateurs.getContent().size());
    }

    @Override
    public PageDTO<Utilisateur> list(Long groupId, int page) throws Exception {
        if(groupId == null | groupId == 0)
            groupId = 1L;
        Pageable pageable = PageRequest.of(page, 5, Sort.by("id").descending());
        Page<Utilisateur> utilisateurPage = repository.findByGroupe(new Groupes(groupId), pageable);
        return new PageDTO<>(
                new PageImpl<>(
                        utilisateurPage.stream().map(this::findWithFile).toList(),
                        pageable,
                        utilisateurPage.getTotalElements()
                )
        );
    }

    @Override
    public PageDTO<Utilisateur> search(String phone, int page) throws Exception {
        Pageable pageable = PageRequest.of(page, 5, Sort.by("id").descending());
        Page<Utilisateur> utilisateurPage = repository.findUsersByPhoneNumberStartingWith(phone, pageable);
        return new PageDTO<>(
                new PageImpl<>(
                        utilisateurPage.stream().map(this::findWithFile).toList(),
                        pageable,
                        utilisateurPage.getTotalElements()
                )
        );
    }

    @Override
    public List<Utilisateur> list() throws Exception {
        return repository.findAll().stream().map(this::findWithFile).toList();
    }

    @Override
    public List<Utilisateur> list(String role) throws Exception {
        groupesService.getByRole(role);
        return this.list();
    }

    @Override
    @Transactional
    public Utilisateur update(Utilisateur utilisateur1, Long id) throws Exception {
        Utilisateur utilisateur = repository.findById(id).orElse(null);
        if(utilisateur == null)
            throw new Exception("User with id "+id+" don't exist");
        if(utilisateur.getId()!=utilisateur.getId())
            throw new Exception("Information non concordante");
        repository.save(utilisateur);
        return (utilisateur);
    }


    private Utilisateur getUser() throws Exception {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Utilisateur utilisateur = this.findByName(username);
        return (utilisateur);
    }

    @Override
    public void disableUtilisateur(Long id) throws Exception {
        Utilisateur utilisateur = repository.findById(id).orElse(null);
        if(utilisateur == null)
            throw new Exception("User with id "+id+" don't exist");
        if(utilisateur.getStatus()== Status.ACTIF)
            utilisateur.setStatus(Status.INNATIF);
        else
            utilisateur.setStatus(Status.ACTIF);
        repository.save(utilisateur);

    }

    @Override
    public Utilisateur findByName(String nom) throws Exception {
        Utilisateur utilisateur = repository.findByEmail(nom).orElse(null);
        if(utilisateur == null)
            throw new Exception("User with id = "+nom+" don't exist");
        return (utilisateur);
    }

    @Override
    public Utilisateur findByLogin(String login) throws Exception {
        Utilisateur utilisateur = repository.findByEmail(login).orElse(repository.findByLogin(login.trim()).orElse(null));
        if(utilisateur == null)
            throw new Exception("User with login = "+login+" not found");
        return this.findWithFile(utilisateur);
    }

    @Override
    public Utilisateur login(String login) throws Exception {
    	Optional<Utilisateur> user = repository.findByEmail(login);
        if (user.isEmpty()) {
            user = repository.findByLogin(login);
            if(user.isEmpty())
                new UsernameNotFoundException("User with username " + login + " don't exist");
        }
        return this.findWithFile(user.get());
    }

  

    @Override
    @Transactional
    public void changePassword(ChangePwd changePwd) throws Exception {
        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Utilisateur utilisateur = repository.findByEmail(userDetails.getEmail()).orElse(null);
        if(utilisateur == null)
            throw new Exception("User not found");
        if(changePwd.getConfirmPwd() == changePwd.getNewPwd())
            throw new Exception("Password not valid");
        if(changePwd.getConfirmPwd().length() < 8)
            throw new Exception("Password not valid");
        utilisateur.setPwd(passwordEncoder.encode(changePwd.getConfirmPwd().trim()));
        utilisateur.setIsFirstConnexion(false);
        repository.save(utilisateur);
    }

    public void activeOrDesactive(Long id) throws Exception {
        Utilisateur utilisateur = repository.findById(id).orElse(null);
        if(utilisateur == null)
            throw new Exception("User not found");
        if(utilisateur.getStatus().equals(Status.INNATIF))
            utilisateur.setStatus(Status.ACTIF);
        else
            utilisateur.setStatus(Status.INNATIF);
        repository.save(utilisateur);

    }

    public void resetPassword(Long id) throws Exception {
        Utilisateur utilisateur = repository.findById(id).orElse(null);
        final String pwd =UtilsAPP.genCode();
        try{
            if(utilisateur == null)
                throw new Exception("User not found");
            utilisateur.setPassWord(passwordEncoder.encode(pwd));
            utilisateur.isFirstConnexion(true);
            updateIt(utilisateur);
            executorService.execute(()->{
                String message = "Votre mot de passe a ete reinitialiser par l'administrateur. Votre nouveau mot de passe est:";
                message = message+pwd;
            });
        }catch (Exception ex){}
    }

 
    private String getMonthName(Long mounth){
        String[] monthList = {"init","Janvier", "Fevrier", "Mars", "Avril", "Mai",
                "Juin", "Juillet", "Aout", "Septembre", "Octobre",
                "Novembre", "Decembre"};
        if(mounth<1L | mounth>12L)
            return "init";
        return monthList[mounth.intValue()];
    }

	
}