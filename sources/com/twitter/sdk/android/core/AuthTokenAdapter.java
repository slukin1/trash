package com.twitter.sdk.android.core;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.twitter.sdk.android.core.internal.oauth.GuestAuthToken;
import com.twitter.sdk.android.core.internal.oauth.OAuth2Token;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class AuthTokenAdapter implements JsonSerializer<AuthToken>, JsonDeserializer<AuthToken> {
    private static final String AUTH_TOKEN = "auth_token";
    private static final String AUTH_TYPE = "auth_type";
    public static final Map<String, Class<? extends AuthToken>> authTypeRegistry;
    private final Gson gson = new Gson();

    static {
        HashMap hashMap = new HashMap();
        authTypeRegistry = hashMap;
        hashMap.put("oauth1a", TwitterAuthToken.class);
        hashMap.put("oauth2", OAuth2Token.class);
        hashMap.put("guest", GuestAuthToken.class);
    }

    public static String getAuthTypeString(Class<? extends AuthToken> cls) {
        for (Map.Entry next : authTypeRegistry.entrySet()) {
            if (((Class) next.getValue()).equals(cls)) {
                return (String) next.getKey();
            }
        }
        return "";
    }

    public AuthToken deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject asJsonObject = jsonElement.getAsJsonObject();
        String asString = asJsonObject.getAsJsonPrimitive("auth_type").getAsString();
        return (AuthToken) this.gson.fromJson(asJsonObject.get(AUTH_TOKEN), authTypeRegistry.get(asString));
    }

    public JsonElement serialize(AuthToken authToken, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("auth_type", getAuthTypeString(authToken.getClass()));
        jsonObject.add(AUTH_TOKEN, this.gson.toJsonTree(authToken));
        return jsonObject;
    }
}
