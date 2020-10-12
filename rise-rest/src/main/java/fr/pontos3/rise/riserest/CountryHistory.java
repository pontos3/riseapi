package fr.pontos3.rise.riserest;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//import org.hibernate.envers.Audited;
//@Audited

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

@Table(uniqueConstraints={
	@UniqueConstraint(columnNames = {"country_id", "endDate"})
})
public class CountryHistory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;

	@Pattern(regexp= "[a-z]{2,}", message="{countryhistory.iso2.format}")
	@Length(min=2, max=2)
	private String iso2;

	@Pattern(regexp= "[a-z]{3,}", message="{countryhistory.iso3.format}")
	@Length(min=3, max=3)
	private String iso3;
	
	@NotNull(message="{countryhistory.validation.usualName.require}")
	@Length(min=3, max=50, message="{countryhistory.validation.usualName.format}")
	private String usualName;

	@Length(min=3, max=255, message="{countryhistory.validation.officialName.format}")
	private String officialName;

	@NotNull(message="{countryhistory.validation.listName.require}")
	@Length(min=3, max=50, message="{countryhistory.validation.listName.format}")
	private String listName;

	@Length(min=3, max=50, message="{countryhistory.validation.inhabitant.format}")
	private String inhabitant;

	@DateTimeFormat(iso = ISO.DATE_TIME)
	//@Column(columnDefinition = "DATETIME NOT NULL default CAST( '0000-01-01 00:00:00' AS DATETIME )")
	private LocalDateTime startDate = LocalDateTime.of(1,1,1,0,0,0);
	
	@DateTimeFormat(iso = ISO.DATE_TIME)
	//@Column(columnDefinition = "DATETIME NOT NULL default CAST( '9999-12-31 23:59:59' AS DATETIME )")
    private LocalDateTime endDate = LocalDateTime.of(9999,12,31,12,59,59);
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "country_id", nullable = false)
	private Country country;
	 
	CountryHistory (Country country,String iso2, String iso3, String usualName, String officialName, String listName) {
		this.country = country;
		this.iso2 = iso2;
		this.iso3 = iso3;
		this.usualName = usualName;
		this.officialName = officialName;
		this.listName = listName;
	}
}
