package fr.pontos3.rise.riserest;

import java.time.LocalDateTime;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.data.web.SortDefault;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;


@RepositoryRestResource(collectionResourceRel = "countryhistory", path = "countryhistory")
public interface CountryHistoryRepository extends PagingAndSortingRepository<CountryHistory, Long> {
    

    @RestResource(exported = false)
    Page<CountryHistory> findAll( Example<CountryHistory> example, Pageable P);

    @RestResource(path = "findByIso2", rel = "findByIso2")
    Page<CountryHistory> findByIso2IgnoreCase(@Param("iso2") String iso2, 
      @SortDefault.SortDefaults({
          @SortDefault(sort = "startDate", direction = Direction.DESC)
      })
      Pageable P 
    );

    @Query("select a from CountryHistory a where :currentDate between a.startDate and a.endDate and lower(a.iso2)=lower(:iso2)")
    CountryHistory findByIso2AtDate(@Param("iso2") String iso2,
      @Param("currentDate") @DateTimeFormat(iso = ISO.DATE_TIME) LocalDateTime currentDate);
    

    @RestResource(path = "findByIso3", rel = "findByIso3")
    Page<CountryHistory> findByIso3IgnoreCase(@Param("iso3") String iso3,  
      @SortDefault.SortDefaults({
          @SortDefault(sort = "startDate", direction = Direction.DESC)
      })
      Pageable P 
    );

    @Query("select a from CountryHistory a where :currentDate between a.startDate and a.endDate and lower(a.iso3)=lower(:iso3)")
    CountryHistory findByIso3AtDate(@Param("iso3") String iso3,
      @Param("currentDate") @DateTimeFormat(iso = ISO.DATE_TIME) LocalDateTime currentDate);
    
    Page<CountryHistory> findByListNameIgnoreCase(@Param("listName") String listName, 
      @SortDefault.SortDefaults({
      @SortDefault(sort = "startDate", direction = Direction.DESC)
      })
      Pageable P
    );

    @RestResource(path = "findByUsualNameInsensitiveCase", rel = "findByUsualNameInsensitiveCase")
    Page<CountryHistory> findByUsualNameIgnoreCaseContaining(@Param("usualName") String usualName, 
      @SortDefault.SortDefaults({
      @SortDefault(sort = "startDate", direction = Direction.DESC)
      })
      Pageable P
    );
    
    Page<CountryHistory> findByStartDateLessThan(@DateTimeFormat(iso = ISO.DATE_TIME) LocalDateTime startDate, Pageable P);
    
    @Query("select a from CountryHistory a where a.startDate <= :currentDate")
    Page<CountryHistory> findAllWithstartDateBefore(
        @Param("currentDate") @DateTimeFormat(iso = ISO.DATE_TIME) LocalDateTime currentDate,
        Pageable P
      );

    @Query("select a from CountryHistory a where :currentDate between a.startDate and a.endDate")
    Page<CountryHistory> findAllAtDate(
      @Param("currentDate") @DateTimeFormat(iso = ISO.DATE_TIME) LocalDateTime currentDate, 
      Pageable P
    );

}