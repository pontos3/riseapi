package fr.pontos3.rise.riserest;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Version;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.web.bind.annotation.CrossOrigin;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//import org.hibernate.envers.Audited;
//@Audited

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Audited
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Country {

	@GeneratedValue(strategy = GenerationType.AUTO)
	private @Id long id;
	
	@Version
	private long version;
	
	@LastModifiedDate
	private Instant modified;

	@Column(unique=true)
	@Size(max=2)
	private String iso2;
	
	@Column(unique=true)
	@Size(max=3)
	private String iso3;
	
	@Column(unique=true)
	private int isoNumeric;
	
	@NotNull
	@Size(max=50)
	private String usualName;

	@Size(max=150)
	private String officialName;

	@NotNull
	private String shortName;
	
	@Size(max=50)
	private String nationality;

	private double longitude;

	private double latitude;

	@Audited
	@ManyToOne
	@JoinColumn(name="countries_id")
	private Area area;
	
	@NotAudited
	@OneToOne
	private Town capital;

	/*
	Country (String iso2, String iso3, String usualName, String officialName, String shortName, double longitude, double latitude) {
		this.iso2 = iso2;
		this.iso3 = iso3;
		this.usualName = usualName;
		this.officialName = officialName;
		this.shortName = shortName;
		this.longitude = longitude;
		this.latitude = latitude;
	}
	*/
}
