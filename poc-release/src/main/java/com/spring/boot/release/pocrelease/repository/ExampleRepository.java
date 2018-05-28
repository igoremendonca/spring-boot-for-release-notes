package com.spring.boot.release.pocrelease.repository;

import com.spring.boot.release.pocrelease.model.Example;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExampleRepository extends CrudRepository <Example, String> {
}
