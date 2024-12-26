package com.cerena.repository;

import com.cerena.entity.FavouriteIlan;
import com.cerena.entity.Ilan;
import com.cerena.entity.Message;
import com.cerena.entity.User;
import jakarta.persistence.EntityManager;

import java.util.List;

public class MessageRepository extends RepositoryManager<Message, Long> {
	
	
	public MessageRepository() {
		super(Message.class);
	}
	
	
}