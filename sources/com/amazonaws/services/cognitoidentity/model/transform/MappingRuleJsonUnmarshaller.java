package com.amazonaws.services.cognitoidentity.model.transform;

import com.amazonaws.services.cognitoidentity.model.MappingRule;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

class MappingRuleJsonUnmarshaller implements Unmarshaller<MappingRule, JsonUnmarshallerContext> {

    /* renamed from: a  reason: collision with root package name */
    public static MappingRuleJsonUnmarshaller f15090a;

    public static MappingRuleJsonUnmarshaller b() {
        if (f15090a == null) {
            f15090a = new MappingRuleJsonUnmarshaller();
        }
        return f15090a;
    }

    /* renamed from: c */
    public MappingRule a(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        AwsJsonReader a11 = jsonUnmarshallerContext.a();
        if (!a11.a()) {
            a11.d();
            return null;
        }
        MappingRule mappingRule = new MappingRule();
        a11.f();
        while (a11.hasNext()) {
            String e11 = a11.e();
            if (e11.equals("Claim")) {
                mappingRule.setClaim(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else if (e11.equals("MatchType")) {
                mappingRule.setMatchType(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else if (e11.equals("Value")) {
                mappingRule.setValue(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else if (e11.equals("RoleARN")) {
                mappingRule.setRoleARN(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else {
                a11.d();
            }
        }
        a11.h();
        return mappingRule;
    }
}
