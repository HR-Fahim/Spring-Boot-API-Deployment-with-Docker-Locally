package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/actuator")
public class HealthController {

    @GetMapping("/health")
    public Map<String, Object> healthCheck() {
        Map<String, Object> response = new HashMap<>();
        response.put("status", "GOOD");

        // Adding random user example info
        Map<String, Object> userInfo = new HashMap<>();
        userInfo.put("name", "Habibur Rahaman Fahim");
        userInfo.put("age", 25);
        userInfo.put("email", "hrfprofessional@gmail.com");
        response.put("user", userInfo);

        // Add more example info as needed

        return response;
    }
}
