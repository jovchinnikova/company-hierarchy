package com.solvd.companyhierarchy.parsers;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.time.LocalDateTime;

public class DateTimeDeserialize extends StdDeserializer<LocalDateTime> {

    private static final long serialVersionUID = 1L;

    protected DateTimeDeserialize() {
        super(LocalDateTime.class);
    }

    @Override
    public LocalDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
        return LocalDateTime.parse(jsonParser.readValueAs((String.class)));
    }
}
