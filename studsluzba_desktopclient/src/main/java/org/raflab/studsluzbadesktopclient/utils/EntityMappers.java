package org.raflab.studsluzbadesktopclient.utils;

import org.raflab.studsluzbadesktopclient.datamodel.ObnovaGodine;
import org.raflab.studsluzbadesktopclient.datamodel.TokStudija;
import org.raflab.studsluzbadesktopclient.datamodel.UpisGodine;

public class EntityMappers {
	
	
	public static TokStudija toTokStudija(UpisGodine upis) {
		TokStudija	ts = new TokStudija("upis",upis.getDatumUpisa(), upis.getGodinaKojaSeUpisuje(), upis.getNapomena());
		ts.setUpis(upis);
		return ts;
	}
	
	
	public static TokStudija toTokStudija(ObnovaGodine obnova) {
		TokStudija	ts = new TokStudija("obnova",obnova.getDatumObnove(), obnova.getGodinaKojuObnavlja(), obnova.getNapomena());
		ts.setObnova(obnova);;
		return ts;
	}
	
	
}
