package androidx.camera.video.internal.encoder;

import android.media.MediaCodec;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.h;
import com.google.common.util.concurrent.ListenableFuture;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicReference;

public class g implements h {

    /* renamed from: b  reason: collision with root package name */
    public final ByteBuffer f6214b;

    /* renamed from: c  reason: collision with root package name */
    public final MediaCodec.BufferInfo f6215c;

    /* renamed from: d  reason: collision with root package name */
    public final ListenableFuture<Void> f6216d;

    /* renamed from: e  reason: collision with root package name */
    public final CallbackToFutureAdapter.a<Void> f6217e;

    public g(h hVar) {
        this.f6215c = e(hVar);
        this.f6214b = b(hVar);
        AtomicReference atomicReference = new AtomicReference();
        this.f6216d = CallbackToFutureAdapter.a(new f(atomicReference));
        this.f6217e = (CallbackToFutureAdapter.a) h.g((CallbackToFutureAdapter.a) atomicReference.get());
    }

    public final ByteBuffer b(h hVar) {
        ByteBuffer d11 = hVar.d();
        MediaCodec.BufferInfo h11 = hVar.h();
        d11.position(h11.offset);
        d11.limit(h11.offset + h11.size);
        ByteBuffer allocate = ByteBuffer.allocate(h11.size);
        allocate.order(d11.order());
        allocate.put(d11);
        allocate.flip();
        return allocate;
    }

    public void close() {
        this.f6217e.c(null);
    }

    public ByteBuffer d() {
        return this.f6214b;
    }

    public final MediaCodec.BufferInfo e(h hVar) {
        MediaCodec.BufferInfo h11 = hVar.h();
        MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
        bufferInfo.set(0, h11.size, h11.presentationTimeUs, h11.flags);
        return bufferInfo;
    }

    public MediaCodec.BufferInfo h() {
        return this.f6215c;
    }

    public boolean i() {
        return (this.f6215c.flags & 1) != 0;
    }

    public long q() {
        return this.f6215c.presentationTimeUs;
    }

    public long size() {
        return (long) this.f6215c.size;
    }
}
