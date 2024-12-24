package com.cerena.repository;

import com.cerena.entity.Message;
import com.cerena.entity.User;

public class MessageRepository extends RepositoryManager<Message, Long> {
	public MessageRepository(Class<Message> entityClass) {
		super(entityClass);
	}
}