package com.zz.task.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zz.task.dto.AgencyBillDto;
import com.zz.task.dto.AgencyDto;
import com.zz.task.model.Agency;
import com.zz.task.model.Client;

@Service
public interface AgencyService {

	AgencyDto saveAgency(AgencyDto agencyDto);

	List<Client> getTopAgency();

	List<Agency> getAgencyId();

	AgencyBillDto getAgencyClient();

}
