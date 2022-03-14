package com.aks.easycheckn.controller.request;

import com.aks.commons.controller.BaseRequest;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.UUID;

@Data
public class EventRequest extends BaseRequest {

    private UUID id;

    @NotNull
    @NotBlank(message = "Title is mandatory")
    private String title;

    private String description;

    private String addressTitle;

    @NotNull
    @NotBlank(message = "AddressDescription is mandatory")
    private String addressDescription;

    @NotNull
    private Timestamp plannedTime;

}
