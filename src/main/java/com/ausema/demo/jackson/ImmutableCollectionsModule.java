package com.ausema.demo.jackson;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.util.Collections;

public class ImmutableCollectionsModule extends SimpleModule {

    public ImmutableCollectionsModule() {
        super(ImmutableCollectionsModule.class.getName(), new Version(1, 0, 0, null, null, null));
    }

    @Override
    public void setupModule(final SetupContext context) {
        context.setMixInAnnotations(Collections.unmodifiableSortedMap(Collections.emptySortedMap()).getClass(), UnmodifiableSortedMapMixin.class);
        context.setMixInAnnotations(Collections.unmodifiableCollection(Collections.emptyList()).getClass(), UnmodifiableCollectionMixin.class);
        context.setMixInAnnotations(Collections.unmodifiableNavigableMap(Collections.emptyNavigableMap()).getClass(), UnmodifiableNavigableMapMixin.class);
    }
}
