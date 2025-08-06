package com.tencent.thumbplayer.tcmedia.f;

import android.content.Context;
import com.jumio.analytics.MobileEvents;
import com.tencent.thumbplayer.tcmedia.api.richmedia.ITPRichMediaSynchronizerListener;
import com.tencent.thumbplayer.tcmedia.api.richmedia.TPRichMediaFeature;
import com.tencent.thumbplayer.tcmedia.api.richmedia.TPRichMediaFeatureData;
import com.tencent.thumbplayer.tcmedia.api.richmedia.TPRichMediaRequestExtraInfo;
import com.tencent.thumbplayer.tcmedia.core.richmedia.ITPNativeRichMediaInnerProcessorCallback;
import com.tencent.thumbplayer.tcmedia.core.richmedia.ITPNativeRichMediaProcessor;
import com.tencent.thumbplayer.tcmedia.core.richmedia.ITPNativeRichMediaProcessorCallback;
import com.tencent.thumbplayer.tcmedia.core.richmedia.TPNativeRichMediaFeature;
import com.tencent.thumbplayer.tcmedia.core.richmedia.TPNativeRichMediaFeatureData;
import com.tencent.thumbplayer.tcmedia.core.richmedia.TPNativeRichMediaProcessor;
import com.tencent.thumbplayer.tcmedia.core.richmedia.TPNativeRichMediaRequestExtraInfo;
import com.tencent.thumbplayer.tcmedia.f.a;
import com.tencent.thumbplayer.tcmedia.tplayer.plugins.c;
import okhttp3.internal.http.StatusLine;

public class b implements a {

    /* renamed from: a  reason: collision with root package name */
    private ITPNativeRichMediaProcessor f49176a;

    /* renamed from: b  reason: collision with root package name */
    private a f49177b;

    /* renamed from: c  reason: collision with root package name */
    private C0623b f49178c;

    /* renamed from: d  reason: collision with root package name */
    private c f49179d;

    public class a implements ITPNativeRichMediaInnerProcessorCallback {

        /* renamed from: b  reason: collision with root package name */
        private a.C0620a f49181b;

        public a() {
        }

        public void a(a.C0620a aVar) {
            this.f49181b = aVar;
        }

        public long onGetCurrentPositionMs(ITPNativeRichMediaProcessor iTPNativeRichMediaProcessor) {
            a.C0620a aVar = this.f49181b;
            if (aVar == null) {
                return -1;
            }
            long a11 = aVar.a(b.this);
            b.this.a(311, (int) a11, 0, (String) null, (Object) null);
            return a11;
        }
    }

    /* renamed from: com.tencent.thumbplayer.tcmedia.f.b$b  reason: collision with other inner class name */
    public class C0623b implements ITPNativeRichMediaProcessorCallback {

        /* renamed from: b  reason: collision with root package name */
        private ITPRichMediaSynchronizerListener f49198b;

        public C0623b() {
        }

        public void a(ITPRichMediaSynchronizerListener iTPRichMediaSynchronizerListener) {
            this.f49198b = iTPRichMediaSynchronizerListener;
        }

        public void onDeselectFeatureSuccess(ITPNativeRichMediaProcessor iTPNativeRichMediaProcessor, int i11) {
            b.this.a(MobileEvents.EVENTTYPE_EXCEPTION, i11, 0, (String) null, (Object) null);
            ITPRichMediaSynchronizerListener iTPRichMediaSynchronizerListener = this.f49198b;
            if (iTPRichMediaSynchronizerListener != null) {
                iTPRichMediaSynchronizerListener.onDeselectFeatureSuccess(b.this, i11);
            }
        }

        public void onRichMediaError(ITPNativeRichMediaProcessor iTPNativeRichMediaProcessor, int i11) {
            b.this.a(StatusLine.HTTP_PERM_REDIRECT, i11, 0, (String) null, (Object) null);
            ITPRichMediaSynchronizerListener iTPRichMediaSynchronizerListener = this.f49198b;
            if (iTPRichMediaSynchronizerListener != null) {
                iTPRichMediaSynchronizerListener.onRichMediaError(b.this, i11);
            }
        }

        public void onRichMediaFeatureData(ITPNativeRichMediaProcessor iTPNativeRichMediaProcessor, int i11, TPNativeRichMediaFeatureData tPNativeRichMediaFeatureData) {
            ITPRichMediaSynchronizerListener iTPRichMediaSynchronizerListener = this.f49198b;
            if (iTPRichMediaSynchronizerListener != null) {
                iTPRichMediaSynchronizerListener.onRichMediaFeatureData(b.this, i11, new TPRichMediaFeatureData(tPNativeRichMediaFeatureData));
            }
        }

        public void onRichMediaFeatureFailure(ITPNativeRichMediaProcessor iTPNativeRichMediaProcessor, int i11, int i12) {
            b.this.a(310, i11, i12, (String) null, (Object) null);
            ITPRichMediaSynchronizerListener iTPRichMediaSynchronizerListener = this.f49198b;
            if (iTPRichMediaSynchronizerListener != null) {
                iTPRichMediaSynchronizerListener.onRichMediaFeatureFailure(b.this, i11, i12);
            }
        }

