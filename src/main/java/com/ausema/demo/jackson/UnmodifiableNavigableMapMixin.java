package com.ausema.demo.jackson;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.NavigableMap;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
class UnmodifiableNavigableMapMixin {

    @JsonCreator
    public UnmodifiableNavigableMapMixin(final NavigableMap<?, ?> navigableMap) {
    }

}
