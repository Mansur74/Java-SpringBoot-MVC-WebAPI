package com.enoca.work.dtos;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CompanyDto {
	private int id;
	@NotEmpty(message="Name should not be empty")
	private String name;
	@NotEmpty(message="Location should not be empty")
	private String location;
	private String description;
	@NotEmpty(message="Image URL should not be empty")
	private String imgUrl;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	private List<EmployeeDto> employees;

}
