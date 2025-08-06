package com.kakao.sdk.common.json;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.util.Date;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u001c\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\f"}, d2 = {"Lcom/kakao/sdk/common/json/KakaoIntDateTypeAdapter;", "Lcom/google/gson/TypeAdapter;", "Ljava/util/Date;", "()V", "read", "in", "Lcom/google/gson/stream/JsonReader;", "write", "", "out", "Lcom/google/gson/stream/JsonWriter;", "value", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class KakaoIntDateTypeAdapter extends TypeAdapter<Date> {
    public Date read(JsonReader jsonReader) {
        JsonToken jsonToken;
        if ((jsonReader == null ? null : jsonReader.peek()) == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        if (jsonReader == null) {
            jsonToken = null;
        } else {
            jsonToken = jsonReader.peek();
        }
        if (jsonToken == JsonToken.NUMBER) {
            return new Date(jsonReader.nextLong() * ((long) 1000));
        }
        return null;
    }

    public void write(JsonWriter jsonWriter, Date date) {
        if (date == null) {
            if (jsonWriter != null) {
                jsonWriter.nullValue();
            }
        } else if (jsonWriter != null) {
            jsonWriter.value(date.getTime() / ((long) 1000));
        }
    }
}
