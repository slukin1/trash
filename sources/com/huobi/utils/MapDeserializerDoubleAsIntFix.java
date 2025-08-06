package com.huobi.utils;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapDeserializerDoubleAsIntFix implements JsonDeserializer<Map<String, Object>> {
    /* renamed from: a */
    public Map<String, Object> deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        try {
            return (Map) b(jsonElement);
        } catch (Exception e11) {
            e11.printStackTrace();
            return null;
        }
    }

    public Object b(JsonElement jsonElement) {
        if (jsonElement.isJsonArray()) {
            ArrayList arrayList = new ArrayList();
            Iterator<JsonElement> it2 = jsonElement.getAsJsonArray().iterator();
            while (it2.hasNext()) {
                arrayList.add(b(it2.next()));
            }
            return arrayList;
        } else if (jsonElement.isJsonObject()) {
            HashMap hashMap = new HashMap();
            for (Map.Entry next : jsonElement.getAsJsonObject().entrySet()) {
                hashMap.put((String) next.getKey(), b((JsonElement) next.getValue()));
            }
            return hashMap;
        } else if (!jsonElement.isJsonPrimitive()) {
            return null;
        } else {
            JsonPrimitive asJsonPrimitive = jsonElement.getAsJsonPrimitive();
            if (asJsonPrimitive.isBoolean()) {
                return Boolean.valueOf(asJsonPrimitive.getAsBoolean());
            }
            if (asJsonPrimitive.isString()) {
                return asJsonPrimitive.getAsString();
            }
            if (!asJsonPrimitive.isNumber()) {
                return null;
            }
            Number asNumber = asJsonPrimitive.getAsNumber();
            if (Math.ceil(asNumber.doubleValue()) == ((double) asNumber.longValue())) {
                return Long.valueOf(asNumber.longValue());
            }
            return Double.valueOf(asNumber.doubleValue());
        }
    }
}
