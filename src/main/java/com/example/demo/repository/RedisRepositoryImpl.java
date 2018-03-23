package com.example.demo.repository;

import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Quiz;

@Repository
public class RedisRepositoryImpl implements RedisRepository {

    private static final String KEY = "Quiz";
    private RedisTemplate<String, Object> redisTemplate;
    private HashOperations<String, Object, Object> hashOperations;
    @Autowired
    public RedisRepositoryImpl(RedisTemplate<String, Object> redisTemplate){
        this.redisTemplate = redisTemplate;
    }
    @PostConstruct
    private void init(){
        hashOperations = redisTemplate.opsForHash();
    }
    public void add(final Quiz q) {
        hashOperations.put(KEY, q.getId(), q);
    }
    public void delete(final Long id) {
        hashOperations.delete(KEY, id);
    }
    public Quiz findQuiz(final Long id){
        return (Quiz) hashOperations.get(KEY, id);
    }
    public Map<Object, Object> findAllQuiz(){
        return hashOperations.entries(KEY);
    }
}