package com.spring.boot.release.pocrelease.service.impl;

import com.spring.boot.release.pocrelease.model.Example;
import com.spring.boot.release.pocrelease.repository.ExampleRepository;
import com.spring.boot.release.pocrelease.service.ExampleService;
import com.spring.boot.release.pocrelease.service.exception.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExampleServiceImpl implements ExampleService {

    private final ExampleRepository exampleRepository;

    @Autowired
    public ExampleServiceImpl(ExampleRepository exampleRepository) {
        this.exampleRepository = exampleRepository;
    }

    @Override
    public Example create(Example example) {
        return exampleRepository.save(example);
    }

    @Override
    public Example get(String exampleId) {
        return exampleRepository.findById(exampleId).orElseThrow(EntityNotFoundException::new);
    }
}