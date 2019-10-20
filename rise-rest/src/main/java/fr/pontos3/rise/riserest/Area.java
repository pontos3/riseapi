package fr.pontos3.rise.riserest;

import java.time.Instant;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.rest.core.annotation.RestResource;

import lombok.AllArgsConstructor;
import lombok.Data;

//import org.hibernate.envers.Audited;

import lombok.NoArgsConstructor;



//@Audited
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Area {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Version
	private long version;
	
	@LastModifiedDate
	private Instant modified;

	@NotNull
	private String label;

	@NotNull
	private String code;
	
	@OneToMany(mappedBy="area")
	@RestResource(path="countries", rel="countries")
	private List<Country> countries;

	Area(String code, String label, List<Country> countries) {
		this.code = code;
		this.label = label;
		this.countries = countries;
	}
}
