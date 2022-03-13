package com.aks.easycheckn.repository.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.UUID;


@Data
@NoArgsConstructor
@Entity(name = "event")
public class EventEntity {

    @Id
    @Type(type = "uuid-char")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id = UUID.randomUUID();

    @NotNull
    @NotBlank(message = "Title is mandatory")
    private String title;

    private String description;

    private String addressTitle;

    @NotNull
    @NotBlank(message = "AddressDescription is mandatory")
    private String addressDescription;

    @NotNull
    @NotBlank(message = "PlannedTime is mandatory")
    private Timestamp plannedTime;
}
