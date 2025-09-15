package com.webservice.soap.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCourseDetailsDto {
	
	@NotBlank(message = "Course Id cannot be null")
	private Long id;
	
	private String name;
	
	private String description;
	
}
