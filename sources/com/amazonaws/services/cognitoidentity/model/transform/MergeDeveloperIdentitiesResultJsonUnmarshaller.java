package com.amazonaws.services.cognitoidentity.model.transform;

import com.amazonaws.services.cognitoidentity.model.MergeDeveloperIdentitiesResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

public class MergeDeveloperIdentitiesResultJsonUnmarshaller implements Unmarshaller<MergeDeveloperIdentitiesResult, JsonUnmarshallerContext> {
    /* renamed from: b */
    public MergeDeveloperIdentitiesResult a(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        MergeDeveloperIdentitiesResult mergeDeveloperIdentitiesResult = new MergeDeveloperIdentitiesResult();
        AwsJsonReader a11 = jsonUnmarshallerContext.a();
        a11.f();
        while (a11.hasNext()) {
            if (a11.e().equals("IdentityId")) {
                mergeDeveloperIdentitiesResult.setIdentityId(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else {
                a11.d();
            }
        }
        a11.h();
        return mergeDeveloperIdentitiesResult;
    }
}
