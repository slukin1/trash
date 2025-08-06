package com.amazonaws.services.cognitoidentity.model.transform;

import com.amazonaws.services.cognitoidentity.model.RulesConfigurationType;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.ListUnmarshaller;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

class RulesConfigurationTypeJsonUnmarshaller implements Unmarshaller<RulesConfigurationType, JsonUnmarshallerContext> {

    /* renamed from: a  reason: collision with root package name */
    public static RulesConfigurationTypeJsonUnmarshaller f15092a;

    public static RulesConfigurationTypeJsonUnmarshaller b() {
        if (f15092a == null) {
            f15092a = new RulesConfigurationTypeJsonUnmarshaller();
        }
        return f15092a;
    }

    /* renamed from: c */
    public RulesConfigurationType a(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        AwsJsonReader a11 = jsonUnmarshallerContext.a();
        if (!a11.a()) {
            a11.d();
            return null;
        }
        RulesConfigurationType rulesConfigurationType = new RulesConfigurationType();
        a11.f();
        while (a11.hasNext()) {
            if (a11.e().equals("Rules")) {
                rulesConfigurationType.setRules(new ListUnmarshaller(MappingRuleJsonUnmarshaller.b()).a(jsonUnmarshallerContext));
            } else {
                a11.d();
            }
        }
        a11.h();
        return rulesConfigurationType;
    }
}
