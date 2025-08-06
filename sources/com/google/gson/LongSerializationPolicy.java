package com.google.gson;

public enum LongSerializationPolicy {
    DEFAULT {
        public JsonElement serialize(Long l11) {
            return new JsonPrimitive((Number) l11);
        }
    },
    STRING {
        public JsonElement serialize(Long l11) {
            return new JsonPrimitive(String.valueOf(l11));
        }
    };

    public abstract JsonElement serialize(Long l11);
}
