package com.ausema.demo.jackson;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.SortedMap;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
class UnmodifiableSortedMapMixin {

    @JsonCreator
    public UnmodifiableSortedMapMixin(final SortedMap<?, ?> map) {
    }
}
