package com.example.jeedemo.restclients;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class PersonalInfo {
	private String fullname;
	private String email;
	private long age;

	public PersonalInfo() {
	}

	public PersonalInfo(String fullname, String email, long age) {
		this.fullname = fullname;
		this.email = email;
		this.age = age;
	}
}