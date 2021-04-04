package com.example.demo.dto;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(value = Include.NON_NULL)
@ApiModel(value= "CompanyDTO Mode / value of @@ApiModel" , description = "my description / description of @@ApiModel")
public class CompanyDTO {
	
	@JsonProperty("company")
	private String companyName;
	

	@ApiModelProperty(value= "category field of User object / value of @@ApiModelProperty")
	private String category;
	@JsonBackReference
	private Map<Integer,UserDTO> users;
	private AddressDTO address;

}
