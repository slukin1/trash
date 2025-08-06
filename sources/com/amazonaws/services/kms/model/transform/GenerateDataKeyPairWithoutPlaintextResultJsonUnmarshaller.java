package com.amazonaws.services.kms.model.transform;

import com.amazonaws.services.kms.model.GenerateDataKeyPairWithoutPlaintextResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

public class GenerateDataKeyPairWithoutPlaintextResultJsonUnmarshaller implements Unmarshaller<GenerateDataKeyPairWithoutPlaintextResult, JsonUnmarshallerContext> {
    /* renamed from: b */
    public GenerateDataKeyPairWithoutPlaintextResult a(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        GenerateDataKeyPairWithoutPlaintextResult generateDataKeyPairWithoutPlaintextResult = new GenerateDataKeyPairWithoutPlaintextResult();
        AwsJsonReader a11 = jsonUnmarshallerContext.a();
        a11.f();
        while (a11.hasNext()) {
            String e11 = a11.e();
            if (e11.equals("PrivateKeyCiphertextBlob")) {
                generateDataKeyPairWithoutPlaintextResult.setPrivateKeyCiphertextBlob(SimpleTypeJsonUnmarshallers.ByteBufferJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else if (e11.equals("PublicKey")) {
                generateDataKeyPairWithoutPlaintextResult.setPublicKey(SimpleTypeJsonUnmarshallers.ByteBufferJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else if (e11.equals("KeyId")) {
                generateDataKeyPairWithoutPlaintextResult.setKeyId(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else if (e11.equals("KeyPairSpec")) {
                generateDataKeyPairWithoutPlaintextResult.setKeyPairSpec(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else {
                a11.d();
            }
        }
        a11.h();
        return generateDataKeyPairWithoutPlaintextResult;
    }
}
