package fr.pontos3.rise.riserest;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.PersistentEntityResourceAssembler;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@RepositoryRestController
public class CountryHistoryController {
	
	private CountryHistoryRepository repository;
	
	public CountryHistoryController(CountryHistoryRepository repository) {
		this.repository = repository;
	}

	@GetMapping("/countryhistory/filter")
	public ResponseEntity<?> filter(
		CountryHistory countryHistory,
		Pageable page,
		PagedResourcesAssembler assembler,
		PersistentEntityResourceAssembler entityAssembler
	){
  
	  ExampleMatcher matcher = ExampleMatcher.matching()
		  .withIgnoreCase()		  
		  .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING)
		  .withIgnorePaths("id")
		  .withIgnorePaths("country")
		  .withIgnorePaths("startDate")
		  .withIgnorePaths("endDate");
  
	  Example<CountryHistory> example = Example.of(countryHistory, matcher);
  
	  Page<CountryHistory> result = this.repository.findAll(example, page);
  
	  return ResponseEntity.ok(assembler.toResource(result, entityAssembler));
  
	}

}
