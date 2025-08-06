package com.jumio.core.models;

import com.jumio.commons.PersistWith;
import com.jumio.core.data.ScanMode;
import com.jumio.core.util.FileData;
import com.jumio.sdk.enums.JumioCredentialPart;
import kotlin.jvm.internal.r;

@PersistWith("DigitalIdScanPartModel")
public final class DigitalIdScanPartModel extends ScanPartModel {

    /* renamed from: j  reason: collision with root package name */
    public final DigitalSelectionModel f39276j;

    /* renamed from: k  reason: collision with root package name */
    public String f39277k = "";

    public DigitalIdScanPartModel(ScanMode scanMode, DigitalSelectionModel digitalSelectionModel) {
        super(JumioCredentialPart.DIGITAL, scanMode, (FileData) null, 4, (r) null);
        this.f39276j = digitalSelectionModel;
    }

    public final String getResult() {
        return this.f39277k;
    }

    public final DigitalSelectionModel getSelectionModel() {
        return this.f39276j;
    }

    public boolean isComplete() {
        return (this.f39277k.length() > 0) && (StringsKt__StringsJVMKt.z(this.f39277k) ^ true);
    }

    public final void setResult(String str) {
        this.f39277k = str;
    }
}
