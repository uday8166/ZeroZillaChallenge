package com.zz.task.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Data
@NoArgsConstructor
public class ClientDto implements Serializable {
	public ClientDto(@NotNull @NotBlank String name, @NotNull @NotBlank String email,
			@NotNull @NotBlank Long phoneNumber, @NotNull @NotBlank Double totalBill) {
		super();
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.totalBill = totalBill;
	}

	@NotNull
	@NotBlank
	private String name;
	@NotNull
	@NotBlank
	private String email;
	@NotNull
	@NotBlank
	private Long phoneNumber;
	@NotNull
	@NotBlank
	private Double totalBill;
}
