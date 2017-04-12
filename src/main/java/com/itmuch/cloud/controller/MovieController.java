package com.itmuch.cloud.controller;

import com.itmuch.cloud.entity.User;
import com.itmuch.cloud.feign.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MovieController {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UserFeignClient userFeignClient;

    @Value("${user.userServicePath}")
    private String userServicePath;

    /**
     * 使用原始的RestTemplate直连服务提供者
     *
     * @param id
     * @return
     */
    @GetMapping("/old/movie/{id}")
    public User findByIdAndRestTemplate(@PathVariable Long id) {
        return restTemplate.getForObject(this.userServicePath + id, User.class);
    }

    @GetMapping("/movie/{id}")
    public User findById(@PathVariable Long id) {
        return userFeignClient.findById(id);
    }

    @GetMapping("/test")
    public User testPost(User user) {
        return userFeignClient.postUser(user);
    }

    @GetMapping("/test-get")
    public User testGet(User user) {
        return userFeignClient.getUser(user);
    }

}
