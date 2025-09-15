package com.webservice.soap.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cuauh_cabrera.courses.GetAllCourseDetailsRequest;
import com.cuauh_cabrera.courses.GetAllCourseDetailsResponse;
import com.cuauh_cabrera.courses.GetCourseDetailsRequest;
import com.cuauh_cabrera.courses.GetCourseDetailsResponse;
import com.webservice.soap.mapper.CourseDetailsDataMapper;
import com.webservice.soap.repository.ICourseDetailsRepository;
import com.webservice.soap.service.ICourseDetailsService;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service
public class CourseDetailsServiceImpl  implements ICourseDetailsService{
	
	private final ICourseDetailsRepository courseDetailsRepository;
	private final CourseDetailsDataMapper courseDetailsDataMapper;
		
	public CourseDetailsServiceImpl(ICourseDetailsRepository courseDetailsRepository,
									CourseDetailsDataMapper courseDetailsDataMapper) {
		this.courseDetailsRepository = courseDetailsRepository;
		this.courseDetailsDataMapper = courseDetailsDataMapper;
	}

	@Override
	public GetAllCourseDetailsResponse findAllCourses(GetAllCourseDetailsRequest request) {
		try {
			log.debug("Retrieving the list of all Courses");
			
			var courseList = courseDetailsRepository.findAllCourses();
			
			if(courseList.isEmpty()) {
				log.warn("No Courses were retrieved. Courses list is empty");
				throw new RuntimeException("No Courses were retrieved. Courses list is emtpy");
			}
			
			GetAllCourseDetailsResponse response = new GetAllCourseDetailsResponse();
			response.getCourseDetails().addAll(courseList);
			
			return response;
			
		}catch (Exception e) {
			log.error("Error retrieving all the Courses");
			throw new RuntimeException("Unable to retrieve the list of Courses " + e.getMessage());
		}
		
	}

	@Override
	public GetCourseDetailsResponse findCourseById(GetCourseDetailsRequest request) {
		try {
			log.debug("Retrieving Course with Id:{}", request.getId());
			
			var courseOptional = courseDetailsRepository.findById((long) request.getId());
			
			if(courseOptional.isEmpty()) {
				log.warn("No Course found with Id:{}", request.getId());
				throw new RuntimeException("No Course found with Id: " + request.getId());
			}
			
			log.info("Found Course with Id:{}", request.getId());
			
			var courseDetails = courseOptional.get();
			
			GetCourseDetailsResponse response = new GetCourseDetailsResponse();
			
			response.setCourseDetails(courseDetails);
			return response;	
			
		}catch (Exception e) {
			log.error("Error retriving Course Details");
			throw new RuntimeException("Error retrieving Course. " + e.getMessage());
		}
	}
	
	
}
