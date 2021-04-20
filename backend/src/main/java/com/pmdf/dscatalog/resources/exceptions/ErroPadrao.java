package com.pmdf.dscatalog.resources.exceptions;

import java.io.Serializable;
import java.time.Instant;

public class ErroPadrao implements Serializable {
	private static final long serialVersionUID = 1L;

	// Utilizando o mesmo paramêtro do erro na rota do Postman
//	{
//	    "timestamp": "2020-10-02T13:17:33.410+00:00",
//	    "status": 500,
//	    "error": "Internal Server Error",
//	    "message": "",
//	    "path": "/categories/5"
//	}

	private Instant timestamp;
	private Integer status;
	private String error;
	private String message;
	private String path;

	public ErroPadrao() {
		
	}

	public Instant getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Instant timestamp) {
		this.timestamp = timestamp;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

}
