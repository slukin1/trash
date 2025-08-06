package com.huobi.index.bean;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.util.AppLanguageHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataAPI;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import org.json.JSONObject;
import tg.r;

public class IndexInformationRequestData {

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, Object> f73193a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, Object> f73194b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    public int f73195c = -1;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static IndexInformationRequestData f73196a = new IndexInformationRequestData();
    }

    public static IndexInformationRequestData b() {
        return a.f73196a;
    }

    public HashMap<String, Object> a(int i11, int i12, long j11, List<FeedRequestItems> list, int i13) {
        this.f73193a.clear();
        this.f73194b.clear();
        this.f73193a.put("realtimeFeastures", this.f73194b);
        int i14 = 2;
        if ((i11 == 2 || i11 == 5) && j11 > 0 && i12 == 2) {
            this.f73193a.put("lastIssueTime", Long.valueOf(j11));
        }
        if (i11 == 3 && list != null) {
            this.f73193a.put(FirebaseAnalytics.Param.ITEMS, list);
        }
        JSONObject presetProperties = SensorsDataAPI.sharedInstance().getPresetProperties();
        if (presetProperties != null) {
            Iterator<String> keys = presetProperties.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                this.f73194b.put(next.replaceAll("\\$", ""), presetProperties.opt(next));
            }
        }
        this.f73194b.put("frompage", "huobi_pro");
        this.f73194b.put("orgpage", "homepage");
        this.f73193a.put("user_id", r.x().J());
        this.f73193a.put("bizType", String.valueOf(i11));
        HashMap<String, Object> hashMap = this.f73193a;
        Object obj = "";
        if (this.f73194b.get("device_id") != null) {
            obj = this.f73194b.get("device_id");
        }
        hashMap.put("device_id", obj);
        this.f73193a.put("requestId", UUID.randomUUID().toString());
        HashMap<String, Object> hashMap2 = this.f73193a;
        if (AppLanguageHelper.getInstance().isChineseLanguage()) {
            i14 = 1;
        } else if (!AppLanguageHelper.getInstance().isHkChineseLanguage()) {
            i14 = 3;
        }
        hashMap2.put("language", Integer.valueOf(i14));
        this.f73193a.put("is_login", Boolean.valueOf(r.x().F0()));
        this.f73193a.put("requestNum", 10);
        this.f73193a.put("actionType", Integer.valueOf(i12));
        this.f73193a.put("pageNum", Integer.valueOf(Math.max(i13, 0)));
        this.f73193a.put(FirebaseAnalytics.Param.CURRENCY, BaseModuleConfig.a().M());
        return this.f73193a;
    }
}
