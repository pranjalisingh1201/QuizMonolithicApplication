package com.spboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spboot.data.QuestionWrapper;
import com.spboot.data.Response;
import com.spboot.service.QuizService;

@RestController
@RequestMapping("quiz")
public class QuizController {
	@Autowired
	QuizService quizservice;
	
	@PostMapping("create")
	public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam int noOfQuestions, @RequestParam String title)
	{
		return quizservice.createQuiz(category,noOfQuestions,title);
	}
	@GetMapping("get/{id}")
	public ResponseEntity<List<QuestionWrapper>> getQuiz(@PathVariable Integer id)
	{
		return quizservice.getQuestions(id);
		
	}
	
	@PostMapping("submit/{id}")
	public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id, @RequestBody List<Response> responses)
	{
		return quizservice.calculateResult(id,responses);
		
	}
}
