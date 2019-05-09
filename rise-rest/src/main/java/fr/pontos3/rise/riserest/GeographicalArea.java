package fr.pontos3.rise.riserest;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.envers.Audited;

@Data
@Entity
@Audited
public class GeographicalArea {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String label;
    private String description;
    private String code;

/*	public String getlabel() {
		return label;
	}

	public void setlabel(String label) {
		this.label = label;
	}

	public String getdescription() {
		return description;
	}

	public void setdescription(String description) {
		this.description = description;
    }
    
    public String getcode() {
        return this.code;
    }

    public void setcode(String code) {
        this.code = code;
    } */

}
