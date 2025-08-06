package com.amazonaws.services.kms.model.transform;

import com.amazonaws.services.kms.model.GenerateDataKeyWithoutPlaintextResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

public class GenerateDataKeyWithoutPlaintextResultJsonUnmarshaller implements Unmarshaller<GenerateDataKeyWithoutPlaintextResult, JsonUnmarshallerContext> {
    /* renamed from: b */
    public GenerateDataKeyWithoutPlaintextResult a(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        GenerateDataKeyWithoutPlaintextResult generateDataKeyWithoutPlaintextResult = new GenerateDataKeyWithoutPlaintextResult();
        AwsJsonReader a11 = jsonUnmarshallerContext.a();
        a11.f();
        while (a11.hasNext()) {
            String e11 = a11.e();
            if (e11.equals("CiphertextBlob")) {
                generateDataKeyWithoutPlaintextResult.setCiphertextBlob(SimpleTypeJsonUnmarshallers.ByteBufferJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else if (e11.equals("KeyId")) {
                generateDataKeyWithoutPlaintextResult.setKeyId(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else {
                a11.d();
            }
        }
        a11.h();
        return generateDataKeyWithoutPlaintextResult;
    }
}
