package fr.pontos3.rise.riserest;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Version;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.LastModifiedDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Town {
	
	@Id
	private long id;
	
	@Version
	private long version;
	
	@LastModifiedDate
	private Instant modified;
	
	@NotNull
	@Column(unique=true)
	private String code;
	
	@OneToOne(mappedBy="capital")
	private Country country;
	
	@NotNull
	@Column(unique=true)
	private String name;
	
	private double longitude;

	private double latitude;
	
	

}
