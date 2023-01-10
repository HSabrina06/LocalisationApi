package com.api.localisation.Service;

import com.api.localisation.Controller.PointRequest;
import com.api.localisation.Controller.SearchRequest;
import com.api.localisation.Dao.LocalisationDao;
import com.api.localisation.Entity.Localisation;
import com.api.localisation.Entity.TypeState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.sound.midi.Soundbank;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class LocalisationServiceImp implements LocalisationService {
@Autowired
    LocalisationDao localisationDao;

    private final Logger log = LoggerFactory.getLogger(LocalisationServiceImp.class);

    @Override
    public Localisation save(Localisation localisation) {
        log.debug("Request to save Localisation : {}", localisation);
        return localisationDao.save(localisation);
    }

    @Override
    public List<Localisation> findAll() {
        return localisationDao.findAll();
    }

    @Override
    public List<Localisation> findAllLocalisationByType(TypeState type) {
        return localisationDao.findLocalisationByType(type, PageRequest.of(0, 3));
    }

    @Override
    public List<Localisation> findAllLocalisationByPointAndType(SearchRequest searchRequest) {

        if(searchRequest.getLimit() == null){
            searchRequest.setLimit(Integer.MAX_VALUE);
        }
        if(searchRequest.getP1()== null && searchRequest.getP2()== null){
            return localisationDao.findLocalisationByType(searchRequest.getType(), PageRequest.of(0, 3));
        }
        if(searchRequest.getP2()== null){
           return localisationDao.findLocalisationByOnePointAndType(searchRequest.getP1().getLan(), searchRequest.getP1().getLng(), searchRequest.getType(),PageRequest.of(0, searchRequest.getLimit()));
        }
        if(searchRequest.getP1()== null){
            return localisationDao.findLocalisationByOnePointAndType(searchRequest.getP2().getLan(), searchRequest.getP2().getLng(),searchRequest.getType(),PageRequest.of(0, searchRequest.getLimit()));
        }
        if(searchRequest.getType()==null){
            System.out.println("type null"+searchRequest.getP1().getLan());

            return localisationDao.findLocalisationByPoint(searchRequest.getP1().getLan(), searchRequest.getP1().getLng(),searchRequest.getP2().getLan(), searchRequest.getP2().getLng(), PageRequest.of(0, searchRequest.getLimit()));
        }
        return localisationDao.findLocalisationByPointAndType(searchRequest.getP1().getLan(), searchRequest.getP1().getLng(),searchRequest.getP2().getLan(), searchRequest.getP2().getLng(),searchRequest.getType(),PageRequest.of(0, searchRequest.getLimit()));
    }


}
