package androidx.camera.video.internal.audio;

import android.content.Context;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioRecord;
import android.media.AudioRecordingConfiguration;
import android.media.AudioTimestamp;
import android.os.Build;
import androidx.camera.core.Logger;
import androidx.camera.video.internal.audio.AudioStream;
import androidx.camera.video.internal.compat.quirk.AudioTimestampFramePositionIncorrectQuirk;
import androidx.core.util.h;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import z.b;
import z.e;
import z.f;

public class q implements AudioStream {

    /* renamed from: a  reason: collision with root package name */
    public final AudioRecord f6054a;

    /* renamed from: b  reason: collision with root package name */
    public final a f6055b;

    /* renamed from: c  reason: collision with root package name */
    public final AtomicBoolean f6056c = new AtomicBoolean(false);

    /* renamed from: d  reason: collision with root package name */
    public final AtomicBoolean f6057d = new AtomicBoolean(false);

    /* renamed from: e  reason: collision with root package name */
    public final AtomicReference<Boolean> f6058e = new AtomicReference<>((Object) null);

    /* renamed from: f  reason: collision with root package name */
    public final int f6059f;

    /* renamed from: g  reason: collision with root package name */
    public final int f6060g;

    /* renamed from: h  reason: collision with root package name */
    public AudioStream.a f6061h;

    /* renamed from: i  reason: collision with root package name */
    public Executor f6062i;

    /* renamed from: j  reason: collision with root package name */
    public long f6063j;

    /* renamed from: k  reason: collision with root package name */
    public AudioManager.AudioRecordingCallback f6064k;

    public class a extends AudioManager.AudioRecordingCallback {
        public a() {
        }

        public void onRecordingConfigChanged(List<AudioRecordingConfiguration> list) {
            for (AudioRecordingConfiguration next : list) {
                if (b.a(next) == q.this.f6054a.getAudioSessionId()) {
                    q.this.k(e.b(next));
                    return;
                }
            }
        }
    }

    public q(a aVar, Context context) throws IllegalArgumentException, AudioStream.AudioStreamException {
        boolean z11 = false;
        if (i(aVar.f(), aVar.e(), aVar.b())) {
            this.f6055b = aVar;
            this.f6060g = aVar.d();
            int g11 = g(aVar.f(), aVar.e(), aVar.b());
            h.i(g11 > 0 ? true : z11);
            int i11 = g11 * 2;
            this.f6059f = i11;
            int i12 = Build.VERSION.SDK_INT;
            if (i12 >= 23) {
                AudioFormat build = new AudioFormat.Builder().setSampleRate(aVar.f()).setChannelMask(r.b(aVar.e())).setEncoding(aVar.b()).build();
                AudioRecord.Builder b11 = z.a.b();
                if (i12 >= 31 && context != null) {
                    f.c(b11, context);
                }
                z.a.d(b11, aVar.c());
                z.a.c(b11, build);
                z.a.e(b11, i11);
                this.f6054a = z.a.a(b11);
            } else {
                this.f6054a = new AudioRecord(aVar.c(), aVar.f(), r.a(aVar.e()), aVar.b(), i11);
            }
            if (this.f6054a.getState() != 1) {
                this.f6054a.release();
                throw new AudioStream.AudioStreamException("Unable to initialize AudioRecord");
            }
            return;
        }
        throw new UnsupportedOperationException(String.format("The combination of sample rate %d, channel count %d and audio format %d is not supported.", new Object[]{Integer.valueOf(aVar.f()), Integer.valueOf(aVar.e()), Integer.valueOf(aVar.b())}));
    }

    public static long e(int i11, long j11, AudioTimestamp audioTimestamp) {
        long c11 = audioTimestamp.nanoTime + r.c(j11 - audioTimestamp.framePosition, i11);
        if (c11 < 0) {
            return 0;
        }
        return c11;
    }

    public static int g(int i11, int i12, int i13) {
        return AudioRecord.getMinBufferSize(i11, r.a(i12), i13);
    }

    public static boolean h() {
        return a0.a.a(AudioTimestampFramePositionIncorrectQuirk.class) != null;
    }

    public static boolean i(int i11, int i12, int i13) {
        return i11 > 0 && i12 > 0 && g(i11, i12, i13) > 0;
    }

