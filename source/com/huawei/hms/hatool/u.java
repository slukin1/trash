package com.huawei.hms.hatool;

import android.text.TextUtils;
import com.hbg.lib.network.pro.core.util.Period;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class u {

    /* renamed from: a  reason: collision with root package name */
    private List<b1> f38285a;

    /* renamed from: b  reason: collision with root package name */
    private String f38286b;

    /* renamed from: c  reason: collision with root package name */
    private String f38287c;

    /* renamed from: d  reason: collision with root package name */
    private String f38288d;

    public u(List<b1> list, String str, String str2, String str3) {
        this.f38285a = list;
        this.f38286b = str;
        this.f38287c = str2;
        this.f38288d = str3;
    }

    private void a(List<b1> list, String str, String str2) {
        if (!list.isEmpty()) {
            int size = (list.size() / 500) + 1;
            for (int i11 = 0; i11 < size; i11++) {
                int i12 = i11 * 500;
                List<b1> subList = list.subList(i12, Math.min(list.size(), i12 + 500));
                String replace = UUID.randomUUID().toString().replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "");
                long currentTimeMillis = System.currentTimeMillis();
                long b11 = ((long) a1.b(str2, str)) * Period.DAY_MILLS;
                ArrayList arrayList = new ArrayList();
                for (b1 next : subList) {
                    if (!c0.a(next.b(), currentTimeMillis, b11)) {
                        arrayList.add(next);
                    }
                }
                if (arrayList.size() > 0) {
                    new l0(str2, str, this.f38288d, arrayList, replace).a();
                } else {
                    v.e("hmsSdk", "No data to report handler");
                }
            }
        }
    }

    public void a() {
        if ("_default_config_tag".equals(this.f38287c)) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            ArrayList arrayList4 = new ArrayList();
            for (b1 next : this.f38285a) {
                String c11 = next.c();
                if (TextUtils.isEmpty(c11) || "oper".equals(c11)) {
                    arrayList4.add(next);
                } else if ("maint".equals(c11)) {
                    arrayList.add(next);
                } else if ("preins".equals(c11)) {
                    arrayList2.add(next);
                } else if ("diffprivacy".equals(c11)) {
                    arrayList3.add(next);
                }
            }
            a(arrayList4, "oper", "_default_config_tag");
            a(arrayList, "maint", "_default_config_tag");
            a(arrayList2, "preins", "_default_config_tag");
            a(arrayList3, "diffprivacy", "_default_config_tag");
            return;
        }
        a(this.f38285a, this.f38287c, this.f38286b);
    }
}
