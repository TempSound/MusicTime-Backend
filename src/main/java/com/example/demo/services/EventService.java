package com.example.demo.services;

import com.example.demo.contract.domain.model.entities.Event;

import java.util.List;

public interface EventService {
    Event save(Event event);
    List<Event> findAllByCustomerId(Long customerId);
    Event findById(Long id);
}
