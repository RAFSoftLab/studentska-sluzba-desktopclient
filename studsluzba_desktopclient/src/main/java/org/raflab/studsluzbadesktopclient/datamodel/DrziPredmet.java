package org.raflab.studsluzbadesktopclient.datamodel;





public class DrziPredmet {
	
	
	private Long id;
	private Nastavnik nastavnik;	
	private Predmet predmet;
	private SkolskaGodina skolskaGodina;
	
	public DrziPredmet() {
		
	}

	public DrziPredmet(Nastavnik nastavnik, Predmet predmet, SkolskaGodina skolskaGodina) {
		super();
		this.nastavnik = nastavnik;
		this.predmet = predmet;
		this.skolskaGodina = skolskaGodina;
	}

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

	public SkolskaGodina getSkolskaGodina() {
		return skolskaGodina;
	}

	public void setSkolskaGodina(SkolskaGodina skolskaGodina) {
		this.skolskaGodina = skolskaGodina;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nastavnik == null) ? 0 : nastavnik.hashCode());
		result = prime * result + ((predmet == null) ? 0 : predmet.hashCode());
		result = prime * result + ((skolskaGodina == null) ? 0 : skolskaGodina.hashCode());
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
		DrziPredmet other = (DrziPredmet) obj;
		if (nastavnik == null) {
			if (other.nastavnik != null)
				return false;
		} else if (!nastavnik.equals(other.nastavnik))
			return false;
		if (predmet == null) {
			if (other.predmet != null)
				return false;
		} else if (!predmet.equals(other.predmet))
			return false;
		if (skolskaGodina == null) {
			if (other.skolskaGodina != null)
				return false;
		} else if (!skolskaGodina.equals(other.skolskaGodina))
			return false;
		return true;
	}
	
	
	
	

}
