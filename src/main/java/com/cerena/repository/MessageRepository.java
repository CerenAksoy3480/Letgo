package com.cerena.repository;

import com.cerena.entity.Message;

public class MessageRepository extends RepositoryManager<Message, Long> {
	public MessageRepository() {
		super(Message.class);
	}
}