package com.example.spring.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.model.Question;
import com.example.spring.service.QuestionService;

@RestController
@RequestMapping("/api/questions")
public class QuestionController {
	@Autowired
    private QuestionService questionService;
    
    private Map<String, Integer> userScores = new HashMap<>();

    @GetMapping("/{id}/{subject}")
    public ResponseEntity<?> getQuestionByIdAndSubject(@PathVariable Long id, @PathVariable String subject) {
        
        Optional<Question> questionOptional = questionService.getQuestionByIdAndSubject(id, subject);
        if (questionOptional.isPresent()) {
            Question question = questionOptional.get();
            
            return ResponseEntity.ok(Map.of(
                "questionText", question.getQuestionText(),
                "options", List.of(question.getOption1(), question.getOption2(), question.getOption3(), question.getOption4())
            ));
        } else {
            return ResponseEntity.status(404).body(Map.of("message", "Question not found for the given id and subject"));
        }
    }
    
    //for validating user answer and updating score
    @PostMapping("/answer")
    public ResponseEntity<?> answerQuestion(
            @RequestParam String username,
            @RequestParam int questionId,
            @RequestParam String userAnswer) {

        // get the question using by id
        Question question = questionService.getQuestionById(questionId);

        //validation for user answer
        boolean isCorrect = question.getCorrectAnswer().equals(userAnswer);
        int scoreChange = isCorrect ? 10 : -10;

        // Update the user score in the database
        questionService.updateUserScore(username, scoreChange);

        //answer validation
        String resultMessage = isCorrect ? "Wow it is a Correct answer !" : "Sorry it is a Wrong answer !";
        return ResponseEntity.ok(Map.of(
                "username", username,
                "result", resultMessage,
                "currentScoreChange", scoreChange,
                "totalScore", questionService.getTotalScoreForUser(username)
        ));
    }
    
    //for checking total score
    @GetMapping("/score")
    public ResponseEntity<?> getUserTotalScore(@RequestParam String username) {
        // Fetch the total score from the database using the service
        int totalScore = questionService.getTotalScoreForUser(username);

        return ResponseEntity.ok(Map.of("username", username, "totalScore", totalScore));
    }
}