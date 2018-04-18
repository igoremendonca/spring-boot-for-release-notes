package com.spring.boot.release.pocrelease.model

import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

import javax.validation.Validation
import javax.validation.Validator

class SecondExampleTest extends Specification {

    @Shared
    Validator validator

    def setup() {
        validator = Validation.buildDefaultValidatorFactory().getValidator()
    }

    def "should create valid second example entity"() {
        given: "Valid parameters"
        def id = "ID"
        def name = 1.5D

        when: "Instance a example"
        def example = SecondExample.builder().id(id).value(name).build()
        validator.validate(example)

        then: "No Exception Throw"
        example != null
        noExceptionThrown()
    }

    @Unroll
    def "should not create second example when #field is #valueF"() {
        when:
        def example = SecondExample.builder().id(id).value(value).build()
        def errors = validator.validate(example)

        then:
        (++errors.iterator()).getPropertyPath().toString() == field

        where:
        id   | value || field   | valueF
        null | 1.5D  || "id"    | "null"
        ""   | 1.5D  || "id"    | "empty"
        "id" | null  || "value" | "null"
    }
}
