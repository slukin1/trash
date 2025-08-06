package com.tencent.thumbplayer.tcmedia.tplayer.a;

import android.content.Context;
import com.huochat.community.base.CommunityConstants;
import com.tencent.thumbplayer.tcmedia.api.TPCommonEnum;
import com.tencent.thumbplayer.tcmedia.api.capability.TPCapability;
import com.tencent.thumbplayer.tcmedia.config.TPPlayerConfig;
import com.tencent.thumbplayer.tcmedia.core.common.TPSystemInfo;
import com.tencent.thumbplayer.tcmedia.tplayer.a.b.a;
import com.tencent.thumbplayer.tcmedia.utils.h;
import com.tencent.thumbplayer.tcmedia.utils.i;
import java.util.HashMap;
import java.util.Map;

public class j implements i.b {

    /* renamed from: a  reason: collision with root package name */
    private static final String f49532a = String.format("android %s", new Object[]{TPSystemInfo.getOsVersion()});

    /* renamed from: c  reason: collision with root package name */
    private static final Map<Integer, Integer> f49533c;

    /* renamed from: d  reason: collision with root package name */
    private static final Map<Integer, Integer> f49534d;

    /* renamed from: b  reason: collision with root package name */
    private Context f49535b;

    static {
        HashMap hashMap = new HashMap();
        f49533c = hashMap;
        hashMap.put(0, -1);
        hashMap.put(1, 0);
        hashMap.put(2, 3);
        hashMap.put(3, 3);
        HashMap hashMap2 = new HashMap();
        f49534d = hashMap2;
        hashMap2.put(-1, -1);
        hashMap2.put(0, 32);
        hashMap2.put(2, 4);
    }

    public j(Context context) {
        this.f49535b = context;
        i.a().a((i.b) this);
    }

    private int a() {
        int i11 = 0;
        for (int a11 : TPCapability.getDRMCapabilities()) {
            i11 |= a(a11);
        }
        return i11;
    }

    public static int a(@TPCommonEnum.TP_DRM_TYPE int i11) {
        Integer num = f49534d.get(Integer.valueOf(i11));
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }

    public static int b(int i11) {
        Integer num = f49533c.get(Integer.valueOf(i11));
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }

    public void a(int i11, int i12, int i13, int i14) {
        h.b(this.f49535b);
    }

    public void a(a aVar) {
        aVar.b(TPPlayerConfig.getGuid());
        aVar.b(0);
        aVar.c(0);
        aVar.d(h.a(this.f49535b));
        aVar.c(TPSystemInfo.getDeviceName());
        aVar.d(f49532a);
        aVar.e(this.f49535b.getPackageName());
        aVar.g(TPPlayerConfig.getAppVersionName(this.f49535b));
        aVar.h(CommunityConstants.COMMUNITY_SDK_VERSION);
        aVar.f(TPPlayerConfig.VERSION);
        aVar.m(TPPlayerConfig.getPlatform());
        aVar.a(0);
        aVar.n(a());
    }

    public void b(a aVar) {
        aVar.d(h.a(this.f49535b));
    }
}
