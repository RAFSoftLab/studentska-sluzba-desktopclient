package org.raflab.studsluzbadesktopclient.servercalls;

import java.util.Arrays;

import org.raflab.studsluzbadesktopclient.datamodel.ObnovaGodine;
import org.raflab.studsluzbadesktopclient.datamodel.UpisGodine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TokStudijaServisConsumer {
	
	@Autowired String baseUrl;
	
	@Autowired RestTemplate restTemplate;
	
	private final String TOKSTUDIJA_URL_PATH = "/tok";
	
	
	
	
	/*
	 * action - upis, obnova ili uplata
	 */
	private String createURL(String action, String pathEnd) {
		return baseUrl+TOKSTUDIJA_URL_PATH+"/"+action+"/"+pathEnd;
	}
	
	
	public Long saveUpis(@RequestBody UpisGodine ug) {
	      HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity <UpisGodine> entity = new HttpEntity<UpisGodine>(ug, headers);
	      
	      return restTemplate.exchange
	    		  (createURL("upis","add"), HttpMethod.POST, entity, Long.class).getBody();
	}
	
	public Long saveObnova(@RequestBody ObnovaGodine og) {
	      HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity <ObnovaGodine> entity = new HttpEntity<ObnovaGodine>(og, headers);
	      
	      return restTemplate.exchange
	    		  (createURL("obnova","add"), HttpMethod.POST, entity, Long.class).getBody();
	}
	
}
