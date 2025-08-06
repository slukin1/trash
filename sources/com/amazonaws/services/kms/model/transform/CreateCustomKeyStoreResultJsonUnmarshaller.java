package com.amazonaws.services.kms.model.transform;

import com.amazonaws.services.kms.model.CreateCustomKeyStoreResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

public class CreateCustomKeyStoreResultJsonUnmarshaller implements Unmarshaller<CreateCustomKeyStoreResult, JsonUnmarshallerContext> {
    /* renamed from: b */
    public CreateCustomKeyStoreResult a(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        CreateCustomKeyStoreResult createCustomKeyStoreResult = new CreateCustomKeyStoreResult();
        AwsJsonReader a11 = jsonUnmarshallerContext.a();
        a11.f();
        while (a11.hasNext()) {
            if (a11.e().equals("CustomKeyStoreId")) {
                createCustomKeyStoreResult.setCustomKeyStoreId(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else {
                a11.d();
            }
        }
        a11.h();
        return createCustomKeyStoreResult;
    }
}
