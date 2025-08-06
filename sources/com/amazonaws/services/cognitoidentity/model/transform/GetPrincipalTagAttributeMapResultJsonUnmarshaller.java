package com.amazonaws.services.cognitoidentity.model.transform;

import com.amazonaws.services.cognitoidentity.model.GetPrincipalTagAttributeMapResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.MapUnmarshaller;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

public class GetPrincipalTagAttributeMapResultJsonUnmarshaller implements Unmarshaller<GetPrincipalTagAttributeMapResult, JsonUnmarshallerContext> {
    /* renamed from: b */
    public GetPrincipalTagAttributeMapResult a(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        GetPrincipalTagAttributeMapResult getPrincipalTagAttributeMapResult = new GetPrincipalTagAttributeMapResult();
        AwsJsonReader a11 = jsonUnmarshallerContext.a();
        a11.f();
        while (a11.hasNext()) {
            String e11 = a11.e();
            if (e11.equals("IdentityPoolId")) {
                getPrincipalTagAttributeMapResult.setIdentityPoolId(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else if (e11.equals("IdentityProviderName")) {
                getPrincipalTagAttributeMapResult.setIdentityProviderName(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else if (e11.equals("UseDefaults")) {
                getPrincipalTagAttributeMapResult.setUseDefaults(SimpleTypeJsonUnmarshallers.BooleanJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else if (e11.equals("PrincipalTags")) {
                getPrincipalTagAttributeMapResult.setPrincipalTags(new MapUnmarshaller(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.b()).a(jsonUnmarshallerContext));
            } else {
                a11.d();
            }
        }
        a11.h();
        return getPrincipalTagAttributeMapResult;
    }
}
