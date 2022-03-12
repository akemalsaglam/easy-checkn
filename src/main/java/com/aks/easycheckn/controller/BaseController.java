package com.aks.easycheckn.controller;


import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

public interface BaseController<RequestModel, ResponseModel, ID> {

    Optional<ResponseModel> getById(ID id);

    List<ResponseModel> getAll();

    Optional<ResponseModel> update(@NotNull RequestModel requestModel);

    Optional<ResponseModel> insert(@NotNull RequestModel requestModel);

    void deleteById(ID id);
}
