package com.mob.tools.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.mob.MobSDK;
import com.mob.commons.C0891r;
import com.mob.commons.a.l;
import com.mob.commons.ab;
import com.mob.commons.d;
import com.mob.commons.v;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.DH;
import com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

public class k {

    /* renamed from: a  reason: collision with root package name */
    private static volatile k f28219a;

    /* renamed from: b  reason: collision with root package name */
    private BroadcastReceiver f28220b = null;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final ConcurrentHashMap<String, a> f28221c = new ConcurrentHashMap<>();

    /* renamed from: d  reason: collision with root package name */
    private volatile long f28222d = 0;

    public interface a {
        void a();
    }

    private k() {
        if (d.c() || d.d()) {
            this.f28220b = new BroadcastReceiver() {
                public void onReceive(Context context, Intent intent) {
                    PushAutoTrackHelper.onBroadcastReceiver(this, context, intent);
                    k.a().a(context, intent);
                }
            };
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(C0891r.b("029cd>cbcicjchcbckGdehLckefchdechckdkebecebfhcgdcejecdfhcfh"));
            v.a(this.f28220b, intentFilter);
        }
    }

    public static k a() {
        if (f28219a == null) {
            synchronized (k.class) {
                if (f28219a == null) {
                    f28219a = new k();
                }
            }
        }
        return f28219a;
    }

    public void a(String str, a aVar) {
        if (aVar != null && str != null && !this.f28221c.containsKey(str)) {
            this.f28221c.put(str, aVar);
        }
    }

    public void a(Context context, Intent intent) {
        if (intent != null) {
            try {
                if (C0891r.b("029cd[cbcicjchcbckEdehMckefchdechckdkebecebfhcgdcejecdfhcfh").equals(intent.getAction()) && intent.getParcelableExtra(C0891r.b("011dehPefcjcidgddBdJdecj")) != null) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - this.f28222d > 2000) {
                        this.f28222d = currentTimeMillis;
                        l.a().d(2500, new i() {
                            public void a() {
                                if (d.j()) {
                                    DH.requester(MobSDK.getContext()).getMwfoForce(true).request(new DH.DHResponder() {
                                        public void onResponse(DH.DHResponse dHResponse) {
                                            HashMap<String, Object> mwfoForce = dHResponse.getMwfoForce(new int[0]);
                                            if (mwfoForce != null) {
                                                String str = (String) mwfoForce.get("ssmt");
                                                String str2 = (String) mwfoForce.get("bsmt");
                                                NLog instance = MobLog.getInstance();
                                                instance.d("[MCM] cdi " + str + " bcdi " + str2 + " len " + k.a().f28221c.size(), new Object[0]);
                                                if (!TextUtils.isEmpty(str2) || (!TextUtils.isEmpty(str) && !C0891r.b("014MhdcfJdUdg[dZcjef(d3heehehchcbhf").equalsIgnoreCase(str))) {
                                                    TreeMap treeMap = new TreeMap();
                                                    treeMap.put("ssmt", str);
                                                    treeMap.put("bsmt", str2);
                                                    String MD5 = Data.MD5(new JSONObject(treeMap).toString());
                                                    String b11 = ab.a().b(ab.f26995i, (String) null);
                                                    if (b11 == null || !b11.equals(MD5)) {
                                                        for (a a11 : k.this.f28221c.values()) {
                                                            a11.a();
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    });
                                }
                            }
                        });
                    }
                }
            } catch (Throwable th2) {
                MobLog.getInstance().d(th2);
            }
        }
    }
}
