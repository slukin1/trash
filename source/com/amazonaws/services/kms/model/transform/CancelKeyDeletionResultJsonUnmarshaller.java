package com.amazonaws.services.kms.model.transform;

import com.amazonaws.services.kms.model.CancelKeyDeletionResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

public class CancelKeyDeletionResultJsonUnmarshaller implements Unmarshaller<CancelKeyDeletionResult, JsonUnmarshallerContext> {
    /* renamed from: b */
    public CancelKeyDeletionResult a(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        CancelKeyDeletionResult cancelKeyDeletionResult = new CancelKeyDeletionResult();
        AwsJsonReader a11 = jsonUnmarshallerContext.a();
        a11.f();
        while (a11.hasNext()) {
            if (a11.e().equals("KeyId")) {
                cancelKeyDeletionResult.setKeyId(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else {
                a11.d();
            }
        }
        a11.h();
        return cancelKeyDeletionResult;
    }
}
