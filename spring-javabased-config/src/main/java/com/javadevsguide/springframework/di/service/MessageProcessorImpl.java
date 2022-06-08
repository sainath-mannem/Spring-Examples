package com.javadevsguide.springframework.di.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class MessageProcessorImpl implements MessageProcessor {

	@Autowired
	@Qualifier("emailService")
	private MessageService messageService;

	public MessageProcessorImpl() {
	}

	public void processMsg(String message) {
		messageService.sendMsg(message);
	}
}
