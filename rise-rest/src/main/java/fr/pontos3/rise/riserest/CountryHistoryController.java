package fr.pontos3.rise.riserest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryHistoryController {
	
	private CountryHistoryRepository repository;
	
	public CountryHistoryController(CountryHistoryRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping("/test/test")
	//public List<CountryHistory> getAllcurent(@RequestParam(value = "startDate") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime startDate) {
	public List<CountryHistory> getAllcurent(@RequestParam(value = "startDate") String startDate) {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		
		
		LocalDateTime dateDebut = LocalDateTime.parse(startDate, formatter);
		
		//return repository.findByStartDateLessThan(dateDebut);
		return repository.findAllWithstartDateBefore(dateDebut);

		
	}

}
