package com.mob.tools.gui;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import com.google.android.exoplayer2.audio.SilenceSkippingAudioProcessor;
import com.mob.tools.MobHandlerThread;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import com.mob.tools.network.NetworkHelper;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.ResHelper;
import java.io.File;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

public class BitmapProcessor {
    private static final int CAPACITY = 3;
    private static final int MAX_CACHE_SIZE = 50;
    private static final int MAX_CACHE_TIME = 60000;
    private static final int MAX_REQ_TIME = 20000;
    private static final int MAX_SIZE = 100;
    private static final int OVERFLOW_SIZE = 120;
    private static final int SCAN_INTERVAL = 20000;
    /* access modifiers changed from: private */
    public static File cacheDir;
    /* access modifiers changed from: private */
    public static CachePoolInner<String, SoftReference<Bitmap>> cachePool = new CachePoolInner<>(50);
    private static ManagerThread manager;
    /* access modifiers changed from: private */
    public static ArrayList<ImageReq> netReqTPS = new ArrayList<>();
    /* access modifiers changed from: private */
    public static ArrayList<ImageReq> reqList = new ArrayList<>();
    /* access modifiers changed from: private */
    public static NetworkHelper.NetworkTimeOut timeout;
    /* access modifiers changed from: private */
    public static boolean work;
    /* access modifiers changed from: private */
    public static WorkerThread[] workerList = new WorkerThread[3];

    public interface BitmapCallback {
        void onImageGot(String str, Bitmap bitmap);
    }

    public static class BitmapDesiredOptions {
        public int desiredHeight = 0;
        public int desiredWidth = 0;
        public long maxBytes = 0;
        public int quality = 0;

        public boolean equals(Object obj) {
            return super.equals(obj) || (obj != null && obj.toString().equals(toString()));
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            int i11 = this.desiredWidth;
            if (i11 > 0) {
                sb2.append(i11);
            }
            int i12 = this.desiredHeight;
            if (i12 > 0) {
                sb2.append(i12);
            }
            long j11 = this.maxBytes;
            if (j11 > 0) {
                sb2.append(j11);
            }
            int i13 = this.quality;
            if (i13 > 0) {
                sb2.append(i13);
            }
            return sb2.toString();
        }
    }

    public static class ImageReq {
        /* access modifiers changed from: private */
        public BitmapDesiredOptions bitmapDesiredOptions;
        /* access modifiers changed from: private */
        public ArrayList<BitmapCallback> callbacks = new ArrayList<>();
        /* access modifiers changed from: private */
        public long diskCacheTime = 0;
        private long reqTime = System.currentTimeMillis();
        /* access modifiers changed from: private */
        public String url;
        /* access modifiers changed from: private */
        public boolean useDiskCache = true;
        /* access modifiers changed from: private */
        public boolean useRamCache = true;
        /* access modifiers changed from: private */
        public WorkerThread worker;

        /* access modifiers changed from: private */
        public void throwComplete(Bitmap bitmap) {
            Iterator<BitmapCallback> it2 = this.callbacks.iterator();
            while (it2.hasNext()) {
                it2.next().onImageGot(this.url, bitmap);
            }
            this.callbacks.clear();
        }

        /* access modifiers changed from: private */
        public void throwError() {
            Iterator<BitmapCallback> it2 = this.callbacks.iterator();
            while (it2.hasNext()) {
                it2.next().onImageGot(this.url, (Bitmap) null);
            }
            this.callbacks.clear();
        }

        public String toString() {
            return "url=" + this.url + "time=" + this.reqTime + "worker=" + this.worker.getName() + " (" + this.worker.getId() + "";
        }
    }

    public static class ManagerThread implements Handler.Callback {
        private Handler handler;

        public ManagerThread() {
            Handler newHandler = MobHandlerThread.newHandler((Runnable) new Runnable() {
                public void run() {
                    int i11 = 0;
                    while (i11 < BitmapProcessor.workerList.length) {
                        if (BitmapProcessor.workerList[i11] == null) {
                            BitmapProcessor.workerList[i11] = new WorkerThread();
                            BitmapProcessor.workerList[i11].setName("worker " + i11);
                            boolean unused = BitmapProcessor.workerList[i11].localType = i11 == 0;
                            BitmapProcessor.workerList[i11].start();
                        }
                        i11++;
                    }
                }
            }, (Handler.Callback) this);
            this.handler = newHandler;
            newHandler.sendEmptyMessageDelayed(1, SilenceSkippingAudioProcessor.DEFAULT_PADDING_SILENCE_US);
        }

