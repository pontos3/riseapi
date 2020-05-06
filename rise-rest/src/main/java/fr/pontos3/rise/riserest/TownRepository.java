package fr.pontos3.rise.riserest;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(exported = false)
public interface TownRepository extends PagingAndSortingRepository<Town, Long> {
	
	

}
