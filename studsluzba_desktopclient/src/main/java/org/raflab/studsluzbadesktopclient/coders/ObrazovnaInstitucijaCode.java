package org.raflab.studsluzbadesktopclient.coders;

// srednja skola ili viskoskolska ustanova
public class ObrazovnaInstitucijaCode extends AbstractCode {
	
	public ObrazovnaInstitucijaCode(String code) {
		super(code);	
	}

	private String naziv;
	private SimpleCodeValue mesto;
	private String adresa;
	private TipObrazovneInstitucije tip;

	@Override
	public String getValue() {		
		return this.naziv+", "+mesto.getValue();
	}
	
	

}
