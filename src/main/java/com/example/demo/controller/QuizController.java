package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import com.example.demo.model.QuizListWrapper;
import com.example.demo.model.Quiz;
import com.example.demo.repository.QuizRepository;
import com.example.demo.repository.RedisRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class QuizController {

	private QuizRepository quizRepository;
	@Autowired
	private RedisRepository redisRepository;

	public QuizController(QuizRepository quizRepository) {
		this.quizRepository = quizRepository;
	}

	//	@PostMapping("/quiz")
	//	@ResponseStatus(HttpStatus.CREATED)
	//	public void addQuiz(@RequestBody Quiz quiz) {
	//		quizRepository.save(quiz);
	//	}

	@GetMapping("/quiz")
	public List<Quiz> getQuestions() {
 
		Map<Object, Object> aa = redisRepository.findAllQuiz(); 
		if (!aa.isEmpty()) {
			//Fetch results from cache
			for(Map.Entry<Object, Object> entry : aa.entrySet()){
			    Quiz q = (Quiz) entry.getValue();
			    System.out.println("FROM CACHE ***"+ q.getId()+"***"+q.getQuestion()+"***"+q.getAnswer()+"***"+q.getExpected()); 
			}
		} else {
			// Fetch from Database
			ListIterator<Quiz> quiz = quizRepository.findAll().listIterator();
			while(quiz.hasNext()){  
				Quiz q = (Quiz) quiz.next();
				//Store in cache
				redisRepository.delete(q.getId());
				redisRepository.add(q);
				System.out.println("FROM DB : Id="+ q.getId()+" Question="+q.getQuestion()+" Answer="+q.getAnswer()+" Expected="+q.getExpected()); 
			     
			}  
		}
		
		return quizRepository.findAll();
	}


	@RequestMapping(value = "/viewQuiz" , method = RequestMethod.GET )
	public ModelAndView viewQuestions() {
		List<Quiz> quizList = new ArrayList<Quiz>();
		Map<Object, Object> aa = redisRepository.findAllQuiz(); 
		if (!aa.isEmpty()) {
			//Fetch results from cache
			for(Map.Entry<Object, Object> entry : aa.entrySet()){
			    Quiz q = (Quiz) entry.getValue();
			    System.out.println("FROM CACHE : Id="+ q.getId()+" Question="+q.getQuestion()+" Answer="+q.getAnswer()+" Expected="+q.getExpected()); 
			    quizList.add(q);
			}
		} else {
			quizList = quizRepository.findAll();
			System.out.println("Fetching from DB...");
			ListIterator<Quiz> quiz = quizList.listIterator();
			while(quiz.hasNext()){  
				Quiz q = (Quiz) quiz.next();
				//Store in cache
				redisRepository.delete(q.getId());
				redisRepository.add(q);
				System.out.println("FROM DB : Id="+ q.getId()+" Question="+q.getQuestion()+" Answer="+q.getAnswer()+" Expected="+q.getExpected()); 
			     
			} 
		}
		
		return new ModelAndView("questions", "questions", quizList);

	}

	@RequestMapping(value = "/answerQuiz" , method = RequestMethod.GET )
	public ModelAndView answerQuestions() {
		return new ModelAndView("index", "questions", quizRepository.findAll());

	}

	@RequestMapping(value="/save", method=RequestMethod.POST)
	public ModelAndView answerSubmit(@ModelAttribute("quizListWrapper") QuizListWrapper quizListWrapper) {

		ListIterator<Quiz> quiz = quizListWrapper.getQuizs().listIterator();
		while(quiz.hasNext()){  
			Quiz q = (Quiz) quiz.next();
			redisRepository.delete(q.getId());
			quizRepository.save(q); 
		}  
		String redirectUrl = "viewQuiz";


		return new ModelAndView("redirect:" + redirectUrl);

	}
}
