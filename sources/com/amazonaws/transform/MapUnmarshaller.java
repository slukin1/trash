package com.amazonaws.transform;

import com.amazonaws.util.json.AwsJsonReader;
import com.amazonaws.util.json.AwsJsonToken;
import java.util.HashMap;
import java.util.Map;

public class MapUnmarshaller<V> implements Unmarshaller<Map<String, V>, JsonUnmarshallerContext> {

    /* renamed from: a  reason: collision with root package name */
    public final Unmarshaller<V, JsonUnmarshallerContext> f15512a;

    public MapUnmarshaller(Unmarshaller<V, JsonUnmarshallerContext> unmarshaller) {
        this.f15512a = unmarshaller;
    }

    /* renamed from: b */
    public Map<String, V> a(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        AwsJsonReader a11 = jsonUnmarshallerContext.a();
        if (a11.peek() == AwsJsonToken.VALUE_NULL) {
            a11.d();
            return null;
        }
        HashMap hashMap = new HashMap();
        a11.f();
        while (a11.hasNext()) {
            hashMap.put(a11.e(), this.f15512a.a(jsonUnmarshallerContext));
        }
        a11.h();
        return hashMap;
    }
}
