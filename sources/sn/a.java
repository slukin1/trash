package sn;

import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.core.util.ConfigPreferences;
import com.huobi.login.utils.Region;
import com.iproov.sdk.bridge.OptionsBridge;

public class a {

    /* renamed from: c  reason: collision with root package name */
    public static final a f76544c = new a();

    /* renamed from: a  reason: collision with root package name */
    public String f76545a;

    /* renamed from: b  reason: collision with root package name */
    public String f76546b;

    public static a c() {
        return f76544c;
    }

    public String a() {
        if (StringUtils.q(this.f76545a)) {
            return this.f76545a;
        }
        String d11 = ConfigPreferences.d("user_config", "HB-COUNTRY-ID");
        if (StringUtils.q(d11) && !d11.equalsIgnoreCase(OptionsBridge.NULL_VALUE)) {
            this.f76545a = d11;
        }
        return this.f76545a;
    }

    public String b() {
        if (StringUtils.q(this.f76546b)) {
            return this.f76546b;
        }
        String d11 = ConfigPreferences.d("user_config", "HB-REGION-ID");
        if (StringUtils.q(d11) && !d11.equalsIgnoreCase(OptionsBridge.NULL_VALUE)) {
            this.f76546b = d11;
        }
        return this.f76546b;
    }

    public String d() {
        if (!a().equals("37") || !StringUtils.q(b())) {
            return "";
        }
        try {
            Region findRegionByRegionId = Region.findRegionByRegionId(Integer.valueOf(Integer.parseInt(b())).intValue());
            return findRegionByRegionId != null ? findRegionByRegionId.getRegionName() : "";
        } catch (Exception unused) {
            return "";
        }
    }

    public void e(String str) {
        this.f76545a = str;
        ConfigPreferences.m("user_config", "HB-COUNTRY-ID", str);
    }

    public void f(String str) {
        this.f76546b = str;
        ConfigPreferences.m("user_config", "HB-REGION-ID", str);
    }
}
