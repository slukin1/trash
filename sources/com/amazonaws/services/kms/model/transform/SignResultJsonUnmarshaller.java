package com.amazonaws.services.kms.model.transform;

import com.amazonaws.services.kms.model.SignResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

public class SignResultJsonUnmarshaller implements Unmarshaller<SignResult, JsonUnmarshallerContext> {
    /* renamed from: b */
    public SignResult a(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        SignResult signResult = new SignResult();
        AwsJsonReader a11 = jsonUnmarshallerContext.a();
        a11.f();
        while (a11.hasNext()) {
            String e11 = a11.e();
            if (e11.equals("KeyId")) {
                signResult.setKeyId(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else if (e11.equals("Signature")) {
                signResult.setSignature(SimpleTypeJsonUnmarshallers.ByteBufferJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else if (e11.equals("SigningAlgorithm")) {
                signResult.setSigningAlgorithm(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else {
                a11.d();
            }
        }
        a11.h();
        return signResult;
    }
}
