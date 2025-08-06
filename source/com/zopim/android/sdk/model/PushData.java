package com.zopim.android.sdk.model;

import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class PushData {
    private static final String PUSH_KEY_AUTHOR = "author";
    private static final String PUSH_KEY_DATA = "data";
    private static final String PUSH_KEY_MSG = "message";
    private static final String PUSH_KEY_TYPE = "type";
    private static final String PUSH_TYPE_END = "zd.chat.end";
    private static final String PUSH_TYPE_MSG = "zd.chat.msg";
    private final String author;
    private final String message;
    private final Type type;

    public enum Type {
        MESSAGE(PushData.PUSH_TYPE_MSG),
        END(PushData.PUSH_TYPE_END),
        NOT_CHAT("ZDC_NOT_CHAT");
        
        private final String typeString;

        private Type(String str) {
            this.typeString = str;
        }

        /* access modifiers changed from: private */
        public static Type getType(String str) {
            if (str != null) {
                for (Type type : values()) {
                    if (type.getValue().equals(str)) {
                        return type;
                    }
                }
            }
            return NOT_CHAT;
        }

        private String getValue() {
            return this.typeString;
        }
    }

    private PushData(Type type2, String str, String str2) {
        this.type = type2;
        this.author = str;
        this.message = str2;
    }

    public static PushData getChatNotification(Map<String, String> map) {
        String str = map.get("data");
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                Type access$000 = Type.getType(jSONObject.optString("type"));
                if (access$000 != null) {
                    return new PushData(access$000, jSONObject.optString("author"), jSONObject.optString("message"));
                }
            } catch (JSONException unused) {
            }
        }
        return new PushData(Type.NOT_CHAT, (String) null, (String) null);
    }

    public String getAuthor() {
        return this.author;
    }

    public String getMessage() {
        return this.message;
    }

    public Type getType() {
        return this.type;
    }
}
