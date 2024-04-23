package com.sports.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sports.model.Stats;

public interface StatsRepo extends JpaRepository<Stats, Integer> { 

}
