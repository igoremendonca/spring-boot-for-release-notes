package com.spring.boot.release.pocrelease.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Builder
@Getter
@EqualsAndHashCode
public class ThirdExample {

    @Id
    @NotEmpty
    private String id;

    @NotEmpty
    private String property;

    @NotNull
    private Double value;
}
