package org.raflab.studsluzbadesktopclient.datamodel;







public class Predmet {
	
	
	private Long id;
	
	private String sifra;
	private String naziv;
	private String opis;
	private Integer ESPB;
	private Integer semestar;
	private Integer godinaStudija; // izracunava se na osnovu semestra	
	private StudijskiProgram studProgram;
	private Integer fondPredavanja;
	private Integer fondVezbe;
	
	

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSifra() {
		return sifra;
	}
	public void setSifra(String sifra) {
		this.sifra = sifra;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public String getOpis() {
		return opis;
	}
	public void setOpis(String opis) {
		this.opis = opis;
	}
	public Integer getESPB() {
		return ESPB;
	}
	public void setESPB(Integer eSPB) {
		ESPB = eSPB;
	}
	public Integer getSemestar() {
		return semestar;
	}
	public void setSemestar(Integer semestar) {
		this.semestar = semestar;
	}
	public Integer getGodinaStudija() {
		return godinaStudija;
	}
	public void setGodinaStudija(Integer godinaStudija) {
		this.godinaStudija = godinaStudija;
	}
	public StudijskiProgram getStudProgram() {
		return studProgram;
	}
	public void setStudProgram(StudijskiProgram studProgram) {
		this.studProgram = studProgram;
	}
	public Integer getFondPredavanja() {
		return fondPredavanja;
	}
	public void setFondPredavanja(Integer fondPredavanja) {
		this.fondPredavanja = fondPredavanja;
	}
	public Integer getFondVezbe() {
		return fondVezbe;
	}
	public void setFondVezbe(Integer fondVezbe) {
		this.fondVezbe = fondVezbe;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sifra == null) ? 0 : sifra.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Predmet other = (Predmet) obj;
		if (sifra == null) {
			if (other.sifra != null)
				return false;
		} else if (!sifra.equals(other.sifra))
			return false;
		return true;
	}		
	
	
	
}
