package com.example.demo.dto;

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
@ApiModel(value= "AddressDTO model/ value of @@ApiModel" , description = "my description / description of @@ApiModel")
public class AddressDTO {
	

	@ApiModelProperty(value= "country field of User object / value of @@ApiModelProperty")
	private String country;

	@ApiModelProperty(value= "city field of User object / value of @@ApiModelProperty")
	private String city;

	@ApiModelProperty(value= "neighborhood field of User object / value of @@ApiModelProperty")
	private String neighborhood;

	@ApiModelProperty(value= "door number field of User object / value of @@ApiModelProperty")
	private String doorNo;
	

}
