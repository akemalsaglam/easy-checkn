package com.aks.easycheckn.controller.mapper;

import com.aks.easycheckn.controller.BaseRequest;
import com.aks.easycheckn.controller.BaseResponse;

import java.util.List;

public interface BaseMapper<Entity, Request extends BaseRequest, Response extends BaseResponse> {

    Response mapEntityToResponse(Entity entity);

    List<Response> mapEntityListToResponseList(List<Entity> entity);

    Entity mapRequestToEntity(Request request);

    List<Entity> mapRequestListToEntitylist(List<Request> request);
}
