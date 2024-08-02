package com.vivek.quizapp.doa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vivek.quizapp.model.Quiz;

public interface QuizDao extends JpaRepository<Quiz, Integer>{

}
