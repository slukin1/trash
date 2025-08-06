package com.amazonaws.services.kms.model.transform;

import com.amazonaws.services.kms.model.XksKeyConfigurationType;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

class XksKeyConfigurationTypeJsonUnmarshaller implements Unmarshaller<XksKeyConfigurationType, JsonUnmarshallerContext> {

    /* renamed from: a  reason: collision with root package name */
    public static XksKeyConfigurationTypeJsonUnmarshaller f15107a;

    public static XksKeyConfigurationTypeJsonUnmarshaller b() {
        if (f15107a == null) {
            f15107a = new XksKeyConfigurationTypeJsonUnmarshaller();
        }
        return f15107a;
    }

    /* renamed from: c */
    public XksKeyConfigurationType a(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        AwsJsonReader a11 = jsonUnmarshallerContext.a();
        if (!a11.a()) {
            a11.d();
            return null;
        }
        XksKeyConfigurationType xksKeyConfigurationType = new XksKeyConfigurationType();
        a11.f();
        while (a11.hasNext()) {
            if (a11.e().equals("Id")) {
                xksKeyConfigurationType.setId(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else {
                a11.d();
            }
        }
        a11.h();
        return xksKeyConfigurationType;
    }
}
