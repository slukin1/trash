package cn.sharesdk.framework.a;

import android.text.TextUtils;
import android.util.Base64;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.framework.ShareSDKCallback;
import cn.sharesdk.framework.a.a.d;
import cn.sharesdk.framework.a.a.e;
import cn.sharesdk.framework.b;
import cn.sharesdk.framework.network.a;
import cn.sharesdk.framework.utils.SSDKLog;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.jumio.core.cdn.CDNDownload;
import com.mob.MobCommunicator;
import com.mob.MobSDK;
import com.mob.tools.network.KVPair;
import com.mob.tools.network.NetworkHelper;
import com.mob.tools.utils.DH;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.ResHelper;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;

public class c {

    /* renamed from: h  reason: collision with root package name */
    private static MobCommunicator f13369h;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public e f13370a = e.a();
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public NetworkHelper f13371b = new NetworkHelper();
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public Hashon f13372c = new Hashon();

    /* renamed from: d  reason: collision with root package name */
    private String f13373d;

    /* renamed from: e  reason: collision with root package name */
    private String f13374e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public boolean f13375f;

    /* renamed from: g  reason: collision with root package name */
    private HashMap<String, String> f13376g;

    public c() {
        try {
            this.f13376g = (HashMap) this.f13370a.l("buffered_server_paths");
        } catch (Throwable unused) {
            this.f13376g = new HashMap<>();
        }
        h();
    }

    private static synchronized MobCommunicator g() {
        MobCommunicator mobCommunicator;
        synchronized (c.class) {
            if (f13369h == null) {
                f13369h = new MobCommunicator(1024, "009cbd92ccef123be840deec0c6ed0547194c1e471d11b6f375e56038458fb18833e5bab2e1206b261495d7e2d1d9e5aa859e6d4b671a8ca5d78efede48e291a3f", "1dfd1d615cb891ce9a76f42d036af7fce5f8b8efaa11b2f42590ecc4ea4cff28f5f6b0726aeb76254ab5b02a58c1d5b486c39d9da1a58fa6ba2f22196493b3a4cbc283dcf749bf63679ee24d185de70c8dfe05605886c9b53e9f569082eabdf98c4fb0dcf07eb9bb3e647903489ff0b5d933bd004af5be4a1022fdda41f347f1");
            }
            mobCommunicator = f13369h;
        }
        return mobCommunicator;
    }

    private void h() {
        this.f13373d = (DH.SyncMtd.getPackageName() + "/" + DH.SyncMtd.getAppVersionName()) + " " + "ShareSDK/3.10.25" + " " + ("Android/" + DH.SyncMtd.getOSVersionInt());
        try {
            this.f13374e = MobSDK.dynamicModifyUrl("api-share.mob.com");
        } catch (Throwable th2) {
            this.f13374e = MobSDK.checkRequestUrl("api-share.mob.com");
            SSDKLog.b().a("001 dynamicModifyUrl catch, no problem " + th2, new Object[0]);
        }
        this.f13375f = true;
    }

    private String i() {
        return this.f13374e + "/conn";
    }

    private String j() {
        HashMap<String, String> hashMap = this.f13376g;
        if (hashMap == null || !hashMap.containsKey("/date")) {
            return this.f13374e + "/date";
        }
        return this.f13376g.get("/date") + "/date";
    }

    /* access modifiers changed from: private */
    public String k() {
        return this.f13374e + "/conf5";
    }

    private String l() {
        try {
            return MobSDK.dynamicModifyUrl("up.mob.com/upload/image");
        } catch (Throwable th2) {
            SSDKLog b11 = SSDKLog.b();
            b11.a("002 dynamicModifyUrl catch, no problem " + th2, new Object[0]);
            return MobSDK.checkRequestUrl("up.mob.com/upload/image");
        }
    }

    private String m() {
        HashMap<String, String> hashMap = this.f13376g;
        if (hashMap == null || !hashMap.containsKey("/log5")) {
            return this.f13374e + "/log5";
        }
        return this.f13376g.get("/log5") + "/log5";
    }

    /* access modifiers changed from: private */
    public String n() {
        try {
            return MobSDK.dynamicModifyUrl("l.mob.com/url/shareSdkEncryptMapping.do");
        } catch (Throwable th2) {
            SSDKLog b11 = SSDKLog.b();
            b11.a("003 dynamicModifyUrl catch, no problem " + th2, new Object[0]);
            return MobSDK.checkRequestUrl("l.mob.com/url/shareSdkEncryptMapping.do");
        }
    }

