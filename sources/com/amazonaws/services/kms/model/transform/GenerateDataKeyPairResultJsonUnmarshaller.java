package com.amazonaws.services.kms.model.transform;

import com.amazonaws.services.kms.model.GenerateDataKeyPairResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

public class GenerateDataKeyPairResultJsonUnmarshaller implements Unmarshaller<GenerateDataKeyPairResult, JsonUnmarshallerContext> {
    /* renamed from: b */
    public GenerateDataKeyPairResult a(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        GenerateDataKeyPairResult generateDataKeyPairResult = new GenerateDataKeyPairResult();
        AwsJsonReader a11 = jsonUnmarshallerContext.a();
        a11.f();
        while (a11.hasNext()) {
            String e11 = a11.e();
            if (e11.equals("PrivateKeyCiphertextBlob")) {
                generateDataKeyPairResult.setPrivateKeyCiphertextBlob(SimpleTypeJsonUnmarshallers.ByteBufferJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else if (e11.equals("PrivateKeyPlaintext")) {
                generateDataKeyPairResult.setPrivateKeyPlaintext(SimpleTypeJsonUnmarshallers.ByteBufferJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else if (e11.equals("PublicKey")) {
                generateDataKeyPairResult.setPublicKey(SimpleTypeJsonUnmarshallers.ByteBufferJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else if (e11.equals("KeyId")) {
                generateDataKeyPairResult.setKeyId(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else if (e11.equals("KeyPairSpec")) {
                generateDataKeyPairResult.setKeyPairSpec(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else if (e11.equals("CiphertextForRecipient")) {
                generateDataKeyPairResult.setCiphertextForRecipient(SimpleTypeJsonUnmarshallers.ByteBufferJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else {
                a11.d();
            }
        }
        a11.h();
        return generateDataKeyPairResult;
    }
}
