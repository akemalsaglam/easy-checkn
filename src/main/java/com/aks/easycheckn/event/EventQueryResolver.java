package com.aks.easycheckn.event;

import com.aks.commons.controller.AbstractController;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class EventQueryResolver
        extends AbstractController<EventEntity, EventRequest, EventResponse, UUID>
        implements GraphQLQueryResolver {

    @Autowired
    public EventQueryResolver(EventService eventService) {
        super(eventService, EventMapper.INSTANCE);
    }

    public Optional<EventResponse> getEvent(UUID id) {
        return super.getById(id);
    }

    public List<EventResponse> getEvents() {
        return super.getAll();
    }

}
