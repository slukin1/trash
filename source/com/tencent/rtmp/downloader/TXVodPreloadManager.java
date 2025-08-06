package com.tencent.rtmp.downloader;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import com.huochat.community.base.CommunityConstants;
import com.luck.picture.lib.config.PictureMimeType;
import com.tencent.liteav.base.ContextUtils;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.txcvodplayer.b.c;
import com.tencent.rtmp.TXPlayInfoParams;
import com.tencent.thumbplayer.tcmedia.core.downloadproxy.api.ITPDownloadProxy;
import com.tencent.thumbplayer.tcmedia.core.downloadproxy.api.ITPPreLoadListener;
import com.tencent.thumbplayer.tcmedia.core.downloadproxy.api.TPDLProxyInitParam;
import com.tencent.thumbplayer.tcmedia.core.downloadproxy.api.TPDownloadParam;
import com.tencent.thumbplayer.tcmedia.core.downloadproxy.api.TPDownloadProxyEnum;
import com.tencent.thumbplayer.tcmedia.core.downloadproxy.api.TPDownloadProxyFactory;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

public class TXVodPreloadManager {
    private static final String TAG = "TXVodPreloadManager";
    private static final String THUMB_PLAYER_GUID = "liteav_tbplayer_android_";
    private static final int THUMB_PLAYER_PLATFORM_ID = 2330303;
    private static Context mAppContext;
    private boolean mInit;
    /* access modifiers changed from: private */
    public ITPDownloadProxy mTpDownloadProxy;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static TXVodPreloadManager f48630a = new TXVodPreloadManager();
    }

    public static class b implements ITPPreLoadListener {

        /* renamed from: a  reason: collision with root package name */
        public int f48631a = -1;

        /* renamed from: b  reason: collision with root package name */
        private final ITXVodPreloadListener f48632b;

        /* renamed from: c  reason: collision with root package name */
        private final String f48633c;

        /* renamed from: d  reason: collision with root package name */
        private ITPDownloadProxy f48634d;

        public b(ITPDownloadProxy iTPDownloadProxy, String str, ITXVodPreloadListener iTXVodPreloadListener) {
            this.f48633c = str;
            this.f48632b = iTXVodPreloadListener;
            this.f48634d = iTPDownloadProxy;
        }

        private void a(int i11) {
            ITPDownloadProxy iTPDownloadProxy = this.f48634d;
            if (iTPDownloadProxy != null) {
                iTPDownloadProxy.stopPreload(i11);
            }
        }

        public final void onPrepareDownloadProgressUpdate(int i11, int i12, long j11, long j12, String str) {
            LiteavLog.i(TXVodPreloadManager.TAG, "preload: prepare process:" + i11 + Constants.ACCEPT_TIME_SEPARATOR_SP + i12 + Constants.ACCEPT_TIME_SEPARATOR_SP + j11 + Constants.ACCEPT_TIME_SEPARATOR_SP + j12);
        }

        public final void onPrepareError(int i11, int i12, String str) {
            LiteavLog.e(TXVodPreloadManager.TAG, "preload error: moduleId: " + i11 + ", errorCode: " + i12 + ", extInfo: " + str);
            ITXVodPreloadListener iTXVodPreloadListener = this.f48632b;
            if (iTXVodPreloadListener != null) {
                iTXVodPreloadListener.onError(this.f48631a, this.f48633c, i12, str);
            }
            a(this.f48631a);
        }

        public final void onPrepareOK() {
            LiteavLog.d(TXVodPreloadManager.TAG, "preload: onPrepareOK");
            ITXVodPreloadListener iTXVodPreloadListener = this.f48632b;
            if (iTXVodPreloadListener != null) {
                iTXVodPreloadListener.onComplete(this.f48631a, this.f48633c);
            }
            a(this.f48631a);
        }
    }

    /* access modifiers changed from: private */
    public int checkDlType(int i11, String str) {
        if (i11 == 1) {
            return 3;
        }
        if (i11 == 2) {
            return 5;
        }
        if (i11 == 3) {
            return 10;
        }
        if (i11 != 4) {
            return (!TextUtils.isEmpty(str) && com.tencent.liteav.txcplayer.a.a.d(str).endsWith(PictureMimeType.MP4)) ? 10 : 0;
        }
        return 19;
    }

    private synchronized Pair<Integer, String> checkInit() {
        ITPDownloadProxy tPDownloadProxy = TPDownloadProxyFactory.getTPDownloadProxy(THUMB_PLAYER_PLATFORM_ID);
        this.mTpDownloadProxy = tPDownloadProxy;
        if (tPDownloadProxy != null) {
            int b11 = com.tencent.liteav.txcplayer.common.b.b();
            if (b11 < 0) {
                return new Pair<>(-1, "MaxCacheSize not set.");
            }
            String a11 = com.tencent.liteav.txcplayer.common.b.a();
            if (TextUtils.equals(a11, "NO_SET")) {
                return new Pair<>(-2, "CacheFolderPath not set.");
            }
            if (!this.mInit) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("VodCacheReserveSizeMB", b11);
                } catch (Exception e11) {
                    e11.printStackTrace();
                }
                this.mTpDownloadProxy.init(mAppContext, new TPDLProxyInitParam(THUMB_PLAYER_PLATFORM_ID, CommunityConstants.COMMUNITY_SDK_VERSION, THUMB_PLAYER_GUID + mAppContext.getPackageName(), (String) null, a11, jSONObject.toString()));
                this.mInit = true;
            }
            this.mTpDownloadProxy.updateStoragePath(a11);
            this.mTpDownloadProxy.setMaxStorageSizeMB((long) b11);
            return new Pair<>(0, (Object) null);
        }
        return new Pair<>(-3, "Inner error.");
    }

    public static TXVodPreloadManager getInstance(Context context) {
        if (context == null) {
            return null;
        }
        Context applicationContext = context.getApplicationContext();
        mAppContext = applicationContext;
        ContextUtils.initApplicationContext(applicationContext);
        ContextUtils.setDataDirectorySuffix("liteav");
        return a.f48630a;
    }

    public int startPreload(String str, float f11, long j11, ITXVodPreloadListener iTXVodPreloadListener) {
        return startPreload(str, f11, j11, iTXVodPreloadListener, 0);
    }

    public void stopPreload(int i11) {
        if (((Integer) checkInit().first).intValue() >= 0) {
            this.mTpDownloadProxy.stopPreload(i11);
        }
    }

    private TXVodPreloadManager() {
        this.mInit = false;
    }

    private int startPreload(String str, float f11, long j11, ITXVodPreloadListener iTXVodPreloadListener, int i11) {
        Pair<Integer, String> checkInit = checkInit();
        if (((Integer) checkInit.first).intValue() < 0) {
            if (iTXVodPreloadListener != null) {
                iTXVodPreloadListener.onError(-1, str, ((Integer) checkInit.first).intValue(), (String) checkInit.second);
            }
            return -1;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        HashMap hashMap = new HashMap();
        hashMap.put(TPDownloadProxyEnum.DLPARAM_PRELOAD_SIZE, Long.valueOf((long) (f11 * 1024.0f * 1024.0f)));
        hashMap.put(TPDownloadProxyEnum.DLPARAM_PREFERRED_RESOLUTION, Long.valueOf(j11));
        TPDownloadParam tPDownloadParam = new TPDownloadParam(arrayList, checkDlType(i11, str), hashMap);
        b bVar = new b(this.mTpDownloadProxy, str, iTXVodPreloadListener);
        int startPreload = this.mTpDownloadProxy.startPreload(com.tencent.liteav.txcplayer.a.a.d(str), tPDownloadParam, bVar);
        bVar.f48631a = startPreload;
        return startPreload;
    }

    public int startPreload(TXPlayInfoParams tXPlayInfoParams, float f11, long j11, ITXVodFilePreloadListener iTXVodFilePreloadListener) throws RuntimeException {
        TXPlayInfoParams tXPlayInfoParams2 = tXPlayInfoParams;
        ITXVodFilePreloadListener iTXVodFilePreloadListener2 = iTXVodFilePreloadListener;
        if (tXPlayInfoParams2 == null || TextUtils.isEmpty(tXPlayInfoParams.getUrl()) || !TextUtils.isEmpty(tXPlayInfoParams.getFileId())) {
            if (Looper.myLooper() != Looper.getMainLooper()) {
                Pair<Integer, String> checkInit = checkInit();
                if (((Integer) checkInit.first).intValue() < 0) {
                    if (iTXVodFilePreloadListener2 != null) {
                        iTXVodFilePreloadListener2.onError(-1, "", ((Integer) checkInit.first).intValue(), (String) checkInit.second);
                    }
                    return -1;
                } else if (tXPlayInfoParams2 == null || tXPlayInfoParams.getAppId() == 0 || TextUtils.isEmpty(tXPlayInfoParams.getFileId())) {
                    if (iTXVodFilePreloadListener2 != null) {
                        iTXVodFilePreloadListener2.onError(-1, "", -1, " invalid params, appId or fileId is null");
                    }
                    return -1;
                } else {
                    AtomicInteger atomicInteger = new AtomicInteger(-1);
                    CountDownLatch countDownLatch = new CountDownLatch(1);
                    final CountDownLatch countDownLatch2 = countDownLatch;
                    final ITXVodFilePreloadListener iTXVodFilePreloadListener3 = iTXVodFilePreloadListener;
                    final long j12 = j11;
                    final float f12 = f11;
                    final TXPlayInfoParams tXPlayInfoParams3 = tXPlayInfoParams;
                    final AtomicInteger atomicInteger2 = atomicInteger;
                    new c(tXPlayInfoParams2).a((c.a) new c.a() {
                        public final void a(int i11, String str) {
                            countDownLatch2.countDown();
                            ITXVodFilePreloadListener iTXVodFilePreloadListener = iTXVodFilePreloadListener3;
                            if (iTXVodFilePreloadListener != null) {
                                iTXVodFilePreloadListener.onError(-1, "", i11, "getPlayInfo failed: ".concat(String.valueOf(str)));
                            }
                        }

                        /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
                        /* JADX WARNING: Removed duplicated region for block: B:14:0x0034  */
                        /* JADX WARNING: Removed duplicated region for block: B:17:0x005e  */
                        /* JADX WARNING: Removed duplicated region for block: B:9:0x0026  */
                        /* Code decompiled incorrectly, please refer to instructions dump. */
                        public final void a(com.tencent.liteav.txcvodplayer.b.c r14, com.tencent.rtmp.TXPlayInfoParams r15) {
                            /*
                                r13 = this;
                                java.lang.String r0 = r14.k()
                                java.lang.String r1 = "SimpleAES"
                                boolean r2 = r1.equalsIgnoreCase(r0)
                                java.lang.String r3 = "Widevine"
                                r4 = 0
                                r5 = 1
                                if (r2 == 0) goto L_0x0012
                            L_0x0010:
                                r0 = r5
                                goto L_0x0024
                            L_0x0012:
                                java.lang.String r2 = r14.a((java.lang.String) r3)
                                boolean r0 = r3.equalsIgnoreCase(r0)
                                if (r0 == 0) goto L_0x0023
                                boolean r0 = android.text.TextUtils.isEmpty(r2)
                                if (r0 != 0) goto L_0x0023
                                goto L_0x0010
                            L_0x0023:
                                r0 = r4
                            L_0x0024:
                                if (r0 != 0) goto L_0x0028
                            L_0x0026:
                                r0 = r5
                                goto L_0x0032
                            L_0x0028:
                                com.tencent.liteav.sdk.common.LicenseChecker$a r0 = com.tencent.liteav.sdk.common.LicenseChecker.a.PLAYER_PREMIUM
                                boolean r0 = com.tencent.liteav.txcplayer.common.c.a(r0)
                                if (r0 == 0) goto L_0x0031
                                goto L_0x0026
                            L_0x0031:
                                r0 = r4
                            L_0x0032:
                                if (r0 != 0) goto L_0x005e
                                java.lang.StringBuilder r14 = new java.lang.StringBuilder
                                java.lang.String r0 = "Encrypted fileId preload needs Player Premium license! fileId="
                                r14.<init>(r0)
                                java.lang.String r15 = r15.getFileId()
                                r14.append(r15)
                                java.lang.String r14 = r14.toString()
                                java.lang.String r15 = "TXVodPreloadManager"
                                com.tencent.liteav.base.util.LiteavLog.e(r15, r14)
                                java.util.concurrent.CountDownLatch r14 = r3
                                r14.countDown()
                                com.tencent.rtmp.downloader.ITXVodFilePreloadListener r14 = r4
                                if (r14 == 0) goto L_0x005d
                                r15 = -1
                                r0 = -5
                                java.lang.String r1 = ""
                                java.lang.String r2 = "Encrypted fileId preload needs Player Premium license!"
                                r14.onError(r15, r1, r0, r2)
                            L_0x005d:
                                return
                            L_0x005e:
                                android.os.Bundle r0 = new android.os.Bundle
                                r0.<init>()
                                long r6 = r5
                                java.lang.String r2 = r14.a()
                                java.lang.String r8 = r14.k()
                                boolean r9 = android.text.TextUtils.isEmpty(r8)
                                java.lang.String r10 = "plain"
                                if (r9 == 0) goto L_0x0076
                                r8 = r10
                            L_0x0076:
                                boolean r9 = r10.equalsIgnoreCase(r8)
                                if (r9 == 0) goto L_0x008f
                                java.lang.String r1 = r15.getFileId()
                                int r3 = r15.getAppId()
                                java.lang.String r1 = com.tencent.liteav.txcplayer.a.a.a(r2, r1, r8, r3)
                                android.util.Pair r3 = new android.util.Pair
                                r3.<init>(r2, r1)
                                goto L_0x01cf
                            L_0x008f:
                                java.lang.String r3 = r14.a((java.lang.String) r3)
                                boolean r9 = android.text.TextUtils.isEmpty(r3)
                                r5 = r5 ^ r9
                                java.lang.String r9 = r14.k()
                                boolean r1 = r1.equalsIgnoreCase(r9)
                                java.lang.String r9 = "VodPreloadUtil"
                                if (r1 != 0) goto L_0x00cf
                                if (r5 == 0) goto L_0x00a7
                                goto L_0x00cf
                            L_0x00a7:
                                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                                java.lang.String r3 = "invalid drmType="
                                r1.<init>(r3)
                                java.lang.String r3 = r14.k()
                                r1.append(r3)
                                java.lang.String r3 = " ,fileId="
                                r1.append(r3)
                                java.lang.String r3 = r15.getFileId()
                                r1.append(r3)
                                java.lang.String r1 = r1.toString()
                                com.tencent.liteav.base.util.LiteavLog.e(r9, r1)
                                android.util.Pair r3 = new android.util.Pair
                                r3.<init>(r2, r2)
                                goto L_0x01cf
                            L_0x00cf:
                                if (r5 == 0) goto L_0x00d2
                                r2 = r3
                            L_0x00d2:
                                com.tencent.liteav.txcvodplayer.b.c$b r1 = r14.f21897c
                                if (r1 == 0) goto L_0x01b5
                                java.lang.String r3 = r1.f21916a
                                boolean r3 = android.text.TextUtils.isEmpty(r3)
                                if (r3 == 0) goto L_0x00e0
                                goto L_0x01b5
                            L_0x00e0:
                                int r3 = r15.getAppId()
                                java.lang.String r5 = r15.getFileId()
                                java.lang.String r11 = "default"
                                java.lang.String r3 = com.tencent.liteav.txcvodplayer.hlsencoder.TXCHLSEncoder.a(r3, r11, r5, r4)
                                java.lang.String r5 = r1.f21916a
                                java.lang.String r5 = com.tencent.liteav.txcvodplayer.hlsencoder.TXCHLSEncoder.a(r3, r5)
                                java.lang.String r11 = r1.f21917b
                                java.lang.String r3 = com.tencent.liteav.txcvodplayer.hlsencoder.TXCHLSEncoder.a(r3, r11)
                                boolean r11 = android.text.TextUtils.isEmpty(r5)
                                if (r11 != 0) goto L_0x019a
                                boolean r11 = android.text.TextUtils.isEmpty(r3)
                                if (r11 == 0) goto L_0x0108
                                goto L_0x019a
                            L_0x0108:
                                com.tencent.liteav.txcvodplayer.c.a r9 = com.tencent.liteav.txcvodplayer.c.a.a()
                                int r11 = r15.getAppId()
                                java.lang.String r12 = r15.getFileId()
                                r9.a((int) r11, (java.lang.String) r12, (com.tencent.liteav.txcvodplayer.b.c.b) r1)
                                java.lang.String r1 = r14.c()
                                java.lang.String r1 = com.tencent.liteav.txcplayer.a.a.a(r2, r1)
                                java.lang.String r2 = r15.getFileId()
                                int r9 = r15.getAppId()
                                java.lang.String r2 = com.tencent.liteav.txcplayer.a.a.a(r1, r2, r8, r9)
                                java.lang.StringBuilder r8 = new java.lang.StringBuilder
                                r8.<init>()
                                r8.append(r2)
                                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                                r2.<init>()
                                java.lang.String r9 = "&oversign="
                                r2.append(r9)
                                int r11 = r15.getAppId()
                                r2.append(r11)
                                java.lang.String r11 = "&o1=default&o2="
                                r2.append(r11)
                                java.lang.String r11 = r15.getFileId()
                                r2.append(r11)
                                java.lang.String r11 = "&o3=&o4="
                                r2.append(r11)
                                r2.append(r5)
                                java.lang.String r5 = "&o5="
                                r2.append(r5)
                                r2.append(r3)
                                r11 = 0
                                int r3 = (r6 > r11 ? 1 : (r6 == r11 ? 0 : -1))
                                if (r3 <= 0) goto L_0x016e
                                java.lang.String r3 = "&o6="
                                r2.append(r3)
                                r2.append(r6)
                            L_0x016e:
                                java.lang.String r3 = r14.l()
                                boolean r5 = android.text.TextUtils.isEmpty(r3)
                                if (r5 != 0) goto L_0x0180
                                java.lang.String r5 = "&o7="
                                r2.append(r5)
                                r2.append(r3)
                            L_0x0180:
                                int r3 = r2.length()
                                if (r3 <= 0) goto L_0x0189
                                r2.append(r9)
                            L_0x0189:
                                java.lang.String r2 = r2.toString()
                                r8.append(r2)
                                java.lang.String r2 = r8.toString()
                                android.util.Pair r3 = new android.util.Pair
                                r3.<init>(r1, r2)
                                goto L_0x01cf
                            L_0x019a:
                                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                                java.lang.String r3 = "create local key exception for fileId="
                                r1.<init>(r3)
                                java.lang.String r3 = r15.getFileId()
                                r1.append(r3)
                                java.lang.String r1 = r1.toString()
                                com.tencent.liteav.base.util.LiteavLog.e(r9, r1)
                                android.util.Pair r3 = new android.util.Pair
                                r3.<init>(r2, r2)
                                goto L_0x01cf
                            L_0x01b5:
                                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                                java.lang.String r3 = "overlayKey is null fileId="
                                r1.<init>(r3)
                                java.lang.String r3 = r15.getFileId()
                                r1.append(r3)
                                java.lang.String r1 = r1.toString()
                                com.tencent.liteav.base.util.LiteavLog.e(r9, r1)
                                android.util.Pair r3 = new android.util.Pair
                                r3.<init>(r2, r2)
                            L_0x01cf:
                                java.lang.Object r1 = r3.second
                                java.lang.String r1 = (java.lang.String) r1
                                java.lang.String r2 = "EVT_PLAY_URL"
                                r0.putString(r2, r1)
                                java.lang.String r1 = r14.b()
                                java.lang.String r2 = "EVT_PLAY_COVER_URL"
                                r0.putString(r2, r1)
                                java.lang.String r1 = r14.d()
                                java.lang.String r2 = "EVT_PLAY_NAME"
                                r0.putString(r2, r1)
                                java.lang.String r1 = r14.e()
                                java.lang.String r2 = "EVT_PLAY_DESCRIPTION"
                                r0.putString(r2, r1)
                                int r1 = r14.f()
                                java.lang.String r2 = "EVT_PLAY_DURATION"
                                r0.putInt(r2, r1)
                                java.lang.String r1 = r14.k()
                                boolean r1 = android.text.TextUtils.isEmpty(r1)
                                if (r1 == 0) goto L_0x0207
                                goto L_0x020b
                            L_0x0207:
                                java.lang.String r10 = r14.k()
                            L_0x020b:
                                java.lang.String r1 = "EVT_DRM_TYPE"
                                r0.putString(r1, r10)
                                com.tencent.liteav.txcvodplayer.b.c$c r2 = r14.h()
                                if (r2 == 0) goto L_0x0224
                                java.lang.String r5 = r2.f21921b
                                java.lang.String r6 = "EVT_IMAGESPRIT_WEBVTTURL"
                                r0.putString(r6, r5)
                                java.util.ArrayList<java.lang.String> r2 = r2.f21920a
                                java.lang.String r5 = "EVT_IMAGESPRIT_IMAGEURL_LIST"
                                r0.putStringArrayList(r5, r2)
                            L_0x0224:
                                java.util.List r2 = r14.i()
                                if (r2 == 0) goto L_0x0263
                                boolean r5 = r2.isEmpty()
                                if (r5 != 0) goto L_0x0263
                                java.util.ArrayList r5 = new java.util.ArrayList
                                r5.<init>()
                                int r6 = r2.size()
                                float[] r6 = new float[r6]
                            L_0x023b:
                                int r7 = r2.size()
                                if (r4 >= r7) goto L_0x0259
                                java.lang.Object r7 = r2.get(r4)
                                com.tencent.liteav.txcvodplayer.b.c$d r7 = (com.tencent.liteav.txcvodplayer.b.c.d) r7
                                java.lang.String r7 = r7.f21922a
                                r5.add(r7)
                                java.lang.Object r7 = r2.get(r4)
                                com.tencent.liteav.txcvodplayer.b.c$d r7 = (com.tencent.liteav.txcvodplayer.b.c.d) r7
                                float r7 = r7.f21923b
                                r6[r4] = r7
                                int r4 = r4 + 1
                                goto L_0x023b
                            L_0x0259:
                                java.lang.String r2 = "EVT_KEY_FRAME_CONTENT_LIST"
                                r0.putStringArrayList(r2, r5)
                                java.lang.String r2 = "EVT_KEY_FRAME_TIME_LIST"
                                r0.putFloatArray(r2, r6)
                            L_0x0263:
                                java.lang.String r2 = r14.k()
                                r0.putString(r1, r2)
                                java.util.ArrayList r1 = new java.util.ArrayList
                                r1.<init>()
                                java.lang.Object r2 = r3.first
                                r1.add(r2)
                                java.util.HashMap r2 = new java.util.HashMap
                                r2.<init>()
                                float r4 = r7
                                r5 = 1149239296(0x44800000, float:1024.0)
                                float r4 = r4 * r5
                                float r4 = r4 * r5
                                java.lang.Float r4 = java.lang.Float.valueOf(r4)
                                java.lang.String r5 = "dl_param_preload_size"
                                r2.put(r5, r4)
                                long r4 = r5
                                java.lang.Long r4 = java.lang.Long.valueOf(r4)
                                java.lang.String r5 = "dl_param_preferred_resolution"
                                r2.put(r5, r4)
                                java.lang.String r4 = r14.l()
                                boolean r4 = android.text.TextUtils.isEmpty(r4)
                                if (r4 != 0) goto L_0x02b4
                                java.lang.String r14 = r14.l()
                                java.lang.String r4 = "dl_param_key_license_url"
                                r2.put(r4, r14)
                                com.tencent.rtmp.TXPlayerDrmBuilder r14 = new com.tencent.rtmp.TXPlayerDrmBuilder
                                r14.<init>()
                                java.lang.String r14 = r14.getDeviceCertificateUrl()
                                java.lang.String r4 = "dl_param_device_certificate_url"
                                r2.put(r4, r14)
                            L_0x02b4:
                                com.tencent.thumbplayer.tcmedia.core.downloadproxy.api.TPDownloadParam r14 = new com.tencent.thumbplayer.tcmedia.core.downloadproxy.api.TPDownloadParam
                                com.tencent.rtmp.downloader.TXVodPreloadManager r4 = com.tencent.rtmp.downloader.TXVodPreloadManager.this
                                com.tencent.rtmp.TXPlayInfoParams r5 = r8
                                int r5 = r5.getMediaType()
                                java.lang.Object r6 = r3.first
                                java.lang.String r6 = (java.lang.String) r6
                                int r4 = r4.checkDlType(r5, r6)
                                r14.<init>(r1, r4, r2)
                                com.tencent.rtmp.downloader.TXVodPreloadManager$b r1 = new com.tencent.rtmp.downloader.TXVodPreloadManager$b
                                com.tencent.rtmp.downloader.TXVodPreloadManager r2 = com.tencent.rtmp.downloader.TXVodPreloadManager.this
                                com.tencent.thumbplayer.tcmedia.core.downloadproxy.api.ITPDownloadProxy r2 = r2.mTpDownloadProxy
                                java.lang.Object r4 = r3.second
                                java.lang.String r4 = (java.lang.String) r4
                                com.tencent.rtmp.downloader.ITXVodFilePreloadListener r5 = r4
                                r1.<init>(r2, r4, r5)
                                com.tencent.rtmp.downloader.TXVodPreloadManager r2 = com.tencent.rtmp.downloader.TXVodPreloadManager.this
                                com.tencent.thumbplayer.tcmedia.core.downloadproxy.api.ITPDownloadProxy r2 = r2.mTpDownloadProxy
                                java.lang.Object r4 = r3.first
                                java.lang.String r4 = (java.lang.String) r4
                                java.lang.String r4 = com.tencent.liteav.txcplayer.a.a.d(r4)
                                int r14 = r2.startPreload(r4, r14, r1)
                                r1.f48631a = r14
                                java.util.concurrent.atomic.AtomicInteger r1 = r9
                                r1.set(r14)
                                java.util.concurrent.CountDownLatch r1 = r3
                                r1.countDown()
                                com.tencent.rtmp.downloader.ITXVodFilePreloadListener r1 = r4
                                if (r1 == 0) goto L_0x0307
                                java.lang.String r15 = r15.getFileId()
                                java.lang.Object r2 = r3.second
                                java.lang.String r2 = (java.lang.String) r2
                                r1.onStart(r14, r15, r2, r0)
                            L_0x0307:
                                return
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.tencent.rtmp.downloader.TXVodPreloadManager.AnonymousClass1.a(com.tencent.liteav.txcvodplayer.b.c, com.tencent.rtmp.TXPlayInfoParams):void");
                        }
                    });
                    try {
                        countDownLatch.await(8, TimeUnit.SECONDS);
                    } catch (InterruptedException e11) {
                        e11.printStackTrace();
                    }
                    return atomicInteger.get();
                }
            } else {
                throw new RuntimeException("startPreload for TXPlayInfoParams can not be called on the main thread.");
            }
        } else {
            return startPreload(tXPlayInfoParams.getUrl(), f11, j11, iTXVodFilePreloadListener, checkDlType(tXPlayInfoParams.getMediaType(), tXPlayInfoParams.getUrl()));
        }
    }
}
