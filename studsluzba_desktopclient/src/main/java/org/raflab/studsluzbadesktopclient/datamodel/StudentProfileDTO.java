package org.raflab.studsluzbadesktopclient.datamodel;



import java.util.List;


/*
 * objekat ove klase sadrzi sve podatke o studentu koji
 * se prikazuju u njegovom profilu  
 * 
 * - polozeni predmeti
 * - tok studija (upisi, obnove godina)
 * - predmete koje slusa
 * - prijavljeni ispiti
 * - uplate
 * 
 * - selektujemo preko indeksa, potrebno prikupiti podatke i o drugim indeksima
 * 
 */

public class StudentProfileDTO {
	
	private StudentIndeks aktivanIndeks;  
	private List<StudentIndeks> neaktivniIndeksi;
	private List<PolozenPredmet> polozeniPredmeti;
	private List<UpisGodine> upisiGodine;
	private List<ObnovaGodine> obnoveGodine;	
	private List<Uplata> uplate;
	private List<Predmet> nepolozeniPredmeti;
	
	// za aktivnu skolsku godinu
	
	private List<PrijavaIspita> prijaveIspita;	
	private List<SlusaPredmet> slusaPredmete;
	

	
	public StudentProfileDTO() {
		
	}
	
	
	public StudentProfileDTO(StudentIndeks studentIndeks) {
		this.aktivanIndeks = studentIndeks;
		
	}
	
	public StudentIndeks getAktivanIndeks() {
		return aktivanIndeks;
	}
	public void setAktivanIndeks(StudentIndeks studentIndeks) {
		this.aktivanIndeks = studentIndeks;
	}
	public List<PolozenPredmet> getPolozeniPredmeti() {
		return polozeniPredmeti;
	}
	public void setPolozeniPredmeti(List<PolozenPredmet> polozeniPredmeti) {
		this.polozeniPredmeti = polozeniPredmeti;
	}	
	public List<Uplata> getUplate() {
		return uplate;
	}
	public void setUplate(List<Uplata> uplate) {
		this.uplate = uplate;
	}
	public List<SlusaPredmet> getSlusaPredmete() {
		return slusaPredmete;
	}
	public void setSlusaPredmete(List<SlusaPredmet> slusaPredmete) {
		this.slusaPredmete = slusaPredmete;
	}
	
	public List<UpisGodine> getUpisiGodine() {
		return upisiGodine;
	}
	public void setUpisiGodine(List<UpisGodine> upisiGodine) {
		this.upisiGodine = upisiGodine;
	}
	public List<ObnovaGodine> getObnoveGodine() {
		return obnoveGodine;
	}
	public void setObnoveGodine(List<ObnovaGodine> obnoveGodine) {
		this.obnoveGodine = obnoveGodine;
	}
	public List<StudentIndeks> getNeaktivniIndeksi() {
		return neaktivniIndeksi;
	}
	public void setNeaktivniIndeksi(List<StudentIndeks> neaktivniIndeksi) {
		this.neaktivniIndeksi = neaktivniIndeksi;
	}
	public List<PrijavaIspita> getPrijaveIspita() {
		return prijaveIspita;
	}
	public void setPrijaveIspita(List<PrijavaIspita> prijaveIspita) {
		this.prijaveIspita = prijaveIspita;
	}
	
	public String getIme() {
		return getStudentPodaci().getIme();
	}
	
	public String getPrezime() {
		return getStudentPodaci().getPrezime();
	}
	
	public boolean noIndeks() {
		return this.aktivanIndeks.getStudProgram()==null || this.aktivanIndeks.getGodina()== 0;
	}
	
	public StudentPodaci getStudentPodaci() {
		return this.aktivanIndeks==null ? null : aktivanIndeks.getStudent();
	}
	
	public String getImeSrednjeSlovoPrezime() {		
		return getStudentPodaci().getIme() + " ("+getStudentPodaci().getSrednjeIme()+") "+getStudentPodaci().getPrezime();		
	}
	
	public String getJmbg() {		
		return getStudentPodaci().getJmbg();
	}
	
	public String getDatumRodjenja() {
		if(getStudentPodaci().getDatumRodjenja()==null) 
			return null;
		return getStudentPodaci().getDatumRodjenja().toString();
	}
	
	public String getMestoPrebivalista() {
		return getStudentPodaci().getMestoPrebivalista();
	}
	
	public String getAdresa() {
		return getStudentPodaci().getAdresa();
	}
	
	public String getBrojTelefona() {
		return getStudentPodaci().getBrojTelefona();		
	}
	
	public String getEmail() {
		return getStudentPodaci().getEmail();
	}


	public List<Predmet> getNepolozeniPredmeti() {
		return nepolozeniPredmeti;
	}


	public void setNepolozeniPredmeti(List<Predmet> nepolozeniPredmeti) {
		this.nepolozeniPredmeti = nepolozeniPredmeti;
	}
	
	
	
	
	
	

}
