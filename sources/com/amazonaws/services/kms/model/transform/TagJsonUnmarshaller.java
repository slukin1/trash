package com.amazonaws.services.kms.model.transform;

import com.amazonaws.services.kms.model.Tag;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

class TagJsonUnmarshaller implements Unmarshaller<Tag, JsonUnmarshallerContext> {

    /* renamed from: a  reason: collision with root package name */
    public static TagJsonUnmarshaller f15106a;

    public static TagJsonUnmarshaller b() {
        if (f15106a == null) {
            f15106a = new TagJsonUnmarshaller();
        }
        return f15106a;
    }

    /* renamed from: c */
    public Tag a(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        AwsJsonReader a11 = jsonUnmarshallerContext.a();
        if (!a11.a()) {
            a11.d();
            return null;
        }
        Tag tag = new Tag();
        a11.f();
        while (a11.hasNext()) {
            String e11 = a11.e();
            if (e11.equals("TagKey")) {
                tag.setTagKey(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else if (e11.equals("TagValue")) {
                tag.setTagValue(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else {
                a11.d();
            }
        }
        a11.h();
        return tag;
    }
}
