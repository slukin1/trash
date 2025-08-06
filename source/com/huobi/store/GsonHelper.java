package com.huobi.store;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

public class GsonHelper {

    /* renamed from: a  reason: collision with root package name */
    public static volatile Gson f81298a;

    public static class NullStringToEmptyAdapterFactory implements TypeAdapterFactory {
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
            if (typeToken.getRawType() != String.class) {
                return null;
            }
            return new StringNullAdapter();
        }
    }

    public static class StringNullAdapter extends TypeAdapter<String> {
        public String read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() != JsonToken.NULL) {
                return jsonReader.nextString();
            }
            jsonReader.nextNull();
            return "";
        }

        public void write(JsonWriter jsonWriter, String str) throws IOException {
            if (str == null) {
                jsonWriter.value("");
            } else {
                jsonWriter.value(str);
            }
        }
    }

    public static Gson a() {
        Gson gson = f81298a;
        if (gson == null) {
            synchronized (GsonHelper.class) {
                gson = f81298a;
                if (gson == null) {
                    gson = new GsonBuilder().registerTypeAdapterFactory(new NullStringToEmptyAdapterFactory()).setDateFormat("yyyy-MM-dd HH:mm:ss").create();
                    f81298a = gson;
                }
            }
        }
        return gson;
    }
}
