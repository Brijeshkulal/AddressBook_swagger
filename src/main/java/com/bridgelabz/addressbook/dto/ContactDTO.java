package com.bridgelabz.addressbook.dto;

import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ContactDTO {
	
	@Pattern(regexp = "^[A-Z]{1}[a-z]{2,}$", message = "First name Invalid")
	public String firstName;
	@Pattern(regexp = "^[A-Z]{1}[a-z]{2,}$", message = "Last name Invalid")
	public String lastName;
	
	public String mail;
	public String address;
	public String city;
	public String state;
	public String zip;
	public String phone_number;
	

}
