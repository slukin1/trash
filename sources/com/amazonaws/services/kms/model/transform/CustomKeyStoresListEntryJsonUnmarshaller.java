package com.amazonaws.services.kms.model.transform;

import com.amazonaws.services.kms.model.CustomKeyStoresListEntry;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

class CustomKeyStoresListEntryJsonUnmarshaller implements Unmarshaller<CustomKeyStoresListEntry, JsonUnmarshallerContext> {

    /* renamed from: a  reason: collision with root package name */
    public static CustomKeyStoresListEntryJsonUnmarshaller f15098a;

    public static CustomKeyStoresListEntryJsonUnmarshaller b() {
        if (f15098a == null) {
            f15098a = new CustomKeyStoresListEntryJsonUnmarshaller();
        }
        return f15098a;
    }

    /* renamed from: c */
    public CustomKeyStoresListEntry a(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        AwsJsonReader a11 = jsonUnmarshallerContext.a();
        if (!a11.a()) {
            a11.d();
            return null;
        }
        CustomKeyStoresListEntry customKeyStoresListEntry = new CustomKeyStoresListEntry();
        a11.f();
        while (a11.hasNext()) {
            String e11 = a11.e();
            if (e11.equals("CustomKeyStoreId")) {
                customKeyStoresListEntry.setCustomKeyStoreId(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else if (e11.equals("CustomKeyStoreName")) {
                customKeyStoresListEntry.setCustomKeyStoreName(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else if (e11.equals("CloudHsmClusterId")) {
                customKeyStoresListEntry.setCloudHsmClusterId(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else if (e11.equals("TrustAnchorCertificate")) {
                customKeyStoresListEntry.setTrustAnchorCertificate(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else if (e11.equals("ConnectionState")) {
                customKeyStoresListEntry.setConnectionState(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else if (e11.equals("ConnectionErrorCode")) {
                customKeyStoresListEntry.setConnectionErrorCode(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else if (e11.equals("CreationDate")) {
                customKeyStoresListEntry.setCreationDate(SimpleTypeJsonUnmarshallers.DateJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else if (e11.equals("CustomKeyStoreType")) {
                customKeyStoresListEntry.setCustomKeyStoreType(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else if (e11.equals("XksProxyConfiguration")) {
                customKeyStoresListEntry.setXksProxyConfiguration(XksProxyConfigurationTypeJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else {
                a11.d();
            }
        }
        a11.h();
        return customKeyStoresListEntry;
    }
}
