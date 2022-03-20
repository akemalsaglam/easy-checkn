package com.aks.easycheckn.event;

import com.aks.commons.controller.BaseResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.ZonedDateTime;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
public class EventResponse extends BaseResponse {

    private UUID id;
    private String title;
    private String description;
    private String addressTitle;
    private String addressDescription;
    private ZonedDateTime startTime;
    private ZonedDateTime endTime;

}
