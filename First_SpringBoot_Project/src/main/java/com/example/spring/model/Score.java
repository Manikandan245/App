package com.example.spring.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Score {
	@Id
    private String username;
    private int totalScore;
    public Score(String username, int totalScore) {
        this.username = username;
        this.totalScore = totalScore;
    }
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getTotalScore() {
		return totalScore;
	}
	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}
	public Score() {
    }
}
