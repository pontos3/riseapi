package fr.pontos3.rise.riserest;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class TownHistory {
	
	@Id
	private long id;
	
	private String libelle;
	
	private String code;
	

}
