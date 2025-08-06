package com.xiaomi.push.service;

import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.gf;
import com.xiaomi.push.gg;
import com.xiaomi.push.gk;
import com.xiaomi.push.gt;
import com.xiaomi.push.hc;
import com.xiaomi.push.hf;
import com.xiaomi.push.hq;
import com.xiaomi.push.service.XMPushService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class o implements gf {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final XMPushService f52575a;

    public o(XMPushService xMPushService) {
        this.f52575a = xMPushService;
    }

    public void a(List<gk> list, String str, String str2) {
        final String str3 = str;
        final List<gk> list2 = list;
        final String str4 = str2;
        this.f52575a.a((XMPushService.j) new XMPushService.j(4) {
            public String a() {
                return "Send tiny data.";
            }

            /* renamed from: a  reason: collision with other method in class */
            public void m3036a() {
                String a11 = o.this.a(str3);
                ArrayList<hf> a12 = az.a(list2, str3, a11, 32768);
                if (a12 != null) {
                    Iterator<hf> it2 = a12.iterator();
                    while (it2.hasNext()) {
                        hf next = it2.next();
                        next.a("uploadWay", "longXMPushService");
                        hc a13 = w.a(str3, a11, next, gg.Notification);
                        if (!TextUtils.isEmpty(str4) && !TextUtils.equals(str3, str4)) {
                            if (a13.a() == null) {
                                gt gtVar = new gt();
                                gtVar.a("-1");
                                a13.a(gtVar);
                            }
                            a13.a().b("ext_traffic_source_pkg", str4);
                        }
                        o.this.f52575a.a(str3, hq.a(a13), true);
                    }
                    return;
                }
                b.d("TinyData LongConnUploader.upload Get a null XmPushActionNotification list when TinyDataHelper.pack() in XMPushService.");
            }
        });
    }

    /* access modifiers changed from: private */
    public String a(String str) {
        if ("com.xiaomi.xmsf".equals(str)) {
            return "1000271";
        }
        return this.f52575a.getSharedPreferences("pref_registered_pkg_names", 0).getString(str, (String) null);
    }
}
