package com.amazonaws.util.json;

import com.amazonaws.AmazonClientException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.Writer;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class JsonUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final AwsJsonFactory f15583a = new GsonFactory();

    @Deprecated
    public enum JsonEngine {
        Gson,
        Jackson
    }

    public static AwsJsonReader a(Reader reader) {
        return f15583a.b(reader);
    }

    public static AwsJsonWriter b(Writer writer) {
        return f15583a.a(writer);
    }

    public static Map<String, String> c(Reader reader) {
        AwsJsonReader a11 = a(reader);
        try {
            if (a11.peek() == null) {
                return Collections.EMPTY_MAP;
            }
            HashMap hashMap = new HashMap();
            a11.f();
            while (a11.hasNext()) {
                String e11 = a11.e();
                if (a11.a()) {
                    a11.d();
                } else {
                    hashMap.put(e11, a11.g());
                }
            }
            a11.h();
            a11.close();
            return Collections.unmodifiableMap(hashMap);
        } catch (IOException e12) {
            throw new AmazonClientException("Unable to parse JSON String.", e12);
        }
    }

    public static Map<String, String> d(String str) {
        if (str == null || str.isEmpty()) {
            return Collections.EMPTY_MAP;
        }
        return c(new StringReader(str));
    }
}
