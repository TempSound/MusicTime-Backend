package com.example.demo.repositories;

import com.example.demo.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface EventRepository extends JpaRepository<Event, Long> {
    @Query("select e from Event e where e.musical.id=:id or e.customer.id=:id")
    public List<Event> findAllByCustomerId(Long id);
    public Optional<Event> findById(Long id);
}