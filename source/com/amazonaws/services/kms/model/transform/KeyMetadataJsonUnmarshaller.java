package com.amazonaws.services.kms.model.transform;

import com.amazonaws.services.kms.model.KeyMetadata;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.ListUnmarshaller;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;
import com.google.common.net.HttpHeaders;

class KeyMetadataJsonUnmarshaller implements Unmarshaller<KeyMetadata, JsonUnmarshallerContext> {

    /* renamed from: a  reason: collision with root package name */
    public static KeyMetadataJsonUnmarshaller f15102a;

    public static KeyMetadataJsonUnmarshaller b() {
        if (f15102a == null) {
            f15102a = new KeyMetadataJsonUnmarshaller();
        }
        return f15102a;
    }

    /* renamed from: c */
    public KeyMetadata a(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        AwsJsonReader a11 = jsonUnmarshallerContext.a();
        if (!a11.a()) {
            a11.d();
            return null;
        }
        KeyMetadata keyMetadata = new KeyMetadata();
        a11.f();
        while (a11.hasNext()) {
            String e11 = a11.e();
            if (e11.equals("AWSAccountId")) {
                keyMetadata.setAWSAccountId(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else if (e11.equals("KeyId")) {
                keyMetadata.setKeyId(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else if (e11.equals("Arn")) {
                keyMetadata.setArn(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else if (e11.equals("CreationDate")) {
                keyMetadata.setCreationDate(SimpleTypeJsonUnmarshallers.DateJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else if (e11.equals("Enabled")) {
                keyMetadata.setEnabled(SimpleTypeJsonUnmarshallers.BooleanJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else if (e11.equals("Description")) {
                keyMetadata.setDescription(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else if (e11.equals("KeyUsage")) {
                keyMetadata.setKeyUsage(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else if (e11.equals("KeyState")) {
                keyMetadata.setKeyState(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else if (e11.equals("DeletionDate")) {
                keyMetadata.setDeletionDate(SimpleTypeJsonUnmarshallers.DateJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else if (e11.equals("ValidTo")) {
                keyMetadata.setValidTo(SimpleTypeJsonUnmarshallers.DateJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else if (e11.equals(HttpHeaders.ORIGIN)) {
                keyMetadata.setOrigin(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else if (e11.equals("CustomKeyStoreId")) {
                keyMetadata.setCustomKeyStoreId(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else if (e11.equals("CloudHsmClusterId")) {
                keyMetadata.setCloudHsmClusterId(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else if (e11.equals("ExpirationModel")) {
                keyMetadata.setExpirationModel(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else if (e11.equals("KeyManager")) {
                keyMetadata.setKeyManager(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else if (e11.equals("CustomerMasterKeySpec")) {
                keyMetadata.setCustomerMasterKeySpec(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else if (e11.equals("KeySpec")) {
                keyMetadata.setKeySpec(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else if (e11.equals("EncryptionAlgorithms")) {
                keyMetadata.setEncryptionAlgorithms(new ListUnmarshaller(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.b()).a(jsonUnmarshallerContext));
            } else if (e11.equals("SigningAlgorithms")) {
                keyMetadata.setSigningAlgorithms(new ListUnmarshaller(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.b()).a(jsonUnmarshallerContext));
            } else if (e11.equals("KeyAgreementAlgorithms")) {
                keyMetadata.setKeyAgreementAlgorithms(new ListUnmarshaller(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.b()).a(jsonUnmarshallerContext));
            } else if (e11.equals("MultiRegion")) {
                keyMetadata.setMultiRegion(SimpleTypeJsonUnmarshallers.BooleanJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else if (e11.equals("MultiRegionConfiguration")) {
                keyMetadata.setMultiRegionConfiguration(MultiRegionConfigurationJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else if (e11.equals("PendingDeletionWindowInDays")) {
                keyMetadata.setPendingDeletionWindowInDays(SimpleTypeJsonUnmarshallers.IntegerJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else if (e11.equals("MacAlgorithms")) {
                keyMetadata.setMacAlgorithms(new ListUnmarshaller(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.b()).a(jsonUnmarshallerContext));
            } else if (e11.equals("XksKeyConfiguration")) {
                keyMetadata.setXksKeyConfiguration(XksKeyConfigurationTypeJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else {
                a11.d();
            }
        }
        a11.h();
        return keyMetadata;
    }
}
