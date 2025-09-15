package com.webservice.soap.mapper;

import org.springframework.stereotype.Component;

import com.cuauh_cabrera.courses.CourseDetails;
import com.webservice.soap.dto.UpdateCourseDetailsDto;
import com.webservice.soap.entity.CourseDetailsEntity;

@Component
public class CourseDetailsDataMapper {
	
	
	/**
	 * Maps a Course Details JPA Entity into a Course Details Domain Object  
	 * @param courseDetailsEntity the JPA Entity
	 * @return a CourseDetails Domain object
	 */
	public CourseDetails courseDetailsEntityToCourseDetails(CourseDetailsEntity courseDetailsEntity) {
				
		CourseDetails courseDetails = new CourseDetails();
	
		courseDetails.setId(courseDetailsEntity.getId().intValue());
		courseDetails.setName(courseDetailsEntity.getName());
		courseDetails.setDescription(courseDetailsEntity.getDescription());
		courseDetails.setIsActive(courseDetailsEntity.getIsActive().booleanValue());
		
		return courseDetails;
	}
		
	/**
	 * Maps an UpdateCourseDetailsDto into a CourseDetailsEntity
	 * @param updateCourseDetailsDto 
	 * @return a CourseDetailsEntity
	 */
	public CourseDetailsEntity updateCourseDetailsDtoToCourseDetailsEntity(UpdateCourseDetailsDto updateCourseDetailsDto) {
		
		return CourseDetailsEntity.builder()
				.id(updateCourseDetailsDto.getId())
				.name(updateCourseDetailsDto.getName())
				.description(updateCourseDetailsDto.getDescription())
				.build();
	}
}