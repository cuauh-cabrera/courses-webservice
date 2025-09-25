package com.webservice.soap.repository;

import java.util.List;
import java.util.Optional;

import com.cuauh_cabrera.courses.CourseDetails;
import com.webservice.soap.dto.CreateCourseDetailsDto;
import com.webservice.soap.dto.UpdateCourseDetailsDto;
import com.webservice.soap.entity.CourseDetailsEntity;

public interface ICourseDetailsRepository {
	
	/**
	 * Find all Courses
	 * @return a list with all course and its details
	 */
	List<CourseDetails> findAll();
		
	/**
	 * Find a CourseDetails entity by its Id
	 * @param id of the CourseEntity to query
	 * @return a CourseDetails entity or an empty Optional if Id is not found
	 */
	Optional<CourseDetails> findById(Long id);
	
	/**
	 * Insert a new CourseDetails entity in the database
	 * @param courseDetailsDto with the new CourseDetails entity information
	 * @return a new CourseDetailsEntity
	 */
	CourseDetailsEntity insert(CreateCourseDetailsDto courseDetailsDto);
	
	/**
	 * Update the information of the specified CourseDetails entity 
	 * @param updateCourseDetailsDto with the information be updated
	 */
	void update(UpdateCourseDetailsDto updateCourseDetailsDto);
	
	/**
	 * Set the status (TRUE | FALSE) of the specified CourseDetails entity 
	 * @param id of the CourseDetails entity to be updated 
	 * @param status (TRUE | FALSE)
	 */
	void setIsActive(Long id, boolean status);
		
	/**
	 * Delete the specified CourseDetails entity from the Database (Hard Delete)
	 * @param id of the CourseDetails entity to be hard deleted from the Database
	 */
	void delete(Long id);
}
