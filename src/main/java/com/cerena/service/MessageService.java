package com.cerena.service;

import com.cerena.entity.Ilan;
import com.cerena.entity.Message;
import com.cerena.entity.User;
import com.cerena.repository.RepositoryManager;
import jakarta.persistence.EntityManager;

import java.util.List;

public class MessageService extends ServiceManager<Message, Long> {
	
	private EntityManager em;
	private final MessageService messageService;
	
	
	
	public MessageService(RepositoryManager<Message, Long> repository, MessageService messageService) {
		super(repository);
		this.messageService = messageService;
	}
	
	public List<Ilan> findByUserId(Long user) {
		return em.createQuery("select i from Ilan i where i.user = :user", Ilan.class)
		         .setParameter("user", user)
		         .getResultList();
	}
}