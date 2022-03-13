package com.zz.task.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zz.task.dto.AgencyBillDto;
import com.zz.task.dto.AgencyDto;
import com.zz.task.dto.ClientDto;
import com.zz.task.model.Agency;
import com.zz.task.model.Client;
import com.zz.task.repository.AgencyRepository;
//import com.zz.task.repository.ClientRepository;
import com.zz.task.repository.ClientRepository;

@Service
public class AgencyServiceImplmentation implements AgencyService {

	@Autowired
	private AgencyRepository agencyRepository;

	@Autowired
	private ClientRepository clientRepository;

	private List<Integer> agencyId;
	List<String> agencyNames;
	String agencyName;

	public String getAgencyName() {
		return agencyName;
	}

	Double topBill = null;
	Integer agencyId1;

	public Integer getAgencyId1() {
		return agencyId1;
	}

	List<String> clientNames;
	String clientName;

	public String getClientName() {
		return clientName;
	}

	@Override
	public AgencyDto saveAgency(AgencyDto agencyDto) {

		Agency agency = new Agency(agencyDto.getName(), agencyDto.getAddress1(), agencyDto.getAddress2(),
				agencyDto.getState(), agencyDto.getCity(), agencyDto.getPhoneNumber());

		List<Agency> agencies = new ArrayList<>();
		agencies.add(agency);

		List<ClientDto> clients = agencyDto.getClientDtos();

		for (Agency agency0 : agencies) {
			agencyRepository.save(agency0);
		}

		for (ClientDto clientDto : clients) {
			Client client = new Client(clientDto.getName(), clientDto.getEmail(), clientDto.getPhoneNumber(),
					clientDto.getTotalBill());
			clientRepository.save(client);
		}

		return agencyDto;
	}

	@Override
	public List<Client> getTopAgency() {

		List<Client> clients = clientRepository.findAll();
		topBill = clients.stream().map(e -> e.getTotalBill()).max(Double::compare).get();

		clients = clientRepository.findByTotalBill(topBill);

		agencyId = clients.stream().map(Client::getClientId).collect(Collectors.toList());

		clientNames = clients.stream().map(Client::getName).collect(Collectors.toList());
		return clients;
	}

	@Override
	public List<Agency> getAgencyId() {

		List<Agency> agencies = (List<Agency>) agencyRepository.findByAgencyId(agencyId1);

		agencyNames = agencies.stream().map(Agency::getName).collect(Collectors.toList());

		return agencies;
	}

	public void setAgencyName(String agencyName) {
		agencyName = agencyNames.get(0);
	}

	public void setAgencyId1(Integer agencyId1) {
		agencyId1 = agencyId.get(0);
	}

	public void setClientName(String clientName) {
		clientName = clientNames.get(0);
	}

	@Override
	public AgencyBillDto getAgencyClient() {

		AgencyBillDto agencyBillDto = new AgencyBillDto(agencyName, clientName, topBill);

		return agencyBillDto;
	}
}