package com.webservice.soap.service;

import com.cuauh_cabrera.courses.CreateCourseDetailsRequest;
import com.cuauh_cabrera.courses.CreateCourseDetailsResponse;
import com.cuauh_cabrera.courses.GetAllCourseDetailsRequest;
import com.cuauh_cabrera.courses.GetAllCourseDetailsResponse;
import com.cuauh_cabrera.courses.GetCourseDetailsRequest;
import com.cuauh_cabrera.courses.GetCourseDetailsResponse;

public interface ICourseDetailsService {
	
	/**
	 * Retrieve a List with all the Courses
	 * @param request a GetAllCourseDetailsRequest
	 * @return GetAllCourseDetailsResponse with a list of all Courses and their course details
	 */
	GetAllCourseDetailsResponse findAllCourses(GetAllCourseDetailsRequest request);
	
	/**
	 * Retrieve a Course by its Id
	 * @param request a GetCourseDetailsRequest with the Id of the Course to be searched
	 * @return GetCourseDetailsResponse with the CourseDeatils info if found or a message if not
	 */
	GetCourseDetailsResponse findCourseById(GetCourseDetailsRequest request);
	
	/**
	 * Create a new Course 
	 * @param request payload with the new CourseDetails information
	 * @return CreateCourseDetailsResponse with operation status message
	 */
	CreateCourseDetailsResponse createCourse(CreateCourseDetailsRequest request);

}
