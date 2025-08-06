package com.tencent.thumbplayer.tcmedia.c.a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.thumbplayer.tcmedia.api.resourceloader.ITPAssetResourceLoadingDataRequest;
import com.tencent.thumbplayer.tcmedia.utils.TPLogUtil;
import com.tencent.thumbplayer.tcmedia.utils.m;
import java.io.RandomAccessFile;

public class c implements ITPAssetResourceLoadingDataRequest {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static String f49029a = "TPAssetResourceLoadingDataRequest";

    /* renamed from: b  reason: collision with root package name */
    private long f49030b;

    /* renamed from: c  reason: collision with root package name */
    private long f49031c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f49032d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public long f49033e;

    /* renamed from: f  reason: collision with root package name */
    private long f49034f;

    /* renamed from: g  reason: collision with root package name */
    private long f49035g;

    /* renamed from: h  reason: collision with root package name */
    private int f49036h;

    /* renamed from: i  reason: collision with root package name */
    private b f49037i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public m f49038j = new m();
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public String f49039k;

    /* renamed from: l  reason: collision with root package name */
    private RandomAccessFile f49040l;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public long f49041a;

        /* renamed from: b  reason: collision with root package name */
        public byte[] f49042b;

        private a() {
        }
    }

    public class b extends Handler {
        public b(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            if (message.what == 256) {
                a aVar = (a) message.obj;
                long j11 = aVar.f49041a;
                byte[] bArr = aVar.f49042b;
                int i11 = message.arg1;
                c cVar = c.this;
                if (!cVar.a(j11, bArr, cVar.f49039k)) {
                    TPLogUtil.e(c.f49029a, "write data failed");
                    return;
                }
                c.this.f49038j.writeLock().lock();
                long unused = c.this.f49033e = ((long) i11) + j11;
                c.this.f49038j.writeLock().unlock();
                String c11 = c.f49029a;
                TPLogUtil.i(c11, "write data from " + j11 + " , with dataLength" + i11);
            }
        }
    }

    public c(long j11, long j12, boolean z11) {
        this.f49030b = j11;
        this.f49034f = j11;
        this.f49033e = j11;
        this.f49031c = j12;
        this.f49032d = z11;
    }

    private void a(int i11, int i12, int i13, Object obj) {
        b bVar = this.f49037i;
        if (bVar != null) {
            Message obtainMessage = bVar.obtainMessage();
            obtainMessage.what = i11;
            obtainMessage.arg1 = i12;
            obtainMessage.arg2 = i13;
            obtainMessage.obj = obj;
            this.f49037i.sendMessage(obtainMessage);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        com.tencent.thumbplayer.tcmedia.utils.TPLogUtil.e(f49029a, "fail to write data");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002b, code lost:
        r4 = r3.f49040l;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002d, code lost:
        if (r4 == null) goto L_0x0044;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        com.tencent.thumbplayer.tcmedia.utils.TPLogUtil.e(f49029a, "file not found");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0037, code lost:
        r4 = r3.f49040l;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0039, code lost:
        if (r4 == null) goto L_0x0044;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        r4.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x003f, code lost:
        com.tencent.thumbplayer.tcmedia.utils.TPLogUtil.e(f49029a, "fail to close mRandomAccessFile");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0046, code lost:
        r5 = r3.f49040l;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0048, code lost:
        if (r5 != null) goto L_0x004a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        r5.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x004e, code lost:
        com.tencent.thumbplayer.tcmedia.utils.TPLogUtil.e(f49029a, "fail to close mRandomAccessFile");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0053, code lost:
        throw r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0022, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:10:0x0024, B:14:0x0030] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0024 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x0030 */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:14:0x0030=Splitter:B:14:0x0030, B:10:0x0024=Splitter:B:10:0x0024} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(long r4, byte[] r6, java.lang.String r7) {
        /*
            r3 = this;
            java.lang.String r0 = "fail to close mRandomAccessFile"
            java.io.RandomAccessFile r1 = new java.io.RandomAccessFile     // Catch:{ FileNotFoundException -> 0x0030, IOException -> 0x0024 }
            java.lang.String r2 = "rw"
            r1.<init>(r7, r2)     // Catch:{ FileNotFoundException -> 0x0030, IOException -> 0x0024 }
            r3.f49040l = r1     // Catch:{ FileNotFoundException -> 0x0030, IOException -> 0x0024 }
            r1.seek(r4)     // Catch:{ FileNotFoundException -> 0x0030, IOException -> 0x0024 }
            java.io.RandomAccessFile r4 = r3.f49040l     // Catch:{ FileNotFoundException -> 0x0030, IOException -> 0x0024 }
            r4.write(r6)     // Catch:{ FileNotFoundException -> 0x0030, IOException -> 0x0024 }
            r4 = 1
            java.io.RandomAccessFile r5 = r3.f49040l
            if (r5 == 0) goto L_0x0045
            r5.close()     // Catch:{ IOException -> 0x001c }
            goto L_0x0045
        L_0x001c:
            java.lang.String r5 = f49029a
            com.tencent.thumbplayer.tcmedia.utils.TPLogUtil.e((java.lang.String) r5, (java.lang.String) r0)
            goto L_0x0045
        L_0x0022:
            r4 = move-exception
            goto L_0x0046
        L_0x0024:
            java.lang.String r4 = f49029a     // Catch:{ all -> 0x0022 }
            java.lang.String r5 = "fail to write data"
            com.tencent.thumbplayer.tcmedia.utils.TPLogUtil.e((java.lang.String) r4, (java.lang.String) r5)     // Catch:{ all -> 0x0022 }
            java.io.RandomAccessFile r4 = r3.f49040l
            if (r4 == 0) goto L_0x0044
            goto L_0x003b
        L_0x0030:
            java.lang.String r4 = f49029a     // Catch:{ all -> 0x0022 }
            java.lang.String r5 = "file not found"
            com.tencent.thumbplayer.tcmedia.utils.TPLogUtil.e((java.lang.String) r4, (java.lang.String) r5)     // Catch:{ all -> 0x0022 }
            java.io.RandomAccessFile r4 = r3.f49040l
            if (r4 == 0) goto L_0x0044
        L_0x003b:
            r4.close()     // Catch:{ IOException -> 0x003f }
            goto L_0x0044
        L_0x003f:
            java.lang.String r4 = f49029a
            com.tencent.thumbplayer.tcmedia.utils.TPLogUtil.e((java.lang.String) r4, (java.lang.String) r0)
        L_0x0044:
            r4 = 0
        L_0x0045:
            return r4
        L_0x0046:
            java.io.RandomAccessFile r5 = r3.f49040l
            if (r5 == 0) goto L_0x0053
            r5.close()     // Catch:{ IOException -> 0x004e }
            goto L_0x0053
        L_0x004e:
            java.lang.String r5 = f49029a
            com.tencent.thumbplayer.tcmedia.utils.TPLogUtil.e((java.lang.String) r5, (java.lang.String) r0)
        L_0x0053:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.thumbplayer.tcmedia.c.a.c.a(long, byte[], java.lang.String):boolean");
    }

    public int a() {
        return this.f49036h;
    }

    public int a(long j11) {
        this.f49038j.readLock().lock();
        long j12 = this.f49033e;
        this.f49038j.readLock().unlock();
        if (j11 >= j12) {
            return -1;
        }
        if (j11 >= this.f49030b) {
            return (int) (j12 - j11);
        }
        TPLogUtil.e(f49029a, "Offset less than mRequestedOffset");
        return -1;
    }

    public void a(int i11) {
        this.f49036h = i11;
    }

    public void a(Looper looper) {
        this.f49037i = new b(looper);
    }

    public void a(String str) {
        this.f49039k = str;
    }

    public void b() {
        b bVar = this.f49037i;
        if (bVar != null) {
            bVar.removeCallbacksAndMessages((Object) null);
            this.f49037i = null;
        }
    }

    public long getCurrentOffset() {
        this.f49038j.readLock().lock();
        long j11 = this.f49034f;
        this.f49038j.readLock().unlock();
        return j11;
    }

    public long getRequestedLength() {
        return this.f49031c;
    }

    public long getRequestedOffset() {
        return this.f49030b;
    }

    public void notifyDataReady(long j11, long j12) {
        long j13 = j12 + j11;
        long j14 = this.f49030b;
        if (j13 > this.f49031c + j14) {
            TPLogUtil.e(f49029a, "data exceed the max request offset");
            return;
        }
        if (j11 < j14) {
            TPLogUtil.w(f49029a, "the notify data offset is less than request offset");
        }
        if (j13 < this.f49034f) {
            TPLogUtil.e(f49029a, "data not reach current offset");
            return;
        }
        this.f49038j.writeLock().lock();
        this.f49034f = j13;
        this.f49033e = j13;
        this.f49038j.writeLock().unlock();
    }

    public void respondWithData(byte[] bArr) {
        if (this.f49035g > this.f49031c) {
            TPLogUtil.i(f49029a, "respond full data");
            return;
        }
        int length = bArr.length;
        a aVar = new a();
        aVar.f49041a = this.f49034f;
        aVar.f49042b = bArr;
        a(256, length, 0, (Object) aVar);
        String str = f49029a;
        TPLogUtil.i(str, "respond data from:" + this.f49034f + ", dataLength:" + length);
        this.f49038j.writeLock().lock();
        long j11 = (long) length;
        this.f49034f = this.f49034f + j11;
        this.f49035g = this.f49035g + j11;
        this.f49038j.writeLock().unlock();
    }
}
