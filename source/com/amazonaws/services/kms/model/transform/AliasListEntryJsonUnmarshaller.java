package com.amazonaws.services.kms.model.transform;

import com.amazonaws.services.kms.model.AliasListEntry;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

class AliasListEntryJsonUnmarshaller implements Unmarshaller<AliasListEntry, JsonUnmarshallerContext> {

    /* renamed from: a  reason: collision with root package name */
    public static AliasListEntryJsonUnmarshaller f15097a;

    public static AliasListEntryJsonUnmarshaller b() {
        if (f15097a == null) {
            f15097a = new AliasListEntryJsonUnmarshaller();
        }
        return f15097a;
    }

    /* renamed from: c */
    public AliasListEntry a(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        AwsJsonReader a11 = jsonUnmarshallerContext.a();
        if (!a11.a()) {
            a11.d();
            return null;
        }
        AliasListEntry aliasListEntry = new AliasListEntry();
        a11.f();
        while (a11.hasNext()) {
            String e11 = a11.e();
            if (e11.equals("AliasName")) {
                aliasListEntry.setAliasName(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else if (e11.equals("AliasArn")) {
                aliasListEntry.setAliasArn(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else if (e11.equals("TargetKeyId")) {
                aliasListEntry.setTargetKeyId(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else if (e11.equals("CreationDate")) {
                aliasListEntry.setCreationDate(SimpleTypeJsonUnmarshallers.DateJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else if (e11.equals("LastUpdatedDate")) {
                aliasListEntry.setLastUpdatedDate(SimpleTypeJsonUnmarshallers.DateJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else {
                a11.d();
            }
        }
        a11.h();
        return aliasListEntry;
    }
}
