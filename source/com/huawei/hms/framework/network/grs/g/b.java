package com.huawei.hms.framework.network.grs.g;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.e.a;
import com.huawei.hms.framework.network.grs.g.j.c;
import com.huawei.hms.framework.network.grs.h.e;
import org.json.JSONException;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private final Context f38031a;

    /* renamed from: b  reason: collision with root package name */
    private final GrsBaseInfo f38032b;

    /* renamed from: c  reason: collision with root package name */
    private final a f38033c;

    public b(Context context, a aVar, GrsBaseInfo grsBaseInfo) {
        this.f38031a = context;
        this.f38032b = grsBaseInfo;
        this.f38033c = aVar;
    }

    public String a(boolean z11) {
        String str = com.huawei.hms.framework.network.grs.a.a(this.f38033c.a().a("geoipCountryCode", ""), "geoip.countrycode").get("ROOT");
        Logger.i("GeoipCountry", "geoIpCountry is: " + str);
        String a11 = this.f38033c.a().a("geoipCountryCodetime", "0");
        long j11 = 0;
        if (!TextUtils.isEmpty(a11) && a11.matches("\\d+")) {
            try {
                j11 = Long.parseLong(a11);
            } catch (NumberFormatException e11) {
                Logger.w("GeoipCountry", "convert urlParamKey from String to Long catch NumberFormatException.", (Throwable) e11);
            }
        }
        if (TextUtils.isEmpty(str) || e.a(Long.valueOf(j11))) {
            c cVar = new c(this.f38032b, this.f38031a);
            cVar.a("geoip.countrycode");
            com.huawei.hms.framework.network.grs.e.c c11 = this.f38033c.c();
            if (c11 != null) {
                String str2 = null;
                try {
                    str2 = h.a(c11.a("services", ""), cVar.c());
                } catch (JSONException e12) {
                    Logger.w("GeoipCountry", "getGeoipCountry merge services occure jsonException. %s", StringUtils.anonymizeMessage(e12.getMessage()));
                }
                if (!TextUtils.isEmpty(str2)) {
                    c11.b("services", str2);
                }
            }
            if (z11) {
                d a12 = this.f38033c.b().a(cVar, "geoip.countrycode", c11, -1);
                if (a12 != null) {
                    str = com.huawei.hms.framework.network.grs.a.a(a12.j(), "geoip.countrycode").get("ROOT");
                }
                Logger.i("GeoipCountry", "sync request to query geoip.countrycode is:" + str);
            } else {
                Logger.i("GeoipCountry", "async request to query geoip.countrycode");
                this.f38033c.b().a(cVar, (com.huawei.hms.framework.network.grs.b) null, "geoip.countrycode", c11, -1);
            }
        }
        return str;
    }
}
