package org.raflab.studsluzbadesktopclient.datamodel;


public class Nastavnik {	
		
		private Long id;
	    private String ime;	  // not null
		private String prezime;  // not null
		private String srednjeIme;   // not null 
		private String adresa;  // not null
		private String brojTelefona;  // not null		
		private String email;  // not null		 
		 
		
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

						
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		
				
		@Override
		public String toString() {
			return this.ime + " "+this.prezime;
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
			Nastavnik other = (Nastavnik) obj;
			if (id == null) {
				if (other.id != null)
					return false;
			} else if (!id.equals(other.id))
				return false;
			return true;
		}
		 
		
		 
		 
		 

}
