//package com.example.back.cache;
//
//import com.example.back.entity.Scores;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.stereotype.Service;
//
//import javax.annotation.Resource;
//import java.util.concurrent.TimeUnit;
//
//@Service
//public class AdminCacheService {
//    @Resource
//    private RedisTemplate<String, String> redisTemplate;
//
//    private static final String scoresIndex = "Scores:";
//
//    public void putScoresInfo(Scores scores){
//        String scoreline = scores.getMathScore().toString() + ";" + scores.getJavaScore().toString() + ";" + scores.getEngScore().toString() +  ";" + scores.getPeScore().toString() +  ";" + scores.getSumScore().toString();
//        redisTemplate.opsForSet().add(scoresIndex + scores.getId(), scoreline);
//        redisTemplate.expire(scoresIndex + scores.getId(), 1, TimeUnit.DAYS);
//    }
//}
