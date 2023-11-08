package com.enoca.work.dtos;

import java.time.LocalDateTime;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {
	
	private int id;
	@NotEmpty(message="Firstname should not be empty")
	private String firstname;
	@NotEmpty(message="Lastname should not be empty")
	private String lastname;
	@NotEmpty(message="Gender should not be empty")
	private String gender;
	@NotEmpty(message="Summary should not be empty")
	private String summary;
	@NotEmpty(message="Image URL should not be empty")
	private String imgUrl;
	@Min(value = 18, message = "Can not be lower than 18 age.")
	private int age;
	@NotNull(message="Salary should not be null")
	private int salary;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
}
