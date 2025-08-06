package com.huobi.woodpecker.monitor;

import android.content.Context;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.huobi.woodpecker.core.ActionType;
import com.huobi.woodpecker.model.udf.ActionRecord;
import com.huobi.woodpecker.utils.ContextUtil;
import com.huobi.woodpecker.utils.RecordUtil;
import com.huobi.woodpecker.utils.StringUtils;
import kv.b;
import kv.e;
import wu.c;

public class NewUserMonitor implements ActionType.a {

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final NewUserMonitor f21148a = new NewUserMonitor();
    }

    public static NewUserMonitor c() {
        return a.f21148a;
    }

    public void a(boolean z11) {
        e.k("BMonitor", "onEnableChange by NewUserMonitor isEnable:" + z11);
        if (z11) {
            b();
        }
    }

    public void b() {
        Context g11 = ContextUtil.g();
        if (g11 != null && b.b(g11, "isNewUser", true) && StringUtils.b(g11.getSharedPreferences("huobi_vulcan_security_store", 0).getString("hb_vtoken", (String) null))) {
            b.e(g11, "isNewUser", false);
            ActionRecord actionRecord = new ActionRecord();
            actionRecord.setAction(ActionType.APP_NEW_USER);
            ((ActionRecord.UdfRecordData) actionRecord.getData()).getMap().put(CrashHianalyticsData.TIME, Long.valueOf(System.currentTimeMillis()));
            RecordUtil.a(actionRecord);
            c.b(actionRecord);
            e.b("sss--->" + actionRecord.toJsonString());
        }
    }
}
