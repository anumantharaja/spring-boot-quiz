package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Quiz implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -4638165055874488270L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String question;
    private String expected; 
    private String answer;
    
    public Quiz() {
    	
    }
    public Quiz(Long id, String question, String expected, String answer) {
		this.id = id;
		this.question = question;
		this.expected = expected;
		this.answer = answer;

	}
    
	public long getId() {
		return id;
	}
	public String getIdString() {
		return Long.toString(id);
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getExpected() {
		return expected;
	}
	public void setExpected(String expected) {
		this.expected = expected;
	}

}

    