package com.example.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.DealMaster;

public interface DealMasterRepo extends JpaRepository<DealMaster, String> {
	Optional<DealMaster> findByItem(String item);
}
