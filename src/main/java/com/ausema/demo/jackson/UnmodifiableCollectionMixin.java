package com.ausema.demo.jackson;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.Collection;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
class UnmodifiableCollectionMixin {

    @JsonCreator
    public UnmodifiableCollectionMixin(final Collection<?> collection) {
        //Nothing todo, only to be able to create instance of unmodifiable collection
    }

}
