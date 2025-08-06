package com.tencent.rtmp.downloader.a;

import android.content.Context;
import android.text.TextUtils;
import com.huochat.community.base.CommunityConstants;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.txcplayer.common.b;
import com.tencent.thumbplayer.tcmedia.core.downloadproxy.api.ITPDownloadProxy;
import com.tencent.thumbplayer.tcmedia.core.downloadproxy.api.ITPOfflineDownloadListener;
import com.tencent.thumbplayer.tcmedia.core.downloadproxy.api.TPDLProxyInitParam;
import com.tencent.thumbplayer.tcmedia.core.downloadproxy.api.TPDownloadParam;
import com.tencent.thumbplayer.tcmedia.core.downloadproxy.api.TPDownloadProxyEnum;
import com.tencent.thumbplayer.tcmedia.core.downloadproxy.api.TPDownloadProxyFactory;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class d {

    /* renamed from: e  reason: collision with root package name */
    private static d f48648e;

    /* renamed from: a  reason: collision with root package name */
    public String f48649a;

    /* renamed from: b  reason: collision with root package name */
    public a f48650b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, String> f48651c;

    /* renamed from: d  reason: collision with root package name */
    public ITPDownloadProxy f48652d = TPDownloadProxyFactory.getTPDownloadProxy(2330303);

    public interface a {
        void a(c cVar);

        void a(c cVar, int i11, String str);

        void b(c cVar);

        void c(c cVar);

        void d(c cVar);
    }

    private d(Context context) {
        File externalFilesDir;
        if (context != null) {
            String a11 = b.a();
            this.f48649a = a11;
            try {
                if (TextUtils.isEmpty(a11) && (externalFilesDir = context.getExternalFilesDir((String) null)) != null) {
                    this.f48649a = externalFilesDir.getAbsolutePath() + "/txcache";
                }
                if (!TextUtils.isEmpty(this.f48649a)) {
                    File file = new File(this.f48649a);
                    if (!file.exists() || !file.isDirectory()) {
                        file.mkdirs();
                    }
                }
            } catch (Exception e11) {
                LiteavLog.e("ThumbPlayerDownloader", "downloader init exception: " + e11.getLocalizedMessage());
            }
            this.f48652d.init(context, new TPDLProxyInitParam(2330303, CommunityConstants.COMMUNITY_SDK_VERSION, "liteav_tbplayer_android_" + context.getPackageName(), this.f48649a));
        }
    }

    public final boolean b(c cVar) {
        String playPath = cVar.getPlayPath();
        if (TextUtils.isEmpty(playPath)) {
            return false;
        }
        String substring = playPath.substring(0, playPath.indexOf("?"));
        String substring2 = substring.substring(0, substring.lastIndexOf("/"));
        String substring3 = substring.substring(substring.lastIndexOf("/") + 1);
        this.f48652d.updateStoragePath(substring2);
        return this.f48652d.checkResourceExist(substring2, substring3, cVar.getPreferredResolution());
    }

    public final int c(final c cVar) {
        String playPath = cVar.getPlayPath();
        if (TextUtils.isEmpty(playPath)) {
            return -1;
        }
        String substring = playPath.substring(0, playPath.indexOf("?"));
        String substring2 = substring.substring(substring.lastIndexOf("/") + 1);
        String url = cVar.getUrl();
        ArrayList arrayList = new ArrayList();
        arrayList.add(url);
        TPDownloadParam tPDownloadParam = new TPDownloadParam(arrayList, 0, (Map<String, Object>) null);
        HashMap hashMap = new HashMap();
        Map<String, String> map = this.f48651c;
        if (map != null && map.size() > 0) {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(this.f48651c);
            hashMap.put(TPDownloadProxyEnum.DLPARAM_URL_HEADER, arrayList2);
        }
        long preferredResolution = cVar.getPreferredResolution();
        if (preferredResolution > 0) {
            hashMap.put(TPDownloadProxyEnum.DLPARAM_OFFLINE_SCHEDULER_LEVEL, 4);
            hashMap.put(TPDownloadProxyEnum.DLPARAM_PREFERRED_RESOLUTION, Long.valueOf(preferredResolution));
        }
        if (cVar.getDrmBuilder() != null) {
            hashMap.put(TPDownloadProxyEnum.DLPARAM_KEY_LICENSE_URL, cVar.getDrmBuilder().getKeyLicenseUrl());
            hashMap.put(TPDownloadProxyEnum.DLPARAM_DEVICE_CERTIFICATE_URL, cVar.getDrmBuilder().getDeviceCertificateUrl());
        }
        tPDownloadParam.setExtInfoMap(hashMap);
        int startOfflineDownload = this.f48652d.startOfflineDownload(substring2, tPDownloadParam, new ITPOfflineDownloadListener() {
            public final void onDownloadCdnUrlExpired(Map<String, String> map) {
                LiteavLog.i("ThumbPlayerDownloader", "onDownloadCdnUrlExpired!");
            }

            public final void onDownloadCdnUrlInfoUpdate(String str, String str2, String str3, String str4) {
            }

            public final void onDownloadCdnUrlUpdate(String str) {
                LiteavLog.i("ThumbPlayerDownloader", "onDownloadCdnUrlUpdate! url:".concat(String.valueOf(str)));
            }

            public final void onDownloadError(int i11, int i12, String str) {
                LiteavLog.e("ThumbPlayerDownloader", "offline download error! moduleID:" + i11 + ", errCode:" + i12);
                if (d.this.f48650b != null) {
                    d.this.f48650b.a(cVar, i12, str);
                }
            }

            public final void onDownloadFinish() {
                if (d.this.f48650b != null) {
                    d.this.f48650b.c(cVar);
                }
            }

            public final void onDownloadProgressUpdate(int i11, int i12, long j11, long j12, String str) {
                if (j11 > 1024 && j11 != cVar.getDownloadSize()) {
                    cVar.b(j11);
                }
                if (cVar.getSize() <= 0 && j12 > 0) {
                    cVar.a(j12);
                }
                if (i11 > 0) {
                    cVar.b(i11);
                }
                if (cVar.getDuration() <= 0 && !TextUtils.isEmpty(str) && str.contains("totalDuration")) {
                    String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    int length = split.length;
                    int i13 = 0;
                    while (true) {
                        if (i13 >= length) {
                            break;
                        }
                        String str2 = split[i13];
                        if (str2.contains("totalDuration")) {
                            cVar.a(Integer.valueOf(str2.split(":")[1]).intValue() * 1000);
                            break;
                        }
                        i13++;
                    }
                }
                cVar.e(i12);
                if (d.this.f48650b != null) {
                    d.this.f48650b.d(cVar);
                }
            }

            public final void onDownloadProtocolUpdate(String str, String str2) {
                LiteavLog.i("ThumbPlayerDownloader", "onDownloadProtocolUpdate! protocol:" + str + ", protocolVer:" + str2);
            }

            public final void onDownloadStatusUpdate(int i11) {
                LiteavLog.i("ThumbPlayerDownloader", "onDownloadStatusUpdate! statusCode:".concat(String.valueOf(i11)));
            }
        });
        cVar.c(startOfflineDownload);
        a aVar = this.f48650b;
        if (aVar != null) {
            aVar.a(cVar);
        }
        return startOfflineDownload;
    }

    public static d a(Context context) {
        synchronized (d.class) {
            if (f48648e == null) {
                f48648e = new d(context);
            }
        }
        return f48648e;
    }

    public final String a(String str) {
        String a11 = b.a();
        if (!TextUtils.equals(this.f48649a, a11)) {
            if (!TextUtils.isEmpty(a11)) {
                this.f48649a = a11;
            } else {
                b.a(this.f48649a);
            }
        }
        this.f48652d.updateStoragePath(this.f48649a);
        String d11 = com.tencent.liteav.txcplayer.a.a.d(str);
        return this.f48649a + "/" + d11 + "?" + str;
    }

    public final float a(c cVar) {
        String playPath = cVar.getPlayPath();
        if (TextUtils.isEmpty(playPath)) {
            return 0.0f;
        }
        String substring = playPath.substring(0, playPath.indexOf("?"));
        return this.f48652d.getResourceDownloadProgress(substring.substring(0, substring.lastIndexOf("/")), substring.substring(substring.lastIndexOf("/") + 1), cVar.getPreferredResolution());
    }

    public final boolean a(String str, long j11) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.trim().endsWith(".sqlite")) {
            return new File(str).delete();
        }
        String substring = str.substring(0, str.indexOf("?"));
        String substring2 = substring.substring(substring.lastIndexOf("/") + 1);
        if (!TextUtils.isEmpty(substring2)) {
            String substring3 = substring.substring(0, substring.lastIndexOf("/"));
            this.f48652d.updateStoragePath(substring3);
            if (this.f48652d.clearCache(substring3, substring2, 1, j11) == 0) {
                return true;
            }
        }
        return false;
    }
}
