package com.example.demo.services;

import com.example.demo.entities.Event;

import java.util.List;
import java.util.Optional;

public interface EventService {
    Event save(Event event);
    List<Event> findAllByCustomerId(Long customerId);
    Event findById(Long id);
}
