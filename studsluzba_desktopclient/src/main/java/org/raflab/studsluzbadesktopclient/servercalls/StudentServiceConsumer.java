package org.raflab.studsluzbadesktopclient.servercalls;


import java.util.Arrays;

import org.raflab.studsluzba_desktopclient.datamodel.StudentPodaci;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(path = "/student")
public class StudentServiceConsumer {
	
	@Autowired RestTemplate restTemplate;
	
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String saveStudent(@RequestBody StudentPodaci sp) {
	      HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity <StudentPodaci> entity = new HttpEntity<StudentPodaci>(sp, headers);
	      
	      return restTemplate.exchange
	    		  ("http://localhost:8080/student/add", HttpMethod.POST, entity, String.class).getBody();
	   }
	
}
