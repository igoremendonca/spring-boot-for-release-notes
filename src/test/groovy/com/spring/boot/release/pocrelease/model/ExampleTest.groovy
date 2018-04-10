package com.spring.boot.release.pocrelease.model

import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

import javax.validation.Validation
import javax.validation.Validator

class ExampleTest extends Specification {

    @Shared
    Validator validator

    def setup() {
        validator = Validation.buildDefaultValidatorFactory().getValidator()
    }

    def "should create valid example entity"() {
        given: "Valid parameters"
        def id = "ID"
        def name = "Name"

        when: "Instance a example"
        def example = Example.builder().id(id).name(name).build()
        validator.validate(example)

        then: "No Exception Throw"
        example != null
        noExceptionThrown()
    }

    @Unroll
    def "should not create example when #field is #value"() {
        when:
        def example = Example.builder().id(id).name(name).build()
        def errors = validator.validate(example)

        then:
        (++errors.iterator()).getPropertyPath().toString() == field

        where:
        id   | name   || field  | value
        null | "Name" || "id"   | "null"
        ""   | "Name" || "id"   | "empty"
        "id" | null   || "name" | "null"
        "id" | ""     || "name" | "empty"
    }
}
