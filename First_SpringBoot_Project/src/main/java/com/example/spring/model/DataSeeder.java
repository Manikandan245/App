package com.example.spring.model;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.spring.repository.QuestionRepository;

@Component
public class DataSeeder implements CommandLineRunner{
	@Autowired
    private QuestionRepository questionRepository;

    @Override
    public void run(String... args) throws Exception {
       
        if (questionRepository.count() != 0) {
            // Questions for maths
            questionRepository.saveAll(Arrays.asList(
                new Question(11L, "4", "Adding two and two gives four.", "1", "2", "3", "4", "What is 2 + 2?", "Maths", 1, null, null),
                new Question(12L, "15", "Three times five equals fifteen.", "5", "10", "15", "20", "What is 3 * 5?", "Maths", 1, null, null),
                new Question(13L, "8", "The sum of 5 and 3 is eight.", "5", "6", "7", "8", "What is 5 + 3?", "Maths", 1, null, null),
                new Question(14L, "9", "The square of 3 is nine.", "6", "7", "8", "9", "What is the square of 3?", "Maths", 1, null, null),
                new Question(15L, "30", "Three times ten equals thirty.", "20", "25", "30", "35", "What is 3 * 10?", "Maths", 1, null, null)
            ));

            //Questions for Science
            questionRepository.saveAll(Arrays.asList(
                new Question(16L, "Water", "H2O is the chemical formula for water.", "Water", "Hydrogen", "Oxygen", "Salt", "What is H2O?", "Science", 1, null, null),
                new Question(17L, "100°C", "Water boils at 100 degrees Celsius.", "50°C", "100°C", "150°C", "0°C", "What is the boiling point of water?", "Science", 1, null, null),
                new Question(18L, "Sun", "The Sun is the center of our solar system.", "Earth", "Mars", "Jupiter", "Sun", "What is the center of our solar system?", "Science", 1, null, null),
                new Question(19L, "Carbon Dioxide", "Plants absorb Carbon Dioxide for photosynthesis.", "Oxygen", "Nitrogen", "Carbon Dioxide", "Hydrogen", "What do plants absorb for photosynthesis?", "Science", 1, null, null),
                new Question(20L, "Electromagnetic Spectrum", "Light is part of the electromagnetic spectrum.", "Sound", "Gravity", "Electromagnetic Spectrum", "Magnetism", "What type of spectrum does light belong to?", "Science", 1, null, null)
            ));

            // Sample Questions for Tamil
            questionRepository.saveAll(Arrays.asList(
                new Question(21L, "Chennai", "Chennai is the capital city of Tamil Nadu.", "Chennai", "madurai", "kovai", "trichy", "What is the capital of Tamil Nadu?", "Tamil", 1, null, null),
                new Question(22L, "Nile", "The Nile is the longest river in the world.", "ganga", "yamuna", "kaveri", "thamirabarani", "What is the longest river in the world?", "Tamil", 1, null, null),
                new Question(23L, "Mount Everest", "Mount Everest is the tallest mountain in the world.", "himalaya", "Mount Everest", "Rockfort", "Palanimalai", "What is the tallest mountain in the world?", "Tamil", 1, null, null),
                new Question(24L, "Australia", "Australia is both a country and a continent.","india", "USA", "Rockfort", "Australia", "What is both a country and a continent?", "Tamil", 1, null, null),
                new Question(25L, "Pacific Ocean", "The Pacific Ocean is the largest ocean on Earth.", "Marina", "Vangalaviriguda", "Indian Ocean", "Pacific Ocean", "What is the largest ocean on Earth?", "Tamil", 1, null, null)
            ));
        }
    }
}
