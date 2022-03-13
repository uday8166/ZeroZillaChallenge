package com.zz.task.dto;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Data
@NoArgsConstructor
public class AgencyBillDto implements Serializable{
	
	public AgencyBillDto(String agencyName, String clientName, Double totalBill) {
		super();
		this.agencyName = agencyName;
		this.clientName = clientName;
		this.totalBill = totalBill;
	}
	private String agencyName;
	private String clientName;
	private Double totalBill;

}
