package com.jumio.sdk.result;

import com.jumio.sdk.enums.JumioScanMode;
import java.io.Serializable;

public class JumioCredentialResult implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public JumioScanMode f24981a;

    /* renamed from: b  reason: collision with root package name */
    public JumioImageData f24982b;

    public final JumioScanMode getExtractionMode() {
        return this.f24981a;
    }

    public final JumioImageData getImageData() {
        return this.f24982b;
    }

    public final void setExtractionMode(JumioScanMode jumioScanMode) {
        this.f24981a = jumioScanMode;
    }

    public final void setImageData(JumioImageData jumioImageData) {
        this.f24982b = jumioImageData;
    }
}