    private String o() {
        HashMap<String, String> hashMap = this.f13376g;
        if (hashMap == null || !hashMap.containsKey("/snsconf")) {
            return this.f13374e + "/snsconf";
        }
        return this.f13376g.get("/snsconf") + "/snsconf";
    }

    /* access modifiers changed from: private */
    public static synchronized MobCommunicator f() {
        MobCommunicator mobCommunicator;
        synchronized (c.class) {
            if (f13369h == null) {
                f13369h = new MobCommunicator(1024, "bb7addd7e33383b74e82aba9b1d274c73aea6c0c71fcc88730270f630dbe490e1d162004f74e9532f98e17004630fbea9b346de63c23e83a7dfad70dd47cebfd", "288e7c44e01569a905386e6341baabfcde63ec37d0f0835cc662c299a5d0072970808a7fa434f0a51fa581d09d5ec4350ba5d548eafbe1fd956fb3afd678c1fb6134c904668652ec5cceb5d85da337a0f2f13ea457cca74a01b3ba0f4c809ad30d382bba2562ec9b996ae44c3700731c1b914997ef826331759e4084a019a03f");
            }
            mobCommunicator = f13369h;
        }
        return mobCommunicator;
    }

    public void b(String str) {
        this.f13374e = str;
    }

    public HashMap<String, Object> c(String str) throws Throwable {
        KVPair kVPair = new KVPair("file", str);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new KVPair("User-Identity", a.a()));
        String httpPost = this.f13371b.httpPost(l(), (ArrayList<KVPair<String>>) null, (KVPair<String>) kVPair, (ArrayList<KVPair<String>>) arrayList, (NetworkHelper.NetworkTimeOut) null);
        SSDKLog.b().c("upload file response == %s", httpPost);
        return this.f13372c.fromJson(httpPost);
    }

    public HashMap<String, Object> d(String str) throws Throwable {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new KVPair("appkey", MobSDK.getAppkey()));
        arrayList.add(new KVPair("device", str));
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new KVPair("User-Identity", a.a()));
        NetworkHelper.NetworkTimeOut networkTimeOut = new NetworkHelper.NetworkTimeOut();
        networkTimeOut.readTimout = 10000;
        networkTimeOut.connectionTimeout = 10000;
        return this.f13372c.fromJson(this.f13371b.httpPost(o(), (ArrayList<KVPair<String>>) arrayList, (KVPair<String>) null, (ArrayList<KVPair<String>>) arrayList2, networkTimeOut));
    }

    public void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            SSDKLog.b().a("duid === " + str, new Object[0]);
            this.f13373d += " " + str;
        }
    }

    public long b() throws Throwable {
        String str;
        if (!this.f13370a.i()) {
            return 0;
        }
        try {
            str = this.f13371b.httpGet(j(), (ArrayList<KVPair<String>>) null, (ArrayList<KVPair<String>>) null, (NetworkHelper.NetworkTimeOut) null);
        } catch (Throwable th2) {
            SSDKLog.b().a(th2);
            str = "{}";
        }
        HashMap fromJson = this.f13372c.fromJson(str);
        if (!fromJson.containsKey("timestamp")) {
            return this.f13370a.b();
        }
        try {
            long currentTimeMillis = System.currentTimeMillis() - ResHelper.parseLong(String.valueOf(fromJson.get("timestamp")));
            this.f13370a.a("service_time", Long.valueOf(currentTimeMillis));
            return currentTimeMillis;
        } catch (Throwable th3) {
            SSDKLog.b().a(th3);
            return this.f13370a.b();
        }
    }

    public void a(HashMap<String, String> hashMap) {
        this.f13376g = hashMap;
        this.f13370a.a("buffered_server_paths", (Object) hashMap);
    }

    public HashMap<String, Object> a() throws Throwable {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new KVPair("appkey", MobSDK.getAppkey()));
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new KVPair("User-Identity", a.a()));
        NetworkHelper.NetworkTimeOut networkTimeOut = new NetworkHelper.NetworkTimeOut();
        networkTimeOut.readTimout = CDNDownload.DEFAULT_TIMEOUT;
        networkTimeOut.connectionTimeout = CDNDownload.DEFAULT_TIMEOUT;
        String httpPost = this.f13371b.httpPost(i(), (ArrayList<KVPair<String>>) arrayList, (KVPair<String>) null, (ArrayList<KVPair<String>>) arrayList2, networkTimeOut);
        SSDKLog.b().c(" isConnectToServer response == %s", httpPost);
        return this.f13372c.fromJson(httpPost);
    }

    public ArrayList<cn.sharesdk.framework.a.a.c> c() throws Throwable {
        ArrayList<cn.sharesdk.framework.a.a.c> a11 = d.a();
        return a11 == null ? new ArrayList<>() : a11;
    }

    public HashMap<String, Object> d() throws Throwable {
        return this.f13372c.fromJson(this.f13370a.g());
    }

    public void b(HashMap<String, Object> hashMap) throws Throwable {
        this.f13370a.g(this.f13372c.fromHashMap(hashMap));
    }

    public void a(final ShareSDKCallback<HashMap<String, Object>> shareSDKCallback) throws Throwable {
        DH.requester(MobSDK.getContext()).getDeviceKey().getDetailNetworkTypeForStatic().getNetworkType().request(new DH.DHResponder() {
            public void onResponse(DH.DHResponse dHResponse) {
                try {
                    String networkType = dHResponse.getNetworkType();
                    if ("none".equals(networkType)) {
                        return;
                    }
                    if (!TextUtils.isEmpty(networkType)) {
                        String appkey = MobSDK.getAppkey();
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(new KVPair("appkey", appkey));
                        arrayList.add(new KVPair("device", dHResponse.getDeviceKey()));
                        arrayList.add(new KVPair("plat", String.valueOf(DH.SyncMtd.getPlatformCode())));
                        arrayList.add(new KVPair("apppkg", DH.SyncMtd.getPackageName()));
                        arrayList.add(new KVPair("appver", String.valueOf(DH.SyncMtd.getAppVersion())));
                        arrayList.add(new KVPair("sdkver", String.valueOf(ShareSDK.SDK_VERSION_CODE)));
                        arrayList.add(new KVPair("networktype", dHResponse.getDetailNetworkTypeForStatic()));
                        ArrayList arrayList2 = new ArrayList();
                        arrayList2.add(new KVPair("User-Identity", a.a()));
                        NetworkHelper.NetworkTimeOut networkTimeOut = new NetworkHelper.NetworkTimeOut();
                        networkTimeOut.readTimout = 10000;
                        networkTimeOut.connectionTimeout = 10000;
                        String httpPost = c.this.f13371b.httpPost(c.this.k(), (ArrayList<KVPair<String>>) arrayList, (KVPair<String>) null, (ArrayList<KVPair<String>>) arrayList2, networkTimeOut);
                        HashMap fromJson = new Hashon().fromJson(httpPost);
                        if (fromJson.containsKey("error")) {
                            if (String.valueOf(fromJson.get("error")).contains("'appkey' is illegal")) {
                                if (TextUtils.isEmpty(appkey)) {
                                    b.a().b();
                                } else {
                                    cn.sharesdk.framework.a.f13299a = true;
                                }
                            }
                        } else if (!TextUtils.isEmpty(appkey)) {
                            cn.sharesdk.framework.a.f13300b = appkey;
                        }
                        SSDKLog.b().c(" get server config response == %s", httpPost);
                        shareSDKCallback.onCallback(c.this.f13372c.fromJson(httpPost));
                    }
                } catch (Throwable th2) {
                    SSDKLog b11 = SSDKLog.b();
                    b11.a("getServerConfig" + th2, new Object[0]);
                }
            }
        });
    }

    public boolean a(String str, boolean z11) {
        try {
            if (!MobSDK.isMob()) {
                return true;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("m", str);
            hashMap.put("t", z11 ? "1" : "0");
            String str2 = (String) g().requestSynchronized((HashMap<String, Object>) hashMap, m(), false);
            SSDKLog.b().c("> Upload All Log  resp: %s", str2);
            return TextUtils.isEmpty(str2) || ((Integer) this.f13372c.fromJson(str2).get("status")).intValue() == 200;
        } catch (Throwable th2) {
            SSDKLog.b().a(th2);
            return false;
        }
    }

    public void a(String str, ArrayList<String> arrayList, int i11, String str2, ShareSDKCallback<HashMap<String, Object>> shareSDKCallback) throws Throwable {
        final String str3 = str2;
        final ArrayList<String> arrayList2 = arrayList;
        final int i12 = i11;
        final ShareSDKCallback<HashMap<String, Object>> shareSDKCallback2 = shareSDKCallback;
        DH.requester(MobSDK.getContext()).getDeviceKey().getDetailNetworkTypeForStatic().getScreenSize().getCarrier().getNetworkType().request(new DH.DHResponder() {
            public void onResponse(DH.DHResponse dHResponse) {
                try {
                    String networkType = dHResponse.getNetworkType();
                    if ("none".equals(networkType)) {
                        return;
                    }
                    if (!TextUtils.isEmpty(networkType)) {
                        if (c.this.f13375f) {
                            boolean c11 = c.this.f13370a.c();
                            boolean d11 = c.this.f13370a.d();
                            String str = null;
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(Data.urlEncode(DH.SyncMtd.getPackageName(), "utf-8"));
                            sb2.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
                            sb2.append(Data.urlEncode(DH.SyncMtd.getAppVersionName(), "utf-8"));
                            sb2.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
                            sb2.append(Data.urlEncode(String.valueOf(ShareSDK.SDK_VERSION_CODE), "utf-8"));
                            sb2.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
                            sb2.append(Data.urlEncode(String.valueOf(DH.SyncMtd.getPlatformCode()), "utf-8"));
                            sb2.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
                            sb2.append(Data.urlEncode(dHResponse.getDetailNetworkTypeForStatic(), "utf-8"));
                            sb2.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
                            if (c11) {
                                sb2.append(Data.urlEncode(String.valueOf(DH.SyncMtd.getOSVersionInt()), "utf-8"));
                                sb2.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
                                sb2.append(Data.urlEncode(dHResponse.getScreenSize(), "utf-8"));
                                sb2.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
                                sb2.append(Data.urlEncode(DH.SyncMtd.getManufacturer(), "utf-8"));
                                sb2.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
                                sb2.append(Data.urlEncode(DH.SyncMtd.getModel(), "utf-8"));
                                sb2.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
                                sb2.append(Data.urlEncode(dHResponse.getCarrier(), "utf-8"));
                                sb2.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
                            } else {
                                sb2.append("|||||");
                            }
                            if (d11) {
                                sb2.append(str3);
                            } else {
                                sb2.append(str3.split("\\|")[0]);
                                sb2.append("|||||");
                            }
                            String sb3 = sb2.toString();
                            SSDKLog.b().c("shorLinkMsg ===>>>>", sb3);
                            str = Base64.encodeToString(Data.AES128Encode(Data.rawMD5(String.format("%s:%s", new Object[]{dHResponse.getDeviceKey(), MobSDK.getAppkey()})), sb3), 2);
                            new ArrayList().add(new KVPair("User-Identity", a.a()));
                            NetworkHelper.NetworkTimeOut networkTimeOut = new NetworkHelper.NetworkTimeOut();
                            networkTimeOut.readTimout = 5000;
                            networkTimeOut.connectionTimeout = 5000;
                            HashMap hashMap = new HashMap();
                            hashMap.put("key", MobSDK.getAppkey());
                            ArrayList arrayList = new ArrayList();
                            for (int i11 = 0; i11 < arrayList2.size(); i11++) {
                                arrayList.add(URLEncoder.encode((String) arrayList2.get(i11), "UTF-8"));
                            }
                            hashMap.put("urls", arrayList);
                            hashMap.put("deviceid", dHResponse.getDeviceKey());
                            hashMap.put("snsplat", Integer.valueOf(i12));
                            if (TextUtils.isEmpty(str3)) {
                                SSDKLog.b().a("shortLinkMsg null", new Object[0]);
                                return;
                            }
                            hashMap.put("m", str);
                            HashMap hashMap2 = (HashMap) c.f().requestSynchronized((HashMap<String, Object>) hashMap, c.this.n(), false);
                            SSDKLog.b().c("> SERVER_SHORT_LINK_URL  resp: %s", hashMap2);
                            if (hashMap2.size() == 0) {
                                boolean unused = c.this.f13375f = false;
                            } else if (hashMap2.get("data") != null) {
                                shareSDKCallback2.onCallback(hashMap2);
                            }
                        }
                    }
                } catch (Throwable th2) {
                    SSDKLog.b().a("getShortLink" + th2, new Object[0]);
                    ShareSDKCallback shareSDKCallback = shareSDKCallback2;
                    if (shareSDKCallback != null) {
                        shareSDKCallback.onCallback(new HashMap());
                    }
                }
            }
        });
    }

    public void a(cn.sharesdk.framework.a.b.c cVar) throws Throwable {
        d.a(cVar.toString(), cVar.f13338e);
    }

    public void a(ArrayList<String> arrayList) throws Throwable {
        d.a(arrayList);
    }

    public HashMap<String, Object> a(String str, String str2) throws Throwable {
        byte[] decode = Base64.decode(str, 2);
        return this.f13372c.fromJson(new String(Data.AES128Decode(Data.rawMD5(MobSDK.getAppkey() + ":" + str2), decode), "UTF-8").trim());
    }

    public HashMap<String, Object> a(String str, ArrayList<String> arrayList, int i11, String str2, HashMap<String, String> hashMap) throws Throwable {
        ArrayList<String> arrayList2 = arrayList;
        HashMap<String, String> hashMap2 = hashMap;
        if (!this.f13375f) {
            return null;
        }
        ArrayList arrayList3 = new ArrayList();
        arrayList3.add(new KVPair("key", MobSDK.getAppkey()));
        for (int i12 = 0; i12 < arrayList.size(); i12++) {
            arrayList3.add(new KVPair("urls", arrayList2.get(i12).toString()));
        }
        arrayList3.add(new KVPair("deviceid", hashMap2.get("dk")));
        arrayList3.add(new KVPair("snsplat", String.valueOf(i11)));
        String a11 = a(str2, hashMap2);
        if (TextUtils.isEmpty(a11)) {
            return null;
        }
        arrayList3.add(new KVPair("m", a11));
        new ArrayList().add(new KVPair("User-Identity", a.a()));
        NetworkHelper.NetworkTimeOut networkTimeOut = new NetworkHelper.NetworkTimeOut();
        networkTimeOut.readTimout = 5000;
        networkTimeOut.connectionTimeout = 5000;
        HashMap hashMap3 = new HashMap();
        hashMap3.put("key", MobSDK.getAppkey());
        ArrayList arrayList4 = new ArrayList();
        for (int i13 = 0; i13 < arrayList.size(); i13++) {
            arrayList4.add(URLEncoder.encode(arrayList2.get(i13), "UTF-8"));
        }
        hashMap3.put("urls", arrayList4);
        hashMap3.put("deviceid", hashMap2.get("dk"));
        hashMap3.put("snsplat", Integer.valueOf(i11));
        if (TextUtils.isEmpty(a11)) {
            return null;
        }
        hashMap3.put("m", a11);
        HashMap<String, Object> hashMap4 = (HashMap) f().requestSynchronized((HashMap<String, Object>) hashMap3, n(), false);
        SSDKLog.b().c("> SERVER_SHORT_LINK_URL  resp: %s", hashMap4);
        if (hashMap4.size() == 0) {
            this.f13375f = false;
            return null;
        } else if (hashMap4.get("data") == null) {
            return null;
        } else {
            return hashMap4;
        }
    }

    private String a(String str, HashMap<String, String> hashMap) throws Throwable {
        boolean c11 = this.f13370a.c();
        boolean d11 = this.f13370a.d();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(Data.urlEncode(DH.SyncMtd.getPackageName(), "utf-8"));
        sb2.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
        sb2.append(Data.urlEncode(DH.SyncMtd.getAppVersionName(), "utf-8"));
        sb2.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
        sb2.append(Data.urlEncode(String.valueOf(ShareSDK.SDK_VERSION_CODE), "utf-8"));
        sb2.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
        sb2.append(Data.urlEncode(String.valueOf(DH.SyncMtd.getPlatformCode()), "utf-8"));
        sb2.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
        sb2.append(Data.urlEncode(hashMap.get("dnwktfs"), "utf-8"));
        sb2.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
        if (c11) {
            sb2.append(Data.urlEncode(String.valueOf(DH.SyncMtd.getOSVersionInt()), "utf-8"));
            sb2.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
            sb2.append(Data.urlEncode(hashMap.get("srs"), "utf-8"));
            sb2.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
            sb2.append(Data.urlEncode(DH.SyncMtd.getManufacturer(), "utf-8"));
            sb2.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
            sb2.append(Data.urlEncode(DH.SyncMtd.getModel(), "utf-8"));
            sb2.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
            sb2.append(Data.urlEncode(hashMap.get("car"), "utf-8"));
            sb2.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
        } else {
            sb2.append("|||||");
        }
        if (d11) {
            sb2.append(str);
        } else {
            sb2.append(str.split("\\|")[0]);
            sb2.append("|||||");
        }
        String sb3 = sb2.toString();
        SSDKLog.b().c("shorLinkMsg ===>>>>", sb3);
        return Base64.encodeToString(Data.AES128Encode(Data.rawMD5(String.format("%s:%s", new Object[]{hashMap.get("dk"), MobSDK.getAppkey()})), sb3), 2);
    }
}
