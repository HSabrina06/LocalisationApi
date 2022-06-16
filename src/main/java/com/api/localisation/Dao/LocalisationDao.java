package com.api.localisation.Dao;

import com.api.localisation.Entity.Localisation;
import com.api.localisation.Entity.TypeState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Pageable;

import java.util.List;


@Repository
public interface LocalisationDao  extends JpaRepository<Localisation, Long> {

 @Query("select l from Localisation l where l.type =:type order by l.type")
 List<Localisation> findLocalisationByType(@Param("type") TypeState type, Pageable pageable);

 @Query("select l from Localisation l where  l.type =:type and (((:p1_lng is null or l.lng =:p1_lng) and (:p1_lan is null or l.lan=:p1_lan) ) or ((:p2_lng is null or l.lng =:p2_lng) and (:p2_lan is null or l.lan=:p2_lan))) order by l.type")
 List<Localisation> findLocalisationByPointAndType(@Param("p1_lan") String p1_lan,  @Param("p1_lng") String p1_lng,@Param("p2_lan") String p2_lan,  @Param("p2_lng") String p2_lng, @Param("type") TypeState type, Pageable pageable);

 @Query("select l from Localisation l where (:type is null or  l.type =:type) and ((:p_lng is null or l.lng =:p_lng) and (:p_lan is null or l.lan=:p_lan) ) order by l.type")
 List<Localisation> findLocalisationByOnePointAndType(@Param("p_lan") String p_lan,  @Param("p_lng") String _lng, @Param("type") TypeState type, Pageable pageable);

 @Query("select l from Localisation l where ((:p1_lng is not null and l.lng =:p1_lng) and (:p1_lan is not null and l.lan=:p1_lan) ) or ((:p2_lng is not null and l.lng =:p2_lng) and (:p2_lan is not null and l.lan=:p2_lan)) order by l.type")
 List<Localisation> findLocalisationByPoint(@Param("p1_lan") String p1_lan,  @Param("p1_lng") String p1_lng,@Param("p2_lan") String p2_lan,  @Param("p2_lng") String p2_lng, Pageable pageable);


}
