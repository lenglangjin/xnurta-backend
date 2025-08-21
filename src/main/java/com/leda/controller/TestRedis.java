package com.leda.controller;

import com.leda.service.ILedaUserService;
import com.leda.utils.uuid.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.DefaultTypedTuple;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
public class TestRedis {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private ILedaUserService userService;

    @GetMapping("/testRedis")
    public void testRedis(){
        long l = System.currentTimeMillis();
        for (int i = 0; i < 1; i++) {
            String string = UUID.randomUUID().toString();
            redisTemplate.opsForValue().set("short:"+string,string);
        }
        System.out.println(System.currentTimeMillis()-l);

        redisTemplate.opsForValue().set("short","short");

        long s = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            redisTemplate.opsForValue().get("short");
        }
        System.out.println("time:"+(System.currentTimeMillis()-s));

        Map<String,String> user = new HashMap<>();

        user.put("name","leda");
        user.put("age","18");
        user.put("sex","男");
        user.put("phone","12345678901");
        redisTemplate.opsForHash().putAll("user:1",user);


        redisTemplate.opsForList().leftPushAll("list","132","456","789");


        redisTemplate.opsForSet().add("set","123","456","789");

        ZSetOperations.TypedTuple typedTuple = new DefaultTypedTuple("123",1.0);

        redisTemplate.opsForZSet().add("zset","123",1);



    }


}
