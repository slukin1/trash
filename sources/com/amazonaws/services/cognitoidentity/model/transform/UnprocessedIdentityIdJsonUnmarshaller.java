package com.amazonaws.services.cognitoidentity.model.transform;

import com.amazonaws.services.cognitoidentity.model.UnprocessedIdentityId;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

class UnprocessedIdentityIdJsonUnmarshaller implements Unmarshaller<UnprocessedIdentityId, JsonUnmarshallerContext> {

    /* renamed from: a  reason: collision with root package name */
    public static UnprocessedIdentityIdJsonUnmarshaller f15093a;

    public static UnprocessedIdentityIdJsonUnmarshaller b() {
        if (f15093a == null) {
            f15093a = new UnprocessedIdentityIdJsonUnmarshaller();
        }
        return f15093a;
    }

    /* renamed from: c */
    public UnprocessedIdentityId a(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        AwsJsonReader a11 = jsonUnmarshallerContext.a();
        if (!a11.a()) {
            a11.d();
            return null;
        }
        UnprocessedIdentityId unprocessedIdentityId = new UnprocessedIdentityId();
        a11.f();
        while (a11.hasNext()) {
            String e11 = a11.e();
            if (e11.equals("IdentityId")) {
                unprocessedIdentityId.setIdentityId(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else if (e11.equals("ErrorCode")) {
                unprocessedIdentityId.setErrorCode(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else {
                a11.d();
            }
        }
        a11.h();
        return unprocessedIdentityId;
    }
}
