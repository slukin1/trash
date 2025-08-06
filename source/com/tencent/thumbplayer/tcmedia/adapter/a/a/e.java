package com.tencent.thumbplayer.tcmedia.adapter.a.a;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.media.PlaybackParams;
import android.media.TimedText;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.tencent.imsdk.BaseConstants;
import com.tencent.thumbplayer.tcmedia.adapter.a.a.a;
import com.tencent.thumbplayer.tcmedia.adapter.a.c;
import com.tencent.thumbplayer.tcmedia.api.TPAudioAttributes;
import com.tencent.thumbplayer.tcmedia.api.TPCaptureCallBack;
import com.tencent.thumbplayer.tcmedia.api.TPCaptureParams;
import com.tencent.thumbplayer.tcmedia.api.TPCommonEnum;
import com.tencent.thumbplayer.tcmedia.api.TPOptionalParam;
import com.tencent.thumbplayer.tcmedia.api.TPPlayerMsg;
import com.tencent.thumbplayer.tcmedia.api.TPProgramInfo;
import com.tencent.thumbplayer.tcmedia.api.TPSubtitleData;
import com.tencent.thumbplayer.tcmedia.api.TPSubtitleFrameBuffer;
import com.tencent.thumbplayer.tcmedia.api.TPSubtitleRenderModel;
import com.tencent.thumbplayer.tcmedia.api.TPTrackInfo;
import com.tencent.thumbplayer.tcmedia.api.composition.ITPMediaAsset;
import com.tencent.thumbplayer.tcmedia.core.common.TPGeneralError;
import com.tencent.thumbplayer.tcmedia.core.common.TPSubtitleFrame;
import com.tencent.thumbplayer.tcmedia.core.imagegenerator.TPImageGeneratorParams;
import com.tencent.thumbplayer.tcmedia.core.player.TPDynamicStatisticParams;
import com.tencent.thumbplayer.tcmedia.core.player.TPGeneralPlayFlowParams;
import com.tencent.thumbplayer.tcmedia.utils.TPLogUtil;
import com.tencent.thumbplayer.tcmedia.utils.o;
import java.io.FileDescriptor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class e implements com.tencent.thumbplayer.tcmedia.adapter.a.b {
    /* access modifiers changed from: private */
    public c.l A;
    /* access modifiers changed from: private */
    public c.m B;
    /* access modifiers changed from: private */
    public volatile MediaPlayer C;
    private d D;
    private com.tencent.thumbplayer.tcmedia.a.c E;
    private Object F;
    private Future<?> G = null;
    private final Object H = new Object();
    private long I = com.sumsub.sns.core.presentation.base.a.f30780p;
    private a J;
    private final Object K = new Object();
    private int L = 3;
    private int M = 30;
    private final Object N = new Object();
    private Future<?> O = null;
    /* access modifiers changed from: private */
    public boolean P = false;
    /* access modifiers changed from: private */
    public volatile C0612e Q;
    /* access modifiers changed from: private */
    public volatile C0612e R;
    private boolean S = false;
    private long T = 0;
    private long U = -1;
    /* access modifiers changed from: private */
    public int V = 0;
    /* access modifiers changed from: private */
    public int W = 0;
    /* access modifiers changed from: private */
    public volatile boolean X = false;
    private int Y = 0;
    /* access modifiers changed from: private */
    public int Z = -1;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public com.tencent.thumbplayer.tcmedia.e.a f48747a;

    /* renamed from: aa  reason: collision with root package name */
    private int f48748aa = 0;

    /* renamed from: ab  reason: collision with root package name */
    private int f48749ab = -1;

    /* renamed from: ac  reason: collision with root package name */
    private int f48750ac = -1;

    /* renamed from: ad  reason: collision with root package name */
    private List<b> f48751ad = new ArrayList();

    /* renamed from: ae  reason: collision with root package name */
    private List<b> f48752ae = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: af  reason: collision with root package name */
    public a f48753af;

    /* renamed from: ag  reason: collision with root package name */
    private long f48754ag = 0;

    /* renamed from: ah  reason: collision with root package name */
    private f f48755ah = null;

    /* renamed from: ai  reason: collision with root package name */
    private MediaPlayer.OnTimedTextListener f48756ai = new MediaPlayer.OnTimedTextListener() {
        public void onTimedText(MediaPlayer mediaPlayer, TimedText timedText) {
            if (e.this.A != null) {
                TPSubtitleData tPSubtitleData = new TPSubtitleData();
                tPSubtitleData.subtitleData = timedText != null ? timedText.getText() : "";
                tPSubtitleData.trackIndex = (long) e.this.Z;
                tPSubtitleData.startPositionMs = e.this.o();
                e.this.A.a(tPSubtitleData);
            }
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private Context f48757b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f48758c = false;

    /* renamed from: d  reason: collision with root package name */
    private long f48759d = 0;

    /* renamed from: e  reason: collision with root package name */
    private long f48760e = 0;

    /* renamed from: f  reason: collision with root package name */
    private String f48761f;

    /* renamed from: g  reason: collision with root package name */
    private FileDescriptor f48762g;

    /* renamed from: h  reason: collision with root package name */
    private AssetFileDescriptor f48763h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f48764i = false;

    /* renamed from: j  reason: collision with root package name */
    private float f48765j = 1.0f;

    /* renamed from: k  reason: collision with root package name */
    private float f48766k = 1.0f;

    /* renamed from: l  reason: collision with root package name */
    private Map<String, String> f48767l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public int f48768m = 0;

    /* renamed from: n  reason: collision with root package name */
    private long f48769n = -1;
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with root package name */
    public boolean f48770o = false;

    /* renamed from: p  reason: collision with root package name */
    private long f48771p = -1;
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public int f48772q = -1;
    /* access modifiers changed from: private */

    /* renamed from: r  reason: collision with root package name */
    public int f48773r = -1;

    /* renamed from: s  reason: collision with root package name */
    private TPAudioAttributes f48774s = null;

    /* renamed from: t  reason: collision with root package name */
    private boolean f48775t = true;

    /* renamed from: u  reason: collision with root package name */
    private c.i f48776u;
    /* access modifiers changed from: private */

    /* renamed from: v  reason: collision with root package name */
    public c.C0614c f48777v;
    /* access modifiers changed from: private */

    /* renamed from: w  reason: collision with root package name */
    public c.h f48778w;
    /* access modifiers changed from: private */

    /* renamed from: x  reason: collision with root package name */
    public c.f f48779x;
    /* access modifiers changed from: private */

    /* renamed from: y  reason: collision with root package name */
    public c.j f48780y;
    /* access modifiers changed from: private */

    /* renamed from: z  reason: collision with root package name */
    public c.p f48781z;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public boolean f48791a;

        /* renamed from: b  reason: collision with root package name */
        public Future<?> f48792b;

        private a() {
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public TPTrackInfo f48793a;

        /* renamed from: b  reason: collision with root package name */
        public String f48794b;

        /* renamed from: c  reason: collision with root package name */
        public List<TPOptionalParam> f48795c;

        /* renamed from: d  reason: collision with root package name */
        public Map<String, String> f48796d;

        private b() {
            this.f48794b = "";
        }
    }

    public static class c implements Handler.Callback {

        /* renamed from: a  reason: collision with root package name */
        private Handler f48797a;

        public c(Handler handler) {
            this.f48797a = handler;
        }

        public boolean handleMessage(Message message) {
            try {
                this.f48797a.handleMessage(message);
                return true;
            } catch (Exception e11) {
                TPLogUtil.e("TPSystemMediaPlayer", "mediaPlayerExceptionHook, HookCallback, " + Log.getStackTraceString(e11));
                return true;
            }
        }
    }

    public class d implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnVideoSizeChangedListener {
        private d() {
        }

        private int a(int i11) {
            return e.this.f48773r > 0 ? e.this.f48773r : i11;
        }

        private int b(int i11) {
            return e.this.f48772q > 0 ? e.this.f48772q : i11;
        }

        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i11) {
        }

        public void onCompletion(MediaPlayer mediaPlayer) {
            if (e.this.f48770o) {
                e.this.f48747a.d("onCompletion, unknown err.");
                return;
            }
            e.this.f48747a.c("onCompletion.");
            C0612e unused = e.this.R = C0612e.COMPLETE;
            e.this.C();
            c.C0614c r11 = e.this.f48777v;
            if (r11 != null) {
                r11.b();
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0079, code lost:
            if (r12 == 100) goto L_0x007c;
         */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x008c  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onError(android.media.MediaPlayer r11, int r12, int r13) {
            /*
                r10 = this;
                com.tencent.thumbplayer.tcmedia.adapter.a.a.e r11 = com.tencent.thumbplayer.tcmedia.adapter.a.a.e.this
                com.tencent.thumbplayer.tcmedia.adapter.a.a.e$e r11 = r11.Q
                com.tencent.thumbplayer.tcmedia.adapter.a.a.e$e r0 = com.tencent.thumbplayer.tcmedia.adapter.a.a.e.C0612e.COMPLETE
                r1 = 1
                if (r11 == r0) goto L_0x0097
                com.tencent.thumbplayer.tcmedia.adapter.a.a.e r11 = com.tencent.thumbplayer.tcmedia.adapter.a.a.e.this
                com.tencent.thumbplayer.tcmedia.adapter.a.a.e$e r11 = r11.Q
                com.tencent.thumbplayer.tcmedia.adapter.a.a.e$e r0 = com.tencent.thumbplayer.tcmedia.adapter.a.a.e.C0612e.STOPPED
                if (r11 == r0) goto L_0x0097
                com.tencent.thumbplayer.tcmedia.adapter.a.a.e r11 = com.tencent.thumbplayer.tcmedia.adapter.a.a.e.this
                com.tencent.thumbplayer.tcmedia.adapter.a.a.e$e r11 = r11.Q
                com.tencent.thumbplayer.tcmedia.adapter.a.a.e$e r0 = com.tencent.thumbplayer.tcmedia.adapter.a.a.e.C0612e.RELEASE
                if (r11 == r0) goto L_0x0097
                com.tencent.thumbplayer.tcmedia.adapter.a.a.e r11 = com.tencent.thumbplayer.tcmedia.adapter.a.a.e.this
                com.tencent.thumbplayer.tcmedia.adapter.a.a.e$e r11 = r11.Q
                com.tencent.thumbplayer.tcmedia.adapter.a.a.e$e r0 = com.tencent.thumbplayer.tcmedia.adapter.a.a.e.C0612e.IDLE
                if (r11 == r0) goto L_0x0097
                com.tencent.thumbplayer.tcmedia.adapter.a.a.e r11 = com.tencent.thumbplayer.tcmedia.adapter.a.a.e.this
                com.tencent.thumbplayer.tcmedia.adapter.a.a.e$e r11 = r11.Q
                com.tencent.thumbplayer.tcmedia.adapter.a.a.e$e r0 = com.tencent.thumbplayer.tcmedia.adapter.a.a.e.C0612e.ERROR
                if (r11 != r0) goto L_0x0034
                goto L_0x0097
            L_0x0034:
                com.tencent.thumbplayer.tcmedia.adapter.a.a.e r11 = com.tencent.thumbplayer.tcmedia.adapter.a.a.e.this
                com.tencent.thumbplayer.tcmedia.e.a r11 = r11.f48747a
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                java.lang.String r3 = "onError, what: "
                r2.<init>(r3)
                r2.append(r12)
                java.lang.String r3 = ", extra: "
                r2.append(r3)
                r2.append(r13)
                java.lang.String r2 = r2.toString()
                r11.c(r2)
                com.tencent.thumbplayer.tcmedia.adapter.a.a.e r11 = com.tencent.thumbplayer.tcmedia.adapter.a.a.e.this
                r11.A()
                com.tencent.thumbplayer.tcmedia.adapter.a.a.e r11 = com.tencent.thumbplayer.tcmedia.adapter.a.a.e.this
                r11.C()
                com.tencent.thumbplayer.tcmedia.adapter.a.a.e r11 = com.tencent.thumbplayer.tcmedia.adapter.a.a.e.this
                com.tencent.thumbplayer.tcmedia.adapter.a.a.e.C0612e unused = r11.Q = r0
                r11 = -1010(0xfffffffffffffc0e, float:NaN)
                r0 = 2001(0x7d1, float:2.804E-42)
                r2 = 2000(0x7d0, float:2.803E-42)
                if (r13 == r11) goto L_0x007e
                r11 = -1007(0xfffffffffffffc11, float:NaN)
                if (r13 == r11) goto L_0x007e
                r11 = -110(0xffffffffffffff92, float:NaN)
                if (r13 == r11) goto L_0x007c
                switch(r13) {
                    case -1005: goto L_0x007c;
                    case -1004: goto L_0x007c;
                    case -1003: goto L_0x007c;
                    default: goto L_0x0075;
                }
            L_0x0075:
                if (r12 == r1) goto L_0x007e
                r11 = 100
                if (r12 == r11) goto L_0x007c
                goto L_0x007e
            L_0x007c:
                r4 = r0
                goto L_0x007f
            L_0x007e:
                r4 = r2
            L_0x007f:
                com.tencent.thumbplayer.tcmedia.adapter.a.a.e r11 = com.tencent.thumbplayer.tcmedia.adapter.a.a.e.this
                r11.e()
                com.tencent.thumbplayer.tcmedia.adapter.a.a.e r11 = com.tencent.thumbplayer.tcmedia.adapter.a.a.e.this
                com.tencent.thumbplayer.tcmedia.adapter.a.c$f r3 = r11.f48779x
                if (r3 == 0) goto L_0x0096
                int r5 = com.tencent.thumbplayer.tcmedia.adapter.a.a.e.g((int) r12)
                long r6 = (long) r13
                r8 = 0
                r3.a(r4, r5, r6, r8)
            L_0x0096:
                return r1
            L_0x0097:
                com.tencent.thumbplayer.tcmedia.adapter.a.a.e r11 = com.tencent.thumbplayer.tcmedia.adapter.a.a.e.this
                com.tencent.thumbplayer.tcmedia.e.a r11 = r11.f48747a
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                java.lang.String r2 = "onError, illegal state:"
                r0.<init>(r2)
                com.tencent.thumbplayer.tcmedia.adapter.a.a.e r2 = com.tencent.thumbplayer.tcmedia.adapter.a.a.e.this
                com.tencent.thumbplayer.tcmedia.adapter.a.a.e$e r2 = r2.Q
                r0.append(r2)
                java.lang.String r2 = ", what:"
                r0.append(r2)
                r0.append(r12)
                java.lang.String r12 = ", extra:"
                r0.append(r12)
                r0.append(r13)
                java.lang.String r12 = r0.toString()
                r11.c(r12)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.thumbplayer.tcmedia.adapter.a.a.e.d.onError(android.media.MediaPlayer, int, int):boolean");
        }

        public boolean onInfo(MediaPlayer mediaPlayer, int i11, int i12) {
            int i13;
            e.this.f48747a.c("mediaplayer, onInfo. what:" + i11 + ", extra:" + i12);
            if (i11 != 3) {
                if (i11 == 801) {
                    boolean unused = e.this.P = true;
                } else if (i11 == 701) {
                    i13 = 200;
                } else if (i11 == 702) {
                    i13 = 201;
                }
                i13 = -1;
            } else {
                i13 = 106;
            }
            if (i13 != -1) {
                if (200 == i13 || 201 == i13) {
                    if (!e.this.G()) {
                        e eVar = e.this;
                        if (200 == i13) {
                            boolean unused2 = eVar.X = true;
                            e.this.E();
                        } else {
                            boolean unused3 = eVar.X = false;
                            e.this.F();
                        }
                        if (e.this.f48778w != null) {
                            e.this.f48778w.a(i13, 0, 0, (Object) null);
                        }
                    }
                } else if (e.this.f48778w != null) {
                    e.this.f48778w.a(106, 0, 0, (Object) null);
                }
            }
            if (i13 == 106) {
                int a11 = a(mediaPlayer.getVideoWidth());
                int b11 = b(mediaPlayer.getVideoHeight());
                if (!(b11 == e.this.W && a11 == e.this.V) && b11 > 0 && a11 > 0) {
                    int unused4 = e.this.W = b11;
                    int unused5 = e.this.V = a11;
                    if (e.this.f48781z != null) {
                        e.this.f48781z.a((long) e.this.V, (long) e.this.W);
                    }
                }
            }
            return true;
        }

        public void onPrepared(MediaPlayer mediaPlayer) {
            if (e.this.Q != C0612e.PREPARING) {
                com.tencent.thumbplayer.tcmedia.e.a c11 = e.this.f48747a;
                c11.c("onPrepared() is called in a wrong situation, mState = " + e.this.Q);
                return;
            }
            C0612e unused = e.this.R = C0612e.PREPARED;
            long duration = (long) e.this.C.getDuration();
            if (duration <= 0) {
                boolean unused2 = e.this.P = true;
            }
            com.tencent.thumbplayer.tcmedia.e.a c12 = e.this.f48747a;
            c12.c("onPrepared() , mStartPositionMs=" + e.this.f48768m + ", duration:" + duration + ", mIsLive:" + e.this.f48770o);
            e.this.A();
            e.this.w();
        }

        public void onSeekComplete(MediaPlayer mediaPlayer) {
            if (e.this.C != null) {
                e.this.f48747a.c("onSeekComplete().");
                C0612e e11 = e.this.Q;
                C0612e eVar = C0612e.STARTED;
                if (e11 == eVar && e.this.R == C0612e.COMPLETE) {
                    C0612e unused = e.this.Q = eVar;
                    C0612e unused2 = e.this.R = eVar;
                    e.this.C.start();
                }
                if (C0612e.PREPARED != e.this.Q && e.this.f48780y != null) {
                    e.this.f48780y.c();
                }
            }
        }

        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i11, int i12) {
            if (i11 == 0 || i12 == 0) {
                com.tencent.thumbplayer.tcmedia.e.a c11 = e.this.f48747a;
                c11.e("onVideoSizeChanged() size error, width:" + i11 + " height:" + i12);
                return;
            }
            int a11 = a(i11);
            int b11 = b(i12);
            try {
                if (!(a11 == e.this.V && b11 == e.this.W) && b11 > 0 && a11 > 0) {
                    e.this.f48781z.a((long) a11, (long) b11);
                }
            } catch (Exception e11) {
                e.this.f48747a.d(e11.toString());
            }
            int unused = e.this.V = a11;
            int unused2 = e.this.W = b11;
            com.tencent.thumbplayer.tcmedia.e.a c12 = e.this.f48747a;
            c12.c("onVideoSizeChanged(), width:" + a11 + " height:" + b11);
        }
    }

    /* renamed from: com.tencent.thumbplayer.tcmedia.adapter.a.a.e$e  reason: collision with other inner class name */
    public enum C0612e {
        IDLE,
        INITIALIZED,
        PREPARING,
        PREPARED,
        STARTED,
        PAUSED,
        STOPPED,
        COMPLETE,
        ERROR,
        RELEASE
    }

    public static class f {

        /* renamed from: a  reason: collision with root package name */
        public int f48810a;

        /* renamed from: b  reason: collision with root package name */
        public long f48811b;

        /* renamed from: c  reason: collision with root package name */
        public long f48812c;

        /* renamed from: d  reason: collision with root package name */
        public int f48813d;

        /* renamed from: e  reason: collision with root package name */
        public int f48814e;

        /* renamed from: f  reason: collision with root package name */
        public int f48815f;

        /* renamed from: g  reason: collision with root package name */
        public String f48816g;

        /* renamed from: h  reason: collision with root package name */
        public C0612e f48817h;

        private f() {
        }
    }

    public e(Context context, com.tencent.thumbplayer.tcmedia.e.b bVar) {
        this.f48747a = new com.tencent.thumbplayer.tcmedia.e.a(bVar, "TPSystemMediaPlayer");
        this.f48757b = context;
        this.D = new d();
        b bVar2 = new b();
        TPTrackInfo tPTrackInfo = new TPTrackInfo();
        bVar2.f48793a = tPTrackInfo;
        tPTrackInfo.isSelected = true;
        tPTrackInfo.name = "audio_1";
        this.f48751ad.add(bVar2);
        b();
        c cVar = new c();
        this.f48753af = cVar;
        cVar.a((a.C0611a) new a.C0611a() {
            public void a(a.e eVar) {
                TPSubtitleData tPSubtitleData = new TPSubtitleData();
                tPSubtitleData.subtitleData = eVar.f48710a;
                c.l a11 = e.this.A;
                if (a11 != null) {
                    a11.a(tPSubtitleData);
                }
            }

            public void a(TPSubtitleFrame tPSubtitleFrame) {
                TPSubtitleFrameBuffer a11 = com.tencent.thumbplayer.tcmedia.adapter.a.b.c.a(tPSubtitleFrame);
                c.m b11 = e.this.B;
                if (b11 != null) {
                    b11.a(a11);
                }
            }

            public void a(String str) {
                e.this.f48747a.c("onSubtitleNote, ".concat(String.valueOf(str)));
                c.h d11 = e.this.f48778w;
                if (d11 != null) {
                    d11.a(506, 0, 0, str);
                }
            }
        });
        this.f48753af.a((a.d) new a.d() {
            public long a() {
                if (e.this.Q == C0612e.PAUSED || e.this.Q == C0612e.STARTED) {
                    return e.this.o();
                }
                return -1;
            }
        });
        this.f48753af.a((a.c) new a.c() {
            public void a(int i11, long j11) {
                if (e.this.f48778w != null) {
                    e.this.f48778w.a(4, 2000, (long) e.g(i11), Long.valueOf(j11));
                }
            }

            public void a(long j11) {
                if (e.this.Q == C0612e.STARTED) {
                    e.this.f48753af.b();
                }
                if (e.this.f48778w != null) {
                    e.this.f48778w.a(4, 1000, 0, Long.valueOf(j11));
                }
            }
        });
        this.f48753af.a((a.b) new a.b() {
            public void a(int i11, int i12) {
                if (e.this.f48778w != null) {
                    e.this.f48778w.a(254, (long) i11, (long) i12, (Object) null);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public synchronized void A() {
        synchronized (this.H) {
            Future<?> future = this.G;
            if (future != null) {
                future.cancel(true);
                this.G = null;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0039, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void B() {
        /*
            r7 = this;
            java.lang.Object r0 = r7.K
            monitor-enter(r0)
            boolean r1 = r7.G()     // Catch:{ all -> 0x003a }
            if (r1 != 0) goto L_0x0012
            com.tencent.thumbplayer.tcmedia.e.a r1 = r7.f48747a     // Catch:{ all -> 0x003a }
            java.lang.String r2 = "startCheckBufferingTimer, forbidden check buffer by position"
            r1.c(r2)     // Catch:{ all -> 0x003a }
            monitor-exit(r0)     // Catch:{ all -> 0x003a }
            return
        L_0x0012:
            com.tencent.thumbplayer.tcmedia.adapter.a.a.e$a r1 = r7.J     // Catch:{ all -> 0x003a }
            if (r1 != 0) goto L_0x0038
            com.tencent.thumbplayer.tcmedia.adapter.a.a.e$a r1 = new com.tencent.thumbplayer.tcmedia.adapter.a.a.e$a     // Catch:{ all -> 0x003a }
            r2 = 0
            r1.<init>()     // Catch:{ all -> 0x003a }
            r7.J = r1     // Catch:{ all -> 0x003a }
            r2 = 0
            r1.f48791a = r2     // Catch:{ all -> 0x003a }
            com.tencent.thumbplayer.tcmedia.utils.o r2 = com.tencent.thumbplayer.tcmedia.utils.o.a()     // Catch:{ all -> 0x003a }
            java.util.concurrent.ScheduledExecutorService r2 = r2.e()     // Catch:{ all -> 0x003a }
            com.tencent.thumbplayer.tcmedia.adapter.a.a.e$6 r3 = new com.tencent.thumbplayer.tcmedia.adapter.a.a.e$6     // Catch:{ all -> 0x003a }
            r3.<init>(r1)     // Catch:{ all -> 0x003a }
            r4 = 0
            java.util.concurrent.TimeUnit r6 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ all -> 0x003a }
            java.util.concurrent.ScheduledFuture r2 = r2.schedule(r3, r4, r6)     // Catch:{ all -> 0x003a }
            r1.f48792b = r2     // Catch:{ all -> 0x003a }
        L_0x0038:
            monitor-exit(r0)     // Catch:{ all -> 0x003a }
            return
        L_0x003a:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x003a }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.thumbplayer.tcmedia.adapter.a.a.e.B():void");
    }

    /* access modifiers changed from: private */
    public synchronized void C() {
        synchronized (this.K) {
            a aVar = this.J;
            if (aVar != null) {
                aVar.f48791a = true;
                Future<?> future = aVar.f48792b;
                if (future != null) {
                    future.cancel(true);
                }
                this.J.f48792b = null;
                this.J = null;
            }
        }
    }

    /* access modifiers changed from: private */
    public void D() {
        long o11 = o();
        long j11 = this.U;
        this.U = o11;
        if (this.Q == C0612e.STARTED) {
            if (this.f48758c) {
                long j12 = this.f48760e;
                if (j12 > 0 && o11 >= j12 && !this.P) {
                    this.f48747a.c("checkBuffingEvent, loopback skip end, curPosition:" + o11 + ", mLoopStartPositionMs:" + this.f48759d);
                    this.C.seekTo((int) this.f48759d);
                }
            } else if (this.f48769n > 0 && o11 >= n() - this.f48769n) {
                this.f48747a.c("checkBuffingEvent, skip end, mBaseDuration: " + this.T + ", curPosition:" + o11 + ", mSkipEndMilsec:" + this.f48769n);
                this.Q = C0612e.COMPLETE;
                e();
                C();
                c.C0614c cVar = this.f48777v;
                if (cVar != null) {
                    cVar.b();
                    return;
                }
                return;
            }
            int i11 = (o11 > j11 ? 1 : (o11 == j11 ? 0 : -1));
            if (i11 != 0) {
                this.f48754ag++;
            }
            if (i11 != 0 || o11 <= 0) {
                if (this.X) {
                    this.f48747a.c("checkBuffingEvent, position change, send end buffering");
                    c.h hVar = this.f48778w;
                    if (hVar != null) {
                        hVar.a(201, o11, this.T, Long.valueOf(this.f48754ag));
                    }
                }
                this.X = false;
                this.Y = 0;
                return;
            }
            int i12 = this.Y + 1;
            this.Y = i12;
            if (i12 >= this.L && !this.X) {
                this.X = true;
                this.f48747a.c("checkBuffingEvent, position no change,send start buffering");
                c.h hVar2 = this.f48778w;
                if (hVar2 != null) {
                    hVar2.a(200, o11, this.T, Long.valueOf(this.f48754ag));
                }
            }
            if (this.Y >= this.M) {
                this.f48747a.e("checkBuffingEvent post error");
                this.Q = C0612e.ERROR;
                e();
                this.X = false;
                C();
                c.f fVar = this.f48779x;
                if (fVar != null) {
                    fVar.a(2001, g(-110), 0, 0);
                }
            }
        } else if (this.Q == C0612e.PAUSED && this.X) {
            this.f48747a.c("checkBuffingEvent, pause state and send end buffering");
            this.X = false;
            this.Y = 0;
            c.h hVar3 = this.f48778w;
            if (hVar3 != null) {
                hVar3.a(201, 0, 0, (Object) null);
            }
        }
    }

    /* access modifiers changed from: private */
    public void E() {
        synchronized (this.N) {
            if (this.O == null) {
                this.O = o.a().e().schedule(new Runnable() {
                    public void run() {
                        if (e.this.Q != C0612e.PAUSED && e.this.X) {
                            e.this.f48747a.e("startCheckBufferTimeOutByInfo, buffer last too long");
                            C0612e unused = e.this.Q = C0612e.ERROR;
                            e.this.e();
                            boolean unused2 = e.this.X = false;
                            e.this.F();
                            c.f i11 = e.this.f48779x;
                            if (i11 != null) {
                                i11.a(2001, e.g(-110), 0, 0);
                            }
                        }
                    }
                }, (long) (this.M * 400), TimeUnit.MILLISECONDS);
            }
        }
    }

    /* access modifiers changed from: private */
    public synchronized void F() {
        synchronized (this.N) {
            Future<?> future = this.O;
            if (future != null) {
                future.cancel(true);
                this.O = null;
            }
        }
    }

    /* access modifiers changed from: private */
    public boolean G() {
        if (this.f48770o) {
            return false;
        }
        return this.f48775t;
    }

    private MediaPlayer a() {
        b bVar = new b();
        int i11 = Build.VERSION.SDK_INT;
        if (i11 <= 19) {
            a((MediaPlayer) bVar);
        }
        bVar.setOnPreparedListener(this.D);
        bVar.setOnCompletionListener(this.D);
        bVar.setOnErrorListener(this.D);
        bVar.setOnInfoListener(this.D);
        bVar.setOnBufferingUpdateListener(this.D);
        bVar.setOnSeekCompleteListener(this.D);
        bVar.setOnVideoSizeChangedListener(this.D);
        if (i11 >= 16) {
            bVar.setOnTimedTextListener(this.f48756ai);
        }
        return bVar;
    }

    private void a(MediaPlayer mediaPlayer) {
        try {
            Field declaredField = MediaPlayer.class.getDeclaredField("mEventHandler");
            declaredField.setAccessible(true);
            Handler handler = (Handler) declaredField.get(mediaPlayer);
            Field declaredField2 = Handler.class.getDeclaredField("mCallback");
            declaredField2.setAccessible(true);
            if (((Handler.Callback) declaredField2.get(handler)) == null) {
                declaredField2.set(handler, new c(handler));
            }
        } catch (Exception e11) {
            com.tencent.thumbplayer.tcmedia.e.a aVar = this.f48747a;
            aVar.e("mediaPlayerExceptionHook, " + Log.getStackTraceString(e11));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002e, code lost:
        if (r6 == 3) goto L_0x0030;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(android.media.MediaPlayer r4, int r5, @com.tencent.thumbplayer.tcmedia.api.TPCommonEnum.TPSeekMode int r6) {
        /*
            r3 = this;
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 26
            if (r0 >= r1) goto L_0x0022
            com.tencent.thumbplayer.tcmedia.e.a r6 = r3.f48747a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "os ver is too low, current sdk int:"
            r1.<init>(r2)
            r1.append(r0)
            java.lang.String r0 = ", is less than 26, use seekTo(int positionMs) instead"
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r6.c(r0)
            r4.seekTo(r5)
            return
        L_0x0022:
            r0 = 2
            r1 = 1
            r2 = 0
            if (r6 != r1) goto L_0x0029
        L_0x0027:
            r0 = r2
            goto L_0x0030
        L_0x0029:
            if (r6 != r0) goto L_0x002d
            r0 = r1
            goto L_0x0030
        L_0x002d:
            r1 = 3
            if (r6 != r1) goto L_0x0027
        L_0x0030:
            long r1 = (long) r5
            r4.seekTo(r1, r0)     // Catch:{ Exception -> 0x0035 }
            return
        L_0x0035:
            r6 = move-exception
            com.tencent.thumbplayer.tcmedia.e.a r0 = r3.f48747a
            r0.a((java.lang.Exception) r6)
            com.tencent.thumbplayer.tcmedia.adapter.a.a.e$e r6 = r3.R     // Catch:{ Exception -> 0x0049 }
            com.tencent.thumbplayer.tcmedia.adapter.a.a.e$e r0 = com.tencent.thumbplayer.tcmedia.adapter.a.a.e.C0612e.COMPLETE     // Catch:{ Exception -> 0x0049 }
            if (r6 != r0) goto L_0x0045
            com.tencent.thumbplayer.tcmedia.adapter.a.a.e$e r6 = com.tencent.thumbplayer.tcmedia.adapter.a.a.e.C0612e.STARTED     // Catch:{ Exception -> 0x0049 }
            r3.Q = r6     // Catch:{ Exception -> 0x0049 }
        L_0x0045:
            r4.seekTo(r5)     // Catch:{ Exception -> 0x0049 }
            return
        L_0x0049:
            r4 = move-exception
            com.tencent.thumbplayer.tcmedia.e.a r5 = r3.f48747a
            r5.a((java.lang.Exception) r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.thumbplayer.tcmedia.adapter.a.a.e.a(android.media.MediaPlayer, int, int):void");
    }

    private synchronized void a(f fVar) {
        int i11;
        String str = fVar.f48816g;
        fVar.f48812c = o();
        fVar.f48817h = this.Q;
        fVar.f48814e = this.f48750ac;
        fVar.f48815f = this.Z;
        com.tencent.thumbplayer.tcmedia.e.a aVar = this.f48747a;
        aVar.c("playerResetStart, pos:" + fVar.f48812c + ", state:" + fVar.f48817h);
        this.S = true;
        f();
        this.R = C0612e.IDLE;
        if (this.f48762g != null) {
            this.C.setDataSource(this.f48762g);
        } else {
            AssetFileDescriptor assetFileDescriptor = this.f48763h;
            if (assetFileDescriptor != null) {
                b(assetFileDescriptor);
            } else {
                e(fVar.f48813d);
                Map<String, String> map = this.f48767l;
                if (map == null || map.isEmpty()) {
                    this.C.setDataSource(str);
                } else {
                    this.C.setDataSource(this.f48757b, Uri.parse(str), this.f48767l);
                }
            }
        }
        this.R = C0612e.INITIALIZED;
        Object obj = this.F;
        if (obj == null) {
            this.C.setDisplay((SurfaceHolder) null);
        } else if (obj instanceof SurfaceHolder) {
            this.C.setDisplay((SurfaceHolder) this.F);
        } else if (obj instanceof Surface) {
            this.C.setSurface((Surface) this.F);
        }
        f fVar2 = this.f48755ah;
        if (!(fVar2 == null || (i11 = fVar2.f48810a) == fVar.f48810a)) {
            c.h hVar = this.f48778w;
            int i12 = i11 == 1 ? 3 : 4;
            if (hVar != null) {
                hVar.a(i12, fVar2.f48811b, 0, (Object) null);
            }
            fVar.f48817h = fVar2.f48817h;
            fVar.f48812c = fVar2.f48812c;
        }
        this.f48755ah = fVar;
        C0612e eVar = fVar.f48817h;
        if (eVar == C0612e.PREPARING || eVar == C0612e.PREPARED || eVar == C0612e.STARTED || eVar == C0612e.PAUSED) {
            h();
        }
    }

    private void a(TPAudioAttributes tPAudioAttributes) {
        if (tPAudioAttributes != null) {
            int i11 = Build.VERSION.SDK_INT;
            if (i11 >= 21) {
                this.C.setAudioAttributes(this.f48774s.toAndroidMediaAudioAttributes());
                com.tencent.thumbplayer.tcmedia.e.a aVar = this.f48747a;
                aVar.c("set audio attributes into MediaPlayer, API:" + i11 + ">=21, " + this.f48774s.toString());
                return;
            }
            int usageToAndroidMediaStreamType = TPAudioAttributes.usageToAndroidMediaStreamType(tPAudioAttributes.getUsage());
            this.C.setAudioStreamType(usageToAndroidMediaStreamType);
            com.tencent.thumbplayer.tcmedia.e.a aVar2 = this.f48747a;
            aVar2.c("set audio attributes into MediaPlayer, API:" + i11 + "<21, Usage:" + tPAudioAttributes.getUsage() + "=>StreamType:" + usageToAndroidMediaStreamType);
        }
    }

    private boolean a(C0612e eVar) {
        return eVar == C0612e.PREPARED || eVar == C0612e.STARTED || eVar == C0612e.PAUSED;
    }

    private void b() {
        this.C = a();
        C0612e eVar = C0612e.IDLE;
        this.Q = eVar;
        this.R = eVar;
    }

    private void b(AssetFileDescriptor assetFileDescriptor) {
        if (Build.VERSION.SDK_INT >= 24) {
            this.C.setDataSource(assetFileDescriptor);
        } else {
            this.C.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
        }
    }

    private boolean b(C0612e eVar) {
        return eVar != C0612e.RELEASE;
    }

    private void c() {
        if (a(this.R)) {
            this.R = C0612e.STOPPED;
            this.f48747a.c("MediaPlayer stop.");
            this.C.stop();
        }
    }

    private void d() {
        if (b(this.R)) {
            this.R = C0612e.RELEASE;
            this.f48747a.c("MediaPlayer release.");
            this.C.release();
        }
    }

    private void d(int i11, long j11) {
        f fVar = new f();
        fVar.f48811b = j11;
        fVar.f48813d = i11;
        fVar.f48810a = 2;
        fVar.f48816g = this.f48761f;
        a(fVar);
    }

    /* access modifiers changed from: private */
    public void e() {
        y();
        c();
        d();
    }

    private void e(int i11) {
        if (i11 > 0) {
            b bVar = this.f48751ad.get(i11);
            c.h hVar = this.f48778w;
            if (hVar != null) {
                TPPlayerMsg.TPAudioTrackInfo tPAudioTrackInfo = new TPPlayerMsg.TPAudioTrackInfo();
                tPAudioTrackInfo.audioTrackUrl = bVar.f48794b;
                tPAudioTrackInfo.paramData = bVar.f48795c;
                com.tencent.thumbplayer.tcmedia.e.a aVar = this.f48747a;
                aVar.c("handleDataSource, audioTrack url:" + tPAudioTrackInfo.audioTrackUrl);
                hVar.a(1011, 0, 0, tPAudioTrackInfo);
            }
        }
    }

    private void e(int i11, long j11) {
        this.f48753af.e();
        b bVar = this.f48752ae.get(i11);
        this.f48753af.a(bVar.f48794b, bVar.f48796d, j11);
        this.f48753af.a();
    }

    private int f(int i11) {
        if (2 == i11) {
            return 2;
        }
        if (1 == i11) {
            return 1;
        }
        return 4 == i11 ? 3 : 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void f() {
        /*
            r5 = this;
            r5.A()
            r5.C()
            r5.F()
            r5.e()
            com.tencent.thumbplayer.tcmedia.adapter.a.a.b r0 = new com.tencent.thumbplayer.tcmedia.adapter.a.a.b
            r0.<init>()
            r5.C = r0
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 19
            if (r0 > r1) goto L_0x001e
            android.media.MediaPlayer r1 = r5.C
            r5.a((android.media.MediaPlayer) r1)
        L_0x001e:
            android.media.MediaPlayer r1 = r5.C
            com.tencent.thumbplayer.tcmedia.adapter.a.a.e$d r2 = r5.D
            r1.setOnPreparedListener(r2)
            android.media.MediaPlayer r1 = r5.C
            com.tencent.thumbplayer.tcmedia.adapter.a.a.e$d r2 = r5.D
            r1.setOnCompletionListener(r2)
            android.media.MediaPlayer r1 = r5.C
            com.tencent.thumbplayer.tcmedia.adapter.a.a.e$d r2 = r5.D
            r1.setOnErrorListener(r2)
            android.media.MediaPlayer r1 = r5.C
            com.tencent.thumbplayer.tcmedia.adapter.a.a.e$d r2 = r5.D
            r1.setOnInfoListener(r2)
            android.media.MediaPlayer r1 = r5.C
            com.tencent.thumbplayer.tcmedia.adapter.a.a.e$d r2 = r5.D
            r1.setOnBufferingUpdateListener(r2)
            android.media.MediaPlayer r1 = r5.C
            com.tencent.thumbplayer.tcmedia.adapter.a.a.e$d r2 = r5.D
            r1.setOnSeekCompleteListener(r2)
            android.media.MediaPlayer r1 = r5.C
            com.tencent.thumbplayer.tcmedia.adapter.a.a.e$d r2 = r5.D
            r1.setOnVideoSizeChangedListener(r2)
            r1 = 16
            if (r0 < r1) goto L_0x005a
            android.media.MediaPlayer r0 = r5.C
            android.media.MediaPlayer$OnTimedTextListener r1 = r5.f48756ai
            r0.setOnTimedTextListener(r1)
        L_0x005a:
            boolean r0 = r5.f48764i
            if (r0 == 0) goto L_0x0065
            android.media.MediaPlayer r0 = r5.C
            r1 = 0
        L_0x0061:
            r0.setVolume(r1, r1)
            goto L_0x0072
        L_0x0065:
            float r0 = r5.f48765j
            r1 = 1065353216(0x3f800000, float:1.0)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x0072
            android.media.MediaPlayer r0 = r5.C
            float r1 = r5.f48765j
            goto L_0x0061
        L_0x0072:
            float r0 = r5.f48766k
            double r1 = (double) r0
            r3 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 == 0) goto L_0x007e
            r5.b((float) r0)
        L_0x007e:
            boolean r0 = r5.f48758c
            if (r0 == 0) goto L_0x0089
            android.media.MediaPlayer r0 = r5.C
            boolean r1 = r5.f48758c
            r0.setLooping(r1)
        L_0x0089:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.thumbplayer.tcmedia.adapter.a.a.e.f():void");
    }

    private void f(int i11, long j11) {
        com.tencent.thumbplayer.tcmedia.e.a aVar = this.f48747a;
        aVar.c("deselectSubTrack, trackIndex:" + i11 + ", opaque:" + j11);
        this.f48753af.e();
    }

    /* access modifiers changed from: private */
    public static int g(int i11) {
        long j11 = (long) i11;
        long j12 = i11 < 0 ? 10000000 - j11 : 10000000 + j11;
        if (j12 >= 2147483647L) {
            j12 = 2147483647L;
        }
        return (int) j12;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0150, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void w() {
        /*
            r10 = this;
            monitor-enter(r10)
            com.tencent.thumbplayer.tcmedia.adapter.a.a.e$f r0 = r10.f48755ah     // Catch:{ all -> 0x0151 }
            com.tencent.thumbplayer.tcmedia.e.a r1 = r10.f48747a     // Catch:{ all -> 0x0151 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0151 }
            java.lang.String r3 = "playerResetEnd, actionInfo:"
            r2.<init>(r3)     // Catch:{ all -> 0x0151 }
            r2.append(r0)     // Catch:{ all -> 0x0151 }
            java.lang.String r3 = ", mSuspend:"
            r2.append(r3)     // Catch:{ all -> 0x0151 }
            boolean r3 = r10.S     // Catch:{ all -> 0x0151 }
            r2.append(r3)     // Catch:{ all -> 0x0151 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0151 }
            r1.c(r2)     // Catch:{ all -> 0x0151 }
            if (r0 == 0) goto L_0x0119
            boolean r1 = r10.S     // Catch:{ all -> 0x0151 }
            if (r1 == 0) goto L_0x0119
            com.tencent.thumbplayer.tcmedia.adapter.a.c$h r2 = r10.f48778w     // Catch:{ all -> 0x0151 }
            int r1 = r0.f48810a     // Catch:{ all -> 0x0151 }
            r3 = 1
            if (r1 != r3) goto L_0x002f
            r1 = 3
            goto L_0x0030
        L_0x002f:
            r1 = 4
        L_0x0030:
            r3 = r1
            if (r2 == 0) goto L_0x0040
            r4 = 1000(0x3e8, double:4.94E-321)
            r6 = 0
            long r8 = r0.f48811b     // Catch:{ all -> 0x0151 }
            java.lang.Long r8 = java.lang.Long.valueOf(r8)     // Catch:{ all -> 0x0151 }
            r2.a(r3, r4, r6, r8)     // Catch:{ all -> 0x0151 }
        L_0x0040:
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0151 }
            r2 = 16
            if (r1 < r2) goto L_0x005c
            int r1 = r0.f48814e     // Catch:{ all -> 0x0151 }
            if (r1 <= 0) goto L_0x0051
            android.media.MediaPlayer r1 = r10.C     // Catch:{ all -> 0x0151 }
            int r2 = r0.f48814e     // Catch:{ all -> 0x0151 }
            r1.selectTrack(r2)     // Catch:{ all -> 0x0151 }
        L_0x0051:
            int r1 = r0.f48815f     // Catch:{ all -> 0x0151 }
            if (r1 <= 0) goto L_0x005c
            android.media.MediaPlayer r1 = r10.C     // Catch:{ all -> 0x0151 }
            int r2 = r0.f48815f     // Catch:{ all -> 0x0151 }
            r1.selectTrack(r2)     // Catch:{ all -> 0x0151 }
        L_0x005c:
            long r1 = r0.f48812c     // Catch:{ all -> 0x0151 }
            r3 = 0
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 <= 0) goto L_0x008c
            boolean r1 = r10.P     // Catch:{ all -> 0x0151 }
            if (r1 != 0) goto L_0x008c
            com.tencent.thumbplayer.tcmedia.e.a r1 = r10.f48747a     // Catch:{ all -> 0x0151 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0151 }
            java.lang.String r3 = "playerResetEnd, onPrepared(), and seek to:"
            r2.<init>(r3)     // Catch:{ all -> 0x0151 }
            long r3 = r0.f48812c     // Catch:{ all -> 0x0151 }
            r2.append(r3)     // Catch:{ all -> 0x0151 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0151 }
            r1.c(r2)     // Catch:{ all -> 0x0151 }
            android.media.MediaPlayer r1 = r10.C     // Catch:{ Exception -> 0x0086 }
            long r2 = r0.f48812c     // Catch:{ Exception -> 0x0086 }
            int r2 = (int) r2     // Catch:{ Exception -> 0x0086 }
            r1.seekTo(r2)     // Catch:{ Exception -> 0x0086 }
            goto L_0x008c
        L_0x0086:
            r1 = move-exception
            com.tencent.thumbplayer.tcmedia.e.a r2 = r10.f48747a     // Catch:{ all -> 0x0151 }
            r2.a((java.lang.Exception) r1)     // Catch:{ all -> 0x0151 }
        L_0x008c:
            com.tencent.thumbplayer.tcmedia.e.a r1 = r10.f48747a     // Catch:{ all -> 0x0151 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0151 }
            java.lang.String r3 = "playerResetEnd, restore state:"
            r2.<init>(r3)     // Catch:{ all -> 0x0151 }
            com.tencent.thumbplayer.tcmedia.adapter.a.a.e$e r3 = r0.f48817h     // Catch:{ all -> 0x0151 }
            r2.append(r3)     // Catch:{ all -> 0x0151 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0151 }
            r1.c(r2)     // Catch:{ all -> 0x0151 }
            com.tencent.thumbplayer.tcmedia.adapter.a.a.e$e r1 = r0.f48817h     // Catch:{ all -> 0x0151 }
            com.tencent.thumbplayer.tcmedia.adapter.a.a.e$e r2 = com.tencent.thumbplayer.tcmedia.adapter.a.a.e.C0612e.IDLE     // Catch:{ all -> 0x0151 }
            if (r1 == r2) goto L_0x0106
            com.tencent.thumbplayer.tcmedia.adapter.a.a.e$e r2 = com.tencent.thumbplayer.tcmedia.adapter.a.a.e.C0612e.INITIALIZED     // Catch:{ all -> 0x0151 }
            if (r1 == r2) goto L_0x0106
            com.tencent.thumbplayer.tcmedia.adapter.a.a.e$e r2 = com.tencent.thumbplayer.tcmedia.adapter.a.a.e.C0612e.PREPARING     // Catch:{ all -> 0x0151 }
            if (r1 != r2) goto L_0x00b0
            goto L_0x0106
        L_0x00b0:
            com.tencent.thumbplayer.tcmedia.adapter.a.a.e$e r2 = com.tencent.thumbplayer.tcmedia.adapter.a.a.e.C0612e.PREPARED     // Catch:{ all -> 0x0151 }
            if (r1 == r2) goto L_0x0103
            com.tencent.thumbplayer.tcmedia.adapter.a.a.e$e r2 = com.tencent.thumbplayer.tcmedia.adapter.a.a.e.C0612e.PAUSED     // Catch:{ all -> 0x0151 }
            if (r1 != r2) goto L_0x00b9
            goto L_0x0103
        L_0x00b9:
            com.tencent.thumbplayer.tcmedia.adapter.a.a.e$e r2 = com.tencent.thumbplayer.tcmedia.adapter.a.a.e.C0612e.STARTED     // Catch:{ all -> 0x0151 }
            if (r1 != r2) goto L_0x00d3
            com.tencent.thumbplayer.tcmedia.e.a r1 = r10.f48747a     // Catch:{ all -> 0x0151 }
            java.lang.String r3 = "playerResetEnd,  MediaPlayer.start()."
            r1.c(r3)     // Catch:{ all -> 0x0151 }
            android.media.MediaPlayer r1 = r10.C     // Catch:{ all -> 0x0151 }
            r1.start()     // Catch:{ all -> 0x0151 }
            com.tencent.thumbplayer.tcmedia.adapter.a.a.e$e r0 = r0.f48817h     // Catch:{ all -> 0x0151 }
            r10.Q = r0     // Catch:{ all -> 0x0151 }
            r10.R = r2     // Catch:{ all -> 0x0151 }
            r10.B()     // Catch:{ all -> 0x0151 }
            goto L_0x0111
        L_0x00d3:
            com.tencent.thumbplayer.tcmedia.e.a r1 = r10.f48747a     // Catch:{ all -> 0x0151 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0151 }
            java.lang.String r3 = "illegal state, state:"
            r2.<init>(r3)     // Catch:{ all -> 0x0151 }
            com.tencent.thumbplayer.tcmedia.adapter.a.a.e$e r0 = r0.f48817h     // Catch:{ all -> 0x0151 }
            r2.append(r0)     // Catch:{ all -> 0x0151 }
            java.lang.String r0 = r2.toString()     // Catch:{ all -> 0x0151 }
            r1.e(r0)     // Catch:{ all -> 0x0151 }
            com.tencent.thumbplayer.tcmedia.adapter.a.a.e$e r0 = com.tencent.thumbplayer.tcmedia.adapter.a.a.e.C0612e.ERROR     // Catch:{ all -> 0x0151 }
            r10.Q = r0     // Catch:{ all -> 0x0151 }
            r10.e()     // Catch:{ all -> 0x0151 }
            com.tencent.thumbplayer.tcmedia.adapter.a.c$f r1 = r10.f48779x     // Catch:{ all -> 0x0151 }
            if (r1 == 0) goto L_0x0111
            r2 = 2000(0x7d0, float:2.803E-42)
            r0 = -10004(0xffffffffffffd8ec, float:NaN)
            int r3 = g((int) r0)     // Catch:{ all -> 0x0151 }
            r4 = 0
            r6 = 0
            r1.a(r2, r3, r4, r6)     // Catch:{ all -> 0x0151 }
            goto L_0x0111
        L_0x0103:
            r10.Q = r1     // Catch:{ all -> 0x0151 }
            goto L_0x0111
        L_0x0106:
            com.tencent.thumbplayer.tcmedia.adapter.a.a.e$e r0 = com.tencent.thumbplayer.tcmedia.adapter.a.a.e.C0612e.PREPARED     // Catch:{ all -> 0x0151 }
            r10.Q = r0     // Catch:{ all -> 0x0151 }
            com.tencent.thumbplayer.tcmedia.adapter.a.c$i r0 = r10.f48776u     // Catch:{ all -> 0x0151 }
            if (r0 == 0) goto L_0x0111
            r0.a()     // Catch:{ all -> 0x0151 }
        L_0x0111:
            r0 = 0
            r10.S = r0     // Catch:{ all -> 0x0151 }
            r0 = 0
            r10.f48755ah = r0     // Catch:{ all -> 0x0151 }
            monitor-exit(r10)
            return
        L_0x0119:
            int r0 = r10.f48768m     // Catch:{ all -> 0x0151 }
            if (r0 <= 0) goto L_0x0144
            boolean r0 = r10.P     // Catch:{ all -> 0x0151 }
            if (r0 != 0) goto L_0x0144
            com.tencent.thumbplayer.tcmedia.e.a r0 = r10.f48747a     // Catch:{ all -> 0x0151 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0151 }
            java.lang.String r2 = "onPrepared(), and seekto:"
            r1.<init>(r2)     // Catch:{ all -> 0x0151 }
            int r2 = r10.f48768m     // Catch:{ all -> 0x0151 }
            r1.append(r2)     // Catch:{ all -> 0x0151 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0151 }
            r0.c(r1)     // Catch:{ all -> 0x0151 }
            android.media.MediaPlayer r0 = r10.C     // Catch:{ Exception -> 0x013e }
            int r1 = r10.f48768m     // Catch:{ Exception -> 0x013e }
            r0.seekTo(r1)     // Catch:{ Exception -> 0x013e }
            goto L_0x0144
        L_0x013e:
            r0 = move-exception
            com.tencent.thumbplayer.tcmedia.e.a r1 = r10.f48747a     // Catch:{ all -> 0x0151 }
            r1.a((java.lang.Exception) r0)     // Catch:{ all -> 0x0151 }
        L_0x0144:
            com.tencent.thumbplayer.tcmedia.adapter.a.a.e$e r0 = com.tencent.thumbplayer.tcmedia.adapter.a.a.e.C0612e.PREPARED     // Catch:{ all -> 0x0151 }
            r10.Q = r0     // Catch:{ all -> 0x0151 }
            com.tencent.thumbplayer.tcmedia.adapter.a.c$i r0 = r10.f48776u     // Catch:{ all -> 0x0151 }
            if (r0 == 0) goto L_0x014f
            r0.a()     // Catch:{ all -> 0x0151 }
        L_0x014f:
            monitor-exit(r10)
            return
        L_0x0151:
            r0 = move-exception
            monitor-exit(r10)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.thumbplayer.tcmedia.adapter.a.a.e.w():void");
    }

    private void x() {
        a(this.f48774s);
    }

    private void y() {
        this.C.setOnPreparedListener((MediaPlayer.OnPreparedListener) null);
        this.C.setOnCompletionListener((MediaPlayer.OnCompletionListener) null);
        this.C.setOnErrorListener((MediaPlayer.OnErrorListener) null);
        this.C.setOnInfoListener((MediaPlayer.OnInfoListener) null);
        this.C.setOnBufferingUpdateListener((MediaPlayer.OnBufferingUpdateListener) null);
        this.C.setOnSeekCompleteListener((MediaPlayer.OnSeekCompleteListener) null);
        this.C.setOnVideoSizeChangedListener((MediaPlayer.OnVideoSizeChangedListener) null);
    }

    private void z() {
        this.f48747a.c("startCheckPrepareTimeoutTimer");
        synchronized (this.H) {
            if (this.G == null) {
                this.G = o.a().e().schedule(new Runnable() {
                    public void run() {
                        if (e.this.Q == C0612e.PREPARING) {
                            e.this.f48747a.e("startCheckPrepareTimeoutTimer, post error");
                            C0612e unused = e.this.Q = C0612e.ERROR;
                            e.this.e();
                            e.this.A();
                            c.f i11 = e.this.f48779x;
                            if (i11 != null) {
                                i11.a(2001, e.g(-110), 0, 0);
                            }
                        }
                    }
                }, this.I, TimeUnit.MILLISECONDS);
            }
        }
    }

    public void a(float f11) {
        this.f48747a.c("setAudioGainRatio, : ".concat(String.valueOf(f11)));
        this.f48765j = f11;
        try {
            if (this.C != null) {
                MediaPlayer mediaPlayer = this.C;
                float f12 = this.f48765j;
                mediaPlayer.setVolume(f12, f12);
            }
        } catch (IllegalStateException e11) {
            com.tencent.thumbplayer.tcmedia.e.a aVar = this.f48747a;
            aVar.c("setAudioGainRatio ex : " + e11.toString());
        }
    }

    public void a(int i11) {
        this.f48747a.c("seekTo, position: ".concat(String.valueOf(i11)));
        if (this.P) {
            this.f48747a.c("current media is not seekable, ignore");
        } else if (this.S) {
            f fVar = this.f48755ah;
            if (fVar != null) {
                fVar.f48812c = (long) i11;
            }
        } else {
            if (this.R == C0612e.COMPLETE) {
                this.Q = C0612e.STARTED;
            }
            this.C.seekTo(i11);
        }
    }

    public void a(int i11, @TPCommonEnum.TPSeekMode int i12) {
        com.tencent.thumbplayer.tcmedia.e.a aVar = this.f48747a;
        aVar.c("seekTo, position: " + i11 + ", mode: " + i12);
        if (this.P) {
            this.f48747a.c("current media is not seekable, ignore");
        } else if (this.S) {
            f fVar = this.f48755ah;
            if (fVar != null) {
                fVar.f48812c = (long) i11;
            }
        } else {
            a(this.C, i11, i12);
        }
    }

    public void a(int i11, long j11) {
        com.tencent.thumbplayer.tcmedia.e.a aVar = this.f48747a;
        aVar.c("selectTrack, trackID:" + i11 + ", opaque:" + j11);
        int size = this.f48751ad.size();
        int size2 = this.f48752ae.size();
        this.f48751ad.size();
        c.h hVar = this.f48778w;
        if (i11 >= 0 && i11 < size) {
            try {
                d(i11, j11);
                this.f48751ad.get(this.f48748aa).f48793a.isSelected = false;
                this.f48751ad.get(i11).f48793a.isSelected = true;
                this.f48748aa = i11;
            } catch (Exception e11) {
                this.f48747a.a(e11);
                if (hVar != null) {
                    hVar.a(4, 2000, (long) g((int) BaseConstants.ERR_SVR_SSO_VCODE), Long.valueOf(j11));
                }
            }
        } else if (i11 < size || i11 >= size + size2) {
            int i12 = i11 - (size + size2);
            if (Build.VERSION.SDK_INT < 16) {
                this.f48747a.e("selectTrack, android mediaplayer not support ");
                if (hVar != null) {
                    hVar.a(4, 2000, (long) g((int) BaseConstants.ERR_SVR_SSO_D2_EXPIRED), Long.valueOf(j11));
                }
            } else if (this.Q == C0612e.PREPARED || this.Q == C0612e.STARTED || this.Q == C0612e.PAUSED) {
                MediaPlayer.TrackInfo[] trackInfoArr = null;
                try {
                    trackInfoArr = this.C.getTrackInfo();
                } catch (Exception unused) {
                    this.f48747a.e("getTrackInfo, android getTrackInfo crash");
                }
                if (trackInfoArr != null && trackInfoArr.length > i12) {
                    MediaPlayer.TrackInfo trackInfo = trackInfoArr[i12];
                    if (trackInfo.getTrackType() == 2) {
                        this.f48750ac = i12;
                    } else if (trackInfo.getTrackType() == 4) {
                        this.Z = i12;
                    } else if (hVar != null) {
                        hVar.a(4, 2000, (long) g((int) BaseConstants.ERR_SVR_SSO_A2_UP_INVALID), Long.valueOf(j11));
                        return;
                    } else {
                        return;
                    }
                    this.C.selectTrack(i12);
                    if (hVar != null) {
                        hVar.a(4, 1000, 0, Long.valueOf(j11));
                    }
                } else if (hVar != null) {
                    hVar.a(4, 2000, (long) g(-10002), Long.valueOf(j11));
                }
            } else {
                com.tencent.thumbplayer.tcmedia.e.a aVar2 = this.f48747a;
                aVar2.e("selectTrack, illegal state:" + this.Q);
            }
        } else {
            int i13 = i11 - size;
            try {
                e(i13, j11);
            } catch (Exception e12) {
                this.f48747a.a(e12);
                if (hVar != null) {
                    hVar.a(4, 2000, (long) g((int) BaseConstants.ERR_SVR_SSO_VCODE), Long.valueOf(j11));
                }
            }
            int i14 = this.f48749ab;
            if (i14 >= 0 && i14 < size2) {
                this.f48752ae.get(i14).f48793a.isSelected = false;
            }
            this.f48752ae.get(i13).f48793a.isSelected = true;
            this.f48749ab = i11;
        }
    }

    public void a(AssetFileDescriptor assetFileDescriptor) {
        if (assetFileDescriptor != null) {
            com.tencent.thumbplayer.tcmedia.e.a aVar = this.f48747a;
            aVar.c("setDataSource afd， afd: " + assetFileDescriptor.toString());
            this.f48763h = assetFileDescriptor;
            b(assetFileDescriptor);
            this.E = new com.tencent.thumbplayer.tcmedia.a.c(assetFileDescriptor);
            C0612e eVar = C0612e.INITIALIZED;
            this.Q = eVar;
            this.R = eVar;
            return;
        }
        this.f48747a.c("setDataSource afd is null ");
        throw new IllegalArgumentException("afd is null");
    }

    public void a(ParcelFileDescriptor parcelFileDescriptor) {
        if (parcelFileDescriptor != null) {
            com.tencent.thumbplayer.tcmedia.e.a aVar = this.f48747a;
            aVar.c("setDataSource pfd， pfd: " + parcelFileDescriptor.toString());
            this.f48762g = parcelFileDescriptor.getFileDescriptor();
            this.C.setDataSource(parcelFileDescriptor.getFileDescriptor());
            this.E = new com.tencent.thumbplayer.tcmedia.a.c(parcelFileDescriptor.getFileDescriptor());
            C0612e eVar = C0612e.INITIALIZED;
            this.Q = eVar;
            this.R = eVar;
            return;
        }
        this.f48747a.c("setDataSource pfd is null ");
        throw new IllegalArgumentException("pfd is null");
    }

    public void a(Surface surface) {
        this.f48747a.c("setSurface, surface: ".concat(String.valueOf(surface)));
        this.F = surface;
        this.C.setSurface(surface);
        this.f48747a.c("setSurface over, surface: ".concat(String.valueOf(surface)));
    }

    public void a(SurfaceHolder surfaceHolder) {
        this.f48747a.c("setSurfaceHolder, sh: ".concat(String.valueOf(surfaceHolder)));
        this.F = surfaceHolder;
        this.C.setDisplay(surfaceHolder);
        this.f48747a.c("setSurfaceHolder over, sh: ".concat(String.valueOf(surfaceHolder)));
    }

    public void a(c.a aVar) {
        throw new IllegalStateException("system Mediaplayer cannot support audio frame out");
    }

    public void a(c.b bVar) {
        throw new IllegalStateException("system Mediaplayer cannot support audio postprocess frame out");
    }

    public void a(c.C0614c cVar) {
        this.f48777v = cVar;
    }

    public void a(c.d dVar) {
    }

    public void a(c.e eVar) {
    }

    public void a(c.f fVar) {
        this.f48779x = fVar;
    }

    public void a(c.g gVar) {
    }

    public void a(c.h hVar) {
        this.f48778w = hVar;
    }

    public void a(c.i iVar) {
        this.f48776u = iVar;
    }

    public void a(c.j jVar) {
        this.f48780y = jVar;
    }

    public void a(c.l lVar) {
        this.A = lVar;
    }

    public void a(c.m mVar) {
        this.B = mVar;
    }

    public void a(c.n nVar) {
        throw new IllegalStateException("system Mediaplayer cannot support video frame out");
    }

    public void a(c.o oVar) {
        throw new IllegalStateException("system Mediaplayer cannot support video postprocess frame out");
    }

    public void a(c.p pVar) {
        this.f48781z = pVar;
    }

    public void a(TPCaptureParams tPCaptureParams, TPCaptureCallBack tPCaptureCallBack) {
        if (this.E != null) {
            TPImageGeneratorParams tPImageGeneratorParams = new TPImageGeneratorParams();
            tPImageGeneratorParams.width = tPCaptureParams.width;
            tPImageGeneratorParams.height = tPCaptureParams.height;
            tPImageGeneratorParams.format = tPCaptureParams.format;
            tPImageGeneratorParams.requestedTimeMsToleranceBefore = tPCaptureParams.requestedTimeMsToleranceBefore;
            tPImageGeneratorParams.requestedTimeMsToleranceAfter = tPCaptureParams.requestedTimeMsToleranceAfter;
            this.E.a(o(), tPImageGeneratorParams, tPCaptureCallBack);
            return;
        }
        tPCaptureCallBack.onCaptureVideoFailed(TPGeneralError.UNMATCHED_STATE);
    }

    public void a(TPOptionalParam tPOptionalParam) {
        int key = tPOptionalParam.getKey();
        if (key == 1) {
            this.f48771p = tPOptionalParam.getParamLong().value;
        } else if (key == 2) {
            this.f48773r = (int) tPOptionalParam.getParamLong().value;
            com.tencent.thumbplayer.tcmedia.e.a aVar = this.f48747a;
            aVar.c("setPlayerOptionalParam, video width:" + this.f48773r);
        } else if (key == 3) {
            this.f48772q = (int) tPOptionalParam.getParamLong().value;
            com.tencent.thumbplayer.tcmedia.e.a aVar2 = this.f48747a;
            aVar2.c("setPlayerOptionalParam, video height:" + this.f48772q);
        } else if (key == 4) {
            this.f48770o = tPOptionalParam.getParamBoolean().value;
            this.P = true;
            com.tencent.thumbplayer.tcmedia.e.a aVar3 = this.f48747a;
            aVar3.c("setPlayerOptionalParam, is live:" + this.f48770o);
        } else if (key == 5) {
            this.f48775t = tPOptionalParam.getParamBoolean().value;
        } else if (key == 7) {
            this.L = (int) (tPOptionalParam.getParamLong().value / 400);
            com.tencent.thumbplayer.tcmedia.e.a aVar4 = this.f48747a;
            aVar4.c("setPlayerOptionalParam, on buffer timeout:" + tPOptionalParam.getParamLong().value + "(ms)");
        } else if (key == 100) {
            this.f48768m = (int) tPOptionalParam.getParamLong().value;
            com.tencent.thumbplayer.tcmedia.e.a aVar5 = this.f48747a;
            aVar5.c("setPlayerOptionalParam, start position:" + this.f48768m);
        } else if (key == 107) {
            this.M = (int) ((tPOptionalParam.getParamLong().value + 400) / 400);
            com.tencent.thumbplayer.tcmedia.e.a aVar6 = this.f48747a;
            aVar6.c("setPlayerOptionalParam, buffer timeout:" + tPOptionalParam.getParamLong().value + "(ms)");
        } else if (key == 128) {
            this.I = tPOptionalParam.getParamLong().value;
            com.tencent.thumbplayer.tcmedia.e.a aVar7 = this.f48747a;
            aVar7.c("setPlayerOptionalParam, prepare timeout:" + this.I + "(ms)");
        } else if (key == 414) {
            this.f48774s = (TPAudioAttributes) tPOptionalParam.getParamObject().objectValue;
            com.tencent.thumbplayer.tcmedia.e.a aVar8 = this.f48747a;
            aVar8.c("setPlayerOptionalParam, " + this.f48774s.toString());
        } else if (key == 450) {
            int i11 = (int) tPOptionalParam.getParamLong().value;
            a aVar9 = this.f48753af;
            if (aVar9 != null) {
                aVar9.a(i11);
            }
            TPLogUtil.i("TPSystemMediaPlayer", "setPlayerOptionalParam, subtitle type:" + tPOptionalParam.getParamLong().value);
        } else if (key == 500) {
            this.f48769n = tPOptionalParam.getParamLong().value;
            com.tencent.thumbplayer.tcmedia.e.a aVar10 = this.f48747a;
            aVar10.c("setPlayerOptionalParam, skip end position:" + this.f48769n);
        } else if (key == 507) {
            TPSubtitleRenderModel tPSubtitleRenderModel = (TPSubtitleRenderModel) tPOptionalParam.getParamObject().objectValue;
            a aVar11 = this.f48753af;
            if (aVar11 != null) {
                aVar11.a(tPSubtitleRenderModel);
            }
            TPLogUtil.i("TPSystemMediaPlayer", "setPlayerOptionalParam, subtitle render model");
        }
    }

    public void a(ITPMediaAsset iTPMediaAsset) {
        throw new IllegalArgumentException("setDataSource by asset, android mediaplayer not support");
    }

    public void a(ITPMediaAsset iTPMediaAsset, @TPCommonEnum.TPSwitchDefMode int i11, long j11) {
    }

    public void a(com.tencent.thumbplayer.tcmedia.e.b bVar) {
        this.f48747a.a(new com.tencent.thumbplayer.tcmedia.e.b(bVar, "TPSystemMediaPlayer"));
    }

    public void a(String str) {
        this.f48747a.c("setAudioNormalizeVolumeParams not supported.");
    }

    public void a(String str, @TPCommonEnum.TPSwitchDefMode int i11, long j11) {
        this.f48747a.c("switchDefinition, defUrl: ".concat(String.valueOf(str)));
        if (TextUtils.isEmpty(str)) {
            this.f48747a.c("switchDefinition, defUrl is null");
            return;
        }
        this.f48761f = str;
        f fVar = new f();
        fVar.f48811b = j11;
        fVar.f48813d = this.f48748aa;
        fVar.f48810a = 1;
        fVar.f48816g = str;
        try {
            a(fVar);
        } catch (Exception unused) {
            throw new IllegalStateException("playerResetStart");
        }
    }

    public void a(String str, Map<String, String> map) {
        this.f48747a.c("setDataSource httpHeader, url: ".concat(String.valueOf(str)));
        this.f48761f = str;
        this.f48767l = map;
        this.C.setDataSource(this.f48757b, Uri.parse(str), this.f48767l);
        this.E = new com.tencent.thumbplayer.tcmedia.a.c(str);
        C0612e eVar = C0612e.INITIALIZED;
        this.Q = eVar;
        this.R = eVar;
    }

    public void a(String str, Map<String, String> map, @TPCommonEnum.TPSwitchDefMode int i11, long j11) {
        this.f48747a.c("switchDefinition, defUrl: ".concat(String.valueOf(str)));
        if (TextUtils.isEmpty(str)) {
            this.f48747a.c("switchDefinition, defUrl is null");
            return;
        }
        this.f48761f = str;
        f fVar = new f();
        fVar.f48811b = j11;
        fVar.f48813d = this.f48748aa;
        fVar.f48810a = 1;
        fVar.f48816g = str;
        try {
            a(fVar);
        } catch (Exception unused) {
            throw new IllegalStateException("playerResetStart");
        }
    }

    public void a(String str, Map<String, String> map, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str3)) {
            this.f48747a.e("addSubtitleSource, illegal argument.");
            return;
        }
        TPTrackInfo tPTrackInfo = new TPTrackInfo();
        tPTrackInfo.name = str3;
        tPTrackInfo.isExclusive = true;
        tPTrackInfo.isInternal = false;
        tPTrackInfo.isSelected = false;
        tPTrackInfo.trackType = 3;
        b bVar = new b();
        bVar.f48793a = tPTrackInfo;
        bVar.f48794b = str;
        bVar.f48796d = map;
        com.tencent.thumbplayer.tcmedia.e.a aVar = this.f48747a;
        aVar.c("addSubtitleSource, name:" + tPTrackInfo.name + ", url:" + str3);
        this.f48752ae.add(bVar);
    }

    public void a(String str, Map<String, String> map, String str2, List<TPOptionalParam> list) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            this.f48747a.e("addAudioTrackSource, illegal argument.");
            return;
        }
        TPTrackInfo tPTrackInfo = new TPTrackInfo();
        tPTrackInfo.name = str2;
        tPTrackInfo.isExclusive = true;
        tPTrackInfo.isInternal = false;
        tPTrackInfo.isSelected = false;
        tPTrackInfo.trackType = 2;
        b bVar = new b();
        bVar.f48793a = tPTrackInfo;
        bVar.f48794b = str;
        bVar.f48796d = map;
        bVar.f48795c = list;
        com.tencent.thumbplayer.tcmedia.e.a aVar = this.f48747a;
        aVar.c("addAudioTrackSource, name:" + tPTrackInfo.name + ", url:" + str2);
        this.f48751ad.add(bVar);
    }

    public void a(boolean z11) {
        this.f48747a.c("setOutputMute, : ".concat(String.valueOf(z11)));
        this.f48764i = z11;
        if (z11) {
            try {
                this.C.setVolume(0.0f, 0.0f);
                this.f48747a.c("setOutputMute, true");
            } catch (Exception e11) {
                com.tencent.thumbplayer.tcmedia.e.a aVar = this.f48747a;
                aVar.c("setOutputMute, Exception: " + e11.toString());
            }
        } else {
            MediaPlayer mediaPlayer = this.C;
            float f11 = this.f48765j;
            mediaPlayer.setVolume(f11, f11);
            com.tencent.thumbplayer.tcmedia.e.a aVar2 = this.f48747a;
            aVar2.c("setOutputMute, false, mAudioGain: " + this.f48765j);
        }
    }

    public void a(boolean z11, long j11, long j12) {
        com.tencent.thumbplayer.tcmedia.e.a aVar = this.f48747a;
        aVar.c("setLoopback, : " + z11 + ", loopStart: " + j11 + ", loopEnd: " + j12);
        if (j11 >= 0) {
            long j13 = this.T;
            if (j11 <= j13 && j12 <= j13) {
                this.f48758c = z11;
                this.f48759d = j11;
                this.f48760e = j12;
                this.C.setLooping(z11);
                return;
            }
        }
        throw new IllegalArgumentException("position error, must more than 0 and less than duration");
    }

    public long b(int i11) {
        return -1;
    }

    public void b(float f11) {
        this.f48747a.c("setPlaySpeedRatio, : ".concat(String.valueOf(f11)));
        int i11 = Build.VERSION.SDK_INT;
        if (i11 < 23) {
            com.tencent.thumbplayer.tcmedia.e.a aVar = this.f48747a;
            aVar.c("os version is too low: " + i11);
            return;
        }
        this.f48766k = f11;
        this.f48747a.c("setPlaySpeedRatio play speed:".concat(String.valueOf(f11)));
        try {
            PlaybackParams playbackParams = this.C.getPlaybackParams();
            if (playbackParams.getSpeed() != f11) {
                playbackParams.setSpeed(f11);
                this.C.setPlaybackParams(playbackParams);
            }
        } catch (Exception e11) {
            this.f48747a.a(e11);
        }
    }

    public void b(int i11, long j11) {
        this.f48747a.c("deselectTrack, trackID ".concat(String.valueOf(i11)));
        int size = this.f48751ad.size();
        int size2 = this.f48752ae.size();
        if (i11 >= size && i11 < size2 + size) {
            int i12 = i11 - size;
            try {
                f(i12, j11);
            } catch (Exception e11) {
                this.f48747a.a(e11);
            }
            this.f48752ae.get(i12).f48793a.isSelected = false;
            this.f48749ab = -1;
        } else if (Build.VERSION.SDK_INT < 16) {
            this.f48747a.e("deselectTrack, android mediaplayer not support ");
        } else {
            this.C.deselectTrack(i11);
        }
    }

    public void b(boolean z11) {
        this.f48747a.c("setLoopback, : ".concat(String.valueOf(z11)));
        this.f48758c = z11;
        this.C.setLooping(z11);
    }

    public TPDynamicStatisticParams c(boolean z11) {
        return null;
    }

    public String c(int i11) {
        return null;
    }

    public void c(int i11, long j11) {
        this.f48747a.e("selectProgram, android mediaplayer not support");
    }

    public void g() {
        if (this.R == C0612e.COMPLETE) {
            this.f48747a.d("call prepare() on mMediaPlayerState==COMPLETE");
            return;
        }
        x();
        this.f48747a.c("prepare ");
        C0612e eVar = C0612e.PREPARING;
        this.Q = eVar;
        this.R = eVar;
        this.C.prepare();
    }

    public void h() {
        x();
        this.f48747a.c("prepareAsync ");
        C0612e eVar = C0612e.PREPARING;
        this.Q = eVar;
        this.R = eVar;
        this.C.prepareAsync();
        z();
    }

    public void i() {
        com.tencent.thumbplayer.tcmedia.e.a aVar;
        String str;
        this.f48747a.c("start ");
        if (this.S) {
            f fVar = this.f48755ah;
            if (fVar != null) {
                fVar.f48817h = C0612e.STARTED;
            }
            aVar = this.f48747a;
            str = "system player is busy.";
        } else if (this.Q == C0612e.PREPARED || this.Q == C0612e.PAUSED) {
            a aVar2 = this.f48753af;
            if (aVar2 != null) {
                aVar2.b();
            }
            this.C.start();
            C0612e eVar = C0612e.STARTED;
            this.Q = eVar;
            this.R = eVar;
            float f11 = this.f48766k;
            if (((double) f11) != 1.0d) {
                b(f11);
            }
            B();
            return;
        } else {
            aVar = this.f48747a;
            str = "start(), illegal state, state:" + this.Q;
        }
        aVar.d(str);
    }

    public synchronized void j() {
        this.f48747a.c("pause ");
        if (this.S) {
            f fVar = this.f48755ah;
            if (fVar != null) {
                fVar.f48817h = C0612e.PAUSED;
            }
            this.f48747a.d("system player is busy.");
            return;
        }
        a aVar = this.f48753af;
        if (aVar != null) {
            aVar.c();
        }
        this.C.pause();
        C0612e eVar = C0612e.PAUSED;
        this.Q = eVar;
        this.R = eVar;
    }

    public synchronized void k() {
        this.f48747a.c("stop ");
        A();
        C();
        F();
        this.Q = C0612e.STOPPED;
        c();
        this.f48748aa = 0;
        this.f48749ab = -1;
        this.f48755ah = null;
        this.Z = -1;
        this.f48750ac = -1;
        this.f48753af.d();
        this.f48754ag = 0;
        this.f48747a.c("stop over.");
    }

    public synchronized void l() {
        this.f48747a.c("reset ");
        C0612e eVar = C0612e.IDLE;
        this.Q = eVar;
        this.R = eVar;
        this.f48753af.e();
        this.C.reset();
        this.f48768m = 0;
        this.f48769n = -1;
        this.f48770o = false;
        this.f48771p = -1;
        this.f48772q = -1;
        this.f48773r = -1;
        this.f48774s = null;
        A();
        C();
        F();
        this.f48747a.c("reset over.");
    }

    public synchronized void m() {
        this.f48747a.c("release ");
        this.f48753af.f();
        A();
        C();
        F();
        this.Q = C0612e.RELEASE;
        e();
        this.f48776u = null;
        this.f48777v = null;
        this.f48778w = null;
        this.f48779x = null;
        this.f48780y = null;
        this.f48781z = null;
        this.A = null;
        this.F = null;
        this.f48747a.c("release over.");
    }

    public long n() {
        if (this.f48770o) {
            return 0;
        }
        if (this.S) {
            return this.T;
        }
        if (this.Q != C0612e.PREPARED && this.Q != C0612e.STARTED && this.Q != C0612e.PAUSED) {
            return -1;
        }
        if (this.T <= 0) {
            this.T = (long) this.C.getDuration();
        }
        long j11 = this.f48771p;
        if (j11 > 0) {
            long j12 = this.T;
            if (j12 <= 0) {
                this.T = j11;
            } else {
                long j13 = this.f48771p;
                if ((Math.abs(j11 - j12) * 100) / j13 > 1) {
                    this.T = j13;
                }
            }
        }
        return this.T;
    }

    public long o() {
        int i11;
        if (this.f48770o) {
            return 0;
        }
        if (this.S || this.Q == C0612e.ERROR) {
            long j11 = this.U;
            if (j11 != -1) {
                return j11;
            }
            i11 = this.f48768m;
        } else {
            if (!(this.Q == C0612e.IDLE || this.Q == C0612e.INITIALIZED || this.Q == C0612e.PREPARING || this.Q == C0612e.STOPPED || this.Q == C0612e.PREPARED)) {
                i11 = this.C.getCurrentPosition();
            }
            i11 = this.f48768m;
        }
        return (long) i11;
    }

    public long p() {
        return 0;
    }

    public int q() {
        com.tencent.thumbplayer.tcmedia.e.a aVar = this.f48747a;
        aVar.c("getVideoWidth, width:" + this.V);
        return this.V;
    }

    public int r() {
        com.tencent.thumbplayer.tcmedia.e.a aVar = this.f48747a;
        aVar.c("getVideoHeight, height:" + this.W);
        return this.W;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x003d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.tencent.thumbplayer.tcmedia.api.TPTrackInfo[] s() {
        /*
            r9 = this;
            com.tencent.thumbplayer.tcmedia.adapter.a.a.e$e r0 = r9.Q
            com.tencent.thumbplayer.tcmedia.adapter.a.a.e$e r1 = com.tencent.thumbplayer.tcmedia.adapter.a.a.e.C0612e.PREPARED
            if (r0 == r1) goto L_0x0012
            com.tencent.thumbplayer.tcmedia.adapter.a.a.e$e r0 = r9.Q
            com.tencent.thumbplayer.tcmedia.adapter.a.a.e$e r1 = com.tencent.thumbplayer.tcmedia.adapter.a.a.e.C0612e.STARTED
            if (r0 == r1) goto L_0x0012
            com.tencent.thumbplayer.tcmedia.adapter.a.a.e$e r0 = r9.Q
            com.tencent.thumbplayer.tcmedia.adapter.a.a.e$e r1 = com.tencent.thumbplayer.tcmedia.adapter.a.a.e.C0612e.PAUSED
            if (r0 != r1) goto L_0x0026
        L_0x0012:
            int r0 = com.tencent.thumbplayer.tcmedia.core.common.TPSystemInfo.SDK_INT
            r1 = 16
            if (r0 <= r1) goto L_0x0026
            android.media.MediaPlayer r0 = r9.C     // Catch:{ Exception -> 0x001f }
            android.media.MediaPlayer$TrackInfo[] r0 = r0.getTrackInfo()     // Catch:{ Exception -> 0x001f }
            goto L_0x0027
        L_0x001f:
            com.tencent.thumbplayer.tcmedia.e.a r0 = r9.f48747a
            java.lang.String r1 = "getTrackInfo, android getTrackInfo crash"
            r0.e(r1)
        L_0x0026:
            r0 = 0
        L_0x0027:
            r1 = 0
            if (r0 != 0) goto L_0x003d
            java.util.List<com.tencent.thumbplayer.tcmedia.adapter.a.a.e$b> r2 = r9.f48751ad
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x003d
            java.util.List<com.tencent.thumbplayer.tcmedia.adapter.a.a.e$b> r2 = r9.f48752ae
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x003d
            com.tencent.thumbplayer.tcmedia.api.TPTrackInfo[] r0 = new com.tencent.thumbplayer.tcmedia.api.TPTrackInfo[r1]
            return r0
        L_0x003d:
            java.util.List<com.tencent.thumbplayer.tcmedia.adapter.a.a.e$b> r2 = r9.f48751ad
            int r2 = r2.size()
            java.util.List<com.tencent.thumbplayer.tcmedia.adapter.a.a.e$b> r3 = r9.f48752ae
            int r3 = r3.size()
            int r2 = r2 + r3
            if (r0 != 0) goto L_0x004e
            r3 = r1
            goto L_0x004f
        L_0x004e:
            int r3 = r0.length
        L_0x004f:
            int r2 = r2 + r3
            com.tencent.thumbplayer.tcmedia.api.TPTrackInfo[] r2 = new com.tencent.thumbplayer.tcmedia.api.TPTrackInfo[r2]
            java.util.List<com.tencent.thumbplayer.tcmedia.adapter.a.a.e$b> r3 = r9.f48751ad
            java.util.Iterator r3 = r3.iterator()
            r4 = r1
        L_0x0059:
            boolean r5 = r3.hasNext()
            if (r5 == 0) goto L_0x006d
            java.lang.Object r5 = r3.next()
            com.tencent.thumbplayer.tcmedia.adapter.a.a.e$b r5 = (com.tencent.thumbplayer.tcmedia.adapter.a.a.e.b) r5
            int r6 = r4 + 1
            com.tencent.thumbplayer.tcmedia.api.TPTrackInfo r5 = r5.f48793a
            r2[r4] = r5
            r4 = r6
            goto L_0x0059
        L_0x006d:
            java.util.List<com.tencent.thumbplayer.tcmedia.adapter.a.a.e$b> r3 = r9.f48752ae
            java.util.Iterator r3 = r3.iterator()
        L_0x0073:
            boolean r5 = r3.hasNext()
            if (r5 == 0) goto L_0x0087
            java.lang.Object r5 = r3.next()
            com.tencent.thumbplayer.tcmedia.adapter.a.a.e$b r5 = (com.tencent.thumbplayer.tcmedia.adapter.a.a.e.b) r5
            int r6 = r4 + 1
            com.tencent.thumbplayer.tcmedia.api.TPTrackInfo r5 = r5.f48793a
            r2[r4] = r5
            r4 = r6
            goto L_0x0073
        L_0x0087:
            if (r0 == 0) goto L_0x00e0
            int r3 = r0.length
            if (r3 > 0) goto L_0x008d
            goto L_0x00e0
        L_0x008d:
            int r3 = r0.length
        L_0x008e:
            if (r1 >= r3) goto L_0x00e0
            r5 = r0[r1]
            com.tencent.thumbplayer.tcmedia.api.TPTrackInfo r6 = new com.tencent.thumbplayer.tcmedia.api.TPTrackInfo
            r6.<init>()
            java.lang.String r7 = r5.getLanguage()
            r6.name = r7
            int r5 = r5.getTrackType()
            int r5 = r9.f((int) r5)
            r6.trackType = r5
            com.tencent.thumbplayer.tcmedia.e.a r5 = r9.f48747a
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "getTrackInfo index:"
            r7.<init>(r8)
            r7.append(r4)
            java.lang.String r8 = ", type:"
            r7.append(r8)
            int r8 = r6.trackType
            r7.append(r8)
            java.lang.String r8 = ", isselcted:"
            r7.append(r8)
            boolean r8 = r6.isSelected
            r7.append(r8)
            java.lang.String r8 = ", name:"
            r7.append(r8)
            java.lang.String r8 = r6.name
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            r5.c(r7)
            int r5 = r4 + 1
            r2[r4] = r6
            int r1 = r1 + 1
            r4 = r5
            goto L_0x008e
        L_0x00e0:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.thumbplayer.tcmedia.adapter.a.a.e.s():com.tencent.thumbplayer.tcmedia.api.TPTrackInfo[]");
    }

    public TPProgramInfo[] t() {
        return new TPProgramInfo[0];
    }

    public long u() {
        return -1;
    }

    public TPGeneralPlayFlowParams v() {
        return null;
    }
}
