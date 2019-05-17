package fr.pontos3.rise.riserest;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

//import org.hibernate.envers.Audited;
//@Audited

@Entity
@Data
@NoArgsConstructor
public class Country {

	@GeneratedValue(strategy = GenerationType.AUTO)
	private @Id long id;

	private String iso2;
	private String iso3;
	
	private String usualName;

	private String officialName;

	private String shortName;

	private double longitude;

	private double latitude;

	Country (String iso2, String iso3, String usualName, String officialName, String shortName, double longitude, double latitude) {
		this.iso2 = iso2;
		this.iso3 = iso3;
		this.usualName = usualName;
		this.officialName = officialName;
		this.shortName = shortName;
		this.longitude = longitude;
		this.latitude = latitude;
	}

}
