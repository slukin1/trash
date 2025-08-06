package com.amazonaws.services.kms.model.transform;

import com.amazonaws.services.kms.model.DeriveSharedSecretResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

public class DeriveSharedSecretResultJsonUnmarshaller implements Unmarshaller<DeriveSharedSecretResult, JsonUnmarshallerContext> {
    /* renamed from: b */
    public DeriveSharedSecretResult a(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        DeriveSharedSecretResult deriveSharedSecretResult = new DeriveSharedSecretResult();
        AwsJsonReader a11 = jsonUnmarshallerContext.a();
        a11.f();
        while (a11.hasNext()) {
            String e11 = a11.e();
            if (e11.equals("KeyId")) {
                deriveSharedSecretResult.setKeyId(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else if (e11.equals("SharedSecret")) {
                deriveSharedSecretResult.setSharedSecret(SimpleTypeJsonUnmarshallers.ByteBufferJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else if (e11.equals("CiphertextForRecipient")) {
                deriveSharedSecretResult.setCiphertextForRecipient(SimpleTypeJsonUnmarshallers.ByteBufferJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else if (e11.equals("KeyAgreementAlgorithm")) {
                deriveSharedSecretResult.setKeyAgreementAlgorithm(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else if (e11.equals("KeyOrigin")) {
                deriveSharedSecretResult.setKeyOrigin(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else {
                a11.d();
            }
        }
        a11.h();
        return deriveSharedSecretResult;
    }
}
