package org.raflab.studsluzbadesktopclient.datamodel;



import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;


public class Ispit {
	

	private Long id;
	private LocalDate datumOdrzavanja;  
	private LocalTime vremeOdrzavanja;
	private String mestoOdrzavanja;  // ne mora da se unosi
	
	
	private DrziPredmet drziPredmet;

	private IspitniRok ispitniRok;

	private Set<PrijavaIspita> prijave;
	
	private LocalDate datumPredajeZapisnika;
	private LocalDate datumVerifikacije;
	
	public LocalDate getDatumOdrzavanja() {
		return datumOdrzavanja;
	}
	public void setDatumOdrzavanja(LocalDate datumOdrzavanja) {
		this.datumOdrzavanja = datumOdrzavanja;
	}
	public String getMestoOdrzavanja() {
		return mestoOdrzavanja;
	}
	public void setMestoOdrzavanja(String mestoOdrzavanja) {
		this.mestoOdrzavanja = mestoOdrzavanja;
	}
	
		
	public IspitniRok getIspitniRok() {
		return ispitniRok;
	}
	public void setIspitniRok(IspitniRok ispitniRok) {
		this.ispitniRok = ispitniRok;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Set<PrijavaIspita> getPrijave() {
		return prijave;
	}
	public void setPrijave(Set<PrijavaIspita> prijave) {
		this.prijave = prijave;
	}
	public DrziPredmet getDrziPredmet() {
		return drziPredmet;
	}
	public void setDrziPredmet(DrziPredmet drziPredmet) {
		this.drziPredmet = drziPredmet;
	}
	
	public String getNastavnik() {
		return drziPredmet.getNastavnik().toString();
	}
	
	public String getPredmet() {
		return drziPredmet.getPredmet().toString();
	}
	public LocalTime getVremeOdrzavanja() {
		return vremeOdrzavanja;
	}
	public void setVremeOdrzavanja(LocalTime vremeOdrzavanja) {
		this.vremeOdrzavanja = vremeOdrzavanja;
	}
	
	
	@Override
	public String toString() {
		return "Ispit: " + drziPredmet.getPredmet().getNaziv()+" " + drziPredmet.getNastavnik() + ", datum: " + datumOdrzavanja + ", vreme: " + vremeOdrzavanja ;
	}
	public LocalDate getDatumPredajeZapisnika() {
		return datumPredajeZapisnika;
	}
	public void setDatumPredajeZapisnika(LocalDate datumPredajeZapisnika) {
		this.datumPredajeZapisnika = datumPredajeZapisnika;
	}
	public LocalDate getDatumVerifikacije() {
		return datumVerifikacije;
	}
	public void setDatumVerifikacije(LocalDate datumVerifikacije) {
		this.datumVerifikacije = datumVerifikacije;
	}
	
	
	
	
}
