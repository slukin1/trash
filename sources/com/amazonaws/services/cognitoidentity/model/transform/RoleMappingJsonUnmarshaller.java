package com.amazonaws.services.cognitoidentity.model.transform;

import com.amazonaws.services.cognitoidentity.model.RoleMapping;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

class RoleMappingJsonUnmarshaller implements Unmarshaller<RoleMapping, JsonUnmarshallerContext> {

    /* renamed from: a  reason: collision with root package name */
    public static RoleMappingJsonUnmarshaller f15091a;

    public static RoleMappingJsonUnmarshaller b() {
        if (f15091a == null) {
            f15091a = new RoleMappingJsonUnmarshaller();
        }
        return f15091a;
    }

    /* renamed from: c */
    public RoleMapping a(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        AwsJsonReader a11 = jsonUnmarshallerContext.a();
        if (!a11.a()) {
            a11.d();
            return null;
        }
        RoleMapping roleMapping = new RoleMapping();
        a11.f();
        while (a11.hasNext()) {
            String e11 = a11.e();
            if (e11.equals("Type")) {
                roleMapping.setType(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else if (e11.equals("AmbiguousRoleResolution")) {
                roleMapping.setAmbiguousRoleResolution(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else if (e11.equals("RulesConfiguration")) {
                roleMapping.setRulesConfiguration(RulesConfigurationTypeJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else {
                a11.d();
            }
        }
        a11.h();
        return roleMapping;
    }
}
