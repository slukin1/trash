package com.amazonaws.services.kms.model.transform;

import com.amazonaws.services.kms.model.GetParametersForImportResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

public class GetParametersForImportResultJsonUnmarshaller implements Unmarshaller<GetParametersForImportResult, JsonUnmarshallerContext> {
    /* renamed from: b */
    public GetParametersForImportResult a(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        GetParametersForImportResult getParametersForImportResult = new GetParametersForImportResult();
        AwsJsonReader a11 = jsonUnmarshallerContext.a();
        a11.f();
        while (a11.hasNext()) {
            String e11 = a11.e();
            if (e11.equals("KeyId")) {
                getParametersForImportResult.setKeyId(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else if (e11.equals("ImportToken")) {
                getParametersForImportResult.setImportToken(SimpleTypeJsonUnmarshallers.ByteBufferJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else if (e11.equals("PublicKey")) {
                getParametersForImportResult.setPublicKey(SimpleTypeJsonUnmarshallers.ByteBufferJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else if (e11.equals("ParametersValidTo")) {
                getParametersForImportResult.setParametersValidTo(SimpleTypeJsonUnmarshallers.DateJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else {
                a11.d();
            }
        }
        a11.h();
        return getParametersForImportResult;
    }
}
