package fr.pontos3.rise.riserest;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//import org.hibernate.envers.Audited;
//@Audited

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Country {

	@GeneratedValue(strategy = GenerationType.AUTO)
	private @Id UUID id;

	private double longitude;

	private double latitude;

	//@OneToMany(mappedBy="country", fetch = FetchType.LAZY)
	//@OneToMany(mappedBy="country")
	//@RestResource(path="countries", rel="countries")
	//private List<CountryHistory> countryHistory;
/*
	@ManyToOne
	@JoinColumn(name="countries_id")
	private GeographicalArea geographicalArea;
*/
	Country (double longitude, double latitude) {
		this.longitude = longitude;
		this.latitude = latitude;
	}
}
