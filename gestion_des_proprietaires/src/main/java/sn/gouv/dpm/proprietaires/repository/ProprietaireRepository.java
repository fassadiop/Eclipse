package sn.gouv.dpm.proprietaires.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.gouv.dpm.proprietaires.entity.Proprietaire;

public interface ProprietaireRepository extends JpaRepository<Proprietaire, Integer>
{
    Proprietaire findByCni(Long cni);
}
