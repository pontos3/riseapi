package fr.pontos3.rise.riserest;

import org.springframework.data.rest.core.config.Projection;
import java.time.LocalDateTime;

@Projection(name = "inlineCountry", types = { CountryHistory.class }) 
interface InlineCountry {
	long getId();

	String getIso2();

	String getIso3();
	
	String getUsualName();

	String getOfficialName();


	String getListName();

	String getInhabitant();

	LocalDateTime getStartDate();
	
    LocalDateTime getEndDate();
    
    Country getCountry();
}