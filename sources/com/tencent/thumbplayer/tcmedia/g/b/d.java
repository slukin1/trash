package com.tencent.thumbplayer.tcmedia.g.b;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.view.Surface;
import com.tencent.thumbplayer.tcmedia.g.a.a;
import com.tencent.thumbplayer.tcmedia.g.f.a;
import com.tencent.thumbplayer.tcmedia.g.h.b;
import java.util.concurrent.atomic.AtomicInteger;

public final class d implements c {

    /* renamed from: a  reason: collision with root package name */
    private static AtomicInteger f49229a = new AtomicInteger(0);

    /* renamed from: b  reason: collision with root package name */
    private final MediaCodec f49230b;

    public d(MediaCodec mediaCodec) {
        this.f49230b = mediaCodec;
        b.c("DirectCodecWrapper", "DirectCodecWrapper sCodecNum:" + f49229a.incrementAndGet());
    }

    public final int a(long j11) {
        return this.f49230b.dequeueInputBuffer(j11);
    }

    public final int a(MediaCodec.BufferInfo bufferInfo, long j11) {
        return this.f49230b.dequeueOutputBuffer(bufferInfo, j11);
    }

    public final MediaCodec a() {
        return this.f49230b;
    }

    public final void a(int i11, int i12, int i13, long j11, int i14) {
        this.f49230b.queueInputBuffer(i11, i12, i13, j11, i14);
    }

    public final void a(int i11, boolean z11) {
        this.f49230b.releaseOutputBuffer(i11, z11);
    }

    public final void a(MediaFormat mediaFormat, Surface surface, MediaCrypto mediaCrypto, int i11) {
        this.f49230b.configure(mediaFormat, surface, mediaCrypto, i11);
    }

    public final void a(Surface surface) {
        b.c("DirectCodecWrapper", "DirectCodecWrapper setOutputSurface start, surface:".concat(String.valueOf(surface)));
        this.f49230b.setOutputSurface(surface);
        b.c("DirectCodecWrapper", "DirectCodecWrapper setOutputSurface end ...");
    }

    public final void a(a aVar) {
        b.d("DirectCodecWrapper", "DirectCodecWrapper setCodecCallback ignore...");
    }

    public final a.b b(e eVar) {
        b.d("DirectCodecWrapper", "setCanReuseType setCodecCallback ignore...");
        return a.b.KEEP_CODEC_RESULT_NO;
    }

    public final void b() {
    }

    public final void c() {
        b.d("DirectCodecWrapper", "DirectCodecWrapper prepareToReUse ignore...");
    }

    public final void d() {
        b.c("DirectCodecWrapper", "DirectCodecWrapper start ...");
        this.f49230b.start();
        b.c("DirectCodecWrapper", "DirectCodecWrapper start end...");
    }

    public final void e() {
        b.c("DirectCodecWrapper", "DirectCodecWrapper flush start ...");
        this.f49230b.flush();
        b.c("DirectCodecWrapper", "DirectCodecWrapper flush end ...");
    }

    public final void f() {
        b.c("DirectCodecWrapper", "DirectCodecWrapper stop before ...");
        this.f49230b.stop();
        b.c("DirectCodecWrapper", "DirectCodecWrapper stop end ...");
    }

    public final void g() {
        b.c("DirectCodecWrapper", "DirectCodecWrapper release start ...");
        this.f49230b.release();
        b.c("DirectCodecWrapper", "DirectCodecWrapper release end ... sCodecNum:" + f49229a.decrementAndGet());
    }
}
