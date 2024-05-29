package sn.gouv.dpm.proprietaires.client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import sn.gouv.dpm.proprietaires.entity.*;

import java.util.List;

@FeignClient(url = "http://localhost:8080", value = "GESTION-DES-EMBARCATIONS")
public interface PirogueClient
{

    //Pour lister toutes les pirogues
    @GetMapping("/pirogueapi/pirogues")
    public List<Pirogue> afficherPirogues();

    //Trouver une pirogue
    @GetMapping("/pirogueapi/pirogues/{immatriculation}")
    public ResponseEntity<Pirogue> obtenirUnePirogue(@PathVariable("immatriculation") String immatriculation);

}

