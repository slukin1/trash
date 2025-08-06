package com.amazonaws.services.kms.model.transform;

import com.amazonaws.services.kms.model.MultiRegionKey;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

class MultiRegionKeyJsonUnmarshaller implements Unmarshaller<MultiRegionKey, JsonUnmarshallerContext> {

    /* renamed from: a  reason: collision with root package name */
    public static MultiRegionKeyJsonUnmarshaller f15104a;

    public static MultiRegionKeyJsonUnmarshaller b() {
        if (f15104a == null) {
            f15104a = new MultiRegionKeyJsonUnmarshaller();
        }
        return f15104a;
    }

    /* renamed from: c */
    public MultiRegionKey a(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        AwsJsonReader a11 = jsonUnmarshallerContext.a();
        if (!a11.a()) {
            a11.d();
            return null;
        }
        MultiRegionKey multiRegionKey = new MultiRegionKey();
        a11.f();
        while (a11.hasNext()) {
            String e11 = a11.e();
            if (e11.equals("Arn")) {
                multiRegionKey.setArn(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else if (e11.equals("Region")) {
                multiRegionKey.setRegion(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else {
                a11.d();
            }
        }
        a11.h();
        return multiRegionKey;
    }
}