        public boolean handleMessage(Message message) {
            if (BitmapProcessor.cachePool != null) {
                BitmapProcessor.cachePool.trimBeforeTime(System.currentTimeMillis() - 60000);
            }
            int size = BitmapProcessor.cachePool == null ? 0 : BitmapProcessor.cachePool.size();
            NLog instance = MobLog.getInstance();
            instance.d(">>>> BitmapProcessor.cachePool: " + size, new Object[0]);
            int size2 = BitmapProcessor.reqList == null ? 0 : BitmapProcessor.reqList.size();
            NLog instance2 = MobLog.getInstance();
            instance2.d(">>>> BitmapProcessor.reqList: " + size2, new Object[0]);
            if (BitmapProcessor.work) {
                this.handler.sendEmptyMessageDelayed(1, SilenceSkippingAudioProcessor.DEFAULT_PADDING_SILENCE_US);
            }
            return false;
        }

        public void quit() {
            this.handler.removeMessages(1);
            this.handler.getLooper().quit();
            for (int i11 = 0; i11 < BitmapProcessor.workerList.length; i11++) {
                if (BitmapProcessor.workerList[i11] != null) {
                    BitmapProcessor.workerList[i11].interrupt();
                    BitmapProcessor.workerList[i11] = null;
                }
            }
        }
    }

    public static class PatchInputStream extends FilterInputStream {

        /* renamed from: in  reason: collision with root package name */
        public InputStream f27900in;

        public PatchInputStream(InputStream inputStream) {
            super(inputStream);
            this.f27900in = inputStream;
        }

        public long skip(long j11) throws IOException {
            long j12 = 0;
            while (j12 < j11) {
                long skip = this.f27900in.skip(j11 - j12);
                if (skip == 0) {
                    break;
                }
                j12 += skip;
            }
            return j12;
        }
    }

    public static class WorkerThread extends Thread {
        /* access modifiers changed from: private */
        public ImageReq curReq;
        /* access modifiers changed from: private */
        public boolean localType;

        private WorkerThread() {
        }

        private void doLocalTask() throws Throwable {
            Bitmap bitmap;
            ImageReq imageReq;
            SoftReference softReference;
            synchronized (BitmapProcessor.reqList) {
                bitmap = null;
                imageReq = BitmapProcessor.reqList.size() > 0 ? (ImageReq) BitmapProcessor.reqList.remove(0) : null;
            }
            if (imageReq != null) {
                if (imageReq.useRamCache && (softReference = (SoftReference) BitmapProcessor.cachePool.get(BitmapProcessor.getCacheKey(imageReq.url, imageReq.bitmapDesiredOptions))) != null) {
                    bitmap = (Bitmap) softReference.get();
                }
                if (bitmap != null) {
                    this.curReq = imageReq;
                    WorkerThread unused = imageReq.worker = this;
                    imageReq.throwComplete(bitmap);
                } else if (!imageReq.useDiskCache || BitmapProcessor.cacheDir == null || !new File(BitmapProcessor.cacheDir, Data.MD5(imageReq.url)).exists()) {
                    synchronized (BitmapProcessor.reqList) {
                        if (BitmapProcessor.netReqTPS.size() > 100) {
                            synchronized (BitmapProcessor.reqList) {
                                while (BitmapProcessor.reqList.size() > 0) {
                                    BitmapProcessor.reqList.remove(0);
                                }
                            }
                            BitmapProcessor.netReqTPS.remove(0);
                        }
                    }
                    BitmapProcessor.netReqTPS.add(imageReq);
                } else {
                    doTask(imageReq);
                }
            } else {
                try {
                    Thread.sleep(30);
                } catch (Throwable unused2) {
                }
            }
        }

