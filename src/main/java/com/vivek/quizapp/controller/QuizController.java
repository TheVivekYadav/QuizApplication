package com.vivek.quizapp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vivek.quizapp.service.QuizService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/quiz")
public class QuizController {

	@Autowired
	QuizService quizService;
	
	@PostMapping("/create")
	public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam int numberOfQuestions, @RequestParam String title) {
		
		return quizService.createQuiz(category, numberOfQuestions,title);
	}
	
}
