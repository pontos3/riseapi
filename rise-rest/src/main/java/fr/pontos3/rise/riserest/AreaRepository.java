package fr.pontos3.rise.riserest;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.history.RevisionRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "areas", path = "areas")
public interface AreaRepository extends RevisionRepository<Area, Long, Long>, PagingAndSortingRepository<Area, Long>{

    List<Area> findByName(@Param("name") String name);
    
    List<Area> findByCode(@Param("code") String code);
    
    List<Area> findLastChangeRevision(@Param("id") long id);

}