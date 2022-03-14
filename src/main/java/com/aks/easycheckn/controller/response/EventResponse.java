package com.aks.easycheckn.controller.response;

import com.aks.commons.controller.BaseResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.sql.Timestamp;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
public class EventResponse extends BaseResponse {

    private UUID id;
    private String title;
    private String description;
    private String addressTitle;
    private String addressDescription;
    private Timestamp plannedTime;

}
