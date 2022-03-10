package com.examly.springapp.dtoclass;


import lombok.Data;
import lombok.Getter;
import lombok.Value;

@Getter
@Data
@Value
public class ResponseDto {

	private String message;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	public ResponseDto(String message) {
		super();
		this.message = message;
		
	}
	public ResponseDto() {
		super();
	}
	
	
}