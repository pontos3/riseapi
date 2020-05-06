package fr.pontos3.rise.riserest;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;


import lombok.AllArgsConstructor;
import lombok.Data;

//import org.hibernate.envers.Audited;

import lombok.NoArgsConstructor;



//@Audited

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class GeographicalArea {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotNull
	private String label;

	@NotNull
	private String code;

	/*
	@OneToMany(mappedBy="geographicalArea")
	@RestResource(path="countries", rel="countries")
	private List<Country> countries;

	GeographicalArea(String code, String label, List<Country> countries) {
		this.code = code;
		this.label = label;
		this.countries = countries;
	}
	*/
}
