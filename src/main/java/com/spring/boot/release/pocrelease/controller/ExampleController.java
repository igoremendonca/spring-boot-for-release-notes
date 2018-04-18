package com.spring.boot.release.pocrelease.controller;

import com.spring.boot.release.pocrelease.controller.to.ExampleTO;
import com.spring.boot.release.pocrelease.model.Example;
import com.spring.boot.release.pocrelease.service.ExampleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Controller
public class ExampleController {

    private final ExampleService exampleService;
    private final ModelMapper modelMapper;

    @Autowired
    public ExampleController(ExampleService exampleService, ModelMapper modelMapper) {
        this.exampleService = exampleService;
        this.modelMapper = modelMapper;
    }

    @ResponseStatus(CREATED)
    @PostMapping(value = "/v1/examples/", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public String create(ExampleTO exampleTO) {
        return exampleService.create(modelMapper.map(exampleTO, Example.class)).getId();
    }

    @ResponseStatus(OK)
    @GetMapping(value = "/v1/examples/", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ExampleTO get(String exampleId) {
        return modelMapper.map(exampleService.get(exampleId), ExampleTO.class);
    }
}
