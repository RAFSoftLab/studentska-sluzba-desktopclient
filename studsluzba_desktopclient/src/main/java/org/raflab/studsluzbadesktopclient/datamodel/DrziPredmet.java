package org.raflab.studsluzbadesktopclient.datamodel;





public class DrziPredmet {
	
	
	private Long id;
	private Nastavnik nastavnik;	
	private Predmet predmet;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Nastavnik getNastavnik() {
		return nastavnik;
	}

	public void setNastavnik(Nastavnik nastavnik) {
		this.nastavnik = nastavnik;
	}

	public Predmet getPredmet() {
		return predmet;
	}

	public void setPredmet(Predmet predmet) {
		this.predmet = predmet;
	}
	
	
	
	

}
