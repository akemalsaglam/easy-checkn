package com.aks.easycheckn.controller;

import com.aks.easycheckn.controller.mapper.EventMapper;
import com.aks.easycheckn.controller.request.EventRequest;
import com.aks.easycheckn.controller.response.EventResponse;
import com.aks.easycheckn.repository.model.EventEntity;
import com.aks.easycheckn.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@Validated
@RestController
@RequestMapping(path = "/event")
public class EventController extends AbstractController<EventEntity, EventRequest, EventResponse, UUID> {

    @Autowired
    public EventController(EventService eventService) {
        super(eventService, EventMapper.INSTANCE);
    }

    @Override
    @GetMapping("/{id}")
    public Optional<EventResponse> getById(@PathVariable UUID id) {
        return super.getById(id);
    }

    @Override
    @GetMapping("/")
    public List<EventResponse> getAll() {
        return super.getAll();
    }

    @Override
    @PutMapping("/")
    public Optional<EventResponse> update(@RequestBody EventRequest eventRequest) {
        return super.update(eventRequest);
    }

    @Override
    @PostMapping("/")
    public Optional<EventResponse> insert(@RequestBody EventRequest eventRequest) {
        return super.insert(eventRequest);
    }

    @Override
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable UUID id) {
        super.deleteById(id);
    }

}


