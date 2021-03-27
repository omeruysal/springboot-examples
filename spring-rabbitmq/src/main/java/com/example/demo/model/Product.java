package com.example.demo.model;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value= "My producst Model for value / value of @ApiModel" , description = "my description for product model / description of @@ApiModel")
public class Product {

	@ApiModelProperty(value= "id field of Product object / value of @@ApiModelProperty")
	private String id;

	@ApiModelProperty(value= "productName field of Product object / value of @@ApiModelProperty")
	private String productName;

	@ApiModelProperty(value= "createdDate field of Product object / value of @@ApiModelProperty")
	private Date createdDate;

	@ApiModelProperty(value= "address field of User Product object / value of @@ApiModelProperty")
	private String descripton;

}


