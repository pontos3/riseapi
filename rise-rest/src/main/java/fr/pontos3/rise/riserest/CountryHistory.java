package fr.pontos3.rise.riserest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//import org.hibernate.envers.Audited;
//@Audited

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CountryHistory {

	@GeneratedValue(strategy = GenerationType.AUTO)
	private @Id UUID id;

	private String iso2;
	private String iso3;
	
	@NotNull
	private String usualName;

	private String officialName;

	@NotNull
	private String listName;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private LocalDateTime startDate;
	
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endDate;

	
	 @ManyToOne(fetch = FetchType.LAZY, optional = false)
     //@ManyToOne
	 @JoinColumn(name = "country_id", nullable = false)
	 @OnDelete(action = OnDeleteAction.CASCADE)
	 //@JsonIgnore
	 private Country country;
	 
	/*
	@ManyToOne
	@JoinColumn(name="countries_id")
	private GeographicalArea geographicalArea;
	 */
	CountryHistory (Country country,String iso2, String iso3, String usualName, String officialName, String listName) {
		this.country = country;
		this.iso2 = iso2;
		this.iso3 = iso3;
		this.usualName = usualName;
		this.officialName = officialName;
		this.listName = listName;
	}
}
