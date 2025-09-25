package com.webservice.soap.mapper;

import org.springframework.stereotype.Component;

import com.cuauh_cabrera.courses.CourseDetails;
import com.cuauh_cabrera.courses.CreateCourseDetailsRequest;
import com.webservice.soap.dto.CreateCourseDetailsDto;
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
	
	/**
	 * Maps a CreateCourseDetailsDto into a CourseDetailsEntity
	 * @param courseDetailsDto with the data to be mapped
	 * @return CourseDetailsEntity with the data mapped from the CreateCourseDetailsDto
	 */
	public CourseDetailsEntity createCourseDetailsDtoToCourseDetailsEntity(CreateCourseDetailsDto courseDetailsDto) {
				
		return CourseDetailsEntity.builder()
				.name(courseDetailsDto.getName())
				.description(courseDetailsDto.getDescription())
				.isActive(courseDetailsDto.getIsActive() != null ? courseDetailsDto.getIsActive() : null)
				.build();
	}
	
	/**
	 * Maps a CourseDetailsEntity into a CreateCourseDetailsDto
	 * @param courseDetailsEntity
	 * @return CreateCourseDetailsDto
	 */
	public CreateCourseDetailsDto courseDetailsEntityToCreateCourseDetailsDto(CourseDetailsEntity courseDetailsEntity) {
		
		return CreateCourseDetailsDto.builder()
				.name(courseDetailsEntity.getName())
				.description(courseDetailsEntity.getDescription())
				.isActive(courseDetailsEntity.getIsActive())
				.build();
	}
			
	/**
	 * Maps a CreateCourseDetailsRequest Domain object to a CourseDetailsEntity
	 * @param createCourseDetailsRequest
	 * @return CourseDetailsEntity
	 */
	public CourseDetailsEntity createCourseDetailsRequestToCourseDetailsEntity(CreateCourseDetailsRequest createCourseDetailsRequest) {
		
		return CourseDetailsEntity.builder()
				.name(createCourseDetailsRequest.getName())
				.description(createCourseDetailsRequest.getDescription())
				.isActive(true)
				.build();
	}
}