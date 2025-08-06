package com.amazonaws.transform;

import com.amazonaws.util.json.AwsJsonReader;
import com.amazonaws.util.json.AwsJsonToken;
import java.util.ArrayList;
import java.util.List;

public class ListUnmarshaller<T> implements Unmarshaller<List<T>, JsonUnmarshallerContext> {

    /* renamed from: a  reason: collision with root package name */
    public final Unmarshaller<T, JsonUnmarshallerContext> f15509a;

    public ListUnmarshaller(Unmarshaller<T, JsonUnmarshallerContext> unmarshaller) {
        this.f15509a = unmarshaller;
    }

    /* renamed from: b */
    public List<T> a(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        AwsJsonReader a11 = jsonUnmarshallerContext.a();
        if (a11.peek() == AwsJsonToken.VALUE_NULL) {
            a11.d();
            return null;
        }
        ArrayList arrayList = new ArrayList();
        a11.c();
        while (a11.hasNext()) {
            arrayList.add(this.f15509a.a(jsonUnmarshallerContext));
        }
        a11.b();
        return arrayList;
    }
}
