package com.techwithratz.initialzr.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.techwithratz.initialzr.exception.BabyBadInputException;
import com.techwithratz.initialzr.exception.BabyNotFoundException;
import com.techwithratz.initialzr.model.Baby;
import com.techwithratz.initialzr.service.NewBornBabyService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@Api(tags="Baby Management Restful services", value="BabyController")
public class NewBornBabyController {
	private Logger logger = LogManager.getLogger(NewBornBabyController.class);

	@Autowired
	NewBornBabyService newBornBabyService;

	@ApiOperation(value="Retrieve list of babies")
	@GetMapping(path = "/babies")
	public List<Baby> getBabies() {
		return newBornBabyService.findAll();
	}

	@PostMapping(path = "/babies")
	public ResponseEntity<Baby> saveBaby(@ApiParam("New Born baby information to be created")
	                                     @Valid @RequestBody Baby baby) {
		if (baby.getName() == null || baby.getBirthDate() == null) {
			logger.info("Baby object is empty");
			throw new BabyBadInputException("Please enter all the details");
		}
		Baby savedUser = newBornBabyService.saveBaby(baby);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}

	@GetMapping(path = "/babies/{id}")
	public ResponseEntity<Object> getBaby(@PathVariable int id) {
		Baby baby = newBornBabyService.findBaby(id);
		if (baby == null) {
			throw new BabyNotFoundException("id--> " + id);
		}
		return ResponseEntity.status(HttpStatus.OK).body(baby);
	}

	@DeleteMapping(path = "/babies/{id}")
	public Baby deleteBaby(@PathVariable int id) {
		Baby baby = newBornBabyService.deleteByBabyId(id);
		if (baby == null) {
			throw new BabyNotFoundException("id--> " + id);
		}
		return baby;
	}

}
