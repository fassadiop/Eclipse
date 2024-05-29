package sn.gouv.dpm.embarcations.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import sn.gouv.dpm.embarcations.entity.Pirogue;
import sn.gouv.dpm.embarcations.repository.PirogueRepository;

@Service
public class PirogueDao
{
    @Autowired
    private PirogueRepository pirogueRepository;

    public List<Pirogue> listerLesPirogues()
    {
        return pirogueRepository.findAll();
    }

    @Transactional
    public Pirogue ajouterUnePirogue(Pirogue pirogue)
    {
        return pirogueRepository.save(pirogue);
    }

    public Pirogue rechercherPirogue(String immatriculation)
    {
        Pirogue pirogue = pirogueRepository.findByImmatriculation(immatriculation);
        return pirogue;
    }

    @Transactional
    public Pirogue modifierPirogue(Pirogue pirogue)
    {
        Pirogue pirogueExistante = rechercherPirogue(pirogue.getImmatriculation());
        pirogueExistante.setNom(pirogue.getNom());
        pirogueExistante.setEtat(pirogue.getEtat());
        pirogueExistante.setNbrePecheur(pirogue.getNbrePecheur());
        pirogueExistante.setLongueur(pirogue.getLongueur());
        pirogueExistante.setLargeur(pirogue.getLargeur());
        pirogueExistante.setCreux(pirogue.getCreux());
        pirogueExistante.setLieuConstruction(pirogue.getLieuConstruction());
        pirogueExistante.setAnneeConstruction(pirogue.getAnneeConstruction());

        return pirogueRepository.save(pirogueExistante);
    }

    public void supprimerPirogue(String immatriculation)
    {
        Pirogue pirogue = rechercherPirogue(immatriculation);
        if (pirogue != null)
        {
            pirogueRepository.delete(pirogue);
        }
    }

    public Long nombreDePirogue()
    {
        Long nbrePirogue = pirogueRepository.count();
        return nbrePirogue;
    }
}
