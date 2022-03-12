package com.aks.easycheckn.controller;

import com.aks.easycheckn.controller.mapper.EventMapper;
import com.aks.easycheckn.controller.request.EventRequest;
import com.aks.easycheckn.controller.response.EventResponse;
import com.aks.easycheckn.repository.model.EventEntity;
import com.aks.easycheckn.service.EventService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Validated
@RestController
@RequestMapping(path = "/event")
public class EventController implements BaseController<EventRequest, EventResponse, UUID> {

    private final EventService eventService;
    private EventMapper eventMapper;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/test")
    public String test() {
        return "Hello world!";
    }

    @Override
    @GetMapping("/{id}")
    public Optional<EventResponse> getById(@PathVariable UUID id) {
        final Optional<EventEntity> eventEntity = eventService.findById(id);
        return eventEntity.map(eventMapper::mapEntityToResponse);

    }

    @Override
    @GetMapping("/all")
    public List<EventResponse> getAll() {
        //return eventMapper.mapEntityListToResponseList(eventService.findAll());
        return null;
    }

    @Override
    @PutMapping("/")
    public Optional<EventResponse> update(@RequestBody EventRequest eventRequest) {
        EventEntity eventEntity = eventMapper.mapRequestToEntity(eventRequest);
        final EventEntity updatedEventEntity = eventService.save(eventEntity);
        return Optional.ofNullable(eventMapper.mapEntityToResponse(updatedEventEntity));
    }

    @Override
    @PostMapping("/")
    public Optional<EventResponse> insert(@RequestBody EventRequest eventRequest) {
        EventEntity eventEntity = eventMapper.mapRequestToEntity(eventRequest);
        final EventEntity insertedEventEntity = eventService.save(eventEntity);
        return Optional.ofNullable(eventMapper.mapEntityToResponse(insertedEventEntity));
    }

    @Override
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable UUID id) {
        eventService.deleteById(id);
    }
}


