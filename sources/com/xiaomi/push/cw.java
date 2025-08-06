package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.push.service.q;
import java.util.HashMap;

public class cw {

    /* renamed from: a  reason: collision with root package name */
    private final String f51545a = "power_consumption_stats";

    /* renamed from: b  reason: collision with root package name */
    private final String f51546b = "off_up_ct";

    /* renamed from: c  reason: collision with root package name */
    private final String f51547c = "off_dn_ct";

    /* renamed from: d  reason: collision with root package name */
    private final String f51548d = "off_ping_ct";

    /* renamed from: e  reason: collision with root package name */
    private final String f51549e = "off_pong_ct";

    /* renamed from: f  reason: collision with root package name */
    private final String f51550f = "off_dur";

    /* renamed from: g  reason: collision with root package name */
    private final String f51551g = "on_up_ct";

    /* renamed from: h  reason: collision with root package name */
    private final String f51552h = "on_dn_ct";

    /* renamed from: i  reason: collision with root package name */
    private final String f51553i = "on_ping_ct";

    /* renamed from: j  reason: collision with root package name */
    private final String f51554j = "on_pong_ct";

    /* renamed from: k  reason: collision with root package name */
    private final String f51555k = "on_dur";

    /* renamed from: l  reason: collision with root package name */
    private final String f51556l = "start_time";

    /* renamed from: m  reason: collision with root package name */
    private final String f51557m = "end_time";

    /* renamed from: n  reason: collision with root package name */
    private final String f51558n = "xmsf_vc";

    /* renamed from: o  reason: collision with root package name */
    private final String f51559o = "android_vc";

    /* renamed from: p  reason: collision with root package name */
    private final String f51560p = ZendeskIdentityStorage.UUID_KEY;

    public void a(Context context, cv cvVar) {
        if (cvVar != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("off_up_ct", Integer.valueOf(cvVar.a()));
            hashMap.put("off_dn_ct", Integer.valueOf(cvVar.b()));
            hashMap.put("off_ping_ct", Integer.valueOf(cvVar.c()));
            hashMap.put("off_pong_ct", Integer.valueOf(cvVar.d()));
            hashMap.put("off_dur", Long.valueOf(cvVar.a()));
            hashMap.put("on_up_ct", Integer.valueOf(cvVar.e()));
            hashMap.put("on_dn_ct", Integer.valueOf(cvVar.f()));
            hashMap.put("on_ping_ct", Integer.valueOf(cvVar.g()));
            hashMap.put("on_pong_ct", Integer.valueOf(cvVar.h()));
            hashMap.put("on_dur", Long.valueOf(cvVar.b()));
            hashMap.put("start_time", Long.valueOf(cvVar.c()));
            hashMap.put("end_time", Long.valueOf(cvVar.d()));
            hashMap.put("xmsf_vc", Integer.valueOf(cvVar.i()));
            hashMap.put("android_vc", Integer.valueOf(cvVar.j()));
            hashMap.put(ZendeskIdentityStorage.UUID_KEY, q.a(context));
            ei.a().a("power_consumption_stats", hashMap);
        }
    }
}
