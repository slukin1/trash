package com.amazonaws.services.kms.model.transform;

import com.amazonaws.services.kms.model.GetKeyPolicyResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

public class GetKeyPolicyResultJsonUnmarshaller implements Unmarshaller<GetKeyPolicyResult, JsonUnmarshallerContext> {
    /* renamed from: b */
    public GetKeyPolicyResult a(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        GetKeyPolicyResult getKeyPolicyResult = new GetKeyPolicyResult();
        AwsJsonReader a11 = jsonUnmarshallerContext.a();
        a11.f();
        while (a11.hasNext()) {
            String e11 = a11.e();
            if (e11.equals("Policy")) {
                getKeyPolicyResult.setPolicy(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else if (e11.equals("PolicyName")) {
                getKeyPolicyResult.setPolicyName(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else {
                a11.d();
            }
        }
        a11.h();
        return getKeyPolicyResult;
    }
}
