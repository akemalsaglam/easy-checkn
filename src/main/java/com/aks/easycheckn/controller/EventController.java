package com.aks.easycheckn.controller;

import com.aks.easycheckn.controller.mapper.EventMapper;
import com.aks.easycheckn.controller.request.EventRequest;
import com.aks.easycheckn.controller.response.EventResponse;
import com.aks.easycheckn.repository.model.EventEntity;
import com.aks.easycheckn.service.EventService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@Validated
@RestController
@RequestMapping(path = "/event")
public class EventController implements BaseController<EventRequest, EventResponse, UUID> {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @Override
    @GetMapping("/{id}")
    public Optional<EventResponse> getById(@Valid @PathVariable UUID id) {
        final Optional<EventEntity> eventEntity = eventService.findById(id);
        return eventEntity.map(EventMapper.INSTANCE::mapEntityToResponse);
    }

    @Override
    @GetMapping("/")
    public List<EventResponse> getAll() {
        return EventMapper.INSTANCE.mapEntityListToResponseList(eventService.findAll());
    }

    @Override
    @PutMapping("/")
    public Optional<EventResponse> update(@RequestBody EventRequest eventRequest) {
        EventEntity eventEntity = EventMapper.INSTANCE.mapRequestToEntity(eventRequest);
        final EventEntity updatedEventEntity = eventService.save(eventEntity);
        return Optional.ofNullable(EventMapper.INSTANCE.mapEntityToResponse(updatedEventEntity));
    }

    @Override
    @PostMapping("/")
    public Optional<EventResponse> insert(@Valid @RequestBody EventRequest eventRequest) {
        EventEntity eventEntity = EventMapper.INSTANCE.mapRequestToEntity(eventRequest);
        final EventEntity insertedEventEntity = eventService.save(eventEntity);
        return Optional.ofNullable(EventMapper.INSTANCE.mapEntityToResponse(insertedEventEntity));
    }

    @Override
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable UUID id) {
        eventService.deleteById(id);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}


