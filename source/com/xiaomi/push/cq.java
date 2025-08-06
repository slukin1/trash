package com.xiaomi.push;

import android.content.Context;
import com.huobi.vulcan.model.VulcanInfo;
import com.luck.picture.lib.loader.IBridgeMediaLoader;
import com.xiaomi.push.service.q;
import io.flutter.plugins.firebase.crashlytics.Constants;
import java.util.HashMap;
import java.util.List;

public class cq {

    /* renamed from: a  reason: collision with root package name */
    private final String f51513a = "disconnection_event";

    /* renamed from: b  reason: collision with root package name */
    private final String f51514b = "count";

    /* renamed from: c  reason: collision with root package name */
    private final String f51515c = VulcanInfo.HOST;

    /* renamed from: d  reason: collision with root package name */
    private final String f51516d = "network_state";

    /* renamed from: e  reason: collision with root package name */
    private final String f51517e = Constants.REASON;

    /* renamed from: f  reason: collision with root package name */
    private final String f51518f = "ping_interval";

    /* renamed from: g  reason: collision with root package name */
    private final String f51519g = "network_type";

    /* renamed from: h  reason: collision with root package name */
    private final String f51520h = "wifi_digest";

    /* renamed from: i  reason: collision with root package name */
    private final String f51521i = IBridgeMediaLoader.COLUMN_DURATION;

    /* renamed from: j  reason: collision with root package name */
    private final String f51522j = "disconnect_time";

    /* renamed from: k  reason: collision with root package name */
    private final String f51523k = "connect_time";

    /* renamed from: l  reason: collision with root package name */
    private final String f51524l = "xmsf_vc";

    /* renamed from: m  reason: collision with root package name */
    private final String f51525m = "android_vc";

    /* renamed from: n  reason: collision with root package name */
    private final String f51526n = ZendeskIdentityStorage.UUID_KEY;

    public void a(Context context, List<cp> list) {
        if (list != null && list.size() != 0) {
            co.a("upload size = " + list.size());
            String a11 = q.a(context);
            for (cp next : list) {
                HashMap hashMap = new HashMap();
                hashMap.put("count", Integer.valueOf(next.a()));
                hashMap.put(VulcanInfo.HOST, next.a());
                hashMap.put("network_state", Integer.valueOf(next.b()));
                hashMap.put(Constants.REASON, Integer.valueOf(next.c()));
                hashMap.put("ping_interval", Long.valueOf(next.a()));
                hashMap.put("network_type", Integer.valueOf(next.d()));
                hashMap.put("wifi_digest", next.b());
                hashMap.put("connected_network_type", Integer.valueOf(next.e()));
                hashMap.put(IBridgeMediaLoader.COLUMN_DURATION, Long.valueOf(next.b()));
                hashMap.put("disconnect_time", Long.valueOf(next.c()));
                hashMap.put("connect_time", Long.valueOf(next.d()));
                hashMap.put("xmsf_vc", Integer.valueOf(next.f()));
                hashMap.put("android_vc", Integer.valueOf(next.g()));
                hashMap.put(ZendeskIdentityStorage.UUID_KEY, a11);
                ei.a().a("disconnection_event", hashMap);
            }
        }
    }
}
