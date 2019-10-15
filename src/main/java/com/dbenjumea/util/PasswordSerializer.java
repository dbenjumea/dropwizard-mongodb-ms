package com.dbenjumea.util;


import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class PasswordSerializer extends JsonSerializer<String> {

    @Override
    public void serialize(String input, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeString(input.toCharArray(), 0, input.toCharArray().length);
    }

    @Override
    public Class<String> handledType() {
        return String.class;
    }
}
