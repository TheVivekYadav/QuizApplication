package com.vivek.quizapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vivek.quizapp.model.Question;
import com.vivek.quizapp.service.QuestionService;

@RestController
@RequestMapping("/question")
public class QuestionController {
	@Autowired
	QuestionService service;
	
    @GetMapping("/allquestions")
    public ResponseEntity<List<Question>> getAllQuestions(){
        return service.getAllquestions();
    }
    
    @PostMapping("/allquestions")
    public ResponseEntity<Question> addQuestion(@RequestBody Question question) {
    	return service.addQuestion(question);    
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Question> getQuestionById(@PathVariable int id){
    	return service.getQuestionById(id);
    }
    
    @PostMapping("/addmultiplequestions")
    public ResponseEntity<List<Question>> addListOfQuestions(@RequestBody List<Question> questionList){
    	return service.addListOfQuestion(questionList);
    }
    
    @GetMapping("/category/{category}")
    public ResponseEntity<List<Question>> getQuestionByCategory(@PathVariable String category){
    	return service.getQuestionByCategory(category);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delQuestion(@PathVariable int id) {
    	return service.delQuestion(id);
    }
    
    @DeleteMapping("delete")
    public ResponseEntity<String> deleteAllQuestion() {
    	return service.deleteAllQuestion();
    }

}
