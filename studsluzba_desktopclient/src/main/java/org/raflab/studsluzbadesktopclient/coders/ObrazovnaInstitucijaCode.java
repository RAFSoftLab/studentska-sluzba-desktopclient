package org.raflab.studsluzbadesktopclient.coders;

// srednja skola ili viskoskolska ustanova kao sifra
// za sada se ne koristi
public class ObrazovnaInstitucijaCode extends AbstractCode {
	
	public ObrazovnaInstitucijaCode(String code) {
		super(code);	
	}

	private String naziv;
	private String mesto;
	private String adresa;
	private TipObrazovneInstitucije tip;

	@Override
	public String getValue() {		
		return this.naziv+", "+mesto;
	}
	
	

}
