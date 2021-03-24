package org.raflab.studsluzbadesktopclient.servercalls;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.raflab.studsluzbadesktopclient.datamodel.DrziPredmet;
import org.raflab.studsluzbadesktopclient.datamodel.Ispit;
import org.raflab.studsluzbadesktopclient.datamodel.IspitniRok;
import org.raflab.studsluzbadesktopclient.datamodel.PrijavaIspita;
import org.raflab.studsluzbadesktopclient.datamodel.StudentIndeks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class IspitiServiceConsumer {
	
	@Autowired RestTemplate restTemplate;
	
	@Autowired String baseUrl;
	
	private final String ISPITI_URL_PATH = "/ispiti";
	
	
	
	private String createURL(String entitet, String pathEnd) {
		return baseUrl+ISPITI_URL_PATH+"/"+entitet+"/"+(!pathEnd.equals("") ? "/"+pathEnd : "");
	}
	
	
	public List<IspitniRok> getIspitniRokoviForAktivna(){
		IspitniRok[] rokovi = restTemplate.getForObject(createURL("ispitnirok", "aktivna/all"), IspitniRok[].class);
		return Arrays.asList(rokovi);
	}
	
	public List<Ispit> getIspitiForRok(Long idRoka){
		Ispit[] ispiti = restTemplate.getForObject(createURL("allforrok", String.valueOf(idRoka)),Ispit[].class);
		return Arrays.asList(ispiti);
	}
	
	public Long saveIspitniRok(@RequestBody IspitniRok ir) {
	      HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity <IspitniRok> entity = new HttpEntity<IspitniRok>(ir, headers);
	      
	      return restTemplate.exchange
	    		  (createURL("ispitnirok","add"), HttpMethod.POST, entity, Long.class).getBody();
	}
	
	public Long saveIspit(@RequestBody Ispit i) {
	      HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity <Ispit> entity = new HttpEntity<Ispit>(i, headers);
	      
	      return restTemplate.exchange
	    		  (createURL("add",""), HttpMethod.POST, entity, Long.class).getBody();
	}	
	
	public void deleteIspitniRok(Long id) {
		restTemplate.delete(createURL("ispitnirok",String.valueOf(id)));   
	}
	
	public List<StudentIndeks> getPrijavljeniZaIspit(Long idIspita){
		StudentIndeks[] prijavljeni = restTemplate.getForObject(createURL("prijavljeni",String.valueOf(idIspita)),StudentIndeks[].class);
		return Arrays.asList(prijavljeni);		
	}
	
	public List<StudentIndeks> getNeprijavljeniZaIspit(Long idIspita){
		StudentIndeks[] neprijavljeni = restTemplate.getForObject(createURL("neprijavljeni",String.valueOf(idIspita)),StudentIndeks[].class);
		return Arrays.asList(neprijavljeni);		
	}
	
	public Long savePrijava(@RequestBody PrijavaIspita pi) {
	      HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity <PrijavaIspita> entity = new HttpEntity<PrijavaIspita>(pi, headers);
	      
	      return restTemplate.exchange
	    		  (createURL("prijava","add"), HttpMethod.POST, entity, Long.class).getBody();
	}	
	
	
}
