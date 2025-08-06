package com.amazonaws.services.kms.model.transform;

import com.amazonaws.services.kms.model.ListKeyPoliciesResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.ListUnmarshaller;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

public class ListKeyPoliciesResultJsonUnmarshaller implements Unmarshaller<ListKeyPoliciesResult, JsonUnmarshallerContext> {
    /* renamed from: b */
    public ListKeyPoliciesResult a(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        ListKeyPoliciesResult listKeyPoliciesResult = new ListKeyPoliciesResult();
        AwsJsonReader a11 = jsonUnmarshallerContext.a();
        a11.f();
        while (a11.hasNext()) {
            String e11 = a11.e();
            if (e11.equals("PolicyNames")) {
                listKeyPoliciesResult.setPolicyNames(new ListUnmarshaller(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.b()).a(jsonUnmarshallerContext));
            } else if (e11.equals("NextMarker")) {
                listKeyPoliciesResult.setNextMarker(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else if (e11.equals("Truncated")) {
                listKeyPoliciesResult.setTruncated(SimpleTypeJsonUnmarshallers.BooleanJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else {
                a11.d();
            }
        }
        a11.h();
        return listKeyPoliciesResult;
    }
}
