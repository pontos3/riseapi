package fr.pontos3.rise.riserest;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Town {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Generated(GenerationTime.ALWAYS )
	//@Column(unique=true, columnDefinition = "AS CONCAT ('town-', id)")
	@NotNull
	private String name;
	
	private float longitude;
	
	private float latitude;
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID uid;

}
