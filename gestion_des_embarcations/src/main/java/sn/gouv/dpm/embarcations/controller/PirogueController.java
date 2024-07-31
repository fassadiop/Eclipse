package sn.gouv.dpm.embarcations.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.ResourceAccessException;

import sn.gouv.dpm.embarcations.client.PermisClient;
import sn.gouv.dpm.embarcations.dao.PirogueDao;
import sn.gouv.dpm.embarcations.entity.Permis;
import sn.gouv.dpm.embarcations.entity.Pirogue;

@RestController
@RequestMapping("/pirogueapi")
public class PirogueController
{
    @Autowired
    private PirogueDao pirogueDao;

    @Autowired
    private PermisClient permisClient;

    //Pour insérer une pirogue
    //http://localhost:8080/pirogueapi/pirogues
    @PostMapping("/pirogues")
    public ResponseEntity<Pirogue> insererPirogue(@RequestBody Pirogue pirogue)
    {
        Pirogue newPirogue = pirogueDao.ajouterUnePirogue(pirogue);
        return new ResponseEntity<Pirogue> (newPirogue, HttpStatus.CREATED);
    }

    //Pour lister toutes les pirogues
    @GetMapping("/pirogues")
    public ResponseEntity<List<Pirogue>> afficherPirogues()
    {
        List<Pirogue> listePirogues = pirogueDao.listerLesPirogues();
        return new ResponseEntity <List<Pirogue>> (listePirogues,HttpStatus.OK);
    }
    
    //Modifier une pirogue
    @PutMapping("/pirogues/{immatriculation}")
    public ResponseEntity<Pirogue> updatePirogue(@PathVariable("immatriculation") String immatriculation, @RequestBody Pirogue newPirogue) throws Exception
    {
        Pirogue pirogueExistante = pirogueDao.rechercherPirogue(immatriculation);
        if (pirogueExistante == null)
        {
            throw new ResourceAccessException("Cette pirogue est introuvable avec cette mail " + immatriculation);
        }
        else
        {
            pirogueExistante.setNom(newPirogue.getNom());
            pirogueExistante.setEtat(newPirogue.getEtat());
            pirogueExistante.setNbrePecheur(newPirogue.getNbrePecheur());
            pirogueExistante.setLongueur(newPirogue.getLongueur());
            pirogueExistante.setLargeur(newPirogue.getLargeur());
            pirogueExistante.setCreux(newPirogue.getCreux());
            pirogueExistante.setLieuConstruction(newPirogue.getLieuConstruction());
            pirogueExistante.setAnneeConstruction(newPirogue.getAnneeConstruction());

            pirogueDao.modifierPirogue(pirogueExistante);
            return new ResponseEntity<Pirogue>(pirogueExistante,HttpStatus.OK);
        }
    }

    //Trouver une pirogue
    @GetMapping("/pirogues/{immatriculation}")
    public ResponseEntity<Pirogue> obtenirUnePirogue(@PathVariable("immatriculation") String immatriculation) throws Exception
    {
        Pirogue pirogue = pirogueDao.rechercherPirogue(immatriculation);
        if (pirogue == null)
        {
            throw new ResourceAccessException("Cette pirogue est introuvable avec cette immatriculation " + immatriculation);
        }
        else
        {
            return new ResponseEntity<Pirogue>(pirogue,HttpStatus.OK);
        }
    }
    //Supprimer une pirogue
    @DeleteMapping("/pirogues/{immatriculation}")
    public ResponseEntity<String> eliminerUnePirogue(@PathVariable("immatriculation") String immatriculation) throws Exception
    {
        Pirogue pirogue = pirogueDao.rechercherPirogue(immatriculation);
        if (pirogue == null)
        {
            throw new ResourceAccessException("Cette Pirogue est introuvable avec cette immatriculation " + immatriculation);
        }
        else
        {
            pirogueDao.supprimerPirogue(immatriculation);
            return new ResponseEntity<String>("Cette pirogue a été supprimée avec succès !",HttpStatus.OK);
        }
    }

    @GetMapping("/permis")
    public List<Permis> ListerTousLesPermis()
    {
        return permisClient.afficherPermis();
    }
}
