package com.zz.task.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Client {
	@Id
	@SequenceGenerator(name = "client_sequence_generator", initialValue = 200, allocationSize = 1)
	@GeneratedValue(generator = "client_sequence_generator")
	private Integer clientId;
	private String name;
	private String email;
	private Long phoneNumber;
	private Double totalBill;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "agencyId")
	private Agency agency;

	public Client(String name, String email, Long phoneNumber, Double totalBill) {
		super();
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.totalBill = totalBill;
	}

	public Client get(int i) {
		return null;
	}

}
