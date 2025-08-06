package com.tencent.rtmp.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.google.android.exoplayer2.DefaultControlDispatcher;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.rtmp.TXImageSprite;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class a extends TXImageSprite {

    /* renamed from: a  reason: collision with root package name */
    private final BitmapFactory.Options f48604a = new BitmapFactory.Options();

    /* renamed from: b  reason: collision with root package name */
    private HandlerThread f48605b;

    /* renamed from: c  reason: collision with root package name */
    private Handler f48606c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public List<c> f48607d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public Map<String, BitmapRegionDecoder> f48608e;

    /* renamed from: com.tencent.rtmp.a.a$a  reason: collision with other inner class name */
    public static class C0609a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private WeakReference<a> f48610a;

        /* renamed from: b  reason: collision with root package name */
        private String f48611b;

        public C0609a(a aVar, String str) {
            this.f48610a = new WeakReference<>(aVar);
            this.f48611b = str;
        }

        private static float a(String str) {
            String str2;
            String[] split = str.split(":");
            String str3 = null;
            if (split.length == 3) {
                String str4 = split[0];
                str3 = split[1];
                str2 = split[2];
            } else if (split.length == 2) {
                str3 = split[0];
                str2 = split[1];
            } else {
                str2 = split.length == 1 ? split[0] : null;
            }
            float f11 = 0.0f;
            if (str3 != null) {
                f11 = 0.0f + (Float.valueOf(str3).floatValue() * 60.0f);
            }
            return str2 != null ? f11 + Float.valueOf(str2).floatValue() : f11;
        }

        /* JADX WARNING: Removed duplicated region for block: B:56:0x00fe A[SYNTHETIC, Splitter:B:56:0x00fe] */
        /* JADX WARNING: Removed duplicated region for block: B:60:0x0104 A[SYNTHETIC, Splitter:B:60:0x0104] */
        /* JADX WARNING: Removed duplicated region for block: B:76:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
                r11 = this;
                java.lang.String r0 = "TXImageSprite"
                java.lang.ref.WeakReference<com.tencent.rtmp.a.a> r1 = r11.f48610a
                java.lang.Object r1 = r1.get()
                com.tencent.rtmp.a.a r1 = (com.tencent.rtmp.a.a) r1
                r2 = 0
                java.lang.String r3 = r11.f48611b     // Catch:{ IOException -> 0x00f6 }
                java.io.InputStream r3 = com.tencent.rtmp.a.a.a((java.lang.String) r3)     // Catch:{ IOException -> 0x00f6 }
                if (r3 != 0) goto L_0x0014
                return
            L_0x0014:
                java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch:{ IOException -> 0x00f6 }
                java.io.InputStreamReader r5 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x00f6 }
                r5.<init>(r3)     // Catch:{ IOException -> 0x00f6 }
                r4.<init>(r5)     // Catch:{ IOException -> 0x00f6 }
                java.lang.String r2 = r4.readLine()     // Catch:{ IOException -> 0x00f1, all -> 0x00ee }
                if (r2 == 0) goto L_0x00e0
                int r3 = r2.length()     // Catch:{ IOException -> 0x00f1, all -> 0x00ee }
                if (r3 == 0) goto L_0x00e0
                java.lang.String r3 = "WEBVTT"
                boolean r2 = r2.contains(r3)     // Catch:{ IOException -> 0x00f1, all -> 0x00ee }
                if (r2 != 0) goto L_0x0034
                goto L_0x00e0
            L_0x0034:
                java.lang.String r2 = r4.readLine()     // Catch:{ IOException -> 0x00f1, all -> 0x00ee }
                if (r2 == 0) goto L_0x00da
                java.lang.String r3 = "-->"
                boolean r3 = r2.contains(r3)     // Catch:{ IOException -> 0x00f1, all -> 0x00ee }
                if (r3 == 0) goto L_0x00da
                java.lang.String r3 = " --> "
                java.lang.String[] r3 = r2.split(r3)     // Catch:{ IOException -> 0x00f1, all -> 0x00ee }
                int r5 = r3.length     // Catch:{ IOException -> 0x00f1, all -> 0x00ee }
                r6 = 2
                if (r5 != r6) goto L_0x00da
                java.lang.String r5 = r4.readLine()     // Catch:{ IOException -> 0x00f1, all -> 0x00ee }
                com.tencent.rtmp.a.a$c r7 = new com.tencent.rtmp.a.a$c     // Catch:{ IOException -> 0x00f1, all -> 0x00ee }
                r8 = 0
                r7.<init>(r8)     // Catch:{ IOException -> 0x00f1, all -> 0x00ee }
                r9 = r3[r8]     // Catch:{ IOException -> 0x00f1, all -> 0x00ee }
                float r9 = a(r9)     // Catch:{ IOException -> 0x00f1, all -> 0x00ee }
                r7.f48615a = r9     // Catch:{ IOException -> 0x00f1, all -> 0x00ee }
                r9 = 1
                r3 = r3[r9]     // Catch:{ IOException -> 0x00f1, all -> 0x00ee }
                float r3 = a(r3)     // Catch:{ IOException -> 0x00f1, all -> 0x00ee }
                r7.f48616b = r3     // Catch:{ IOException -> 0x00f1, all -> 0x00ee }
                r7.f48617c = r5     // Catch:{ IOException -> 0x00f1, all -> 0x00ee }
                java.lang.String r3 = "#"
                int r3 = r5.indexOf(r3)     // Catch:{ IOException -> 0x00f1, all -> 0x00ee }
                r10 = -1
                if (r3 == r10) goto L_0x0078
                java.lang.String r3 = r5.substring(r8, r3)     // Catch:{ IOException -> 0x00f1, all -> 0x00ee }
                r7.f48618d = r3     // Catch:{ IOException -> 0x00f1, all -> 0x00ee }
            L_0x0078:
                java.lang.String r3 = "="
                int r3 = r5.indexOf(r3)     // Catch:{ IOException -> 0x00f1, all -> 0x00ee }
                if (r3 == r10) goto L_0x00cb
                int r3 = r3 + 1
                int r10 = r5.length()     // Catch:{ IOException -> 0x00f1, all -> 0x00ee }
                if (r3 >= r10) goto L_0x00cb
                int r10 = r5.length()     // Catch:{ IOException -> 0x00f1, all -> 0x00ee }
                java.lang.String r3 = r5.substring(r3, r10)     // Catch:{ IOException -> 0x00f1, all -> 0x00ee }
                java.lang.String r5 = ","
                java.lang.String[] r3 = r3.split(r5)     // Catch:{ IOException -> 0x00f1, all -> 0x00ee }
                int r5 = r3.length     // Catch:{ IOException -> 0x00f1, all -> 0x00ee }
                r10 = 4
                if (r5 != r10) goto L_0x00cb
                r5 = r3[r8]     // Catch:{ IOException -> 0x00f1, all -> 0x00ee }
                java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ IOException -> 0x00f1, all -> 0x00ee }
                int r5 = r5.intValue()     // Catch:{ IOException -> 0x00f1, all -> 0x00ee }
                r7.f48619e = r5     // Catch:{ IOException -> 0x00f1, all -> 0x00ee }
                r5 = r3[r9]     // Catch:{ IOException -> 0x00f1, all -> 0x00ee }
                java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ IOException -> 0x00f1, all -> 0x00ee }
                int r5 = r5.intValue()     // Catch:{ IOException -> 0x00f1, all -> 0x00ee }
                r7.f48620f = r5     // Catch:{ IOException -> 0x00f1, all -> 0x00ee }
                r5 = r3[r6]     // Catch:{ IOException -> 0x00f1, all -> 0x00ee }
                java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ IOException -> 0x00f1, all -> 0x00ee }
                int r5 = r5.intValue()     // Catch:{ IOException -> 0x00f1, all -> 0x00ee }
                r7.f48621g = r5     // Catch:{ IOException -> 0x00f1, all -> 0x00ee }
                r5 = 3
                r3 = r3[r5]     // Catch:{ IOException -> 0x00f1, all -> 0x00ee }
                java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ IOException -> 0x00f1, all -> 0x00ee }
                int r3 = r3.intValue()     // Catch:{ IOException -> 0x00f1, all -> 0x00ee }
                r7.f48622h = r3     // Catch:{ IOException -> 0x00f1, all -> 0x00ee }
            L_0x00cb:
                if (r1 == 0) goto L_0x00da
                java.util.List r3 = r1.f48607d     // Catch:{ IOException -> 0x00f1, all -> 0x00ee }
                if (r3 == 0) goto L_0x00da
                java.util.List r3 = r1.f48607d     // Catch:{ IOException -> 0x00f1, all -> 0x00ee }
                r3.add(r7)     // Catch:{ IOException -> 0x00f1, all -> 0x00ee }
            L_0x00da:
                if (r2 != 0) goto L_0x0034
                r4.close()     // Catch:{ IOException -> 0x00df }
            L_0x00df:
                return
            L_0x00e0:
                java.lang.String r2 = "DownloadAndParseVTTFileTask : getVTT File Error!"
                com.tencent.liteav.base.util.LiteavLog.e(r0, r2)     // Catch:{ IOException -> 0x00f1, all -> 0x00ee }
                if (r1 == 0) goto L_0x00ea
                r1.a()     // Catch:{ IOException -> 0x00f1, all -> 0x00ee }
            L_0x00ea:
                r4.close()     // Catch:{ IOException -> 0x00ed }
            L_0x00ed:
                return
            L_0x00ee:
                r0 = move-exception
                r2 = r4
                goto L_0x0102
            L_0x00f1:
                r1 = move-exception
                r2 = r4
                goto L_0x00f7
            L_0x00f4:
                r0 = move-exception
                goto L_0x0102
            L_0x00f6:
                r1 = move-exception
            L_0x00f7:
                java.lang.String r3 = "load image sprite failed."
                com.tencent.liteav.base.util.LiteavLog.e((java.lang.String) r0, (java.lang.String) r3, (java.lang.Throwable) r1)     // Catch:{ all -> 0x00f4 }
                if (r2 == 0) goto L_0x0101
                r2.close()     // Catch:{ IOException -> 0x0101 }
            L_0x0101:
                return
            L_0x0102:
                if (r2 == 0) goto L_0x0107
                r2.close()     // Catch:{ IOException -> 0x0107 }
            L_0x0107:
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.rtmp.a.a.C0609a.run():void");
        }
    }

    public static class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private WeakReference<a> f48612a;

        /* renamed from: b  reason: collision with root package name */
        private String f48613b;

        /* renamed from: c  reason: collision with root package name */
        private String f48614c;

        public b(a aVar, String str, String str2) {
            this.f48612a = new WeakReference<>(aVar);
            this.f48613b = str;
            this.f48614c = str2;
        }

        public final void run() {
            a aVar = (a) this.f48612a.get();
            if (this.f48612a != null && aVar != null) {
                InputStream inputStream = null;
                try {
                    InputStream a11 = a.a(this.f48614c);
                    String lastPathSegment = Uri.parse(this.f48614c).getLastPathSegment();
                    if (aVar.f48608e != null) {
                        aVar.f48608e.put(lastPathSegment, BitmapRegionDecoder.newInstance(a11, true));
                    }
                    if (a11 != null) {
                        try {
                            a11.close();
                        } catch (IOException unused) {
                        }
                    }
                } catch (IOException e11) {
                    LiteavLog.e("TXImageSprite", "load bitmap from network failed.", (Throwable) e11);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException unused2) {
                        }
                    }
                } catch (Throwable th2) {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException unused3) {
                        }
                    }
                    throw th2;
                }
            }
        }
    }

    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public float f48615a;

        /* renamed from: b  reason: collision with root package name */
        public float f48616b;

        /* renamed from: c  reason: collision with root package name */
        public String f48617c;

        /* renamed from: d  reason: collision with root package name */
        public String f48618d;

        /* renamed from: e  reason: collision with root package name */
        public int f48619e;

        /* renamed from: f  reason: collision with root package name */
        public int f48620f;

        /* renamed from: g  reason: collision with root package name */
        public int f48621g;

        /* renamed from: h  reason: collision with root package name */
        public int f48622h;

        private c() {
        }

        public /* synthetic */ c(byte b11) {
            this();
        }
    }

    public a(Context context) {
        super(context);
        ArrayList arrayList = new ArrayList();
        this.f48607d = arrayList;
        this.f48607d = Collections.synchronizedList(arrayList);
        HashMap hashMap = new HashMap();
        this.f48608e = hashMap;
        this.f48608e = Collections.synchronizedMap(hashMap);
    }

    public final Bitmap getThumbnail(float f11) {
        c cVar;
        BitmapRegionDecoder bitmapRegionDecoder;
        if (this.f48607d.size() == 0) {
            return null;
        }
        int i11 = 0;
        int size = this.f48607d.size() - 1;
        while (true) {
            int i12 = ((size - i11) / 2) + i11;
            if (this.f48607d.get(i12).f48615a > f11 || this.f48607d.get(i12).f48616b <= f11) {
                if (i11 < size) {
                    if (f11 < this.f48607d.get(i12).f48616b) {
                        if (f11 >= this.f48607d.get(i12).f48615a) {
                            cVar = null;
                            break;
                        }
                        size = i12 - 1;
                    } else {
                        i11 = i12 + 1;
                    }
                } else {
                    cVar = this.f48607d.get(i11);
                    break;
                }
            } else {
                cVar = this.f48607d.get(i12);
                break;
            }
        }
        if (cVar == null || (bitmapRegionDecoder = this.f48608e.get(cVar.f48618d)) == null) {
            return null;
        }
        Rect rect = new Rect();
        int i13 = cVar.f48619e;
        rect.left = i13;
        int i14 = cVar.f48620f;
        rect.top = i14;
        rect.right = i13 + cVar.f48621g;
        rect.bottom = i14 + cVar.f48622h;
        return bitmapRegionDecoder.decodeRegion(rect, this.f48604a);
    }

    public final void release() {
        a();
        if (this.f48605b != null && this.f48606c != null) {
            if (LiteavSystemInfo.getSystemOSVersionInt() >= 18) {
                this.f48605b.quitSafely();
            } else {
                this.f48605b.quit();
            }
            this.f48606c = null;
            this.f48605b = null;
        }
    }

    public final void setVTTUrlAndImageUrls(String str, List<String> list) {
        if (TextUtils.isEmpty(str)) {
            LiteavLog.e("TXImageSprite", "setVTTUrlAndImageUrls: vttUrl can't be null!");
            return;
        }
        a();
        if (this.f48605b == null) {
            HandlerThread handlerThread = new HandlerThread("SuperVodThumbnailsWorkThread");
            this.f48605b = handlerThread;
            handlerThread.start();
            this.f48606c = new Handler(this.f48605b.getLooper());
        }
        this.f48606c.post(new C0609a(this, str));
        if (list != null && list.size() != 0) {
            for (String bVar : list) {
                this.f48606c.post(new b(this, str, bVar));
            }
        }
    }

    /* access modifiers changed from: private */
    public void a() {
        if (this.f48606c != null) {
            LiteavLog.i("TXImageSprite", " remove all tasks!");
            this.f48606c.removeCallbacksAndMessages((Object) null);
            this.f48606c.post(new Runnable() {
                public final void run() {
                    if (a.this.f48607d != null) {
                        a.this.f48607d.clear();
                    }
                    if (a.this.f48608e != null) {
                        for (BitmapRegionDecoder bitmapRegionDecoder : a.this.f48608e.values()) {
                            if (bitmapRegionDecoder != null) {
                                bitmapRegionDecoder.recycle();
                            }
                        }
                        a.this.f48608e.clear();
                    }
                }
            });
        }
    }

    public static /* synthetic */ InputStream a(String str) throws IOException {
        URLConnection openConnection = new URL(str).openConnection();
        openConnection.connect();
        openConnection.getInputStream();
        openConnection.setConnectTimeout(DefaultControlDispatcher.DEFAULT_FAST_FORWARD_MS);
        openConnection.setReadTimeout(DefaultControlDispatcher.DEFAULT_FAST_FORWARD_MS);
        return openConnection.getInputStream();
    }
}