        private void doNetworkTask() throws Throwable {
            Bitmap bitmap;
            ImageReq imageReq;
            SoftReference softReference;
            synchronized (BitmapProcessor.netReqTPS) {
                bitmap = null;
                imageReq = BitmapProcessor.netReqTPS.size() > 0 ? (ImageReq) BitmapProcessor.netReqTPS.remove(0) : null;
            }
            if (imageReq == null) {
                synchronized (BitmapProcessor.reqList) {
                    if (BitmapProcessor.reqList.size() > 0) {
                        imageReq = (ImageReq) BitmapProcessor.reqList.remove(0);
                    }
                }
            }
            if (imageReq != null) {
                if (imageReq.useRamCache && (softReference = (SoftReference) BitmapProcessor.cachePool.get(BitmapProcessor.getCacheKey(imageReq.url, imageReq.bitmapDesiredOptions))) != null) {
                    bitmap = (Bitmap) softReference.get();
                }
                if (bitmap != null) {
                    this.curReq = imageReq;
                    WorkerThread unused = imageReq.worker = this;
                    imageReq.throwComplete(bitmap);
                    return;
                }
                doTask(imageReq);
                return;
            }
            try {
                Thread.sleep(30);
            } catch (Throwable unused2) {
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:25:0x009a A[Catch:{ all -> 0x00d8 }] */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x00bc A[Catch:{ all -> 0x00d8 }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void doTask(final com.mob.tools.gui.BitmapProcessor.ImageReq r11) throws java.lang.Throwable {
            /*
                r10 = this;
                r0 = 0
                r10.curReq = r11     // Catch:{ all -> 0x00d8 }
                com.mob.tools.gui.BitmapProcessor.WorkerThread unused = r11.worker = r10     // Catch:{ all -> 0x00d8 }
                java.lang.String r1 = r11.url     // Catch:{ all -> 0x00d8 }
                java.lang.String r1 = com.mob.tools.utils.Data.MD5((java.lang.String) r1)     // Catch:{ all -> 0x00d8 }
                java.io.File r2 = new java.io.File     // Catch:{ all -> 0x00d8 }
                java.io.File r3 = com.mob.tools.gui.BitmapProcessor.cacheDir     // Catch:{ all -> 0x00d8 }
                r2.<init>(r3, r1)     // Catch:{ all -> 0x00d8 }
                boolean r3 = r11.useDiskCache     // Catch:{ all -> 0x00d8 }
                if (r3 == 0) goto L_0x0041
                long r3 = r11.diskCacheTime     // Catch:{ all -> 0x00d8 }
                r5 = 0
                int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r3 <= 0) goto L_0x0041
                boolean r3 = r2.exists()     // Catch:{ all -> 0x00d8 }
                if (r3 == 0) goto L_0x0041
                long r3 = r2.lastModified()     // Catch:{ all -> 0x00d8 }
                long r5 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x00d8 }
                long r7 = r11.diskCacheTime     // Catch:{ all -> 0x00d8 }
                long r3 = r3 + r7
                int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r3 >= 0) goto L_0x0041
                r2.delete()     // Catch:{ all -> 0x00d8 }
            L_0x0041:
                boolean r3 = r11.useDiskCache     // Catch:{ all -> 0x00d8 }
                if (r3 == 0) goto L_0x00c2
                java.io.File r3 = com.mob.tools.gui.BitmapProcessor.cacheDir     // Catch:{ all -> 0x00d8 }
                if (r3 == 0) goto L_0x00c2
                boolean r3 = r2.exists()     // Catch:{ all -> 0x00d8 }
                if (r3 == 0) goto L_0x00c2
                com.mob.tools.gui.BitmapProcessor$BitmapDesiredOptions r3 = r11.bitmapDesiredOptions     // Catch:{ all -> 0x00d8 }
                if (r3 == 0) goto L_0x0090
                com.mob.tools.gui.BitmapProcessor$BitmapDesiredOptions r3 = r11.bitmapDesiredOptions     // Catch:{ all -> 0x00d8 }
                java.lang.String r4 = ""
                boolean r3 = r3.equals(r4)     // Catch:{ all -> 0x00d8 }
                if (r3 == 0) goto L_0x0066
                goto L_0x0090
            L_0x0066:
                java.io.File r2 = new java.io.File     // Catch:{ all -> 0x00d8 }
                java.io.File r3 = com.mob.tools.gui.BitmapProcessor.cacheDir     // Catch:{ all -> 0x00d8 }
                r2.<init>(r3, r1)     // Catch:{ all -> 0x00d8 }
                java.lang.String r4 = r2.getAbsolutePath()     // Catch:{ all -> 0x00d8 }
                com.mob.tools.gui.BitmapProcessor$BitmapDesiredOptions r1 = r11.bitmapDesiredOptions     // Catch:{ all -> 0x00d8 }
                int r5 = r1.desiredWidth     // Catch:{ all -> 0x00d8 }
                com.mob.tools.gui.BitmapProcessor$BitmapDesiredOptions r1 = r11.bitmapDesiredOptions     // Catch:{ all -> 0x00d8 }
                int r6 = r1.desiredHeight     // Catch:{ all -> 0x00d8 }
                com.mob.tools.gui.BitmapProcessor$BitmapDesiredOptions r1 = r11.bitmapDesiredOptions     // Catch:{ all -> 0x00d8 }
                int r7 = r1.quality     // Catch:{ all -> 0x00d8 }
                com.mob.tools.gui.BitmapProcessor$BitmapDesiredOptions r1 = r11.bitmapDesiredOptions     // Catch:{ all -> 0x00d8 }
                long r8 = r1.maxBytes     // Catch:{ all -> 0x00d8 }
                android.graphics.Bitmap r1 = com.mob.tools.utils.BitmapHelper.getBitmapByCompressQuality(r4, r5, r6, r7, r8)     // Catch:{ all -> 0x00d8 }
                goto L_0x0098
            L_0x0090:
                java.lang.String r1 = r2.getAbsolutePath()     // Catch:{ all -> 0x00d8 }
                android.graphics.Bitmap r1 = com.mob.tools.utils.BitmapHelper.getBitmap(r1)     // Catch:{ all -> 0x00d8 }
            L_0x0098:
                if (r1 == 0) goto L_0x00bc
                boolean r2 = r11.useRamCache     // Catch:{ all -> 0x00d8 }
                if (r2 == 0) goto L_0x00b8
                com.mob.tools.gui.CachePoolInner r2 = com.mob.tools.gui.BitmapProcessor.cachePool     // Catch:{ all -> 0x00d8 }
                java.lang.String r3 = r11.url     // Catch:{ all -> 0x00d8 }
                com.mob.tools.gui.BitmapProcessor$BitmapDesiredOptions r4 = r11.bitmapDesiredOptions     // Catch:{ all -> 0x00d8 }
                java.lang.String r3 = com.mob.tools.gui.BitmapProcessor.getCacheKey(r3, r4)     // Catch:{ all -> 0x00d8 }
                java.lang.ref.SoftReference r4 = new java.lang.ref.SoftReference     // Catch:{ all -> 0x00d8 }
                r4.<init>(r1)     // Catch:{ all -> 0x00d8 }
                r2.put(r3, r4)     // Catch:{ all -> 0x00d8 }
            L_0x00b8:
                r11.throwComplete(r1)     // Catch:{ all -> 0x00d8 }
                goto L_0x00bf
            L_0x00bc:
                r11.throwError()     // Catch:{ all -> 0x00d8 }
            L_0x00bf:
                r10.curReq = r0     // Catch:{ all -> 0x00d8 }
                goto L_0x00e5
            L_0x00c2:
                com.mob.tools.network.NetworkHelper r2 = new com.mob.tools.network.NetworkHelper     // Catch:{ all -> 0x00d8 }
                r2.<init>()     // Catch:{ all -> 0x00d8 }
                java.lang.String r3 = r11.url     // Catch:{ all -> 0x00d8 }
                com.mob.tools.gui.BitmapProcessor$WorkerThread$1 r4 = new com.mob.tools.gui.BitmapProcessor$WorkerThread$1     // Catch:{ all -> 0x00d8 }
                r4.<init>(r1, r11)     // Catch:{ all -> 0x00d8 }
                com.mob.tools.network.NetworkHelper$NetworkTimeOut r1 = com.mob.tools.gui.BitmapProcessor.timeout     // Catch:{ all -> 0x00d8 }
                r2.rawGet((java.lang.String) r3, (com.mob.tools.network.RawNetworkCallback) r4, (com.mob.tools.network.NetworkHelper.NetworkTimeOut) r1)     // Catch:{ all -> 0x00d8 }
                goto L_0x00e5
            L_0x00d8:
                r1 = move-exception
                com.mob.tools.log.NLog r2 = com.mob.tools.MobLog.getInstance()
                r2.w((java.lang.Throwable) r1)
                r11.throwError()
                r10.curReq = r0
            L_0x00e5:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mob.tools.gui.BitmapProcessor.WorkerThread.doTask(com.mob.tools.gui.BitmapProcessor$ImageReq):void");
        }

        /* access modifiers changed from: private */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x0043 */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x0049 A[Catch:{ all -> 0x0054 }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void saveFile(java.io.InputStream r6, java.io.File r7) {
            /*
                r5 = this;
                r0 = 1
                r1 = 0
                r2 = 0
                boolean r3 = r7.exists()     // Catch:{ all -> 0x0043 }
                if (r3 == 0) goto L_0x000c
                r7.delete()     // Catch:{ all -> 0x0043 }
            L_0x000c:
                java.io.File r3 = r7.getParentFile()     // Catch:{ all -> 0x0043 }
                boolean r3 = r3.exists()     // Catch:{ all -> 0x0043 }
                if (r3 != 0) goto L_0x001d
                java.io.File r3 = r7.getParentFile()     // Catch:{ all -> 0x0043 }
                r3.mkdirs()     // Catch:{ all -> 0x0043 }
            L_0x001d:
                r7.createNewFile()     // Catch:{ all -> 0x0043 }
                java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ all -> 0x0043 }
                r3.<init>(r7)     // Catch:{ all -> 0x0043 }
                r2 = 256(0x100, float:3.59E-43)
                byte[] r2 = new byte[r2]     // Catch:{ all -> 0x0042 }
                int r4 = r6.read(r2)     // Catch:{ all -> 0x0042 }
            L_0x002d:
                if (r4 <= 0) goto L_0x0037
                r3.write(r2, r1, r4)     // Catch:{ all -> 0x0042 }
                int r4 = r6.read(r2)     // Catch:{ all -> 0x0042 }
                goto L_0x002d
            L_0x0037:
                r3.flush()     // Catch:{ all -> 0x0042 }
                java.io.Closeable[] r6 = new java.io.Closeable[r0]
                r6[r1] = r3
                com.mob.commons.v.a((java.io.Closeable[]) r6)
                goto L_0x0053
            L_0x0042:
                r2 = r3
            L_0x0043:
                boolean r6 = r7.exists()     // Catch:{ all -> 0x0054 }
                if (r6 == 0) goto L_0x004c
                r7.delete()     // Catch:{ all -> 0x0054 }
            L_0x004c:
                java.io.Closeable[] r6 = new java.io.Closeable[r0]
                r6[r1] = r2
                com.mob.commons.v.a((java.io.Closeable[]) r6)
            L_0x0053:
                return
            L_0x0054:
                r6 = move-exception
                java.io.Closeable[] r7 = new java.io.Closeable[r0]
                r7[r1] = r2
                com.mob.commons.v.a((java.io.Closeable[]) r7)
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mob.tools.gui.BitmapProcessor.WorkerThread.saveFile(java.io.InputStream, java.io.File):void");
        }

        public void interrupt() {
            try {
                super.interrupt();
            } catch (Throwable unused) {
            }
        }

        public void run() {
            while (BitmapProcessor.work) {
                try {
                    if (this.localType) {
                        doLocalTask();
                    } else {
                        doNetworkTask();
                    }
                } catch (Throwable th2) {
                    MobLog.getInstance().w(th2);
                }
            }
        }
    }

    static {
        NetworkHelper.NetworkTimeOut networkTimeOut = new NetworkHelper.NetworkTimeOut();
        timeout = networkTimeOut;
        networkTimeOut.connectionTimeout = 5000;
        networkTimeOut.readTimout = 20000 - 5000;
    }

    public static void deleteCacheDir(boolean z11) {
        if (z11) {
            deleteCacheDir();
        } else {
            new Thread() {
                public void run() {
                    BitmapProcessor.deleteCacheDir();
                }
            }.start();
        }
    }

    public static void deleteCachedFile(String str, BitmapDesiredOptions bitmapDesiredOptions) {
        removeBitmapFromRamCache(str, bitmapDesiredOptions);
        new File(cacheDir, Data.MD5(str)).delete();
    }

    public static Bitmap getBitmapFromCache(String str) {
        return getBitmapFromCache(str, (BitmapDesiredOptions) null);
    }

    /* access modifiers changed from: private */
    public static String getCacheKey(String str, BitmapDesiredOptions bitmapDesiredOptions) {
        if (bitmapDesiredOptions == null) {
            return str;
        }
        return str + bitmapDesiredOptions.toString();
    }

    public static long getCacheSizeInByte() {
        long j11 = 0;
        for (File length : new File(cacheDir.getPath()).listFiles()) {
            j11 += length.length();
        }
        return j11;
    }

    public static String getCacheSizeText() {
        float cacheSizeInByte = (float) getCacheSizeInByte();
        if (cacheSizeInByte < 1024.0f) {
            return String.format(Locale.CHINA, "%.02f", new Object[]{Float.valueOf(cacheSizeInByte)}) + " B";
        }
        float f11 = cacheSizeInByte / 1024.0f;
        if (f11 < 1000.0f) {
            return String.format(Locale.CHINA, "%.02f", new Object[]{Float.valueOf(f11)}) + " KB";
        }
        return String.format(Locale.CHINA, "%.02f", new Object[]{Float.valueOf(f11 / 1204.0f)}) + " MB";
    }

    public static synchronized void prepare(Context context) {
        synchronized (BitmapProcessor.class) {
            cacheDir = new File(ResHelper.getImageCachePath(context));
        }
    }

    public static synchronized void process(String str, BitmapCallback bitmapCallback) {
        synchronized (BitmapProcessor.class) {
            process(str, (BitmapDesiredOptions) null, bitmapCallback);
        }
    }

    public static void removeBitmapFromRamCache(String str, BitmapDesiredOptions bitmapDesiredOptions) {
        CachePoolInner<String, SoftReference<Bitmap>> cachePoolInner = cachePool;
        if (cachePoolInner != null) {
            cachePoolInner.put(getCacheKey(str, bitmapDesiredOptions), null);
        }
    }

    public static synchronized void start() {
        synchronized (BitmapProcessor.class) {
            if (!work) {
                work = true;
                manager = new ManagerThread();
            }
        }
    }

    public static synchronized void stop() {
        synchronized (BitmapProcessor.class) {
            if (work) {
                work = false;
                synchronized (reqList) {
                    reqList.clear();
                    cachePool.clear();
                }
                manager.quit();
            }
        }
    }

    public static Bitmap getBitmapFromCache(String str, BitmapDesiredOptions bitmapDesiredOptions) {
        CachePoolInner<String, SoftReference<Bitmap>> cachePoolInner = cachePool;
        if (cachePoolInner == null || str == null || cachePoolInner.get(getCacheKey(str, bitmapDesiredOptions)) == null) {
            return null;
        }
        return (Bitmap) cachePool.get(getCacheKey(str, bitmapDesiredOptions)).get();
    }

    public static synchronized void process(String str, BitmapDesiredOptions bitmapDesiredOptions, BitmapCallback bitmapCallback) {
        synchronized (BitmapProcessor.class) {
            process(str, bitmapDesiredOptions, true, bitmapCallback);
        }
    }

    /* access modifiers changed from: private */
    public static synchronized void deleteCacheDir() {
        synchronized (BitmapProcessor.class) {
            File file = new File(cacheDir.getPath());
            if (file.isDirectory()) {
                String[] list = file.list();
                for (String file2 : list) {
                    new File(file, file2).delete();
                }
            }
        }
    }

    public static synchronized void process(String str, BitmapDesiredOptions bitmapDesiredOptions, boolean z11, BitmapCallback bitmapCallback) {
        synchronized (BitmapProcessor.class) {
            process(str, bitmapDesiredOptions, z11, true, bitmapCallback);
        }
    }

    public static synchronized void process(String str, BitmapDesiredOptions bitmapDesiredOptions, boolean z11, boolean z12, BitmapCallback bitmapCallback) {
        synchronized (BitmapProcessor.class) {
            process(str, bitmapDesiredOptions, z11, z12, 0, bitmapCallback);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
        r1 = new com.mob.tools.gui.BitmapProcessor.ImageReq();
        com.mob.tools.gui.BitmapProcessor.ImageReq.access$002(r1, r8);
        com.mob.tools.gui.BitmapProcessor.ImageReq.access$102(r1, r9);
        com.mob.tools.gui.BitmapProcessor.ImageReq.access$302(r1, r10);
        com.mob.tools.gui.BitmapProcessor.ImageReq.access$402(r1, r12);
        com.mob.tools.gui.BitmapProcessor.ImageReq.access$502(r1, r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0075, code lost:
        if (r14 == null) goto L_0x007e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0077, code lost:
        com.mob.tools.gui.BitmapProcessor.ImageReq.access$200(r1).add(r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x007e, code lost:
        r8 = reqList;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0080, code lost:
        monitor-enter(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:?, code lost:
        reqList.add(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x008e, code lost:
        if (reqList.size() <= 120) goto L_0x00a0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0098, code lost:
        if (reqList.size() <= 100) goto L_0x00a0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x009a, code lost:
        reqList.remove(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00a0, code lost:
        monitor-exit(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:?, code lost:
        start();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00a5, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void process(java.lang.String r8, com.mob.tools.gui.BitmapProcessor.BitmapDesiredOptions r9, boolean r10, boolean r11, long r12, com.mob.tools.gui.BitmapProcessor.BitmapCallback r14) {
        /*
            java.lang.Class<com.mob.tools.gui.BitmapProcessor> r0 = com.mob.tools.gui.BitmapProcessor.class
            monitor-enter(r0)
            if (r8 != 0) goto L_0x0007
            monitor-exit(r0)
            return
        L_0x0007:
            java.util.ArrayList<com.mob.tools.gui.BitmapProcessor$ImageReq> r1 = reqList     // Catch:{ all -> 0x00ac }
            monitor-enter(r1)     // Catch:{ all -> 0x00ac }
            java.util.ArrayList<com.mob.tools.gui.BitmapProcessor$ImageReq> r2 = reqList     // Catch:{ all -> 0x00a9 }
            int r2 = r2.size()     // Catch:{ all -> 0x00a9 }
            r3 = 0
            r4 = r3
        L_0x0012:
            if (r4 >= r2) goto L_0x0060
            java.util.ArrayList<com.mob.tools.gui.BitmapProcessor$ImageReq> r5 = reqList     // Catch:{ all -> 0x00a9 }
            java.lang.Object r5 = r5.get(r4)     // Catch:{ all -> 0x00a9 }
            com.mob.tools.gui.BitmapProcessor$ImageReq r5 = (com.mob.tools.gui.BitmapProcessor.ImageReq) r5     // Catch:{ all -> 0x00a9 }
            java.lang.String r6 = r5.url     // Catch:{ all -> 0x00a9 }
            boolean r6 = r6.equals(r8)     // Catch:{ all -> 0x00a9 }
            com.mob.tools.gui.BitmapProcessor$BitmapDesiredOptions r7 = r5.bitmapDesiredOptions     // Catch:{ all -> 0x00a9 }
            if (r7 != 0) goto L_0x002c
            if (r9 == 0) goto L_0x003c
        L_0x002c:
            com.mob.tools.gui.BitmapProcessor$BitmapDesiredOptions r7 = r5.bitmapDesiredOptions     // Catch:{ all -> 0x00a9 }
            if (r7 == 0) goto L_0x003e
            com.mob.tools.gui.BitmapProcessor$BitmapDesiredOptions r7 = r5.bitmapDesiredOptions     // Catch:{ all -> 0x00a9 }
            boolean r7 = r7.equals(r9)     // Catch:{ all -> 0x00a9 }
            if (r7 == 0) goto L_0x003e
        L_0x003c:
            r7 = 1
            goto L_0x003f
        L_0x003e:
            r7 = r3
        L_0x003f:
            if (r6 == 0) goto L_0x005d
            if (r7 == 0) goto L_0x005d
            if (r14 == 0) goto L_0x0057
            java.util.ArrayList r8 = r5.callbacks     // Catch:{ all -> 0x00a9 }
            int r8 = r8.indexOf(r14)     // Catch:{ all -> 0x00a9 }
            r9 = -1
            if (r8 != r9) goto L_0x0057
            java.util.ArrayList r8 = r5.callbacks     // Catch:{ all -> 0x00a9 }
            r8.add(r14)     // Catch:{ all -> 0x00a9 }
        L_0x0057:
            start()     // Catch:{ all -> 0x00a9 }
            monitor-exit(r1)     // Catch:{ all -> 0x00a9 }
            monitor-exit(r0)
            return
        L_0x005d:
            int r4 = r4 + 1
            goto L_0x0012
        L_0x0060:
            monitor-exit(r1)     // Catch:{ all -> 0x00a9 }
            com.mob.tools.gui.BitmapProcessor$ImageReq r1 = new com.mob.tools.gui.BitmapProcessor$ImageReq     // Catch:{ all -> 0x00ac }
            r1.<init>()     // Catch:{ all -> 0x00ac }
            java.lang.String unused = r1.url = r8     // Catch:{ all -> 0x00ac }
            com.mob.tools.gui.BitmapProcessor.BitmapDesiredOptions unused = r1.bitmapDesiredOptions = r9     // Catch:{ all -> 0x00ac }
            boolean unused = r1.useRamCache = r10     // Catch:{ all -> 0x00ac }
            long unused = r1.diskCacheTime = r12     // Catch:{ all -> 0x00ac }
            boolean unused = r1.useDiskCache = r11     // Catch:{ all -> 0x00ac }
            if (r14 == 0) goto L_0x007e
            java.util.ArrayList r8 = r1.callbacks     // Catch:{ all -> 0x00ac }
            r8.add(r14)     // Catch:{ all -> 0x00ac }
        L_0x007e:
            java.util.ArrayList<com.mob.tools.gui.BitmapProcessor$ImageReq> r8 = reqList     // Catch:{ all -> 0x00ac }
            monitor-enter(r8)     // Catch:{ all -> 0x00ac }
            java.util.ArrayList<com.mob.tools.gui.BitmapProcessor$ImageReq> r9 = reqList     // Catch:{ all -> 0x00a6 }
            r9.add(r1)     // Catch:{ all -> 0x00a6 }
            java.util.ArrayList<com.mob.tools.gui.BitmapProcessor$ImageReq> r9 = reqList     // Catch:{ all -> 0x00a6 }
            int r9 = r9.size()     // Catch:{ all -> 0x00a6 }
            r10 = 120(0x78, float:1.68E-43)
            if (r9 <= r10) goto L_0x00a0
        L_0x0090:
            java.util.ArrayList<com.mob.tools.gui.BitmapProcessor$ImageReq> r9 = reqList     // Catch:{ all -> 0x00a6 }
            int r9 = r9.size()     // Catch:{ all -> 0x00a6 }
            r10 = 100
            if (r9 <= r10) goto L_0x00a0
            java.util.ArrayList<com.mob.tools.gui.BitmapProcessor$ImageReq> r9 = reqList     // Catch:{ all -> 0x00a6 }
            r9.remove(r3)     // Catch:{ all -> 0x00a6 }
            goto L_0x0090
        L_0x00a0:
            monitor-exit(r8)     // Catch:{ all -> 0x00a6 }
            start()     // Catch:{ all -> 0x00ac }
            monitor-exit(r0)
            return
        L_0x00a6:
            r9 = move-exception
            monitor-exit(r8)     // Catch:{ all -> 0x00a6 }
            throw r9     // Catch:{ all -> 0x00ac }
        L_0x00a9:
            r8 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x00a9 }
            throw r8     // Catch:{ all -> 0x00ac }
        L_0x00ac:
            r8 = move-exception
            monitor-exit(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.tools.gui.BitmapProcessor.process(java.lang.String, com.mob.tools.gui.BitmapProcessor$BitmapDesiredOptions, boolean, boolean, long, com.mob.tools.gui.BitmapProcessor$BitmapCallback):void");
    }
}
