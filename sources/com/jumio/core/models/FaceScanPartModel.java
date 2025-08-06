package com.jumio.core.models;

import com.jumio.commons.PersistWith;
import com.jumio.core.data.ScanMode;
import com.jumio.core.extraction.liveness.extraction.LivenessDataModel;
import com.jumio.core.util.FileData;
import com.jumio.sdk.enums.JumioCredentialPart;
import kotlin.jvm.internal.r;

@PersistWith("FaceScanPartModel")
public class FaceScanPartModel extends ScanPartModel {

    /* renamed from: j  reason: collision with root package name */
    public LivenessDataModel f39308j;

    public FaceScanPartModel(ScanMode scanMode) {
        super(JumioCredentialPart.FACE, scanMode, (FileData) null, 4, (r) null);
    }

    public final LivenessDataModel getLivenessData() {
        return this.f39308j;
    }

    public final void setLivenessData(LivenessDataModel livenessDataModel) {
        this.f39308j = livenessDataModel;
    }
}