    public void a(AudioStream.a aVar, Executor executor) {
        boolean z11 = true;
        h.j(!this.f6057d.get(), "AudioStream can not be started when setCallback.");
        c();
        if (aVar != null && executor == null) {
            z11 = false;
        }
        h.b(z11, "executor can't be null with non-null callback.");
        this.f6061h = aVar;
        this.f6062i = executor;
        if (Build.VERSION.SDK_INT >= 29) {
            AudioManager.AudioRecordingCallback audioRecordingCallback = this.f6064k;
            if (audioRecordingCallback != null) {
                e.d(this.f6054a, audioRecordingCallback);
            }
            if (aVar != null) {
                if (this.f6064k == null) {
                    this.f6064k = new a();
                }
                e.c(this.f6054a, executor, this.f6064k);
            }
        }
    }

    public final void c() {
        h.j(!this.f6056c.get(), "AudioStream has been released.");
    }

    public final void d() {
        h.j(this.f6057d.get(), "AudioStream has not been started.");
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long f() {
        /*
            r6 = this;
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = -1
            r3 = 24
            if (r0 < r3) goto L_0x0030
            boolean r0 = h()
            if (r0 != 0) goto L_0x0030
            android.media.AudioTimestamp r0 = new android.media.AudioTimestamp
            r0.<init>()
            android.media.AudioRecord r3 = r6.f6054a
            r4 = 0
            int r3 = z.b.b(r3, r0, r4)
            if (r3 != 0) goto L_0x0029
            androidx.camera.video.internal.audio.a r3 = r6.f6055b
            int r3 = r3.f()
            long r4 = r6.f6063j
            long r3 = e(r3, r4, r0)
            goto L_0x0031
        L_0x0029:
            java.lang.String r0 = "AudioStreamImpl"
            java.lang.String r3 = "Unable to get audio timestamp"
            androidx.camera.core.Logger.w(r0, r3)
        L_0x0030:
            r3 = r1
        L_0x0031:
            int r0 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r0 != 0) goto L_0x0039
            long r3 = java.lang.System.nanoTime()
        L_0x0039:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.video.internal.audio.q.f():long");
    }

    public void k(boolean z11) {
        Executor executor = this.f6062i;
        AudioStream.a aVar = this.f6061h;
        if (executor != null && aVar != null && !Objects.equals(this.f6058e.getAndSet(Boolean.valueOf(z11)), Boolean.valueOf(z11))) {
            executor.execute(new p(aVar, z11));
        }
    }

    public AudioStream.PacketInfo read(ByteBuffer byteBuffer) {
        long j11;
        c();
        d();
        int read = this.f6054a.read(byteBuffer, this.f6059f);
        if (read > 0) {
            byteBuffer.limit(read);
            j11 = f();
            this.f6063j += r.f((long) read, this.f6060g);
        } else {
            j11 = 0;
        }
        return AudioStream.PacketInfo.c(read, j11);
    }

    public void release() {
        AudioManager.AudioRecordingCallback audioRecordingCallback;
        if (!this.f6056c.getAndSet(true)) {
            if (Build.VERSION.SDK_INT >= 29 && (audioRecordingCallback = this.f6064k) != null) {
                e.d(this.f6054a, audioRecordingCallback);
            }
            this.f6054a.release();
        }
    }

    public void start() throws AudioStream.AudioStreamException {
        c();
        boolean z11 = true;
        if (!this.f6057d.getAndSet(true)) {
            this.f6054a.startRecording();
            boolean z12 = false;
            if (this.f6054a.getRecordingState() == 3) {
                this.f6063j = 0;
                this.f6058e.set((Object) null);
                if (Build.VERSION.SDK_INT >= 29) {
                    AudioRecordingConfiguration a11 = e.a(this.f6054a);
                    if (a11 == null || !e.b(a11)) {
                        z11 = false;
                    }
                    z12 = z11;
                }
                k(z12);
                return;
            }
            this.f6057d.set(false);
            throw new AudioStream.AudioStreamException("Unable to start AudioRecord with state: " + this.f6054a.getRecordingState());
        }
    }

    public void stop() {
        c();
        if (this.f6057d.getAndSet(false)) {
            this.f6054a.stop();
            if (this.f6054a.getRecordingState() != 1) {
                Logger.w("AudioStreamImpl", "Failed to stop AudioRecord with state: " + this.f6054a.getRecordingState());
            }
        }
    }
}
