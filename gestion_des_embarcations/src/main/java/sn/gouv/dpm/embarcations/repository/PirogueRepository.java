package sn.gouv.dpm.embarcations.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sn.gouv.dpm.embarcations.entity.Pirogue;

@Repository
public interface PirogueRepository extends JpaRepository<Pirogue, Integer>
{
    Pirogue findByImmatriculation(String immatriculation);
    Pirogue findByNom(String nom);
}

