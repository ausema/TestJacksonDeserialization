package com.ausema.demo.jackson;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class JacksonConfiguration {

    public ObjectMapper objectMapper(){
        return configureMapperForImmutableObjects(new ObjectMapper());
    }

    private ObjectMapper configureMapperForImmutableObjects(final ObjectMapper mapper) {
        return mapper.setVisibility(
                mapper.getVisibilityChecker()
                        .withFieldVisibility(JsonAutoDetect.Visibility.ANY)
                        .withGetterVisibility(JsonAutoDetect.Visibility.NONE)
                        .withSetterVisibility(JsonAutoDetect.Visibility.NONE)
                        .withCreatorVisibility(JsonAutoDetect.Visibility.NONE))
                .activateDefaultTypingAsProperty(mapper.getPolymorphicTypeValidator(), ObjectMapper.DefaultTyping.NON_FINAL, "@class")
                .registerModules(
                        new InmutableCollectionsModule()
                )
                .setSerializationInclusion(JsonInclude.Include.NON_DEFAULT)
                .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
                .disable(SerializationFeature.FAIL_ON_EMPTY_BEANS)
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }
}
