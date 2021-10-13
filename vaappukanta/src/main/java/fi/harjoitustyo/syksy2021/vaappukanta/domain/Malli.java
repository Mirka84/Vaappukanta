package fi.harjoitustyo.syksy2021.vaappukanta.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Malli {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long malliid; 
	
	private String mallinimi;
	
	@JsonIgnore
	@OneToMany(cascade=CascadeType.ALL, mappedBy="malli")
	private List<Vaappu>vaaput;
	
	
	public Malli() {
		super();
	}



	public Malli(long malliid, String mallinimi) {
		super();
		this.malliid = malliid;
		this.mallinimi = mallinimi;
	}



	public long getMalliid() {
		return malliid;
	}



	public void setMalliid(long malliid) {
		this.malliid = malliid;
	}



	public String getMallinimi() {
		return mallinimi;
	}



	public void setMallinimi(String mallinimi) {
		this.mallinimi = mallinimi;
	}



	@Override
	public String toString() {
		return "Malli [malliid=" + malliid + ", nimi=" + mallinimi + "]";
	} 
	

}
