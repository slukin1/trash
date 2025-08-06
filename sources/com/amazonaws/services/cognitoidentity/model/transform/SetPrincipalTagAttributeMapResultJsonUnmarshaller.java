package com.amazonaws.services.cognitoidentity.model.transform;

import com.amazonaws.services.cognitoidentity.model.SetPrincipalTagAttributeMapResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.MapUnmarshaller;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

public class SetPrincipalTagAttributeMapResultJsonUnmarshaller implements Unmarshaller<SetPrincipalTagAttributeMapResult, JsonUnmarshallerContext> {
    /* renamed from: b */
    public SetPrincipalTagAttributeMapResult a(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        SetPrincipalTagAttributeMapResult setPrincipalTagAttributeMapResult = new SetPrincipalTagAttributeMapResult();
        AwsJsonReader a11 = jsonUnmarshallerContext.a();
        a11.f();
        while (a11.hasNext()) {
            String e11 = a11.e();
            if (e11.equals("IdentityPoolId")) {
                setPrincipalTagAttributeMapResult.setIdentityPoolId(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else if (e11.equals("IdentityProviderName")) {
                setPrincipalTagAttributeMapResult.setIdentityProviderName(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else if (e11.equals("UseDefaults")) {
                setPrincipalTagAttributeMapResult.setUseDefaults(SimpleTypeJsonUnmarshallers.BooleanJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else if (e11.equals("PrincipalTags")) {
                setPrincipalTagAttributeMapResult.setPrincipalTags(new MapUnmarshaller(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.b()).a(jsonUnmarshallerContext));
            } else {
                a11.d();
            }
        }
        a11.h();
        return setPrincipalTagAttributeMapResult;
    }
}
