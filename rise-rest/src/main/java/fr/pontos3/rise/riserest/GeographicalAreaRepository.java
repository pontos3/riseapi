package fr.pontos3.rise.riserest;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "geographicalareas", path = "geographicalareas")
public interface GeographicalAreaRepository extends PagingAndSortingRepository<GeographicalArea, Long> {

    List<GeographicalArea> findByLabel(@Param("label") String label);
    
    List<GeographicalArea> findByCode(@Param("code") String code);

}