package com.xiaomi.push;

import android.text.TextUtils;
import com.google.android.gms.fido.u2f.api.common.ClientData;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.dq;
import com.xiaomi.push.service.am;
import java.util.HashMap;

class er {
    public static void a(am.b bVar, String str, fb fbVar) {
        String str2;
        dq.c cVar = new dq.c();
        if (!TextUtils.isEmpty(bVar.f52466c)) {
            cVar.a(bVar.f52466c);
        }
        if (!TextUtils.isEmpty(bVar.f52468e)) {
            cVar.d(bVar.f52468e);
        }
        if (!TextUtils.isEmpty(bVar.f52469f)) {
            cVar.e(bVar.f52469f);
        }
        cVar.b(bVar.f3345a ? "1" : "0");
        if (!TextUtils.isEmpty(bVar.f52467d)) {
            cVar.c(bVar.f52467d);
        } else {
            cVar.c("XIAOMI-SASL");
        }
        es esVar = new es();
        esVar.c(bVar.f3346b);
        esVar.a(Integer.parseInt(bVar.f52470g));
        esVar.b(bVar.f3343a);
        esVar.a("BIND", (String) null);
        esVar.a(esVar.e());
        b.a("[Slim]: bind id=" + esVar.e());
        HashMap hashMap = new HashMap();
        hashMap.put(ClientData.KEY_CHALLENGE, str);
        hashMap.put("token", bVar.f52466c);
        hashMap.put("chid", bVar.f52470g);
        hashMap.put("from", bVar.f3346b);
        hashMap.put("id", esVar.e());
        hashMap.put("to", "xiaomi.com");
        if (bVar.f3345a) {
            hashMap.put("kick", "1");
        } else {
            hashMap.put("kick", "0");
        }
        if (!TextUtils.isEmpty(bVar.f52468e)) {
            hashMap.put("client_attrs", bVar.f52468e);
        } else {
            hashMap.put("client_attrs", "");
        }
        if (!TextUtils.isEmpty(bVar.f52469f)) {
            hashMap.put("cloud_attrs", bVar.f52469f);
        } else {
            hashMap.put("cloud_attrs", "");
        }
        if (bVar.f52467d.equals("XIAOMI-PASS") || bVar.f52467d.equals("XMPUSH-PASS")) {
            str2 = ba.a(bVar.f52467d, (String) null, hashMap, bVar.f52471h);
        } else {
            bVar.f52467d.equals("XIAOMI-SASL");
            str2 = null;
        }
        cVar.f(str2);
        esVar.a(cVar.a(), (String) null);
        fbVar.b(esVar);
    }

    public static void a(String str, String str2, fb fbVar) {
        es esVar = new es();
        esVar.c(str2);
        esVar.a(Integer.parseInt(str));
        esVar.a("UBND", (String) null);
        fbVar.b(esVar);
    }
}
