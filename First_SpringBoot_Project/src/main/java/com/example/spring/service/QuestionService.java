package com.example.spring.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring.model.Question;
import com.example.spring.model.Score;
import com.example.spring.repository.QuestionRepository;
import com.example.spring.repository.ScoreRepository;

@Service
public class QuestionService {
	@Autowired
    private QuestionRepository questionRepository;
	@Autowired
    private ScoreRepository scoreRepository;

    public Optional<Question> getQuestionByIdAndSubject(Long id, String subject) {
        return questionRepository.findByIdAndSubject(id, subject);
    }
    
 // Fetch a question using id
    public Question getQuestionById(int questionId) {
        return questionRepository.findById((long) questionId).orElseThrow(
                () -> new RuntimeException("Question not found"));
    }

    // Fetch the total score for a user
    public int getTotalScoreForUser(String username) {
        Optional<Score> userScore = scoreRepository.findById(username);
        return userScore.map(Score::getTotalScore).orElse(0);
    }

    // Update the user's score if answer is correct
    public void updateUserScore(String username, int scoreChange) {
        Score userScore = scoreRepository.findById(username)
                .orElse(new Score(username, 0));  // Create new if user not found
        userScore.setTotalScore(userScore.getTotalScore() + scoreChange);
        scoreRepository.save(userScore);
    }
}
