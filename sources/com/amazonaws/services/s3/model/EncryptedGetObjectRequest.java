package com.amazonaws.services.s3.model;

import java.util.Map;

public class EncryptedGetObjectRequest extends GetObjectRequest {
    private String instructionFileSuffix;
    private boolean keyWrapExpected;
    private ExtraMaterialsDescription supplemental;

    public EncryptedGetObjectRequest(String str, String str2) {
        this(str, str2, (String) null);
    }

    public ExtraMaterialsDescription getExtraMaterialDescription() {
        return this.supplemental;
    }

    public String getInstructionFileSuffix() {
        return this.instructionFileSuffix;
    }

    public boolean isKeyWrapExpected() {
        return this.keyWrapExpected;
    }

    public void setExtraMaterialDescription(ExtraMaterialsDescription extraMaterialsDescription) {
        if (extraMaterialsDescription == null) {
            extraMaterialsDescription = ExtraMaterialsDescription.NONE;
        }
        this.supplemental = extraMaterialsDescription;
    }

    public void setInstructionFileSuffix(String str) {
        this.instructionFileSuffix = str;
    }

    public void setKeyWrapExpected(boolean z11) {
        this.keyWrapExpected = z11;
    }

    public EncryptedGetObjectRequest withExtraMaterialsDescription(ExtraMaterialsDescription extraMaterialsDescription) {
        setExtraMaterialDescription(extraMaterialsDescription);
        return this;
    }

    public EncryptedGetObjectRequest withInstructionFileSuffix(String str) {
        this.instructionFileSuffix = str;
        return this;
    }

    public EncryptedGetObjectRequest withKeyWrapExpected(boolean z11) {
        this.keyWrapExpected = z11;
        return this;
    }

    public EncryptedGetObjectRequest(String str, String str2, String str3) {
        super(str, str2, str3);
        this.supplemental = ExtraMaterialsDescription.NONE;
        setKey(str2);
        setVersionId(str3);
    }

    public EncryptedGetObjectRequest withExtraMaterialsDescription(Map<String, String> map) {
        setExtraMaterialDescription(map == null ? null : new ExtraMaterialsDescription(map));
        return this;
    }

    public EncryptedGetObjectRequest(S3ObjectId s3ObjectId) {
        super(s3ObjectId);
        this.supplemental = ExtraMaterialsDescription.NONE;
    }

    public EncryptedGetObjectRequest(String str, String str2, boolean z11) {
        super(str, str2, z11);
        this.supplemental = ExtraMaterialsDescription.NONE;
    }
}
