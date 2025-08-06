package androidx.camera.video.internal.audio;

import androidx.camera.core.Logger;
import androidx.camera.video.internal.audio.AudioStream;
import androidx.core.util.h;
import java.nio.ByteBuffer;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class c0 implements AudioStream {

    /* renamed from: a  reason: collision with root package name */
    public final AtomicBoolean f6025a = new AtomicBoolean(false);

    /* renamed from: b  reason: collision with root package name */
    public final AtomicBoolean f6026b = new AtomicBoolean(false);

    /* renamed from: c  reason: collision with root package name */
    public final int f6027c;

    /* renamed from: d  reason: collision with root package name */
    public final int f6028d;

    /* renamed from: e  reason: collision with root package name */
    public byte[] f6029e;

    /* renamed from: f  reason: collision with root package name */
    public long f6030f;

    /* renamed from: g  reason: collision with root package name */
    public AudioStream.a f6031g;

    /* renamed from: h  reason: collision with root package name */
    public Executor f6032h;

    public c0(a aVar) {
        this.f6027c = aVar.d();
        this.f6028d = aVar.f();
    }

    public static void c(long j11) {
        long f11 = j11 - f();
        if (f11 > 0) {
            try {
                Thread.sleep(TimeUnit.NANOSECONDS.toMillis(f11));
            } catch (InterruptedException e11) {
                Logger.w("SilentAudioStream", "Ignore interruption", e11);
            }
        }
    }

    public static long f() {
        return System.nanoTime();
    }

    public void a(AudioStream.a aVar, Executor executor) {
        boolean z11 = true;
        h.j(!this.f6025a.get(), "AudioStream can not be started when setCallback.");
        d();
        if (aVar != null && executor == null) {
            z11 = false;
        }
        h.b(z11, "executor can't be null with non-null callback.");
        this.f6031g = aVar;
        this.f6032h = executor;
    }

    public final void d() {
        h.j(!this.f6026b.get(), "AudioStream has been released.");
    }

    public final void e() {
        h.j(this.f6025a.get(), "AudioStream has not been started.");
    }

    public final void h() {
        AudioStream.a aVar = this.f6031g;
        Executor executor = this.f6032h;
        if (aVar != null && executor != null) {
            executor.execute(new b0(aVar));
        }
    }

    public final void i(ByteBuffer byteBuffer, int i11) {
        h.i(i11 <= byteBuffer.remaining());
        byte[] bArr = this.f6029e;
        if (bArr == null || bArr.length < i11) {
            this.f6029e = new byte[i11];
        }
        int position = byteBuffer.position();
        byteBuffer.put(this.f6029e, 0, i11).limit(i11 + position).position(position);
    }

    public AudioStream.PacketInfo read(ByteBuffer byteBuffer) {
        d();
        e();
        long f11 = r.f((long) byteBuffer.remaining(), this.f6027c);
        int d11 = (int) r.d(f11, this.f6027c);
        if (d11 <= 0) {
            return AudioStream.PacketInfo.c(0, this.f6030f);
        }
        long c11 = this.f6030f + r.c(f11, this.f6028d);
        c(c11);
        i(byteBuffer, d11);
        AudioStream.PacketInfo c12 = AudioStream.PacketInfo.c(d11, this.f6030f);
        this.f6030f = c11;
        return c12;
    }

    public void release() {
        this.f6026b.getAndSet(true);
    }

    public void start() {
        d();
        if (!this.f6025a.getAndSet(true)) {
            this.f6030f = f();
            h();
        }
    }

    public void stop() {
        d();
        this.f6025a.set(false);
    }
}
