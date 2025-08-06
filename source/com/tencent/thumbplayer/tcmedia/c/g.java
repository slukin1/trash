package com.tencent.thumbplayer.tcmedia.c;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.thumbplayer.tcmedia.api.proxy.ITPPreloadProxy;
import com.tencent.thumbplayer.tcmedia.api.proxy.TPDownloadParamData;
import com.tencent.thumbplayer.tcmedia.config.TPPlayerConfig;
import com.tencent.thumbplayer.tcmedia.core.downloadproxy.api.ITPDLProxyLogListener;
import com.tencent.thumbplayer.tcmedia.core.downloadproxy.api.ITPDownloadProxy;
import com.tencent.thumbplayer.tcmedia.core.downloadproxy.api.ITPPreLoadListener;
import com.tencent.thumbplayer.tcmedia.core.downloadproxy.api.TPDownloadProxyEnum;
import com.tencent.thumbplayer.tcmedia.utils.TPLogUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class g implements ITPPreloadProxy {

    /* renamed from: a  reason: collision with root package name */
    private Context f49095a;

    /* renamed from: b  reason: collision with root package name */
    private int f49096b;

    /* renamed from: c  reason: collision with root package name */
    private ITPDownloadProxy f49097c;

    /* renamed from: d  reason: collision with root package name */
    private a f49098d = new a();
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public ITPPreloadProxy.IPreloadListener f49099e = new f("TPPreloadProxyImpl");

    /* renamed from: f  reason: collision with root package name */
    private boolean f49100f = false;

    public class a implements ITPDLProxyLogListener, ITPPreLoadListener {
        private a() {
        }

        public int d(String str, int i11, String str2, String str3) {
            TPLogUtil.d(str2, "[" + str + ":" + i11 + "] " + str3);
            return 0;
        }

        public int e(String str, int i11, String str2, String str3) {
            TPLogUtil.e(str2, "[" + str + ":" + i11 + "] " + str3);
            return 0;
        }

        public int i(String str, int i11, String str2, String str3) {
            TPLogUtil.i(str2, "[" + str + ":" + i11 + "] " + str3);
            return 0;
        }

        public void onPrepareDownloadProgressUpdate(int i11, int i12, long j11, long j12, String str) {
            g.this.f49099e.onPrepareDownloadProgressUpdate(i11, i12, j11, j12);
        }

        public void onPrepareError(int i11, int i12, String str) {
            g.this.f49099e.onPrepareError();
        }

        public void onPrepareOK() {
            g.this.f49099e.onPrepareSuccess();
        }

        public int w(String str, int i11, String str2, String str3) {
            TPLogUtil.w(str2, "[" + str + ":" + i11 + "] " + str3);
            return 0;
        }
    }

    public g(Context context, int i11) {
        this.f49095a = context;
        this.f49096b = i11;
        a();
    }

    private void a() {
        int i11 = 3;
        while (i11 > 0 && !this.f49100f) {
            try {
                b a11 = i.a().a(this.f49096b);
                if (a11 == null || a11.a() == null) {
                    i11--;
                    TPLogUtil.e("TPPreloadProxyImpl", "p2p so load failed");
                } else {
                    ITPDownloadProxy a12 = a11.a();
                    this.f49097c = a12;
                    a12.setLogListener(this.f49098d);
                    this.f49097c.setUserData(TPDownloadProxyEnum.USER_IS_VIP, Boolean.valueOf(TPPlayerConfig.isUserIsVip()));
                    if (!TextUtils.isEmpty(TPPlayerConfig.getUserUin())) {
                        this.f49097c.setUserData(TPDownloadProxyEnum.USER_UIN, TPPlayerConfig.getUserUin());
                    }
                    if (!TextUtils.isEmpty(TPPlayerConfig.getAppVersionName(this.f49095a))) {
                        this.f49097c.setUserData(TPDownloadProxyEnum.USER_APP_VERSION, TPPlayerConfig.getAppVersionName(this.f49095a));
                    }
                    if (TPPlayerConfig.getBuildNumber(this.f49095a) != -1) {
                        this.f49097c.setUserData("app_version_code", String.valueOf(TPPlayerConfig.getBuildNumber(this.f49095a)));
                    }
                    this.f49097c.setUserData(TPDownloadProxyEnum.USER_UPC, TPPlayerConfig.getUserUpc());
                    this.f49097c.setUserData(TPDownloadProxyEnum.USER_UPC_STATE, Integer.valueOf(TPPlayerConfig.getUserUpcState()));
                    this.f49097c.setUserData(TPDownloadProxyEnum.USER_EXTERNAL_NETWORK_IP, TPPlayerConfig.getOutNetIp());
                    this.f49100f = true;
                    return;
                }
            } catch (Exception e11) {
                i11--;
                TPLogUtil.e("TPPreloadProxyImpl", (Throwable) e11);
            }
        }
    }

    public String getPlayErrorCodeStr(int i11) {
        return null;
    }

    public boolean isAvailable() {
        return this.f49097c != null && this.f49100f;
    }

    public void pushEvent(int i11) {
        if (isAvailable()) {
            try {
                this.f49097c.pushEvent(i11);
            } catch (Throwable th2) {
                TPLogUtil.e("TPPreloadProxyImpl", th2);
            }
        }
    }

    public void setPreloadListener(ITPPreloadProxy.IPreloadListener iPreloadListener) {
        if (iPreloadListener == null) {
            this.f49099e = new f("TPPreloadProxyImpl");
        } else {
            this.f49099e = iPreloadListener;
        }
    }

    public int startClipPreload(String str, ArrayList<TPDownloadParamData> arrayList) {
        TPLogUtil.i("TPPreloadProxyImpl", "[startClipPreload] Preloading clips.");
        if (arrayList == null) {
            TPLogUtil.e("TPPreloadProxyImpl", "[startClipPreload] Fail to start clip preload: null download parameter list.");
            return -1;
        }
        if (!isAvailable()) {
            a();
            if (!isAvailable()) {
                TPLogUtil.e("TPPreloadProxyImpl", "[startClipPreload] Fail to initialize proxy.");
                return -1;
            }
        }
        int startClipPreload = this.f49097c.startClipPreload(str, arrayList.size(), this.f49098d);
        if (startClipPreload <= 0) {
            TPLogUtil.e("TPPreloadProxyImpl", "[startClipPreload] Fail to start clip preload: invalid preload ID.");
            stopPreload(startClipPreload);
            return -1;
        }
        Iterator<TPDownloadParamData> it2 = arrayList.iterator();
        int i11 = 1;
        while (it2.hasNext()) {
            TPDownloadParamData next = it2.next();
            if (!this.f49097c.setClipInfo(startClipPreload, i11, next.getDownloadFileID(), k.a(next.getUrl(), next, (Map<String, String>) null, (Map<String, Object>) null))) {
                TPLogUtil.e("TPPreloadProxyImpl", "[startClipPreload] Fail to set clip info.");
                stopPreload(startClipPreload);
                return -1;
            }
            i11++;
        }
        try {
            this.f49097c.startTask(startClipPreload);
            return startClipPreload;
        } catch (Throwable th2) {
            TPLogUtil.e("TPPreloadProxyImpl", "[startClipPreload] Fail to start task: " + th2.toString());
            stopPreload(startClipPreload);
            return -1;
        }
    }

    public int startPreload(String str, TPDownloadParamData tPDownloadParamData) {
        return startPreload(str, tPDownloadParamData, (Map<String, String>) null);
    }

    public int startPreload(String str, TPDownloadParamData tPDownloadParamData, Map<String, String> map) {
        if (!isAvailable()) {
            a();
            if (!isAvailable()) {
                return -1;
            }
        }
        if (tPDownloadParamData != null) {
            try {
                return this.f49097c.startPreload(str, k.a((String) null, tPDownloadParamData, map, (Map<String, Object>) null), this.f49098d);
            } catch (Throwable th2) {
                TPLogUtil.e("TPPreloadProxyImpl", th2);
            }
        }
        return -1;
    }

    public void stopPreload(int i11) {
        ITPDownloadProxy iTPDownloadProxy = this.f49097c;
        if (iTPDownloadProxy != null) {
            try {
                iTPDownloadProxy.stopPreload(i11);
            } catch (Throwable th2) {
                TPLogUtil.e("TPPreloadProxyImpl", th2);
            }
        }
    }
}
