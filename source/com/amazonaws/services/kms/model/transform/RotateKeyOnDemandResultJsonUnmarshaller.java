package com.amazonaws.services.kms.model.transform;

import com.amazonaws.services.kms.model.RotateKeyOnDemandResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

public class RotateKeyOnDemandResultJsonUnmarshaller implements Unmarshaller<RotateKeyOnDemandResult, JsonUnmarshallerContext> {
    /* renamed from: b */
    public RotateKeyOnDemandResult a(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        RotateKeyOnDemandResult rotateKeyOnDemandResult = new RotateKeyOnDemandResult();
        AwsJsonReader a11 = jsonUnmarshallerContext.a();
        a11.f();
        while (a11.hasNext()) {
            if (a11.e().equals("KeyId")) {
                rotateKeyOnDemandResult.setKeyId(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else {
                a11.d();
            }
        }
        a11.h();
        return rotateKeyOnDemandResult;
    }
}
