package androidx.camera.video.internal.encoder;

import android.media.MediaCodec;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.h;
import com.google.common.util.concurrent.ListenableFuture;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class j implements h {

    /* renamed from: b  reason: collision with root package name */
    public final MediaCodec f6224b;

    /* renamed from: c  reason: collision with root package name */
    public final MediaCodec.BufferInfo f6225c;

    /* renamed from: d  reason: collision with root package name */
    public final int f6226d;

    /* renamed from: e  reason: collision with root package name */
    public final ByteBuffer f6227e;

    /* renamed from: f  reason: collision with root package name */
    public final ListenableFuture<Void> f6228f;

    /* renamed from: g  reason: collision with root package name */
    public final CallbackToFutureAdapter.a<Void> f6229g;

    /* renamed from: h  reason: collision with root package name */
    public final AtomicBoolean f6230h = new AtomicBoolean(false);

    public j(MediaCodec mediaCodec, int i11, MediaCodec.BufferInfo bufferInfo) throws MediaCodec.CodecException {
        this.f6224b = (MediaCodec) h.g(mediaCodec);
        this.f6226d = i11;
        this.f6227e = mediaCodec.getOutputBuffer(i11);
        this.f6225c = (MediaCodec.BufferInfo) h.g(bufferInfo);
        AtomicReference atomicReference = new AtomicReference();
        this.f6228f = CallbackToFutureAdapter.a(new i(atomicReference));
        this.f6229g = (CallbackToFutureAdapter.a) h.g((CallbackToFutureAdapter.a) atomicReference.get());
    }

    public ListenableFuture<Void> b() {
        return Futures.nonCancellationPropagating(this.f6228f);
    }

    public void close() {
        if (!this.f6230h.getAndSet(true)) {
            try {
                this.f6224b.releaseOutputBuffer(this.f6226d, false);
                this.f6229g.c(null);
            } catch (IllegalStateException e11) {
                this.f6229g.f(e11);
            }
        }
    }

    public ByteBuffer d() {
        f();
        this.f6227e.position(this.f6225c.offset);
        ByteBuffer byteBuffer = this.f6227e;
        MediaCodec.BufferInfo bufferInfo = this.f6225c;
        byteBuffer.limit(bufferInfo.offset + bufferInfo.size);
        return this.f6227e;
    }

    public final void f() {
        if (this.f6230h.get()) {
            throw new IllegalStateException("encoded data is closed.");
        }
    }

    public MediaCodec.BufferInfo h() {
        return this.f6225c;
    }

    public boolean i() {
        return (this.f6225c.flags & 1) != 0;
    }

    public long q() {
        return this.f6225c.presentationTimeUs;
    }

    public long size() {
        return (long) this.f6225c.size;
    }
}
