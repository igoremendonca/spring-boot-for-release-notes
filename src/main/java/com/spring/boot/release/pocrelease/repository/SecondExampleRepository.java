package com.spring.boot.release.pocrelease.repository;

import com.spring.boot.release.pocrelease.model.SecondExample;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecondExampleRepository extends CrudRepository <SecondExample, String> {
}
