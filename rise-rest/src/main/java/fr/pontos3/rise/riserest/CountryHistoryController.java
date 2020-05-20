package fr.pontos3.rise.riserest;

import fr.pontos3.rise.riserest.CountryHistoryRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@RepositoryRestController
public class CountryHistoryController {
	
	private CountryHistoryRepository repository;

//	private PagedResourcesAssembler<CountryHistory> assembler;

	
	
	public CountryHistoryController(CountryHistoryRepository repository) {
		this.repository = repository;
	}

	@GetMapping("/countryhistory/filter")
	public ResponseEntity<?> filter(
		CountryHistory countryHistory,
		Pageable page //,
		//PagedResourcesAssembler<Page<CountryHistory>> assembler,
		//PersistentEntityResourceAssembler entityAssembler
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
  
	  //Resources<String> res = new Resouces();
	  //PagedModel<CountryHistory> collModel = this.assembler.toModel(result, entityAssembler);

	  //PagedResourcesAssembler.toModel(Page<CountryHistory> page, RepresentationModelAssembler<CountryHistory,R> assembler) : PagedModel<R>

	  return ResponseEntity.ok(result);
  
	}

}
