package it.adebiasi.primes.primeservice.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class InlineListDeserializer extends JsonSerializer<ArrayList<Long>> {

    @Override
    public void serialize(ArrayList<Long> value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeString("[" + value.stream().map(String::valueOf).collect(Collectors.joining(",")) + "]");
    }
}
