package org.raflab.studsluzbadesktopclient.servercalls;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.raflab.studsluzbadesktopclient.coders.SimpleCode;
import org.raflab.studsluzbadesktopclient.datamodel.NastavnaNaucnaZvanja;
import org.raflab.studsluzbadesktopclient.datamodel.SrednjaSkola;
import org.raflab.studsluzbadesktopclient.datamodel.StudentPodaci;
import org.raflab.studsluzbadesktopclient.datamodel.StudijskiProgram;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class SifarniciServisConsumer {
	
	@Autowired RestTemplate restTemplate;
	
	@Autowired String baseUrl;
	
	private final String CODER_URL_PATH = "/coder";
	
	public NastavnaNaucnaZvanja[] getSvaZvanja(){
		NastavnaNaucnaZvanja[] retVal = restTemplate.getForObject(createURL("zvanje", "all"), NastavnaNaucnaZvanja[].class);
		return retVal;
	}
	
	public List<SimpleCode> getBackendCoder(String coder){
		String[] retVal = restTemplate.getForObject(createURL(coder, "all"), String[].class);
		List<SimpleCode> rez = new ArrayList<SimpleCode>();
		for(String s:retVal) {
			rez.add(new SimpleCode(s));
		}		
		return rez;
	}
	
	public SrednjaSkola[] getSrednjeSkole(){
		SrednjaSkola[] retVal = restTemplate.getForObject(createURL("srednjaskola", "all"), SrednjaSkola[] .class);
		return retVal;
	}
	
	public Long saveSrednjaSkola(@RequestBody SrednjaSkola ss) {
	      HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity <SrednjaSkola> entity = new HttpEntity<SrednjaSkola>(ss, headers);
	      
	      return restTemplate.exchange
	    		  (createURL("srednjaskola","add"), HttpMethod.POST, entity, Long.class).getBody();
	}
	
	private String createURL(String coderType, String pathEnd) {
		return baseUrl+CODER_URL_PATH+"/"+coderType+"/"+pathEnd;
	}
	
}
