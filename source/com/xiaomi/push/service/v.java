package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.push.hc;
import com.xiaomi.push.hf;
import java.util.Map;

public class v {

    /* renamed from: a  reason: collision with root package name */
    private static a f52603a;

    /* renamed from: a  reason: collision with other field name */
    private static b f3430a;

    public interface a {
        Map<String, String> a(Context context, hc hcVar);

        /* renamed from: a  reason: collision with other method in class */
        void m3055a(Context context, hc hcVar);

        void a(Context context, hc hcVar, hf hfVar);

        void a(String str, byte[] bArr, long j11);

        boolean a(Context context, hc hcVar, boolean z11);
    }

    public interface b {
        void a(hc hcVar);

        void a(String str);

        /* renamed from: a  reason: collision with other method in class */
        boolean m3056a(hc hcVar);
    }

    public static void a(Context context, hc hcVar, hf hfVar) {
        a aVar = f52603a;
        if (aVar == null) {
            com.xiaomi.channel.commonutils.logger.b.d("The Listener of EventProcessor must be set. Please check extension plugin initialization.");
        } else {
            aVar.a(context, hcVar, hfVar);
        }
    }

    public static boolean a(Context context, hc hcVar, boolean z11) {
        a aVar = f52603a;
        if (aVar != null && hcVar != null) {
            return aVar.a(context, hcVar, z11);
        }
        com.xiaomi.channel.commonutils.logger.b.a("pepa judement listener or container is null");
        return false;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m3053a(Context context, hc hcVar) {
        a aVar = f52603a;
        if (aVar == null || hcVar == null) {
            com.xiaomi.channel.commonutils.logger.b.a("handle msg wrong");
        } else {
            aVar.a(context, hcVar);
        }
    }

    public static void a(String str, byte[] bArr, long j11) {
        a aVar = f52603a;
        if (aVar == null || bArr == null) {
            com.xiaomi.channel.commonutils.logger.b.a("handle send msg wrong");
        } else {
            aVar.a(str, bArr, j11);
        }
    }

    public static Map<String, String> a(Context context, hc hcVar) {
        a aVar = f52603a;
        if (aVar != null && hcVar != null) {
            return aVar.a(context, hcVar);
        }
        com.xiaomi.channel.commonutils.logger.b.a("pepa listener or container is null");
        return null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m3054a(hc hcVar) {
        b bVar = f3430a;
        if (bVar != null && hcVar != null) {
            return bVar.a(hcVar);
        }
        com.xiaomi.channel.commonutils.logger.b.a("pepa handleReceiveMessage is null");
        return false;
    }

    public static void a(hc hcVar) {
        b bVar = f3430a;
        if (bVar == null || hcVar == null) {
            com.xiaomi.channel.commonutils.logger.b.a("pepa clearMessage is null");
        } else {
            bVar.a(hcVar);
        }
    }

    public static void a(String str) {
        b bVar = f3430a;
        if (bVar == null || str == null) {
            com.xiaomi.channel.commonutils.logger.b.a("pepa clearMessage is null");
        } else {
            bVar.a(str);
        }
    }
}
