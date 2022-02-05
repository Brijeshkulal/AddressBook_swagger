package com.bridgelabz.addressbook.dto;

import java.util.List;

import com.bridgelabz.addressbook.model.Contact;

import lombok.Data;

@Data
public class ResponseDTO {
	
	private String message;
	private Object object;
	private List<Contact> contactList;
	
	public ResponseDTO(String message, Object object) {
		this.message = message;
		this.object = object;
	}

	public ResponseDTO(String message, List<Contact> contactList) {
		super();
		this.message = message;
		this.contactList = contactList;
	}

}


