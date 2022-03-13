package com.zz.task.dto;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AgencyDto implements Serializable{
	@NotNull
	@NotBlank
	private String name;
	@NotNull
	@NotBlank
	private String address1;
	private String address2;
	@NotNull
	@NotBlank
	private String state;
	@NotNull
	@NotBlank
	private String city;
	@NotNull
	@NotBlank
	private Long phoneNumber;
	
	private List<ClientDto> clientDtos;
	
	
}
