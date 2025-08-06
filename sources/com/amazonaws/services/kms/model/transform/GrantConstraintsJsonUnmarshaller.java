package com.amazonaws.services.kms.model.transform;

import com.amazonaws.services.kms.model.GrantConstraints;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.MapUnmarshaller;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

class GrantConstraintsJsonUnmarshaller implements Unmarshaller<GrantConstraints, JsonUnmarshallerContext> {

    /* renamed from: a  reason: collision with root package name */
    public static GrantConstraintsJsonUnmarshaller f15099a;

    public static GrantConstraintsJsonUnmarshaller b() {
        if (f15099a == null) {
            f15099a = new GrantConstraintsJsonUnmarshaller();
        }
        return f15099a;
    }

    /* renamed from: c */
    public GrantConstraints a(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        AwsJsonReader a11 = jsonUnmarshallerContext.a();
        if (!a11.a()) {
            a11.d();
            return null;
        }
        GrantConstraints grantConstraints = new GrantConstraints();
        a11.f();
        while (a11.hasNext()) {
            String e11 = a11.e();
            if (e11.equals("EncryptionContextSubset")) {
                grantConstraints.setEncryptionContextSubset(new MapUnmarshaller(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.b()).a(jsonUnmarshallerContext));
            } else if (e11.equals("EncryptionContextEquals")) {
                grantConstraints.setEncryptionContextEquals(new MapUnmarshaller(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.b()).a(jsonUnmarshallerContext));
            } else {
                a11.d();
            }
        }
        a11.h();
        return grantConstraints;
    }
}
