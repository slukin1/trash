package com.google.gson;

import com.google.gson.internal.Streams;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.MalformedJsonException;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Iterator;
import java.util.NoSuchElementException;

public final class JsonStreamParser implements Iterator<JsonElement> {
    private final Object lock;
    private final JsonReader parser;

    public JsonStreamParser(String str) {
        this((Reader) new StringReader(str));
    }

    public boolean hasNext() {
        boolean z11;
        synchronized (this.lock) {
            try {
                z11 = this.parser.peek() != JsonToken.END_DOCUMENT;
            } catch (MalformedJsonException e11) {
                throw new JsonSyntaxException((Throwable) e11);
            } catch (IOException e12) {
                throw new JsonIOException((Throwable) e12);
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return z11;
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }

    public JsonStreamParser(Reader reader) {
        JsonReader jsonReader = new JsonReader(reader);
        this.parser = jsonReader;
        jsonReader.setLenient(true);
        this.lock = new Object();
    }

    public JsonElement next() throws JsonParseException {
        if (hasNext()) {
            try {
                return Streams.parse(this.parser);
            } catch (StackOverflowError e11) {
                throw new JsonParseException("Failed parsing JSON source to Json", e11);
            } catch (OutOfMemoryError e12) {
                throw new JsonParseException("Failed parsing JSON source to Json", e12);
            } catch (JsonParseException e13) {
                e = e13;
                if (e.getCause() instanceof EOFException) {
                    e = new NoSuchElementException();
                }
                throw e;
            }
        } else {
            throw new NoSuchElementException();
        }
    }
}
