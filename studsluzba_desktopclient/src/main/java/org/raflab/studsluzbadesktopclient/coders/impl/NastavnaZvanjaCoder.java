package org.raflab.studsluzbadesktopclient.coders.impl;

import org.raflab.studsluzbadesktopclient.coders.Coder;
import org.raflab.studsluzbadesktopclient.coders.SimpleCode;
import org.raflab.studsluzbadesktopclient.datamodel.NastavnaNaucnaZvanja;
import org.raflab.studsluzbadesktopclient.servercalls.SifarniciServisConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NastavnaZvanjaCoder extends Coder<SimpleCode> {
	
	@Autowired SifarniciServisConsumer serviceConsumer;
	
	@Override
	protected void loadCodes() {
		/*for(NastavnaNaucnaZvanja nz: serviceConsumer.getSvaZvanja())
			System.out.println(nz.getZvanje());
		*/
	}

}
