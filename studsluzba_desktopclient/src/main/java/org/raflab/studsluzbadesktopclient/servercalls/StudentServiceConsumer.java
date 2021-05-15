package org.raflab.studsluzbadesktopclient.servercalls;


import java.util.Arrays;
import java.util.List;

import org.raflab.studsluzbadesktopclient.datamodel.StudentDTO;
import org.raflab.studsluzbadesktopclient.datamodel.StudentIndeks;
import org.raflab.studsluzbadesktopclient.datamodel.StudentPodaci;
import org.raflab.studsluzbadesktopclient.datamodel.StudentProfileDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
public class StudentServiceConsumer {
	
	@Autowired RestTemplate restTemplate;
	
	@Autowired String baseUrl;
	
	private final String STUDENT_URL_PATH = "/student"; 
	
	public Long saveStudent(@RequestBody StudentPodaci sp) {
	      HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity <StudentPodaci> entity = new HttpEntity<StudentPodaci>(sp, headers);
	      
	      return restTemplate.exchange
	    		  (createURL("add"), HttpMethod.POST, entity, Long.class).getBody();
	}
	
	public Long saveStudentIndeks(@RequestBody StudentIndeks si) {
	      HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity <StudentIndeks> entity = new HttpEntity<StudentIndeks>(si, headers);
	      
	      return restTemplate.exchange
	    		  (createURL("saveindeks"), HttpMethod.POST, entity, Long.class).getBody();
	}
	
	private String createURL(String pathEnd) {
		return baseUrl+STUDENT_URL_PATH+"/"+pathEnd;
	}
	
	public StudentIndeks fastSearchByIndeks(String indeksShort) {  	     	      	
	      UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(createURL("fastsearch"))
	    		  .queryParam("indeksShort", indeksShort);
	      ResponseEntity<StudentIndeks> response = restTemplate.getForEntity(builder.toUriString(), StudentIndeks.class, HttpMethod.GET);
	      if(response.getStatusCode()==HttpStatus.OK)
	    	  return response.getBody();
	      else return null;    
	    		  
	}
	
	public List<StudentDTO> searchStudent(String ime, String prezime, Integer godinaUpisa, String studProgram, Integer broj) {  	      	
	      UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(createURL("search"));
	      
			
		  if(ime!=null) builder.queryParam("ime", ime);			
		  if(prezime!=null) builder.queryParam("prezime", prezime);	     // TODO ne radi pretraživanje sa načim slovima			
	      if(godinaUpisa!=null) builder.queryParam("godina", godinaUpisa);
	      if(studProgram!=null) builder.queryParam("studProgram", studProgram);
	      if(broj!=null) builder.queryParam("broj", broj);     	    		  
	      ResponseEntity<StudentDTO[]> response = restTemplate.getForEntity(builder.toUriString(), StudentDTO[].class, HttpMethod.GET);
	      if(response.getStatusCode()==HttpStatus.OK)
	    	  return List.of(response.getBody());
	      else return null;  	    		  
	}
	
	public StudentIndeks getIndeksById(Long id) {  	     	      	
	      UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(createURL("indeks")+"/"+id);	    		  
	      ResponseEntity<StudentIndeks> response = restTemplate.getForEntity(builder.toUriString(), StudentIndeks.class, HttpMethod.GET);
	      if(response.getStatusCode()==HttpStatus.OK)
	    	  return response.getBody();
	      else return null;   	    		  
	}
	
	public StudentPodaci getStudentById(Long id) {  	     	      	
	      UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(createURL("podaci")+"/"+id);	    		  
	      ResponseEntity<StudentPodaci> response = restTemplate.getForEntity(builder.toUriString(), StudentPodaci.class, HttpMethod.GET);
	      if(response.getStatusCode()==HttpStatus.OK)
	    	  return response.getBody();
	      else return null;   	    		  
	}
	
	public StudentProfileDTO getStudentProfileForIndeksId(Long id) {
		 UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(createURL("profile")+"/"+id);	    		  
	      ResponseEntity<StudentProfileDTO> response = restTemplate.getForEntity(builder.toUriString(), StudentProfileDTO.class, HttpMethod.GET);
	      if(response.getStatusCode()==HttpStatus.OK)
	    	  return response.getBody();
	      else return null; 	
	}
	
	public List<StudentIndeks> getIndeksiForStudentPodaci(Long idStudentPodaci){
		StudentIndeks[] indeksi = restTemplate.getForObject(createURL("indeksi/"+idStudentPodaci), StudentIndeks[].class);
		return Arrays.asList(indeksi);       
	     
	}
	
	
}
