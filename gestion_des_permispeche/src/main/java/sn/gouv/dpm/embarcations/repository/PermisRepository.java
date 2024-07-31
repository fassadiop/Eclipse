package sn.gouv.dpm.embarcations.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.gouv.dpm.embarcations.entity.Permis;

public interface PermisRepository extends JpaRepository<Permis, Integer>
{
    Permis findByNumeroPerception(Integer numeroPerception);
    Permis findByNumeroPermis(String numeroPermis);
}