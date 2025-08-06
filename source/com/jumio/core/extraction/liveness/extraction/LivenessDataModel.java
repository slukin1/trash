package com.jumio.core.extraction.liveness.extraction;

import com.jumio.commons.PersistWith;
import com.jumio.commons.camera.ImageData;
import com.jumio.core.data.ScanMode;
import com.jumio.core.model.StaticModel;

@PersistWith("LivenessDataModel")
public final class LivenessDataModel implements StaticModel {

    /* renamed from: a  reason: collision with root package name */
    public ScanMode f39202a;

    /* renamed from: b  reason: collision with root package name */
    public ImageData[] f39203b;

    /* renamed from: c  reason: collision with root package name */
    public Boolean f39204c;

    public final ImageData[] getFrames() {
        return this.f39203b;
    }

    public final ScanMode getType() {
        return this.f39202a;
    }

    public final Boolean isPassed() {
        return this.f39204c;
    }

    public final void setFrames(ImageData[] imageDataArr) {
        this.f39203b = imageDataArr;
    }

    public final void setPassed(Boolean bool) {
        this.f39204c = bool;
    }

    public final void setType(ScanMode scanMode) {
        this.f39202a = scanMode;
    }
}
