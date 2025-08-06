package com.kakao.network.response;

import java.util.NoSuchElementException;
import org.json.JSONException;
import org.json.JSONObject;

public class ResponseBody {

    /* renamed from: a  reason: collision with root package name */
    public JSONObject f25067a = null;

    public static class ResponseBodyException extends RuntimeException {
        private static final long serialVersionUID = 8171429617556607125L;

        public ResponseBodyException() {
        }

        public ResponseBodyException(String str) {
            super(str);
        }

        public ResponseBodyException(Exception exc) {
            super(exc);
        }
    }

    public ResponseBody(JSONObject jSONObject) throws ResponseBodyException {
        if (jSONObject != null) {
            this.f25067a = jSONObject;
            return;
        }
        throw new ResponseBodyException();
    }

    public int a(String str) throws ResponseBodyException {
        try {
            return ((Integer) c(str)).intValue();
        } catch (Exception e11) {
            throw new ResponseBodyException(e11);
        }
    }

    public JSONObject b(String str) {
        try {
            return (JSONObject) c(str);
        } catch (ResponseBodyException e11) {
            throw e11;
        } catch (Exception e12) {
            throw new ResponseBodyException(e12);
        }
    }

    public final Object c(String str) {
        Object obj;
        try {
            obj = this.f25067a.get(str);
        } catch (JSONException unused) {
            obj = null;
        }
        if (obj == null) {
            throw new NoSuchElementException(str);
        } else if (obj == JSONObject.NULL) {
            return null;
        } else {
            return obj;
        }
    }

    public String d(String str) throws ResponseBodyException {
        try {
            return (String) c(str);
        } catch (Exception e11) {
            throw new ResponseBodyException(e11);
        }
    }

    public boolean e(String str) {
        return this.f25067a.has(str);
    }

    public JSONObject f(String str, JSONObject jSONObject) {
        if (e(str)) {
            try {
                return b(str);
            } catch (ResponseBodyException unused) {
            }
        }
        return jSONObject;
    }

    public String g(String str, String str2) {
        if (e(str)) {
            try {
                return d(str);
            } catch (ResponseBodyException unused) {
            }
        }
        return str2;
    }

    public String toString() {
        return this.f25067a.toString();
    }

    public ResponseBody(String str) throws ResponseBodyException {
        try {
            this.f25067a = new JSONObject(str);
        } catch (JSONException e11) {
            throw new ResponseBodyException((Exception) e11);
        }
    }
}
