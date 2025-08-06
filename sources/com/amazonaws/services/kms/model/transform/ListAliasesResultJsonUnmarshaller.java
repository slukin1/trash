package com.amazonaws.services.kms.model.transform;

import com.amazonaws.services.kms.model.ListAliasesResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.ListUnmarshaller;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

public class ListAliasesResultJsonUnmarshaller implements Unmarshaller<ListAliasesResult, JsonUnmarshallerContext> {
    /* renamed from: b */
    public ListAliasesResult a(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        ListAliasesResult listAliasesResult = new ListAliasesResult();
        AwsJsonReader a11 = jsonUnmarshallerContext.a();
        a11.f();
        while (a11.hasNext()) {
            String e11 = a11.e();
            if (e11.equals("Aliases")) {
                listAliasesResult.setAliases(new ListUnmarshaller(AliasListEntryJsonUnmarshaller.b()).a(jsonUnmarshallerContext));
            } else if (e11.equals("NextMarker")) {
                listAliasesResult.setNextMarker(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else if (e11.equals("Truncated")) {
                listAliasesResult.setTruncated(SimpleTypeJsonUnmarshallers.BooleanJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else {
                a11.d();
            }
        }
        a11.h();
        return listAliasesResult;
    }
}
