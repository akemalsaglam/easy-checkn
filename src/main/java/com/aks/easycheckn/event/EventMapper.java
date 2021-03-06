package com.aks.easycheckn.event;

import com.aks.commons.mapper.BaseMapper;
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
            @Mapping(target = "startTime", source = "entity.startTime"),
            @Mapping(target = "endTime", source = "entity.endTime"),
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
            @Mapping(target = "startTime", source = "request.startTime"),
            @Mapping(target = "endTime", source = "request.endTime"),
    })
    @Named("mapRequestToEntity")
    EventEntity mapRequestToEntity(EventRequest request);

    @IterableMapping(qualifiedByName = "mapRequestToEntity")
    @Named("mapRequestListToEntitylist")
    List<EventEntity> mapRequestListToEntitylist(List<EventRequest> request);
}
