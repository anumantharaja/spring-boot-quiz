package com.example.demo.repository;

import java.util.Map;

import com.example.demo.model.Quiz;

public interface RedisRepository {
    Map<Object, Object> findAllQuiz();
    void add(Quiz q);
    void delete(Long id);
    Quiz findQuiz(Long id);
}