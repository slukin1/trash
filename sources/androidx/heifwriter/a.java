package androidx.heifwriter;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;
import android.util.Pair;
import androidx.heifwriter.HeifEncoder;
import java.io.FileDescriptor;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public final class a implements AutoCloseable {

    /* renamed from: b  reason: collision with root package name */
    public final int f9842b;

    /* renamed from: c  reason: collision with root package name */
    public final HandlerThread f9843c;

    /* renamed from: d  reason: collision with root package name */
    public final Handler f9844d;

    /* renamed from: e  reason: collision with root package name */
    public int f9845e;

    /* renamed from: f  reason: collision with root package name */
    public final int f9846f;

    /* renamed from: g  reason: collision with root package name */
    public final int f9847g;

    /* renamed from: h  reason: collision with root package name */
    public final int f9848h;

    /* renamed from: i  reason: collision with root package name */
    public final d f9849i = new d();

    /* renamed from: j  reason: collision with root package name */
    public MediaMuxer f9850j;

    /* renamed from: k  reason: collision with root package name */
    public HeifEncoder f9851k;

    /* renamed from: l  reason: collision with root package name */
    public final AtomicBoolean f9852l = new AtomicBoolean(false);

    /* renamed from: m  reason: collision with root package name */
    public int[] f9853m;

    /* renamed from: n  reason: collision with root package name */
    public int f9854n;

    /* renamed from: o  reason: collision with root package name */
    public boolean f9855o;

    /* renamed from: p  reason: collision with root package name */
    public final List<Pair<Integer, ByteBuffer>> f9856p = new ArrayList();

    /* renamed from: androidx.heifwriter.a$a  reason: collision with other inner class name */
    public class C0041a implements Runnable {
        public C0041a() {
        }

        public void run() {
            try {
                a.this.g();
            } catch (Exception unused) {
            }
        }
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final String f9858a;

        /* renamed from: b  reason: collision with root package name */
        public final FileDescriptor f9859b;

        /* renamed from: c  reason: collision with root package name */
        public final int f9860c;

        /* renamed from: d  reason: collision with root package name */
        public final int f9861d;

        /* renamed from: e  reason: collision with root package name */
        public final int f9862e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f9863f;

        /* renamed from: g  reason: collision with root package name */
        public int f9864g;

        /* renamed from: h  reason: collision with root package name */
        public int f9865h;

        /* renamed from: i  reason: collision with root package name */
        public int f9866i;

        /* renamed from: j  reason: collision with root package name */
        public int f9867j;

        /* renamed from: k  reason: collision with root package name */
        public Handler f9868k;

        public b(String str, int i11, int i12, int i13) {
            this(str, (FileDescriptor) null, i11, i12, i13);
        }

        public a a() throws IOException {
            return new a(this.f9858a, this.f9859b, this.f9860c, this.f9861d, this.f9867j, this.f9863f, this.f9864g, this.f9865h, this.f9866i, this.f9862e, this.f9868k);
        }

        public b b(int i11) {
            if (i11 > 0) {
                this.f9865h = i11;
                return this;
            }
            throw new IllegalArgumentException("Invalid maxImage: " + i11);
        }

        public b c(int i11) {
            if (i11 < 0 || i11 > 100) {
                throw new IllegalArgumentException("Invalid quality: " + i11);
            }
            this.f9864g = i11;
            return this;
        }

        public b(String str, FileDescriptor fileDescriptor, int i11, int i12, int i13) {
            this.f9863f = true;
            this.f9864g = 100;
            this.f9865h = 1;
            this.f9866i = 0;
            this.f9867j = 0;
            if (i11 <= 0 || i12 <= 0) {
                throw new IllegalArgumentException("Invalid image size: " + i11 + "x" + i12);
            }
            this.f9858a = str;
            this.f9859b = fileDescriptor;
            this.f9860c = i11;
            this.f9861d = i12;
            this.f9862e = i13;
        }
    }

    public class c extends HeifEncoder.Callback {

        /* renamed from: a  reason: collision with root package name */
        public boolean f9869a;

        public c() {
        }

        public void a(HeifEncoder heifEncoder) {
            e((Exception) null);
        }

        public void b(HeifEncoder heifEncoder, ByteBuffer byteBuffer) {
            if (!this.f9869a) {
                a aVar = a.this;
                if (aVar.f9853m == null) {
                    e(new IllegalStateException("Output buffer received before format info"));
                    return;
                }
                if (aVar.f9854n < aVar.f9847g * aVar.f9845e) {
                    MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
                    bufferInfo.set(byteBuffer.position(), byteBuffer.remaining(), 0, 0);
                    a aVar2 = a.this;
                    aVar2.f9850j.writeSampleData(aVar2.f9853m[aVar2.f9854n / aVar2.f9845e], byteBuffer, bufferInfo);
                }
                a aVar3 = a.this;
                int i11 = aVar3.f9854n + 1;
                aVar3.f9854n = i11;
                if (i11 == aVar3.f9847g * aVar3.f9845e) {
                    e((Exception) null);
                }
            }
        }

        public void c(HeifEncoder heifEncoder, MediaCodec.CodecException codecException) {
            e(codecException);
        }

        public void d(HeifEncoder heifEncoder, MediaFormat mediaFormat) {
            if (!this.f9869a) {
                if (a.this.f9853m != null) {
                    e(new IllegalStateException("Output format changed after muxer started"));
                    return;
                }
                try {
                    a.this.f9845e = mediaFormat.getInteger("grid-rows") * mediaFormat.getInteger("grid-cols");
                } catch (ClassCastException | NullPointerException unused) {
                    a.this.f9845e = 1;
                }
                a aVar = a.this;
                aVar.f9853m = new int[aVar.f9847g];
                if (aVar.f9846f > 0) {
                    Log.d("HeifWriter", "setting rotation: " + a.this.f9846f);
                    a aVar2 = a.this;
                    aVar2.f9850j.setOrientationHint(aVar2.f9846f);
                }
                int i11 = 0;
                while (true) {
                    a aVar3 = a.this;
                    if (i11 < aVar3.f9853m.length) {
                        mediaFormat.setInteger("is-default", i11 == aVar3.f9848h ? 1 : 0);
                        a aVar4 = a.this;
                        aVar4.f9853m[i11] = aVar4.f9850j.addTrack(mediaFormat);
                        i11++;
                    } else {
                        aVar3.f9850j.start();
                        a.this.f9852l.set(true);
                        a.this.j();
                        return;
                    }
                }
            }
        }

        public final void e(Exception exc) {
            if (!this.f9869a) {
                this.f9869a = true;
                a.this.f9849i.a(exc);
            }
        }
    }

    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public boolean f9871a;

        /* renamed from: b  reason: collision with root package name */
        public Exception f9872b;

        public synchronized void a(Exception exc) {
            if (!this.f9871a) {
                this.f9871a = true;
                this.f9872b = exc;
                notifyAll();
            }
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(5:15|16|17|18|11) */
        /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0020 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:4:0x0009 */
        /* JADX WARNING: Removed duplicated region for block: B:4:0x0009 A[LOOP:0: B:4:0x0009->B:33:0x0009, LOOP_START, SYNTHETIC] */
        /* JADX WARNING: Unknown top exception splitter block from list: {B:17:0x0020=Splitter:B:17:0x0020, B:4:0x0009=Splitter:B:4:0x0009} */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public synchronized void b(long r7) throws java.lang.Exception {
            /*
                r6 = this;
                monitor-enter(r6)
                r0 = 0
                int r2 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
                if (r2 < 0) goto L_0x003e
                if (r2 != 0) goto L_0x0011
            L_0x0009:
                boolean r7 = r6.f9871a     // Catch:{ all -> 0x0046 }
                if (r7 != 0) goto L_0x0027
                r6.wait()     // Catch:{ InterruptedException -> 0x0009 }
                goto L_0x0009
            L_0x0011:
                long r2 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0046 }
            L_0x0015:
                boolean r4 = r6.f9871a     // Catch:{ all -> 0x0046 }
                if (r4 != 0) goto L_0x0027
                int r4 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
                if (r4 <= 0) goto L_0x0027
                r6.wait(r7)     // Catch:{ InterruptedException -> 0x0020 }
            L_0x0020:
                long r4 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0046 }
                long r4 = r4 - r2
                long r7 = r7 - r4
                goto L_0x0015
            L_0x0027:
                boolean r7 = r6.f9871a     // Catch:{ all -> 0x0046 }
                if (r7 != 0) goto L_0x0037
                r7 = 1
                r6.f9871a = r7     // Catch:{ all -> 0x0046 }
                java.util.concurrent.TimeoutException r7 = new java.util.concurrent.TimeoutException     // Catch:{ all -> 0x0046 }
                java.lang.String r8 = "timed out waiting for result"
                r7.<init>(r8)     // Catch:{ all -> 0x0046 }
                r6.f9872b = r7     // Catch:{ all -> 0x0046 }
            L_0x0037:
                java.lang.Exception r7 = r6.f9872b     // Catch:{ all -> 0x0046 }
                if (r7 != 0) goto L_0x003d
                monitor-exit(r6)
                return
            L_0x003d:
                throw r7     // Catch:{ all -> 0x0046 }
            L_0x003e:
                java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x0046 }
                java.lang.String r8 = "timeoutMs is negative"
                r7.<init>(r8)     // Catch:{ all -> 0x0046 }
                throw r7     // Catch:{ all -> 0x0046 }
            L_0x0046:
                r7 = move-exception
                monitor-exit(r6)
                throw r7
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.heifwriter.a.d.b(long):void");
        }
    }

    @SuppressLint({"WrongConstant"})
    public a(String str, FileDescriptor fileDescriptor, int i11, int i12, int i13, boolean z11, int i14, int i15, int i16, int i17, Handler handler) throws IOException {
        MediaMuxer mediaMuxer;
        String str2 = str;
        int i18 = i15;
        int i19 = i16;
        if (i19 < i18) {
            MediaFormat.createVideoFormat("image/vnd.android.heic", i11, i12);
            this.f9845e = 1;
            this.f9846f = i13;
            this.f9842b = i17;
            this.f9847g = i18;
            this.f9848h = i19;
            Looper looper = handler != null ? handler.getLooper() : null;
            if (looper == null) {
                HandlerThread handlerThread = new HandlerThread("HeifEncoderThread", -2);
                this.f9843c = handlerThread;
                handlerThread.start();
                looper = handlerThread.getLooper();
            } else {
                this.f9843c = null;
            }
            Handler handler2 = new Handler(looper);
            this.f9844d = handler2;
            if (str2 == null) {
                FileDescriptor fileDescriptor2 = fileDescriptor;
                mediaMuxer = new MediaMuxer(fileDescriptor, 3);
            }
            this.f9850j = mediaMuxer;
            this.f9851k = new HeifEncoder(i11, i12, z11, i14, i17, handler2, new c());
            return;
        }
        throw new IllegalArgumentException("Invalid maxImages (" + i18 + ") or primaryIndex (" + i19 + ")");
    }

    public void a(Bitmap bitmap) {
        f(2);
        synchronized (this) {
            HeifEncoder heifEncoder = this.f9851k;
            if (heifEncoder != null) {
                heifEncoder.b(bitmap);
            }
        }
    }

    public final void b(int i11) {
        if (this.f9842b != i11) {
            throw new IllegalStateException("Not valid in input mode " + this.f9842b);
        }
    }

    public void close() {
        this.f9844d.postAtFrontOfQueue(new C0041a());
    }

    public final void e(boolean z11) {
        if (this.f9855o != z11) {
            throw new IllegalStateException("Already started");
        }
    }

    public final void f(int i11) {
        e(true);
        b(i11);
    }

    public void g() {
        MediaMuxer mediaMuxer = this.f9850j;
        if (mediaMuxer != null) {
            mediaMuxer.stop();
            this.f9850j.release();
            this.f9850j = null;
        }
        HeifEncoder heifEncoder = this.f9851k;
        if (heifEncoder != null) {
            heifEncoder.close();
            synchronized (this) {
                this.f9851k = null;
            }
        }
    }

    @SuppressLint({"WrongConstant"})
    public void j() {
        Pair remove;
        if (this.f9852l.get()) {
            while (true) {
                synchronized (this.f9856p) {
                    if (!this.f9856p.isEmpty()) {
                        remove = this.f9856p.remove(0);
                    } else {
                        return;
                    }
                }
                MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
                bufferInfo.set(((ByteBuffer) remove.second).position(), ((ByteBuffer) remove.second).remaining(), 0, 16);
                this.f9850j.writeSampleData(this.f9853m[((Integer) remove.first).intValue()], (ByteBuffer) remove.second, bufferInfo);
            }
            while (true) {
            }
        }
    }

    public void k() {
        e(false);
        this.f9855o = true;
        this.f9851k.n();
    }

    public void l(long j11) throws Exception {
        e(true);
        synchronized (this) {
            HeifEncoder heifEncoder = this.f9851k;
            if (heifEncoder != null) {
                heifEncoder.o();
            }
        }
        this.f9849i.b(j11);
        j();
        g();
    }
}
