package com.amazonaws.services.kms.model.transform;

import com.amazonaws.services.kms.model.GenerateRandomResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

public class GenerateRandomResultJsonUnmarshaller implements Unmarshaller<GenerateRandomResult, JsonUnmarshallerContext> {
    /* renamed from: b */
    public GenerateRandomResult a(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        GenerateRandomResult generateRandomResult = new GenerateRandomResult();
        AwsJsonReader a11 = jsonUnmarshallerContext.a();
        a11.f();
        while (a11.hasNext()) {
            String e11 = a11.e();
            if (e11.equals("Plaintext")) {
                generateRandomResult.setPlaintext(SimpleTypeJsonUnmarshallers.ByteBufferJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else if (e11.equals("CiphertextForRecipient")) {
                generateRandomResult.setCiphertextForRecipient(SimpleTypeJsonUnmarshallers.ByteBufferJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else {
                a11.d();
            }
        }
        a11.h();
        return generateRandomResult;
    }
}
