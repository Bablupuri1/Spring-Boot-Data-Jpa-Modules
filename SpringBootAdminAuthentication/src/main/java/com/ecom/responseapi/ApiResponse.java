package com.ecom.responseapi;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ApiResponse {

	public boolean success;
	public String message;
	public Integer status;
	private Object data;
	private String description;
//	private List<String> list;

	public ApiResponse(boolean success, String message, Integer status, Object data,String description) {
		super();
		this.success = success;
		this.message = message;
		this.status = status;
		this.data = data;
		this.description=description;
//		this.list = list;
	}

}
