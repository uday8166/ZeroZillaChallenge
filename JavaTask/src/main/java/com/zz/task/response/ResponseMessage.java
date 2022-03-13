package com.zz.task.response;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@lombok.Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseMessage {
	public ResponseMessage(HttpStatus badRequest, boolean error2, String message2, Object data2) {
		// TODO Auto-generated constructor stub
	}
	private Integer statusCode;
	private boolean error;
	private String message;
	private Object Data;
}
