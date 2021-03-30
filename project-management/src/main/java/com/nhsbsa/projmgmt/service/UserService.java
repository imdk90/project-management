package com.nhsbsa.projmgmt.service;

import org.springframework.stereotype.Service;

import com.nhsbsa.projmgmt.entity.User;

@Service
public interface UserService {

	public User save(User user);

	public Iterable<User> getAll();

	public User findByUserId(long theId);

	public void delete(User theUser);
}
