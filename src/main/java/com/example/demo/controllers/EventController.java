package com.example.demo.controllers;

import com.example.demo.entities.Event;
import com.example.demo.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/events")
@CrossOrigin(origins = "http://localhost:4200")
public class EventController {
    @Autowired
    private EventService eventService;
    @PostMapping
    public Event addEvent(@RequestBody Event event) {
        return eventService.save(event);
    }
    @GetMapping("/{id}")
    public List<Event> getEvents(@PathVariable long id) {
        return eventService.findAllByCustomerId(id);
    }
    @GetMapping("/retrieve/{id}")
    public Event getEvent(@PathVariable long id) {
        return eventService.findById(id);
    }
}
