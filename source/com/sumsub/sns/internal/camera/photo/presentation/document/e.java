package com.sumsub.sns.internal.camera.photo.presentation.document;

import androidx.camera.video.v;
import com.sumsub.sns.internal.ml.autocapture.SeamlessDocaptureMobileConfig;
import kotlin.NoWhenBranchMatchedException;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static final long f31754a = 1048576;

    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f31755a;

        static {
            int[] iArr = new int[SeamlessDocaptureMobileConfig.VideoQuality.values().length];
            iArr[SeamlessDocaptureMobileConfig.VideoQuality.UHD.ordinal()] = 1;
            iArr[SeamlessDocaptureMobileConfig.VideoQuality.FHD.ordinal()] = 2;
            iArr[SeamlessDocaptureMobileConfig.VideoQuality.HD.ordinal()] = 3;
            iArr[SeamlessDocaptureMobileConfig.VideoQuality.SD.ordinal()] = 4;
            f31755a = iArr;
        }
    }

    public static final v b(SeamlessDocaptureMobileConfig.VideoQuality videoQuality) {
        int i11 = a.f31755a[videoQuality.ordinal()];
        if (i11 == 1) {
            return v.f6368d;
        }
        if (i11 == 2) {
            return v.f6367c;
        }
        if (i11 == 3) {
            return v.f6366b;
        }
        if (i11 == 4) {
            return v.f6365a;
        }
        throw new NoWhenBranchMatchedException();
    }
}
