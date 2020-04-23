package fr.pontos3.rise.riserest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.fasterxml.jackson.annotation.JsonFormat;


@RepositoryRestResource(collectionResourceRel = "countryhistory", path = "countryhistory")
public interface CountryHistoryRepository extends PagingAndSortingRepository<CountryHistory, UUID> {

    List<CountryHistory> findByIso2(@Param("iso2") String iso2);
    
    List<CountryHistory> findByIso3(@Param("iso3") String iso3);

    List<CountryHistory> findByListName(@Param("listName") String listName);

    List<CountryHistory> findByUsualName(@Param("usualName") String usualName);
    
    //List<CountryHistory> findByStartDateLessThan(@Param("startDate")  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime startDate);
    List<CountryHistory> findByStartDateLessThan(@Param("startDate") LocalDateTime startDate);
    
    
    @Query("select a from CountryHistory a where a.startDate <= :currentDate")
    List<CountryHistory> findAllWithstartDateBefore(
      @Param("currentDate")
      @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss") LocalDateTime currentDate);
//      @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime currentDate);
    
    
    /*
	@Query(value = "from CountryHistory ch where :currentDate BETWEEN ch.startDate AND ch.endDate", nativeQuery = true)
	public List<CountryHistory> getAllCurrent(
			@Param("currentDate") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime currentDate
			);
	*/
	

    //List<Country> findByCoordinates(@Param("longitude") float longitude, @Param("longitude") float latitude);

}