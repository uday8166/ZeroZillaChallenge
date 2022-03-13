package com.zz.task.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Agency {

	@Id
	@SequenceGenerator(name = "agency_sequence_generator", initialValue = 100, allocationSize = 1)
	@GeneratedValue(generator = "agency_sequence_generator")
	private Integer agencyId;
	private String name;
	private String address1;
	private String address2;
	private String state;
	private String city;
	private Long phoneNumber;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "agency")
	private List<Client> clients;

	public Agency(String name, String address1, String address2, String state, String city, Long phoneNumber) {
		super();
		this.name = name;
		this.address1 = address1;
		this.address2 = address2;
		this.state = state;
		this.city = city;
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "Agency [agencyId=" + agencyId + ", name=" + name + ", address1=" + address1 + ", address2=" + address2
				+ ", state=" + state + ", city=" + city + ", phoneNumber=" + phoneNumber + "]";
	}

}
