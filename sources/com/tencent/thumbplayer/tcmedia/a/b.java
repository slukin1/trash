package com.tencent.thumbplayer.tcmedia.a;

import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.thumbplayer.tcmedia.core.common.TPGeneralError;
import com.tencent.thumbplayer.tcmedia.core.common.TPSystemInfo;
import com.tencent.thumbplayer.tcmedia.utils.TPLogUtil;
import com.tencent.thumbplayer.tcmedia.utils.o;
import java.io.FileDescriptor;
import java.util.HashMap;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private static b f48683a;

    /* renamed from: b  reason: collision with root package name */
    private HandlerThread f48684b = null;

    /* renamed from: c  reason: collision with root package name */
    private c f48685c = null;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public MediaMetadataRetriever f48686d = null;

    /* renamed from: e  reason: collision with root package name */
    private int f48687e = 0;

    public interface a {
        void a(int i11, int i12);

        void a(int i11, long j11, int i12, int i13, Bitmap bitmap, long j12);
    }

    /* renamed from: com.tencent.thumbplayer.tcmedia.a.b$b  reason: collision with other inner class name */
    public static class C0610b {

        /* renamed from: a  reason: collision with root package name */
        public a f48688a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public int f48689b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public String f48690c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public FileDescriptor f48691d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public AssetFileDescriptor f48692e;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public long f48693f;
        /* access modifiers changed from: private */

        /* renamed from: g  reason: collision with root package name */
        public int f48694g;
        /* access modifiers changed from: private */

        /* renamed from: h  reason: collision with root package name */
        public int f48695h;

        private C0610b() {
        }
    }

    public class c extends Handler {
        public c(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            int i11 = message.what;
            if (i11 == 1) {
                TPLogUtil.i("TPSysPlayerImageCapture", "eventHandler EV_CAP_IMAGE");
                b.this.a((C0610b) message.obj);
            } else if (i11 != 2) {
                TPLogUtil.i("TPSysPlayerImageCapture", "eventHandler unknow msg");
            } else {
                TPLogUtil.i("TPSysPlayerImageCapture", "eventHandler EV_STOP_CAP_IMAGE");
                if (b.this.f48686d != null) {
                    b.this.f48686d.release();
                    MediaMetadataRetriever unused = b.this.f48686d = null;
                }
            }
        }
    }

    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public String f48697a;

        /* renamed from: b  reason: collision with root package name */
        public FileDescriptor f48698b;

        /* renamed from: c  reason: collision with root package name */
        public AssetFileDescriptor f48699c;

        /* renamed from: d  reason: collision with root package name */
        public long f48700d;

        /* renamed from: e  reason: collision with root package name */
        public int f48701e;

        /* renamed from: f  reason: collision with root package name */
        public int f48702f;
    }

    private b() {
        try {
            this.f48684b = o.a().b();
            this.f48685c = new c(this.f48684b.getLooper());
        } catch (Throwable th2) {
            TPLogUtil.e("TPSysPlayerImageCapture", th2);
            this.f48685c = new c(Looper.getMainLooper());
        }
    }

    public static synchronized b a() {
        b bVar;
        synchronized (b.class) {
            if (f48683a == null) {
                f48683a = new b();
            }
            bVar = f48683a;
        }
        return bVar;
    }

    /* access modifiers changed from: private */
    public void a(C0610b bVar) {
        MediaMetadataRetriever mediaMetadataRetriever;
        C0610b bVar2 = bVar;
        try {
            int i11 = Build.VERSION.SDK_INT;
            if (i11 >= 14) {
                long currentTimeMillis = System.currentTimeMillis();
                MediaMetadataRetriever mediaMetadataRetriever2 = this.f48686d;
                if (mediaMetadataRetriever2 != null) {
                    mediaMetadataRetriever2.release();
                    this.f48686d = null;
                }
                this.f48686d = new MediaMetadataRetriever();
                if (i11 >= 14) {
                    if (bVar.f48691d != null) {
                        this.f48686d.setDataSource(bVar.f48691d);
                    } else if (bVar.f48692e != null) {
                        this.f48686d.setDataSource(bVar.f48692e.getFileDescriptor(), bVar.f48692e.getStartOffset(), bVar.f48692e.getLength());
                    } else {
                        this.f48686d.setDataSource(bVar.f48690c, new HashMap());
                    }
                }
                Bitmap frameAtTime = this.f48686d.getFrameAtTime(bVar.f48693f * 1000, 2);
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                if (frameAtTime != null) {
                    bVar2.f48688a.a(bVar.f48689b, bVar.f48693f, bVar.f48694g, bVar.f48695h, frameAtTime, currentTimeMillis2);
                } else {
                    bVar2.f48688a.a(bVar.f48689b, TPGeneralError.FAILED);
                }
                mediaMetadataRetriever = this.f48686d;
                if (mediaMetadataRetriever == null) {
                    return;
                }
                mediaMetadataRetriever.release();
                this.f48686d = null;
                return;
            }
            throw new Exception("os version not support");
        } catch (Exception e11) {
            TPLogUtil.e("TPSysPlayerImageCapture", (Throwable) e11);
            TPLogUtil.e("TPSysPlayerImageCapture", "doRealCaptureImage, Exception: " + e11.toString());
            bVar2.f48688a.a(bVar.f48689b, TPGeneralError.FAILED);
            mediaMetadataRetriever = this.f48686d;
            if (mediaMetadataRetriever == null) {
            }
        } catch (Throwable th2) {
            MediaMetadataRetriever mediaMetadataRetriever3 = this.f48686d;
            if (mediaMetadataRetriever3 != null) {
                mediaMetadataRetriever3.release();
                this.f48686d = null;
            }
            throw th2;
        }
    }

    public int a(d dVar, a aVar) {
        TPLogUtil.i("TPSysPlayerImageCapture", "captureImageWithPosition, position: " + dVar.f48700d + ", width: " + dVar.f48701e + ", height: " + dVar.f48702f);
        this.f48687e = this.f48687e + 1;
        if (TextUtils.isEmpty(TPSystemInfo.getDeviceName()) || !TPSystemInfo.getDeviceName().equals("Lenovo+K900")) {
            C0610b bVar = new C0610b();
            int unused = bVar.f48689b = this.f48687e;
            FileDescriptor unused2 = bVar.f48691d = dVar.f48698b;
            AssetFileDescriptor unused3 = bVar.f48692e = dVar.f48699c;
            String unused4 = bVar.f48690c = dVar.f48697a;
            long unused5 = bVar.f48693f = dVar.f48700d;
            int unused6 = bVar.f48694g = dVar.f48701e;
            int unused7 = bVar.f48695h = dVar.f48702f;
            bVar.f48688a = aVar;
            Message message = new Message();
            message.what = 1;
            message.obj = bVar;
            if (!this.f48685c.sendMessage(message)) {
                TPLogUtil.i("TPSysPlayerImageCapture", "captureImageWithPosition, send msg failed ");
            }
            return this.f48687e;
        }
        TPLogUtil.i("TPSysPlayerImageCapture", "captureImageWithPosition, Lenovo+K900 no incompatible");
        return -1;
    }
}
