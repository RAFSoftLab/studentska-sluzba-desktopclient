package org.raflab.studsluzbadesktopclient.servercalls;

import java.util.Arrays;
import java.util.List;


import org.raflab.studsluzbadesktopclient.datamodel.StudijskiProgram;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class StudProgramiServiceConsumer {
@Autowired RestTemplate restTemplate;
	
	@Autowired String baseUrl;
	
	private final String STUDPROGRAMI_URL_PATH = "/studprogram";
	
	private String createURL(String type, String pathEnd) {
		return baseUrl+STUDPROGRAMI_URL_PATH+"/"+type+"/"+pathEnd;
	}
	
	public List<StudijskiProgram> getSudijskiProgramiSorted(){
		StudijskiProgram[] retVal = restTemplate.getForObject(createURL("all", "sorted"), StudijskiProgram[] .class);
		return Arrays.asList(retVal);
	}
	
}
