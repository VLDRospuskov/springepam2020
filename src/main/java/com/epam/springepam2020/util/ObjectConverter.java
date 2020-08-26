package com.epam.springepam2020.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ObjectConverter {

    private final ObjectMapper objectMapper;

    public <T> T convert(Object object, Class<T> type) {
        return objectMapper.convertValue(object, type);
    }

    public <T> List<T> convertToList(Iterable<?> iterable, Class<T> elementType) {
        List<T> result = new ArrayList<>();
        for (Object object : iterable) {
            if (object != null) {
                T converted = convert(object, elementType);
                result.add(converted);
            }
        }
        return result;
    }

}
