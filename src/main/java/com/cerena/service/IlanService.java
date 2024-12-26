package com.cerena.service;

import com.cerena.entity.Ilan;
import com.cerena.entity.User;
import com.cerena.repository.IlanRepository;
import com.cerena.repository.RepositoryManager;

import java.time.LocalDate;
import java.util.List;

public class IlanService extends ServiceManager<Ilan, Long> {
	private final IlanRepository ilanRepository;
	
	public IlanService(RepositoryManager<Ilan, Long> repository, IlanRepository ilanRepository) {
		super(repository);
		this.ilanRepository = ilanRepository;
	}
	
	public List<Ilan> findByCategory(long categoryId) {
		return  ilanRepository.findByCategory(categoryId);
	}
	
	public List<Ilan> findByLocation(long locationId) {
		return  ilanRepository.findByCategory(locationId);
	}
	
	public List<Ilan> findByDateRage(String startDate, String endDate) {
		return  ilanRepository.findByDateRage(startDate, endDate);
	}
	
	public List<Ilan> findByUserId(long userId) {
        User user = new User();
        user.setId(userId);
        return ilanRepository.findByUser(user);
    }
	

}