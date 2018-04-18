package com.spring.boot.release.pocrelease.model;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Builder
@Getter
public class SecondExample {

    @Id
    @NotEmpty
    private String id;

    @NotNull
    private Double value;
}
