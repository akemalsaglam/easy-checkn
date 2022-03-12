package com.aks.easycheckn.controller.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.UUID;


public class EventResponse {

    private UUID id;
    private String title;
    private String description;
    private String addressTitle;
    private String addressDescription;
    private Timestamp plannedTime;

    public EventResponse() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddressTitle() {
        return addressTitle;
    }

    public void setAddressTitle(String addressTitle) {
        this.addressTitle = addressTitle;
    }

    public String getAddressDescription() {
        return addressDescription;
    }

    public void setAddressDescription(String addressDescription) {
        this.addressDescription = addressDescription;
    }

    public Timestamp getPlannedTime() {
        return plannedTime;
    }

    public void setPlannedTime(Timestamp plannedTime) {
        this.plannedTime = plannedTime;
    }
}
