package com.spring.boot.release.pocrelease.model;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
@Getter
public class Example {

    @Id
    private String id;

    @NotEmpty
    private String name;
}
