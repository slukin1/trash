package com.jumio.core.data.digitaldocument;

import com.jumio.core.data.ScanMode;
import com.jumio.sdk.enums.JumioCredentialPart;
import java.io.Serializable;
import org.json.JSONObject;

public final class DigitalDocumentPart implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public final JumioCredentialPart f39094a;

    /* renamed from: b  reason: collision with root package name */
    public final ScanMode f39095b;

    public DigitalDocumentPart(JSONObject jSONObject) {
        this.f39094a = JumioCredentialPart.valueOf(jSONObject.getString("part"));
        this.f39095b = ScanMode.valueOf(jSONObject.getString("extraction"));
    }

    public final ScanMode getExtraction() {
        return this.f39095b;
    }

    public final JumioCredentialPart getPart() {
        return this.f39094a;
    }
}