        public void onRichMediaInfo(ITPNativeRichMediaProcessor iTPNativeRichMediaProcessor, int i11, long j11, long j12, long j13, Object obj) {
            ITPRichMediaSynchronizerListener iTPRichMediaSynchronizerListener = this.f49198b;
            if (iTPRichMediaSynchronizerListener != null) {
                iTPRichMediaSynchronizerListener.onRichMediaInfo(b.this, i11, j11, j12, j13, obj);
            }
        }

        public void onRichMediaPrepared(ITPNativeRichMediaProcessor iTPNativeRichMediaProcessor) {
            b.this.a(301, 0, 0, (String) null, b.this.getFeatures());
            ITPRichMediaSynchronizerListener iTPRichMediaSynchronizerListener = this.f49198b;
            if (iTPRichMediaSynchronizerListener != null) {
                iTPRichMediaSynchronizerListener.onRichMediaPrepared(b.this);
            }
        }

        public void onSelectFeatureSuccess(ITPNativeRichMediaProcessor iTPNativeRichMediaProcessor, int i11) {
            b.this.a(303, i11, 0, (String) null, (Object) null);
            ITPRichMediaSynchronizerListener iTPRichMediaSynchronizerListener = this.f49198b;
            if (iTPRichMediaSynchronizerListener != null) {
                iTPRichMediaSynchronizerListener.onSelectFeatureSuccess(b.this, i11);
            }
        }
    }

    public b(Context context) {
        this.f49176a = new TPNativeRichMediaProcessor(context);
        a aVar = new a();
        this.f49177b = aVar;
        this.f49176a.setInnerProcessorCallback(aVar);
        C0623b bVar = new C0623b();
        this.f49178c = bVar;
        this.f49176a.setProcessorCallback(bVar);
        c cVar = new c();
        this.f49179d = cVar;
        cVar.a(new com.tencent.thumbplayer.tcmedia.f.b.a());
    }

    /* access modifiers changed from: private */
    public void a(int i11, int i12, int i13, String str, Object obj) {
        this.f49179d.a(i11, i12, i13, str, obj);
    }

    public void a(float f11) {
        this.f49176a.setPlaybackRate(f11);
    }

    public void a(long j11) {
        this.f49176a.seek(j11);
    }

    public void a(a.C0620a aVar) {
        this.f49177b.a(aVar);
    }

    public void deselectFeatureAsync(int i11) {
        this.f49176a.deselectFeatureAsync(i11);
        a(304, i11, 0, (String) null, (Object) null);
    }

    public void finalize() {
        this.f49176a.setInnerProcessorCallback((ITPNativeRichMediaInnerProcessorCallback) null);
        this.f49176a.setProcessorCallback((ITPNativeRichMediaProcessorCallback) null);
        this.f49176a.release();
        this.f49178c.a((ITPRichMediaSynchronizerListener) null);
        this.f49177b.a((a.C0620a) null);
        super.finalize();
    }

    public TPRichMediaFeature[] getFeatures() {
        TPNativeRichMediaFeature[] features = this.f49176a.getFeatures();
        int i11 = 0;
        if (features == null) {
            return new TPRichMediaFeature[0];
        }
        TPRichMediaFeature[] tPRichMediaFeatureArr = new TPRichMediaFeature[features.length];
        while (i11 < features.length && features[i11] != null) {
            tPRichMediaFeatureArr[i11] = new TPRichMediaFeature(features[i11]);
            i11++;
        }
        return tPRichMediaFeatureArr;
    }

    public void prepareAsync() {
        this.f49176a.prepareAsync();
        a(300, 0, 0, (String) null, (Object) null);
    }

    public void release() {
        this.f49176a.setInnerProcessorCallback((ITPNativeRichMediaInnerProcessorCallback) null);
        this.f49176a.setProcessorCallback((ITPNativeRichMediaProcessorCallback) null);
        this.f49176a.release();
        this.f49178c.a((ITPRichMediaSynchronizerListener) null);
        this.f49177b.a((a.C0620a) null);
        a(307, 0, 0, (String) null, (Object) null);
        this.f49179d.c();
    }

    public void reset() {
        this.f49176a.reset();
        a(MobileEvents.EVENTTYPE_SDKPARAMETERS, 0, 0, (String) null, (Object) null);
    }

    public void selectFeatureAsync(int i11, TPRichMediaRequestExtraInfo tPRichMediaRequestExtraInfo) {
        TPNativeRichMediaRequestExtraInfo tPNativeRichMediaRequestExtraInfo = new TPNativeRichMediaRequestExtraInfo();
        tPNativeRichMediaRequestExtraInfo.setActOnOptional(tPRichMediaRequestExtraInfo.getActOnOption());
        this.f49176a.selectFeatureAsync(i11, tPNativeRichMediaRequestExtraInfo);
        a(302, i11, 0, (String) null, (Object) null);
    }

    public void setListener(ITPRichMediaSynchronizerListener iTPRichMediaSynchronizerListener) {
        this.f49178c.a(iTPRichMediaSynchronizerListener);
    }

    public void setRichMediaSource(String str) {
        this.f49176a.setRichMediaSource(str);
        a(MobileEvents.EVENTTYPE_NETWORKCALL, 0, 0, str, (Object) null);
    }
}
