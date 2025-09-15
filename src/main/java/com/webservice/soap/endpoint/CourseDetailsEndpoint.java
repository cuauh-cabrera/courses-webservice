package com.webservice.soap.endpoint;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.cuauh_cabrera.courses.GetAllCourseDetailsRequest;
import com.cuauh_cabrera.courses.GetAllCourseDetailsResponse;
import com.cuauh_cabrera.courses.GetCourseDetailsRequest;
import com.cuauh_cabrera.courses.GetCourseDetailsResponse;
import com.webservice.soap.service.ICourseDetailsService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Endpoint
public class CourseDetailsEndpoint {
	
	private final ICourseDetailsService courseDetailsService;
		
	public CourseDetailsEndpoint(ICourseDetailsService courseDetailsService) {
		this.courseDetailsService = courseDetailsService;
	}
	
	@PayloadRoot(namespace="http://cuauh-cabrera.com/courses", localPart="GetAllCourseDetailsRequest")
	@ResponsePayload
	public GetAllCourseDetailsResponse processAllCourseDetailsRequest(@RequestPayload GetAllCourseDetailsRequest request) {
		
		log.info("Processing Request to retrieve a list with all the Courses");
		
		return courseDetailsService.findAllCourses(request);
	}

	/**
	 * 
	 * @param request
	 * @return
	 */
	@PayloadRoot(namespace="http://cuauh-cabrera.com/courses", localPart="GetCourseDetailsRequest")
	@ResponsePayload
	public GetCourseDetailsResponse processCourseDetailsRequest(@RequestPayload GetCourseDetailsRequest request) {
		
		log.info("Processing request to retrive Course Deatils Information");
				
		return courseDetailsService.findCourseById(request);
	}

}
