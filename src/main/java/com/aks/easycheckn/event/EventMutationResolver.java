package com.aks.easycheckn.event;

import com.aks.commons.controller.AbstractController;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class EventMutationResolver
        extends AbstractController<EventEntity, EventRequest, EventResponse, UUID>
        implements GraphQLMutationResolver {


    public EventMutationResolver(EventService eventService) {
        super(eventService, EventMapper.INSTANCE);
    }

    public Optional<EventResponse> createEvent(EventRequest input) {
        return super.insert(input);
    }

    public Optional<EventResponse> updateEvent(EventRequest input) {
        return super.update(input);
    }

    public boolean deleteEvent(UUID id) {
        try {
            super.deleteById(id);
            return true;
        } catch (Exception ex) {
            return false;
        }

    }

}
