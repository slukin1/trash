package com.tencent.android.tpush.service.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.tencent.android.tpush.data.RegisterEntity;
import com.tencent.android.tpush.service.cache.CacheManager;
import com.tencent.tpns.dataacquisition.CustomDeviceInfos;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class d {

    /* renamed from: a  reason: collision with root package name */
    private static volatile d f69851a;

    /* renamed from: b  reason: collision with root package name */
    private Context f69852b = null;

    /* renamed from: c  reason: collision with root package name */
    private Map<String, String> f69853c = new HashMap(10);

    /* renamed from: d  reason: collision with root package name */
    private Map<Long, String> f69854d = new HashMap(10);

    private d(Context context) {
        this.f69852b = context.getApplicationContext();
        this.f69854d.put(-1L, "");
    }

    public static d a(Context context) {
        if (f69851a == null) {
            synchronized (d.class) {
                if (f69851a == null) {
                    f69851a = new d(context);
                }
            }
        }
        return f69851a;
    }

    public String a(long j11) {
        if (this.f69854d.containsKey(Long.valueOf(j11))) {
            return this.f69854d.get(Long.valueOf(j11));
        }
        List<String> registerInfos = CacheManager.getRegisterInfos(this.f69852b);
        if (registerInfos != null) {
            for (String next : registerInfos) {
                RegisterEntity registerInfoByPkgName = CacheManager.getRegisterInfoByPkgName(next);
                if (registerInfoByPkgName != null) {
                    this.f69854d.put(Long.valueOf(registerInfoByPkgName.accessId), a(next));
                }
            }
        }
        if (this.f69854d.get(Long.valueOf(j11)) == null) {
            return "";
        }
        return this.f69854d.get(Long.valueOf(j11));
    }

    public String a(String str) {
        if (str == null) {
            return "";
        }
        if (this.f69853c.containsKey(str)) {
            return this.f69853c.get(str);
        }
        List<PackageInfo> appPackages = CustomDeviceInfos.getAppPackages(this.f69852b);
        if (appPackages != null) {
            for (PackageInfo next : appPackages) {
                if (str.equals(next.packageName)) {
                    this.f69853c.put(str, next.versionName);
                    return next.versionName;
                }
            }
        }
        return "";
    }
}
