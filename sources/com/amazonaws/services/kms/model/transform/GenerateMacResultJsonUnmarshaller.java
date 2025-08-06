package com.amazonaws.services.kms.model.transform;

import com.amazonaws.services.kms.model.GenerateMacResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

public class GenerateMacResultJsonUnmarshaller implements Unmarshaller<GenerateMacResult, JsonUnmarshallerContext> {
    /* renamed from: b */
    public GenerateMacResult a(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        GenerateMacResult generateMacResult = new GenerateMacResult();
        AwsJsonReader a11 = jsonUnmarshallerContext.a();
        a11.f();
        while (a11.hasNext()) {
            String e11 = a11.e();
            if (e11.equals("Mac")) {
                generateMacResult.setMac(SimpleTypeJsonUnmarshallers.ByteBufferJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else if (e11.equals("MacAlgorithm")) {
                generateMacResult.setMacAlgorithm(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else if (e11.equals("KeyId")) {
                generateMacResult.setKeyId(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else {
                a11.d();
            }
        }
        a11.h();
        return generateMacResult;
    }
}
