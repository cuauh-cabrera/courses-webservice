package com.webservice.soap.repository.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;
import com.cuauh_cabrera.courses.CourseDetails;
import com.webservice.soap.dto.CreateCourseDetailsDto;
import com.webservice.soap.dto.UpdateCourseDetailsDto;
import com.webservice.soap.entity.CourseDetailsEntity;
import com.webservice.soap.mapper.CourseDetailsDataMapper;
import com.webservice.soap.repository.CourseDetailsJpaRepository;
import com.webservice.soap.repository.ICourseDetailsRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class CourseDetailsRepositoryImpl implements ICourseDetailsRepository{
	
	private final CourseDetailsJpaRepository courseDetailsJpaRepository;
	private final CourseDetailsDataMapper courseDetailsDataMapper;

	public CourseDetailsRepositoryImpl(CourseDetailsJpaRepository courseDetailsJpaRepository, 
									   CourseDetailsDataMapper courseDetailsDataMapper) {
		this.courseDetailsJpaRepository = courseDetailsJpaRepository;
		this.courseDetailsDataMapper = courseDetailsDataMapper;
	}

	@Override
	public List<CourseDetails> findAll() {
		try {
			log.debug("Querying the list of all Courses");

			List<CourseDetailsEntity> courseEntities = courseDetailsJpaRepository.findAll();

			return courseEntities.stream()
					.map(courseDetailsDataMapper::courseDetailsEntityToCourseDetails)
					.toList();

		}catch (Exception e) {
			log.error("Error querying the list of Courses" + e.getMessage());
			return Collections.emptyList();	
		}
	}

	@Override
	public Optional<CourseDetails> findById(Long id) {
		try {
			log.debug("Querying Course Details for Course with Id:{}", id);
			
			Optional<CourseDetailsEntity> courseOptional = courseDetailsJpaRepository.findById(id);
			
			if(courseOptional.isPresent()) {
				
				log.debug("Found Course Deatils for Course Id: {}", id);
				
				CourseDetailsEntity courseEntity = courseOptional.get();
				
				CourseDetails courseDetails = courseDetailsDataMapper.courseDetailsEntityToCourseDetails(courseEntity);
				
				return Optional.ofNullable(courseDetails);
			}
			
			log.warn("No Course Details were found for Course with Id: {}", id);
			return Optional.empty();

		}catch (Exception e) {
			log.error("Error querying Course Details with Id: {}", id);
			return Optional.empty();
		}
	}

	@Override
	public void update(UpdateCourseDetailsDto updateCourseDetailsDto) {
		try {
			log.debug("Searching Course with Id:{}", updateCourseDetailsDto.getId());
						
			Optional<CourseDetailsEntity> courseOptional = courseDetailsJpaRepository.findById(updateCourseDetailsDto.getId());
			
			if(courseOptional.isPresent()) {
				
				log.debug("Found Course Details with Course Id:{}", updateCourseDetailsDto.getId());
				
				CourseDetailsEntity courseToUpdate = courseDetailsDataMapper
						.updateCourseDetailsDtoToCourseDetailsEntity(updateCourseDetailsDto);
				
				courseDetailsJpaRepository.save(courseToUpdate);
				
				log.info("Course Deatils for Course Id: {} updated succesfully", updateCourseDetailsDto.getId());
			}
			
		}catch (Exception e) {
			log.error("Error updating Course Details with Id:{}", updateCourseDetailsDto.getId());
			throw new RuntimeException("Error updating Course with Id: " + updateCourseDetailsDto.getId() + e.getMessage());
		}
		
	}

	@Override
	public void setIsActive(Long id, boolean status) {
		try {
			log.debug("Searching Course with Id:{}", id);
			
			Optional<CourseDetailsEntity> courseOptional = courseDetailsJpaRepository.findById(id);
			
			if(courseOptional.isPresent()) {
				
				log.debug("Found Course Details with Course Id:{}", id);
				
				CourseDetailsEntity courseEntity = courseOptional.get();
				courseEntity.setIsActive(status);
				courseDetailsJpaRepository.save(courseEntity);
				
				log.info("Course status updated for Course Id: {}", id);
			}
			
			log.warn("No Course Details were found for Course with Id: {}", id);
			
		}catch (Exception e) {
			log.error("Error updating status for Course with Id:{}", id);
			throw new RuntimeException("Error updating status for Course with Id: " + id + e.getMessage());
		}
		
	}

	@Override
	public void delete(Long id) {
		try {
			log.debug("Searching Course with Id:{}", id);
			
			Optional<CourseDetailsEntity> courseOptional = courseDetailsJpaRepository.findById(id);
			
			if(courseOptional.isPresent()) {
				
				log.debug("Found Course Details with Course Id:{}", id);
				
				CourseDetailsEntity courseEntity = courseOptional.get();
				courseDetailsJpaRepository.delete(courseEntity);
				
				log.info("Deleted Course with Id: {}", id);
			}
			
			log.warn("No Course Details were found for Course with Id: {}", id);
			
		}catch (Exception e) {
			log.error("Error deleting Course with Id:{}", id);
			throw new RuntimeException("Error deleting Course from Database with Id: " + id + e.getMessage());
		}
		
	}

	@Override
	public CourseDetailsEntity insert(CreateCourseDetailsDto courseDetailsDto) {
		try {
			log.debug("Inserting new CourseDetails entity into the Database");
			
			CourseDetailsEntity courseEntity = courseDetailsDataMapper
					.createCourseDetailsDtoToCourseDetailsEntity(courseDetailsDto);
			
			var savedCourse = courseDetailsJpaRepository.save(courseEntity);
			
			log.info("Course persisted in the Database");
			
			return savedCourse;
						
		}catch (Exception e) {
			log.error("Error persisting CourseDetails entity");
			throw new RuntimeException("Error inserting new Course into the Database" + e.getMessage());
		}
		
	}

}
