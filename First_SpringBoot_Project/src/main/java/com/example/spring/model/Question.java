package com.example.spring.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Question {

	@Id
    private Long id;
    private String correctAnswer;
    private String explanation;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String questionText;
    private String subject;
    private Integer topicId;
    private String options; 
    private String question;
	
	public Question(Long id, String correctAnswer, String explanation, String option1, String option2, String option3,
			String option4, String questionText, String subject, Integer topicId, String options, String question) {
		super();
		this.id = id;
		this.correctAnswer = correctAnswer;
		this.explanation = explanation;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
		this.option4 = option4;
		this.questionText = questionText;
		this.subject = subject;
		this.topicId = topicId;
		this.options = options;
		this.question = question;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCorrectAnswer() {
		return correctAnswer;
	}
	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}
	public String getExplanation() {
		return explanation;
	}
	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}
	public String getOption1() {
		return option1;
	}
	public void setOption1(String option1) {
		this.option1 = option1;
	}
	public String getOption2() {
		return option2;
	}
	public void setOption2(String option2) {
		this.option2 = option2;
	}
	public String getOption3() {
		return option3;
	}
	public void setOption3(String option3) {
		this.option3 = option3;
	}
	public String getOption4() {
		return option4;
	}
	public void setOption4(String option4) {
		this.option4 = option4;
	}
	public String getQuestionText() {
		return questionText;
	}
	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public Integer getTopicId() {
		return topicId;
	}
	public void setTopicId(Integer topicId) {
		this.topicId = topicId;
	}
	public String getOptions() {
		return options;
	}
	public void setOptions(String options) {
		this.options = options;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	} 
	public Question() {} 

}