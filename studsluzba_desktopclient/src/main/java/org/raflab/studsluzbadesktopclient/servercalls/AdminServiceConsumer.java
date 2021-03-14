package org.raflab.studsluzbadesktopclient.servercalls;

import java.util.Arrays;
import java.util.List;

import org.raflab.studsluzbadesktopclient.datamodel.SkolskaGodina;
import org.raflab.studsluzbadesktopclient.datamodel.StudentIndeks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class AdminServiceConsumer {
	
	@Autowired RestTemplate restTemplate;
	
	@Autowired String baseUrl;
	
	private final String ADMIN_URL_PATH = "/admin";
	
	/*
	 * action - upis, obnova ili uplata
	 */
	private String createURL(String entitet, String pathEnd) {
		return baseUrl+ADMIN_URL_PATH+"/"+entitet+"/"+pathEnd;
	}
	
	
	
		
	public SkolskaGodina getAktivnaSkolskaGodina() {  	     	      	
	      UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(createURL("skolskagodina", "aktivna"));	    		  
	      ResponseEntity<SkolskaGodina> response = restTemplate.getForEntity(builder.toUriString(), SkolskaGodina.class, HttpMethod.GET);
	      if(response.getStatusCode()==HttpStatus.OK)
	    	  return response.getBody();
	      else return null;
	}
	
	public List<SkolskaGodina> getSkolskeGodine(){
		SkolskaGodina[] skolskeGodine = restTemplate.getForObject(createURL("skolskagodina", "all"), SkolskaGodina[].class);
		return List.of(skolskeGodine);
	}
	    
	public Long saveSkolskaGodina(@RequestBody SkolskaGodina sg) {
	      HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity <SkolskaGodina> entity = new HttpEntity<SkolskaGodina>(sg, headers);
	      
	      return restTemplate.exchange
	    		  (createURL("skolskagodina","add"), HttpMethod.POST, entity, Long.class).getBody();
	}
	
	
	
	

}
