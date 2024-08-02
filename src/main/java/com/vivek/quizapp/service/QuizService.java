package com.vivek.quizapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.vivek.quizapp.doa.QuestionDoa;
import com.vivek.quizapp.doa.QuizDao;
import com.vivek.quizapp.model.Question;
import com.vivek.quizapp.model.Quiz;

@Service
public class QuizService {
	
	@Autowired
	QuizDao quizDoa;
	
	@Autowired
	QuestionDoa questionDoa;

	public ResponseEntity<String> createQuiz(String category, int numberOfQuestions, String title) {
		
		List<Question> questions = questionDoa.findRandomQuestionByCategory(category, numberOfQuestions);		
		Quiz quiz = new Quiz();
		quiz.setTitle(title);
//		quiz.setQuestions();
	}
}
