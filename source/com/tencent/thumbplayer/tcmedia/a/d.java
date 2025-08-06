package com.tencent.thumbplayer.tcmedia.a;

import android.graphics.Bitmap;
import android.util.Log;
import com.tencent.thumbplayer.tcmedia.adapter.a.a;
import com.tencent.thumbplayer.tcmedia.api.TPCaptureCallBack;
import com.tencent.thumbplayer.tcmedia.core.common.TPGeneralError;
import com.tencent.thumbplayer.tcmedia.core.common.TPVideoFrame;
import com.tencent.thumbplayer.tcmedia.core.imagegenerator.ITPImageGeneratorCallback;
import com.tencent.thumbplayer.tcmedia.core.imagegenerator.TPImageGenerator;
import com.tencent.thumbplayer.tcmedia.core.imagegenerator.TPImageGeneratorParams;
import com.tencent.thumbplayer.tcmedia.utils.TPLogUtil;
import java.util.HashMap;
import java.util.Map;

public class d implements a, ITPImageGeneratorCallback {

    /* renamed from: a  reason: collision with root package name */
    private long f48707a;

    /* renamed from: b  reason: collision with root package name */
    private TPImageGenerator f48708b;

    /* renamed from: c  reason: collision with root package name */
    private Map<Long, TPCaptureCallBack> f48709c;

    public d(int i11) {
        this(i11, 0, 0);
    }

    public d(int i11, long j11, long j12) {
        this.f48707a = 0;
        this.f48708b = new TPImageGenerator(i11, j11, j12, this);
        this.f48709c = new HashMap();
        try {
            this.f48708b.init();
        } catch (Exception e11) {
            TPLogUtil.e("TPThumbPlayer[TPThumbCapture.java]", "init: " + Log.getStackTraceString(e11));
        }
    }

    public d(String str) {
        this.f48707a = 0;
        this.f48708b = new TPImageGenerator(str, this);
        this.f48709c = new HashMap();
        try {
            this.f48708b.init();
        } catch (Exception e11) {
            TPLogUtil.e("TPThumbPlayer[TPThumbCapture.java]", "init: " + Log.getStackTraceString(e11));
        }
    }

    public void a() {
        try {
            this.f48708b.cancelAllImageGenerations();
            this.f48708b.unInit();
        } catch (Exception e11) {
            TPLogUtil.e("TPThumbPlayer[TPThumbCapture.java]", "release: " + Log.getStackTraceString(e11));
        }
        this.f48709c.clear();
        this.f48708b = null;
    }

    public void a(long j11, TPImageGeneratorParams tPImageGeneratorParams, TPCaptureCallBack tPCaptureCallBack) {
        if (tPImageGeneratorParams == null) {
            tPImageGeneratorParams = new TPImageGeneratorParams();
            tPImageGeneratorParams.format = 37;
        }
        TPImageGeneratorParams tPImageGeneratorParams2 = tPImageGeneratorParams;
        long j12 = this.f48707a + 1;
        this.f48707a = j12;
        this.f48709c.put(Long.valueOf(j12), tPCaptureCallBack);
        try {
            this.f48708b.generateImageAsyncAtTime(j11, this.f48707a, tPImageGeneratorParams2);
        } catch (Exception e11) {
            TPLogUtil.e("TPThumbPlayer[TPThumbCapture.java]", "generateImageAsyncAtTime: " + Log.getStackTraceString(e11));
        }
    }

    public void onImageGenerationCompleted(int i11, long j11, long j12, long j13, TPVideoFrame tPVideoFrame) {
        TPCaptureCallBack tPCaptureCallBack = this.f48709c.get(Long.valueOf(j13));
        if (tPCaptureCallBack != null) {
            if (i11 == 0 && tPVideoFrame != null) {
                Bitmap a11 = a.a(tPVideoFrame);
                if (a11 != null) {
                    tPCaptureCallBack.onCaptureVideoSuccess(a11);
                } else {
                    i11 = TPGeneralError.FAILED;
                }
            }
            tPCaptureCallBack.onCaptureVideoFailed(i11);
        }
        this.f48709c.remove(Long.valueOf(j13));
    }
}
