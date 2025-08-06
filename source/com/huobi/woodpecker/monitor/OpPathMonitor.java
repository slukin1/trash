package com.huobi.woodpecker.monitor;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huobi.woodpecker.model.OpPath;
import java.util.ArrayList;
import java.util.List;
import kv.e;
import org.json.JSONArray;

public class OpPathMonitor {

    /* renamed from: a  reason: collision with root package name */
    public List<OpPath> f21149a = new ArrayList(1024);

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static OpPathMonitor f21150a = new OpPathMonitor();
    }

    public static OpPathMonitor c() {
        return a.f21150a;
    }

    public void a(String str, String str2) {
        synchronized (this) {
            if (e.l()) {
                e.c("OpPathMonitor", "add() called with: to = [" + str + "], option = [" + str2 + "]");
            }
            this.f21149a.add(new OpPath(str, str2));
        }
    }

    public void b(String str, String str2, String str3) {
        synchronized (this) {
            if (e.l()) {
                e.c("OpPathMonitor", "add() called with: toFragment = [" + str + "], toActivity = [" + str2 + "], option = [" + str3 + "]");
            }
            this.f21149a.add(new OpPath(str + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + str2, str3));
        }
    }

    public String d() {
        return e(4);
    }

    public String e(int i11) {
        synchronized (this) {
            if (e.l()) {
                e.c("OpPathMonitor", "obtain() called with: index = [" + i11 + "]");
            }
            if (this.f21149a.isEmpty()) {
                return "";
            }
            int size = this.f21149a.size();
            if (i11 < 1 || i11 > size) {
                i11 = size;
            }
            ArrayList arrayList = new ArrayList();
            for (int i12 = size - i11; i12 < size; i12++) {
                arrayList.add(this.f21149a.get(i12));
            }
            String jSONArray = f(arrayList).toString();
            return jSONArray;
        }
    }

    public JSONArray f(List<OpPath> list) {
        JSONArray jSONArray = new JSONArray();
        if (list == null) {
            return jSONArray;
        }
        for (int i11 = 0; i11 < list.size(); i11++) {
            jSONArray.put(list.get(i11).toJsonObject());
        }
        return jSONArray;
    }
}
