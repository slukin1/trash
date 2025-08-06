package com.tencent.thumbplayer.tcmedia.g;

import android.media.Image;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Surface;
import com.tencent.thumbplayer.tcmedia.g.b.c;
import com.tencent.thumbplayer.tcmedia.g.h.d;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public boolean f49210a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f49211b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public c f49212c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public com.tencent.thumbplayer.tcmedia.g.a.a f49213d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final com.tencent.thumbplayer.tcmedia.g.g.a f49214e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f49215f = true;

    /* renamed from: g  reason: collision with root package name */
    private boolean f49216g;

    /* renamed from: h  reason: collision with root package name */
    private final String f49217h;

    /* renamed from: i  reason: collision with root package name */
    private C0624b f49218i;

    public static abstract class a {
        public abstract void onError(b bVar, MediaCodec.CodecException codecException);

        public abstract void onInputBufferAvailable(b bVar, int i11);

        public abstract void onOutputBufferAvailable(b bVar, int i11, MediaCodec.BufferInfo bufferInfo);

        public abstract void onOutputFormatChanged(b bVar, MediaFormat mediaFormat);
    }

    /* renamed from: com.tencent.thumbplayer.tcmedia.g.b$b  reason: collision with other inner class name */
    public enum C0624b {
        CreateByName,
        CreateByType
    }

    public static final class c extends MediaCodec.Callback {

        /* renamed from: a  reason: collision with root package name */
        private final b f49227a;

        /* renamed from: b  reason: collision with root package name */
        private final a f49228b;

        public c(b bVar, a aVar) {
            this.f49227a = bVar;
            this.f49228b = aVar;
        }

        public final void onError(MediaCodec mediaCodec, MediaCodec.CodecException codecException) {
            a aVar = this.f49228b;
            if (aVar != null) {
                aVar.onError(this.f49227a, codecException);
            }
        }

        public final void onInputBufferAvailable(MediaCodec mediaCodec, int i11) {
            a aVar = this.f49228b;
            if (aVar != null) {
                aVar.onInputBufferAvailable(this.f49227a, i11);
            }
        }

        public final void onOutputBufferAvailable(MediaCodec mediaCodec, int i11, MediaCodec.BufferInfo bufferInfo) {
            a aVar = this.f49228b;
            if (aVar != null) {
                aVar.onOutputBufferAvailable(this.f49227a, i11, bufferInfo);
            }
        }

        public final void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
            a aVar = this.f49228b;
            if (aVar != null) {
                aVar.onOutputFormatChanged(this.f49227a, mediaFormat);
            }
        }
    }

    private b(String str, C0624b bVar) {
        this.f49217h = str;
        this.f49218i = bVar;
        this.f49214e = new com.tencent.thumbplayer.tcmedia.g.g.a(b());
    }

    public static b a(String str) {
        return new b(str, C0624b.CreateByName);
    }

    private void b(Surface surface) {
        this.f49210a = a.a().a(this, surface);
        this.f49214e.a();
        this.f49214e.b();
        this.f49214e.a(this.f49210a);
    }

    private void m() {
        this.f49214e.b(this.f49211b);
        d.b(new Runnable() {
            public void run() {
                if (b.this.f49212c != null) {
                    b.this.f49212c.a(b.this.f49213d);
                }
                if (b.this.f49213d != null) {
                    b.this.f49213d.onCreate(Boolean.valueOf(b.this.f49211b));
                }
            }
        });
    }

    private void n() {
        this.f49214e.c();
    }

    private void o() {
        this.f49214e.d();
        d.b(new Runnable() {
            public void run() {
                if (b.this.f49213d != null) {
                    b.this.f49213d.onStarted(Boolean.valueOf(b.this.f49211b), b.this.f49214e.e());
                }
            }
        });
    }

    public final int a(long j11) {
        c cVar = this.f49212c;
        if (cVar != null) {
            return cVar.a(j11);
        }
        return -1000;
    }

    public final int a(MediaCodec.BufferInfo bufferInfo, long j11) {
        c cVar = this.f49212c;
        if (cVar != null) {
            return cVar.a(bufferInfo, j11);
        }
        return -1000;
    }

    public final C0624b a() {
        return this.f49218i;
    }

    public final ByteBuffer a(int i11) {
        MediaCodec a11;
        c cVar = this.f49212c;
        if (cVar == null || (a11 = cVar.a()) == null) {
            return null;
        }
        return a11.getOutputBuffer(i11);
    }

    public final void a(int i11, int i12, int i13, long j11, int i14) {
        c cVar = this.f49212c;
        if (cVar != null) {
            cVar.a(i11, i12, i13, j11, i14);
        }
    }

    public final void a(int i11, int i12, MediaCodec.CryptoInfo cryptoInfo, long j11, int i13) {
        MediaCodec a11;
        c cVar = this.f49212c;
        if (cVar != null && (a11 = cVar.a()) != null) {
            a11.queueSecureInputBuffer(i11, i12, cryptoInfo, j11, i13);
        }
    }

    public final void a(int i11, boolean z11) {
        c cVar = this.f49212c;
        if (cVar != null) {
            cVar.a(i11, z11);
        }
    }

    public final void a(MediaFormat mediaFormat, Surface surface, MediaCrypto mediaCrypto, int i11) {
        if (this.f49216g) {
            com.tencent.thumbplayer.tcmedia.g.h.b.d("TMediaCodec", "configure ignored, mediaFormat:" + mediaFormat + " surface:" + surface + " crypto:" + mediaCrypto + " flags:" + i11 + " stack:" + Log.getStackTraceString(new Throwable()));
            return;
        }
        this.f49216g = true;
        b(surface);
        try {
            this.f49212c = a.a().a(mediaFormat, surface, mediaCrypto, i11, this);
        } catch (IOException e11) {
            com.tencent.thumbplayer.tcmedia.g.h.b.b("TMediaCodec", "createCodec mediaFormat:".concat(String.valueOf(mediaFormat)), e11);
        }
        m();
    }

    public final void a(Bundle bundle) {
        MediaCodec a11;
        c cVar = this.f49212c;
        if (cVar != null && (a11 = cVar.a()) != null) {
            a11.setParameters(bundle);
        }
    }

    public final void a(Surface surface) {
        c cVar = this.f49212c;
        if (cVar != null) {
            cVar.a(surface);
        }
    }

    public final void a(com.tencent.thumbplayer.tcmedia.g.a.a aVar) {
        this.f49213d = aVar;
    }

    public final void a(a aVar, Handler handler) {
        MediaCodec a11;
        if (Build.VERSION.SDK_INT < 23) {
            com.tencent.thumbplayer.tcmedia.g.h.b.d("TMediaCodec", "ignore method setCallback for API lower than 23");
            return;
        }
        c cVar = this.f49212c;
        if (cVar != null && (a11 = cVar.a()) != null) {
            a11.setCallback(new c(this, aVar), handler);
        }
    }

    public final void a(boolean z11) {
        this.f49215f = z11;
    }

    public final Image b(int i11) {
        c cVar = this.f49212c;
        if (cVar != null) {
            return cVar.a().getOutputImage(i11);
        }
        return null;
    }

    public final boolean b() {
        return com.tencent.thumbplayer.tcmedia.g.h.c.a(this.f49217h);
    }

    public final com.tencent.thumbplayer.tcmedia.g.a.a c() {
        return this.f49213d;
    }

    public final ByteBuffer c(int i11) {
        c cVar = this.f49212c;
        if (cVar != null) {
            return cVar.a().getInputBuffer(i11);
        }
        return null;
    }

    public final void d(int i11) {
        MediaCodec a11;
        c cVar = this.f49212c;
        if (cVar != null && (a11 = cVar.a()) != null) {
            a11.setVideoScalingMode(i11);
        }
    }

    public final boolean d() {
        return this.f49215f;
    }

    public final void e() {
        if (com.tencent.thumbplayer.tcmedia.g.h.b.a()) {
            com.tencent.thumbplayer.tcmedia.g.h.b.b("TMediaCodec", "start codecWrapper:" + this.f49212c);
        }
        n();
        c cVar = this.f49212c;
        if (cVar != null) {
            cVar.d();
        }
        o();
    }

    public final void f() {
        c cVar = this.f49212c;
        if (cVar != null) {
            cVar.f();
        }
    }

    public final void g() {
        c cVar = this.f49212c;
        if (cVar != null) {
            cVar.g();
        }
    }

    public final void h() {
        c cVar = this.f49212c;
        if (cVar != null) {
            cVar.e();
        }
    }

    public final MediaFormat i() {
        MediaCodec a11;
        c cVar = this.f49212c;
        if (cVar == null || (a11 = cVar.a()) == null) {
            return null;
        }
        return a11.getOutputFormat();
    }

    public final ByteBuffer[] j() {
        MediaCodec a11;
        c cVar = this.f49212c;
        if (cVar == null || (a11 = cVar.a()) == null) {
            return null;
        }
        return a11.getInputBuffers();
    }

    public final ByteBuffer[] k() {
        MediaCodec a11;
        c cVar = this.f49212c;
        if (cVar == null || (a11 = cVar.a()) == null) {
            return null;
        }
        return a11.getOutputBuffers();
    }

    public final String l() {
        return this.f49217h;
    }
}
