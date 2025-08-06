package com.tencent.thumbplayer.tcmedia.g.b;

import android.graphics.SurfaceTexture;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Build;
import android.util.Log;
import android.view.Surface;
import com.google.android.exoplayer2.audio.MpegAudioUtil;
import com.jumio.core.cdn.CDNDownload;
import com.tencent.imsdk.BaseConstants;
import com.tencent.thumbplayer.tcmedia.g.f.a;
import com.tencent.thumbplayer.tcmedia.g.h.c;
import com.tencent.thumbplayer.tcmedia.g.h.d;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class f implements c {

    /* renamed from: i  reason: collision with root package name */
    private static final Map<Surface, f> f49243i = new ConcurrentHashMap();
    private int A;
    private com.tencent.thumbplayer.tcmedia.g.e.a.a B;

    /* renamed from: a  reason: collision with root package name */
    public b f49244a = b.Started;

    /* renamed from: b  reason: collision with root package name */
    public boolean f49245b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f49246c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f49247d;

    /* renamed from: e  reason: collision with root package name */
    public final e f49248e;

    /* renamed from: f  reason: collision with root package name */
    public Surface f49249f;

    /* renamed from: g  reason: collision with root package name */
    public final b f49250g;

    /* renamed from: h  reason: collision with root package name */
    public final String f49251h;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public final String f49252j;

    /* renamed from: k  reason: collision with root package name */
    private final a.C0625a f49253k;

    /* renamed from: l  reason: collision with root package name */
    private final HashSet<Integer> f49254l;

    /* renamed from: m  reason: collision with root package name */
    private final ArrayList<Long> f49255m;

    /* renamed from: n  reason: collision with root package name */
    private final Set<SurfaceTexture> f49256n;

    /* renamed from: o  reason: collision with root package name */
    private final int[] f49257o;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public final MediaCodec f49258p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f49259q;

    /* renamed from: r  reason: collision with root package name */
    private a f49260r;

    /* renamed from: s  reason: collision with root package name */
    private MediaCodecInfo.CodecCapabilities f49261s;

    /* renamed from: t  reason: collision with root package name */
    private long f49262t;
    /* access modifiers changed from: private */

    /* renamed from: u  reason: collision with root package name */
    public com.tencent.thumbplayer.tcmedia.g.a.a f49263u;

    /* renamed from: v  reason: collision with root package name */
    private boolean f49264v;

    /* renamed from: w  reason: collision with root package name */
    private a.b f49265w;

    /* renamed from: x  reason: collision with root package name */
    private boolean f49266x;

    /* renamed from: y  reason: collision with root package name */
    private boolean f49267y;

    /* renamed from: z  reason: collision with root package name */
    private boolean f49268z;

    /* renamed from: com.tencent.thumbplayer.tcmedia.g.b.f$2  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f49270a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.tencent.thumbplayer.tcmedia.g.f.a$b[] r0 = com.tencent.thumbplayer.tcmedia.g.f.a.b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f49270a = r0
                com.tencent.thumbplayer.tcmedia.g.f.a$b r1 = com.tencent.thumbplayer.tcmedia.g.f.a.b.KEEP_CODEC_RESULT_NO     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f49270a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.tencent.thumbplayer.tcmedia.g.f.a$b r1 = com.tencent.thumbplayer.tcmedia.g.f.a.b.KEEP_CODEC_RESULT_YES_WITH_RECONFIGURATION     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f49270a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.tencent.thumbplayer.tcmedia.g.f.a$b r1 = com.tencent.thumbplayer.tcmedia.g.f.a.b.KEEP_CODEC_RESULT_YES_WITHOUT_RECONFIGURATION     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f49270a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.tencent.thumbplayer.tcmedia.g.f.a$b r1 = com.tencent.thumbplayer.tcmedia.g.f.a.b.KEEP_CODEC_RESULT_YES_WITH_FLUSH     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.thumbplayer.tcmedia.g.b.f.AnonymousClass2.<clinit>():void");
        }
    }

    public enum a {
        Uninitialized,
        Configured,
        Error,
        Flushed,
        Running,
        EndOfStream,
        Released
    }

    public enum b {
        Started,
        DequeueIn,
        QueueIn,
        DequeueOut,
        ReleaseOut
    }

    public f(MediaCodec mediaCodec, e eVar) {
        String str = "ReuseCodecWrapper[" + hashCode() + "]";
        this.f49252j = str;
        this.f49254l = new HashSet<>();
        this.f49255m = new ArrayList<>();
        this.f49256n = new LinkedHashSet();
        this.f49257o = new int[2];
        this.f49260r = a.Uninitialized;
        this.f49265w = a.b.KEEP_CODEC_RESULT_NO;
        boolean z11 = false;
        this.f49267y = false;
        this.f49268z = false;
        this.A = 0;
        this.f49258p = mediaCodec;
        this.f49248e = eVar;
        this.f49250g = new b(eVar.f49237g, eVar.f49238h, eVar.f49239i);
        String a11 = c.a(mediaCodec);
        this.f49251h = a11;
        this.f49253k = com.tencent.thumbplayer.tcmedia.g.f.a.a(a11);
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 18) {
            boolean z12 = i11 != 29 || eVar.f49234d == 0;
            com.tencent.thumbplayer.tcmedia.g.h.b.b(str, "canCallGetCodecInfo:".concat(String.valueOf(z12)));
            if (z12) {
                this.f49261s = mediaCodec.getCodecInfo().getCapabilitiesForType(eVar.f49240j);
            }
        }
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f49261s;
        this.f49246c = codecCapabilities != null && c.a(codecCapabilities);
        MediaCodecInfo.CodecCapabilities codecCapabilities2 = this.f49261s;
        if (codecCapabilities2 != null && c.b(codecCapabilities2)) {
            z11 = true;
        }
        this.f49247d = z11;
    }

    public static c a(MediaCodec mediaCodec, String str, e eVar) {
        return c.a(str) ? new g(mediaCodec, eVar) : new a(mediaCodec, eVar);
    }

    private void a(int i11) {
        if (i11 < 40000) {
            String str = this.f49252j;
            com.tencent.thumbplayer.tcmedia.g.h.b.e(str, this + "    releaseCodecWhenError, errorCode:" + i11);
            g();
        }
    }

    private void a(int i11, int i12) {
        if (!this.f49268z && b(i11, i12)) {
            this.f49268z = true;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this);
            sb2.append(", trackDecodeApi state:");
            sb2.append(this.f49260r);
            sb2.append("  surfaceState:");
            Surface surface = this.f49249f;
            sb2.append(surface != null ? Boolean.valueOf(surface.isValid()) : null);
            String sb3 = sb2.toString();
            if (i11 == 0) {
                a((int) BaseConstants.ERR_SVR_PROFILE_ACCOUNT_MISS, sb3, (Throwable) null);
            } else if (i11 == 1) {
                a((int) BaseConstants.ERR_SVR_COMM_INVALID_HTTP_URL, sb3, (Throwable) null);
            }
        }
    }

    private void a(int i11, String str, Throwable th2) {
        a(i11, str, th2, false, this.f49249f);
    }

    private void a(int i11, String str, Throwable th2, boolean z11, Surface surface) {
        int d11;
        this.f49267y = true;
        String str2 = str + " handleCoreAPIException exception:" + (th2 == null ? "" : th2.getLocalizedMessage());
        if (z11 && (d11 = d(surface)) != 0) {
            i11 = d11;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("errorCode", i11);
            jSONObject.put("exceptionMsg", str2);
            com.tencent.thumbplayer.tcmedia.g.a.a aVar = this.f49263u;
            if (aVar != null) {
                aVar.onReuseCodecAPIException(jSONObject.toString(), th2);
            }
        } catch (JSONException e11) {
            e11.printStackTrace();
        }
        com.tencent.thumbplayer.tcmedia.g.h.b.b(this.f49252j, "hasReused:" + this.f49264v + "    errorCode:" + i11 + ", " + str2, th2);
        a(i11);
    }

    private void a(Surface surface, boolean z11, boolean z12) {
        if (this.f49249f == surface) {
            com.tencent.thumbplayer.tcmedia.g.h.b.d(this.f49252j, this + ", innerSetOutputSurface error surface:" + surface + " is same, stack:" + Log.getStackTraceString(new Throwable()));
            return;
        }
        String str = null;
        if (com.tencent.thumbplayer.tcmedia.g.h.b.a()) {
            str = this + " configure, call innerSetOutputSurface surface:" + surface + "  decodeState:" + this.f49244a + " callByInner:" + z11;
            com.tencent.thumbplayer.tcmedia.g.h.b.b(this.f49252j, str);
        }
        String str2 = str;
        try {
            b(surface);
            this.f49258p.setOutputSurface(surface);
            if (!z12) {
                p();
            }
        } catch (Throwable th2) {
            int i11 = 0;
            if (th2 instanceof IllegalStateException) {
                i11 = CDNDownload.DEFAULT_TIMEOUT;
            } else if (th2 instanceof IllegalArgumentException) {
                i11 = BaseConstants.ERR_SVR_FRIENDSHIP_INVALID_PARAMETERS;
            }
            a(i11, str2, th2, true, surface);
            throw th2;
        }
    }

    private final void b(int i11, int i12, int i13, long j11, int i14) {
        int i15 = AnonymousClass2.f49270a[this.f49265w.ordinal()];
        if (i15 == 1) {
            com.tencent.thumbplayer.tcmedia.g.h.b.d(this.f49252j, "queueInputBufferForAdaptation error for KEEP_CODEC_RESULT_NO");
        } else if (i15 == 2) {
            c(i11, i12, i13, j11, i14);
        } else if (i15 == 3) {
            this.f49258p.queueInputBuffer(i11, i12, i13, j11, i14);
        }
    }

    private void b(MediaFormat mediaFormat, Surface surface, MediaCrypto mediaCrypto, int i11) {
        try {
            if (com.tencent.thumbplayer.tcmedia.g.h.b.a()) {
                com.tencent.thumbplayer.tcmedia.g.h.b.b(this.f49252j, this + ", realConfigure mediaFormat:" + mediaFormat + " surface:" + surface + " crypto:" + mediaCrypto + " flags:" + i11 + " state:" + this.f49260r + " mHasConfigureCalled：" + this.f49266x);
            }
            this.f49258p.configure(mediaFormat, surface, mediaCrypto, i11);
            b(surface);
            this.f49260r = a.Configured;
        } catch (Throwable th2) {
            int i12 = 0;
            if (th2 instanceof IllegalStateException) {
                i12 = 10000;
            } else if (th2 instanceof MediaCodec.CryptoException) {
                i12 = 10001;
            }
            a(i12, (String) null, th2, true, surface);
            throw th2;
        }
    }

    private void b(Surface surface) {
        if (com.tencent.thumbplayer.tcmedia.g.h.b.a()) {
            String str = this.f49252j;
            com.tencent.thumbplayer.tcmedia.g.h.b.c(str, this + ", oldSurface:" + this.f49249f + " CodecWrapperSetSurface surface:" + surface);
        }
        this.f49249f = surface;
    }

    private boolean b(int i11, int i12) {
        if (i12 == -1) {
            int[] iArr = this.f49257o;
            iArr[i11] = iArr[i11] + 1;
            return iArr[i11] > 100;
        }
        this.f49257o[i11] = 0;
        return false;
    }

    private final void c(int i11, int i12, int i13, long j11, int i14) {
        this.f49258p.queueInputBuffer(i11, i12, i13, j11, i14);
    }

    private void c(Surface surface) {
        a(surface, true, false);
    }

    private int d(Surface surface) {
        if (surface == null) {
            return BaseConstants.ERR_SVR_GROUP_API_NAME_ERROR;
        }
        if (!surface.isValid()) {
            return BaseConstants.ERR_SVR_GROUP_INVALID_PARAMETERS;
        }
        return 0;
    }

    private boolean n() {
        return Thread.currentThread().getId() != this.f49262t;
    }

    private void o() {
        if (this.B == null) {
            com.tencent.thumbplayer.tcmedia.g.e.a.a aVar = new com.tencent.thumbplayer.tcmedia.g.e.a.a(1, 1);
            this.B = aVar;
            a(aVar.d(), true, true);
        }
    }

    private void p() {
        if (com.tencent.thumbplayer.tcmedia.g.h.b.a()) {
            String str = this.f49252j;
            com.tencent.thumbplayer.tcmedia.g.h.b.b(str, this + "unBindingBackupSurface");
        }
        com.tencent.thumbplayer.tcmedia.g.e.a.a aVar = this.B;
        if (aVar != null) {
            aVar.b();
        }
        this.B = null;
    }

    private void q() {
        this.f49268z = false;
        this.A = 0;
    }

    private void r() {
        int[] iArr = this.f49257o;
        iArr[0] = 0;
        iArr[1] = 0;
    }

    public int a(long j11) {
        if (n()) {
            com.tencent.thumbplayer.tcmedia.g.h.b.d(this.f49252j, "ignore call method dequeueInputBuffer for isNotMyThread");
            return -1;
        }
        int i11 = 0;
        try {
            int dequeueInputBuffer = this.f49258p.dequeueInputBuffer(j11);
            if (com.tencent.thumbplayer.tcmedia.g.h.b.a()) {
                com.tencent.thumbplayer.tcmedia.g.h.b.a(this.f49252j, this + ", dequeueInputBuffer state:" + this.f49260r + " decodeState:" + this.f49244a + " , result=" + dequeueInputBuffer);
            }
            this.f49244a = b.DequeueIn;
            this.f49260r = a.Running;
            a(0, dequeueInputBuffer);
            return dequeueInputBuffer;
        } catch (Throwable th2) {
            if (th2 instanceof IllegalStateException) {
                i11 = MpegAudioUtil.MAX_RATE_BYTES_PER_SECOND;
            } else if (th2 instanceof IllegalArgumentException) {
                i11 = BaseConstants.ERR_SVR_PROFILE_INVALID_PARAMETERS;
            }
            a(i11, (String) null, th2);
            throw th2;
        }
    }

    public int a(MediaCodec.BufferInfo bufferInfo, long j11) {
        if (n()) {
            com.tencent.thumbplayer.tcmedia.g.h.b.d(this.f49252j, "ignore call method dequeueOutputBuffer for isNotMyThread");
            return -1;
        }
        try {
            int dequeueOutputBuffer = this.f49258p.dequeueOutputBuffer(bufferInfo, j11);
            if (com.tencent.thumbplayer.tcmedia.g.h.b.a()) {
                String str = this + ", dequeueOutputBuffer outIndex:" + dequeueOutputBuffer;
                if (this instanceof g) {
                    com.tencent.thumbplayer.tcmedia.g.h.b.a(this.f49252j, str);
                }
            }
            this.f49254l.add(Integer.valueOf(dequeueOutputBuffer));
            this.f49244a = b.DequeueOut;
            a(1, dequeueOutputBuffer);
            return dequeueOutputBuffer;
        } catch (Throwable th2) {
            int i11 = 0;
            if (Build.VERSION.SDK_INT >= 21 && (th2 instanceof MediaCodec.CodecException)) {
                i11 = 60001;
            } else if (th2 instanceof IllegalStateException) {
                i11 = 60000;
            }
            a(i11, (String) null, th2);
            throw th2;
        }
    }

    public MediaCodec a() {
        return this.f49258p;
    }

    public abstract a.b a(e eVar);

    public void a(int i11, int i12, int i13, long j11, int i14) {
        if (n()) {
            com.tencent.thumbplayer.tcmedia.g.h.b.d(this.f49252j, "ignore call method queueInputBuffer for isNotMyThread");
            return;
        }
        String str = null;
        if (com.tencent.thumbplayer.tcmedia.g.h.b.a()) {
            str = this + ", queueInputBuffer index:" + i11 + " offset:" + i12 + " size:" + i13 + " presentationTimeUs:" + j11 + ' ' + "flags:" + i14 + " state:" + this.f49260r + " decodeState:" + this.f49244a;
            com.tencent.thumbplayer.tcmedia.g.h.b.a(this.f49252j, str);
        }
        try {
            if (this.f49264v) {
                b(i11, i12, i13, j11, i14);
            } else {
                this.f49258p.queueInputBuffer(i11, i12, i13, j11, i14);
            }
            this.f49244a = b.QueueIn;
        } catch (Throwable th2) {
            int i15 = 0;
            if (Build.VERSION.SDK_INT >= 21 && (th2 instanceof MediaCodec.CodecException)) {
                i15 = BaseConstants.ERR_SVR_CONV_ACCOUNT_NOT_FOUND;
            } else if (th2 instanceof IllegalStateException) {
                i15 = 50000;
            } else if (th2 instanceof MediaCodec.CryptoException) {
                i15 = BaseConstants.ERR_SVR_CONV_INVALID_PARAMETERS;
            }
            a(i15, str, th2);
            throw th2;
        }
    }

    public void a(int i11, boolean z11) {
        if (n()) {
            com.tencent.thumbplayer.tcmedia.g.h.b.d(this.f49252j, "ignore call method releaseOutputBuffer for isNotMyThread");
            return;
        }
        String str = null;
        if (com.tencent.thumbplayer.tcmedia.g.h.b.a()) {
            str = this + ", releaseOutputBuffer render:" + z11;
            com.tencent.thumbplayer.tcmedia.g.h.b.a(this.f49252j, str);
        }
        try {
            this.f49254l.remove(Integer.valueOf(i11));
            this.f49258p.releaseOutputBuffer(i11, z11);
        } catch (Throwable th2) {
            if (this.f49260r != a.Flushed) {
                com.tencent.thumbplayer.tcmedia.g.h.b.a(this.f49252j, this + ", releaseOutputBuffer failed, ignore e:", th2);
            }
            int i12 = 0;
            if (Build.VERSION.SDK_INT >= 21 && (th2 instanceof MediaCodec.CodecException)) {
                i12 = BaseConstants.ERR_SVR_ACCOUNT_USERSIG_EMPTY;
            } else if (th2 instanceof IllegalStateException) {
                i12 = BaseConstants.ERR_SVR_ACCOUNT_USERSIG_EXPIRED;
            }
            a(i12, str, th2);
        }
        this.f49244a = b.ReleaseOut;
    }

    public void a(MediaFormat mediaFormat, Surface surface, MediaCrypto mediaCrypto, int i11) {
        if (n()) {
            com.tencent.thumbplayer.tcmedia.g.h.b.d(this.f49252j, "ignore call method configure for isNotMyThread");
            return;
        }
        this.f49266x = true;
        this.f49259q = false;
        if (this.f49260r == a.Uninitialized) {
            b(mediaFormat, surface, mediaCrypto, i11);
        } else if (surface != null) {
            r();
            c(surface);
        }
    }

    public void a(Surface surface) {
        a(surface, false, false);
    }

    public void a(com.tencent.thumbplayer.tcmedia.g.a.a aVar) {
        this.f49263u = aVar;
    }

    public a.b b(e eVar) {
        a.b a11 = a(eVar);
        this.f49265w = a11;
        return a11;
    }

    public void b() {
        long id2 = Thread.currentThread().getId();
        if (!this.f49255m.contains(Long.valueOf(id2))) {
            this.f49262t = id2;
            this.f49255m.add(Long.valueOf(id2));
            if (this.f49255m.size() > 100) {
                this.f49255m.remove(0);
            }
        }
    }

    public void c() {
        q();
        if (com.tencent.thumbplayer.tcmedia.g.a.c()) {
            if (this.f49260r == a.Running) {
                try {
                    e();
                } catch (IllegalStateException e11) {
                    com.tencent.thumbplayer.tcmedia.g.h.b.b(this.f49252j, "flush failed in prepareToReUse", e11);
                }
            }
        } else if (this.f49260r != a.Flushed) {
            e();
        }
        this.f49264v = true;
    }

    public void d() {
        a aVar = this.f49260r;
        a aVar2 = a.Configured;
        if (aVar != aVar2) {
            String str = this.f49252j;
            com.tencent.thumbplayer.tcmedia.g.h.b.b(str, "start ignore:" + this.f49260r);
            return;
        }
        try {
            if (com.tencent.thumbplayer.tcmedia.g.h.b.a()) {
                com.tencent.thumbplayer.tcmedia.g.h.b.b(this.f49252j, this + ", start state:" + this.f49260r);
            }
            if (this.f49260r == aVar2) {
                this.f49258p.start();
                this.f49260r = a.Running;
            }
        } catch (Throwable th2) {
            int i11 = 0;
            if (Build.VERSION.SDK_INT >= 21 && (th2 instanceof MediaCodec.CodecException)) {
                i11 = BaseConstants.ERR_SVR_MSG_PKG_PARSE_FAILED;
            } else if (th2 instanceof IllegalStateException) {
                i11 = 20000;
            }
            a(i11, (String) null, th2);
            throw th2;
        }
    }

    public void e() {
        if (n()) {
            com.tencent.thumbplayer.tcmedia.g.h.b.d(this.f49252j, "call method flush for isNotMyThread...");
        }
        try {
            if (com.tencent.thumbplayer.tcmedia.g.h.b.a()) {
                com.tencent.thumbplayer.tcmedia.g.h.b.b(this.f49252j, this + ", flush state:" + this.f49260r);
            }
            this.f49258p.flush();
            this.f49260r = a.Flushed;
        } catch (Throwable th2) {
            int i11 = 0;
            if (Build.VERSION.SDK_INT >= 21 && (th2 instanceof MediaCodec.CodecException)) {
                i11 = BaseConstants.ERR_SVR_MSG_JSON_PARSE_FAILED;
            } else if (th2 instanceof IllegalStateException) {
                i11 = 90000;
            }
            a(i11, (String) null, th2);
            throw th2;
        }
    }

    public void f() {
        if (com.tencent.thumbplayer.tcmedia.g.h.b.a()) {
            String str = this.f49252j;
            com.tencent.thumbplayer.tcmedia.g.h.b.b(str, this + ", stop");
        }
        if (!j()) {
            if (com.tencent.thumbplayer.tcmedia.g.h.b.a()) {
                String str2 = this.f49252j;
                com.tencent.thumbplayer.tcmedia.g.h.b.b(str2, this + ", codec real stop");
            }
            try {
                this.f49258p.stop();
                this.f49260r = a.Uninitialized;
            } catch (IllegalStateException e11) {
                this.f49260r = a.Uninitialized;
                com.tencent.thumbplayer.tcmedia.g.h.b.b(this.f49252j, "stop failed", e11);
                throw e11;
            }
        }
    }

    public void g() {
        if (com.tencent.thumbplayer.tcmedia.g.h.b.a()) {
            String str = this.f49252j;
            com.tencent.thumbplayer.tcmedia.g.h.b.b(str, this + " call release mHoldBufferOutIndex:" + this.f49254l + " mReleaseCalled:" + this.f49259q + " stack:" + Log.getStackTraceString(new Throwable()));
        }
        this.f49259q = true;
        this.f49266x = false;
        if (j()) {
            try {
                e();
            } catch (IllegalStateException e11) {
                com.tencent.thumbplayer.tcmedia.g.h.b.b(this.f49252j, "flush failed for not in the Executing state.", e11);
            }
            o();
            com.tencent.thumbplayer.tcmedia.g.a.a().b(this);
            return;
        }
        if (com.tencent.thumbplayer.tcmedia.g.h.b.a()) {
            String str2 = this.f49252j;
            com.tencent.thumbplayer.tcmedia.g.h.b.d(str2, "Don't not keep the codec, release it ..., mErrorHappened:" + this.f49267y);
        }
        com.tencent.thumbplayer.tcmedia.g.a.a().a((c) this);
        i();
        this.f49260r = a.Released;
    }

    public final com.tencent.thumbplayer.tcmedia.g.a.a h() {
        return this.f49263u;
    }

    public final void i() {
        if (com.tencent.thumbplayer.tcmedia.g.h.b.a()) {
            String str = this.f49252j;
            com.tencent.thumbplayer.tcmedia.g.h.b.b(str, this + ", recycle isRecycled:" + this.f49245b + "  mSurfaceMap.size:" + f49243i.size() + "...... stack:" + Log.getStackTraceString(new Throwable()));
        }
        if (this.f49245b) {
            com.tencent.thumbplayer.tcmedia.g.h.b.d(this.f49252j, "ignore recycle for has isRecycled is true.");
            return;
        }
        this.f49266x = false;
        this.f49245b = true;
        d.a(new Runnable() {
            public void run() {
                try {
                    f.this.f49258p.stop();
                    f.this.f49258p.release();
                } catch (Throwable th2) {
                    com.tencent.thumbplayer.tcmedia.g.h.b.a(f.this.f49252j, "recycle codec ignore error,", th2);
                }
                if (f.this.f49263u != null) {
                    f.this.f49263u.onRealRelease();
                }
            }
        });
        this.f49260r = a.Uninitialized;
    }

    public boolean j() {
        return com.tencent.thumbplayer.tcmedia.g.a.c() ? !this.f49267y && com.tencent.thumbplayer.tcmedia.g.a.a().e() && com.tencent.thumbplayer.tcmedia.g.a.a().f() : !this.f49267y && com.tencent.thumbplayer.tcmedia.g.a.a().e();
    }

    public void k() {
        this.A++;
    }

    public boolean l() {
        return this.A >= 3;
    }

    public String m() {
        return this.f49251h;
    }

    public String toString() {
        return super.toString() + " mReleaseCalled:" + this.f49259q + " isRecycled:" + this.f49245b;
    }
}
