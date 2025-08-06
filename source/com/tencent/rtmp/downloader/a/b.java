package com.tencent.rtmp.downloader.a;

import android.app.Application;
import android.content.Context;
import android.os.Parcel;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.liteav.base.ContextUtils;
import com.tencent.liteav.base.storage.PersistStorage;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.txcplayer.a.a;
import com.tencent.liteav.txcvodplayer.b.e;
import com.tencent.rtmp.TXPlayerAuthBuilder;
import com.tencent.rtmp.TXPlayerDrmBuilder;
import com.tencent.rtmp.downloader.ITXVodDownloadListener;
import com.tencent.rtmp.downloader.TXVodDownloadDataSource;
import com.tencent.rtmp.downloader.TXVodDownloadManager;
import com.tencent.rtmp.downloader.TXVodDownloadMediaInfo;
import com.tencent.rtmp.downloader.a.d;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public d f48635a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<c> f48636b;

    /* renamed from: c  reason: collision with root package name */
    public ITXVodDownloadListener f48637c;

    /* renamed from: d  reason: collision with root package name */
    public d.a f48638d = new d.a() {
        public final void a(c cVar) {
            if (cVar != null) {
                LiteavLog.i("TXVodDownloadManagerImpl", "downloadBegin " + cVar.getPlayPath());
                cVar.d(1);
                b.a(b.this, cVar);
                ITXVodDownloadListener iTXVodDownloadListener = b.this.f48637c;
                if (iTXVodDownloadListener != null) {
                    iTXVodDownloadListener.onDownloadStart(cVar);
                }
            }
        }

        public final void b(c cVar) {
            if (cVar != null) {
                LiteavLog.i("TXVodDownloadManagerImpl", "downloadEnd " + cVar.getPlayPath());
                cVar.d(2);
                b.a(b.this, cVar);
                synchronized (b.this.f48636b) {
                    b.this.f48636b.remove(cVar);
                }
                ITXVodDownloadListener iTXVodDownloadListener = b.this.f48637c;
                if (iTXVodDownloadListener != null) {
                    iTXVodDownloadListener.onDownloadStop(cVar);
                }
            }
        }

        public final void c(c cVar) {
            if (cVar != null) {
                LiteavLog.i("TXVodDownloadManagerImpl", "downloadFinish " + cVar.getPlayPath());
                cVar.d(4);
                b.a(b.this, cVar);
                synchronized (b.this.f48636b) {
                    b.this.f48636b.remove(cVar);
                }
                ITXVodDownloadListener iTXVodDownloadListener = b.this.f48637c;
                if (iTXVodDownloadListener != null) {
                    iTXVodDownloadListener.onDownloadFinish(cVar);
                }
            }
        }

        public final void d(c cVar) {
            ITXVodDownloadListener iTXVodDownloadListener;
            if (cVar != null && (iTXVodDownloadListener = b.this.f48637c) != null) {
                iTXVodDownloadListener.onDownloadProgress(cVar);
            }
        }

        public final void a(c cVar, int i11, String str) {
            if (cVar != null) {
                LiteavLog.w("TXVodDownloadManagerImpl", "downloadError " + cVar.getPlayPath() + " " + i11 + " ： " + str);
                cVar.d(3);
                b.a(b.this, cVar);
                synchronized (b.this.f48636b) {
                    b.this.f48636b.remove(cVar);
                }
                if (b.this.f48637c == null) {
                    return;
                }
                if (cVar.getDownloadState() == 2) {
                    b.this.f48637c.onDownloadStop(cVar);
                } else if (i11 == 1008) {
                    b.this.f48637c.onDownloadError(cVar, TXVodDownloadManager.DOWNLOAD_HLS_KEY_ERROR, str);
                } else if (i11 == 14020003) {
                    b.this.f48637c.onDownloadError(cVar, TXVodDownloadManager.DOWNLOAD_403FORBIDDEN, str);
                } else {
                    b.this.f48637c.onDownloadError(cVar, TXVodDownloadManager.DOWNLOAD_DISCONNECT, str);
                }
            }
        }
    };

    /* renamed from: e  reason: collision with root package name */
    private PersistStorage f48639e;

    public b() {
        Context b11 = b();
        d a11 = d.a(b11);
        this.f48635a = a11;
        if (a11 != null) {
            a11.f48650b = this.f48638d;
        }
        this.f48636b = new ArrayList<>();
        if (b11 != null) {
            ContextUtils.initApplicationContext(b11);
            ContextUtils.setDataDirectorySuffix("liteav");
            this.f48639e = new PersistStorage("vod_download");
        }
    }

    private static Context b() {
        try {
            Method method = Class.forName("android.app.ActivityThread").getMethod("currentActivityThread", new Class[0]);
            if (method == null) {
                return null;
            }
            method.setAccessible(true);
            Object invoke = method.invoke((Object) null, new Object[0]);
            Method method2 = invoke.getClass().getMethod("getApplication", new Class[0]);
            if (method2 == null) {
                return null;
            }
            return ((Application) method2.invoke(invoke, new Object[0])).getApplicationContext();
        } catch (Throwable th2) {
            th2.printStackTrace();
            return null;
        }
    }

    private String c(TXVodDownloadMediaInfo tXVodDownloadMediaInfo) {
        TXVodDownloadDataSource dataSource = tXVodDownloadMediaInfo.getDataSource();
        if (dataSource == null) {
            if (TextUtils.isEmpty(tXVodDownloadMediaInfo.getUrl())) {
                return null;
            }
            String str = "_" + a.b(tXVodDownloadMediaInfo.getUrl());
            if (!TextUtils.isEmpty(this.f48639e.getString(str))) {
                return str;
            }
            String str2 = tXVodDownloadMediaInfo.getUserName() + str;
            if (!TextUtils.isEmpty(this.f48639e.getString(str2)) || tXVodDownloadMediaInfo.getPreferredResolution() <= 0) {
                return str2;
            }
            return str2 + "_" + tXVodDownloadMediaInfo.getPreferredResolution();
        } else if (TextUtils.isEmpty(dataSource.getFileId())) {
            return null;
        } else {
            return dataSource.getUserName() + "_" + dataSource.getAppId() + "_" + dataSource.getFileId() + "_" + dataSource.getQuality();
        }
    }

    private c d(TXVodDownloadMediaInfo tXVodDownloadMediaInfo) {
        c cVar = null;
        if (tXVodDownloadMediaInfo != null) {
            synchronized (this.f48636b) {
                Iterator<c> it2 = this.f48636b.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    c next = it2.next();
                    if (next.getPlayPath().equals(tXVodDownloadMediaInfo.getPlayPath())) {
                        cVar = next;
                        break;
                    }
                }
            }
        }
        return cVar;
    }

    public final c a(TXVodDownloadMediaInfo tXVodDownloadMediaInfo) {
        c b11;
        String c11 = c(tXVodDownloadMediaInfo);
        if (TextUtils.isEmpty(c11)) {
            return null;
        }
        String string = this.f48639e.getString(c11);
        if (TextUtils.isEmpty(string) || (b11 = b(string)) == null) {
            return null;
        }
        LiteavLog.i("TXVodDownloadManagerImpl", "partly download, resume download");
        a(b11);
        return b11;
    }

    public final c a(final TXVodDownloadDataSource tXVodDownloadDataSource) {
        final a aVar;
        final c cVar = new c();
        if (TextUtils.isEmpty(tXVodDownloadDataSource.getTemplateName())) {
            aVar = new a(tXVodDownloadDataSource.getAuthBuilder(), tXVodDownloadDataSource.getQuality());
        } else {
            aVar = new a(tXVodDownloadDataSource.getAuthBuilder(), tXVodDownloadDataSource.getTemplateName());
        }
        cVar.a(aVar);
        c a11 = a((TXVodDownloadMediaInfo) cVar);
        if (a11 != null) {
            return a11;
        }
        if (tXVodDownloadDataSource.getAuthBuilder() == null) {
            return null;
        }
        TXPlayerAuthBuilder authBuilder = aVar.getAuthBuilder();
        com.tencent.liteav.txcvodplayer.b.d dVar = new com.tencent.liteav.txcvodplayer.b.d();
        dVar.f21932c = authBuilder.isHttps();
        dVar.a(new e() {
            /* JADX WARNING: Removed duplicated region for block: B:31:0x0076  */
            /* JADX WARNING: Removed duplicated region for block: B:55:0x00dc  */
            /* JADX WARNING: Removed duplicated region for block: B:67:0x00fe  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void a(com.tencent.liteav.txcvodplayer.b.d r8) {
                /*
                    r7 = this;
                    com.tencent.rtmp.downloader.a.c r0 = r0
                    int r0 = r0.getDownloadState()
                    r1 = 2
                    if (r0 != r1) goto L_0x002e
                    com.tencent.rtmp.downloader.a.b r8 = com.tencent.rtmp.downloader.a.b.this
                    java.util.ArrayList<com.tencent.rtmp.downloader.a.c> r0 = r8.f48636b
                    monitor-enter(r0)
                    com.tencent.rtmp.downloader.a.b r8 = com.tencent.rtmp.downloader.a.b.this     // Catch:{ all -> 0x002b }
                    java.util.ArrayList<com.tencent.rtmp.downloader.a.c> r8 = r8.f48636b     // Catch:{ all -> 0x002b }
                    com.tencent.rtmp.downloader.a.c r1 = r0     // Catch:{ all -> 0x002b }
                    r8.remove(r1)     // Catch:{ all -> 0x002b }
                    monitor-exit(r0)     // Catch:{ all -> 0x002b }
                    com.tencent.rtmp.downloader.a.b r8 = com.tencent.rtmp.downloader.a.b.this
                    com.tencent.rtmp.downloader.ITXVodDownloadListener r8 = r8.f48637c
                    if (r8 == 0) goto L_0x0023
                    com.tencent.rtmp.downloader.a.c r0 = r0
                    r8.onDownloadStop(r0)
                L_0x0023:
                    java.lang.String r8 = "TXVodDownloadManagerImpl"
                    java.lang.String r0 = "Download task canceled"
                    com.tencent.liteav.base.util.LiteavLog.w(r8, r0)
                    return
                L_0x002b:
                    r8 = move-exception
                    monitor-exit(r0)     // Catch:{ all -> 0x002b }
                    throw r8
                L_0x002e:
                    com.tencent.liteav.txcvodplayer.b.f r8 = r8.a()
                    com.tencent.rtmp.downloader.TXVodDownloadDataSource r0 = r12
                    int r0 = r0.getQuality()
                    r1 = 1000(0x3e8, float:1.401E-42)
                    r2 = 0
                    if (r0 == r1) goto L_0x00a1
                    com.tencent.rtmp.downloader.a.a r0 = r1
                    int r0 = r0.getQuality()
                    if (r0 != 0) goto L_0x004c
                    com.tencent.liteav.txcvodplayer.b.g r8 = r8.f()
                    r2 = r8
                    goto L_0x00da
                L_0x004c:
                    java.lang.String r0 = com.tencent.rtmp.downloader.a.a.b((int) r0)
                    java.lang.String r3 = "hls"
                    java.util.List r4 = r8.k()
                    if (r4 == 0) goto L_0x0073
                    java.util.Iterator r4 = r4.iterator()
                L_0x005c:
                    boolean r5 = r4.hasNext()
                    if (r5 == 0) goto L_0x0073
                    java.lang.Object r5 = r4.next()
                    com.tencent.liteav.txcvodplayer.b.f$a r5 = (com.tencent.liteav.txcvodplayer.b.f.a) r5
                    java.lang.String r6 = r5.f21950a
                    boolean r6 = r6.equals(r0)
                    if (r6 == 0) goto L_0x005c
                    java.util.List<java.lang.Integer> r0 = r5.f21952c
                    goto L_0x0074
                L_0x0073:
                    r0 = r2
                L_0x0074:
                    if (r0 == 0) goto L_0x00da
                    java.util.List r8 = r8.e()
                    java.util.Iterator r8 = r8.iterator()
                L_0x007e:
                    boolean r4 = r8.hasNext()
                    if (r4 == 0) goto L_0x00da
                    java.lang.Object r4 = r8.next()
                    com.tencent.liteav.txcvodplayer.b.g r4 = (com.tencent.liteav.txcvodplayer.b.g) r4
                    int r5 = r4.f21961i
                    java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
                    boolean r5 = r0.contains(r5)
                    if (r5 == 0) goto L_0x007e
                    java.lang.String r5 = r4.f21959g
                    if (r5 == 0) goto L_0x00d9
                    boolean r5 = r5.contains(r3)
                    if (r5 == 0) goto L_0x007e
                    goto L_0x00d9
                L_0x00a1:
                    com.tencent.rtmp.downloader.TXVodDownloadDataSource r0 = r12
                    java.lang.String r0 = r0.getTemplateName()
                    if (r0 == 0) goto L_0x00da
                    com.tencent.rtmp.downloader.a.a r0 = r1
                    java.lang.String r0 = r0.getTemplateName()
                    java.lang.String r3 = "hls"
                    if (r0 == 0) goto L_0x00da
                    java.util.List r8 = r8.e()
                    java.util.Iterator r8 = r8.iterator()
                L_0x00bb:
                    boolean r4 = r8.hasNext()
                    if (r4 == 0) goto L_0x00da
                    java.lang.Object r4 = r8.next()
                    com.tencent.liteav.txcvodplayer.b.g r4 = (com.tencent.liteav.txcvodplayer.b.g) r4
                    java.lang.String r5 = r4.f21960h
                    boolean r5 = r0.equals(r5)
                    if (r5 == 0) goto L_0x00bb
                    java.lang.String r5 = r4.f21959g
                    if (r5 == 0) goto L_0x00d9
                    boolean r5 = r5.contains(r3)
                    if (r5 == 0) goto L_0x00bb
                L_0x00d9:
                    r2 = r4
                L_0x00da:
                    if (r2 != 0) goto L_0x00fe
                    com.tencent.rtmp.downloader.a.b r8 = com.tencent.rtmp.downloader.a.b.this
                    java.util.ArrayList<com.tencent.rtmp.downloader.a.c> r8 = r8.f48636b
                    monitor-enter(r8)
                    com.tencent.rtmp.downloader.a.b r0 = com.tencent.rtmp.downloader.a.b.this     // Catch:{ all -> 0x00fb }
                    java.util.ArrayList<com.tencent.rtmp.downloader.a.c> r0 = r0.f48636b     // Catch:{ all -> 0x00fb }
                    com.tencent.rtmp.downloader.a.c r1 = r0     // Catch:{ all -> 0x00fb }
                    r0.remove(r1)     // Catch:{ all -> 0x00fb }
                    monitor-exit(r8)     // Catch:{ all -> 0x00fb }
                    com.tencent.rtmp.downloader.a.b r8 = com.tencent.rtmp.downloader.a.b.this
                    com.tencent.rtmp.downloader.ITXVodDownloadListener r8 = r8.f48637c
                    if (r8 == 0) goto L_0x00fa
                    com.tencent.rtmp.downloader.a.c r0 = r0
                    r1 = -5003(0xffffffffffffec75, float:NaN)
                    java.lang.String r2 = "No such resolution"
                    r8.onDownloadError(r0, r1, r2)
                L_0x00fa:
                    return
                L_0x00fb:
                    r0 = move-exception
                    monitor-exit(r8)     // Catch:{ all -> 0x00fb }
                    throw r0
                L_0x00fe:
                    java.lang.String r8 = r2.f21953a
                    com.tencent.rtmp.downloader.TXVodDownloadDataSource r0 = r12
                    if (r0 == 0) goto L_0x010c
                    java.lang.String r0 = r0.getToken()
                    java.lang.String r8 = com.tencent.liteav.txcplayer.a.a.a(r8, r0)
                L_0x010c:
                    com.tencent.rtmp.downloader.a.c r0 = r0
                    r0.b((java.lang.String) r8)
                    com.tencent.rtmp.downloader.a.c r8 = r0
                    long r3 = r2.f21956d
                    r8.a((long) r3)
                    com.tencent.rtmp.downloader.a.c r8 = r0
                    int r0 = r2.f21957e
                    int r0 = r0 * r1
                    r8.a((int) r0)
                    com.tencent.rtmp.downloader.a.b r8 = com.tencent.rtmp.downloader.a.b.this
                    com.tencent.rtmp.downloader.a.c r0 = r0
                    r8.a((com.tencent.rtmp.downloader.a.c) r0)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.rtmp.downloader.a.b.AnonymousClass1.a(com.tencent.liteav.txcvodplayer.b.d):void");
            }

            public final void a(com.tencent.liteav.txcvodplayer.b.d dVar, String str, int i11) {
                synchronized (b.this.f48636b) {
                    b.this.f48636b.remove(cVar);
                }
                ITXVodDownloadListener iTXVodDownloadListener = b.this.f48637c;
                if (iTXVodDownloadListener != null) {
                    iTXVodDownloadListener.onDownloadError(cVar, TXVodDownloadManager.DOWNLOAD_AUTH_FAILED, str);
                }
            }
        });
        if (dVar.a(authBuilder.getAppId(), authBuilder.getFileId(), authBuilder.getTimeout(), authBuilder.getUs(), authBuilder.getExper(), authBuilder.getSign()) == 0) {
            cVar.a(dVar);
            synchronized (this.f48636b) {
                this.f48636b.add(cVar);
            }
            return cVar;
        }
        LiteavLog.e("TXVodDownloadManagerImpl", "unable to getPlayInfo");
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0038, code lost:
        r0 = r8.f48635a;
        r1 = r9.getPlayPath();
        r2 = r0.a(r1, r9.getPreferredResolution());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0047, code lost:
        if (r2 == false) goto L_0x0082;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0049, code lost:
        r5 = r9.getDrmBuilder();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x004d, code lost:
        if (r5 == null) goto L_0x0082;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004f, code lost:
        r6 = r5.getPlayUrl();
        r5 = r5.getKeyLicenseUrl();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x005b, code lost:
        if (android.text.TextUtils.isEmpty(r6) != false) goto L_0x0082;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0061, code lost:
        if (android.text.TextUtils.isEmpty(r5) != false) goto L_0x0082;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0063, code lost:
        r1 = r1.substring(0, r1.indexOf("?"));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x007d, code lost:
        if (r0.f48652d.deleteOfflineLicenseKeySetId(r1.substring(0, r1.lastIndexOf("/")), r6, r5) != 0) goto L_0x0081;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x007f, code lost:
        r2 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0081, code lost:
        r2 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0082, code lost:
        if (r2 == false) goto L_0x00e2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0084, code lost:
        r0 = c(r9);
        r1 = r8.f48639e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x008a, code lost:
        if (r1 == null) goto L_0x00e2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x008c, code lost:
        r1.clear(r0);
        r8.f48639e.clear(r0 + "_kv");
        r8.f48639e.commit();
        r9 = r9.getDataSource();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00ae, code lost:
        if (r9 == null) goto L_0x00da;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00b8, code lost:
        if (android.text.TextUtils.isEmpty(r9.getOverlayKey()) != false) goto L_0x00da;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00ba, code lost:
        r0 = com.tencent.liteav.txcvodplayer.c.a.a();
        r1 = r9.getAppId();
        r9 = r9.getFileId();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00ca, code lost:
        if (android.text.TextUtils.isEmpty(r9) != false) goto L_0x00da;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00cc, code lost:
        r0.f21963a.clear(com.tencent.liteav.txcvodplayer.c.a.b(r1, r9));
        r0.f21963a.commit();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00da, code lost:
        com.tencent.liteav.base.util.LiteavLog.i("TXVodDownloadManagerImpl", "delete DownloadMediaInfo and file complete");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00e1, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00e2, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean b(com.tencent.rtmp.downloader.TXVodDownloadMediaInfo r9) {
        /*
            r8 = this;
            java.util.ArrayList<com.tencent.rtmp.downloader.a.c> r0 = r8.f48636b
            monitor-enter(r0)
            java.util.ArrayList<com.tencent.rtmp.downloader.a.c> r1 = r8.f48636b     // Catch:{ all -> 0x00e3 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x00e3 }
        L_0x0009:
            boolean r2 = r1.hasNext()     // Catch:{ all -> 0x00e3 }
            r3 = 0
            if (r2 == 0) goto L_0x0037
            java.lang.Object r2 = r1.next()     // Catch:{ all -> 0x00e3 }
            com.tencent.rtmp.downloader.a.c r2 = (com.tencent.rtmp.downloader.a.c) r2     // Catch:{ all -> 0x00e3 }
            java.lang.String r4 = r2.getPlayPath()     // Catch:{ all -> 0x00e3 }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x00e3 }
            if (r4 != 0) goto L_0x0009
            java.lang.String r2 = r2.getPlayPath()     // Catch:{ all -> 0x00e3 }
            java.lang.String r4 = r9.getPlayPath()     // Catch:{ all -> 0x00e3 }
            boolean r2 = r2.equals(r4)     // Catch:{ all -> 0x00e3 }
            if (r2 == 0) goto L_0x0009
            java.lang.String r9 = "TXVodDownloadManagerImpl"
            java.lang.String r1 = "file is downloading, can not be delete"
            com.tencent.liteav.base.util.LiteavLog.e(r9, r1)     // Catch:{ all -> 0x00e3 }
            monitor-exit(r0)     // Catch:{ all -> 0x00e3 }
            return r3
        L_0x0037:
            monitor-exit(r0)     // Catch:{ all -> 0x00e3 }
            com.tencent.rtmp.downloader.a.d r0 = r8.f48635a
            java.lang.String r1 = r9.getPlayPath()
            long r4 = r9.getPreferredResolution()
            boolean r2 = r0.a(r1, r4)
            r4 = 1
            if (r2 == 0) goto L_0x0082
            com.tencent.rtmp.TXPlayerDrmBuilder r5 = r9.getDrmBuilder()
            if (r5 == 0) goto L_0x0082
            java.lang.String r6 = r5.getPlayUrl()
            java.lang.String r5 = r5.getKeyLicenseUrl()
            boolean r7 = android.text.TextUtils.isEmpty(r6)
            if (r7 != 0) goto L_0x0082
            boolean r7 = android.text.TextUtils.isEmpty(r5)
            if (r7 != 0) goto L_0x0082
            java.lang.String r2 = "?"
            int r2 = r1.indexOf(r2)
            java.lang.String r1 = r1.substring(r3, r2)
            com.tencent.thumbplayer.tcmedia.core.downloadproxy.api.ITPDownloadProxy r0 = r0.f48652d
            java.lang.String r2 = "/"
            int r2 = r1.lastIndexOf(r2)
            java.lang.String r1 = r1.substring(r3, r2)
            int r0 = r0.deleteOfflineLicenseKeySetId(r1, r6, r5)
            if (r0 != 0) goto L_0x0081
            r2 = r4
            goto L_0x0082
        L_0x0081:
            r2 = r3
        L_0x0082:
            if (r2 == 0) goto L_0x00e2
            java.lang.String r0 = r8.c(r9)
            com.tencent.liteav.base.storage.PersistStorage r1 = r8.f48639e
            if (r1 == 0) goto L_0x00e2
            r1.clear(r0)
            com.tencent.liteav.base.storage.PersistStorage r1 = r8.f48639e
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
            java.lang.String r0 = "_kv"
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.clear(r0)
            com.tencent.liteav.base.storage.PersistStorage r0 = r8.f48639e
            r0.commit()
            com.tencent.rtmp.downloader.TXVodDownloadDataSource r9 = r9.getDataSource()
            if (r9 == 0) goto L_0x00da
            java.lang.String r0 = r9.getOverlayKey()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x00da
            com.tencent.liteav.txcvodplayer.c.a r0 = com.tencent.liteav.txcvodplayer.c.a.a()
            int r1 = r9.getAppId()
            java.lang.String r9 = r9.getFileId()
            boolean r2 = android.text.TextUtils.isEmpty(r9)
            if (r2 != 0) goto L_0x00da
            com.tencent.liteav.base.storage.PersistStorage r2 = r0.f21963a
            java.lang.String r9 = com.tencent.liteav.txcvodplayer.c.a.b(r1, r9)
            r2.clear(r9)
            com.tencent.liteav.base.storage.PersistStorage r9 = r0.f21963a
            r9.commit()
        L_0x00da:
            java.lang.String r9 = "TXVodDownloadManagerImpl"
            java.lang.String r0 = "delete DownloadMediaInfo and file complete"
            com.tencent.liteav.base.util.LiteavLog.i(r9, r0)
            return r4
        L_0x00e2:
            return r3
        L_0x00e3:
            r9 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00e3 }
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.rtmp.downloader.a.b.b(com.tencent.rtmp.downloader.TXVodDownloadMediaInfo):boolean");
    }

    public final void a(c cVar) {
        String url = cVar.getUrl();
        if (!TextUtils.isEmpty(url)) {
            cVar.a(a(this.f48635a.a(url), cVar));
            if (cVar.getPlayPath() == null) {
                ITXVodDownloadListener iTXVodDownloadListener = this.f48637c;
                if (iTXVodDownloadListener != null) {
                    iTXVodDownloadListener.onDownloadError(cVar, TXVodDownloadManager.DOWNLOAD_PATH_ERROR, "Failed to create local path");
                    return;
                }
                return;
            }
            LiteavLog.i("TXVodDownloadManagerImpl", "download url " + url + " to " + cVar.getPlayPath());
            synchronized (this.f48636b) {
                this.f48636b.add(cVar);
            }
            cVar.c(this.f48635a.c(cVar));
            if (cVar.getTaskId() < 0) {
                LiteavLog.e("TXVodDownloadManagerImpl", "start download failed");
                ITXVodDownloadListener iTXVodDownloadListener2 = this.f48637c;
                if (iTXVodDownloadListener2 != null) {
                    iTXVodDownloadListener2.onDownloadError(cVar, TXVodDownloadManager.DOWNLOAD_FORMAT_ERROR, "Internal error");
                }
            }
        }
    }

    private c b(String str) {
        a aVar;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        byte[] decode = Base64.decode(str, 2);
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(decode, 0, decode.length);
        obtain.setDataPosition(0);
        c createFromParcel = c.CREATOR.createFromParcel(obtain);
        obtain.recycle();
        if (createFromParcel == null) {
            return null;
        }
        if (d(createFromParcel) == null) {
            if (createFromParcel.getDownloadState() == 1) {
                createFromParcel.d(2);
                createFromParcel.a(this.f48635a.a(createFromParcel));
            }
            if (!this.f48635a.b(createFromParcel)) {
                createFromParcel.a();
            }
        }
        if (!createFromParcel.getPlayPath().contains("&oversign=") && (aVar = (a) createFromParcel.getDataSource()) != null && !TextUtils.isEmpty(aVar.getOverlayKey())) {
            createFromParcel.a(a(createFromParcel.getPlayPath(), createFromParcel));
        }
        return createFromParcel;
    }

    private static String a(String str, c cVar) {
        TXVodDownloadDataSource dataSource = cVar.getDataSource();
        StringBuilder sb2 = new StringBuilder();
        if (dataSource != null && !TextUtils.isEmpty(dataSource.getOverlayKey())) {
            sb2.append("&oversign=");
            sb2.append(dataSource.getAppId());
            sb2.append("&o1=");
            sb2.append(dataSource.getUserName());
            sb2.append("&o2=");
            sb2.append(dataSource.getFileId());
            sb2.append("&o3=");
            sb2.append(dataSource.getQuality());
            sb2.append("&o4=");
            sb2.append(dataSource.getOverlayKey());
            sb2.append("&o5=");
            sb2.append(dataSource.getOverlayIv());
        }
        if (cVar.getPreferredResolution() > 0) {
            if (sb2.length() == 0) {
                sb2.append("&oversign=");
            }
            sb2.append("&o6=");
            sb2.append(cVar.getPreferredResolution());
        }
        TXPlayerDrmBuilder drmBuilder = cVar.getDrmBuilder();
        if (drmBuilder != null) {
            String keyLicenseUrl = drmBuilder.getKeyLicenseUrl();
            if (!TextUtils.isEmpty(keyLicenseUrl)) {
                if (sb2.length() == 0) {
                    sb2.append("&oversign=");
                }
                sb2.append("&o7=");
                sb2.append(keyLicenseUrl);
            }
        }
        if (sb2.length() <= 0) {
            return str;
        }
        sb2.append("&oversign=");
        return str.concat(sb2.toString());
    }

    public final boolean a(String str) {
        LiteavLog.i("TXVodDownloadManagerImpl", "delete file ".concat(String.valueOf(str)));
        synchronized (this.f48636b) {
            Iterator<c> it2 = this.f48636b.iterator();
            while (it2.hasNext()) {
                c next = it2.next();
                if (next.getPlayPath() != null && next.getPlayPath().equals(str)) {
                    LiteavLog.e("TXVodDownloadManagerImpl", "file is downloading, can not be delete");
                    return false;
                }
            }
            return this.f48635a.a(str, -1);
        }
    }

    public final List<TXVodDownloadMediaInfo> a() {
        PersistStorage persistStorage = this.f48639e;
        if (persistStorage != null) {
            try {
                String[] allKeys = persistStorage.getAllKeys();
                if (allKeys == null) {
                    return null;
                }
                ArrayList arrayList = new ArrayList(allKeys.length);
                for (String string : allKeys) {
                    c b11 = b(this.f48639e.getString(string));
                    c d11 = d(b11);
                    if (d11 != null) {
                        arrayList.add(d11);
                    } else {
                        arrayList.add(b11);
                    }
                }
                return arrayList;
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x003e, code lost:
        if (r8.f48639e == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0040, code lost:
        r0 = new com.tencent.rtmp.downloader.a.c();
        r0.a(new com.tencent.rtmp.downloader.a.a(r9, r10, r11, (java.lang.String) null, r12));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
        return b(r8.f48639e.getString(c(r0)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:?, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.tencent.rtmp.downloader.TXVodDownloadMediaInfo a(int r9, java.lang.String r10, int r11, java.lang.String r12) {
        /*
            r8 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r10)
            r1 = 0
            if (r0 == 0) goto L_0x0008
            return r1
        L_0x0008:
            java.util.ArrayList<com.tencent.rtmp.downloader.a.c> r0 = r8.f48636b
            monitor-enter(r0)
            java.util.ArrayList<com.tencent.rtmp.downloader.a.c> r2 = r8.f48636b     // Catch:{ all -> 0x0062 }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x0062 }
        L_0x0011:
            boolean r3 = r2.hasNext()     // Catch:{ all -> 0x0062 }
            if (r3 == 0) goto L_0x003b
            java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x0062 }
            com.tencent.rtmp.downloader.a.c r3 = (com.tencent.rtmp.downloader.a.c) r3     // Catch:{ all -> 0x0062 }
            com.tencent.rtmp.downloader.TXVodDownloadDataSource r4 = r3.getDataSource()     // Catch:{ all -> 0x0062 }
            if (r4 == 0) goto L_0x0011
            int r5 = r4.getAppId()     // Catch:{ all -> 0x0062 }
            if (r5 != r9) goto L_0x0011
            java.lang.String r5 = r4.getFileId()     // Catch:{ all -> 0x0062 }
            boolean r5 = r5.equals(r10)     // Catch:{ all -> 0x0062 }
            if (r5 == 0) goto L_0x0011
            int r4 = r4.getQuality()     // Catch:{ all -> 0x0062 }
            if (r4 != r11) goto L_0x0011
            monitor-exit(r0)     // Catch:{ all -> 0x0062 }
            return r3
        L_0x003b:
            monitor-exit(r0)     // Catch:{ all -> 0x0062 }
            com.tencent.liteav.base.storage.PersistStorage r0 = r8.f48639e
            if (r0 == 0) goto L_0x0061
            com.tencent.rtmp.downloader.a.c r0 = new com.tencent.rtmp.downloader.a.c
            r0.<init>()
            com.tencent.rtmp.downloader.a.a r7 = new com.tencent.rtmp.downloader.a.a
            r5 = 0
            r1 = r7
            r2 = r9
            r3 = r10
            r4 = r11
            r6 = r12
            r1.<init>(r2, r3, r4, r5, r6)
            r0.a((com.tencent.rtmp.downloader.a.a) r7)
            java.lang.String r9 = r8.c(r0)
            com.tencent.liteav.base.storage.PersistStorage r10 = r8.f48639e
            java.lang.String r9 = r10.getString(r9)
            com.tencent.rtmp.downloader.a.c r1 = r8.b((java.lang.String) r9)
        L_0x0061:
            return r1
        L_0x0062:
            r9 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0062 }
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.rtmp.downloader.a.b.a(int, java.lang.String, int, java.lang.String):com.tencent.rtmp.downloader.TXVodDownloadMediaInfo");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0032, code lost:
        if (r5.f48639e == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0034, code lost:
        r0 = new com.tencent.rtmp.downloader.a.c();
        r0.b(r6);
        r0.c(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0043, code lost:
        if (r7 <= 0) goto L_0x0048;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0045, code lost:
        r0.c(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
        return b(r5.f48639e.getString(c(r0)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.tencent.rtmp.downloader.TXVodDownloadMediaInfo a(java.lang.String r6, long r7, java.lang.String r9) {
        /*
            r5 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r6)
            r1 = 0
            if (r0 == 0) goto L_0x0008
            return r1
        L_0x0008:
            java.util.ArrayList<com.tencent.rtmp.downloader.a.c> r0 = r5.f48636b
            monitor-enter(r0)
            java.util.ArrayList<com.tencent.rtmp.downloader.a.c> r2 = r5.f48636b     // Catch:{ all -> 0x0057 }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x0057 }
        L_0x0011:
            boolean r3 = r2.hasNext()     // Catch:{ all -> 0x0057 }
            if (r3 == 0) goto L_0x002f
            java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x0057 }
            com.tencent.rtmp.downloader.a.c r3 = (com.tencent.rtmp.downloader.a.c) r3     // Catch:{ all -> 0x0057 }
            java.lang.String r4 = r3.getUrl()     // Catch:{ all -> 0x0057 }
            if (r4 == 0) goto L_0x0011
            java.lang.String r4 = r3.getUrl()     // Catch:{ all -> 0x0057 }
            boolean r4 = r4.equals(r6)     // Catch:{ all -> 0x0057 }
            if (r4 == 0) goto L_0x0011
            monitor-exit(r0)     // Catch:{ all -> 0x0057 }
            return r3
        L_0x002f:
            monitor-exit(r0)     // Catch:{ all -> 0x0057 }
            com.tencent.liteav.base.storage.PersistStorage r0 = r5.f48639e
            if (r0 == 0) goto L_0x0056
            com.tencent.rtmp.downloader.a.c r0 = new com.tencent.rtmp.downloader.a.c
            r0.<init>()
            r0.b((java.lang.String) r6)
            r0.c((java.lang.String) r9)
            r1 = 0
            int r6 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r6 <= 0) goto L_0x0048
            r0.c((long) r7)
        L_0x0048:
            java.lang.String r6 = r5.c(r0)
            com.tencent.liteav.base.storage.PersistStorage r7 = r5.f48639e
            java.lang.String r6 = r7.getString(r6)
            com.tencent.rtmp.downloader.a.c r1 = r5.b((java.lang.String) r6)
        L_0x0056:
            return r1
        L_0x0057:
            r6 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0057 }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.rtmp.downloader.a.b.a(java.lang.String, long, java.lang.String):com.tencent.rtmp.downloader.TXVodDownloadMediaInfo");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00d1, code lost:
        if (r4 > 0) goto L_0x00dd;
     */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00e8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ void a(com.tencent.rtmp.downloader.a.b r11, com.tencent.rtmp.downloader.a.c r12, com.tencent.liteav.txcvodplayer.b.c r13) {
        /*
            java.lang.String r0 = "get substream infos failure"
            r1 = -5001(0xffffffffffffec77, float:NaN)
            if (r13 == 0) goto L_0x00ef
            com.tencent.rtmp.downloader.TXVodDownloadDataSource r2 = r12.getDataSource()
            if (r2 != 0) goto L_0x000e
            goto L_0x00ef
        L_0x000e:
            java.lang.String r2 = r13.a()
            java.lang.String r3 = "Widevine"
            java.lang.String r3 = r13.a((java.lang.String) r3)
            boolean r4 = android.text.TextUtils.isEmpty(r3)
            r5 = 0
            if (r4 != 0) goto L_0x0029
            com.tencent.rtmp.TXPlayerDrmBuilder r2 = new com.tencent.rtmp.TXPlayerDrmBuilder
            java.lang.String r4 = r13.l()
            r2.<init>(r4, r3)
            goto L_0x0032
        L_0x0029:
            java.lang.String r3 = r13.c()
            java.lang.String r3 = com.tencent.liteav.txcplayer.a.a.a(r2, r3)
            r2 = r5
        L_0x0032:
            boolean r4 = android.text.TextUtils.isEmpty(r3)
            if (r4 == 0) goto L_0x0040
            com.tencent.rtmp.downloader.ITXVodDownloadListener r11 = r11.f48637c
            if (r11 == 0) goto L_0x003f
            r11.onDownloadError(r12, r1, r0)
        L_0x003f:
            return
        L_0x0040:
            int r0 = r13.f()
            int r0 = r0 * 1000
            r12.a((int) r0)
            com.tencent.rtmp.downloader.TXVodDownloadDataSource r0 = r12.getDataSource()
            int r0 = r0.getQuality()
            int r0 = com.tencent.rtmp.downloader.a.a.a((int) r0)
            r6 = -1
            if (r0 > 0) goto L_0x005a
            goto L_0x009d
        L_0x005a:
            java.util.List r1 = r13.j()
            if (r1 == 0) goto L_0x009d
            int r4 = r1.size()
            if (r4 <= 0) goto L_0x009d
            r4 = 2147483647(0x7fffffff, float:NaN)
            r6 = 0
            r7 = r6
        L_0x006b:
            int r8 = r1.size()
            if (r6 >= r8) goto L_0x0090
            java.lang.Object r8 = r1.get(r6)
            com.tencent.liteav.txcvodplayer.b.c$e r8 = (com.tencent.liteav.txcvodplayer.b.c.e) r8
            int r9 = r8.f21925b
            int r8 = r8.f21926c
            int r8 = java.lang.Math.min(r9, r8)
            if (r0 < r8) goto L_0x008d
            int r8 = r0 - r8
            int r8 = java.lang.Math.abs(r8)
            if (r8 > r4) goto L_0x008d
            if (r8 == 0) goto L_0x0091
            r7 = r6
            r4 = r8
        L_0x008d:
            int r6 = r6 + 1
            goto L_0x006b
        L_0x0090:
            r6 = r7
        L_0x0091:
            java.lang.Object r0 = r1.get(r6)
            com.tencent.liteav.txcvodplayer.b.c$e r0 = (com.tencent.liteav.txcvodplayer.b.c.e) r0
            int r1 = r0.f21925b
            int r0 = r0.f21926c
            int r1 = r1 * r0
            long r6 = (long) r1
        L_0x009d:
            r0 = 0
            int r4 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r4 <= 0) goto L_0x00d9
            java.util.List r4 = r13.j()
            if (r4 == 0) goto L_0x00d4
            int r8 = r4.size()
            if (r8 != 0) goto L_0x00b0
            goto L_0x00d4
        L_0x00b0:
            java.util.Iterator r4 = r4.iterator()
        L_0x00b4:
            boolean r8 = r4.hasNext()
            if (r8 == 0) goto L_0x00cb
            java.lang.Object r8 = r4.next()
            com.tencent.liteav.txcvodplayer.b.c$e r8 = (com.tencent.liteav.txcvodplayer.b.c.e) r8
            int r9 = r8.f21926c
            int r10 = r8.f21925b
            int r9 = r9 * r10
            long r9 = (long) r9
            int r9 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1))
            if (r9 != 0) goto L_0x00b4
            r5 = r8
        L_0x00cb:
            if (r5 == 0) goto L_0x00d9
            long r4 = r5.f21928e
            int r0 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r0 <= 0) goto L_0x00d9
            goto L_0x00dd
        L_0x00d4:
            long r4 = r13.g()
            goto L_0x00dd
        L_0x00d9:
            long r4 = r13.g()
        L_0x00dd:
            r12.a((long) r4)
            r12.b((java.lang.String) r3)
            r12.c((long) r6)
            if (r2 == 0) goto L_0x00eb
            r12.a((com.tencent.rtmp.TXPlayerDrmBuilder) r2)
        L_0x00eb:
            r11.a((com.tencent.rtmp.downloader.a.c) r12)
            return
        L_0x00ef:
            com.tencent.rtmp.downloader.ITXVodDownloadListener r11 = r11.f48637c
            if (r11 == 0) goto L_0x00f6
            r11.onDownloadError(r12, r1, r0)
        L_0x00f6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.rtmp.downloader.a.b.a(com.tencent.rtmp.downloader.a.b, com.tencent.rtmp.downloader.a.c, com.tencent.liteav.txcvodplayer.b.c):void");
    }

    public static /* synthetic */ void a(b bVar, c cVar) {
        String str;
        if (bVar.f48639e != null) {
            if (cVar == null) {
                str = "";
            } else {
                Parcel obtain = Parcel.obtain();
                cVar.writeToParcel(obtain, 0);
                obtain.setDataPosition(0);
                String encodeToString = Base64.encodeToString(obtain.marshall(), 2);
                obtain.recycle();
                str = encodeToString;
            }
            if (!TextUtils.isEmpty(str)) {
                String c11 = bVar.c(cVar);
                if (!TextUtils.isEmpty(c11)) {
                    bVar.f48639e.put(c11, str);
                    bVar.f48639e.commit();
                    LiteavLog.i("TXVodDownloadManagerImpl", "saveDownloadMediaInfo key: " + c11 + "| mediaInfo: " + str);
                }
            }
        }
    }
}
