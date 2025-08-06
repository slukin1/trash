package com.huawei.hms.framework.network.grs.f;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.g.b;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class e {

    /* renamed from: a  reason: collision with root package name */
    private static final String f38021a = "e";

    /* renamed from: b  reason: collision with root package name */
    public static final Set<String> f38022b = Collections.unmodifiableSet(new a(16));

    public class a extends HashSet<String> {
        public a(int i11) {
            super(i11);
            add("ser_country");
            add("reg_country");
            add("issue_country");
            add("geo_ip");
        }
    }

    private static String a(Context context, com.huawei.hms.framework.network.grs.e.a aVar, String str, GrsBaseInfo grsBaseInfo, boolean z11) {
        String str2;
        StringBuilder sb2;
        String str3;
        String serCountry = grsBaseInfo.getSerCountry();
        String regCountry = grsBaseInfo.getRegCountry();
        String issueCountry = grsBaseInfo.getIssueCountry();
        for (String str4 : str.split(">")) {
            if (f38022b.contains(str4.trim())) {
                if ("ser_country".equals(str4.trim()) && !TextUtils.isEmpty(serCountry) && !GrsBaseInfo.CountryCodeSource.UNKNOWN.equals(serCountry)) {
                    str2 = f38021a;
                    sb2 = new StringBuilder();
                    str3 = "current route_by is serCountry and routerCountry is: ";
                } else if ("reg_country".equals(str4.trim()) && !TextUtils.isEmpty(regCountry) && !GrsBaseInfo.CountryCodeSource.UNKNOWN.equals(regCountry)) {
                    Logger.i(f38021a, "current route_by is regCountry and routerCountry is: " + regCountry);
                    return regCountry;
                } else if ("issue_country".equals(str4.trim()) && !TextUtils.isEmpty(issueCountry) && !GrsBaseInfo.CountryCodeSource.UNKNOWN.equals(issueCountry)) {
                    Logger.i(f38021a, "current route_by is issueCountry and routerCountry is: " + issueCountry);
                    return issueCountry;
                } else if ("geo_ip".equals(str4.trim())) {
                    serCountry = new b(context, aVar, grsBaseInfo).a(z11);
                    str2 = f38021a;
                    sb2 = new StringBuilder();
                    str3 = "current route_by is geo_ip and routerCountry is: ";
                }
                sb2.append(str3);
                sb2.append(serCountry);
                Logger.i(str2, sb2.toString());
                return serCountry;
            }
        }
        return "";
    }

    public static String b(Context context, com.huawei.hms.framework.network.grs.e.a aVar, String str, GrsBaseInfo grsBaseInfo, boolean z11) {
        if (TextUtils.isEmpty(str)) {
            Logger.w(f38021a, "routeBy must be not empty string or null.");
            return null;
        } else if (!"no_route".equals(str) && !"unconditional".equals(str)) {
            return a(context, aVar, str, grsBaseInfo, z11);
        } else {
            Logger.v(f38021a, "routeBy equals NO_ROUTE_POLICY");
            return "no_route_country";
        }
    }
}
