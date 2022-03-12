package com.aks.easycheckn.controller.mapper;

import com.aks.easycheckn.controller.request.EventRequest;
import com.aks.easycheckn.controller.response.EventResponse;
import com.aks.easycheckn.repository.model.EventEntity;
import org.mapstruct.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Mapper
public interface EventMapper {

    @Mappings({
            @Mapping(target = "id", source = "entity.id"),
            @Mapping(target = "title", source = "entity.title"),
            @Mapping(target = "description", source = "entity.description"),
            @Mapping(target = "addressTitle", source = "entity.addressTitle"),
            @Mapping(target = "addressDescription", source = "entity.addressDescription"),
            @Mapping(target = "plannedTime", source = "entity.plannedTime"),
    })
    @Named("mapEntityToResponse")
    EventResponse mapEntityToResponse(EventEntity entity);

    /*@IterableMapping(qualifiedByName = "mapEntityToResponse")
    List<EventResponse> mapEntityListToResponseList(List<EventEntity> entity);*/

    @Mappings({
            @Mapping(target = "id", source = "request.id"),
            @Mapping(target = "title", source = "request.title"),
            @Mapping(target = "description", source = "request.description"),
            @Mapping(target = "addressTitle", source = "request.addressTitle"),
            @Mapping(target = "addressDescription", source = "request.addressDescription"),
            @Mapping(target = "plannedTime", source = "request.plannedTime"),
    })
    @Named("mapRequestToEntity")
    EventEntity mapRequestToEntity(EventRequest request);

   /* @IterableMapping(qualifiedByName = "mapRequestToEntity")
    List<EventEntity> mapRequestListToEntitylist(List<EventRequest> request);*/
}
