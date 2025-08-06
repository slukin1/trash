package com.amazonaws.services.cognitoidentity.model.transform;

import com.amazonaws.services.cognitoidentity.model.CognitoIdentityProvider;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

class CognitoIdentityProviderJsonUnmarshaller implements Unmarshaller<CognitoIdentityProvider, JsonUnmarshallerContext> {

    /* renamed from: a  reason: collision with root package name */
    public static CognitoIdentityProviderJsonUnmarshaller f15086a;

    public static CognitoIdentityProviderJsonUnmarshaller b() {
        if (f15086a == null) {
            f15086a = new CognitoIdentityProviderJsonUnmarshaller();
        }
        return f15086a;
    }

    /* renamed from: c */
    public CognitoIdentityProvider a(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        AwsJsonReader a11 = jsonUnmarshallerContext.a();
        if (!a11.a()) {
            a11.d();
            return null;
        }
        CognitoIdentityProvider cognitoIdentityProvider = new CognitoIdentityProvider();
        a11.f();
        while (a11.hasNext()) {
            String e11 = a11.e();
            if (e11.equals("ProviderName")) {
                cognitoIdentityProvider.setProviderName(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else if (e11.equals("ClientId")) {
                cognitoIdentityProvider.setClientId(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else if (e11.equals("ServerSideTokenCheck")) {
                cognitoIdentityProvider.setServerSideTokenCheck(SimpleTypeJsonUnmarshallers.BooleanJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else {
                a11.d();
            }
        }
        a11.h();
        return cognitoIdentityProvider;
    }
}
