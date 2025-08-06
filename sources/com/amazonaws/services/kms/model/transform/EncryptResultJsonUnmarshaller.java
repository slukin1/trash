package com.amazonaws.services.kms.model.transform;

import com.amazonaws.services.kms.model.EncryptResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

public class EncryptResultJsonUnmarshaller implements Unmarshaller<EncryptResult, JsonUnmarshallerContext> {
    /* renamed from: b */
    public EncryptResult a(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        EncryptResult encryptResult = new EncryptResult();
        AwsJsonReader a11 = jsonUnmarshallerContext.a();
        a11.f();
        while (a11.hasNext()) {
            String e11 = a11.e();
            if (e11.equals("CiphertextBlob")) {
                encryptResult.setCiphertextBlob(SimpleTypeJsonUnmarshallers.ByteBufferJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else if (e11.equals("KeyId")) {
                encryptResult.setKeyId(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else if (e11.equals("EncryptionAlgorithm")) {
                encryptResult.setEncryptionAlgorithm(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else {
                a11.d();
            }
        }
        a11.h();
        return encryptResult;
    }
}
