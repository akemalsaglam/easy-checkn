package com.aks.easycheckn.event;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class EventResolver implements GraphQLQueryResolver {

    private final EventService eventService;

    /*public Optional<EventResponse> getEvent(String id) {
        final Optional<EventEntity> eventEntity = eventService.findById(id);
        return eventEntity.map(EventMapper.INSTANCE::mapEntityToResponse);
    }*/

    public List<EventResponse> getEvents() {
        return EventMapper.INSTANCE.mapEntityListToResponseList(eventService.findAll());
    }

}
