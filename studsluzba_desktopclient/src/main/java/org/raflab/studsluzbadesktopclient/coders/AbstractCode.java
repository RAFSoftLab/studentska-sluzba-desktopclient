package org.raflab.studsluzbadesktopclient.coders;

public abstract class AbstractCode {
	
	private String code;
	
	public AbstractCode(String code) {
		this.code = code;
	}
	
	public abstract String getValue();

	public String getCode() {
		return code;
	}
	
	

}
