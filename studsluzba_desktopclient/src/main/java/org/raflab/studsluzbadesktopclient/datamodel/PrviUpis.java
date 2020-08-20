package org.raflab.studsluzbadesktopclient.datamodel;



import java.time.LocalDate;



public class PrviUpis{	

	private Long id;	
	private float uspehSrednjaSkola;
	private float uspehPrijemni;
	private SrednjaSkola zavrsenaSrednjaSkola;
	private String strucnaSprema;
	private int godinaZavrsetkaSrednjeSkole;
	private String prelazSaViskoskolskeUstanove;
	private LocalDate datumUpisa;
	private String napomena;
	
	private String prethodnoZavrseneStudije;
	private String visokoskolsaUstanovaZavrsenihStudija;
	private String stecenoZvanje;
	private float prosecnaOcenaNaPrethodnimStudijama;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public float getUspehSrednjaSkola() {
		return uspehSrednjaSkola;
	}
	public void setUspehSrednjaSkola(float uspehSrednjaSkola) {
		this.uspehSrednjaSkola = uspehSrednjaSkola;
	}
	public float getUspehPrijemni() {
		return uspehPrijemni;
	}
	public void setUspehPrijemni(float uspehPrijemni) {
		this.uspehPrijemni = uspehPrijemni;
	}
	public SrednjaSkola getZavrsenaSrednjaSkola() {
		return zavrsenaSrednjaSkola;
	}
	public void setZavrsenaSrednjaSkola(SrednjaSkola zavrsenaSrednjaSkola) {
		this.zavrsenaSrednjaSkola = zavrsenaSrednjaSkola;
	}
	public String getStrucnaSprema() {
		return strucnaSprema;
	}
	public void setStrucnaSprema(String strucnaSprema) {
		this.strucnaSprema = strucnaSprema;
	}
	public int getGodinaZavrsetkaSrednjeSkole() {
		return godinaZavrsetkaSrednjeSkole;
	}
	public void setGodinaZavrsetkaSrednjeSkole(int godinaZavrsetkaSrednjeSkole) {
		this.godinaZavrsetkaSrednjeSkole = godinaZavrsetkaSrednjeSkole;
	}
	public String getPrelazSaViskoskolskeUstanove() {
		return prelazSaViskoskolskeUstanove;
	}
	public void setPrelazSaViskoskolskeUstanove(String prelazSaViskoskolskeUstanove) {
		this.prelazSaViskoskolskeUstanove = prelazSaViskoskolskeUstanove;
	}
	public LocalDate getDatumUpisa() {
		return datumUpisa;
	}
	public void setDatumUpisa(LocalDate datumUpisa) {
		this.datumUpisa = datumUpisa;
	}
	public String getNapomena() {
		return napomena;
	}
	public void setNapomena(String napomena) {
		this.napomena = napomena;
	}
	public String getPrethodnoZavrseneStudije() {
		return prethodnoZavrseneStudije;
	}
	public void setPrethodnoZavrseneStudije(String prethodnoZavrseneStudije) {
		this.prethodnoZavrseneStudije = prethodnoZavrseneStudije;
	}
	public String getVisokoskolsaUstanovaZavrsenihStudija() {
		return visokoskolsaUstanovaZavrsenihStudija;
	}
	public void setVisokoskolsaUstanovaZavrsenihStudija(String visokoskolsaUstanovaZavrsenihStudija) {
		this.visokoskolsaUstanovaZavrsenihStudija = visokoskolsaUstanovaZavrsenihStudija;
	}
	public String getStecenoZvanje() {
		return stecenoZvanje;
	}
	public void setStecenoZvanje(String stecenoZvanje) {
		this.stecenoZvanje = stecenoZvanje;
	}
	public float getProsecnaOcenaNaPrethodnimStudijama() {
		return prosecnaOcenaNaPrethodnimStudijama;
	}
	public void setProsecnaOcenaNaPrethodnimStudijama(float prosecnaOcenaNaPrethodnimStudijama) {
		this.prosecnaOcenaNaPrethodnimStudijama = prosecnaOcenaNaPrethodnimStudijama;
	}
	
	
	
}
