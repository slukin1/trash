package com.amazonaws.services.cognitoidentity.model.transform;

import com.amazonaws.services.cognitoidentity.model.ListIdentitiesResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.ListUnmarshaller;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

public class ListIdentitiesResultJsonUnmarshaller implements Unmarshaller<ListIdentitiesResult, JsonUnmarshallerContext> {
    /* renamed from: b */
    public ListIdentitiesResult a(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        ListIdentitiesResult listIdentitiesResult = new ListIdentitiesResult();
        AwsJsonReader a11 = jsonUnmarshallerContext.a();
        a11.f();
        while (a11.hasNext()) {
            String e11 = a11.e();
            if (e11.equals("IdentityPoolId")) {
                listIdentitiesResult.setIdentityPoolId(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else if (e11.equals("Identities")) {
                listIdentitiesResult.setIdentities(new ListUnmarshaller(IdentityDescriptionJsonUnmarshaller.b()).a(jsonUnmarshallerContext));
            } else if (e11.equals("NextToken")) {
                listIdentitiesResult.setNextToken(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else {
                a11.d();
            }
        }
        a11.h();
        return listIdentitiesResult;
    }
}
