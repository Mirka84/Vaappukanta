package fi.harjoitustyo.syksy2021.vaappukanta.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
public class Vaappu {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	
	@NotNull
	@Size(min=2, max=15, message = "Nimi on pakollinen tieto")
	private String nimi; 
	
	@NotNull
	@Size(min=2, max=50, message = "Tekijä on pakollinen tieto")
	private String tekija; 
	
	private int pituus; 
	private String vari; 
	
	@ManyToOne
	@JoinColumn(name="malliid")
	@JsonManagedReference
	private Malli malli;
	
	

	public Vaappu() {
		super();
	}

	public Vaappu(Long id, String nimi, String tekija, int pituus, String vari, Malli malli) {
		super();
		this.id = id;
		this.nimi = nimi;
		this.tekija = tekija;
		this.pituus = pituus;
		this.vari = vari;
		this.malli = malli;
	}
	
	public Vaappu(String nimi, String tekija, int pituus, String vari) {
		this.nimi=nimi; 
		this.tekija=tekija;
		this.pituus=pituus;
		this.vari=vari; 
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNimi() {
		return nimi;
	}

	public void setNimi(String nimi) {
		this.nimi = nimi;
	}

	public String getTekija() {
		return tekija;
	}

	public void setTekija(String tekija) {
		this.tekija = tekija;
	}

	public int getPituus() {
		return pituus;
	}

	public void setPituus(int pituus) {
		this.pituus = pituus;
	}

	public String getVari() {
		return vari;
	}

	public void setVari(String vari) {
		this.vari = vari;
	}

	public Malli getMalli() {
		return malli;
	}

	public void setMalli(Malli malli) {
		this.malli = malli;
	}

	@Override
	public String toString() {
		return "Vaappu [id=" + id + ", nimi=" + nimi + ", tekija=" + tekija + ", pituus=" + pituus + ", vari=" + vari
				 + ", malli=" + malli + "]";
	} 
	

}
