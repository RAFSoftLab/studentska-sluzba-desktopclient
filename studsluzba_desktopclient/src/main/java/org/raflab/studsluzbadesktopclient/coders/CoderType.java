package org.raflab.studsluzbadesktopclient.coders;

public enum CoderType {
	
	MESTO(TextFileSimpleCoder.class,"coders/mesta.txt"),
	DRZAVLJANSTVO,
	DRZAVA (TextFileSimpleCoder.class,"coders/drzave.txt"),
	TIP_SREDNJE_SKOLE(TextFileSimpleCoder.class,"coders/tipsrednjeskole.txt"),
	VISOKOSKOLSKA_USTANOVA,
	NASTAVNO_ZVANJE(TextFileSimpleCoder.class,"coders/nastavnasaradnickazvanja.txt"),
	VRSTA_STUDIJA ,
	UZA_NAUCNA_OBLAST,
	STUDIJSKI_PROGRAM (BackendSimpleCoder.class, "studprogram/oznaka"),
	ISPITNI_ROK;
	
	private CoderType(Class<? extends Coder<? extends AbstractCode>> klasa, String path) {
		this.tip = klasa;
		this.path = path;
	}
	
	private CoderType() {
		
	}
	
	public Class<? extends Coder<? extends AbstractCode>> getTip() {
		return tip;
	}
	public void setTip(Class<? extends Coder<? extends AbstractCode>> tip) {
		this.tip = tip;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	private Class<? extends Coder<? extends AbstractCode>> tip;
	private String path; // fajl za tekst file codere ili REST path za backend sifarnike
	
	
	
}
