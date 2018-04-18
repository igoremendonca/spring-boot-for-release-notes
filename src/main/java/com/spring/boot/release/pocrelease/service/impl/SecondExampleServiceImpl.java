package com.spring.boot.release.pocrelease.service.impl;

import com.spring.boot.release.pocrelease.model.SecondExample;
import com.spring.boot.release.pocrelease.repository.SecondExampleRepository;
import com.spring.boot.release.pocrelease.service.SecondExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SecondExampleServiceImpl implements SecondExampleService {

    private final SecondExampleRepository secondExampleRepository;

    @Autowired
    public SecondExampleServiceImpl(SecondExampleRepository secondExampleRepository) {
        this.secondExampleRepository = secondExampleRepository;
    }

    @Override
    public SecondExample create(SecondExample example) {
        return secondExampleRepository.save(example);
    }
}
