package com.amazonaws.services.kms.model.transform;

import com.amazonaws.services.kms.model.MultiRegionConfiguration;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.ListUnmarshaller;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

class MultiRegionConfigurationJsonUnmarshaller implements Unmarshaller<MultiRegionConfiguration, JsonUnmarshallerContext> {

    /* renamed from: a  reason: collision with root package name */
    public static MultiRegionConfigurationJsonUnmarshaller f15103a;

    public static MultiRegionConfigurationJsonUnmarshaller b() {
        if (f15103a == null) {
            f15103a = new MultiRegionConfigurationJsonUnmarshaller();
        }
        return f15103a;
    }

    /* renamed from: c */
    public MultiRegionConfiguration a(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        AwsJsonReader a11 = jsonUnmarshallerContext.a();
        if (!a11.a()) {
            a11.d();
            return null;
        }
        MultiRegionConfiguration multiRegionConfiguration = new MultiRegionConfiguration();
        a11.f();
        while (a11.hasNext()) {
            String e11 = a11.e();
            if (e11.equals("MultiRegionKeyType")) {
                multiRegionConfiguration.setMultiRegionKeyType(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else if (e11.equals("PrimaryKey")) {
                multiRegionConfiguration.setPrimaryKey(MultiRegionKeyJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else if (e11.equals("ReplicaKeys")) {
                multiRegionConfiguration.setReplicaKeys(new ListUnmarshaller(MultiRegionKeyJsonUnmarshaller.b()).a(jsonUnmarshallerContext));
            } else {
                a11.d();
            }
        }
        a11.h();
        return multiRegionConfiguration;
    }
}
