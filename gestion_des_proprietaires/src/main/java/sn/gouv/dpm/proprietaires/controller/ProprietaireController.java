package sn.gouv.dpm.proprietaires.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;
import sn.gouv.dpm.proprietaires.client.PirogueClient;
import sn.gouv.dpm.proprietaires.dao.ProprietaireDao;
import sn.gouv.dpm.proprietaires.entity.*;

import java.util.List;

@RestController
@RequestMapping("/proprietaireapi")
public class ProprietaireController
{
    @Autowired
    private ProprietaireDao proprietaireDao;

    @Autowired
    private PirogueClient pirogueClient;

    //Pour insérer un proprietaire
    //http://localhost:8081/proprietaireapi/proprietaires
    @PostMapping("/proprietaires")
    public ResponseEntity<Proprietaire> insererProprietaire(@RequestBody Proprietaire proprietaire)
    {
        Proprietaire newProprietaire = proprietaireDao.ajouterUnProprietaire(proprietaire);
        return new ResponseEntity<Proprietaire> (newProprietaire, HttpStatus.CREATED);
    }

    //Pour lister tous les proprietaires
    @GetMapping("/proprietaires")
    public ResponseEntity<List<Proprietaire>> afficherProprietaires()
    {
        List<Proprietaire> listeProprietaires = proprietaireDao.listerProprietaire();
        return new ResponseEntity <List<Proprietaire>> (listeProprietaires,HttpStatus.OK);
    }

    @PutMapping("/proprietaires/{cni}")
    public ResponseEntity<Proprietaire> updateProprietaire(@PathVariable("cni") Long cni, @RequestBody Proprietaire newProprietaire) throws Exception
    {
        Proprietaire proprietaireExistant = proprietaireDao.rechercherProprietaire(cni);
        if (proprietaireExistant == null)
        {
            throw new ResourceAccessException("Ce proprietaire est introuvable avec ce numéro de cni " + cni);
        }
        else
        {
            proprietaireExistant.setNom(newProprietaire.getNom());
            proprietaireExistant.setPrenom(newProprietaire.getPrenom());
            proprietaireExistant.setDateNaissance(newProprietaire.getDateNaissance());
            proprietaireExistant.setNationalite(newProprietaire.getNationalite());
            proprietaireExistant.setAdresse(newProprietaire.getAdresse());
            proprietaireExistant.setTelephone1(newProprietaire.getTelephone1());
            proprietaireExistant.setTelephone2(newProprietaire.getTelephone2());
            proprietaireExistant.setVille(newProprietaire.getVille());
            proprietaireExistant.setPays(newProprietaire.getPays());

            proprietaireDao.modifierProprietaire(proprietaireExistant);
            return new ResponseEntity<Proprietaire>(proprietaireExistant,HttpStatus.OK);
        }
    }

    @GetMapping("/proprietaires/{cni}")
    public ResponseEntity<Proprietaire> obtenirUnProprietaire(@PathVariable("cni") Long cni) throws Exception
    {
        Proprietaire proprietaire = proprietaireDao.rechercherProprietaire(cni);
        if (proprietaire == null)
        {
            throw new ResourceAccessException("Ce proprietaire est introuvable avec ce numéro de cni " + cni);
        }
        else
        {
            return new ResponseEntity<Proprietaire>(proprietaire,HttpStatus.OK);
        }
    }

    @DeleteMapping("/proprietaires/{cni}")
    public ResponseEntity<String> eliminerUnProprietaire(@PathVariable("cni") Long cni) throws Exception
    {
        Proprietaire proprietaire = proprietaireDao.rechercherProprietaire(cni);
        if (proprietaire == null)
        {
            throw new ResourceAccessException("Ce proprietaire est introuvable avec ce numéro de cni " + cni);
        }
        else
        {
            proprietaireDao.supprimerProprietaire(cni);
            return new ResponseEntity<String>("Ce proprietaire a été supprimé avec succès !",HttpStatus.OK);
        }
    }

    @GetMapping("/pirogues")
    public List<Pirogue> ListerToutesLesPirogues()
    {
        return pirogueClient.afficherPirogues();
    }

}
