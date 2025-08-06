package com.tencent.android.tpush.a;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import com.hbg.lib.network.pro.core.util.Period;
import com.tencent.android.tpush.XGPushProvider;
import com.tencent.android.tpush.common.j;
import com.tencent.android.tpush.logging.TLogger;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static volatile a f68098a;

    /* renamed from: b  reason: collision with root package name */
    private Context f68099b = null;

    /* renamed from: c  reason: collision with root package name */
    private PackageManager f68100c = null;

    /* renamed from: d  reason: collision with root package name */
    private HashMap<String, b> f68101d = new HashMap<>();

    /* renamed from: e  reason: collision with root package name */
    private Map<String, Long> f68102e = new HashMap();

    private a(Context context) {
        this.f68099b = context;
        this.f68100c = context.getPackageManager();
    }

    public static a a(Context context) {
        if (f68098a == null) {
            synchronized (a.class) {
                if (f68098a == null) {
                    f68098a = new a(context);
                }
            }
        }
        return f68098a;
    }

    private boolean d() {
        String str = com.tencent.android.tpush.service.a.a.a(this.f68099b).I;
        String str2 = Build.MANUFACTURER;
        TLogger.d("IPCManager", "wakeCtr:" + str + ",mf:" + str2);
        if (!j.b(str) || !j.b(str2)) {
            for (String lowerCase : str.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
                if (lowerCase.toLowerCase().equals(str2.toLowerCase())) {
                    return true;
                }
            }
        }
        return false;
    }

    public void b() {
        TLogger.d("IPCManager", "action - initProviders");
        List<ProviderInfo> queryContentProviders = this.f68100c.queryContentProviders((String) null, 0, 0);
        List<String> c11 = c();
        if (queryContentProviders != null && c11 != null) {
            for (ProviderInfo next : queryContentProviders) {
                if (c11.contains(next.packageName) && next.exported) {
                    b bVar = this.f68101d.get(next.packageName);
                    if (bVar == null) {
                        bVar = new b();
                    }
                    bVar.a(next.packageName);
                    if (next.name.equals(XGPushProvider.class.getName())) {
                        bVar.a(next);
                    } else {
                        bVar.b(next);
                    }
                    this.f68101d.put(next.packageName, bVar);
                }
            }
        }
    }

    public List<String> c() {
        TLogger.d("IPCManager", "action - getAllLocalXGApps");
        ArrayList arrayList = new ArrayList();
        List<ResolveInfo> queryBroadcastReceivers = this.f68100c.queryBroadcastReceivers(new Intent(com.tencent.android.tpush.common.Constants.ACTION_SDK_INSTALL), 0);
        if (queryBroadcastReceivers != null) {
            for (ResolveInfo resolveInfo : queryBroadcastReceivers) {
                arrayList.add(resolveInfo.resolvePackageName);
            }
        }
        Map<String, ProviderInfo> a11 = com.tencent.android.tpush.a.a(this.f68099b);
        if (a11 != null) {
            for (Map.Entry next : a11.entrySet()) {
                if (!arrayList.contains(next.getKey())) {
                    arrayList.add(next.getKey());
                }
            }
        }
        return arrayList;
    }

    public void a() {
        try {
            b();
        } catch (Throwable th2) {
            TLogger.e("IPCManager", ZendeskBlipsProvider.ACTION_CORE_INIT, th2);
        }
    }

    public void a(String str) {
        try {
            if (d() && !this.f68099b.getPackageName().equals(str)) {
                TLogger.d("IPCManager", "tryWakeUpApp packageName:" + str);
                c(str);
            }
        } catch (Throwable th2) {
            TLogger.e("IPCManager", "tryWakeUpApp", th2);
        }
    }

    private void c(String str) {
        Long l11 = this.f68102e.get(str);
        if (l11 == null || System.currentTimeMillis() <= l11.longValue()) {
            b b11 = b(str);
            TLogger.d("IPCManager", "tryWakeUpApp ipcAppInfo:" + b11);
            if (b11 != null) {
                ArrayList<ProviderInfo> a11 = b11.a();
                TLogger.d("IPCManager", "tryWakeUpApp providerInfoList:" + a11);
                if (a11 != null) {
                    for (ProviderInfo next : a11) {
                        if (next.exported) {
                            String str2 = next.authority;
                            Uri parse = Uri.parse("content://" + str2);
                            TLogger.d("IPCManager", "tryWakeUpApp uri:" + parse);
                            this.f68099b.getContentResolver().getType(parse);
                        }
                    }
                }
            }
            this.f68102e.put(str, Long.valueOf(System.currentTimeMillis() + Period.MIN60_MILLS));
        }
    }

    public b b(String str) {
        if (!this.f68101d.containsKey(str)) {
            a();
        }
        return this.f68101d.get(str);
    }
}
