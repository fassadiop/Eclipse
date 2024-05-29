package sn.gouv.dpm.embarcations.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import sn.gouv.dpm.embarcations.entity.Permis;

@FeignClient(url = "http://localhost:8082", value = "GESTION-DES-PERMIS-DE-PECHE")
public interface PermisClient
{
    //Pour lister tous les permis
    @GetMapping("/permisapi/permis")
    public List<Permis> afficherPermis();

    @GetMapping("/permisapi/permis/{numeroPerception}")
    public ResponseEntity<Permis> TrouverUnPermis(@PathVariable("numeroPerception") Integer numeroPerception);
}
