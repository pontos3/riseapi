package fr.pontos3.rise.riserest;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.validation.constraints.NotNull;
import javax.persistence.OneToMany;

//import org.hibernate.envers.Audited;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Audited

@Entity
@Getter @Setter @NoArgsConstructor
public class GeographicalArea {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String label;
	private String code;
	
	@OneToMany
	private List<Country> countries;

	GeographicalArea(String code, String label, List<Country> countries) {
		this.code = code;
		this.label = label;
		this.countries = countries;
	}

}
