package fv;

import android.app.Activity;
import com.huobi.woodpecker.core.ActionType;
import com.huobi.woodpecker.model.udf.ActionRecord;
import com.huobi.woodpecker.monitor.base.BaseLifecycleMonitor;
import com.huobi.woodpecker.utils.RecordUtil;
import wu.c;

public class a extends BaseLifecycleMonitor {

    /* renamed from: c  reason: collision with root package name */
    public static final String f22751c = a.class.getSimpleName();

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final a f22752a = new a();
    }

    public static a h() {
        return b.f22752a;
    }

    public final void i(String str) {
        ActionRecord actionRecord = new ActionRecord();
        actionRecord.setAction(ActionType.APP_PAGE_VIEW);
        ((ActionRecord.UdfRecordData) actionRecord.getData()).getMap().put("title", str);
        RecordUtil.a(actionRecord);
        c.b(actionRecord);
    }

    public void onActivityResumed(Activity activity) {
        if (activity != null) {
            i(activity.getClass().getName());
        }
    }

    public a() {
    }
}
