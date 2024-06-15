package com.flight.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flight.management.model.AdminModel;

public interface AdminRepo extends JpaRepository<AdminModel, String> {

}
