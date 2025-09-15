package com.webservice.soap.repository;

import java.util.List;
import java.util.Optional;

import com.cuauh_cabrera.courses.CourseDetails;
import com.webservice.soap.dto.UpdateCourseDetailsDto;

public interface ICourseDetailsRepository {
	
	/**
	 * Find all Courses
	 * @return a list with all course and its details
	 */
	List<CourseDetails> findAllCourses();
		
	/**
	 * Find a Course by its Id
	 * @param id of the Course
	 * @return a Course Details object or an empty Optional if not found
	 */
	Optional<CourseDetails> findById(Long id);
	
	/**
	 * Update the Course Details for a given Course Id
	 * @param updateCourseDetailsDto
	 */
	void updateCourse(UpdateCourseDetailsDto updateCourseDetailsDto);
	
	/**
	 * Set the status of a Course
	 * @param id of the Course to set the status
	 * @param the status to be settled
	 */
	void setCourseStatus(Long id, boolean status);
		
	/**
	 * Delete the provided Course from the Database (Hard Delete)
	 * This is a destructive operation
	 * @param id of the Course to be removed from the Database
	 */
	void deleteCourse(Long id);
}
