package com.ausema.demo.jackson;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.Map;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY)
class UnmodifiableMapMixin {

    @JsonCreator
    public UnmodifiableMapMixin(final Map<?, ?> map) {
    }

}
