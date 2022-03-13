package com.aks.easycheckn.controller.request;

import com.aks.easycheckn.controller.BaseRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
