package androidx.camera.video.internal.encoder;

import android.media.MediaCodec;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.h;
import com.google.common.util.concurrent.ListenableFuture;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class f1 implements d1 {

    /* renamed from: a  reason: collision with root package name */
    public final MediaCodec f6206a;

    /* renamed from: b  reason: collision with root package name */
    public final int f6207b;

    /* renamed from: c  reason: collision with root package name */
    public final ByteBuffer f6208c;

    /* renamed from: d  reason: collision with root package name */
    public final ListenableFuture<Void> f6209d;

    /* renamed from: e  reason: collision with root package name */
    public final CallbackToFutureAdapter.a<Void> f6210e;

    /* renamed from: f  reason: collision with root package name */
    public final AtomicBoolean f6211f = new AtomicBoolean(false);

    /* renamed from: g  reason: collision with root package name */
    public long f6212g = 0;

    /* renamed from: h  reason: collision with root package name */
    public boolean f6213h = false;

    public f1(MediaCodec mediaCodec, int i11) throws MediaCodec.CodecException {
        this.f6206a = (MediaCodec) h.g(mediaCodec);
        this.f6207b = h.d(i11);
        this.f6208c = mediaCodec.getInputBuffer(i11);
        AtomicReference atomicReference = new AtomicReference();
        this.f6209d = CallbackToFutureAdapter.a(new e1(atomicReference));
        this.f6210e = (CallbackToFutureAdapter.a) h.g((CallbackToFutureAdapter.a) atomicReference.get());
    }

    public void a(boolean z11) {
        h();
        this.f6213h = z11;
    }

    public boolean b() {
        if (this.f6211f.getAndSet(true)) {
            return false;
        }
        try {
            this.f6206a.queueInputBuffer(this.f6207b, this.f6208c.position(), this.f6208c.limit(), this.f6212g, this.f6213h ? 4 : 0);
            this.f6210e.c(null);
            return true;
        } catch (IllegalStateException e11) {
            this.f6210e.f(e11);
            return false;
        }
    }

    public ListenableFuture<Void> c() {
        return Futures.nonCancellationPropagating(this.f6209d);
    }

    public boolean cancel() {
        if (this.f6211f.getAndSet(true)) {
            return false;
        }
        try {
            this.f6206a.queueInputBuffer(this.f6207b, 0, 0, 0, 0);
            this.f6210e.c(null);
        } catch (IllegalStateException e11) {
            this.f6210e.f(e11);
        }
        return true;
    }

    public ByteBuffer d() {
        h();
        return this.f6208c;
    }

    public void e(long j11) {
        h();
        h.a(j11 >= 0);
        this.f6212g = j11;
    }

    public final void h() {
        if (this.f6211f.get()) {
            throw new IllegalStateException("The buffer is submitted or canceled.");
        }
    }
}
