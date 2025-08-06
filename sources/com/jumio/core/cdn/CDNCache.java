package com.jumio.core.cdn;

import android.content.res.AssetManager;
import com.jumio.commons.log.Log;
import d10.l;
import iw.b;
import iw.c;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.jvm.internal.x;

public final class CDNCache implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public transient File f39064a = new File("");

    /* renamed from: b  reason: collision with root package name */
    public transient AssetManager f39065b;

    /* renamed from: c  reason: collision with root package name */
    public transient ExecutorService f39066c;

    /* renamed from: d  reason: collision with root package name */
    public final LinkedHashMap f39067d = new LinkedHashMap();

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public String f39068a;

        /* renamed from: b  reason: collision with root package name */
        public final AtomicBoolean f39069b;

        public a() {
            this(0);
        }

        public /* synthetic */ a(int i11) {
            this("");
        }

        public final void a(String str) {
            this.f39068a = str;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && x.b(this.f39068a, ((a) obj).f39068a);
        }

        public final int hashCode() {
            return this.f39068a.hashCode();
        }

        public final String toString() {
            String str = this.f39068a;
            return "AssetResult(path=" + str + ")";
        }

        public a(String str) {
            this.f39068a = str;
            this.f39069b = new AtomicBoolean(false);
        }

        public final AtomicBoolean a() {
            return this.f39069b;
        }
    }

    public static final void a(CDNCache cDNCache, String str, String str2, a aVar) {
        cDNCache.a(str, str2, aVar);
    }

    public static /* synthetic */ void load$default(CDNCache cDNCache, String str, String str2, int i11, l lVar, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            str2 = str;
        }
        if ((i12 & 4) != 0) {
            i11 = CDNDownload.DEFAULT_TIMEOUT;
        }
        if ((i12 & 8) != 0) {
            lVar = null;
        }
        cDNCache.load(str, str2, i11, lVar);
    }

    public final void b(String str) {
        String[] list;
        AssetManager assetManager = this.f39065b;
        if (assetManager != null && (list = assetManager.list(str)) != null) {
            if (!(list.length == 0) || !StringsKt__StringsJVMKt.v(str, ".enc", false, 2, (Object) null)) {
                if (!(list.length == 0)) {
                    for (String str2 : list) {
                        String a11 = a(str);
                        b(a11 + str2);
                    }
                    return;
                }
                return;
            }
            this.f39067d.put(StringsKt__StringsKt.a1(str, "/", (String) null, 2, (Object) null), str);
        }
    }

    public final String c(String str) {
        String[] list;
        String str2 = (String) this.f39067d.get(str);
        if (str2 == null) {
            str2 = "";
        }
        a aVar = new a(str2);
        boolean z11 = true;
        if (aVar.f39068a.length() > 0) {
            return aVar.f39068a;
        }
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(5);
        AssetManager assetManager = this.f39065b;
        if (!(assetManager == null || (list = assetManager.list("")) == null)) {
            if (list.length != 0) {
                z11 = false;
            }
            if (!z11) {
                for (String bVar : list) {
                    newFixedThreadPool.execute(new b(this, str, bVar, aVar));
                }
            }
        }
        newFixedThreadPool.shutdown();
        try {
            newFixedThreadPool.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e11) {
            Log.printStackTrace(e11);
        }
        this.f39066c = newFixedThreadPool;
        return aVar.f39068a;
    }

    public final InputStream get(String str) {
        if (str.length() == 0) {
            return null;
        }
        if (isAssetFile(str)) {
            AssetManager assetManager = this.f39065b;
            if (assetManager != null) {
                return assetManager.open(c(StringsKt__StringsKt.a1(str, "/", (String) null, 2, (Object) null)));
            }
            return null;
        } else if (isFile(str)) {
            return new FileInputStream(new File(this.f39064a, str));
        } else {
            return null;
        }
    }

    public final AssetManager getAssetManager() {
        return this.f39065b;
    }

    public final File getDirectory() {
        return this.f39064a;
    }

    public final boolean has(String str) {
        return (str.length() > 0) && (isFile(str) || isAssetFile(str));
    }

    public final boolean isAssetFile(String str) {
        ExecutorService executorService;
        try {
            ExecutorService executorService2 = this.f39066c;
            if ((executorService2 != null && !executorService2.isTerminated()) && (executorService = this.f39066c) != null) {
                executorService.awaitTermination(5, TimeUnit.SECONDS);
            }
        } catch (InterruptedException e11) {
            Log.printStackTrace(e11);
        }
        if (this.f39067d.get(StringsKt__StringsKt.a1(str, "/", (String) null, 2, (Object) null)) != null) {
            return true;
        }
        return false;
    }

    public final synchronized boolean isFile(String str) {
        return new File(this.f39064a, str).exists();
    }

    public final synchronized void load(String str, String str2, int i11, l<? super Boolean, Unit> lVar) {
        if (!(str.length() > 0) || has(str2)) {
            Log.d(str + " already available locally!");
            if (lVar != null) {
                lVar.invoke(Boolean.TRUE);
            }
        } else {
            Log.d("Download " + str + " from CDN");
            new CDNDownload(str, new File(this.f39064a, str2), i11, lVar);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0040, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0042, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void remove(java.lang.String r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            int r0 = r3.length()     // Catch:{ all -> 0x0043 }
            if (r0 != 0) goto L_0x0009
            r0 = 1
            goto L_0x000a
        L_0x0009:
            r0 = 0
        L_0x000a:
            if (r0 != 0) goto L_0x0041
            boolean r0 = r2.isFile(r3)     // Catch:{ all -> 0x0043 }
            if (r0 != 0) goto L_0x0013
            goto L_0x0041
        L_0x0013:
            java.io.File r0 = new java.io.File     // Catch:{ all -> 0x0043 }
            java.io.File r1 = r2.f39064a     // Catch:{ all -> 0x0043 }
            r0.<init>(r1, r3)     // Catch:{ all -> 0x0043 }
            java.lang.String r3 = r0.getAbsolutePath()     // Catch:{ all -> 0x0043 }
            java.io.File r1 = r2.f39064a     // Catch:{ all -> 0x0043 }
            java.lang.String r1 = r1.getAbsolutePath()     // Catch:{ all -> 0x0043 }
            boolean r3 = kotlin.jvm.internal.x.b(r3, r1)     // Catch:{ all -> 0x0043 }
            if (r3 == 0) goto L_0x002c
            monitor-exit(r2)
            return
        L_0x002c:
            boolean r3 = r0.isDirectory()     // Catch:{ all -> 0x0043 }
            if (r3 == 0) goto L_0x0036
            boolean unused = kotlin.io.FilesKt__UtilsKt.f(r0)     // Catch:{ all -> 0x0043 }
            goto L_0x003f
        L_0x0036:
            boolean r3 = r0.isFile()     // Catch:{ all -> 0x0043 }
            if (r3 == 0) goto L_0x003f
            r0.delete()     // Catch:{ all -> 0x0043 }
        L_0x003f:
            monitor-exit(r2)
            return
        L_0x0041:
            monitor-exit(r2)
            return
        L_0x0043:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.core.cdn.CDNCache.remove(java.lang.String):void");
    }

    public final void setAssetManager(AssetManager assetManager) {
        this.f39065b = assetManager;
        a();
    }

    public final void setDirectory(File file) {
        File file2 = new File(file, "cdn");
        this.f39064a = file2;
        if (!file2.exists()) {
            this.f39064a.mkdirs();
        }
    }

    public final void a(String str, String str2, a aVar) {
        AssetManager assetManager;
        String[] list;
        if (!aVar.a().get() && (assetManager = this.f39065b) != null && (list = assetManager.list(str2)) != null) {
            if (!(list.length == 0) || !x.b(str, StringsKt__StringsKt.a1(str2, "/", (String) null, 2, (Object) null))) {
                if (!(list.length == 0)) {
                    for (String str3 : list) {
                        String a11 = a(str2);
                        a(str, a11 + str3, aVar);
                    }
                    return;
                }
                return;
            }
            aVar.a().set(true);
            aVar.a(str2);
        }
    }

    public final void a() {
        this.f39067d.clear();
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(5);
        newFixedThreadPool.execute(new c(this, newFixedThreadPool));
        this.f39066c = newFixedThreadPool;
    }

    public static final void a(CDNCache cDNCache, ExecutorService executorService) {
        String[] list;
        AssetManager assetManager = cDNCache.f39065b;
        if (!(assetManager == null || (list = assetManager.list("")) == null)) {
            if (!(list.length == 0)) {
                for (String aVar : list) {
                    executorService.execute(new iw.a(cDNCache, aVar));
                }
            }
        }
        executorService.shutdown();
    }

    public static final void a(CDNCache cDNCache, String str) {
        cDNCache.b(str);
    }

    public static String a(String str) {
        String str2 = str.length() > 0 ? "/" : "";
        return str + str2;
    }
}
