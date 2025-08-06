package com.xiaomi.push.service;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import com.adjust.sdk.Constants;
import com.hbg.lib.network.pro.core.util.Period;
import com.sumsub.sentry.q;
import com.xiaomi.push.av;
import com.xiaomi.push.cd;
import com.xiaomi.push.cg;
import com.xiaomi.push.ch;
import com.xiaomi.push.dp;
import com.xiaomi.push.dq;
import com.xiaomi.push.ej;
import com.xiaomi.push.ep;
import com.xiaomi.push.eq;
import com.xiaomi.push.fb;
import com.xiaomi.push.fy;
import com.xiaomi.push.j;
import com.xiaomi.push.s;
import com.xiaomi.push.service.ax;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

public class ao extends ax.a implements ch.a {

    /* renamed from: a  reason: collision with root package name */
    private long f52510a;

    /* renamed from: a  reason: collision with other field name */
    private XMPushService f3352a;

    public static class a implements ch.b {
        public String a(String str) {
            Uri.Builder buildUpon = Uri.parse(str).buildUpon();
            buildUpon.appendQueryParameter("sdkver", String.valueOf(48));
            buildUpon.appendQueryParameter("osver", String.valueOf(Build.VERSION.SDK_INT));
            buildUpon.appendQueryParameter(q.f30469g, fy.a(j.e()));
            buildUpon.appendQueryParameter("mi", String.valueOf(s.a()));
            String builder = buildUpon.toString();
            com.xiaomi.channel.commonutils.logger.b.c("fetch bucket from : " + builder);
            URL url = new URL(builder);
            int port = url.getPort() == -1 ? 80 : url.getPort();
            try {
                long currentTimeMillis = System.currentTimeMillis();
                String a11 = av.a(s.a(), url);
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                eq.a(url.getHost() + ":" + port, (int) currentTimeMillis2, (Exception) null);
                return a11;
            } catch (IOException e11) {
                eq.a(url.getHost() + ":" + port, -1, e11);
                throw e11;
            }
        }
    }

    public static class b extends ch {
        public b(Context context, cg cgVar, ch.b bVar, String str) {
            super(context, cgVar, bVar, str);
        }

        public String a(ArrayList<String> arrayList, String str, String str2, boolean z11) {
            try {
                if (ep.a().a()) {
                    str2 = ax.a();
                }
                return super.a(arrayList, str, str2, z11);
            } catch (IOException e11) {
                eq.a(0, ej.GSLB_ERR.a(), 1, (String) null, av.b(ch.f51493a) ? 1 : 0);
                throw e11;
            }
        }
    }

    public ao(XMPushService xMPushService) {
        this.f3352a = xMPushService;
    }

    public static void a(XMPushService xMPushService) {
        ao aoVar = new ao(xMPushService);
        ax.a().a((ax.a) aoVar);
        synchronized (ch.class) {
            ch.a((ch.a) aoVar);
            ch.a(xMPushService, (cg) null, new a(), "0", Constants.PUSH, "2.2");
        }
    }

    public void a(dp.a aVar) {
    }

    public void a(dq.b bVar) {
        cd b11;
        if (bVar.b() && bVar.a() && System.currentTimeMillis() - this.f52510a > Period.MIN60_MILLS) {
            com.xiaomi.channel.commonutils.logger.b.a("fetch bucket :" + bVar.a());
            this.f52510a = System.currentTimeMillis();
            ch a11 = ch.a();
            a11.a();
            a11.b();
            fb a12 = this.f3352a.a();
            if (a12 != null && (b11 = a11.b(a12.a().c())) != null) {
                ArrayList a13 = b11.a();
                boolean z11 = true;
                Iterator it2 = a13.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        if (((String) it2.next()).equals(a12.a())) {
                            z11 = false;
                            break;
                        }
                    } else {
                        break;
                    }
                }
                if (z11 && !a13.isEmpty()) {
                    com.xiaomi.channel.commonutils.logger.b.a("bucket changed, force reconnect");
                    this.f3352a.a(0, (Exception) null);
                    this.f3352a.a(false);
                }
            }
        }
    }

    public ch a(Context context, cg cgVar, ch.b bVar, String str) {
        return new b(context, cgVar, bVar, str);
    }
}
