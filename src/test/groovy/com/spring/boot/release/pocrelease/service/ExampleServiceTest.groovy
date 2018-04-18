package com.spring.boot.release.pocrelease.service

import com.spring.boot.release.pocrelease.model.Example
import com.spring.boot.release.pocrelease.repository.ExampleRepository
import com.spring.boot.release.pocrelease.service.impl.ExampleServiceImpl
import spock.lang.Specification


class ExampleServiceTest extends Specification {

    ExampleService exampleService
    def exampleRepository = Mock(ExampleRepository)

    def setup() {
        exampleService = new ExampleServiceImpl(exampleRepository)
    }

    def "should create example" () {
        given: "A example dto"
        def example = Example.builder().id("id").name("name").build()

        when: "Call create example service"
        def result = exampleService.create(example)

        then: "Call create example repository"
        1 * exampleRepository.save(example) >> example
        result == example
    }
}
