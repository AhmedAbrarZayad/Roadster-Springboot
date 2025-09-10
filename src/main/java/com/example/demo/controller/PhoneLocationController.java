package com.example.demo.controller;

import com.example.demo.models.PhoneLocation;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Controller
public class PhoneLocationController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/location")
    @SendTo("/topic/locations")
    public PhoneLocation updateLocation(PhoneLocation location) throws Exception {
        // Use the timestamp from the Android app (Unix timestamp in milliseconds)
        // Don't override it unless it's null
        if (location.getTimestamp() == null) {
            location.setTimestamp(System.currentTimeMillis());
        }
        
        // Log the received location
        System.out.println("Received location update: " + location);
        
        // Broadcast to all connected clients
        return location;
    }

    // REST endpoint for direct HTTP POST (alternative to WebSocket)
    @PostMapping("/api/location")
    @ResponseBody
    public PhoneLocation updateLocationRest(@RequestBody PhoneLocation location) {
        if (location.getTimestamp() == null) {
            location.setTimestamp(System.currentTimeMillis());
        }
        
        System.out.println("Received location via REST: " + location);
        
        // Broadcast via WebSocket to connected clients
        messagingTemplate.convertAndSend("/topic/locations", location);
        
        return location;
    }

    // Get endpoint for testing
    @GetMapping("/api/location/test")
    @ResponseBody
    public String test() {
        return "Location service is running!";
    }
}
