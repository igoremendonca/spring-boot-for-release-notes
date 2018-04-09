package com.spring.boot.release.pocrelease.controller.to;

import lombok.*;

import javax.validation.constraints.NotEmpty;

@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class ExampleTO {

    @NotEmpty
    private String id;

    @NotEmpty
    private String name;
}
