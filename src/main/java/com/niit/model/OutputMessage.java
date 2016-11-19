package com.niit.model;

public class OutputMessage extends Message {

	public OutputMessage() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OutputMessage(Message message) {
		super(message.getMessage(),message.getId());
		// TODO Auto-generated constructor stub
	}
}