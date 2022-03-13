package com.zz.task.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zz.task.dto.ClientDto;
import com.zz.task.model.Client;
import com.zz.task.repository.ClientRepository;

@Service
public class ClientServiceImplemetation implements ClientService {

	@Autowired
	ClientRepository clientRepository;

	@Override
	public ClientDto updateClient(ClientDto clientDto) {

		Client client = new Client(clientDto.getName(), clientDto.getEmail(), clientDto.getPhoneNumber(),
				clientDto.getTotalBill());
		Client client3 = null;
		if (client != null) {
			client3 = clientRepository.findByEmail(client.getEmail());
			if (client3 != null) {
				client3 = clientRepository.save(client);
			}
		}

		return clientDto;
	}

}
