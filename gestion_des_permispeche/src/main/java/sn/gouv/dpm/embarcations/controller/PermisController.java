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

import sn.gouv.dpm.embarcations.dao.PermisDao;
import sn.gouv.dpm.embarcations.entity.Permis;

@RestController
@RequestMapping("/permisapi")
public class PermisController
{
    @Autowired
    private PermisDao permisDao;

    //Pour insérer un permis
    //http://localhost:8080/permisapi/permis
    @PostMapping("/permis")
    public ResponseEntity<Permis> insererPermis(@RequestBody Permis permis)
    {
        Permis newPermis = permisDao.ajouterUnPermis(permis);
        return new ResponseEntity<Permis> (newPermis, HttpStatus.CREATED);
    }

    //Pour lister tous les permis
    @GetMapping("/permis")
    public ResponseEntity<List<Permis>> afficherPermis()
    {
        List<Permis> listePermis = permisDao.listerLesPermis();
        return new ResponseEntity <List<Permis>> (listePermis,HttpStatus.OK);
    }

    @PutMapping("/pirogues/{numeroPermis}")
    public ResponseEntity<Permis> updatePermis(@PathVariable("numeroPermis") String numeroPermis, @RequestBody Permis newPermis) throws Exception
    {
        Permis permisExistant = permisDao.rechercherPermis(numeroPermis);
        if (permisExistant == null)
        {
            throw new ResourceAccessException("Ce permis est introuvable avec ce numéro " + numeroPermis);
        }
        else
        {
            permisExistant.setNumeroPerception(newPermis.getNumeroPerception());
            permisExistant.setTypePermis(newPermis.getTypePermis());
            permisExistant.setNumeroPermis(newPermis.getNumeroPermis());
            permisExistant.setRegion(newPermis.getRegion());
            permisExistant.setDateQuitance(newPermis.getDateQuitance());
            permisExistant.setDateDebutValidite(newPermis.getDateDebutValidite());
            permisExistant.setDateFinValidite(newPermis.getDateFinValidite());

            permisDao.modifierPermis(permisExistant);
            return new ResponseEntity<Permis>(permisExistant,HttpStatus.OK);
        }
    }

    @GetMapping("/permis/{numeroPerception}")
    public ResponseEntity<Permis> TrouverUnPermis(@PathVariable("numeroPerception") Integer numeroPerception) throws Exception
    {
        Permis permis = permisDao.rechercherUnPermis(numeroPerception);
        if (permis == null)
        {
            throw new ResourceAccessException("Ce permis est introuvable avec ce numero de perception " + numeroPerception);
        }
        else
        {
            return new ResponseEntity<Permis>(permis,HttpStatus.OK);
        }
    }

    @DeleteMapping("/permis/{numeroPerception}")
    public ResponseEntity<String> eliminerUnePermis(@PathVariable("numeroPerception") Integer numeroPerception) throws Exception
    {
        Permis permis = permisDao.rechercherUnPermis(numeroPerception);
        if (permis == null)
        {
            throw new ResourceAccessException("Ce Permis est introuvable avec ce numero de perception " + numeroPerception);
        }
        else
        {
            permisDao.supprimerUnPermis(numeroPerception);
            return new ResponseEntity<String>("Ce permis a été supprimé avec succès !",HttpStatus.OK);
        }
    }

}
