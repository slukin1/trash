package com.jumio.core.models;

import com.jumio.commons.PersistWith;
import com.jumio.core.data.ScanMode;

@PersistWith("LivenessScanPartModel")
public final class LivenessScanPartModel extends FaceScanPartModel {
    public LivenessScanPartModel(ScanMode scanMode) {
        super(scanMode);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0016, code lost:
        if ((r0.length == 0) != false) goto L_0x0018;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isComplete() {
        /*
            r3 = this;
            com.jumio.core.extraction.liveness.extraction.LivenessDataModel r0 = r3.getLivenessData()
            if (r0 == 0) goto L_0x000b
            com.jumio.commons.camera.ImageData[] r0 = r0.getFrames()
            goto L_0x000c
        L_0x000b:
            r0 = 0
        L_0x000c:
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x0018
            int r0 = r0.length
            if (r0 != 0) goto L_0x0015
            r0 = r2
            goto L_0x0016
        L_0x0015:
            r0 = r1
        L_0x0016:
            if (r0 == 0) goto L_0x0019
        L_0x0018:
            r1 = r2
        L_0x0019:
            r0 = r1 ^ 1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.core.models.LivenessScanPartModel.isComplete():boolean");
    }
}
