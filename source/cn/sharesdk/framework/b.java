package cn.sharesdk.framework;

import android.text.TextUtils;
import cn.sharesdk.framework.network.a;
import cn.sharesdk.framework.utils.SSDKLog;
import com.mob.MobSDK;
import com.mob.tools.network.KVPair;
import com.mob.tools.network.NetworkHelper;
import com.mob.tools.utils.DH;
import com.mob.tools.utils.Hashon;
import java.util.ArrayList;
import java.util.HashMap;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private static volatile b f13420a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public NetworkHelper f13421b = new NetworkHelper();

    /* renamed from: c  reason: collision with root package name */
    private String f13422c = MobSDK.checkRequestUrl("api-share.mob.com");

    private b() {
    }

    /* access modifiers changed from: private */
    public String c() {
        return this.f13422c + "/conf5";
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public static cn.sharesdk.framework.b a() {
        /*
            java.lang.Class<cn.sharesdk.framework.b> r0 = cn.sharesdk.framework.b.class
            monitor-enter(r0)
            cn.sharesdk.framework.b r1 = f13420a     // Catch:{ all -> 0x001c }
            if (r1 != 0) goto L_0x0018
            monitor-enter(r0)     // Catch:{ all -> 0x001c }
            cn.sharesdk.framework.b r1 = f13420a     // Catch:{ all -> 0x0015 }
            if (r1 != 0) goto L_0x0013
            cn.sharesdk.framework.b r1 = new cn.sharesdk.framework.b     // Catch:{ all -> 0x0015 }
            r1.<init>()     // Catch:{ all -> 0x0015 }
            f13420a = r1     // Catch:{ all -> 0x0015 }
        L_0x0013:
            monitor-exit(r0)     // Catch:{ all -> 0x0015 }
            goto L_0x0018
        L_0x0015:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0015 }
            throw r1     // Catch:{ all -> 0x001c }
        L_0x0018:
            monitor-exit(r0)     // Catch:{ all -> 0x001c }
            cn.sharesdk.framework.b r0 = f13420a
            return r0
        L_0x001c:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x001c }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.sharesdk.framework.b.a():cn.sharesdk.framework.b");
    }

    public void b() {
        try {
            DH.requester(MobSDK.getContext()).getDeviceKey().getDetailNetworkTypeForStatic().request(new DH.DHResponder() {
                public void onResponse(DH.DHResponse dHResponse) {
                    try {
                        ArrayList arrayList = new ArrayList();
                        String appkey = MobSDK.getAppkey();
                        if (!TextUtils.isEmpty(appkey)) {
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
                            HashMap fromJson = new Hashon().fromJson(b.this.f13421b.httpPost(b.this.c(), (ArrayList<KVPair<String>>) arrayList, (KVPair<String>) null, (ArrayList<KVPair<String>>) arrayList2, networkTimeOut));
                            if (!fromJson.containsKey("error")) {
                                a.f13300b = appkey;
                            } else if (String.valueOf(fromJson.get("error")).contains("'appkey' is illegal")) {
                                a.f13299a = true;
                            }
                        }
                    } catch (Throwable th2) {
                        SSDKLog b11 = SSDKLog.b();
                        b11.a("updateServerConfig " + th2, new Object[0]);
                    }
                }
            });
        } catch (Throwable th2) {
            SSDKLog.b().a(th2);
        }
    }
}
