package com.amazonaws.services.kms.model.transform;

import com.amazonaws.services.kms.model.ListKeysResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.ListUnmarshaller;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

public class ListKeysResultJsonUnmarshaller implements Unmarshaller<ListKeysResult, JsonUnmarshallerContext> {
    /* renamed from: b */
    public ListKeysResult a(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        ListKeysResult listKeysResult = new ListKeysResult();
        AwsJsonReader a11 = jsonUnmarshallerContext.a();
        a11.f();
        while (a11.hasNext()) {
            String e11 = a11.e();
            if (e11.equals("Keys")) {
                listKeysResult.setKeys(new ListUnmarshaller(KeyListEntryJsonUnmarshaller.b()).a(jsonUnmarshallerContext));
            } else if (e11.equals("NextMarker")) {
                listKeysResult.setNextMarker(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else if (e11.equals("Truncated")) {
                listKeysResult.setTruncated(SimpleTypeJsonUnmarshallers.BooleanJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else {
                a11.d();
            }
        }
        a11.h();
        return listKeysResult;
    }
}
