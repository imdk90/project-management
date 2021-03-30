package com.nhsbsa.projmgmt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nhsbsa.projmgmt.entity.User;
import com.nhsbsa.projmgmt.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepo;

	@Override
	public User save(User user) {
		return userRepo.save(user);
	}

	@Override
	public Iterable<User> getAll() {
		return userRepo.findAll();
	}

	@Override
	public User findByUserId(long theId) {
		return userRepo.findByUserId(theId);
	}

	@Override
	public void delete(User theUser) {
		userRepo.delete(theUser);
	}

}
