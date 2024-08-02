package com.vivek.quizapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.vivek.quizapp.doa.QuestionDoa;
import com.vivek.quizapp.model.Question;

@Service
public class QuestionService {
	
	@Autowired
	QuestionDoa questionDoa;

	public ResponseEntity<List<Question>> getAllquestions() {
		try {
			return new ResponseEntity<>(questionDoa.findAll(), HttpStatus.OK);
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<Question> addQuestion(Question question) {
		try {
			questionDoa.save(question);
			return new ResponseEntity<>(question,HttpStatus.CREATED);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new Question(),HttpStatus.BAD_REQUEST);
	}

	
	public ResponseEntity<List<Question>> getQuestionByCategory(String category) {
		try {
			return new ResponseEntity<List<Question>>(questionDoa.findByCategory(category),HttpStatus.OK);		
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<String> delQuestion(int id) {
		
		try {
		questionDoa.deleteById(id);
		return new ResponseEntity<>("Question Deleted with id = " + id,HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>("Cannot delete question",HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<String> deleteAllQuestion() {
		try {
		questionDoa.deleteAll();
		return new ResponseEntity<String>("All questions has been deleted",HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<String>("Cannot delete all question from database",HttpStatus.BAD_REQUEST);
	}
	public ResponseEntity<List<Question>> addListOfQuestion(List<Question> questionList) {
		try {
		return new ResponseEntity<List<Question>>(questionDoa.saveAll(questionList),HttpStatus.CREATED);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<Question> getQuestionById(int id) {
	    try {
	        Optional<Question> optionalQuestion = questionDoa.findById(id);
	        if (optionalQuestion.isPresent()) {
	            return new ResponseEntity<>(optionalQuestion.get(), HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(new Question(),HttpStatus.NOT_FOUND);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
	
	
}
