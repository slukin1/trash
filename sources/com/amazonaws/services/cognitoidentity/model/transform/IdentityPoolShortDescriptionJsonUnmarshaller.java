package com.amazonaws.services.cognitoidentity.model.transform;

import com.amazonaws.services.cognitoidentity.model.IdentityPoolShortDescription;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

class IdentityPoolShortDescriptionJsonUnmarshaller implements Unmarshaller<IdentityPoolShortDescription, JsonUnmarshallerContext> {

    /* renamed from: a  reason: collision with root package name */
    public static IdentityPoolShortDescriptionJsonUnmarshaller f15089a;

    public static IdentityPoolShortDescriptionJsonUnmarshaller b() {
        if (f15089a == null) {
            f15089a = new IdentityPoolShortDescriptionJsonUnmarshaller();
        }
        return f15089a;
    }

    /* renamed from: c */
    public IdentityPoolShortDescription a(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        AwsJsonReader a11 = jsonUnmarshallerContext.a();
        if (!a11.a()) {
            a11.d();
            return null;
        }
        IdentityPoolShortDescription identityPoolShortDescription = new IdentityPoolShortDescription();
        a11.f();
        while (a11.hasNext()) {
            String e11 = a11.e();
            if (e11.equals("IdentityPoolId")) {
                identityPoolShortDescription.setIdentityPoolId(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else if (e11.equals("IdentityPoolName")) {
                identityPoolShortDescription.setIdentityPoolName(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else {
                a11.d();
            }
        }
        a11.h();
        return identityPoolShortDescription;
    }
}
