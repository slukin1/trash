package com.google.gson;

import com.google.gson.internal.Streams;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.MalformedJsonException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

public final class JsonParser {
    public JsonElement parse(String str) throws JsonSyntaxException {
        return parse((Reader) new StringReader(str));
    }

    public JsonElement parse(Reader reader) throws JsonIOException, JsonSyntaxException {
        try {
            JsonReader jsonReader = new JsonReader(reader);
            JsonElement parse = parse(jsonReader);
            if (!parse.isJsonNull()) {
                if (jsonReader.peek() != JsonToken.END_DOCUMENT) {
                    throw new JsonSyntaxException("Did not consume the entire document.");
                }
            }
            return parse;
        } catch (MalformedJsonException e11) {
            throw new JsonSyntaxException((Throwable) e11);
        } catch (IOException e12) {
            throw new JsonIOException((Throwable) e12);
        } catch (NumberFormatException e13) {
            throw new JsonSyntaxException((Throwable) e13);
        }
    }

    public JsonElement parse(JsonReader jsonReader) throws JsonIOException, JsonSyntaxException {
        boolean isLenient = jsonReader.isLenient();
        jsonReader.setLenient(true);
        try {
            JsonElement parse = Streams.parse(jsonReader);
            jsonReader.setLenient(isLenient);
            return parse;
        } catch (StackOverflowError e11) {
            throw new JsonParseException("Failed parsing JSON source: " + jsonReader + " to Json", e11);
        } catch (OutOfMemoryError e12) {
            throw new JsonParseException("Failed parsing JSON source: " + jsonReader + " to Json", e12);
        } catch (Throwable th2) {
            jsonReader.setLenient(isLenient);
            throw th2;
        }
    }
}
