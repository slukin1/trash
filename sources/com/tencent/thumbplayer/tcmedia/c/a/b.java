package com.tencent.thumbplayer.tcmedia.c.a;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.luck.picture.lib.config.PictureMimeType;
import com.tencent.thumbplayer.tcmedia.api.resourceloader.ITPAssetResourceLoaderListener;
import com.tencent.thumbplayer.tcmedia.api.resourceloader.ITPAssetResourceLoadingRequest;
import com.tencent.thumbplayer.tcmedia.api.resourceloader.TPAssetResourceLoadingContentInformationRequest;
import com.tencent.thumbplayer.tcmedia.core.downloadproxy.utils.TPDLFileSystem;
import com.tencent.thumbplayer.tcmedia.core.downloadproxy.utils.TPDLIOUtil;
import com.tencent.thumbplayer.tcmedia.utils.TPLogUtil;
import com.tencent.thumbplayer.tcmedia.utils.o;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class b implements a {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static String f49011a = "TPAssetResourceLoader";

    /* renamed from: b  reason: collision with root package name */
    private Context f49012b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public ITPAssetResourceLoaderListener f49013c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public long f49014d = 0;

    /* renamed from: e  reason: collision with root package name */
    private String f49015e = "";

    /* renamed from: f  reason: collision with root package name */
    private String f49016f = "";

    /* renamed from: g  reason: collision with root package name */
    private String f49017g = "";

    /* renamed from: h  reason: collision with root package name */
    private String f49018h = PictureMimeType.MP4;

    /* renamed from: i  reason: collision with root package name */
    private int f49019i = 0;

    /* renamed from: j  reason: collision with root package name */
    private ArrayList<d> f49020j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public TPAssetResourceLoadingContentInformationRequest f49021k;

    /* renamed from: l  reason: collision with root package name */
    private HandlerThread f49022l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public HandlerThread f49023m;

    /* renamed from: n  reason: collision with root package name */
    private a f49024n;

    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        private void a(long j11, long j12, String str, int i11, int i12) {
            d dVar = new d(j11, j12, i12, a(j11, j12));
            dVar.a(b.this.f49023m.getLooper());
            dVar.a(b.this.b(i11, str));
            dVar.a(b.this.f49021k);
            if (b.this.f49013c.shouldWaitForLoadingOfRequestedResource(dVar)) {
                b.this.a(dVar);
                TPLogUtil.i(b.f49011a, "add to mLoadingRequests, requestId: ".concat(String.valueOf(i12)));
            }
        }

        private boolean a(long j11, long j12) {
            boolean z11 = b.this.f49014d > 0 && j12 + j11 >= b.this.f49014d;
            if (z11) {
                b.this.f();
            }
            return z11;
        }

        public void handleMessage(Message message) {
            String d11 = b.f49011a;
            TPLogUtil.d(d11, "mCallbackForResourceLoaderHandler msg : " + message.what);
            if (b.this.f49013c != null) {
                int i11 = message.what;
                if (i11 == 256) {
                    TPLogUtil.i(b.f49011a, "start read data");
                    C0616b bVar = (C0616b) message.obj;
                    long j11 = bVar.f49026a;
                    long j12 = bVar.f49027b;
                    String str = bVar.f49028c;
                    int i12 = message.arg1;
                    int i13 = message.arg2;
                    String d12 = b.f49011a;
                    TPLogUtil.i(d12, "start read data, requestStart: " + j11 + " requestEnd:" + j12 + " requestId:" + i13);
                    long a11 = b.this.a(j11, j12);
                    if (a11 <= 0) {
                        TPLogUtil.e(b.f49011a, "requestLength invalid, check requestStart and requestEnd");
                    } else {
                        a(j11, a11, str, i12, i13);
                    }
                } else if (i11 == 257) {
                    TPLogUtil.i(b.f49011a, "stop read data");
                    b.this.b(message.arg1);
                }
            }
        }
    }

    /* renamed from: com.tencent.thumbplayer.tcmedia.c.a.b$b  reason: collision with other inner class name */
    public static class C0616b {

        /* renamed from: a  reason: collision with root package name */
        public long f49026a;

        /* renamed from: b  reason: collision with root package name */
        public long f49027b;

        /* renamed from: c  reason: collision with root package name */
        public String f49028c;

        private C0616b() {
        }
    }

    public b(Context context, Looper looper) {
        this.f49012b = context;
        this.f49020j = new ArrayList<>();
        if (looper == null) {
            HandlerThread b11 = o.a().b();
            this.f49022l = b11;
            looper = b11.getLooper();
        }
        this.f49024n = new a(looper);
        this.f49023m = o.a().a("TPAssetResourceLoader-dataWriteThread");
    }

    private synchronized int a(long j11) {
        if (this.f49020j == null) {
            return 0;
        }
        int i11 = 0;
        for (int i12 = 0; i12 < this.f49020j.size(); i12++) {
            i11 = Math.max(i11, this.f49020j.get(i12).a(j11));
        }
        return i11;
    }

    /* access modifiers changed from: private */
    public long a(long j11, long j12) {
        if (j12 > 0) {
            return j12 - j11;
        }
        long j13 = this.f49014d;
        if (j13 <= 0) {
            return 536870912;
        }
        return j13 - j11;
    }

    private synchronized d a(int i11) {
        if (this.f49020j == null) {
            return null;
        }
        for (int i12 = 0; i12 < this.f49020j.size(); i12++) {
            d dVar = this.f49020j.get(i12);
            if (dVar.getLoadingDataRequest().a() == i11) {
                return dVar;
            }
        }
        return null;
    }

    private String a(Context context, int i11) {
        if (TextUtils.isEmpty(this.f49017g)) {
            String format = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
            File externalCacheFile = TPDLFileSystem.getExternalCacheFile(context, "resourceLoader", format + Constants.ACCEPT_TIME_SEPARATOR_SERVER + i11 + this.f49018h);
            TPDLIOUtil.createFile(externalCacheFile);
            this.f49017g = externalCacheFile.getAbsolutePath();
        }
        return this.f49017g;
    }

    private void a(int i11, int i12, int i13, Object obj) {
        a aVar = this.f49024n;
        if (aVar != null) {
            Message obtainMessage = aVar.obtainMessage();
            obtainMessage.what = i11;
            obtainMessage.arg1 = i12;
            obtainMessage.arg2 = i13;
            obtainMessage.obj = obj;
            this.f49024n.sendMessage(obtainMessage);
        }
    }

    /* access modifiers changed from: private */
    public synchronized void a(d dVar) {
        ArrayList<d> arrayList = this.f49020j;
        if (arrayList != null) {
            arrayList.add(dVar);
        }
    }

    /* access modifiers changed from: private */
    public void b(int i11) {
        d a11 = a(i11);
        if (a11 == null) {
            String str = f49011a;
            TPLogUtil.e(str, "TPAssetLoader can't find the request " + i11 + " with current loading requests");
            return;
        }
        a11.b();
        TPLogUtil.i(f49011a, "handleStopReadData, cancel the loading request with id ".concat(String.valueOf(i11)));
        b(a11);
        this.f49013c.didCancelLoadingRequest(a11);
    }

    private synchronized void b(d dVar) {
        ArrayList<d> arrayList = this.f49020j;
        if (arrayList != null) {
            arrayList.remove(dVar);
        }
    }

    private String e() {
        return this.f49016f;
    }

    /* access modifiers changed from: private */
    public synchronized void f() {
        ArrayList<d> arrayList = this.f49020j;
        if (arrayList != null) {
            Iterator<d> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                ITPAssetResourceLoadingRequest next = it2.next();
                ((d) next).b();
                this.f49013c.didCancelLoadingRequest(next);
            }
            this.f49020j.clear();
        }
    }

    public int a(int i11, String str, int i12) {
        if (this.f49013c == null) {
            TPLogUtil.e(f49011a, "listener not set");
            return 0;
        }
        a(257, i12, 0, (Object) null);
        return 0;
    }

    public int a(int i11, String str, long j11, long j12) {
        if (this.f49013c == null) {
            TPLogUtil.e(f49011a, "listener not set");
            return 0;
        }
        String str2 = f49011a;
        TPLogUtil.i(str2, "onStartReadData, fileId:" + i11 + ", fileKey:" + str + ", requestStart:" + j11 + ", requestEnd:" + j12);
        int i12 = this.f49019i + 1;
        C0616b bVar = new C0616b();
        bVar.f49026a = j11;
        bVar.f49027b = j12;
        bVar.f49028c = str;
        a(256, i11, i12, (Object) bVar);
        this.f49019i = i12;
        return i12;
    }

    public long a(int i11, String str) {
        return this.f49014d;
    }

    public void a() {
        if (this.f49013c == null) {
            TPLogUtil.e(f49011a, "listener not set");
            return;
        }
        TPAssetResourceLoadingContentInformationRequest tPAssetResourceLoadingContentInformationRequest = new TPAssetResourceLoadingContentInformationRequest();
        this.f49021k = tPAssetResourceLoadingContentInformationRequest;
        this.f49013c.fillInContentInformation(tPAssetResourceLoadingContentInformationRequest);
        TPAssetResourceLoadingContentInformationRequest tPAssetResourceLoadingContentInformationRequest2 = this.f49021k;
        this.f49015e = tPAssetResourceLoadingContentInformationRequest2.contentType;
        this.f49014d = tPAssetResourceLoadingContentInformationRequest2.dataTotalSize;
        this.f49016f = tPAssetResourceLoadingContentInformationRequest2.dataFilePath;
        String str = f49011a;
        TPLogUtil.i(str, "proxy start, mDataTotalSize: " + this.f49014d + " businessPath:" + this.f49016f);
    }

    public void a(ITPAssetResourceLoaderListener iTPAssetResourceLoaderListener) {
        this.f49013c = iTPAssetResourceLoaderListener;
    }

    public int b(int i11, String str, long j11, long j12) {
        String str2 = f49011a;
        TPLogUtil.d(str2, "read data, offset:" + j11 + ", length:" + j12);
        int min = (int) Math.min((long) a(j11), j12);
        if (min <= 0) {
            return -1;
        }
        String str3 = f49011a;
        TPLogUtil.d(str3, "on read data, fileId: " + i11 + " readOffset: " + j11 + " readLength:" + j12 + " readyLength:" + min);
        return min;
    }

    public String b(int i11, String str) {
        String e11 = e();
        return !TextUtils.isEmpty(e11) ? e11 : a(this.f49012b, i11);
    }

    public void b() {
        TPLogUtil.i(f49011a, "reset start");
        f();
        this.f49014d = 0;
        this.f49015e = "";
        this.f49016f = "";
        if (!TextUtils.isEmpty(this.f49017g)) {
            try {
                new File(this.f49017g).deleteOnExit();
                this.f49017g = "";
            } catch (Exception e11) {
                String str = f49011a;
                TPLogUtil.e(str, "reset, delete cache file has exception:" + e11.toString());
            }
        }
        a aVar = this.f49024n;
        if (aVar != null) {
            aVar.removeCallbacksAndMessages((Object) null);
        }
    }

    public String c(int i11, String str) {
        return this.f49015e;
    }

    public void c() {
        TPLogUtil.i(f49011a, "release start");
        b();
        o.a().a(this.f49022l, (Handler) this.f49024n);
        o.a().a(this.f49023m, (Handler) null);
        this.f49022l = null;
        this.f49023m = null;
        this.f49024n = null;
        this.f49020j = null;
    }
}
