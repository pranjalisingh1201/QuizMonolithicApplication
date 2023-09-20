package com.spboot.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.spboot.dao.QuestionDao;
import com.spboot.dao.QuizDao;
import com.spboot.data.QuestionWrapper;
import com.spboot.data.Questiontb;
import com.spboot.data.Quiz;
import com.spboot.data.Response;

@Service
public class QuizService {
	@Autowired
	QuizDao quizDao;
	
	@Autowired
	QuestionDao questionDao;

	public ResponseEntity<String> createQuiz(String category, int noOfQuestions, String title) {
		// TODO Auto-generated method stub
		try {
		List<Questiontb> questions = questionDao.findRandomQuestionsByCategory(category,noOfQuestions);
		Quiz quiz = new Quiz();
		quiz.setTitle(title);
		quiz.setQuestions(questions);
		quizDao.save(quiz);
		return new ResponseEntity<>("SUCCESS",HttpStatus.OK);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return new  ResponseEntity<>("FAILED",HttpStatus.INTERNAL_SERVER_ERROR);
	}

	public ResponseEntity<List<QuestionWrapper>> getQuestions(Integer id) {
		// TODO Auto-generated method stub
		Optional<Quiz> quiz = quizDao.findById(id);
		List<Questiontb> questions = quiz.get().getQuestions();
		List<QuestionWrapper> qw = new ArrayList<>();
		for(Questiontb q : questions)
		{
			QuestionWrapper ques = new QuestionWrapper(q.getId(),q.getQuestionTitle(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
			qw.add(ques);
		}
		return new ResponseEntity<>(qw,HttpStatus.OK);
	}

	public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
		// TODO Auto-generated method stub
		Quiz quiz = quizDao.findById(id).get();
		List<Questiontb> questions = quiz.getQuestions();
		int result = 0,i=0;
		for(Response res : responses)
		{
			if(res.getResponse().equals(questions.get(i).getRightAnswer()))result++;
			i++;
		}
		return new ResponseEntity<>(result,HttpStatus.OK);
	}

}
