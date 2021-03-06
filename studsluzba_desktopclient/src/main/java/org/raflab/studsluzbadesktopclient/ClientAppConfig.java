package org.raflab.studsluzbadesktopclient;


import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.raflab.studsluzbadesktopclient.datamodel.SkolskaGodina;
import org.raflab.studsluzbadesktopclient.servercalls.AdminServiceConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ClientAppConfig {
	@Bean
    public RestTemplate getRestTemplate() {
       return new RestTemplate();
    }
    
	@Bean
    public String getBaseUrl() {
       return "http://localhost:8080";
    }
	
		
	@PostConstruct
    public void init() {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));        
    }
	
	@Autowired
	AdminServiceConsumer adminServiceConsumer;
			
	@Bean	
	public SkolskaGodina getAktivnaSkolskaGodina() {
		return adminServiceConsumer.getAktivnaSkolskaGodina();
	}
	
}
