package fr.pontos3.rise.riserest;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "countries", path = "countries")
public interface CountryRepository extends PagingAndSortingRepository<Country, Long> {

    List<Country> findByIso2(@Param("iso2") String iso2);
    
    List<Country> findByIso3(@Param("iso3") String iso3);

    List<Country> findByShortName(@Param("shortName") String shortName);

    List<Country> findByUsualName(@Param("usualName") String usualName);

}