package sn.gouv.dpm.embarcations.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import sn.gouv.dpm.embarcations.entity.Permis;
import sn.gouv.dpm.embarcations.repository.PermisRepository;

@Service
public class PermisDao
{
    @Autowired
    private PermisRepository permisRepository;

    public List<Permis> listerLesPermis()
    {
        return permisRepository.findAll();
    }

    @Transactional
    public Permis ajouterUnPermis(Permis permis)
    {
        return permisRepository.save(permis);
    }

    public Permis rechercherUnPermis(Integer numeroPerception)
    {
        Permis permis = permisRepository.findByNumeroPerception(numeroPerception);
        return permis;
    }

    public Permis rechercherPermis(String numeroPermis)
    {
        Permis permis = permisRepository.findByNumeroPermis(numeroPermis);
        return permis;
    }

    @Transactional
    public Permis modifierPermis(Permis permis)
    {
        Permis permisExistant = rechercherPermis(permis.getNumeroPermis());
        permisExistant.setNumeroPerception(permis.getNumeroPerception());
        permisExistant.setTypePermis(permis.getTypePermis());
        permisExistant.setNumeroPermis(permis.getNumeroPermis());
        permisExistant.setRegion(permis.getRegion());
        permisExistant.setDateQuitance(permis.getDateQuitance());
        permisExistant.setDateDebutValidite(permis.getDateDebutValidite());
        permisExistant.setDateFinValidite(permis.getDateFinValidite());

        return permisRepository.save(permisExistant);
    }

    public void supprimerPermis(String numeroPermis)
    {
        Permis permis = rechercherPermis(numeroPermis);
        if (permis != null)
        {
            permisRepository.delete(permis);
        }
    }

    public void supprimerUnPermis(Integer numeroPerception)
    {
        Permis permis = rechercherUnPermis(numeroPerception);
        if (permis != null)
        {
            permisRepository.delete(permis);
        }
    }

    public Long nombreDePermis()
    {
        Long nbrePermis = permisRepository.count();
        return nbrePermis;
    }
}
