package com.amazonaws.services.kms.model.transform;

import com.amazonaws.services.kms.model.KeyListEntry;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

class KeyListEntryJsonUnmarshaller implements Unmarshaller<KeyListEntry, JsonUnmarshallerContext> {

    /* renamed from: a  reason: collision with root package name */
    public static KeyListEntryJsonUnmarshaller f15101a;

    public static KeyListEntryJsonUnmarshaller b() {
        if (f15101a == null) {
            f15101a = new KeyListEntryJsonUnmarshaller();
        }
        return f15101a;
    }

    /* renamed from: c */
    public KeyListEntry a(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        AwsJsonReader a11 = jsonUnmarshallerContext.a();
        if (!a11.a()) {
            a11.d();
            return null;
        }
        KeyListEntry keyListEntry = new KeyListEntry();
        a11.f();
        while (a11.hasNext()) {
            String e11 = a11.e();
            if (e11.equals("KeyId")) {
                keyListEntry.setKeyId(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else if (e11.equals("KeyArn")) {
                keyListEntry.setKeyArn(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else {
                a11.d();
            }
        }
        a11.h();
        return keyListEntry;
    }
}
