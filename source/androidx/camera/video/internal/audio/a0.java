package androidx.camera.video.internal.audio;

import android.annotation.SuppressLint;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.video.internal.audio.AudioStream;
import androidx.core.util.h;
import java.nio.ByteBuffer;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicBoolean;

public class a0 implements AudioStream {

    /* renamed from: a  reason: collision with root package name */
    public final AtomicBoolean f6005a = new AtomicBoolean(false);

    /* renamed from: b  reason: collision with root package name */
    public final AtomicBoolean f6006b = new AtomicBoolean(false);

    /* renamed from: c  reason: collision with root package name */
    public final Queue<a> f6007c = new ConcurrentLinkedQueue();

    /* renamed from: d  reason: collision with root package name */
    public final Executor f6008d = CameraXExecutors.newSequentialExecutor(CameraXExecutors.audioExecutor());

    /* renamed from: e  reason: collision with root package name */
    public final Object f6009e = new Object();

    /* renamed from: f  reason: collision with root package name */
    public a f6010f = null;

    /* renamed from: g  reason: collision with root package name */
    public final AudioStream f6011g;

    /* renamed from: h  reason: collision with root package name */
    public final int f6012h;

    /* renamed from: i  reason: collision with root package name */
    public final int f6013i;

    /* renamed from: j  reason: collision with root package name */
    public final int f6014j;

    /* renamed from: k  reason: collision with root package name */
    public final AtomicBoolean f6015k = new AtomicBoolean(false);

    /* renamed from: l  reason: collision with root package name */
    public int f6016l;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final int f6017a;

        /* renamed from: b  reason: collision with root package name */
        public final int f6018b;

        /* renamed from: c  reason: collision with root package name */
        public final ByteBuffer f6019c;

        /* renamed from: d  reason: collision with root package name */
        public long f6020d;

        public a(ByteBuffer byteBuffer, AudioStream.PacketInfo packetInfo, int i11, int i12) {
            byteBuffer.rewind();
            int limit = byteBuffer.limit() - byteBuffer.position();
            if (limit == packetInfo.a()) {
                this.f6017a = i11;
                this.f6018b = i12;
                this.f6019c = byteBuffer;
                this.f6020d = packetInfo.b();
                return;
            }
            throw new IllegalStateException("Byte buffer size is not match with packet info: " + limit + " != " + packetInfo.a());
        }

        public int a() {
            return this.f6019c.remaining();
        }

