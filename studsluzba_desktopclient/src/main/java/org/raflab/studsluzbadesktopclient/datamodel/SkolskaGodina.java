package org.raflab.studsluzbadesktopclient.datamodel;

import java.time.LocalDate;

public class SkolskaGodina {
	
	
	private Long id;
	
	private int pocetna;
	private int krajnja;
	private boolean aktivna;
	
	private LocalDate datumPocetka;
	
	public int getPocetna() {
		return pocetna;
	}
	public void setPocetna(int pocetna) {
		this.pocetna = pocetna;
		this.krajnja = pocetna+1;
	}
	public int getKrajnja() {
		return krajnja;
	}
	
	public boolean isAktivna() {
		return aktivna;
	}
	public void setAktivna(boolean aktivna) {
		this.aktivna = aktivna;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setKrajnja(int krajnja) {
		this.krajnja = krajnja;
	}
	public LocalDate getDatumPocetka() {
		return datumPocetka;
	}
	public void setDatumPocetka(LocalDate datumPocetka) {
		this.datumPocetka = datumPocetka;
	}
	
	/*
	 * vraca skolsku godinu u obliku pocetna/krajnja kao string za prikaz u tabeli
	 */
	
	public String getGodinaStr() {
		return pocetna + "/" + krajnja;
	}
	
	/*
	 * prikaz u tabeli - da li je aktivna
	 */
	
	public String getAktivnaStr() {
		return aktivna ? "aktivna" : "neaktivna";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		SkolskaGodina other = (SkolskaGodina) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
