package com.kakao.sdk.common.json;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.kakao.sdk.common.util.b;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0004J \u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J(\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016¨\u0006\r"}, d2 = {"Lcom/kakao/sdk/common/json/MapToQueryAdapter;", "Lcom/google/gson/TypeAdapter;", "", "", "()V", "read", "in", "Lcom/google/gson/stream/JsonReader;", "write", "", "out", "Lcom/google/gson/stream/JsonWriter;", "value", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MapToQueryAdapter extends TypeAdapter<Map<String, ? extends String>> {
    public Map<String, String> read(JsonReader jsonReader) {
        String str = null;
        if ((jsonReader == null ? null : jsonReader.peek()) == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        if (jsonReader != null) {
            str = jsonReader.nextString();
        }
        return b.f25110a.h(str);
    }

    public void write(JsonWriter jsonWriter, Map<String, String> map) {
        if (map != null) {
            String b11 = b.f25110a.b(map);
            if (jsonWriter != null) {
                jsonWriter.value(b11);
            }
        } else if (jsonWriter != null) {
            jsonWriter.nullValue();
        }
    }
}
