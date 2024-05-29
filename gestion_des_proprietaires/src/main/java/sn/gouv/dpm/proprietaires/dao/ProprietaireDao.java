package sn.gouv.dpm.proprietaires.dao;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.gouv.dpm.proprietaires.entity.Proprietaire;
import sn.gouv.dpm.proprietaires.repository.ProprietaireRepository;

import java.util.List;

@Service
public class ProprietaireDao
{
    @Autowired
    private ProprietaireRepository proprietaireRepository;

    public List<Proprietaire> listerProprietaire()
    {
        return proprietaireRepository.findAll();
    }

    @Transactional
    public Proprietaire ajouterUnProprietaire(Proprietaire proprietaire)
    {
        return proprietaireRepository.save(proprietaire);
    }

    @Transactional
    public Proprietaire modifierProprietaire(Proprietaire proprietaire)
    {
        Proprietaire proprietaireExistant = rechercherProprietaire(proprietaire.getCni());
        proprietaireExistant.setNom(proprietaire.getNom());
        proprietaireExistant.setPrenom(proprietaire.getPrenom());
        proprietaireExistant.setDateNaissance(proprietaire.getDateNaissance());
        proprietaireExistant.setNationalite(proprietaire.getNationalite());
        proprietaireExistant.setAdresse(proprietaire.getAdresse());
        proprietaireExistant.setTelephone1(proprietaire.getTelephone1());
        proprietaireExistant.setTelephone2(proprietaire.getTelephone2());
        proprietaireExistant.setVille(proprietaire.getVille());
        proprietaireExistant.setPays(proprietaire.getPays());

        return proprietaireRepository.save(proprietaireExistant);
    }

    public Proprietaire rechercherProprietaire(Long cni)
    {
        return proprietaireRepository.findByCni(cni);
    }

    public Proprietaire chercherProprietaire(Integer proprietaireId)
    {
        return proprietaireRepository.findById(proprietaireId).orElse(null);
    }

    public void supprimerProprietaire(Long cni)
    {
        Proprietaire proprietaire = rechercherProprietaire(cni);
        if (proprietaire != null)
        {
            proprietaireRepository.delete(proprietaire);
        }
    }

    public Long compterProprietaires()
    {
        Long nbreProprietaire = proprietaireRepository.count();
        return nbreProprietaire;
    }
}
