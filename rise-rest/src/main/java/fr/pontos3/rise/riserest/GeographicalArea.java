package fr.pontos3.rise.riserest;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.springframework.data.rest.core.annotation.RestResource;

import lombok.AllArgsConstructor;
import lombok.Data;

//import org.hibernate.envers.Audited;

import lombok.NoArgsConstructor;



//@Audited

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class GeographicalArea {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
