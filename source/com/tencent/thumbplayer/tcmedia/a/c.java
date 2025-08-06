package com.tencent.thumbplayer.tcmedia.a;

import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import com.tencent.thumbplayer.tcmedia.a.b;
import com.tencent.thumbplayer.tcmedia.adapter.a.a;
import com.tencent.thumbplayer.tcmedia.api.TPCaptureCallBack;
import com.tencent.thumbplayer.tcmedia.core.imagegenerator.TPImageGeneratorParams;
import java.io.FileDescriptor;
import java.util.HashMap;
import java.util.Map;

public class c implements b.a, a {

    /* renamed from: a  reason: collision with root package name */
    private Map<Integer, TPCaptureCallBack> f48703a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private String f48704b;

    /* renamed from: c  reason: collision with root package name */
    private FileDescriptor f48705c;

    /* renamed from: d  reason: collision with root package name */
    private AssetFileDescriptor f48706d;

    public c(AssetFileDescriptor assetFileDescriptor) {
        this.f48706d = assetFileDescriptor;
    }

    public c(FileDescriptor fileDescriptor) {
        this.f48705c = fileDescriptor;
    }

    public c(String str) {
        this.f48704b = str;
    }

    public void a() {
        this.f48703a.clear();
    }

    public void a(int i11, int i12) {
        TPCaptureCallBack tPCaptureCallBack = this.f48703a.get(Integer.valueOf(i11));
        if (tPCaptureCallBack != null) {
            tPCaptureCallBack.onCaptureVideoFailed(i12);
        }
    }

    public void a(int i11, long j11, int i12, int i13, Bitmap bitmap, long j12) {
        TPCaptureCallBack tPCaptureCallBack = this.f48703a.get(Integer.valueOf(i11));
        if (tPCaptureCallBack != null) {
            tPCaptureCallBack.onCaptureVideoSuccess(bitmap);
        }
    }

    public void a(long j11, TPImageGeneratorParams tPImageGeneratorParams, TPCaptureCallBack tPCaptureCallBack) {
        b.d dVar = new b.d();
        dVar.f48697a = this.f48704b;
        dVar.f48698b = this.f48705c;
        dVar.f48699c = this.f48706d;
        dVar.f48700d = j11;
        dVar.f48701e = tPImageGeneratorParams.width;
        dVar.f48702f = tPImageGeneratorParams.height;
        this.f48703a.put(Integer.valueOf(b.a().a(dVar, (b.a) this)), tPCaptureCallBack);
    }
}
