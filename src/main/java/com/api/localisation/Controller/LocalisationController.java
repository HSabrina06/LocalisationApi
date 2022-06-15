package com.api.localisation.Controller;

import com.api.localisation.Dao.LocalisationDao;
import com.api.localisation.Entity.Localisation;
import com.api.localisation.Entity.TypeState;
import com.api.localisation.Service.LocalisationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class LocalisationController {

    private final Logger log = LoggerFactory.getLogger(LocalisationController.class);
    @Autowired
    LocalisationService localisationService;
    @Autowired
    LocalisationDao LocalisationDao;


    @PostMapping("/localisation")
    public ResponseEntity<Localisation> createLocalisation(@RequestBody Localisation localisation) throws URISyntaxException {
        log.debug("REST request to save Localisation : {}", localisation);

        try {
            Localisation result = localisationService.save(localisation);
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/localisations")
    public ResponseEntity<List<Localisation>> getAllLocalisation() {
        log.debug("REST request to get all localisations ");
        List<Localisation> localisations = localisationService.findAll();

        return ResponseEntity.ok().body(localisations);
    }

    @GetMapping("/localisations/{id}")
    public ResponseEntity<Localisation> getLocalisationById(@PathVariable Long id) {
        log.debug("REST request to get Localisation : {}", id);
        Optional<Localisation> localisation = LocalisationDao.findById(id);
        if (localisation.isPresent()) {
            return new ResponseEntity<>(localisation.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/searchLocalisationsByPointType")
    public ResponseEntity<List<Localisation>> getLocalisationByPoint(@RequestBody  SearchRequest searchRequest) {
        List<Localisation> localisations = localisationService.findAllLocalisationByPointAndType(searchRequest);
        return ResponseEntity.ok().body(localisations);
    }


}
