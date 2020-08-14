package org.raflab.studsluzbadesktopclient.datamodel;

import java.time.LocalDate;


public class StudentPodaci {	
	
	    private String ime;	  // not null
		private String prezime;  // not null
		private String srednjeIme;   // not null 
		private String jmbg;    
		private LocalDate datumRodjenja;  // not null
		private String mestoRodjenjaCode; 
		private String mestoPrebivalistaCode;  // not null
		private String drzavaRodjenjaCode;   
		private String drzavljanstvoCode;   // not null
		private String nacionalnost;   // samoizjasnjavanje, moze bilo sta  
		private char pol;    // not null
		private String adresa;  // not null
		private String brojTelefona;  // not null		
		private String email;  // not null
		private String brojLicneKarte; 
		private String licnuKartuIzdao;
		private String mestoStanovanjaCode;
		private String adresaStanovanja;
	
		 
		 
		
		public String getIme() {
			return ime;
		}
		public void setIme(String ime) {
			this.ime = ime;
		}
		public String getPrezime() {
			return prezime;
		}
		public void setPrezime(String prezime) {
			this.prezime = prezime;
		}
		public String getSrednjeIme() {
			return srednjeIme;
		}
		public void setSrednjeIme(String srednjeIme) {
			this.srednjeIme = srednjeIme;
		}
		public String getJmbg() {
			return jmbg;
		}
		public void setJmbg(String jmbg) {
			this.jmbg = jmbg;
		}
		public LocalDate getDatumRodjenja() {
			return datumRodjenja;
		}
		public void setDatumRodjenja(LocalDate datumRodjenja) {
			this.datumRodjenja = datumRodjenja;
		}
		public String getMestoRodjenjaCode() {
			return mestoRodjenjaCode;
		}
		public void setMestoRodjenjaCode(String mestoRodjenjaCode) {
			this.mestoRodjenjaCode = mestoRodjenjaCode;
		}
		public String getMestoPrebivalistaCode() {
			return mestoPrebivalistaCode;
		}
		public void setMestoPrebivalistaCode(String mestoPrebivalistaCode) {
			this.mestoPrebivalistaCode = mestoPrebivalistaCode;
		}
		public String getDrzavaRodjenjaCode() {
			return drzavaRodjenjaCode;
		}
		public void setDrzavaRodjenjaCode(String drzavaRodjenjaCode) {
			this.drzavaRodjenjaCode = drzavaRodjenjaCode;
		}
		public String getDrzavljanstvoCode() {
			return drzavljanstvoCode;
		}
		public void setDrzavljanstvoCode(String drzavljanstvoCode) {
			this.drzavljanstvoCode = drzavljanstvoCode;
		}
		public String getNacionalnost() {
			return nacionalnost;
		}
		public void setNacionalnost(String nacionalnost) {
			this.nacionalnost = nacionalnost;
		}
		public char getPol() {
			return pol;
		}
		public void setPol(char pol) {
			this.pol = pol;
		}
		public String getAdresa() {
			return adresa;
		}
		public void setAdresa(String adresa) {
			this.adresa = adresa;
		}
		public String getBrojTelefona() {
			return brojTelefona;
		}
		public void setBrojTelefona(String brojTelefona) {
			this.brojTelefona = brojTelefona;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getBrojLicneKarte() {
			return brojLicneKarte;
		}
		public void setBrojLicneKarte(String brojLicneKarte) {
			this.brojLicneKarte = brojLicneKarte;
		}
		public String getLicnuKartuIzdao() {
			return licnuKartuIzdao;
		}
		public void setLicnuKartuIzdao(String licnuKartuIzdao) {
			this.licnuKartuIzdao = licnuKartuIzdao;
		}
		public String getMestoStanovanjaCode() {
			return mestoStanovanjaCode;
		}
		public void setMestoStanovanjaCode(String mestoStanovanjaCode) {
			this.mestoStanovanjaCode = mestoStanovanjaCode;
		}
		public String getAdresaStanovanja() {
			return adresaStanovanja;
		}
		public void setAdresaStanovanja(String adresaStanovanja) {
			this.adresaStanovanja = adresaStanovanja;
		}
		@Override
		public String toString() {
			return "StudentPodaci [ime=" + ime + ", prezime=" + prezime + ", srednjeIme=" + srednjeIme + ", jmbg="
					+ jmbg + ", datumRodjenja=" + datumRodjenja + ", mestoRodjenjaCode=" + mestoRodjenjaCode
					+ ", mestoPrebivalistaCode=" + mestoPrebivalistaCode + ", drzavaRodjenjaCode=" + drzavaRodjenjaCode
					+ ", drzavljanstvoCode=" + drzavljanstvoCode + ", nacionalnost=" + nacionalnost + ", pol=" + pol
					+ ", adresa=" + adresa + ", brojTelefona=" + brojTelefona + ", email=" + email + ", brojLicneKarte="
					+ brojLicneKarte + ", licnuKartuIzdao=" + licnuKartuIzdao + ", mestoStanovanjaCode="
					+ mestoStanovanjaCode + ", adresaStanovanja=" + adresaStanovanja + "]";
		}
		 
		
		 
		 
		 

}