package com.nhsbsa.projmgmt.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.nhsbsa.projmgmt.entity.User;

public interface UserRepository extends PagingAndSortingRepository<User, Long> {

	User findByUserId(long theId);
}
