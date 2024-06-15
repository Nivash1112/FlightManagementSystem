package com.flight.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flight.management.model.UserModel;

public interface UserRepository extends JpaRepository<UserModel, String> {

}
