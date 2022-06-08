package com.javadevsguide.springframework.di.service;

import java.util.Arrays;
import java.util.List;

public class ServiceImpl implements Service {

	@Override
	public List<String> getIds() {
		return Arrays.asList("A", "B");
	}

}
