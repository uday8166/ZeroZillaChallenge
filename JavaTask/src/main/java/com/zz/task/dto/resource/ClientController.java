package com.zz.task.dto.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zz.task.dto.ClientDto;
import com.zz.task.response.ResponseMessage;
import com.zz.task.service.ClientService;

@RestController
@RequestMapping("/api/v1/client")
public class ClientController {

	@Autowired
	private ClientService clientService;

	@PutMapping("/update-client")
	public ResponseEntity<ResponseMessage> updateClient(@RequestBody ClientDto client) {

		ClientDto dto = clientService.updateClient(client);
		if (dto != null) {
			ResponseMessage message = new ResponseMessage(HttpStatus.OK.value(), false, "Client Updated succefully ",
					dto);
			return new ResponseEntity<>(message, HttpStatus.OK);
		}

		return new ResponseEntity<>(new ResponseMessage(HttpStatus.NOT_FOUND, true, "Noo Data Found", null),
				HttpStatus.NOT_FOUND);

	}

}
