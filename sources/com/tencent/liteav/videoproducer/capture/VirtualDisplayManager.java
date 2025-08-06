package com.tencent.liteav.videoproducer.capture;

import android.content.Context;
import android.content.Intent;
import android.hardware.display.VirtualDisplay;
import android.media.projection.MediaProjection;
import android.os.Handler;
import android.os.Looper;
import android.view.Surface;
import com.tencent.liteav.audio2.SystemLoopbackRecorder2;
import com.tencent.liteav.base.util.CustomHandler;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.l;
import com.tencent.rtmp.video.ScreenCaptureService;
import com.tencent.rtmp.video.TXScreenCapture;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class VirtualDisplayManager {

    /* renamed from: b  reason: collision with root package name */
    private static volatile VirtualDisplayManager f22527b;

    /* renamed from: a  reason: collision with root package name */
    public final l f22528a;

    /* renamed from: c  reason: collision with root package name */
    private final Context f22529c;

    /* renamed from: d  reason: collision with root package name */
    private final Handler f22530d;

    /* renamed from: e  reason: collision with root package name */
    private final Map<Surface, a> f22531e = new HashMap();

    /* renamed from: f  reason: collision with root package name */
    private boolean f22532f = false;

    /* renamed from: g  reason: collision with root package name */
    private MediaProjection f22533g;

    /* renamed from: h  reason: collision with root package name */
    private final Runnable f22534h = f.a(this);

    /* renamed from: i  reason: collision with root package name */
    private final MediaProjection.Callback f22535i = new MediaProjection.Callback() {
        public final void onStop() {
            LiteavLog.e("VirtualDisplayManager", "MediaProjection session is no longer valid");
            VirtualDisplayManager.this.f22528a.a(j.a(VirtualDisplayManager.this));
        }
    };

    public interface VirtualDisplayListener {
        void onCaptureError();

        void onStartFinish(boolean z11, boolean z12);
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public Surface f22537a;

        /* renamed from: b  reason: collision with root package name */
        public int f22538b;

        /* renamed from: c  reason: collision with root package name */
        public int f22539c;

        /* renamed from: d  reason: collision with root package name */
        public VirtualDisplayListener f22540d;

        /* renamed from: e  reason: collision with root package name */
        public VirtualDisplay f22541e;

        private a() {
        }

        public /* synthetic */ a(byte b11) {
            this();
        }
    }

    private VirtualDisplayManager(Context context) {
        this.f22529c = context.getApplicationContext();
        this.f22530d = new CustomHandler(Looper.getMainLooper());
        this.f22528a = new l();
    }

    public static VirtualDisplayManager a(Context context) {
        if (f22527b == null) {
            synchronized (VirtualDisplayManager.class) {
                if (f22527b == null) {
                    f22527b = new VirtualDisplayManager(context);
                }
            }
        }
        return f22527b;
    }

    public static /* synthetic */ void c(VirtualDisplayManager virtualDisplayManager) {
        HashMap hashMap = new HashMap(virtualDisplayManager.f22531e);
        virtualDisplayManager.f22531e.clear();
        for (a aVar : hashMap.values()) {
            VirtualDisplayListener virtualDisplayListener = aVar.f22540d;
            if (virtualDisplayListener != null) {
                if (aVar.f22541e != null) {
                    virtualDisplayListener.onCaptureError();
                } else {
                    virtualDisplayListener.onStartFinish(false, false);
                }
            }
        }
        virtualDisplayManager.a(false);
    }

    private void b() {
        LiteavLog.i("VirtualDisplayManager", "stopScreenCaptureService");
        try {
            this.f22529c.stopService(new Intent(this.f22529c, ScreenCaptureService.class));
        } catch (Throwable unused) {
        }
    }

    private static void b(MediaProjection mediaProjection) {
        try {
            Class.forName("com.tencent.liteav.audio.SystemLoopbackRecorder").getMethod("notifyMediaProjectionState", new Class[]{MediaProjection.class}).invoke((Object) null, new Object[]{mediaProjection});
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e11) {
            LiteavLog.e("VirtualDisplayManager", "fail to send media projection session " + e11.getMessage());
        }
        Class<SystemLoopbackRecorder2> cls = SystemLoopbackRecorder2.class;
        try {
            int i11 = SystemLoopbackRecorder2.f21320a;
            cls.getMethod("notifyMediaProjectionState", new Class[]{MediaProjection.class}).invoke((Object) null, new Object[]{mediaProjection});
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e12) {
            LiteavLog.e("VirtualDisplayManager", "fail to send media projection session " + e12.getMessage());
        }
    }

    private void a() {
        for (a next : this.f22531e.values()) {
            if (next.f22541e == null) {
                try {
                    next.f22541e = this.f22533g.createVirtualDisplay("TXCScreenCapture", next.f22538b, next.f22539c, 1, 1, next.f22537a, (VirtualDisplay.Callback) null, (Handler) null);
                    LiteavLog.i("VirtualDisplayManager", "create VirtualDisplay " + next.f22541e);
                    VirtualDisplayListener virtualDisplayListener = next.f22540d;
                    if (virtualDisplayListener != null) {
                        virtualDisplayListener.onStartFinish(true, false);
                    }
                } catch (Throwable th2) {
                    LiteavLog.e("VirtualDisplayManager", "create VirtualDisplay error ", th2);
                    VirtualDisplayListener virtualDisplayListener2 = next.f22540d;
                    if (virtualDisplayListener2 != null) {
                        virtualDisplayListener2.onStartFinish(false, false);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(boolean z11) {
        if (this.f22531e.isEmpty()) {
            if (z11) {
                this.f22528a.b(this.f22534h, TimeUnit.SECONDS.toMillis(1));
                return;
            }
            LiteavLog.i("VirtualDisplayManager", "Stop media projection session " + this.f22533g);
            if (this.f22533g != null) {
                b((MediaProjection) null);
                try {
                    this.f22533g.unregisterCallback(this.f22535i);
                    this.f22533g.stop();
                } catch (Throwable th2) {
                    LiteavLog.w("VirtualDisplayManager", "stop media projection session with exception ", th2);
                }
                this.f22533g = null;
            }
            b();
        }
    }

    public final void a(MediaProjection mediaProjection) {
        this.f22528a.a(i.a(this, mediaProjection));
    }

    public static /* synthetic */ void a(VirtualDisplayManager virtualDisplayManager, MediaProjection mediaProjection) {
        virtualDisplayManager.f22532f = false;
        if (mediaProjection == null) {
            HashMap hashMap = new HashMap(virtualDisplayManager.f22531e);
            virtualDisplayManager.f22531e.clear();
            for (a aVar : hashMap.values()) {
                VirtualDisplayListener virtualDisplayListener = aVar.f22540d;
                if (virtualDisplayListener != null) {
                    virtualDisplayListener.onStartFinish(false, true);
                }
            }
            virtualDisplayManager.b();
            return;
        }
        LiteavLog.i("VirtualDisplayManager", "Got session ".concat(String.valueOf(mediaProjection)));
        virtualDisplayManager.f22533g = mediaProjection;
        mediaProjection.registerCallback(virtualDisplayManager.f22535i, virtualDisplayManager.f22530d);
        virtualDisplayManager.a();
        b(virtualDisplayManager.f22533g);
        virtualDisplayManager.a(true);
    }

    public static /* synthetic */ void a(VirtualDisplayManager virtualDisplayManager, Surface surface) {
        VirtualDisplay virtualDisplay;
        if (surface != null) {
            a remove = virtualDisplayManager.f22531e.remove(surface);
            if (!(remove == null || (virtualDisplay = remove.f22541e) == null)) {
                virtualDisplay.release();
                LiteavLog.i("VirtualDisplayManager", "VirtualDisplay released, " + remove.f22541e);
            }
            virtualDisplayManager.a(true);
        }
    }

    public static /* synthetic */ void a(VirtualDisplayManager virtualDisplayManager, Surface surface, int i11, int i12, MediaProjection mediaProjection, VirtualDisplayListener virtualDisplayListener) {
        if (surface == null) {
            LiteavLog.e("VirtualDisplayManager", "surface is null!");
            virtualDisplayListener.onStartFinish(false, false);
            return;
        }
        a aVar = new a((byte) 0);
        aVar.f22537a = surface;
        aVar.f22538b = i11;
        aVar.f22539c = i12;
        aVar.f22540d = virtualDisplayListener;
        aVar.f22541e = null;
        virtualDisplayManager.f22531e.put(surface, aVar);
        virtualDisplayManager.f22528a.c(virtualDisplayManager.f22534h);
        MediaProjection mediaProjection2 = virtualDisplayManager.f22533g;
        if (mediaProjection2 == null && mediaProjection == null) {
            if (!virtualDisplayManager.f22532f) {
                virtualDisplayManager.f22532f = true;
                Intent intent = new Intent(virtualDisplayManager.f22529c, TXScreenCapture.TXScreenCaptureAssistantActivity.class);
                intent.addFlags(268435456);
                virtualDisplayManager.f22529c.startActivity(intent);
            }
        } else if (mediaProjection == null || mediaProjection2 == mediaProjection) {
            virtualDisplayManager.a();
        } else {
            LiteavLog.i("VirtualDisplayManager", "start capture with media projection from user:".concat(String.valueOf(mediaProjection)));
            virtualDisplayManager.a(mediaProjection);
        }
    }
}
