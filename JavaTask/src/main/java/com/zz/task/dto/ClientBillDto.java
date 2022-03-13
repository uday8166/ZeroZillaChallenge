package com.zz.task.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientBillDto {

	private Long totalBill;
	private String name;
	private Integer agencyId;
}