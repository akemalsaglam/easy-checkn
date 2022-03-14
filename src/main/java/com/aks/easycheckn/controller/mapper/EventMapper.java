package com.aks.easycheckn.controller.mapper;

import com.aks.commons.mapper.BaseMapper;
import com.aks.easycheckn.controller.request.EventRequest;
import com.aks.easycheckn.controller.response.EventResponse;
import com.aks.easycheckn.repository.model.EventEntity;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface EventMapper extends BaseMapper<EventEntity, EventRequest, EventResponse> {

    EventMapper INSTANCE = Mappers.getMapper(EventMapper.class);

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

    @IterableMapping(qualifiedByName = "mapEntityToResponse")
    @Named("mapEntityListToResponseList")
    List<EventResponse> mapEntityListToResponseList(List<EventEntity> entity);

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

    @IterableMapping(qualifiedByName = "mapRequestToEntity")
    @Named("mapRequestListToEntitylist")
    List<EventEntity> mapRequestListToEntitylist(List<EventRequest> request);
}
