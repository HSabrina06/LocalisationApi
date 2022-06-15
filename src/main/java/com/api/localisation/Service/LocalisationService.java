package com.api.localisation.Service;

import com.api.localisation.Controller.SearchRequest;
import com.api.localisation.Entity.Localisation;
import com.api.localisation.Entity.TypeState;

import java.util.List;

public interface LocalisationService {

    /**
     * Save a localisation.
     *
     * @param localisation the entity to save.
     * @return the persisted entity.
     */
    Localisation save(Localisation localisation);

    /**
     * Get all the localisations.
     *
     * @return the list of entities.
     */
    List<Localisation> findAll();


    /**
     * Get all the localisations by Type.
     *
     * @return the list of entities.
     */

    List<Localisation> findAllLocalisationByType(TypeState type);



    /**
     * Get all the localisations by searchRequest
     *
     * @return the list of entities.
     */

    List<Localisation> findAllLocalisationByPointAndType(SearchRequest searchRequest);


}
