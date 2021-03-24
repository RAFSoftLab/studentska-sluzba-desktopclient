package org.raflab.studsluzbadesktopclient.datamodel;


public class PolozenPredmet {
	
	
	private Long id;
	
	private Integer ocena;
		
	private IzlazakIspit ispit;  
		
	private Nastavnik nastavnik;
		
	private Predmet predmet;	
	
	private boolean priznat;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getOcena() {
		return ocena;
	}
	public void setOcena(Integer ocena) {
		this.ocena = ocena;
	}
	public IzlazakIspit getIspit() {
		return ispit;
	}
	public void setIspit(IzlazakIspit ispit) {
		this.ispit = ispit;
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
	public boolean isPriznat() {
		return priznat;
	}
	public void setPriznat(boolean priznat) {
		this.priznat = priznat;
	}
	
	public String getNaziv() {
		return predmet.getNaziv();
	}
	
	public String getSifra() {
		return predmet.getSifra();
	}
	
	public String getPriznat() {
		return priznat ? "priznat" : "";
	}
	
	public int getEspb() {
		return predmet.getEspb();
	}
	
	
	
	
}
