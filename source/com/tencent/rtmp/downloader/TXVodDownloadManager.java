package com.tencent.rtmp.downloader;

import android.text.TextUtils;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.txcvodplayer.b.c;
import com.tencent.liteav.txcvodplayer.hlsencoder.TXCHLSEncoder;
import com.tencent.rtmp.TXPlayInfoParams;
import com.tencent.rtmp.TXPlayerDrmBuilder;
import com.tencent.rtmp.downloader.ITXVodDownloadListener;
import com.tencent.rtmp.downloader.TXVodDownloadManager;
import com.tencent.rtmp.downloader.a.a;
import com.tencent.rtmp.downloader.a.b;
import com.tencent.rtmp.downloader.a.c;
import com.tencent.rtmp.downloader.a.d;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class TXVodDownloadManager {
    public static final int DOWNLOAD_403FORBIDDEN = -5008;
    public static final int DOWNLOAD_AUTH_FAILED = -5001;
    public static final int DOWNLOAD_DISCONNECT = -5005;
    public static final int DOWNLOAD_FORMAT_ERROR = -5004;
    public static final int DOWNLOAD_HLS_KEY_ERROR = -5006;
    public static final int DOWNLOAD_NO_FILE = -5003;
    public static final int DOWNLOAD_PATH_ERROR = -5007;
    public static final int DOWNLOAD_SUCCESS = 0;
    private static final String TAG = "TXVodDownloadManager";
    private static TXVodDownloadManager sInstance;
    private final b mManagerImpl = new b();

    private TXVodDownloadManager() {
    }

    public static TXVodDownloadManager getInstance() {
        synchronized (TXVodDownloadManager.class) {
            if (sInstance == null) {
                sInstance = new TXVodDownloadManager();
            }
        }
        return sInstance;
    }

    @Deprecated
    public boolean deleteDownloadFile(String str) {
        return this.mManagerImpl.a(str);
    }

    public boolean deleteDownloadMediaInfo(TXVodDownloadMediaInfo tXVodDownloadMediaInfo) {
        return this.mManagerImpl.b(tXVodDownloadMediaInfo);
    }

    @Deprecated
    public TXVodDownloadMediaInfo getDownloadMediaInfo(int i11, String str, int i12) {
        return this.mManagerImpl.a(i11, str, i12, "");
    }

    public List<TXVodDownloadMediaInfo> getDownloadMediaInfoList() {
        return this.mManagerImpl.a();
    }

    @Deprecated
    public void setDownloadPath(String str) {
        d dVar = this.mManagerImpl.f48635a;
        if (!TextUtils.isEmpty(str)) {
            String a11 = com.tencent.liteav.txcplayer.common.b.a();
            dVar.f48649a = a11;
            if (TextUtils.isEmpty(a11)) {
                String str2 = str + "/txcache";
                dVar.f48649a = str2;
                com.tencent.liteav.txcplayer.common.b.a(str2);
            }
            try {
                new File(dVar.f48649a).mkdirs();
            } catch (Exception e11) {
                LiteavLog.e("ThumbPlayerDownloader", "setDownloadPath exception: " + e11.getLocalizedMessage());
            }
        }
    }

    public void setHeaders(Map<String, String> map) {
        this.mManagerImpl.f48635a.f48651c = map;
    }

    public void setListener(ITXVodDownloadListener iTXVodDownloadListener) {
        this.mManagerImpl.f48637c = iTXVodDownloadListener;
    }

    public TXVodDownloadMediaInfo startDownload(TXVodDownloadDataSource tXVodDownloadDataSource) {
        b bVar = this.mManagerImpl;
        if (tXVodDownloadDataSource.getAuthBuilder() != null) {
            LiteavLog.w("TXVodDownloadManagerImpl", "startDownloadV2");
            return bVar.a(tXVodDownloadDataSource);
        }
        LiteavLog.w("TXVodDownloadManagerImpl", "startDownloadV4");
        a aVar = new a(tXVodDownloadDataSource.getAppId(), tXVodDownloadDataSource.getFileId(), tXVodDownloadDataSource.getQuality(), tXVodDownloadDataSource.getPSign(), tXVodDownloadDataSource.getUserName());
        c cVar = new c();
        cVar.a(aVar);
        c a11 = bVar.a((TXVodDownloadMediaInfo) cVar);
        if (a11 != null) {
            return a11;
        }
        new com.tencent.liteav.txcvodplayer.b.c(new TXPlayInfoParams(aVar.getAppId(), aVar.getFileId(), aVar.getPSign())).a((c.a) new c.a(cVar) {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c f48644a;

            {
                this.f48644a = r2;
            }

            public final void a(com.tencent.liteav.txcvodplayer.b.c cVar, TXPlayInfoParams tXPlayInfoParams) {
                c.b bVar;
                LiteavLog.i("TXVodDownloadManagerImpl", "onSuccess: protocol params = " + tXPlayInfoParams.toString());
                if (this.f48644a.getDownloadState() == 2) {
                    synchronized (b.this.f48636b) {
                        b.this.f48636b.remove(this.f48644a);
                    }
                    ITXVodDownloadListener iTXVodDownloadListener = b.this.f48637c;
                    if (iTXVodDownloadListener != null) {
                        iTXVodDownloadListener.onDownloadStop(this.f48644a);
                    }
                    LiteavLog.w("TXVodDownloadManagerImpl", "Download task canceled");
                    return;
                }
                if ("SimpleAES".equalsIgnoreCase(cVar.k()) && (bVar = cVar.f21897c) != null && !TextUtils.isEmpty(bVar.f21916a)) {
                    a aVar = (a) this.f48644a.getDataSource();
                    String a11 = TXCHLSEncoder.a(aVar.getAppId(), aVar.getUserName(), aVar.getFileId(), aVar.getQuality());
                    String a12 = TXCHLSEncoder.a(a11, bVar.f21916a);
                    String a13 = TXCHLSEncoder.a(a11, bVar.f21917b);
                    if (TextUtils.isEmpty(a12) || TextUtils.isEmpty(a13)) {
                        LiteavLog.e("TXVodDownloadManagerImpl", "create local key exception!");
                        return;
                    }
                    aVar.a(a12);
                    aVar.b(a13);
                    com.tencent.liteav.txcvodplayer.c.a.a().a(tXPlayInfoParams.getAppId(), tXPlayInfoParams.getFileId(), bVar);
                }
                b.a(b.this, this.f48644a, cVar);
            }

            public final void a(int i11, String str) {
                LiteavLog.w("TXVodDownloadManagerImpl", "onFail: errorCode = " + i11 + " message = " + str);
                synchronized (b.this.f48636b) {
                    b.this.f48636b.remove(this.f48644a);
                }
                ITXVodDownloadListener iTXVodDownloadListener = b.this.f48637c;
                if (iTXVodDownloadListener != null) {
                    iTXVodDownloadListener.onDownloadError(this.f48644a, TXVodDownloadManager.DOWNLOAD_AUTH_FAILED, str);
                }
            }
        });
        return cVar;
    }

    public TXVodDownloadMediaInfo startDownloadDrm(TXPlayerDrmBuilder tXPlayerDrmBuilder, long j11, String str) {
        b bVar = this.mManagerImpl;
        com.tencent.rtmp.downloader.a.c cVar = new com.tencent.rtmp.downloader.a.c();
        cVar.b(tXPlayerDrmBuilder.getPlayUrl());
        cVar.c(str);
        cVar.c(j11);
        cVar.a(tXPlayerDrmBuilder);
        com.tencent.rtmp.downloader.a.c a11 = bVar.a((TXVodDownloadMediaInfo) cVar);
        if (a11 != null) {
            return a11;
        }
        bVar.a(cVar);
        return cVar;
    }

    @Deprecated
    public TXVodDownloadMediaInfo startDownloadUrl(String str) {
        return startDownloadUrl(str, -1, "default");
    }

    public void stopDownload(TXVodDownloadMediaInfo tXVodDownloadMediaInfo) {
        d.a aVar;
        b bVar = this.mManagerImpl;
        if (tXVodDownloadMediaInfo == null) {
            return;
        }
        if (tXVodDownloadMediaInfo.getTaskId() < 0) {
            LiteavLog.w("TXVodDownloadManagerImpl", "stop download not start task");
            return;
        }
        synchronized (bVar.f48636b) {
            Iterator<com.tencent.rtmp.downloader.a.c> it2 = bVar.f48636b.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                com.tencent.rtmp.downloader.a.c next = it2.next();
                if (next.getTaskId() == tXVodDownloadMediaInfo.getTaskId()) {
                    d dVar = bVar.f48635a;
                    if (dVar.f48652d.pauseDownload(next.getTaskId()) == 0 && (aVar = dVar.f48650b) != null) {
                        aVar.b(next);
                    }
                    LiteavLog.i("TXVodDownloadManagerImpl", "stop download " + tXVodDownloadMediaInfo.getUrl());
                }
            }
        }
    }

    public TXVodDownloadMediaInfo getDownloadMediaInfo(int i11, String str, int i12, String str2) {
        return this.mManagerImpl.a(i11, str, i12, str2);
    }

    @Deprecated
    public TXVodDownloadMediaInfo startDownloadUrl(String str, String str2) {
        return startDownloadUrl(str, -1, str2);
    }

    @Deprecated
    public TXVodDownloadMediaInfo getDownloadMediaInfo(String str) {
        return getDownloadMediaInfo(str, -1, "");
    }

    public TXVodDownloadMediaInfo startDownloadUrl(String str, long j11, String str2) {
        b bVar = this.mManagerImpl;
        com.tencent.rtmp.downloader.a.c cVar = new com.tencent.rtmp.downloader.a.c();
        cVar.b(str);
        cVar.c(str2);
        cVar.c(j11);
        com.tencent.rtmp.downloader.a.c a11 = bVar.a((TXVodDownloadMediaInfo) cVar);
        if (a11 != null) {
            return a11;
        }
        bVar.a(cVar);
        return cVar;
    }

    public TXVodDownloadMediaInfo getDownloadMediaInfo(String str, long j11, String str2) {
        return this.mManagerImpl.a(str, j11, str2);
    }
}
