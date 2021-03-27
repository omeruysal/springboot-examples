package com.example.demo.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value= "My User Model for value / value of @@ApiModel" , description = "my description / description of @@ApiModel")
public class User {
	
	@ApiModelProperty(value= "id field of User object / value of @@ApiModelProperty")
	private Long id;
	
	@ApiModelProperty(value= "username field of User object / value of @@ApiModelProperty")
	private String username;
	
	@ApiModelProperty(value= "lastname field of User object / value of @@ApiModelProperty")
	private String lastname;
	
	@ApiModelProperty(value= "address field of User object / value of @@ApiModelProperty")
	private String address;

}