        public AudioStream.PacketInfo b(ByteBuffer byteBuffer) {
            int i11;
            long j11 = this.f6020d;
            int position = this.f6019c.position();
            int position2 = byteBuffer.position();
            if (this.f6019c.remaining() > byteBuffer.remaining()) {
                i11 = byteBuffer.remaining();
                this.f6020d += r.c(r.f((long) i11, this.f6017a), this.f6018b);
                ByteBuffer duplicate = this.f6019c.duplicate();
                duplicate.position(position).limit(position + i11);
                byteBuffer.put(duplicate).limit(position2 + i11).position(position2);
            } else {
                i11 = this.f6019c.remaining();
                byteBuffer.put(this.f6019c).limit(position2 + i11).position(position2);
            }
            this.f6019c.position(position + i11);
            return AudioStream.PacketInfo.c(i11, j11);
        }
    }

    public a0(AudioStream audioStream, a aVar) {
        boolean z11 = false;
        this.f6011g = audioStream;
        int d11 = aVar.d();
        this.f6012h = d11;
        int f11 = aVar.f();
        this.f6013i = f11;
        h.b(((long) d11) > 0, "mBytesPerFrame must be greater than 0.");
        h.b(((long) f11) > 0 ? true : z11, "mSampleRate must be greater than 0.");
        this.f6014j = 500;
        this.f6016l = d11 * 1024;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void k() {
        this.f6015k.set(false);
        this.f6011g.release();
        synchronized (this.f6009e) {
            this.f6010f = null;
            this.f6007c.clear();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void l(AudioStream.a aVar, Executor executor) {
        this.f6011g.a(aVar, executor);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void m() {
        try {
            this.f6011g.start();
            p();
        } catch (AudioStream.AudioStreamException e11) {
            throw new RuntimeException(e11);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void n() {
        this.f6015k.set(false);
        this.f6011g.stop();
        synchronized (this.f6009e) {
            this.f6010f = null;
            this.f6007c.clear();
        }
    }

    public void a(AudioStream.a aVar, Executor executor) {
        boolean z11 = true;
        h.j(!this.f6005a.get(), "AudioStream can not be started when setCallback.");
        h();
        if (aVar != null && executor == null) {
            z11 = false;
        }
        h.b(z11, "executor can't be null with non-null callback.");
        this.f6008d.execute(new z(this, aVar, executor));
    }

    public final void h() {
        h.j(!this.f6006b.get(), "AudioStream has been released.");
    }

    public final void i() {
        h.j(this.f6005a.get(), "AudioStream has not been started.");
    }

    public final void j() {
        if (this.f6015k.get()) {
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(this.f6016l);
            a aVar = new a(allocateDirect, this.f6011g.read(allocateDirect), this.f6012h, this.f6013i);
            int i11 = this.f6014j;
            synchronized (this.f6009e) {
                this.f6007c.offer(aVar);
                while (this.f6007c.size() > i11) {
                    this.f6007c.poll();
                    Logger.w("BufferedAudioStream", "Drop audio data due to full of queue.");
                }
            }
            if (this.f6015k.get()) {
                this.f6008d.execute(new w(this));
            }
        }
    }

    public final void p() {
        if (!this.f6015k.getAndSet(true)) {
            j();
        }
    }

    /* renamed from: q */
    public final void o(int i11) {
        int i12 = this.f6016l;
        if (i12 != i11) {
            int i13 = this.f6012h;
            this.f6016l = (i11 / i13) * i13;
            Logger.d("BufferedAudioStream", "Update buffer size from " + i12 + " to " + this.f6016l);
        }
    }

    public final void r(int i11) {
        this.f6008d.execute(new y(this, i11));
    }

    @SuppressLint({"BanThreadSleep"})
    public AudioStream.PacketInfo read(ByteBuffer byteBuffer) {
        boolean z11;
        h();
        i();
        r(byteBuffer.remaining());
        AudioStream.PacketInfo c11 = AudioStream.PacketInfo.c(0, 0);
        do {
            synchronized (this.f6009e) {
                a aVar = this.f6010f;
                this.f6010f = null;
                if (aVar == null) {
                    aVar = this.f6007c.poll();
                }
                if (aVar != null) {
                    c11 = aVar.b(byteBuffer);
                    if (aVar.a() > 0) {
                        this.f6010f = aVar;
                    }
                }
            }
            z11 = c11.a() <= 0 && this.f6005a.get() && !this.f6006b.get();
            if (z11) {
                try {
                    Thread.sleep(1);
                    continue;
                } catch (InterruptedException e11) {
                    Logger.w("BufferedAudioStream", "Interruption while waiting for audio data", e11);
                }
            }
        } while (z11);
        return c11;
    }

    public void release() {
        if (!this.f6006b.getAndSet(true)) {
            this.f6008d.execute(new x(this));
        }
    }

    public void start() throws AudioStream.AudioStreamException, IllegalStateException {
        h();
        if (!this.f6005a.getAndSet(true)) {
            FutureTask futureTask = new FutureTask(new u(this), (Object) null);
            this.f6008d.execute(futureTask);
            try {
                futureTask.get();
            } catch (InterruptedException | ExecutionException e11) {
                this.f6005a.set(false);
                throw new AudioStream.AudioStreamException(e11);
            }
        }
    }

    public void stop() throws IllegalStateException {
        h();
        if (this.f6005a.getAndSet(false)) {
            this.f6008d.execute(new v(this));
        }
    }
}
