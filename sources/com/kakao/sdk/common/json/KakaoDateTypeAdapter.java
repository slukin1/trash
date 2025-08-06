package com.kakao.sdk.common.json;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016J\u0014\u0010\n\u001a\u0004\u0018\u00010\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016R\u0017\u0010\u0010\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/kakao/sdk/common/json/KakaoDateTypeAdapter;", "Lcom/google/gson/TypeAdapter;", "Ljava/util/Date;", "Lcom/google/gson/stream/JsonWriter;", "out", "value", "", "write", "Lcom/google/gson/stream/JsonReader;", "in", "read", "Ljava/text/SimpleDateFormat;", "a", "Ljava/text/SimpleDateFormat;", "getFormat", "()Ljava/text/SimpleDateFormat;", "format", "<init>", "()V", "common_release"}, k = 1, mv = {1, 6, 0})
public final class KakaoDateTypeAdapter extends TypeAdapter<Date> {

    /* renamed from: a  reason: collision with root package name */
    public final SimpleDateFormat f25085a;

    public KakaoDateTypeAdapter() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault());
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        this.f25085a = simpleDateFormat;
    }

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
        if (jsonToken != JsonToken.STRING) {
            return null;
        }
        return this.f25085a.parse(jsonReader.nextString());
    }

    public void write(JsonWriter jsonWriter, Date date) {
        if (date == null) {
            if (jsonWriter != null) {
                jsonWriter.nullValue();
            }
        } else if (jsonWriter != null) {
            jsonWriter.value(this.f25085a.format(date));
        }
    }
}
