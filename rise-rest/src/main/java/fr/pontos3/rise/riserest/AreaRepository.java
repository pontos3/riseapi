package fr.pontos3.rise.riserest;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "areas", path = "areas")
public interface AreaRepository extends PagingAndSortingRepository<Area, Long> {

    List<Area> findByLabel(@Param("label") String label);
    
    List<Area> findByCode(@Param("code") String code);

}