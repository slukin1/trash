package hs;

import com.huobi.statistics.hbg.bean.AnalyticsClickItem;
import java.util.HashMap;
import java.util.Map;

public final class a {

    /* renamed from: b  reason: collision with root package name */
    public static final a f84218b = new a();

    /* renamed from: a  reason: collision with root package name */
    public Map<String, AnalyticsClickItem> f84219a = new HashMap();

    public static a b() {
        return f84218b;
    }

    public Map<String, AnalyticsClickItem> a() {
        return this.f84219a;
    }

    public void c(String str, Map<String, Object> map) {
        is.a.i(str, map);
    }
}
