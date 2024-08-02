package com.vivek.quizapp.doa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vivek.quizapp.model.Question;

@Repository
public interface QuestionDoa extends JpaRepository<Question, Integer>{
	List<Question> findByCategory(String category);

	
	@Query("Select * from qustion q where q.category=:actegory ")
	List<Question> findRandomQuestionByCategory(String category, int num);
}
