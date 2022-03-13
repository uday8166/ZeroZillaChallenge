package com.zz.task.dto.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zz.task.dto.AgencyBillDto;
import com.zz.task.dto.AgencyDto;
import com.zz.task.response.ResponseMessage;
import com.zz.task.service.AgencyService;

@SuppressWarnings({ "unused", "unused" })
@RestController
@RequestMapping("/api/v1/agency")
public class AgencyController {

	@Autowired
	private AgencyService agencyService;

	@PostMapping("/create-agency")
	public ResponseEntity<ResponseMessage> saveAgency(@RequestBody AgencyDto agency) {
		if (agency != null) {
			AgencyDto dto = agencyService.saveAgency(agency);
			ResponseMessage message = new ResponseMessage(HttpStatus.OK.value(), false, "Agency saved succefully ",
					dto);
			return new ResponseEntity<>(message, HttpStatus.OK);
		}
		return new ResponseEntity<>(
				new ResponseMessage(HttpStatus.BAD_REQUEST, true, "Please Enter Valid Details", null),
				HttpStatus.BAD_REQUEST);

	}

	@GetMapping("/top-agency")
	public ResponseEntity<ResponseMessage> getTopAgencyDetails() {

		AgencyBillDto client = (AgencyBillDto) agencyService.getAgencyClient();
		if (client != null) {

			ResponseMessage message = new ResponseMessage(HttpStatus.OK.value(), false, "Top Agency", client);
			return new ResponseEntity<>(message, HttpStatus.OK);
		}
		return new ResponseEntity<>(new ResponseMessage(HttpStatus.NOT_FOUND, true, "Noo Data Found", null),
				HttpStatus.NOT_FOUND);

	}

}
