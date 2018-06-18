package com.spring.boot.release.pocrelease.model

import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

import javax.validation.Validation
import javax.validation.Validator

class ThirdExampleTest extends Specification {

    @Shared
    Validator validator

    def setup() {
        validator = Validation.buildDefaultValidatorFactory().getValidator()
    }

    def "should create valid third example entity"() {
        given: "Valid parameters"
        def id = "ID"
        def property = "Property"
        def value = 1.5F

        when: "Instance a example"
        def example = ThirdExample.builder().id(id).property(property).value(value).build()
        validator.validate(example)

        then: "No Exception Throw"
        example != null
        noExceptionThrown()
    }

    @Unroll
    def "should not create third example when #field is #valueF"() {
        when:
        def example = ThirdExample.builder().id(id).property(property).value(value).build()
        def errors = validator.validate(example)

        then:
        (++errors.iterator()).getPropertyPath().toString() == field

        where:
        id   | property   | value || field      | valueF
        null | "property" | 1.5F  || "id"       | "null"
        ""   | "property" | 1.5F  || "id"       | "empty"
        "id" | "property" | null  || "value"    | "null"
        "id" | null       | 1.5F  || "property" | "null"
        "id" | ""         | 1.5F  || "property" | "empty"
    }
}
