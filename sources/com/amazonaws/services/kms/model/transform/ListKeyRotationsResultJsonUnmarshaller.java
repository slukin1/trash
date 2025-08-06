package com.amazonaws.services.kms.model.transform;

import com.amazonaws.services.kms.model.ListKeyRotationsResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.ListUnmarshaller;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

public class ListKeyRotationsResultJsonUnmarshaller implements Unmarshaller<ListKeyRotationsResult, JsonUnmarshallerContext> {
    /* renamed from: b */
    public ListKeyRotationsResult a(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        ListKeyRotationsResult listKeyRotationsResult = new ListKeyRotationsResult();
        AwsJsonReader a11 = jsonUnmarshallerContext.a();
        a11.f();
        while (a11.hasNext()) {
            String e11 = a11.e();
            if (e11.equals("Rotations")) {
                listKeyRotationsResult.setRotations(new ListUnmarshaller(RotationsListEntryJsonUnmarshaller.b()).a(jsonUnmarshallerContext));
            } else if (e11.equals("NextMarker")) {
                listKeyRotationsResult.setNextMarker(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else if (e11.equals("Truncated")) {
                listKeyRotationsResult.setTruncated(SimpleTypeJsonUnmarshallers.BooleanJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else {
                a11.d();
            }
        }
        a11.h();
        return listKeyRotationsResult;
    }
}
