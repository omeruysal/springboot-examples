package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder({"userId","name","username","lastname","company","address"})
@JsonInclude(value = Include.NON_NULL)
@Builder
@ApiModel(value= "UserDTO Model/ value of @@ApiModel" , description = "my description / description of @@ApiModel")
public class UserDTO {
	

	@ApiModelProperty(value= "id field of User object / value of @@ApiModelProperty")
	@JsonProperty(access = Access.READ_ONLY,value  = "userId")
	private Integer id;
	private String username;
	
	
	private String name;
	
	@JsonProperty(value="lastName")
	private String lastname;
	private AddressDTO address;
	@JsonManagedReference
	private CompanyDTO company;
	@JsonIgnore //artik post ile user create ederken passwordu request uzerinden de alamayiz. Cunku hem response hem de request uzerinden ignore eder
	private String password;

}
