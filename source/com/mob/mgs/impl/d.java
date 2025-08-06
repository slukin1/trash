package com.mob.mgs.impl;

import android.text.TextUtils;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.mob.MobSDK;
import com.mob.commons.i;
import com.mob.commons.u;
import com.mob.mcl.b.a;
import com.mob.tools.network.NetCommunicator;
import com.mob.tools.utils.DH;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class d {

    /* renamed from: a  reason: collision with root package name */
    private static NetCommunicator f27613a;

    public static <T> T a(List<HashMap<String, String>> list, String str, boolean z11) throws Throwable {
        HashMap<String, Object> a11 = a();
        a11.put("guardId", str);
        a11.put("targetAppInfoDtoList", list);
        a11.put("deviceSwitch", Integer.valueOf(z11 ? 1 : 0));
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final String[] strArr = new String[1];
        final int[] iArr = new int[1];
        DH.requester(MobSDK.getContext()).getHmOsDetailedVer().getHmEPMState().request(new DH.DHResponder() {
            public void onResponse(DH.DHResponse dHResponse) {
                strArr[0] = dHResponse.getHmOsDetailedVer();
                iArr[0] = dHResponse.getHmEPMState();
                countDownLatch.countDown();
            }
        });
        countDownLatch.await();
        a11.put("hmv", strArr[0]);
        a11.put("ep", Integer.valueOf(iArr[0]));
        e a12 = e.a();
        a12.a("[GD][/v6/gd] request: " + a11);
        return a("/v7/gd", a11);
    }

    private static synchronized NetCommunicator b() {
        NetCommunicator netCommunicator;
        synchronized (d.class) {
            if (f27613a == null) {
                f27613a = new NetCommunicator(1024, "009cbd92ccef123be840deec0c6ed0547194c1e471d11b6f375e56038458fb18833e5bab2e1206b261495d7e2d1d9e5aa859e6d4b671a8ca5d78efede48e291a3f", "1dfd1d615cb891ce9a76f42d036af7fce5f8b8efaa11b2f42590ecc4ea4cff28f5f6b0726aeb76254ab5b02a58c1d5b486c39d9da1a58fa6ba2f22196493b3a4cbc283dcf749bf63679ee24d185de70c8dfe05605886c9b53e9f569082eabdf98c4fb0dcf07eb9bb3e647903489ff0b5d933bd004af5be4a1022fdda41f347f1");
            }
            netCommunicator = f27613a;
        }
        return netCommunicator;
    }

    public static <T> T a(List<HashMap<String, Object>> list, String str, String str2) throws Throwable {
        HashMap<String, Object> a11 = a();
        a11.put("guardId", str);
        a11.put("workId", str2);
        a11.put("pkgList", list);
        e a12 = e.a();
        a12.a("[request][/v6/pu] request: " + a11);
        return a("/v7/pu", a11);
    }

    public static <T> T a(String str, String str2, String str3, String str4, String str5, String str6, int i11) throws Throwable {
        HashMap<String, Object> a11 = a();
        a11.put("guardId", str5);
        a11.put("workId", str6);
        a11.put("pullDuid", str);
        a11.put("pullAppkey", str2);
        a11.put("pullPkg", str3);
        a11.put("pullGuardId", str4);
        a11.put("pullTime", Long.valueOf(System.currentTimeMillis()));
        a11.put("actType", Integer.valueOf(i11));
        e a12 = e.a();
        a12.a("[request][/v6/bpu] request: " + a11);
        return a("/v7/bpu", a11);
    }

    public static <T> T a(boolean z11, boolean z12) throws Throwable {
        HashMap<String, Object> a11 = a();
        a11.put("guardId", a.a());
        if (z12) {
            if (!TextUtils.isEmpty(i.c())) {
                a11.put("duid", i.c());
            }
            if (!TextUtils.isEmpty(i.d())) {
                a11.put("guardId", i.d());
            }
        }
        a11.put("deviceSwitch", Integer.valueOf(z11 ? 1 : 0));
        e a12 = e.a();
        a12.a("[request][deviceSwitch/updateV5] request: " + a11);
        return a("/v7/dsu", a11);
    }

    private static HashMap<String, Object> a() {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("versionTime", "2021.11.17 18:38");
        hashMap.put("appkey", u.a());
        hashMap.put("appver", Integer.valueOf(DH.SyncMtd.getAppVersion()));
        hashMap.put("platVersion", DH.SyncMtd.getOSVersionName());
        hashMap.put("apppkg", MobSDK.getContext().getPackageName());
        hashMap.put("sdkver", 50000);
        hashMap.put("duid", f.a().f());
        hashMap.put("product", 1);
        hashMap.put("plat", 1);
        hashMap.put("brand", DH.SyncMtd.getManufacturer());
        hashMap.put(DeviceRequestsHelper.DEVICE_INFO_MODEL, DH.SyncMtd.getModel());
        hashMap.put("modelVersion", DH.SyncMtd.getOSVersionName());
        return hashMap;
    }

    private static <T> T a(String str, HashMap<String, Object> hashMap) throws Throwable {
        HashMap hashMap2 = new HashMap();
        hashMap2.put("versionTime", "2021.11.17 18:38");
        NetCommunicator b11 = b();
        return b11.requestWithoutEncode(true, hashMap2, hashMap, i.a().a("gdg") + str, true);
    }
}
