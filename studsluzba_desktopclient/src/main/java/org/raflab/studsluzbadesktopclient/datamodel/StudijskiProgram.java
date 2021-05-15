package org.raflab.studsluzbadesktopclient.datamodel;

public class StudijskiProgram {	
		
	    
		private Long id;
		private String oznaka;  // RN, RM   
		private String naziv;   
		private int godinaAkreditacije;
		private String zvanje;
		private int trajanjeGodina;
		private int trajanjeSemestara;
		private String vrstaStudija; // OAS - osnovne akademske studje, OSS - osnovne strukovne, 	MAS - master akademske studije
		
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getOznaka() {
			return oznaka;
		}
		public void setOznaka(String oznaka) {
			this.oznaka = oznaka;
		}
		public String getNaziv() {
			return naziv;
		}
		public void setNaziv(String naziv) {
			this.naziv = naziv;
		}
		public int getGodinaAkreditacije() {
			return godinaAkreditacije;
		}
		public void setGodinaAkreditacije(int godinaAkreditacije) {
			this.godinaAkreditacije = godinaAkreditacije;
		}
		public String getZvanje() {
			return zvanje;
		}
		public void setZvanje(String zvanje) {
			this.zvanje = zvanje;
		}
		public int getTrajanjeGodina() {
			return trajanjeGodina;
		}
		public void setTrajanjeGodina(int trajanjeGodina) {
			this.trajanjeGodina = trajanjeGodina;
		}
		public int getTrajanjeSemestara() {
			return trajanjeSemestara;
		}
		public void setTrajanjeSemestara(int trajanjeSemestara) {
			this.trajanjeSemestara = trajanjeSemestara;
		}
		public String getVrstaStudija() {
			return vrstaStudija;
		}
		public void setVrstaStudija(String vrstaStudija) {
			this.vrstaStudija = vrstaStudija;
		}
		
		@Override
		public String toString() {
			return oznaka + "-" + vrstaStudija +"-"+naziv + " ["+godinaAkreditacije+"]";
		}
		
}
