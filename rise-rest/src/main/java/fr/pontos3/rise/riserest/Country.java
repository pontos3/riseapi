package fr.pontos3.rise.riserest;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//import org.hibernate.envers.Audited;
//@Audited

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Country {

	@GeneratedValue(strategy = GenerationType.AUTO)
	private @Id long id;
	
	@Version
	private long version;
	
	
	private @LastModifiedDate Instant modified;

	private String iso2;
	private String iso3;
	
	@NotNull
	private String usualName;

	private String officialName;

	@NotNull
	private String shortName;

	private double longitude;

	private double latitude;

	@ManyToOne
	@JoinColumn(name="countries_id")
	private Area area;

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
