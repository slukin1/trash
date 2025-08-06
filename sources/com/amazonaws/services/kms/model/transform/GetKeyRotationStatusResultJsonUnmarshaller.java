package com.amazonaws.services.kms.model.transform;

import com.amazonaws.services.kms.model.GetKeyRotationStatusResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

public class GetKeyRotationStatusResultJsonUnmarshaller implements Unmarshaller<GetKeyRotationStatusResult, JsonUnmarshallerContext> {
    /* renamed from: b */
    public GetKeyRotationStatusResult a(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        GetKeyRotationStatusResult getKeyRotationStatusResult = new GetKeyRotationStatusResult();
        AwsJsonReader a11 = jsonUnmarshallerContext.a();
        a11.f();
        while (a11.hasNext()) {
            String e11 = a11.e();
            if (e11.equals("KeyRotationEnabled")) {
                getKeyRotationStatusResult.setKeyRotationEnabled(SimpleTypeJsonUnmarshallers.BooleanJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else if (e11.equals("KeyId")) {
                getKeyRotationStatusResult.setKeyId(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else if (e11.equals("RotationPeriodInDays")) {
                getKeyRotationStatusResult.setRotationPeriodInDays(SimpleTypeJsonUnmarshallers.IntegerJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else if (e11.equals("NextRotationDate")) {
                getKeyRotationStatusResult.setNextRotationDate(SimpleTypeJsonUnmarshallers.DateJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else if (e11.equals("OnDemandRotationStartDate")) {
                getKeyRotationStatusResult.setOnDemandRotationStartDate(SimpleTypeJsonUnmarshallers.DateJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else {
                a11.d();
            }
        }
        a11.h();
        return getKeyRotationStatusResult;
    }
}
