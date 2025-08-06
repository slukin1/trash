package com.amazonaws.services.kms.model.transform;

import com.amazonaws.services.kms.model.ReplicateKeyResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.ListUnmarshaller;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

public class ReplicateKeyResultJsonUnmarshaller implements Unmarshaller<ReplicateKeyResult, JsonUnmarshallerContext> {
    /* renamed from: b */
    public ReplicateKeyResult a(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        ReplicateKeyResult replicateKeyResult = new ReplicateKeyResult();
        AwsJsonReader a11 = jsonUnmarshallerContext.a();
        a11.f();
        while (a11.hasNext()) {
            String e11 = a11.e();
            if (e11.equals("ReplicaKeyMetadata")) {
                replicateKeyResult.setReplicaKeyMetadata(KeyMetadataJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else if (e11.equals("ReplicaPolicy")) {
                replicateKeyResult.setReplicaPolicy(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else if (e11.equals("ReplicaTags")) {
                replicateKeyResult.setReplicaTags(new ListUnmarshaller(TagJsonUnmarshaller.b()).a(jsonUnmarshallerContext));
            } else {
                a11.d();
            }
        }
        a11.h();
        return replicateKeyResult;
    }
}
