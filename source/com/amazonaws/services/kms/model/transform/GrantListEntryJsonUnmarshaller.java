package com.amazonaws.services.kms.model.transform;

import com.amazonaws.services.kms.model.GrantListEntry;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.ListUnmarshaller;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

class GrantListEntryJsonUnmarshaller implements Unmarshaller<GrantListEntry, JsonUnmarshallerContext> {

    /* renamed from: a  reason: collision with root package name */
    public static GrantListEntryJsonUnmarshaller f15100a;

    public static GrantListEntryJsonUnmarshaller b() {
        if (f15100a == null) {
            f15100a = new GrantListEntryJsonUnmarshaller();
        }
        return f15100a;
    }

    /* renamed from: c */
    public GrantListEntry a(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        AwsJsonReader a11 = jsonUnmarshallerContext.a();
        if (!a11.a()) {
            a11.d();
            return null;
        }
        GrantListEntry grantListEntry = new GrantListEntry();
        a11.f();
        while (a11.hasNext()) {
            String e11 = a11.e();
            if (e11.equals("KeyId")) {
                grantListEntry.setKeyId(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else if (e11.equals("GrantId")) {
                grantListEntry.setGrantId(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else if (e11.equals("Name")) {
                grantListEntry.setName(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else if (e11.equals("CreationDate")) {
                grantListEntry.setCreationDate(SimpleTypeJsonUnmarshallers.DateJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else if (e11.equals("GranteePrincipal")) {
                grantListEntry.setGranteePrincipal(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else if (e11.equals("RetiringPrincipal")) {
                grantListEntry.setRetiringPrincipal(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else if (e11.equals("IssuingAccount")) {
                grantListEntry.setIssuingAccount(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else if (e11.equals("Operations")) {
                grantListEntry.setOperations(new ListUnmarshaller(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.b()).a(jsonUnmarshallerContext));
            } else if (e11.equals("Constraints")) {
                grantListEntry.setConstraints(GrantConstraintsJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else {
                a11.d();
            }
        }
        a11.h();
        return grantListEntry;
    }
}
