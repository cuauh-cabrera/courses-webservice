package com.webservice.soap.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CreateCourseDetailsDto {

	private Long id;
	
	@NotBlank(message = "Tha name of the Course cannot be empty")
	private String name;

	@NotBlank(message = "The Course description cannot be emtpy")
	private String description;
	private Boolean isActive;

}
