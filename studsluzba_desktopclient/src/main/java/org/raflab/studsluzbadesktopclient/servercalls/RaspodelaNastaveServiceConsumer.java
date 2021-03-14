package org.raflab.studsluzbadesktopclient.servercalls;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.raflab.studsluzbadesktopclient.datamodel.DrziPredmet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RaspodelaNastaveServiceConsumer {
	
	@Autowired RestTemplate restTemplate;
	
	@Autowired String baseUrl;
	
	private final String RASPODELA_NASTAVE_URL_PATH = "/raspodelanastave"; 

	private String createURL(String entitet, String pathEnd) {
		return baseUrl+RASPODELA_NASTAVE_URL_PATH+"/"+entitet+ (!pathEnd.equals("") ? "/"+pathEnd : "");
	}
	
	public List<DrziPredmet> getDrziPredmetUAktivnojSkolskojGodini(){
		DrziPredmet[] drziPredmetList = restTemplate.getForObject(createURL("drzipredmet", "aktivna/all"), DrziPredmet[].class);
		return List.of(drziPredmetList);
	}
	
	public Long saveDrziPredmet(@RequestBody DrziPredmet dp) {
	      HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity <DrziPredmet> entity = new HttpEntity<DrziPredmet>(dp, headers);
	      
	      return restTemplate.exchange
	    		  (createURL("drzipredmet","add"), HttpMethod.POST, entity, Long.class).getBody();
	}
	
	public void deleteDrziPredmet(Long id) {		
	     restTemplate.delete(createURL("drzipredmet",String.valueOf(id)));      
	}
}
