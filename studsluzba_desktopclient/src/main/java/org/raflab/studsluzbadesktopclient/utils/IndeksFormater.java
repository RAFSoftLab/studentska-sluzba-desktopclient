package org.raflab.studsluzbadesktopclient.utils;

import org.raflab.studsluzbadesktopclient.datamodel.StudentIndeks;

public class IndeksFormater {
	
	// vraca indeks u obliku smer/broj-godina
	public static String formatIndeks(StudentIndeks si) {
		if(si==null) return null;
		return si.getStudProgram()+"/"+si.getBroj()+"-"+si.getGodina();		
	}

}
