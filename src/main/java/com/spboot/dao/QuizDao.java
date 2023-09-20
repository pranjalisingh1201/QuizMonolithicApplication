package com.spboot.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spboot.data.Quiz;

public interface QuizDao extends JpaRepository<Quiz, Integer>{

	Optional<Quiz> findById(Integer id);

}
