package com.sumsub.sns.internal.videoident.videoident.chat;

import android.graphics.Bitmap;
import com.sumsub.sns.internal.videoident.videoident.SNSVideoIdent;
import com.sumsub.sns.internal.videoident.videoident.twilio.b;
import d10.l;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Unit;
import tvi.webrtc.VideoFrame;
import tvi.webrtc.VideoProcessor;
import tvi.webrtc.VideoSink;

public final class a implements VideoProcessor {

    /* renamed from: a  reason: collision with root package name */
    public VideoSink f37043a;

    /* renamed from: b  reason: collision with root package name */
    public final AtomicReference<Boolean> f37044b = new AtomicReference<>(Boolean.FALSE);

    /* renamed from: c  reason: collision with root package name */
    public d10.a<Unit> f37045c;

    /* renamed from: d  reason: collision with root package name */
    public l<? super Bitmap, Unit> f37046d;

    public a(VideoSink videoSink) {
        this.f37043a = videoSink;
    }

    public final void a(VideoSink videoSink) {
        this.f37043a = videoSink;
    }

    public final l<Bitmap, Unit> b() {
        l<? super Bitmap, Unit> lVar = this.f37046d;
        if (lVar != null) {
            return lVar;
        }
        return null;
    }

    public final VideoSink c() {
        return this.f37043a;
    }

    public final boolean d() {
        return this.f37044b.get().booleanValue();
    }

    public final void e() {
        if (this.f37044b.get().booleanValue()) {
            com.sumsub.sns.internal.videoident.videoident.a.a(SNSVideoIdent.logTag, "makePhoto: already making photo", (Throwable) null, 4, (Object) null);
        } else {
            this.f37044b.set(Boolean.TRUE);
        }
    }

    public void onCapturerStarted(boolean z11) {
    }

    public void onCapturerStopped() {
    }

    public void onFrameCaptured(VideoFrame videoFrame) {
    }

    public void onFrameCaptured(VideoFrame videoFrame, VideoProcessor.FrameAdaptationParameters frameAdaptationParameters) {
        if (videoFrame != null) {
            videoFrame.retain();
            if (this.f37044b.compareAndSet(Boolean.TRUE, Boolean.FALSE)) {
                d10.a<Unit> aVar = this.f37045c;
                if (aVar != null) {
                    aVar.invoke();
                }
                com.sumsub.sns.internal.videoident.videoident.a.a(SNSVideoIdent.logTag, "decoding frame w=" + videoFrame.getBuffer().getWidth() + ", h=" + videoFrame.getBuffer().getHeight(), (Throwable) null, 4, (Object) null);
                b().invoke(b.a(videoFrame));
            }
            videoFrame.release();
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public void setSink(VideoSink videoSink) {
    }

    public final d10.a<Unit> a() {
        return this.f37045c;
    }

    public final void a(d10.a<Unit> aVar) {
        this.f37045c = aVar;
    }

    public final void a(l<? super Bitmap, Unit> lVar) {
        this.f37046d = lVar;
    }
}
