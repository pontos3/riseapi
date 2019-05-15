package fr.pontos3.rise.riserest;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//import org.hibernate.envers.Audited;
//@Audited

@Entity
@Getter
@Setter
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

}
