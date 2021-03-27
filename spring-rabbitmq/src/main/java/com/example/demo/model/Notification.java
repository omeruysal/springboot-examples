package com.example.demo.model;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Notification implements Serializable{
	

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String notificationId;
    private Date createdAt;
    private Boolean seen;
    private String message;
    private String content;

}
