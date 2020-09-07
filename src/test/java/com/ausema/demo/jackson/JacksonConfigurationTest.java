package com.ausema.demo.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.NavigableMap;
import java.util.SortedMap;
import java.util.TreeMap;

import static org.assertj.core.api.Assertions.assertThat;

class JacksonConfigurationTest {

    @Test
    public void shouldDeserialzeUnmmodifiableSortedMap() throws IOException {
        JacksonConfiguration jacksonConfiguration = new JacksonConfiguration();
        ObjectMapper objectMapper = jacksonConfiguration.objectMapper();
        final TreeMap<String, String> map = new TreeMap<>();
        map.put("1", "2");
        map.put("2", "3");

        final SortedMap<String, String> sortedMapSource = Collections.unmodifiableSortedMap(map);

        final byte[] bytes = objectMapper.writeValueAsBytes(sortedMapSource);

        final SortedMap sortedMap = objectMapper.readValue(bytes, SortedMap.class);
        assertThat(sortedMap).hasSize(2);
    }

    @Test
    public void shouldDeserialzeUnmmodifiableNavigableMap() throws IOException {
        JacksonConfiguration jacksonConfiguration = new JacksonConfiguration();
        ObjectMapper objectMapper = jacksonConfiguration.objectMapper();
        final TreeMap<String, String> map = new TreeMap<>();
        map.put("1", "2");
        map.put("2", "3");

        final NavigableMap<String, String> navigableMapSource = Collections.unmodifiableNavigableMap(map);

        final byte[] bytes = objectMapper.writeValueAsBytes(navigableMapSource);

        final NavigableMap sortedMap = objectMapper.readValue(bytes, NavigableMap.class);

        assertThat(sortedMap).hasSize(2);
    }


    @Test
    public void shouldDeserialzeUnmmodifiableCollection() throws IOException {
        JacksonConfiguration jacksonConfiguration = new JacksonConfiguration();
        ObjectMapper objectMapper = jacksonConfiguration.objectMapper();
        final List<String> strings = Arrays.asList("1", "2");
        final Collection<String> unmodifiableCollection = Collections.unmodifiableCollection(strings);

        final byte[] bytes = objectMapper.writeValueAsBytes(unmodifiableCollection);

        final Collection collection = objectMapper.readValue(bytes, Collection.class);

        assertThat(collection).hasSize(2);
    }


}