package org.raflab.studsluzbadesktopclient.servercalls;

import org.raflab.studsluzba_desktopclient.datamodel.StudentPodaci;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class StudentServerCalls {
	

	
	public static String saveStudentPosaci(StudentPodaci studentPodaci) {
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			String studentJson = mapper.writeValueAsString(studentPodaci);
			System.out.println(studentJson);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}

}
