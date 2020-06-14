package com.techwithratz.initialzr.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.techwithratz.initialzr.exception.BabyNotFoundException;
import com.techwithratz.initialzr.model.Baby;


@Component
public class NewBornBabyService {
	
static List<Baby> babies  = new ArrayList<>();
	
	static int babyCount = 3;
	
	static {
		babies.add(new Baby(1, "Vihaan", new Date(),"ABC","ABC","Female",2.4));
		babies.add(new Baby(2, "Jo", new Date(),"ABC","ABC","Male",2.5));
		babies.add(new Baby(3, "Rohan", new Date(),"ABC","ABC","Male",2.7));
	}
	
	public List<Baby> findAll() {
		return babies;
	}
	
	public Baby saveBaby(Baby baby) {
		if(baby.getId() == null) {
			 baby.setId(++babyCount);
		}
		babies.add(baby);
		return baby;
	}
	
	public Baby findBaby(int id) {
		Baby baby = babies.stream().filter(u-> u.getId()== id).findAny().orElse(null);
		return baby;
	}
	
	public Baby deleteByBabyId(int id) {
		Baby baby = findBaby(id);
		if(baby == null) {
			throw new BabyNotFoundException("id--> "+id);
		}
		babies.removeIf(u -> u.getId() == baby.getId()); 
		return baby;
	}
	

}
