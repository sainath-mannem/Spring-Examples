package com.iii.hr.empservice.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("local")
public class LocalPreviligeCheckImpl implements PreviligeCheck {

	@Override
	public boolean isUserHasAccess(String user) {
		System.out.println("Local profile Class Classed");
		return true;
	}

}
