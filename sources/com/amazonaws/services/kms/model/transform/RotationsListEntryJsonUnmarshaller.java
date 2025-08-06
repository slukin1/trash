package com.amazonaws.services.kms.model.transform;

import com.amazonaws.services.kms.model.RotationsListEntry;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

class RotationsListEntryJsonUnmarshaller implements Unmarshaller<RotationsListEntry, JsonUnmarshallerContext> {

    /* renamed from: a  reason: collision with root package name */
    public static RotationsListEntryJsonUnmarshaller f15105a;

    public static RotationsListEntryJsonUnmarshaller b() {
        if (f15105a == null) {
            f15105a = new RotationsListEntryJsonUnmarshaller();
        }
        return f15105a;
    }

    /* renamed from: c */
    public RotationsListEntry a(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        AwsJsonReader a11 = jsonUnmarshallerContext.a();
        if (!a11.a()) {
            a11.d();
            return null;
        }
        RotationsListEntry rotationsListEntry = new RotationsListEntry();
        a11.f();
        while (a11.hasNext()) {
            String e11 = a11.e();
            if (e11.equals("KeyId")) {
                rotationsListEntry.setKeyId(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else if (e11.equals("RotationDate")) {
                rotationsListEntry.setRotationDate(SimpleTypeJsonUnmarshallers.DateJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else if (e11.equals("RotationType")) {
                rotationsListEntry.setRotationType(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else {
                a11.d();
            }
        }
        a11.h();
        return rotationsListEntry;
    }
}
