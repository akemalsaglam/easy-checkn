package com.aks.easycheckn.service;

import com.aks.easycheckn.repository.model.EventEntity;
import com.aks.easycheckn.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EventService implements BaseService<EventEntity, UUID> {

    private final EventRepository eventRepository;

    @Autowired
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public EventEntity save(EventEntity eventEntity) {
        return eventRepository.save(eventEntity);
    }

    @Override
    public EventEntity saveAndFlush(EventEntity eventEntity) {
        return eventRepository.saveAndFlush(eventEntity);
    }

    @Override
    public List<EventEntity> findAll() {
        return eventRepository.findAll();
    }

    @Override
    public Optional<EventEntity> findById(UUID id) {
        return eventRepository.findById(id);
    }

    @Override
    public void deleteById(UUID id) {
        eventRepository.deleteById(id);
    }
}
