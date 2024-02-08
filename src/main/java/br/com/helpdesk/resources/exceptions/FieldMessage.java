package br.com.helpdesk.resources.exceptions;

import java.io.Serializable;

public class FieldMessage implements Serializable {
	private static final long serialVersionUID = 1L;

	private String fieldNAme;
	private String message;

	public FieldMessage() {
		super();
	}

	public FieldMessage(String fieldNAme, String message) {
		super();
		this.fieldNAme = fieldNAme;
		this.message = message;
	}

	public String getFieldNAme() {
		return fieldNAme;
	}

	public void setFieldNAme(String fieldNAme) {
		this.fieldNAme = fieldNAme;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
