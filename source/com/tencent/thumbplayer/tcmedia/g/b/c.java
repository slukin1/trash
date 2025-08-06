package com.tencent.thumbplayer.tcmedia.g.b;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.view.Surface;
import com.tencent.thumbplayer.tcmedia.g.a.a;
import com.tencent.thumbplayer.tcmedia.g.f.a;

public interface c {
    int a(long j11);

    int a(MediaCodec.BufferInfo bufferInfo, long j11);

    MediaCodec a();

    void a(int i11, int i12, int i13, long j11, int i14);

    void a(int i11, boolean z11);

    void a(MediaFormat mediaFormat, Surface surface, MediaCrypto mediaCrypto, int i11);

    void a(Surface surface);

    void a(a aVar);

    a.b b(e eVar);

    void b();

    void c();

    void d();

    void e();

    void f();

    void g();
}
