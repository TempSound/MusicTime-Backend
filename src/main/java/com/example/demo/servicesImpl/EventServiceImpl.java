package com.example.demo.servicesImpl;

import com.example.demo.entities.Event;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.repositories.EventRepository;
import com.example.demo.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService {
    @Autowired
    private EventRepository eventRepository;
    @Override
    public Event save(Event event) {
        return eventRepository.save(event);
    }

    @Override
    public List<Event> findAllByCustomerId(Long customerId) {
        return eventRepository.findAllByCustomerId(customerId);
    }

    @Override
    public Event findById(Long id) {
      Event event=eventRepository.findById(id).get();
      if(event==null)  throw  new ResourceNotFoundException("Evento no encontrado");
      return event;
    }
}
